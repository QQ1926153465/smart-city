package com.briup.smartcity.service;

import com.briup.smartcity.bean.Article;
import com.briup.smartcity.bean.extend.ArticleExtend;
import com.briup.smartcity.exception.ServiceException;
import com.github.pagehelper.PageInfo;

/**
 * 资讯信息服务相关接口
 */
public interface IArticleService {

	// 通过id查询咨询信息，同时获取咨询对应的栏目和用户信息
	ArticleExtend findByIdWithCategoryAndUser(int id) throws ServiceException;

    // 保存或更新咨询信息
    void saveOrUpdate(Article article) throws ServiceException;

    // 分页查询咨询信息，同时获取咨询对应的栏目和用户信息
	PageInfo<ArticleExtend> pageQueryArticleWithCategoryAndUser(int pageNum, int pageSize,Article article) throws ServiceException;

	// 通过id删除咨询信息
  	void deleteById(int id) throws ServiceException;

	// 分页查询推荐被推荐的咨询信息，同时获取咨询对应的栏目和用户信息
	PageInfo<ArticleExtend> pageQueryRecommend(int pageNum, int pageSize ) throws ServiceException;

	// 修改咨询信息的状态，状态：0-待审核，1-不通过，2-通过，3-推荐
  	void changeStatus(int id,int status) throws ServiceException;




}
