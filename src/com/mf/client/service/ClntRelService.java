/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.client.service;

import java.util.List;

import com.mf.client.entity.ClntRel;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2015-01-04
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface ClntRelService{

	public PageView query(PageView pageView,ClntRel clntRel);
	
	public List<ClntRel> queryAll(ClntRel clntRel);
	
	public void add(ClntRel clntRel);
	
	public void addAll(ClntRel clntRel);
	
	public void delete(String id);
	
	public void modify(ClntRel clntRel);
	
	public ClntRel getById(String id);
	
	public List<ClntRel> findAll();
	
	
}
