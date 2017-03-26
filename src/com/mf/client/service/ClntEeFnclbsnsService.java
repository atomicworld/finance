/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.service;

import java.util.List;

import com.mf.client.entity.ClntEeFnclbsns;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-26
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface ClntEeFnclbsnsService{

	public PageView query(PageView pageView,ClntEeFnclbsns clntEeFnclbsns);
	
	public List<ClntEeFnclbsns> queryAll(ClntEeFnclbsns clntEeFnclbsns);
	
	public void add(ClntEeFnclbsns clntEeFnclbsns);
	
	public void addAll(ClntEeFnclbsns clntEeFnclbsns);
	
	public void delete(String id);
	
	public void modify(ClntEeFnclbsns clntEeFnclbsns);
	
	public ClntEeFnclbsns getById(String id);
	
	public List<ClntEeFnclbsns> findAll();
	
	
}
