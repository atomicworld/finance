/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.client.service;

import java.util.List;

import com.mf.client.entity.ClntEventMv;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2015-01-05
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface ClntEventMvService{

	public PageView query(PageView pageView,ClntEventMv clntEventMv);
	
	public List<ClntEventMv> queryAll(ClntEventMv clntEventMv);
	
	public void add(ClntEventMv clntEventMv);
	
	public void addAll(ClntEventMv clntEventMv);
	
	public void delete(String id);
	
	public void modify(ClntEventMv clntEventMv);
	
	public ClntEventMv getById(String id);
	
	public List<ClntEventMv> findAll();
	
	
}
