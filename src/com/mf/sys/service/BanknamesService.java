/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.sys.service;

import java.util.List;

import com.mf.sys.entity.Banknames;
import com.mf.util.*;
/**
 * @author wangzhi
 * @2015-08-17
 * @version 1.0
 * @param <T>
 */

public interface BanknamesService{

	public PageView query(PageView pageView,Banknames banknames);
	
	public List<Banknames> queryByParentId(int parentId);
	
	public void add(Banknames banknames);
	
	public void addAll(Banknames banknames);
	
	public void delete(String id);
	
	public void modify(Banknames banknames);
	
	public Banknames getById1(int id);
	
	public List<Banknames> findAll();
	
}
