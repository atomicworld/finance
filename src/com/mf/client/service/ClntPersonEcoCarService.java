/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.service;
import java.util.List;

import com.mf.client.entity.ClntPersonEcoCar;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-29
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface ClntPersonEcoCarService{

	public PageView query(PageView pageView,ClntPersonEcoCar clntPersonEcoCar);
	
	public List<ClntPersonEcoCar> queryAll(ClntPersonEcoCar clntPersonEcoCar);
	
	public void add(ClntPersonEcoCar clntPersonEcoCar);
	
	public void addAll(ClntPersonEcoCar clntPersonEcoCar);
	
	public void delete(String id);
	
	public void modify(ClntPersonEcoCar clntPersonEcoCar);
	
	public ClntPersonEcoCar getById(String id);
	
	public List<ClntPersonEcoCar> findAll();
	
	
}
