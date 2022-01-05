package com.briup.smartcity.utils;
//枚举类： 对象数量有限 定义类 创建对象
public enum ResultCode {
    SUCCESS(1,"操作成功"),
    ERROR(2,"操作失败"),
    PARAM_ERROR(3,"参数错误");
    //系统可能返回的信息 及状态码 定义到枚举类
    private Integer status;
    private String message;

    ResultCode(Integer status, String message) {
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
}
