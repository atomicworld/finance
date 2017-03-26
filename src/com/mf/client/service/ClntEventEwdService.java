/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.client.service;

import java.util.List;

import com.mf.client.entity.ClntEventEwd;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2015-01-05
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface ClntEventEwdService{

	public PageView query(PageView pageView,ClntEventEwd clntEventEwd);
	
	public List<ClntEventEwd> queryAll(ClntEventEwd clntEventEwd);
	
	public void add(ClntEventEwd clntEventEwd);
	
	public void addAll(ClntEventEwd clntEventEwd);
	
	public void delete(String id);
	
	public void modify(ClntEventEwd clntEventEwd);
	
	public ClntEventEwd getById(String id);
	
	public List<ClntEventEwd> findAll();
	
	
}
