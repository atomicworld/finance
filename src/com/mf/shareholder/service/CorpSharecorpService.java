/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.shareholder.service;

import java.util.List;

import com.mf.shareholder.entity.CorpSharecorp;
import com.mf.util.*;
/**
 * @author wangyw
 * @2015-08-24
 * @version 1.0
 * @param <T>
 */

public interface CorpSharecorpService{

	public PageView query(PageView pageView,CorpSharecorp corpSharecorp);
	
	public List<CorpSharecorp> queryAll(CorpSharecorp corpSharecorp);
	
	public void add(CorpSharecorp corpSharecorp);
	
	public void addAll(CorpSharecorp corpSharecorp);
	
	public void delete(String id);
	
	public void modify(CorpSharecorp corpSharecorp);
	
	public CorpSharecorp getById(String id);
	
	public List<CorpSharecorp> findAll();
	
	
}
