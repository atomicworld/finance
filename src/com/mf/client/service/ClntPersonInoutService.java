/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.service;

import java.util.List;

import com.mf.client.entity.ClntPersonInout;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-16
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface ClntPersonInoutService{

	public PageView query(PageView pageView,ClntPersonInout clntPersonInout);
	
	public List<ClntPersonInout> queryAll(ClntPersonInout clntPersonInout);
	
	public void add(ClntPersonInout clntPersonInout);
	
	public void addAll(ClntPersonInout clntPersonInout);
	
	public void delete(String id);
	
	public void modify(ClntPersonInout clntPersonInout);
	
	public ClntPersonInout getById(String id);
	
	public List<ClntPersonInout> findAll();
	
	
}
