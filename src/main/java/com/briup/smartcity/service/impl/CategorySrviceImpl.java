package com.briup.smartcity.service.impl;

import com.briup.smartcity.bean.Category;
import com.briup.smartcity.exception.ServiceException;
import com.briup.smartcity.mapper.CategoryMapper;
import com.briup.smartcity.mapper.extend.CategoryExtendMapper;
import com.briup.smartcity.service.ICategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategorySrviceImpl implements ICategoryService {
    @Autowired
    private CategoryMapper mapper;
    @Autowired
    private CategoryExtendMapper extendMapper;
    @Override
    public PageInfo<Category> pageQueryAll(int pageNum, int pageSize) throws ServiceException {
        //1、设置分页信息
        PageHelper.startPage(pageNum,pageSize,true);
        List<Category> list = extendMapper.findAllCategory();
        return new PageInfo<>(list);
    }

    @Override
    public void deleteById(int id) throws ServiceException {
        /*调用mapper对象执行删除的sql语句
        1、简单的操作，只需要调用逆向工程生成的
         */
        List<Category> list = extendMapper.findAllCategory();
        for (Integer i = 0; i < list.size(); i++) {
            if (list.get(i).getCategoryParentId() != null && id == list.get(i).getCategoryParentId()) {
                throw new ServiceException("该栏目有子栏目，请先删除其子栏目");
            }
        }
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void batchDelete(int[] ids) throws ServiceException {
        List<Category> list = extendMapper.findAllCategory();
        for (Integer i = 0; i < list.size(); i++) {
            for (int j = 0; j < ids.length; j++) {
                if (list.get(i).getCategoryParentId() != null && ids[j] == list.get(i).getCategoryParentId()) {
                    throw new ServiceException("这些栏目中有的栏目有子栏目，请先删除其子栏目");
                }
            }
        }
        extendMapper.batchDeleteCategroy(ids);
    }

    @Override
    public void saveCategory(Category category) throws ServiceException {
        String categoryName = category.getCategoryName();
        List<Category> list = extendMapper.findAllCategory();
        if (categoryName == null){
            throw new ServiceException("栏目名称不能为空");
        }
        for (Integer i = 0; i < list.size(); i++) {
            if (list.get(i).getCategoryName().equals(categoryName)) {
                throw new ServiceException("该栏目名称已存在");
            }
        }
        mapper.insertSelective(category);
    }

    @Override
    public void updateCategory(Category category) throws ServiceException {
        int num = 0;
        Integer categoryId = category.getCategoryId();
        String categoryName = category.getCategoryName();
        List<Category> list = extendMapper.findAllCategory();
        List<Category> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCategoryId() != categoryId ) {
                list1.add(list.get(i));
            }
        }
        for (int j = 0; j < list1.size(); j++) {
            if (list1.get(j).getCategoryName().equals(categoryName)){
                throw new ServiceException("该栏目已存在");
            }

        }

        mapper.updateByPrimaryKeySelective(category);
}

    @Override
    public List<Category> findAll() throws ServiceException {
        return extendMapper.findAllCategory();
    }
}
