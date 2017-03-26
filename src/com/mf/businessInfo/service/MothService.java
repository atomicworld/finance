/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.businessInfo.service;

import java.util.List;

import com.mf.businessInfo.entity.Checkinfo;
import com.mf.financemng.entity.FnncLedger;
import com.mf.util.PageView;
/**
 * @author wangyw
 * @2015-08-22
 * @version 1.0
 * @param <T>
 */

public interface MothService{

	public PageView query(PageView pageView,Checkinfo moth);
	
	public List<Checkinfo> queryAll(Checkinfo moth);
	
	public void add(Checkinfo moth);
	
	public void addAll(Checkinfo moth);
	
	public void delete(String month);
	
	public void modify(Checkinfo moth);
	
	public List<Checkinfo> getById2(String id);
	public Checkinfo getById(String id);
	
	public List<Checkinfo> findAll();

	public void delete(int id);

	public void initFromExcel(FnncLedger fnncLedger, String[][] a);

	public List<Checkinfo> getBank();
//	public Checkinfo isHave(String id);

	public void delete2(String month);
	
	
}
