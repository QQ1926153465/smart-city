package com.briup.smartcity.mapper.extend;

import com.briup.smartcity.bean.Category;

import java.util.List;

public interface CategoryExtendMapper {
    List<Category> findAllCategory();
    int batchDeleteCategroy(int[] ids);
}
