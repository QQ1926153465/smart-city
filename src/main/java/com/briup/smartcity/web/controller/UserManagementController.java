package com.briup.smartcity.web.controller;


import com.briup.smartcity.aop.Logging;
import com.briup.smartcity.bean.BaseUser;
import com.briup.smartcity.exception.ServiceException;
import com.briup.smartcity.service.IBaseUserService;
import com.briup.smartcity.service.IUserManagementService;
import com.briup.smartcity.utils.Result;
import com.briup.smartcity.utils.ResultUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@Logging()
@Api(tags = "用户管理模块")
@RestController
@RequestMapping("/auth/user/")
public class UserManagementController {

    @Autowired
    private IUserManagementService service ;

    @DeleteMapping("/delete")
    @ApiOperation("通过id删除用户")
    @ApiImplicitParam(name = "id",value = "需要删除的用户的id",dataType = "int")
    public Result deleteUserById(Integer id){

        int i = service.deleteUserById(id);

        return ResultUtil.success(i);
    }







    @GetMapping(value = "/page/query")

    @ApiOperation("分页并模糊查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "当前页面" , dataType = "int"),
            @ApiImplicitParam(name = "pageSize" , value = "每页大小" , dataType = "int"),
            @ApiImplicitParam(name = "username" , value = "用户名" , dataType = "String"),
            @ApiImplicitParam(name = "role" , value = "角色" , dataType = "int")
    })

    public Result findAllUserByPageHelper(Integer pageNum,Integer pageSize,String username,Integer role){
        PageInfo<BaseUser> pageInfo = service.findUserByPageHelperLike(pageNum, pageSize,username,role);
        return ResultUtil.success(pageInfo);
    }






    @GetMapping(value = "/info")
    @ApiOperation("获取当前登录用户信息")
    public Result findUserByToken(){
        BaseUser user = service.findUserByToken();
        return ResultUtil.success(user);
    }











    @PutMapping(value = "/update")
    @ApiOperation("更新用户基本信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "用户名" ),
            @ApiImplicitParam(name = "user_id" , value = "用户id" ),
            @ApiImplicitParam(name = "telephone" , value = "用户手机号码" ),
            @ApiImplicitParam(name = "status" , value = "账户状态：0-正常，1-禁用" ),
            @ApiImplicitParam(name = "role" , value = "角色：0-管理员，1-普通用户" ),
            @ApiImplicitParam(name = "register_time" , value = "注册时间" ),
            @ApiImplicitParam(name = "realname" , value = "用户真实姓名" ),
            @ApiImplicitParam(name = "password" , value = "密码" ),
            @ApiImplicitParam(name = "icon" , value = "头像地址" ),
            @ApiImplicitParam(name = "gender" , value = "性别" ),
            @ApiImplicitParam(name = "email" , value = "邮件" ),
            @ApiImplicitParam(name = "dob" , value = "出生日期"),
    })
    //String username, Integer user_id, String telephone, Integer status,
    //                             Integer role, @DateTimeFormat Date register_time,String realname,
    //                             String password,String icon,Integer gender,String email,@DateTimeFormat Date dob

    //BaseUser user;
    public Result updateUser(BaseUser user){

        int i = service.UpdateUserByUserName(user);

        return ResultUtil.success(i);

    }






    @PutMapping("/updateUserIcon")
    @ApiOperation("更新用户头像")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "id",value = "用户id",dataType = "int"),
                    @ApiImplicitParam(name = "userIcon",value = "头像地址",dataType = "String")
            }
    )

    public Result UpdataUserIconById(Integer id,String userIcon){

        int i = service.UpdataUserIconById(id, userIcon);

        return ResultUtil.success(i);
    }







    @PutMapping("/update/status")
    @ApiOperation("更新用户状态")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "id",value = "用户id",dataType = "int"),
                    @ApiImplicitParam(name = "status",value = "账户状态：0-正常，1-禁用",dataType = "int")
            }
    )

    public Result UpdataUserStatusById(Integer id,Integer status){

        int i = service.UpdataUserStatusById(id, status);

        return ResultUtil.success(i);
    }

}
