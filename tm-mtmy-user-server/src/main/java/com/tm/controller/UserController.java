package com.tm.controller;

import com.tm.entity.User;
import com.tm.entity.dto.UserDTO;
import com.tm.result.Result;
import com.tm.result.ResultCodeEnum;
import com.tm.service.UserService;
import com.tm.utils.SendSmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserService userService;

    /**
     * 发送验证码
     * @param phoneNumber
     * @return
     */
    @PostMapping("sendCode")
    public Result sendCode(String phoneNumber){
        //生成验证码
        String s = SendSmsUtil.loginSendSms(phoneNumber);
        //将验证码存入redis
        redisTemplate.opsForValue().set("code_" + phoneNumber,s,300, TimeUnit.SECONDS);
        return Result.SUCCESS(ResultCodeEnum.SUCCESS);
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @PostMapping("userRegister")
    public Result userRegister(@RequestBody UserDTO user){
        return Result.SUCCESS(userService.userRegister(user));
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @PostMapping("userLogin")
    public Result userLogin(@RequestBody UserDTO user){
        return Result.SUCCESS(userService.userLogin(user));
    }
}


