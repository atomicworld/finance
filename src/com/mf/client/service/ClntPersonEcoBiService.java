/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.service;

import java.util.List;

import com.mf.client.entity.ClntPersonEcoBi;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-29
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface ClntPersonEcoBiService{

	public PageView query(PageView pageView,ClntPersonEcoBi clntPersonEcoBi);
	
	public List<ClntPersonEcoBi> queryAll(ClntPersonEcoBi clntPersonEcoBi);
	
	public void add(ClntPersonEcoBi clntPersonEcoBi);
	
	public void addAll(ClntPersonEcoBi clntPersonEcoBi);
	
	public void delete(String id);
	
	public void modify(ClntPersonEcoBi clntPersonEcoBi);
	
	public ClntPersonEcoBi getById(String id);
	
	public List<ClntPersonEcoBi> findAll();
	
	
}
