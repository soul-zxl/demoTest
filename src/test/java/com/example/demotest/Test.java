package com.example.demotest;

import com.example.demotest.entity.User;
import com.example.demotest.mapper.LoginJwtMapper;
import com.example.demotest.mapper.UserMapper;
import com.example.demotest.util.redisUtile;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.assertj.core.util.Lists;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ArrayList;

@SpringBootTest
public class Test {
    @Autowired
    DataSource dataSource;
    @Autowired
    redisUtile redisUtile;
    @Autowired
    LoginJwtMapper loginJwtMapper;

    @SneakyThrows
    @org.junit.jupiter.api.Test
    public void test() {
        dataSource.getClass();
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        System.out.println(dataSource.getClass());
    }

    @Autowired
    //指定    redis模板
    @Qualifier("redisTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    @org.junit.jupiter.api.Test
    public void testReids() throws JsonProcessingException {
        //   操作字符串
        redisTemplate.opsForValue().set("mykey", "myvalues，美美");
        System.out.println(redisTemplate.opsForValue().get("mykey"));


        User user = new User(1, "zxl", "17", "12480411132QQ.COM");
        //真实开打一般都是用json来传递
        String jsonUser = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user", jsonUser);
        System.out.println(redisTemplate.opsForValue().get("user"));


        //传入对象需要序列化
        // 不然会报错  ailed to serialize object using DefaultSerializer
        User user1 = new User(1, "ssssss", "2222", "124804eee11132QQ.COM");
        redisTemplate.opsForValue().set("user1", user1);
        System.out.println(redisTemplate.opsForValue().get("user1"));


    }

    @org.junit.jupiter.api.Test
    public void test2() {
        Object name = redisUtile.get("name");
        System.out.println(name);

    }

    @org.junit.jupiter.api.Test
    public void test3() {

        Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println(jedis.ping());

        jedis.flushDB();

    }

    @org.junit.jupiter.api.Test
    public void test4() {
        long l = System.currentTimeMillis();
        System.out.println(l);
        for (int i = 0; i < 60000; i++) {
            User user5 = new User(i, "zxl", "22", "4444");
            redisUtile.set("user" + i, user5);
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1);
        //   8244    8473   8223
        System.out.println(l1 - l);
    }

    @org.junit.jupiter.api.Test
    public void test5() {
        long l = System.currentTimeMillis();
        System.out.println(l);
        for (int i = 0; i < 60000; i++) {
            User user5 = new User(i, "zxl", "22", "4444");
            loginJwtMapper.insert(user5);
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1);
        //   191637
        System.out.println(l1 - l);

    }
    //@org.junit.jupiter.api.Test
    //public void test1(){
    //    ArrayList<Object> objects = Lists.newArrayList();
    //    StringUtils.isBlank()
    //}




}
