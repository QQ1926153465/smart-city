package com.briup.smartcity.service;

import java.io.IOException;
import java.util.List;

import com.briup.smartcity.bean.Carousel;
import com.briup.smartcity.exception.ServiceException;
import com.github.pagehelper.PageInfo;

/**
 * 轮播图相关接口
 */
public interface ICarouselService {

    // 分页查询轮播图信息
    PageInfo<Carousel> findAll(int pageNum, int pageSize) throws ServiceException;

    // 通过id删除轮播图信息
    void deleteById(int id) throws ServiceException;

    // 保存轮播图信息
    void saveCarousel(Carousel carousel)throws ServiceException;

    // 更新轮播图信息
    int updateCarousel(Carousel carousel)throws ServiceException;

    // 查询所有已经启用的轮播图
    List<Carousel> findYesCarousel()throws ServiceException;

    int SaveCarousel(Carousel carousel);

}
