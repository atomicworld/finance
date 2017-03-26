/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.shareholder.service;

import java.util.List;

import com.mf.shareholder.entity.CorpSharedetail;
import com.mf.util.*;
/**
 * @author wangyw
 * @2015-08-22
 * @version 1.0
 * @param <T>
 */

public interface CorpSharedetailService{

	public PageView query(PageView pageView,CorpSharedetail corpSharedetail);
	
	public List<CorpSharedetail> queryAll(CorpSharedetail corpSharedetail);
	
	public void add(CorpSharedetail corpSharedetail);
	
	public void addAll(CorpSharedetail corpSharedetail);
	
	public void delete(String id);
	
	public void modify(CorpSharedetail corpSharedetail);
	
	public CorpSharedetail getById(String id);
	
	public List<CorpSharedetail> findAll();
	
	
}
