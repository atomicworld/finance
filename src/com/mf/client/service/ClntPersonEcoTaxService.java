/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.service;

import java.util.List;

import com.mf.client.entity.ClntPersonEcoTax;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-29
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface ClntPersonEcoTaxService{

	public PageView query(PageView pageView,ClntPersonEcoTax clntPersonEcoTax);
	
	public List<ClntPersonEcoTax> queryAll(ClntPersonEcoTax clntPersonEcoTax);
	
	public void add(ClntPersonEcoTax clntPersonEcoTax);
	
	public void addAll(ClntPersonEcoTax clntPersonEcoTax);
	
	public void delete(String id);
	
	public void modify(ClntPersonEcoTax clntPersonEcoTax);
	
	public ClntPersonEcoTax getById(String id);
	
	public List<ClntPersonEcoTax> findAll();
	
	
}
