/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.shareholder.service;

import java.util.List;

import com.mf.shareholder.entity.CorpPersondetail;
import com.mf.util.*;
/**
 * @author wangyw
 * @2015-08-22
 * @version 1.0
 * @param <T>
 */

public interface CorpPersondetailService{

	public PageView query(PageView pageView,CorpPersondetail corpPersondetail);
	
	public List<CorpPersondetail> queryAll(CorpPersondetail corpPersondetail);
	
	public void add(CorpPersondetail corpPersondetail);
	
	public void addAll(CorpPersondetail corpPersondetail);
	
	public void delete(String id);
	
	public void modify(CorpPersondetail corpPersondetail);
	
	public CorpPersondetail getById(String id);
	
	public List<CorpPersondetail> findAll();
	
	
}
