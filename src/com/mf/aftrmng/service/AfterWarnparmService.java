/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.aftrmng.service;

import java.util.List;

import com.mf.aftrmng.entity.AfterWarnparm;
import com.mf.util.PageView;

/**
 * @author yangchao
 * @2015-01-27
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface AfterWarnparmService{

	public PageView query(PageView pageView,AfterWarnparm afterWarnparm);
	
	public List<AfterWarnparm> queryAll(AfterWarnparm afterWarnparm);
	
	public void add(AfterWarnparm afterWarnparm);
	
	public void addAll(AfterWarnparm afterWarnparm);
	
	public void delete(String id);
	
	public void modify(AfterWarnparm afterWarnparm);
	
	public AfterWarnparm getById(String id);
	
	public AfterWarnparm findByWarnnm(AfterWarnparm afterWarnparm);
	
	public List<AfterWarnparm> findAll();
	
	
}
