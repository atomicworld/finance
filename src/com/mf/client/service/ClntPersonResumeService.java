/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.service;

import java.util.List;

import com.mf.client.entity.ClntPersonResume;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-16
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface ClntPersonResumeService{

	public PageView query(PageView pageView,ClntPersonResume clntPersonResume);
	
	public List<ClntPersonResume> queryAll(ClntPersonResume clntPersonResume);
	
	public void add(ClntPersonResume clntPersonResume);
	
	public void addAll(ClntPersonResume clntPersonResume);
	
	public void delete(String id);
	
	public void modify(ClntPersonResume clntPersonResume);
	
	public ClntPersonResume getById(String id);
	
	public List<ClntPersonResume> findAll();
	
	
}
