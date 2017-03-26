/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service;

import java.util.List;

import com.mf.financemng.entity.FnncChckprfbs;
import com.mf.financemng.entity.FnncPrfbsList;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2015-02-12
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface FnncChckprfbsService{

	public PageView query(PageView pageView,FnncChckprfbs fnncChckprfbs);
	
	public void add(FnncChckprfbs fnncChckprfbs);
	
	public void modify(FnncChckprfbs fnncChckprfbs);
	
	public FnncChckprfbs getById(String id);
	
	public List<FnncChckprfbs> findAll();
	
	public PageView queryList(PageView pageView, FnncPrfbsList fnncprfbslist);
	

}
