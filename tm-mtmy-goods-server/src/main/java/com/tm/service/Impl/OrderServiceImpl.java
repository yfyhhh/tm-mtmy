package com.tm.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tm.entity.TmMtmyProvince;
import com.tm.entity.UserAddr;
import com.tm.entity.bo.OrderSubBO;
import com.tm.entity.dto.CreateOrderDTO;
import com.tm.entity.dto.CreateOrderListDTO;
import com.tm.entity.vo.UserAddrVo;
import com.tm.mapper.OrderMapper;
import com.tm.result.Result;
import com.tm.result.ResultCodeEnum;
import com.tm.service.OrderService;
import com.tm.utils.IdWorker;
import javafx.concurrent.Worker;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查询收货地址列表
     * @param userId
     * @return
     */
    @Override
    public Result addrList(Long userId) {
        List<UserAddrVo> userAddrVos = orderMapper.addrList(userId);
        // 新建一个表，将地址列表数据直接存入数据库，为了避免多重循环
        userAddrVos.forEach(a->{
            a.setProvinceName(orderMapper.queryAddressNameById(a.getProvinceId()));
            a.setCityName(orderMapper.queryAddressNameById(a.getCityId()));
            a.setAreaName(orderMapper.queryAddressNameById(a.getAreaId()));
        });
        return Result.SUCCESS(userAddrVos);
    }

    /**
     * 查询所有地址
     * @return
     */
    @Override
    public Result allAddr() {
        List<TmMtmyProvince> maps = null;
        try {
            File file = ResourceUtils.getFile("classpath:city.json");
            String s = FileUtils.readFileToString(file, "UTF-8");
            maps = JSON.parseArray(s, TmMtmyProvince.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.SUCCESS(maps);
    }

    /**
     * 新增收货地址
     * @param userAddr
     * @return
     */
    @Override
    public Result addUserAddr(UserAddr userAddr) {
       Integer integer = orderMapper.addUserAddr(userAddr);
       if (integer != 1){
           return Result.FAIL(990,"新增失败");
       }
        return Result.SUCCESS(ResultCodeEnum.SUCCESS);
    }

    /**
     * 获取创建订单的唯一标识
     * @return
     */
    @Override
    public Result getOrderFlag() {
        // 雪花算法+UUID
        IdWorker worker = new IdWorker(1, 1, 1);
        long l = worker.nextId();
        String s = UUID.randomUUID().toString();
        String a = s + l;
        // 将其存入redis中
        redisTemplate.opsForValue().set(a,"exist");
        return Result.SUCCESS(a);
    }

    /**
     * 创建订单
     * @param createOrderDTO
     * @return
     */
    @Override
    public Result createOrder(CreateOrderDTO createOrderDTO) {
        // 获取订单的唯一标识看是否第一次请求下单
        String orderFlag = createOrderDTO.getOrderFlag();
        // 到redis中查，看标识再操作
        Object o = redisTemplate.opsForValue().get(orderFlag);
        if (o != null){
            // 定一个总价格
            BigDecimal bigDecimal = new BigDecimal(0);
            // 有唯一标识，说明是第一次请求
            // 创建订单号
            String s = UUID.randomUUID().toString().replaceAll("-", "");
            String orderId = s + s;
            // 对前端传过来的商品进行价格计算
            List<CreateOrderListDTO> createOrderListDTOS = createOrderDTO.getCreateOrderListDTOS();
            // 先将订单存入数据库
            orderMapper.addOrder(createOrderDTO.getUserId(),orderId);

            String goodsName = "";

            for (CreateOrderListDTO a : createOrderListDTOS) {
                OrderSubBO orderSubBO = orderMapper.queryGoodsDetailById(a.getGoodsId(),a.getSpecsId());
                // 算折扣后的价格
                orderSubBO.setCount(a.getCount());
                // 原价 * 数量 = 成交价格
                orderSubBO.setBuyDealPrice(orderSubBO.getBuyCostPrice().multiply(new BigDecimal(a.getCount())));
                orderSubBO.setGoodsId(a.getGoodsId());
                orderSubBO.setSgmId(a.getSpecsId());
                bigDecimal = orderSubBO.getBuyDealPrice().add(bigDecimal);

                // 将订单存入数据库
                try {
                    orderMapper.addOrderSub(orderSubBO);
                    // 删除购物车数据
                    redisTemplate.opsForHash().delete("cart_" + createOrderDTO.getUserId(),orderSubBO.getSgmId());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (createOrderListDTOS.size() > 1){
                    goodsName = orderSubBO.getGoodsDealName() + "等" + createOrderListDTOS.size() + "件商品";
                }else {
                    goodsName = orderSubBO.getGoodsDealName();
                }
            }
            // bigDecimal就是订单总价格
            orderMapper.insertOrderPrice(orderId,bigDecimal);
            // 延时30分钟，将当前订单进行状态修改
            updateOrder(orderId);

            // 删除redis中的唯一标识
            redisTemplate.delete(orderFlag);

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("orderId",orderId);
            jsonObject.put("price",bigDecimal);
            jsonObject.put("goodsName",goodsName);
            return Result.SUCCESS(jsonObject);
        }else {
            // 没有标识，说明不是第一次请求，直接返回
            return Result.FAIL(777,"已下单成功，请勿重复下单");
        }
    }

    @Async
    public void updateOrder(String orderId){
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Integer flag = orderMapper.getOrderFlag(orderId);
                if (flag == 0){
                    orderMapper.updateOrder(orderId);
                }

                timer.cancel();
            }
        };
        timer.schedule(timerTask,1800000);
    }
}
