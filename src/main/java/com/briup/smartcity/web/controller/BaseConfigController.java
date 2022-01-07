package com.briup.smartcity.web.controller;


import com.briup.smartcity.aop.Logging;
import com.briup.smartcity.bean.BaseConfig;
import com.briup.smartcity.service.IBaseConfigService;
import com.briup.smartcity.utils.Result;
import com.briup.smartcity.utils.ResultUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Logging()
@Api(tags = "系统配置模块")
@RestController
@RequestMapping("/auth/config")
public class BaseConfigController {

    @Autowired
    private IBaseConfigService service;
    @Logging()
    @GetMapping("/current/config/yes")
    @ApiOperation("查询当前启用的系统配置")
    public Result Config(){

        BaseConfig baseConfig = service.currentConfigYes();
        System.out.println(baseConfig);
        return ResultUtil.success(baseConfig);
    }
    @Logging()
    @DeleteMapping("/deleteById")
    @ApiOperation("通过id删除配置信息")
    @ApiImplicitParam(name = "id",value = "id",dataType = "int")
    public Result deleteConfig(Integer id){
        int i = service.deleteById(id);
        return  ResultUtil.success(i);
    }
    @Logging()
    @GetMapping ("/page/query")
    @ApiOperation("分页查询配置信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "pageNum"),
            @ApiImplicitParam(name = "pageSize",value = "pageSize")
    })
    public Result findConfig(Integer pageNum,Integer pageSize){
        PageInfo<BaseConfig> allWithPage = service.findAllWithPage(pageNum, pageSize);
        return ResultUtil.success(allWithPage);
    }

    @Logging()
    @PostMapping("/save")
    @ApiOperation("保存配置信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "configIcon"),
            @ApiImplicitParam(name = "configId",dataType = "int"),
            @ApiImplicitParam(name = "configInfo"),
            @ApiImplicitParam(name = "configName"),
            @ApiImplicitParam(name = "configStatus",dataType = "int")
    })
    public  Result saveConfig(BaseConfig baseConfig){
        service.saveConfig(baseConfig);
        return ResultUtil.success(baseConfig);
    }

    @PutMapping("/update")
    @ApiOperation("更新配置基本信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "configIcon"),
            @ApiImplicitParam(name = "configId",dataType = "int"),
            @ApiImplicitParam(name = "configInfo"),
            @ApiImplicitParam(name = "configName"),
            @ApiImplicitParam(name = "configStatus",dataType = "int")
    })
    public Result updateConfig(BaseConfig baseConfig){
        service.updateConfig(baseConfig);
        return ResultUtil.success(baseConfig);
    }

    @PutMapping("/update/status")
    @ApiOperation("更新配置状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "id"),
            @ApiImplicitParam(name = "status",value = "status")
    })
    public Result upConfig(Integer id,Integer status){
        service.changeConfigStatus(id,status);
        return ResultUtil.success();
    }

}
