/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.shareholder.service;

import java.util.List;

import com.mf.shareholder.entity.CorpSharerelatives;
import com.mf.util.*;
/**
 * @author wangyw
 * @2015-08-24
 * @version 1.0
 * @param <T>
 */

public interface CorpSharerelativesService{

	public PageView query(PageView pageView,CorpSharerelatives corpSharerelatives);
	
	public List<CorpSharerelatives> queryAll(CorpSharerelatives corpSharerelatives);
	
	public void add(CorpSharerelatives corpSharerelatives);
	
	public void addAll(CorpSharerelatives corpSharerelatives);
	
	public void delete(String id);
	
	public void modify(CorpSharerelatives corpSharerelatives);
	
	public CorpSharerelatives getById(String id);
	
	public List<CorpSharerelatives> findAll();
	
	
}
