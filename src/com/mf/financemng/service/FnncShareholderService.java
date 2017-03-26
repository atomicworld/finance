/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mf.financemng.entity.FnncShareholder;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2015-02-10
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface FnncShareholderService{

	public PageView query(PageView pageView,FnncShareholder fnncShareholder);
	
	public List<FnncShareholder> queryAll(FnncShareholder fnncShareholder);
	
	public void add(FnncShareholder fnncShareholder,HttpServletRequest request);
	
	public void addAll(FnncShareholder fnncShareholder);
	
	public void delete(String id);
	
	public void modify(FnncShareholder fnncShareholder);
	
	public FnncShareholder getById(String id);
	
	public List<FnncShareholder> findAll();

	public FnncShareholder findbynm(String sharholdnm);

	public PageView queryhistory(PageView pageView,FnncShareholder fnncshareholder);
	
	
}
