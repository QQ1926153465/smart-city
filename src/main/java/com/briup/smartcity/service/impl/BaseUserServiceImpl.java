package com.briup.smartcity.service.impl;

import com.briup.smartcity.bean.BaseUser;
import com.briup.smartcity.exception.ServiceException;
import com.briup.smartcity.mapper.BaseUserMapper;
import com.briup.smartcity.mapper.extend.BaseUserExtendMapper;
import com.briup.smartcity.service.IBaseUserService;
import com.briup.smartcity.utils.JwtUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class BaseUserServiceImpl implements IBaseUserService  {
    @Autowired
    private BaseUserMapper mapper;
    //当逆向工程生成的映射接口不满足功能要求，程序员自定义接口
    @Autowired
    private BaseUserExtendMapper extendMapper;
    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return token字符串
     * @throws ServiceException 自定义异常
     */
    @Override
    public String login(String username, String password) throws ServiceException {

        BaseUser user = extendMapper.selectBaseUserByUsername(username);
        //1.user==null
        if (user==null){
            //不存在
            throw new ServiceException("用户名不存在");
        }
        if (!user.getPassword().equals(password)){
            //密码错误
            throw new ServiceException("密码错误");
        }
//        账号被锁定
        if (user.getStatus()==1){
            throw new ServiceException(" 账号被锁定");
        }

        //通过逻辑判断，登录成功，返回token
        HashMap<String, Object> userInfo = new HashMap<>();
        userInfo.put("role",user.getRole());
        userInfo.put("userId",user.getUserId());
        userInfo.put("realName",user.getRealname());


        return JwtUtil.sign(username,userInfo);
    }

    /**
     * 通过token获取当前登录用户的信息
     *
     * @param token
     * @return
     * @throws ServiceException
     */
    @Override
    public BaseUser currentUserInfo(String token) throws ServiceException {
        return null;
    }

    /**
     * 分页查询用户信息
     *
     * @param pageNum
     * @param pageSize
     * @param username
     * @param role
     * @return
     * @throws ServiceException
     */
    @Override
    public PageInfo<BaseUser> pageQuery(int pageNum, int pageSize, String username, Integer role) throws ServiceException {
        return null;
    }

    /**
     * 更新用户信息
     *
     * @param baseUser
     * @throws ServiceException
     */
    @Override
    public void updateUser(BaseUser baseUser) throws ServiceException {

    }

    /**
     * 更新用户信息
     *
     * @param id
     * @param alterUserIcon
     * @throws ServiceException
     */
    @Override
    public void updateUserIcon(int id, String alterUserIcon) throws ServiceException {

    }
}
