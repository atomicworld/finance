/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service;

import java.util.List;

import com.mf.financemng.entity.FnncDealitem;
import com.mf.util.PageView;
/**
 * @author wangyw
 * @2015-04-15
 * @version 1.0
 * @param <T>
 */

public interface FnncDealitemService{

	public PageView query(PageView pageView,FnncDealitem fnncDealitem);
	
	public List<FnncDealitem> queryAll(FnncDealitem fnncDealitem);
	
	public void add(FnncDealitem fnncDealitem);
	
	public void addAll(FnncDealitem fnncDealitem);
	
	public void delete(String id);
	
	public void modify(FnncDealitem fnncDealitem);
	
	public FnncDealitem getById(String id);
	
	public List<FnncDealitem> findAll();
	
	public FnncDealitem queryItem(FnncDealitem item);
	
}
