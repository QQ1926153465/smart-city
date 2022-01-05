package com.briup.smartcity.service.impl;

import com.briup.smartcity.bean.BaseLog;
import com.briup.smartcity.mapper.BaseLogMapper;
import com.briup.smartcity.mapper.extend.BaseLogExtendMapper;
import com.briup.smartcity.service.IBaseLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseLogServiceImpl implements IBaseLogService {
    @Autowired
    private BaseLogMapper mapper;
    @Autowired
    private BaseLogExtendMapper extendMapper;

    @Override
    public PageInfo<BaseLog> findAllByPageHepler(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<BaseLog> list = extendMapper.findAll();
        PageInfo<BaseLog> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
