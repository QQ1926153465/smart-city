package com.briup.smartcity.service.impl;

import com.briup.smartcity.bean.BaseConfig;
import com.briup.smartcity.exception.ServiceException;
import com.briup.smartcity.mapper.BaseConfigMapper;
import com.briup.smartcity.mapper.extend.BaseConfigExtendMapper;
import com.briup.smartcity.service.IBaseConfigService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseConfigServiceImp implements IBaseConfigService {
    @Autowired
    private BaseConfigMapper mapper;
    @Autowired
    private BaseConfigExtendMapper extendMapper;

    @Override
    public void saveConfig(BaseConfig baseConfig) throws ServiceException {
        Integer status = baseConfig.getConfigStatus();
        if(status==1) {
            List<BaseConfig>baseConfigs =extendMapper.findAllStatusYes();
            if (baseConfigs.size()==1) {
                throw new ServiceException("无法保存，有其他配置处于启动状态");
            }
        }
            mapper.insert(baseConfig);

    }

    @Override
    public void updateConfig(BaseConfig baseConfig) throws ServiceException {
        List<BaseConfig> baseConfigss = mapper.fingdAllByPageHeple();
        Integer id =baseConfig.getConfigId();
        for(int i=0;i<baseConfigss.size();i++)
        {
            if(id == baseConfigss.get(i).getConfigId())
            {
                Integer status = baseConfig.getConfigStatus();
                if (status==1) {
                    List<BaseConfig> baseConfigs =extendMapper.findAllStatusYes();
                    if (baseConfigs.size()==1) {
                        throw new ServiceException("无法更新，有其他配置处于启动状态");
                    }
                }
                mapper.updateByPrimaryKey(baseConfig);
                break;
            }
            else{
            throw new ServiceException("id不存在");
        }

        }

    }

    @Override
    public void changeConfigStatus(int id, int status) throws ServiceException {
        List<BaseConfig> baseConfigss = mapper.fingdAllByPageHeple();
        for(int i=0;i<baseConfigss.size();i++)
        {
            if(id == baseConfigss.get(i).getConfigId())
            {
                if (status==1){
                    List<BaseConfig> baseConfigs = extendMapper.findAllStatusYes();
                    if(baseConfigs.size()==1){
                        throw new ServiceException("无法更新,有其他配置处于启动状态");
                    }
                }
                mapper.upcongficstatus(id, status);
                break;
            }
            throw new ServiceException("id不存在");
        }
    }

    @Override
    public int deleteById(int id)  throws ServiceException {


        int i = mapper.deleteByPrimaryKey(id);
        if ( i==0 ){

            throw new ServiceException("id不存在");
        }
        return i;

    }

    @Override
    public PageInfo<BaseConfig> findAllWithPage(int pageNum, int pageSize) throws ServiceException {


        PageHelper.startPage(pageNum,pageSize,true);

        List<BaseConfig> configs = mapper.fingdAllByPageHeple();

        PageInfo<BaseConfig> pageInfo = new PageInfo<>(configs);

        return pageInfo;
    }

    @Override
    public BaseConfig currentConfigYes() throws ServiceException{
        BaseConfig baseConfig = mapper.YesBaseConfig();

        return baseConfig;

    }
}
