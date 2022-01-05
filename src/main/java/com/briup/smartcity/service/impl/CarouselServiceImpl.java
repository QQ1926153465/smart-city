package com.briup.smartcity.service.impl;

import com.briup.smartcity.bean.Carousel;
import com.briup.smartcity.exception.ServiceException;
import com.briup.smartcity.mapper.CarouselMapper;
import com.briup.smartcity.service.ICarouselService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class CarouselServiceImpl implements ICarouselService {
    @Autowired
    private CarouselMapper mapper;

    @Override
    public PageInfo<Carousel> findAll(int pageNum, int pageSize) throws ServiceException {
        //1.设置分页信息
        PageHelper.startPage(pageNum,pageSize,true);
        //2.执行分页查询
        List<Carousel> list = mapper.findAllCarousel();
        PageInfo<Carousel> pageInfo = new PageInfo<>(list);
        //3.获取查询数据
        System.out.println("分页数据："+pageInfo.getList());
        System.out.println("分页数量："+pageInfo.getPageSize());
        System.out.println("当前页数："+pageInfo.getPageNum());

        return pageInfo;
    }

    @Override
    public int deleteById(int id) throws ServiceException {
        int i = mapper.deleteByPrimaryKey(id);
        if (i==0){
            throw new ServiceException("轮播图不存在");
        }
        return i;
    }

    @Override
    public void saveCarousel(Carousel carousel) throws ServiceException {

    }

    @Override
    public int updateCarousel(Carousel carousel) throws ServiceException {
        int i = mapper.updateByPrimaryKeySelective(carousel);
        if (i==0){
            throw new ServiceException("id不存在");
        }
        return i;
    }

    @Override
    public List<Carousel> findYesCarousel() throws ServiceException {
        List<Carousel> allCarousel = mapper.findYesCarousel();

        return allCarousel;
    }

    @Override
    public int SaveCarousel(Carousel carousel) {

        int i = mapper.insertSelective(carousel);

        return i;
    }


}
