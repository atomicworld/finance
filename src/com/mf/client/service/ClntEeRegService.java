/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.service;

import java.util.List;

import com.mf.client.entity.ClntEeReg;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-25
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface ClntEeRegService{

	public PageView query(PageView pageView,ClntEeReg clntEeReg);
	
	public List<ClntEeReg> queryAll(ClntEeReg clntEeReg);
	
	public void add(ClntEeReg clntEeReg);
	
	public void addAll(ClntEeReg clntEeReg);
	
	public void delete(String id);
	
	public void modify(ClntEeReg clntEeReg);
	
	public ClntEeReg getById(String id);
	
	public List<ClntEeReg> findAll();
	
	
}
