/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service;

import java.util.List;

import com.mf.financemng.entity.FnncAccntctlcd;
import com.mf.util.PageView;

/**
 * @author shenguangdong
 * @2015-02-10
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface FnncAccntctlcdService{

	public PageView query(PageView pageView,FnncAccntctlcd fnncAccntctlcd);
	
	public List<FnncAccntctlcd> queryAll(FnncAccntctlcd fnncAccntctlcd);
	
	public void add(FnncAccntctlcd fnncAccntctlcd);
	
	public void addAll(FnncAccntctlcd fnncAccntctlcd);
	
	public void delete(String id);
	
	public void modify(FnncAccntctlcd fnncAccntctlcd);
	
	public FnncAccntctlcd getById(String id);
	
	public List<FnncAccntctlcd> findAll();
	
	
}
