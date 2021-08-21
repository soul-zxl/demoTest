package com.example.demotest.util;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class ResponseResult implements Serializable {

    @ApiModelProperty(value = "状态码")
    private Integer code;

    @ApiModelProperty(value = "提示信息")
    private String msg;

    @ApiModelProperty(value = "返回数据")
    private Object data;

    private static ResponseResult resultData(Integer code, String msg, Object data) {
        ResponseResult res = new ResponseResult();
        res.setCode(code);
        res.setMsg(msg);
        res.setData(data);
        return res;
    }

    /**
     * 成功
     */
    public static ResponseResult success() {
        return resultData(200, "操作成功", null);
    }

    /**
     * 成功
     */
    public static ResponseResult success(String msg) {
        return resultData(200, msg, null);
    }

    /**
     * 成功
     */
    public static ResponseResult success(Object data) {
        return resultData(200, "操作成功", data);
    }

    /**
     * 成功
     */
    public static ResponseResult success(String msg, Object data) {
        return resultData(200, msg, data);
    }

    /**
     * 失败
     */
    public static ResponseResult error() {
        return resultData(500, "操作失败", null);
    }

    /**
     * 失败
     */
    public static ResponseResult error(Integer code) {
        return resultData(code, null, null);
    }

    /**
     * 失败
     */
    public static ResponseResult error(Integer code, String msg) {
        return resultData(code, msg, null);
    }

    /**
     * 失败
     */
    public static ResponseResult error(String msg) {
        return resultData(500, msg, null);
    }

    /**
     * 失败
     */
    public static ResponseResult error(Object data) {
        return resultData(500, "操作失败", data);
    }

    /**
     * 失败
     */
    public static ResponseResult error(Integer code, String msg, Object data) {
        return resultData(code, msg, data);
    }








}
