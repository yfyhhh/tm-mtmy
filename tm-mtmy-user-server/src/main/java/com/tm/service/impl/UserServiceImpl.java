package com.tm.service.impl;

import com.tm.entity.User;
import com.tm.entity.dto.UserDTO;
import com.tm.mapper.UserMapper;
import com.tm.result.Result;
import com.tm.result.ResultCodeEnum;
import com.tm.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Result userRegister(UserDTO user) {
        //根据手机号查询用户
        User userModel = userMapper.queryUserByPhoneNumber(user.getUserPhone());
        //判断该用户是否已存在
        if(userModel != null){
            return Result.FAIL("该手机号已注册，请登录");
        }
        //从redis中获取该手机号的验证码
        Object o = redisTemplate.opsForValue().get("code_" + user.getUserPhone());
        //判断验证码是否过期
        if(o ==null){
            return Result.FAIL("验证码过期");
        }
        //跟用户传进来的验证码比较
        if(user.getCode().equals(o.toString())){
            //验证码通过，新增用户
            userMapper.addUser(user);
        }
        return Result.SUCCESS("注册成功!!!");
    }

    @Override
    public Result userLogin(UserDTO user) {
        //获得用户输入的密码
        String userPwd = user.getUserPwd();
        //判断密码是否为空
        if (StringUtils.isNotBlank(userPwd)) {
            //查询数据库获得密码，和用户输入的进行匹配
            User userModel = userMapper.queryUserByName(user.getUserName());
            //用户密码MD5加密
            //String s1 = MD5Util.MD5Encode(userPwd);
            //判断密码是否正确
            if (userModel != null && userModel.getUserPwd().equals(userPwd)){
                //验证通过后，用UUID生成一个token,将token扔到redis中
                String s = UUID.randomUUID().toString();
                //将token存入redis
                redisTemplate.opsForValue().set("token_" + user.getUserName(), s);
                return Result.SUCCESS(s);
            }else {
                return Result.FAIL("账号或密码错误");
            }
        }
        //从缓存中获取验证码
        Object o = redisTemplate.opsForValue().get("code_" + user.getUserPhone());
        if (o == null){
            return Result.FAIL("验证码已过期");
        }
        //判断用户输入的验证码是否与缓存中的一致
        if (user.getCode().equals(o.toString())){
            //验证通过后，用UUID生成一个token,将token扔到redis中
            String s = UUID.randomUUID().toString();
            //将token存入redis
            redisTemplate.opsForValue().set("token_" + user.getUserPhone(), s);
            return Result.SUCCESS(s);
        }else {
            return Result.FAIL("验证码错误");
        }
    }
}
