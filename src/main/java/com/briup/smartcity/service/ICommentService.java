package com.briup.smartcity.service;

import com.briup.smartcity.bean.Comment;
import com.briup.smartcity.exception.ServiceException;
import com.github.pagehelper.PageInfo;

/**
 * 评论相关服务接口
 */
public interface ICommentService {
	// 审核评论，状态：0-待审核，1-不通过，2-通过
	void checkComment(int id,int status) throws ServiceException;

	// 分页查询所有评论
	PageInfo<Comment> pageQuery(int pageNum, int pageSize, String keywords);

	// 通过id删除评论
	int deleteById(int id) throws ServiceException;

	// 评论删除评论
	void batchDelete(int[] ids) throws ServiceException;
}

