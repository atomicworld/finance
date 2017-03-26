/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.client.service;

import java.util.List;

import com.mf.client.entity.ClntGradeCommerce;
import com.mf.util.PageView;
/**
 * @author wangyw
 * @2015-04-09
 * @version 1.0
 * @param <T>
 */

public interface ClntGradeCommerceService{

	public PageView query(PageView pageView,ClntGradeCommerce clntGradeCommerce);
	
	public List<ClntGradeCommerce> queryAll(ClntGradeCommerce clntGradeCommerce);
	
	public void add(ClntGradeCommerce clntGradeCommerce);
	
	public void addAll(ClntGradeCommerce clntGradeCommerce);
	
	public void delete(String id);
	
	public void modify(ClntGradeCommerce clntGradeCommerce);
	
	public ClntGradeCommerce getById(String id);
	
	public List<ClntGradeCommerce> findAll();
	
	
}
