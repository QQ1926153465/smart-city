package com.briup.smartcity.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 响应报文中响应体的内容封装的结果类
 * code msg data
 */
@ApiModel(description = "响应结果信息")
public class Result {
    @ApiModelProperty("状态码")
    private Integer status;//状态码
    @ApiModelProperty("状态信息")
    private String message;//状态信息
    //万物皆对象
    @ApiModelProperty("业务数据")
    private Object data;// 业务数据

    public Result() {
    }

    public Result(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
    public Result(ResultCode rc){
        this.status = rc.getStatus();
        this.message = rc.getMessage();
    }
    public Result(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}


