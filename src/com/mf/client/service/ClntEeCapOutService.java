/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.service;

import java.util.List;

import com.mf.client.entity.ClntEeCapOut;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-26
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface ClntEeCapOutService{

	public PageView query(PageView pageView,ClntEeCapOut clntEeCapOut);
	
	public List<ClntEeCapOut> queryAll(ClntEeCapOut clntEeCapOut);
	
	public void add(ClntEeCapOut clntEeCapOut);
	
	public void addAll(ClntEeCapOut clntEeCapOut);
	
	public void delete(String id);
	
	public void modify(ClntEeCapOut clntEeCapOut);
	
	public ClntEeCapOut getById(String id);
	
	public List<ClntEeCapOut> findAll();
	
	
}
