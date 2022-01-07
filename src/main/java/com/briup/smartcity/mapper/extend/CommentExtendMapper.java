package com.briup.smartcity.mapper.extend;

import com.briup.smartcity.bean.Comment;

import java.util.List;

public interface CommentExtendMapper {
    //第13分钟
    //分页查询评论信息
    List<Comment> selectAllCommentByKeyword(String keyword);
    //审核评论状态
    void checkComment(int id,int status);

    //批量删除评论
    void deleteCommentBySomeId(int[] ids);

}
