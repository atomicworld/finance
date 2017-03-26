/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.service;

import java.util.List;

import com.mf.client.entity.ClntPersonFamily;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-16
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface ClntPersonFamilyService{

	public PageView query(PageView pageView,ClntPersonFamily clntPersonFamily);
	
	public List<ClntPersonFamily> queryAll(ClntPersonFamily clntPersonFamily);
	
	public void add(ClntPersonFamily clntPersonFamily);
	
	public void addAll(ClntPersonFamily clntPersonFamily);
	
	public void delete(String id);
	
	public void modify(ClntPersonFamily clntPersonFamily);
	
	public ClntPersonFamily getById(String id);
	
	public List<ClntPersonFamily> findAll();
	
	
}
