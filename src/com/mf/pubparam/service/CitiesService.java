/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.pubparam.service;

import java.util.List;

import com.mf.pubparam.entity.Cities;
/**
 * @author xujiuhua
 * @2015-02-08
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface CitiesService{

	public List<Cities> getCitybyParentId(String parentId);
	
	public Cities getById(String id);
	
	
}
