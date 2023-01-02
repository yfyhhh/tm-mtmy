package com.tm.controller;

import com.tm.entity.UserAddr;
import com.tm.entity.dto.CreateOrderDTO;
import com.tm.result.Result;
import com.tm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    /**
     * 查询所有地址
     * @return
     */
    @PostMapping("allAddr")
    public Result allAddr(){
        return orderService.allAddr();
    }

    /**
     * 查询收货地址列表
     * @param userId
     * @return
     */
    @PostMapping("userAddrList")
    public Result userAddrList(Long userId){
        return orderService.addrList(userId);
    }

    /**
     * 新增收货地址
     * @param userAddr
     * @return
     */
    @PostMapping("addUserAddr")
    public Result addUserAddr(UserAddr userAddr){
        return orderService.addUserAddr(userAddr);
    }


    /**
     * 获取创建订单的唯一标识
     * @return
     */
    @PostMapping("getOrderFlag")
    public Result getOrderFlag(){
        return orderService.getOrderFlag();
    }

    /**
     * 创建订单
     * @param createOrderDTO
     * @return
     */
    @PostMapping("createOrder")
    public Result createOrder(@RequestBody CreateOrderDTO createOrderDTO){
        return orderService.createOrder(createOrderDTO);
    }


}
