/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.service;

import java.util.List;

import com.mf.client.entity.ClntPersonEcoSi;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-29
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface ClntPersonEcoSiService{

	public PageView query(PageView pageView,ClntPersonEcoSi clntPersonEcoSi);
	
	public List<ClntPersonEcoSi> queryAll(ClntPersonEcoSi clntPersonEcoSi);
	
	public void add(ClntPersonEcoSi clntPersonEcoSi);
	
	public void addAll(ClntPersonEcoSi clntPersonEcoSi);
	
	public void delete(String id);
	
	public void modify(ClntPersonEcoSi clntPersonEcoSi);
	
	public ClntPersonEcoSi getById(String id);
	
	public List<ClntPersonEcoSi> findAll();
	
	
}
