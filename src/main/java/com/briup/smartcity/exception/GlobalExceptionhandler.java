package com.briup.smartcity.exception;

import com.briup.smartcity.utils.Result;
import com.briup.smartcity.utils.ResultUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionhandler {
    @ExceptionHandler(Exception.class)
    public Result handlerException(Exception e){
        System.out.println("执行全局异常处理");
        e.printStackTrace();
        if (e instanceof ServiceException){
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.error("程序内部错误");
    }
}
