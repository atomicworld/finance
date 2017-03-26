/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.shareholder.service;

import java.util.List;

import com.mf.shareholder.entity.CorpShareassets;
import com.mf.util.*;
/**
 * @author wangyw
 * @2015-08-24
 * @version 1.0
 * @param <T>
 */

public interface CorpShareassetsService{

	public PageView query(PageView pageView,CorpShareassets corpShareassets);
	
	public List<CorpShareassets> queryAll(CorpShareassets corpShareassets);
	
	public void add(CorpShareassets corpShareassets);
	
	public void addAll(CorpShareassets corpShareassets);
	
	public void delete(String id);
	
	public void modify(CorpShareassets corpShareassets);
	
	public CorpShareassets getById(String id);
	
	public List<CorpShareassets> findAll();
	
	
}
