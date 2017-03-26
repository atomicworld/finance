/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.sendFileImpl.service;

import java.util.List;

import com.mf.sendFileImpl.entity.BsnsApplyData;
import com.mf.util.*;
/**
 * @author wangzhi
 * @2015-09-08
 * @version 1.0
 * @param <T>
 */

public interface BsnsApplyDataService{

	public PageView query(PageView pageView,BsnsApplyData bsnsApplyData);
	
	public List<BsnsApplyData> queryAll(BsnsApplyData bsnsApplyData);
	
	public void add(BsnsApplyData bsnsApplyData);
	
	public void addAll(BsnsApplyData bsnsApplyData);
	
	public void delete(String id);
	
	public void modify(BsnsApplyData bsnsApplyData);
	
	public BsnsApplyData getById(String id);
	
	public List<BsnsApplyData> findAll();
	
	public List<BsnsApplyData> query1();
	
	
}
