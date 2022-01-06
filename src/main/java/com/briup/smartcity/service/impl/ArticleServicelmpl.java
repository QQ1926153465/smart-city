package com.briup.smartcity.service.impl;

import com.briup.smartcity.bean.Article;
import com.briup.smartcity.bean.extend.ArticleExtend;
import com.briup.smartcity.exception.ServiceException;
import com.briup.smartcity.mapper.ArticleMapper;
import com.briup.smartcity.mapper.extend.ArticleExtendMapper;
import com.briup.smartcity.service.IArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArticleServicelmpl implements IArticleService {
    @Autowired
    private ArticleMapper mapper;
    @Autowired
    private ArticleExtendMapper extendMapper;
//    @Autowired
//    private ArticleExtend articleExtend;
    @Autowired
    private Article article;
    @Override
    public ArticleExtend findByIdWithCategoryAndUser(int id) throws ServiceException {
        ArticleExtend articleExtend = extendMapper.selectArticleWithCategoryAndUser(id);
        return articleExtend;

    }

    @Override
    public void saveOrUpdate(Article article) throws ServiceException {
        if(article.getArticleId()==null)
            mapper.insertSelective(article);
        else
            mapper.updateByPrimaryKeySelective(article);


    }
    @Override
    public PageInfo<ArticleExtend> pageQueryArticleWithCategoryAndUser(int pageNum, int pageSize,Article article) throws ServiceException {

//        ArticleExtend articleExtend = new ArticleExtend();
//        PageHelper.startPage(pageNum,pageSize,true);
//        List<ArticleExtend> li = extendMapper.findAll(article);
//        PageInfo<ArticleExtend> articlePageInfo = new PageInfo<>(li);
//        return articlePageInfo;
        PageHelper.startPage(pageNum,pageSize,true);

        List<ArticleExtend> li = extendMapper.findAll(article);
        System.out.println(li);
        PageInfo<ArticleExtend> articlePageInfo = new PageInfo<>(li);


        return articlePageInfo;





    }

    @Override
    public void deleteById(int id) throws ServiceException {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo<ArticleExtend> pageQueryRecommend(int pageNum, int pageSize ) throws ServiceException {
//        ArticleExtend articleExtend = new ArticleExtend();
//        PageHelper.startPage(pageNum,pageSize,true);
//        List<ArticleExtend> li = extendMapper.findAll(article);
//        PageInfo<ArticleExtend> articlePageInfo = new PageInfo<>(li);
//
        return null;

    }

    @Override
    public void changeStatus(int id, int status) throws ServiceException {

        article.setArticleId(id);
        article.setArticleStatus(status);
        mapper.updateByPrimaryKeySelective(article);



    }
}
