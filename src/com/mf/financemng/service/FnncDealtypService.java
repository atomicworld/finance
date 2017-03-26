/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service;

import java.util.List;

import com.mf.financemng.entity.FnncDealtyp;
import com.mf.util.PageView;
/**
 * @author wangyw
 * @2015-04-15
 * @version 1.0
 * @param <T>
 */

public interface FnncDealtypService{

	public PageView query(PageView pageView,FnncDealtyp fnncDealtyp);
	
	public List<FnncDealtyp> queryAll(FnncDealtyp fnncDealtyp);
	
	public void add(FnncDealtyp fnncDealtyp);
	
	public void addAll(FnncDealtyp fnncDealtyp);
	
	public void delete(String id);
	
	public void modify(FnncDealtyp fnncDealtyp);
	
	public FnncDealtyp getById(String id);
	
	public List<FnncDealtyp> findAll();
	
	
}
