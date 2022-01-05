package com.briup.smartcity.service;

import com.briup.smartcity.bean.BaseUser;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IUserManagementService {
    int deleteUserById(Integer id);

    PageInfo<BaseUser> findUserByPageHelperLike(Integer pageNum, Integer pageSize, String username, Integer role);

    BaseUser findUserByToken();

    int UpdateUserByUserName(BaseUser user);

    int UpdataUserIconById(Integer id, String icon);

    int UpdataUserStatusById(Integer id,Integer status);
}
