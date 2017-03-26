/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.client.service;

import java.util.List;

import com.mf.client.entity.ClntEventOther;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2015-01-05
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface ClntEventOtherService{

	public PageView query(PageView pageView,ClntEventOther clntEventOther);
	
	public List<ClntEventOther> queryAll(ClntEventOther clntEventOther);
	
	public void add(ClntEventOther clntEventOther);
	
	public void addAll(ClntEventOther clntEventOther);
	
	public void delete(String id);
	
	public void modify(ClntEventOther clntEventOther);
	
	public ClntEventOther getById(String id);
	
	public List<ClntEventOther> findAll();
	
	
}
