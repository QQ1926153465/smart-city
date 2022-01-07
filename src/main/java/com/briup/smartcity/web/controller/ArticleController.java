package com.briup.smartcity.web.controller;

import com.briup.smartcity.aop.Logging;
import com.briup.smartcity.bean.Article;
import com.briup.smartcity.bean.extend.ArticleExtend;
import com.briup.smartcity.service.IArticleService;
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
@Logging()
@Api(tags = "资讯信息管理模块")
@RestController
public class ArticleController {
    @Autowired
    private IArticleService service;
    @Logging()
    @ApiOperation("通过id删除")
    @DeleteMapping("/auth/article/deleteById")
    public Result deleteById(int id){
        service.deleteById(id);
        return ResultUtil.success();
    }

    @Logging()
    @ApiOperation("通过ID获取资讯详情")
    @GetMapping("/auth/article/findById")
    public  Result SelectById(int id){
        ArticleExtend articleExtend = (ArticleExtend) service.findByIdWithCategoryAndUser(id);
        return  ResultUtil.success(articleExtend);
    }

    @Logging()
    @ApiOperation("通过id更新状态")
    @PutMapping("/auth/article/changeStatus")
    public  Result changeStatus(Integer id,Integer status){
        service.changeStatus(id,status);
        return ResultUtil.success(status);
    }
    @Logging()
    @ApiOperation("更新保存信息")
    @PostMapping("/auth/article/saveOrUpdate")
    public Result saveOrUpdate(Article article){
        service.saveOrUpdate(article);
        return ResultUtil.success();
    }




    @ApiOperation("通过标题、状态、栏目分页查找资讯信息")

    @GetMapping("/auth/article/page/queryWithCategoryAndUser")
//,String title,Integer status,Integer categoryId
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title",value = "title",dataType = "String"),
            @ApiImplicitParam(name = "status",value = "status",dataType = "int"),
            @ApiImplicitParam(name = "categoryId",value = "categoryId",dataType = "int"),
    }
    )
    public Result pageByLike(Integer pageNum, Integer pageSize, String title,Integer status,Integer categoryId){

        Article article = new Article();
        article.setArticleCategoryId(categoryId);
        article.setArticleTitle(title);
        article.setArticleStatus(status);

        PageInfo<ArticleExtend> pageInfo = service.pageQueryArticleWithCategoryAndUser(pageNum, pageSize,article);
        return ResultUtil.success(pageInfo);
    }
//    @GetMapping ("/auth/category/find/all")
//    public  Result Aaaa(int pageNum, int pageSize ){
//        PageInfo<ArticleExtend> pageInfo = service.pageQueryRecommend(pageNum,pageSize);
//        return ResultUtil.success(pageInfo);
//
//    }
}

