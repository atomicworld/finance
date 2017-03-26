/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.service;

import java.util.List;

import com.mf.client.entity.ClntPersonShop;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-16
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface ClntPersonShopService{

	public PageView query(PageView pageView,ClntPersonShop clntPersonShop);
	
	public List<ClntPersonShop> queryAll(ClntPersonShop clntPersonShop);
	
	public void add(ClntPersonShop clntPersonShop);
	
	public void addAll(ClntPersonShop clntPersonShop);
	
	public void delete(String id);
	
	public void modify(ClntPersonShop clntPersonShop);
	
	public ClntPersonShop getById(String id);
	
	public List<ClntPersonShop> findAll();
	
	
}
