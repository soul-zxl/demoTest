package com.example.demotest.controller;

import com.example.demotest.entity.User;
import com.example.demotest.service.loginJwtService;
import com.example.demotest.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@Api(value = "user", tags = "用户api")
@RequestMapping("/user")
public class userController {

    @Autowired
    loginJwtService loginJwtService;

    @PostMapping("/insert")
    @ApiOperation(value = "注册", tags = "注册api")
    public ResponseEntity insert(@RequestBody User user) {
        this.loginJwtService.save(user);
        return ResultUtil.success();
    }

    @PostMapping("/select")
    @ApiOperation(value = "查询用户信息", tags = "查询用户信息api")
    public ResponseEntity select() {
        List<User> list = this.loginJwtService.list(null);
        list.stream().forEach(System.out::println);
        return ResultUtil.success();
    }

    @PostMapping("/update")
    @ApiOperation(value = "查询用户信息", tags = "修改用户信息api")
    public ResponseEntity update(User user) {
        this.loginJwtService.updateById(user);
        return ResultUtil.success();
    }

    @GetMapping("/delete/{id}")
    @ApiOperation(value = "根据id删除用户信息", tags = "根据id删除用户信息api")
    public ResponseEntity delete(@PathVariable("id") String id) {
        this.loginJwtService.removeById(id);
        return ResultUtil.success();
    }


}
