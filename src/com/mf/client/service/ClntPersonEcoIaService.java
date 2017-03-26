/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.service;

import java.util.List;

import com.mf.client.entity.ClntPersonEcoIa;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-29
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface ClntPersonEcoIaService{

	public PageView query(PageView pageView,ClntPersonEcoIa clntPersonEcoIa);
	
	public List<ClntPersonEcoIa> queryAll(ClntPersonEcoIa clntPersonEcoIa);
	
	public void add(ClntPersonEcoIa clntPersonEcoIa);
	
	public void addAll(ClntPersonEcoIa clntPersonEcoIa);
	
	public void delete(String id);
	
	public void modify(ClntPersonEcoIa clntPersonEcoIa);
	
	public ClntPersonEcoIa getById(String id);
	
	public List<ClntPersonEcoIa> findAll();
	
	
}
