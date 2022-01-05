package com.briup.smartcity.service.impl;

import com.briup.smartcity.bean.Comment;
import com.briup.smartcity.exception.ServiceException;
import com.briup.smartcity.mapper.CommentMapper;
import com.briup.smartcity.mapper.extend.CommentExtendMapper;
import com.briup.smartcity.service.ICommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class CommentServicelmpl implements ICommentService{
    @Autowired
    private CommentMapper mapper;
    @Autowired
    private CommentExtendMapper extendMapper;

    @Override
    public void checkComment(int id, int status) throws ServiceException {
        //审核评论状态
        extendMapper.checkComment(id,status);
    }

    @Override
    public PageInfo<Comment> pageQuery(int pageNum, int pageSize, String keywords) {
        //查询语句
        //PageHelper.startPage(pageNum,pageSize.true);
        PageHelper.startPage(pageNum, pageSize, true);
        List<Comment> list = extendMapper.selectAllCommentByKeyword(keywords);
        return new PageInfo<>(list);

    }

    @Override
    public int deleteById(int id) throws ServiceException {
        //删除
        int i = mapper.deleteByPrimaryKey(id);
        if (i==0){
            throw new ServiceException("id不存在");
        }
        return i;
    }

    @Override
    public void batchDelete(int[] ids) throws ServiceException {
        //批量删除
        extendMapper.deleteCommentBySomeId(ids);
    }
}
