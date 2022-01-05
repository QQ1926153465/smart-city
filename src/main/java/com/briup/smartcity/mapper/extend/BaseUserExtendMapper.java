package com.briup.smartcity.mapper.extend;

import com.briup.smartcity.bean.BaseUser;

public interface BaseUserExtendMapper {

    BaseUser selectBaseUserByUsername(String username);

}
