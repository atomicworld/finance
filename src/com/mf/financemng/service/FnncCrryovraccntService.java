/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service;

import java.util.List;

import com.mf.financemng.entity.FnncCrryovraccnt;
import com.mf.util.PageView;
/**
 * @author yangchao
 * @2015-03-09
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface FnncCrryovraccntService{

	public PageView query(PageView pageView,FnncCrryovraccnt fnncCrryovraccnt);
	
	public PageView queryJZ(PageView pageView,FnncCrryovraccnt fnncCrryovraccnt);
	
	public boolean queryLen(PageView pageView,FnncCrryovraccnt fnncCrryovraccnt);
	
	public List<FnncCrryovraccnt> queryAll(FnncCrryovraccnt fnncCrryovraccnt);
	
	public void add(FnncCrryovraccnt fnncCrryovraccnt);
	
	public void addAll(FnncCrryovraccnt fnncCrryovraccnt);
	
	public void delete(String id);
	
	public void modify(FnncCrryovraccnt fnncCrryovraccnt);
	
	public FnncCrryovraccnt getById(String id);
	
	
	public List<FnncCrryovraccnt> findAll();
	
	
}
