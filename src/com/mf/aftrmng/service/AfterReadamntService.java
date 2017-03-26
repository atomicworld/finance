/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.aftrmng.service;

import java.util.List;

import com.mf.aftrmng.entity.AfterReadamnt;
import com.mf.util.PageView;
/**
 * @author wangyw
 * @2015-04-20
 * @version 1.0
 * @param <T>
 */

public interface AfterReadamntService{

	public PageView query(PageView pageView,AfterReadamnt afterReadamnt);
	
	public List<AfterReadamnt> queryAll(AfterReadamnt afterReadamnt);
	
	public void add(AfterReadamnt afterReadamnt);
	
	public void addAll(AfterReadamnt afterReadamnt);
	
	public void delete(String id);
	
	public void modify(AfterReadamnt afterReadamnt);
	
	public AfterReadamnt getById(String id);
	
	public List<AfterReadamnt> findAll();
	
	
}
