package com.briup.smartcity.bean;

import java.util.Date;

public class Article {
    private Integer articleId;

    private String articleTitle;

    private String articleContent;

    private Date articlePublishTime;

    private Integer articleReadTimes;

    private Integer articleStatus;

    private Integer articleThumpUp;

    private String articleCover;

    private Integer articleUserId;

    private Integer articleCategoryId;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Date getArticlePublishTime() {
        return articlePublishTime;
    }

    public void setArticlePublishTime(Date articlePublishTime) {
        this.articlePublishTime = articlePublishTime;
    }

    public Integer getArticleReadTimes() {
        return articleReadTimes;
    }

    public void setArticleReadTimes(Integer articleReadTimes) {
        this.articleReadTimes = articleReadTimes;
    }

    public Integer getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(Integer articleStatus) {
        this.articleStatus = articleStatus;
    }

    public Integer getArticleThumpUp() {
        return articleThumpUp;
    }

    public void setArticleThumpUp(Integer articleThumpUp) {
        this.articleThumpUp = articleThumpUp;
    }

    public String getArticleCover() {
        return articleCover;
    }

    public void setArticleCover(String articleCover) {
        this.articleCover = articleCover;
    }

    public Integer getArticleUserId() {
        return articleUserId;
    }

    public void setArticleUserId(Integer articleUserId) {
        this.articleUserId = articleUserId;
    }

    public Integer getArticleCategoryId() {
        return articleCategoryId;
    }

    public void setArticleCategoryId(Integer articleCategoryId) {
        this.articleCategoryId = articleCategoryId;
    }
}