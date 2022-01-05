package com.briup.smartcity.service;

import com.briup.smartcity.bean.BaseUser;
import com.briup.smartcity.exception.ServiceException;
import com.github.pagehelper.PageInfo;

/**
 * 用户相关接口
 */
public interface IBaseUserService {

    /**
     * 用户登录
     * @param username  用户名
     * @param password 密码
     * @return token字符串
     * @throws ServiceException  自定义异常
     */
    String login(String username,String password)throws ServiceException;

    /**
     * 通过token获取当前登录用户的信息
     * @param token
     * @return
     * @throws ServiceException
     */
    BaseUser currentUserInfo(String token) throws ServiceException;

    /**
     * 分页查询用户信息
     * @param pageNum
     * @param pageSize
     * @param username
     * @param role
     * @return
     * @throws ServiceException
     */
    PageInfo<BaseUser> pageQuery(int pageNum, int pageSize, String username, Integer role) throws ServiceException;

    /**
     * 更新用户信息
     * @param baseUser
     * @throws ServiceException
     */
    void updateUser(BaseUser baseUser) throws ServiceException;

    /**
     * 更新用户信息
     * @param id
     * @param alterUserIcon
     * @throws ServiceException
     */
    void updateUserIcon(int id, String alterUserIcon) throws ServiceException;
}
