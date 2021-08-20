package com.example.demotest.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demotest.entity.User;
import com.example.demotest.mapper.LoginJwtMapper;
import com.example.demotest.util.JwtUtil;
import com.example.demotest.util.redisUtile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginJwtService extends ServiceImpl<LoginJwtMapper, User> {
    @Autowired
    redisUtile redisUtile;
    public String login(User user){
        //判断是否正确




        //存入redis中
        redisUtile.set("token",JwtUtil.createToken(user));
        return "success";

    }

}