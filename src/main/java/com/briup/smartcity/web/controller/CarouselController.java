package com.briup.smartcity.web.controller;

import com.briup.smartcity.aop.Logging;
import com.briup.smartcity.bean.Carousel;
import com.briup.smartcity.service.ICarouselService;
import com.briup.smartcity.utils.Result;
import com.briup.smartcity.utils.ResultUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Logging()
@Api(tags = "轮播图模块")
@RestController
@RequestMapping("/auth/carousel")
public class CarouselController {
    @Autowired
    private ICarouselService service;

    @ApiOperation("根据id删除轮播图信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "id")
    })
    @DeleteMapping("/deleteById")
    public Result delete(Integer id){
        int i = service.deleteById(id);
        return ResultUtil.success(i);
    }

    @ApiOperation("分页查找轮播图信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "当前页",dataType = "int"),
            @ApiImplicitParam(name = "pageSize",value = "每页大小",dataType = "int")
    })
    @GetMapping("/page/query")
    public Result findAllCarousel(Integer pageNum,Integer pageSize){
        //执行查询分页
        PageInfo <Carousel> pageInfo = service.findAll(pageNum, pageSize);
        return ResultUtil.success(pageInfo);
    }

    @ApiOperation("查找所有已启用的轮播图")
    @GetMapping("/find/yes")
    public Result findAllYesCarousel(){
        List<Carousel> yesCarousel = service.findYesCarousel();
        return ResultUtil.success(yesCarousel);
    }



    //添加 提供添加信息  存放数据库 id值  mysql 主键自增
    @ApiOperation("保存轮播图信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "carouselId",value = "轮播图ID",dataType = "int"),
            @ApiImplicitParam(name = "carouselInfo",value = "轮播图描述"),
            @ApiImplicitParam(name = "carouselName",value = "轮播图名称"),
            @ApiImplicitParam(name = "carouselStatus",value = "轮播图状态",dataType = "int"),
            @ApiImplicitParam(name = "carouselUrl",value = "轮播图地址")
    })
    @PostMapping("/save")
    public Result addCarousel(Carousel carousel){
        service.saveCarousel(carousel);
        return ResultUtil.success();
    }

    @ApiOperation("修改轮播信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "carouselId",value = "轮播图ID",dataType = "int"),
            @ApiImplicitParam(name = "carouselInfo",value = "轮播图描述"),
            @ApiImplicitParam(name = "carouselName",value = "轮播图名称"),
            @ApiImplicitParam(name = "carouselStatus",value = "轮播图状态",dataType = "int"),
            @ApiImplicitParam(name = "carouselUrl",value = "轮播图地址")
    })
    @PutMapping("/update")
    public  Result update(Carousel carousel){
        service.updateCarousel(carousel);
        return ResultUtil.success();
    }

}
