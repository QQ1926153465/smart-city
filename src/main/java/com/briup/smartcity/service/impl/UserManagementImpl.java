package com.briup.smartcity.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.briup.smartcity.bean.BaseUser;
import com.briup.smartcity.exception.ServiceException;
import com.briup.smartcity.mapper.BaseUserMapper;
import com.briup.smartcity.mapper.extend.BaseUserExtendMapper;
import com.briup.smartcity.service.IUserManagementService;
import com.briup.smartcity.utils.JwtUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserManagementImpl implements IUserManagementService {
    @Autowired
    private BaseUserMapper mapper;
    @Autowired
    private BaseUserExtendMapper extendMapper;


    @Autowired
    private BaseUser user;


    @Override
    public int deleteUserById(Integer id) {
        int i = mapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public PageInfo<BaseUser> findUserByPageHelperLike(Integer pageNum, Integer pageSize,String username,Integer role) {
        PageHelper.startPage(pageNum,pageSize,true);
        List<BaseUser> users = mapper.findUserByPageHelperLike(username,role);
        PageInfo<BaseUser> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }   

    @Override
    public BaseUser findUserByToken() {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        String token = request.getHeader("authorization");
//        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhZG1pbiIsImV4cCI6MTY0MTI1ODcwNCwiaW5mbyI6eyJyZWFsTmFtZSI6IuWImOS6muiTiSIsInVzZXJuYW1lIjoiYWRtaW4ifX0.UQmrE-k2NDTL11xgTwpc04XdOfbmV-0rJz2PHrTVAJs";

        String userId = JwtUtil.getUserId(token);

        BaseUser user = extendMapper.selectBaseUserByUsername(userId);

        return user;
    }

    @Override
    public int UpdateUserByUserName(BaseUser user) {

        int i = mapper.updateByUsernameSelective(user);
        return i;
    }

    @Override
    public int UpdataUserIconById(Integer id,String icon) {
        user.setUserId(id);
        user.setIcon(icon);
        int i = mapper.updateByPrimaryKeySelective(user);
        return i;
    }

    @Override
    public int UpdataUserStatusById(Integer id, Integer status) {
        user.setUserId(id);
        user.setStatus(status);

        int i = mapper.updateByPrimaryKeySelective(user);


        return i;
    }
}