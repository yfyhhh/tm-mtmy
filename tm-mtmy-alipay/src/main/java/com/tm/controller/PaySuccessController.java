package com.tm.controller;

import com.tm.entity.OrdersPayInfo;
import com.tm.result.Result;
import com.tm.service.PaySuccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("paySuccess")
public class PaySuccessController {

    @Autowired
    private PaySuccessService paySuccessService;

    /**
     * 接受支付成功的信息，存入数据库
     * @param payInfo
     * @return
     */
    @GetMapping("paySuccess")
    public Result paySuccess(OrdersPayInfo payInfo){
        return paySuccessService.paySuccess(payInfo);
    }
}
