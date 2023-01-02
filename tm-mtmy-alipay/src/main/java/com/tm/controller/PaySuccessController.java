package com.tm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("paySuccess")
public class PaySuccessController {

    @GetMapping("paySuccess")
    public Object paySuccess(String ordersId){

        return null;
    }
}
