/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.pubparam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.pubparam.dao.CitiesDao;
import com.mf.pubparam.entity.Cities;
import com.mf.pubparam.service.CitiesService;
/**
 * @author xujiuhua
 * @2015-02-08
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("citiesService")
public class CitiesServiceImpl implements CitiesService {
	@Autowired
	private CitiesDao citiesDao;
	
	@Override
	public List<Cities> getCitybyParentId(String parentId) {
		return citiesDao.getByparentId(parentId);
	}
	//wyy
	@Override
	public Cities getById(String id){
		return citiesDao.getById(id);
	}
	
	
}
