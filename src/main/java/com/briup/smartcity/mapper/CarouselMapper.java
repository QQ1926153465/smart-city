package com.briup.smartcity.mapper;

import com.briup.smartcity.bean.Carousel;

import java.util.List;

public interface CarouselMapper {
    int deleteByPrimaryKey(Integer carouselId);

    List<Carousel> findYesCarousel();

    int insert(Carousel record);

    int insertSelective(Carousel record);

    Carousel selectByPrimaryKey(Integer carouselId);

    int updateByPrimaryKeySelective(Carousel record);

    int updateByPrimaryKey(Carousel record);

    List<Carousel> findallCarousel();
}