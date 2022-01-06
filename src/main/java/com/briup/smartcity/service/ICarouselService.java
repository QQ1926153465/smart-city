package com.briup.smartcity.service;

import com.briup.smartcity.bean.Carousel;
import com.briup.smartcity.exception.ServiceException;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 轮播图相关接口
 */
public interface ICarouselService {

    // 分页查询轮播图信息
    PageInfo<Carousel> findAll(int pageNum, int pageSize)throws ServiceException;

    // 通过id删除轮播图信息
    int deleteById(int id) throws ServiceException;

    // 保存轮播图信息
    void saveCarousel(Carousel carousel)throws ServiceException;

    // 更新轮播图信息
    void updateCarousel(Carousel carousel)throws ServiceException;

    // 查询所有已经启用的轮播图
    List<Carousel> findYesCarousel()throws ServiceException;
}
