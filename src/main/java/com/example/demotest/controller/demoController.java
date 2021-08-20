package com.example.demotest.controller;
import com.example.demotest.entity.User;
import com.example.demotest.service.loginJwtService;
import com.example.demotest.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "demo", tags = "demoAPI")
@RequestMapping("/demo")
public class demoController {
     @Autowired
    loginJwtService loginJwtService;

    @PostMapping("/add")
    @ApiOperation("更新用户的接口")
    public String updateUser() {
        return "ok";
    }


}