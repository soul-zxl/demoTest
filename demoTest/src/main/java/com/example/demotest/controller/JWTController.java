package com.example.demotest.controller;

import com.example.demotest.entity.User;
import com.example.demotest.util.JwtUtil;
import com.example.demotest.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(value = "JWT", tags = "JWTAPI")
@RequestMapping()
public class JWTController {

    @PostMapping("/insert")
    @ApiOperation("登录")
    public ResponseEntity login(@RequestBody User user) {
        String token = JwtUtil.createToken(user);
        return ResultUtil.success(token);
    }
}
