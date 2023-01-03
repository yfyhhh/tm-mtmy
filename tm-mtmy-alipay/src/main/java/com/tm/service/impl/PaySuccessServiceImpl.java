package com.tm.service.impl;

import com.tm.entity.OrdersPayInfo;
import com.tm.mapper.PaySuccessMapper;
import com.tm.result.Result;
import com.tm.result.ResultCodeEnum;
import com.tm.service.PaySuccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaySuccessServiceImpl implements PaySuccessService {

    @Autowired
    private PaySuccessMapper paySuccessMapper;

    @Override
    public Result paySuccess(OrdersPayInfo payInfo) {
        try {
            // 将订单支付信息存入数据库
            Integer a = paySuccessMapper.addOrdersPayInfo(payInfo);
            if (a == 1){
                // 存入成功后，将订单状态改为已支付
                paySuccessMapper.updateOrdersTypeById(payInfo.getOut_trade_no());
            }
            return Result.SUCCESS(ResultCodeEnum.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
