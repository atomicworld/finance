/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2016
 */

package com.mf.financemng.service;

import java.util.List;

import com.mf.financemng.entity.Finreportitem;
import com.mf.util.*;
/**
 * @author wangyw
 * @2016-01-05
 * @version 1.0
 * @param <T>
 */

public interface FinreportitemService{

	public PageView query(PageView pageView,Finreportitem finreportitem);
	
	public List<Finreportitem> queryAll(Finreportitem finreportitem);
	
	public void add(Finreportitem finreportitem);
	
	public void addAll(Finreportitem finreportitem);
	
	public void delete(String id);
	
	public void modify(Finreportitem finreportitem);
	
	public Finreportitem getById(String id);
	
	public List<Finreportitem> findAll();
	
	public List<Finreportitem> getByPitemcode(String pitemcode);
	
	
}
