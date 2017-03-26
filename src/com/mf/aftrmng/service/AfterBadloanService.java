/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.aftrmng.service;

import java.util.List;

import com.mf.aftrmng.entity.AfterBadloan;
import com.mf.aftrmng.entity.AfterFvclass;
import com.mf.util.PageView;
/**
 * @author wangyw
 * @2015-04-20
 * @version 1.0
 * @param <T>
 */

public interface AfterBadloanService{

	public PageView query(PageView pageView,AfterFvclass afterfvclass);
	
	public PageView queryBadloan(PageView pageView,AfterBadloan afterBadloan);
	
	public List<AfterBadloan> queryAll(AfterBadloan afterBadloan);
	
	public void add(AfterBadloan afterBadloan);
	
	public void addAll(AfterBadloan afterBadloan);
	
	public void delete(String id);
	
	public void modify(AfterBadloan afterBadloan);
	
	public AfterBadloan getById(String id);
	
	public List<AfterBadloan> findAll();
	
	
}
