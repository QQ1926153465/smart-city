package com.briup.smartcity.web.controller;


import com.briup.smartcity.bean.Category;
import com.briup.smartcity.service.ICategoryService;
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

@Api(tags = "资讯栏目模块")
@RestController
@RequestMapping("/auth/category")
public class CategoryController {
    @Autowired
    private ICategoryService service;

    @ApiOperation("分页查看栏目信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "当前页",dataType = "int"),
            @ApiImplicitParam(name = "pageSize",value = "每页大小",dataType = "int")
    })
    @GetMapping("/page/queryAll")
    public Result pageQueryAllCatagory(Integer pageNum, Integer pageSize){
        //执行查询分页
        PageInfo<Category> pageInfo = service.pageQueryAll(pageNum, pageSize);
        return ResultUtil.success(pageInfo);
    }

    @ApiOperation("通过id删除栏目")
    @DeleteMapping("/deleteById")
    public Result deleteById(int id){
        //调用service方法实现
        service.deleteById(id);
        return ResultUtil.success();
    }

    @ApiOperation("查找所有栏目不分页")
    @GetMapping("/find/all")
    public Result findAll(){
        List<Category> list = service.findAll();
        return ResultUtil.success(list);
    }

    @ApiOperation("批量删除栏目")
    @DeleteMapping("/batchDelete")
    public Result batchDelete(int[] ids){
        service.batchDelete(ids);
        return ResultUtil.success();

    }

    @ApiOperation("保存栏目信息")
    @PostMapping("/save")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryId",value = "栏目id",dataType = "int"),
            @ApiImplicitParam(name = "categoryDescription",value = "栏目描述",dataType = "String"),
            @ApiImplicitParam(name = "categoryName",value = "栏目名称",dataType = "String"),
            @ApiImplicitParam(name = "categoryOrder",value = "栏目序号",dataType = "int"),
            @ApiImplicitParam(name = "categoryParentId",value = "栏目所属的父栏目",dataType = "int")
    })
    public  Result saveCategory(Category category){
        System.out.println("栏目对象"+category);
        service.saveCategory(category);
        return ResultUtil.success();
    }

    @ApiOperation("更新栏目信息")
    @PutMapping("/update")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryId",value = "栏目id",dataType = "int"),
            @ApiImplicitParam(name = "categoryDescription",value = "栏目描述",dataType = "String"),
            @ApiImplicitParam(name = "categoryName",value = "栏目名称",dataType = "String"),
            @ApiImplicitParam(name = "categoryOrder",value = "栏目序号",dataType = "int"),
            @ApiImplicitParam(name = "categoryParentId",value = "栏目所属的父栏目",dataType = "int")
    })
    public Result updateCategory(Category category){
        service.updateCategory(category);
        return ResultUtil.success();
    }





}
