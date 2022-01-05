package com.briup.smartcity.service;

import com.briup.smartcity.bean.Category;
import com.briup.smartcity.exception.ServiceException;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 栏目信息相关接口
 */
public interface ICategoryService {
    // 分页查询栏目信息
    PageInfo<Category> pageQueryAll(int pageNum, int pageSize) throws ServiceException;

    // 通过id删除栏目
    void deleteById(int id) throws ServiceException;

    // 批量删除栏目
    void batchDelete(int[] ids) throws ServiceException;

    // 保存栏目信息
    void saveCategory(Category category) throws ServiceException;

    // 更新栏目信息
    void updateCategory(Category category) throws ServiceException;

    // 查询所有栏目信息，不分页
    List<Category> findAll() throws ServiceException;
}
