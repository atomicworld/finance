/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.service;

import java.util.List;

import com.mf.client.entity.ClntPersonEvaluate;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-18
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface ClntPersonEvaluateService{

	public PageView query(PageView pageView,ClntPersonEvaluate clntPersonEvaluate);
	
	public List<ClntPersonEvaluate> queryAll(ClntPersonEvaluate clntPersonEvaluate);
	
	public void add(ClntPersonEvaluate clntPersonEvaluate);
	
	public void addAll(ClntPersonEvaluate clntPersonEvaluate);
	
	public void delete(String id);
	
	public void modify(ClntPersonEvaluate clntPersonEvaluate);
	
	public ClntPersonEvaluate getById(String id);
	
	public List<ClntPersonEvaluate> findAll();
	
	
}
