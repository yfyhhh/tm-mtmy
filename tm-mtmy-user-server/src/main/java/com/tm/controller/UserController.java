package com.tm.controller;

import com.tm.entity.QRCodeUserLogin;
import com.tm.entity.User;
import com.tm.entity.UserByFlag;
import com.tm.entity.dto.UserDTO;
import com.tm.result.Result;
import com.tm.result.ResultCodeEnum;
import com.tm.service.UserService;
import com.tm.utils.SendSmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("api/user")
@CrossOrigin
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

    /**
     *根据标识查询用户
     * @param userByFlag
     * @return
     */
    @PostMapping("queryUserByFlag")
    public Result queryUserByFlag(UserByFlag userByFlag){
        return userService.queryUserByFlag(userByFlag);
    }

    /**
     * 添加登录标识
     * @param userByFlag
     * @return
     */
    @PostMapping("saveLoginFlag")
    public Result saveLoginFlag(UserByFlag userByFlag){
        return userService.saveLoginFlag(userByFlag);
    }

    /**
     *
     * @param qrCodeUserLogin
     * @return
     */
    @PostMapping("userQRCodeLogin")
    public Result userQRCodeLogin(QRCodeUserLogin qrCodeUserLogin){
        return userService.userQRCodeLogin(qrCodeUserLogin);
    }

}


