package com.briup.smartcity.mapper;

import com.briup.smartcity.bean.BaseConfig;

public interface BaseConfigMapper {
    int deleteByPrimaryKey(Integer configId);

    int insert(BaseConfig record);

    int insertSelective(BaseConfig record);

    BaseConfig selectByPrimaryKey(Integer configId);

    int updateByPrimaryKeySelective(BaseConfig record);

    int updateByPrimaryKey(BaseConfig record);
}