package com.briup.smartcity.mapper.extend;

import com.briup.smartcity.bean.Article;
import com.briup.smartcity.bean.extend.ArticleExtend;

import java.util.List;

public interface ArticleExtendMapper {
    ArticleExtend selectArticleWithCategoryAndUser(int id);
    List<ArticleExtend> findAll(Article article);
    List<ArticleExtend> findAll2();
}



