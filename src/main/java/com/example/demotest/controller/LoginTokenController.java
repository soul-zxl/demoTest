package com.example.demotest.controller;

import com.example.demotest.entity.User;
import com.example.demotest.service.loginJwtService;
import com.example.demotest.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "token",tags = "生成token")
@RequestMapping("/token")
public class LoginTokenController {
    @Autowired
    loginJwtService loginJwtService;

    @PostMapping("/insert")
    @ApiOperation("测试")
    public ResponseEntity login(@RequestBody User user) {
        String login = loginJwtService.login(user);
        return ResultUtil.success(login);
    }

}
