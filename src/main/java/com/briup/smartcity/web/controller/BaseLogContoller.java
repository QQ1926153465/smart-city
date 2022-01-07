package com.briup.smartcity.web.controller;


import com.briup.smartcity.aop.Logging;
import com.briup.smartcity.bean.BaseLog;
import com.briup.smartcity.service.IBaseLogService;
import com.briup.smartcity.utils.Result;
import com.briup.smartcity.utils.ResultUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Logging()
@Api(tags = "日志模块")
@RequestMapping("/auth/log")
@RestController
public class BaseLogContoller {
    @Autowired
    private IBaseLogService service;
    @GetMapping("/pageQuery")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "pageNum",value = "当前页面",dataType = "int"),
                    @ApiImplicitParam(name = "pageSize",value = "页面大小",dataType = "int")
            }
    )
    public Result findAllByPageHelper(Integer pageNum, Integer pageSize){
        PageInfo<BaseLog> pageInfo = service.findAllByPageHepler(pageNum, pageSize);
        return ResultUtil.success(pageInfo);
    }

}
