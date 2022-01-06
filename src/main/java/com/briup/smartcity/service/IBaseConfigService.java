package com.briup.smartcity.service;

import com.briup.smartcity.bean.BaseConfig;
import com.briup.smartcity.exception.ServiceException;
import com.github.pagehelper.PageInfo;

/**
 * 基础配置相关接口
 */
public interface IBaseConfigService {
	/**
	 * 保存配置信息
	 */
	void saveConfig(BaseConfig baseConfig) throws ServiceException;

	/**
	 * 更新配置信息
	 */
	void updateConfig(BaseConfig baseConfig) throws ServiceException;

	/**
	 * 改变配置信息的状态
	 */
	void changeConfigStatus(int id,int status) throws ServiceException;

	/**
	 * 根据id删除
	 */
	int deleteById(int id) throws ServiceException;
	
	/**
	 * 分页询所有配置信息
	 */
	PageInfo<BaseConfig> findAllWithPage(int pageNum, int pageSize) throws ServiceException;

	/**
	 * 查找当前启用的配置信息
	 */
    BaseConfig currentConfigYes() throws ServiceException;
}
