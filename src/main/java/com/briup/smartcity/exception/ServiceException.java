package com.briup.smartcity.exception;

import com.briup.smartcity.utils.ResultCode;

/**
 *
 * 自定义异常类，当程序发生异常，自定义抛出异常信息
 *
 */
public class ServiceException extends RuntimeException{
    private Integer code;
    private String msg;
    private ResultCode resultCode;

    public ServiceException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public ServiceException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
        this.msg = resultCode.getMessage();
        this.code = resultCode.getStatus();
    }

    public ServiceException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
