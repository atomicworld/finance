/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.service;

import java.util.List;

import com.mf.client.entity.ClntPersonJob;
import com.mf.util.PageView;

public interface ClntPersonJobService{

	public PageView query(PageView pageView,ClntPersonJob clntPersonJob);
	
	public List<ClntPersonJob> queryAll(ClntPersonJob clntPersonJob);
	
	public void add(ClntPersonJob clntPersonJob);
	
	public void delete(String id);
	
	public void modify(ClntPersonJob clntPersonJob);
	
	public ClntPersonJob getById(String id);
	
	public List<ClntPersonJob> findAll();
	
	
}
