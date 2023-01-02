package com.tm.controller;

import com.tm.entity.bo.PaymentBO;
import com.tm.service.PayService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
import java.util.Map;
 
/**
 *  支付宝支付，控制器
 *
 * @author wangziyang
 * */
@RestController
@RequestMapping(value = "pay")
public class PayController {

    @Autowired
    private PayService payService;
 
    /**
     *  下单支付
     * */
    @GetMapping("confirm")
    public Object pay (PaymentBO bo) throws Exception {
        //这个接口其实应该是post方式的，但是我这里图方便，直接以get方式访问，
        //且返回格式是text/html，这样前端页面就能直接显示支付宝返回的html片段
        //真实场景下由post方式请求，返回code、msg、data那种格式的标准结构，让前端拿到data里的        
        //html片段之后自行加载
 
        //由于我这里并没有真正的传参数，所以象征性的new一下，避免空指针
        return payService.pay(bo);
    }
}