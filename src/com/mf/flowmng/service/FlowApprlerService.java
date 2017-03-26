/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.flowmng.service;

import java.util.List;

import com.mf.flowmng.entity.FlowApprler;
import com.mf.util.PageView;

/**
 * @author yangchao
 * @2015-01-16
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface FlowApprlerService{

	public PageView query(PageView pageView,FlowApprler flowApprler);
	
	public List<FlowApprler> queryAll(FlowApprler flowApprler);
	
	public void add(FlowApprler flowApprler);
	
	public void delete(String id);
	
	public void modify(FlowApprler flowApprler);
	
	public FlowApprler getById(String id);
	public FlowApprler getById1(String id);
	
	public List<FlowApprler> findAll();
	//wyy
	public int getByOpno(String opno);
	
	
}
