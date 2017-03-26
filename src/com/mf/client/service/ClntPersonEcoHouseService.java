/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.service;

import java.util.List;

import com.mf.client.entity.ClntPersonEcoHouse;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-29
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface ClntPersonEcoHouseService{

	public PageView query(PageView pageView,ClntPersonEcoHouse clntPersonEcoHouse);
	
	public List<ClntPersonEcoHouse> queryAll(ClntPersonEcoHouse clntPersonEcoHouse);
	
	public void add(ClntPersonEcoHouse clntPersonEcoHouse);
	
	public void addAll(ClntPersonEcoHouse clntPersonEcoHouse);
	
	public void delete(String id);
	
	public void modify(ClntPersonEcoHouse clntPersonEcoHouse);
	
	public ClntPersonEcoHouse getById(String id);
	
	public List<ClntPersonEcoHouse> findAll();
	
	
}
