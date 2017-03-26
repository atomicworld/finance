/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.bsnsmng.service;

import java.util.List;

import com.mf.bsnsmng.entity.BsnsReport;
import com.mf.util.PageView;
/**
 * @author yangchao
 * @2015-03-27
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface BsnsReportService{

	public PageView query(PageView pageView,BsnsReport bsnsReport);
	
	public List<BsnsReport> queryAll(BsnsReport bsnsReport);
	
	public void add(BsnsReport bsnsReport);
	
	public void addAll(BsnsReport bsnsReport);
	
	public void delete(String id);
	
	public void modify(BsnsReport bsnsReport);
	
	public BsnsReport getById(String id);
	
	public List<BsnsReport> findAll();
	
	
}
