package com.briup.smartcity.web.controller;

import com.briup.smartcity.aop.Logging;
import com.briup.smartcity.service.IBaseUserService;
import com.briup.smartcity.utils.JwtUtil;
import com.briup.smartcity.utils.Result;
import com.briup.smartcity.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@Api(tags="登录模块")
@RestController
public class LoginController {
    @Autowired
    private IBaseUserService service;

    @ApiOperation("登录系统")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "用户名" , dataType = "String"),
            @ApiImplicitParam(name = "password" , value = "密码" , dataType = "String")
    })
    @PostMapping(value = "/login" ,consumes ="application/x-www-form-urlencoded")
    public Result login(String username, String password){
        //1.调用service层的代码
        String token = service.login(username,password);
        return ResultUtil.success(token);

    }



    @ApiOperation("退出登录")
    @PostMapping(value = "/logout")
    public Result loginOut(){

        return ResultUtil.success("退出成功");
    }
}
