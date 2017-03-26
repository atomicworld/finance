/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.businessInfo.service;

import java.util.List;

import com.mf.businessInfo.entity.Fileupdown;
import com.mf.util.PageView;
/**
 * @author wangyw
 * @2015-08-26
 * @version 1.0
 * @param <T>
 */

public interface FileupdownService{

	public PageView query(PageView pageView,Fileupdown fileupdown);
	
	public List<Fileupdown> queryAll(Fileupdown fileupdown);
	
	public void add(Fileupdown fileupdown);
	
	public void addAll(Fileupdown fileupdown);
	
	public void delete(String id);
	
	public void modify(Fileupdown fileupdown);
	
	public Fileupdown getById(String id);
	
	public List<Fileupdown> findAll();

	public int count(String id);
	
	public void deleteByReportid(String reportid);
	
	public List<Fileupdown> getByReportid(String reportid);
	
	
}
