/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.service;

import java.util.List;

import com.mf.client.entity.ClntEeCapPeople;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-26
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface ClntEeCapPeopleService{

	public PageView query(PageView pageView,ClntEeCapPeople clntEeCapPeople);
	
	public List<ClntEeCapPeople> queryAll(ClntEeCapPeople clntEeCapPeople);
	
	public void add(ClntEeCapPeople clntEeCapPeople);
	
	public void addAll(ClntEeCapPeople clntEeCapPeople);
	
	public void delete(String id);
	
	public void modify(ClntEeCapPeople clntEeCapPeople);
	
	public ClntEeCapPeople getById(String id);
	
	public List<ClntEeCapPeople> findAll();
	
	
}
