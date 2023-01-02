package com.tm.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.tm.entity.bo.GoodsBO;
import com.tm.entity.dto.AddCartDTO;
import com.tm.mapper.CartMapper;
import com.tm.mapper.GoodsMapper;
import com.tm.result.Result;
import com.tm.result.ResultCodeEnum;
import com.tm.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 添加购物车
     * @param addCartDTO
     * @return
     */
    @Override
    public Result addCart(AddCartDTO addCartDTO) {
        // 先查询得到商品信息
        GoodsBO goodsBO = goodsMapper.goodsInfoBySpecId(addCartDTO.getGoodsId(),addCartDTO.getSpecId());

        // 把商品价格信息存入到redis中
        JSONObject jsonObjectGoods = new JSONObject();
        jsonObjectGoods.put("price",goodsBO.getGoodsBO().getGoodsSgmPrice());
        redisTemplate.opsForHash().put("cart_goods", addCartDTO.getSpecId(),jsonObjectGoods);

        // 判断库存是否充足
        if (addCartDTO.getCount() > goodsBO.getGoodsBO().getGoodsStock()){
            return Result.FAIL(987,"库存不足");
        }

        Map entries = redisTemplate.opsForHash().entries("cart_" + addCartDTO.getUserId());

        // 判断是否已有当前商品
        JSONObject jsonObject = (JSONObject)entries.get(addCartDTO.getGoodsId());
        if (jsonObject != null){
            // 购物车已存在当前商品
            // 判断再加会不会超出库存
            Integer redisCount = jsonObject.getInteger("count");
            Integer addCount = addCartDTO.getCount();
            Integer mySqlCount = goodsBO.getGoodsBO().getGoodsStock();
            if (redisCount + addCount > mySqlCount){
                // 超出
                return Result.FAIL(987,"库存不足");
            }
            // 没有超出的话,更新数量
            jsonObject.put("count",redisCount + addCount);
            // 大key是用户ID， 小key是商品ID，value就是要加到购物车中的商品信息
            redisTemplate.opsForHash().put("cart_" + addCartDTO.getUserId(),addCartDTO.getSpecId(),jsonObject);
        }else {
            // 购物车不存在当前商品
            // 将数据存入redis
            JSONObject jsonObjectUser = new JSONObject();
            jsonObjectUser.put("specsId",goodsBO.getGoodsBO().getSpecsId());
            jsonObjectUser.put("count",addCartDTO.getCount());
            jsonObjectUser.put("goodsName",goodsBO.getGoodsName());
            jsonObjectUser.put("goodsBanner",goodsBO.getGoodsBanner());
            // 大key是用户ID， 小key是商品ID，value就是要加到购物车中的商品信息
            redisTemplate.opsForHash().put("cart_" + addCartDTO.getUserId(),addCartDTO.getSpecId(),jsonObjectUser);
        }
        return Result.SUCCESS(ResultCodeEnum.SUCCESS);
    }

    /**
     * 查询购物车
     * @param userId
     * @return
     */
    @Override
    public Result queryCartByUserId(Long userId) {
        List<JSONObject> list = new ArrayList<>();
        Map entries = redisTemplate.opsForHash().entries("cart_" + userId);
        Set set = entries.keySet();
        set.forEach(a->{
            JSONObject jsonObject = (JSONObject) entries.get(a);
            JSONObject jsonObjectPrice = (JSONObject) redisTemplate.opsForHash().get("cart_goods", jsonObject.get("specsId"));
            jsonObject.put("price",jsonObjectPrice.get("price"));
            list.add(jsonObject);
        });
        return Result.SUCCESS(list);
    }
}
