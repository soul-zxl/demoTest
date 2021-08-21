package com.example.demotest.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public class ResultUtil {

    /**
     * 业务逻辑成功
     */
    private static final Integer SUCCESS = 200;

    /**
     * 业务逻辑成功，无返回值
     */
    private static final Integer NO_CONTENT = 200;

    /**
     * 参数校验异常
     */
    private static final Integer ERROR = 400;

    /**
     * 认证失败
     */
    private static final Integer UNAUTHORIZED = 401;

    /**
     * 系统异常
     */
    private static final Integer INTERNAL_SERVER_ERROR=500;


    /**
     * 业务异常
     */
    private static final Integer BUSINESS_ERROR = 412;


    public static ResponseEntity success(Object object) {
        Result result = new Result();
        result.setCode(SUCCESS);
        result.setMsg("成功");
        result.setData(object);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity success(String msg) {
        Result result = new Result(new HashMap());
        result.setCode(NO_CONTENT);
        result.setMsg(msg);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity success(String msg, Object object) {
        Result result = new Result();
        result.setCode(SUCCESS);
        result.setMsg(msg);
        result.setData(object);
        return new ResponseEntity(result, HttpStatus.OK);
    }


    public static ResponseEntity success() {
        Result result = new Result(new HashMap());
        result.setCode(NO_CONTENT);
        result.setMsg("成功");
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity error(String msg) {
        Result result = new Result(new HashMap());
        result.setCode(INTERNAL_SERVER_ERROR);
        result.setMsg(msg);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity error(String msg,Object errdata) {
        Result result = new Result();
        result.setCode(INTERNAL_SERVER_ERROR);
        result.setMsg(msg);
        result.setData(errdata);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity unauthorizedError(String msg) {
        Result result = new Result(new HashMap());
        result.setCode(UNAUTHORIZED);
        result.setMsg(msg);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity internalServerError(String msg) {
        Result result = new Result(new HashMap());
        result.setCode(INTERNAL_SERVER_ERROR);
        result.setMsg(msg);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    /**
     * 业务异常返回
     * @param msg
     * @return
     */
    public static ResponseEntity businessError(String msg) {
        Result result = new Result(new HashMap());
        result.setCode(BUSINESS_ERROR);
        result.setMsg(msg);
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
