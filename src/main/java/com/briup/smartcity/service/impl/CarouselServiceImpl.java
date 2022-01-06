package com.briup.smartcity.service.impl;

import com.briup.smartcity.bean.Carousel;
import com.briup.smartcity.exception.ServiceException;
import com.briup.smartcity.mapper.CarouselMapper;
import com.briup.smartcity.mapper.extend.CarouselExtendMapper;
import com.briup.smartcity.service.ICarouselService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarouselServiceImpl implements ICarouselService {
    @Autowired
    private CarouselMapper mapper;

    @Autowired
    private CarouselExtendMapper extendMapper;

    @Override
    public PageInfo<Carousel> findAll(int pageNum, int pageSize) throws ServiceException {
        PageHelper.startPage(pageNum,pageSize,true);
        List<Carousel> carousels = mapper.findallCarousel();
        PageInfo<Carousel> pageInfo = new PageInfo<>(carousels);
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
            mapper.insert(carousel);
    }

    @Override
    public void updateCarousel(Carousel carousel) throws ServiceException {
        Integer id = carousel.getCarouselId();

        Carousel carousel1 = mapper.selectByPrimaryKey(id);
        if (carousel1==null){
            throw new ServiceException("id不存在，无法更新");
        }
        mapper.updateByPrimaryKeySelective(carousel);
//        List<Carousel> c= mapper.findallCarousel();
//        for (int i = 0; i < c.size(); i++) {
//            Integer idd = c.get(i).getCarouselId();
//            if (id==(idd))
//            {
//                Integer status = carousel.getCarouselStatus();
//                if (status==1){
//                    List<Carousel> s = extendMapper.findyesCarousel();
//                    if (s.size()==1) {
//                        throw new ServiceException("有其他配置处于启动状态，无法更新");
//                    }
//                }
//                mapper.updateByPrimaryKey(carousel);
//                  break;
//            }
//            else{
//                throw new ServiceException("id不存在");
        }

//        }




    @Override
    public List<Carousel> findYesCarousel() throws ServiceException {
        List<Carousel> yesCarousel = mapper.findYesCarousel();
        return yesCarousel;
    }
}
