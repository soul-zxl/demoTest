package com.example.demotest.controller;

import com.example.demotest.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "demo",tags = "demoAPI")
@RequestMapping("/demo")
public class demoController {


    @PostMapping("/add")
    @ApiOperation("更新用户的接口")
    public String updateUser(@RequestBody User user) {
        return "ok";
    }


    @PostMapping("/update")
    @ApiOperation("添加用户的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", defaultValue = "李四"),
            @ApiImplicitParam(name = "address", value = "用户地址", defaultValue = "深圳", required = true)
    }
    )
    public String addUser(@RequestBody User user) {
        return "ok";
    }



}
