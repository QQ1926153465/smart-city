package com.briup.smartcity.service;

import com.briup.smartcity.bean.BaseConfig;
import com.briup.smartcity.bean.BaseLog;
import com.github.pagehelper.PageInfo;

import java.awt.*;

public interface IBaseLogService {
    PageInfo<BaseLog> findAllByPageHepler(Integer pageNum,Integer pageSize);
}
