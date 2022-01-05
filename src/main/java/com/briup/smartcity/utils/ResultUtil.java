package com.briup.smartcity.utils;

/**
 * 返回结果对象的工具类：
 * 1.封装每个controller类中大量重复new对象
 */
public class ResultUtil {
    //表示返回成功
    public static Result success(){
        return new Result(ResultCode.SUCCESS);
    }
    //表示返回成功+携带数据
    public static Result success(Object data){
        return new Result(1,"操作成功",data);
    }
    //表示返回默认信息失败
    public static Result error(){
        return new Result(2,"操作失败");
    }

    public static Result error(ResultCode rc){
        return new Result(rc);
    }

    //表示返回指定信息失败
    public static Result error(String msg){
        return new Result(2,msg);
    }
    //表示返回指定信息失败+携带错误数据
    public static Result error(String msg,Object data){
        return new Result(1,msg,data);
    }
}
