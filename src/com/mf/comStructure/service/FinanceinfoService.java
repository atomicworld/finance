package com.mf.comStructure.service;

import com.mf.comStructure.entity.Financeinfo;
import com.mf.util.PageView;
/**
 * @author wangyw
 * @2015-04-16
 * @version 1.0
 * @param <T>
 */

public interface FinanceinfoService{

	public PageView query(PageView pageView,Financeinfo financeinfo);
	
	public void add(Financeinfo financeinfo);
	
	public void delete(String id);
	
	public void modify(Financeinfo financeinfo);
	
	public Financeinfo getById(String id);
	public void submit(String id);	
	
}
