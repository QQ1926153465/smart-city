package com.briup.smartcity.web.controller;

import com.briup.smartcity.bean.Comment;
import com.briup.smartcity.service.ICommentService;
import com.briup.smartcity.utils.Result;
import com.briup.smartcity.utils.ResultUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "评论管理")
@RestController
@RequestMapping("/auth/comment")
public class CommentController {

    @Autowired
    private ICommentService service;

    @ApiOperation("分页查询评论信息")
    @GetMapping(value = "/pageQuery")
    @ApiImplicitParams({@ApiImplicitParam(
            name = "pageNum",
            value = "当前页码",
            dataType = "int"
    ), @ApiImplicitParam(
            name = "pageSize",
            value = "分页大小",
            dataType = "int"
    ), @ApiImplicitParam(
            name = "keywords",
            value = "评论内容关键字",
            dataType = "String"
    )})
    public Result pageQuery( int pageNum, int pageSize,String keywords) {
        PageInfo<Comment> pageInfo = service.pageQuery(pageNum,pageSize,keywords);
        return ResultUtil.success(pageInfo);
    }


    @ApiOperation("审核评论状态")
    @PutMapping(value = "/check")
    @ApiImplicitParams({@ApiImplicitParam(
            name = "id",
            value = "评论编号"
    ), @ApiImplicitParam(
            name = "id",
            value = "审核状态：0-待审核，1-不通过，2-通过"
    )})
    public Result checkComment(int id, Integer status) {
        service.checkComment(id,status);
        return ResultUtil.success();
    }


    @ApiOperation("批量删除评论")
    @DeleteMapping(value = "/batchDelete")
    @ApiImplicitParams({@ApiImplicitParam(
            name = "ids",
            value = "评论编号",
            dataType = "int",
            allowMultiple = true
    )})
    public Result batchDelete(int[] ids) {
        service.batchDelete(ids);
        return ResultUtil.success();
    }

    @ApiOperation("通过id删除评论信息")
    @DeleteMapping(value = "/deleteById")
    @ApiImplicitParams({@ApiImplicitParam(
            name = "id",
            value = "评论编号",
            dataType = "int"
    )})
    public Result deleteById(int id) {
        int i = service.deleteById(id);
        return ResultUtil.success(i);
    }
}

