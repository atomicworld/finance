/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.service;

import java.util.List;

import com.mf.client.entity.ClntEeCapFampart;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-26
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface ClntEeCapFampartService{

	public PageView query(PageView pageView,ClntEeCapFampart clntEeCapFampart);
	
	public List<ClntEeCapFampart> queryAll(ClntEeCapFampart clntEeCapFampart);
	
	public void add(ClntEeCapFampart clntEeCapFampart);
	
	public void addAll(ClntEeCapFampart clntEeCapFampart);
	
	public void delete(String id);
	
	public void modify(ClntEeCapFampart clntEeCapFampart);
	
	public ClntEeCapFampart getById(String id);
	
	public List<ClntEeCapFampart> findAll();
	
	
}
