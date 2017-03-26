/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.flowmng.service;

import java.util.List;

import com.mf.flowmng.entity.FlowApprlBase;
import com.mf.util.PageView;

/**
 * @author shengd
 * @2015-01-09
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface FlowApprlBaseService{

	public PageView query(PageView pageView,FlowApprlBase flowApprlBase);
	
	public List<FlowApprlBase> queryAll(FlowApprlBase flowApprlBase);
	
	public void add(FlowApprlBase flowApprlBase);
	
	
	public void delete(String id);
	
	public void modify(FlowApprlBase flowApprlBase);
	
	public FlowApprlBase getById(String id);
	
	public List<FlowApprlBase> findAll();
	
	
}
