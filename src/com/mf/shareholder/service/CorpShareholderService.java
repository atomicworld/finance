/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.shareholder.service;

import java.util.List;

import com.mf.shareholder.entity.CorpShareholder;
import com.mf.util.*;
/**
 * @author wangyw
 * @2015-08-20
 * @version 1.0
 * @param <T>
 */

public interface CorpShareholderService{

	public PageView query(PageView pageView,CorpShareholder corpShareholder);
	
	public List<CorpShareholder> queryAll(CorpShareholder corpShareholder);
	
	public void add(CorpShareholder corpShareholder);
	
	public void addAll(CorpShareholder corpShareholder);
	
	public void delete(String id);
	
	public void modify(CorpShareholder corpShareholder);
	
	public CorpShareholder getById(String id);
	
	public List<CorpShareholder> findAll();
	
	
}
