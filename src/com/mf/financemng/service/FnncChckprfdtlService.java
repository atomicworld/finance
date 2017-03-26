/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service;

import java.util.List;

import com.mf.financemng.entity.FnncChckprfdtl;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2015-02-12
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface FnncChckprfdtlService{

	public PageView query(PageView pageView,FnncChckprfdtl fnncChckprfdtl);
	
	public List<FnncChckprfdtl> queryAll(FnncChckprfdtl fnncChckprfdtl);
	
	public void add(FnncChckprfdtl fnncChckprfdtl);
	
	public void addAll(FnncChckprfdtl fnncChckprfdtl);
	
	public void delete(String id);
	
	public void modify(FnncChckprfdtl fnncChckprfdtl);
	
	public FnncChckprfdtl getById(String id);
	
	public List<FnncChckprfdtl> findAll();
	
	
}
