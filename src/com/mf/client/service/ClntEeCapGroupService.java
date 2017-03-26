/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.service;

import java.util.List;

import com.mf.client.entity.ClntEeCapGroup;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-26
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface ClntEeCapGroupService{

	public PageView query(PageView pageView,ClntEeCapGroup clntEeCapGroup);
	
	public List<ClntEeCapGroup> queryAll(ClntEeCapGroup clntEeCapGroup);
	
	public void add(ClntEeCapGroup clntEeCapGroup);
	
	public void addAll(ClntEeCapGroup clntEeCapGroup);
	
	public void delete(String id);
	
	public void modify(ClntEeCapGroup clntEeCapGroup);
	
	public ClntEeCapGroup getById(String id);
	
	public List<ClntEeCapGroup> findAll();
	
	
}
