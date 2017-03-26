/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.client.service;

import java.util.List;

import com.mf.client.entity.ClntEventInst;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2015-01-05
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface ClntEventInstService{

	public PageView query(PageView pageView,ClntEventInst clntEventInst);
	
	public List<ClntEventInst> queryAll(ClntEventInst clntEventInst);
	
	public void add(ClntEventInst clntEventInst);
	
	public void addAll(ClntEventInst clntEventInst);
	
	public void delete(String id);
	
	public void modify(ClntEventInst clntEventInst);
	
	public ClntEventInst getById(String id);
	
	public List<ClntEventInst> findAll();
	
	
}
