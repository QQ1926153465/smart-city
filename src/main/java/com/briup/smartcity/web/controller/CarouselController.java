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
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@Api(tags = "轮播图模块")
@RestController
@Logging()
@RequestMapping("/auth/carousel")
public class CarouselController {
    @Autowired
    private ICarouselService service;


    @GetMapping(value = "/page/query")
    @ApiOperation("分页查找轮播图信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "当前页面" , dataType = "int"),
            @ApiImplicitParam(name = "pageSize" , value = "每页大小" , dataType = "int")
    })
    public Result findAllByPage(Integer pageNum,Integer pageSize){
        PageInfo<Carousel> pageInfo = service.findAll(pageNum, pageSize);
        return ResultUtil.success(pageInfo);
    }





//    @Logging()
    @ApiOperation("查找所有已启用的轮播图")
    @GetMapping(value = "/find/yes")
    public Result findAllYesCarousel(){
        List<Carousel> allYesCarousel = service.findYesCarousel();
        return ResultUtil.success(allYesCarousel);
    }






//    @Logging()
    @DeleteMapping(value = "/deleteById")
    @ApiOperation("通过id删除轮播图")
    @ApiImplicitParam(name = "id",value = "需要删除的轮播图的id", dataType = "int")

    public Result deleteById(Integer id){
        service.deleteById(id);
        return ResultUtil.success();
    }



//    @Logging()
    @PostMapping("/save")
    @ApiOperation("保存轮播图信息")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "carouselId",value = "编号：自动生成无需书写"),
                    @ApiImplicitParam(name = "carouselName",value = "轮播图名称",dataType = "String"),
                    @ApiImplicitParam(name = "carouselInfo",value = "轮播图信息",dataType = "String"),
                    @ApiImplicitParam(name = "carouselUrl",value = "轮播图地址",dataType = "String"),
                    @ApiImplicitParam(name = "carouselStatus",value = "轮播图状态：0-禁用，1-启用",dataType = "int"),



            }
    )
    public Result SaveCarousel(Carousel carousel){

        int i = service.SaveCarousel(carousel);
        return ResultUtil.success(i);
    }


//    @Logging()
    @PutMapping("/update")
    @ApiOperation("根据ID修改轮播图基本信息和状态信息")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "carouselId",value = "需要修改的编号"),
                    @ApiImplicitParam(name = "carouselName",value = "轮播图名称",dataType = "String"),
                    @ApiImplicitParam(name = "carouselInfo",value = "轮播图信息",dataType = "String"),
                    @ApiImplicitParam(name = "carouselUrl",value = "轮播图地址",dataType = "String"),
                    @ApiImplicitParam(name = "carouselStatus",value = "轮播图状态：0-禁用，1-启用",dataType = "int"),



            }
    )

    public Result UpdateCarouselById(Carousel carousel){

        int i = service.updateCarousel(carousel);


        return ResultUtil.success(i);
    }


}
