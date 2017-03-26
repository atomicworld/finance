/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.service;

import java.util.List;

import com.mf.client.entity.ClntEeCapInvest;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-26
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface ClntEeCapInvestService{

	public PageView query(PageView pageView,ClntEeCapInvest clntEeCapInvest);
	
	public List<ClntEeCapInvest> queryAll(ClntEeCapInvest clntEeCapInvest);
	
	public void add(ClntEeCapInvest clntEeCapInvest);
	
	public void addAll(ClntEeCapInvest clntEeCapInvest);
	
	public void delete(String id);
	
	public void modify(ClntEeCapInvest clntEeCapInvest);
	
	public ClntEeCapInvest getById(String id);
	
	public List<ClntEeCapInvest> findAll();
	
	
}
