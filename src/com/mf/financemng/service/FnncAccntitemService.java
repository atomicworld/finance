/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service;

import java.util.List;
import java.util.Map;

import com.mf.base.AutoCompleteEntity;
import com.mf.financemng.entity.FnncAccntitem;
import com.mf.financemng.entity.FnncPrfbsList;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2015-01-29
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface FnncAccntitemService{

	public PageView query(PageView pageView,FnncAccntitem fnncAccntitem);
	
	public List<FnncAccntitem> queryAll(FnncAccntitem fnncAccntitem);
	
	public Map<String,List<AutoCompleteEntity>> getAllItemForAutoCmp();
	
	public void add(FnncAccntitem fnncAccntitem);
	
	public void addAll(FnncAccntitem fnncAccntitem);
	
	public void delete(String id);
	
	public void modify(FnncAccntitem fnncAccntitem);
	
	public FnncAccntitem getById(String id);
	
	public List<FnncAccntitem> findAll();
	
	public FnncAccntitem getByUp(FnncAccntitem fnnc);
	
	public String  getChild(String accntno);
	
	public List<FnncAccntitem> getByAccntno(String stat);
	
	public List<FnncAccntitem> getType(String accntkndcode);
}
