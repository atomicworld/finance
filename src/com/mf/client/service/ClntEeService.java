/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.service;

import java.util.List;

import com.mf.client.entity.ClntEe;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-24
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface ClntEeService{

	public PageView query(PageView pageView,ClntEe clntEe);
	
	public List<ClntEe> queryAll(ClntEe clntEe);
	
	public void add(ClntEe clntEe);
	
	public void addAll(ClntEe clntEe);
	
	public void delete(String id);
	
	public void modify(ClntEe clntEe);
	
	public ClntEe getById(String id);
	
	public ClntEe FindByid(String id);
	
	public List<ClntEe> findAll();
	
	
}
