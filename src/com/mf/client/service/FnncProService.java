/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.client.service;

import java.util.List;

import com.mf.client.entity.*;
import com.mf.client.dao.*;
import com.mf.client.service.*;
import com.mf.util.*;
/**
 * @author wangyw
 * @2015-08-19
 * @version 1.0
 * @param <T>
 */

public interface FnncProService{

	public PageView query(PageView pageView,Fixedassets fnncPro);
	
	public List<Fixedassets> queryAll(Fixedassets fnncPro);
	
	public void add(Fixedassets fnncPro);
	
	public void addAll(Fixedassets fnncPro);
	
	public void delete(String id);
	
	public void modify(Fixedassets fnncPro);
	
	public Fixedassets getById(String id);
	
	public List<Fixedassets> findAll();

	public void deleteint(int proid);
	
	
}
