package com.briup.smartcity.mapper;

import com.briup.smartcity.bean.BaseUser;

import java.util.List;

public interface BaseUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(BaseUser record);

    int insertSelective(BaseUser record);

    BaseUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(BaseUser record);

    int updateByUsernameSelective(BaseUser record);

    int updateByPrimaryKey(BaseUser record);

    List<BaseUser> findAll();

    List<BaseUser> findUserByPageHelperLike(String username,Integer role);

}