/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.client.service;

import java.util.List;

import com.mf.client.entity.ClntBlacklist;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2015-01-05
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface ClntBlacklistService{

	public PageView query(PageView pageView,ClntBlacklist clntBlacklist);
	
	public List<ClntBlacklist> queryAll(ClntBlacklist clntBlacklist);
	
	public void add(ClntBlacklist clntBlacklist);
	
	public void addAll(ClntBlacklist clntBlacklist);
	
	public void delete(String id);
	
	public void modify(ClntBlacklist clntBlacklist);
	
	public ClntBlacklist getById(String id);
	
	public List<ClntBlacklist> findAll();
	
	//add by hw
	public List<ClntBlacklist> queryUnSubmit(ClntBlacklist clntBlacklist);
	
}
