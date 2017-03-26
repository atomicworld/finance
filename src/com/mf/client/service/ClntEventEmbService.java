/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.client.service;

import java.util.List;

import com.mf.client.entity.ClntEventEmb;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2015-01-05
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface ClntEventEmbService{

	public PageView query(PageView pageView,ClntEventEmb clntEventEmb);
	
	public List<ClntEventEmb> queryAll(ClntEventEmb clntEventEmb);
	
	public void add(ClntEventEmb clntEventEmb);
	
	public void addAll(ClntEventEmb clntEventEmb);
	
	public void delete(String id);
	
	public void modify(ClntEventEmb clntEventEmb);
	
	public ClntEventEmb getById(String id);
	
	public List<ClntEventEmb> findAll();
	
	
}
