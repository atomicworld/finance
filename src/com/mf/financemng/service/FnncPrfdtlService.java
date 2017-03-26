/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service;

import java.util.List;

import com.mf.financemng.entity.FnncPrfbsList;
import com.mf.financemng.entity.FnncPrfdtl;
import com.mf.financemng.entity.FnncPrfdtlList;
import com.mf.util.PageView;
/**
 * @author yangchao
 * @2015-02-11
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface FnncPrfdtlService{

	public PageView query(PageView pageView,FnncPrfdtl fnncPrfdtl);
	
	public PageView queryAccnt(PageView pageView,FnncPrfdtlList fnncprfdtllist);
	
	public PageView queryAccntAll(PageView pageView,FnncPrfdtlList fnncprfdtllist);

	public List<FnncPrfdtl> queryAll(FnncPrfdtl fnncPrfdtl);
	
	public List<FnncPrfdtlList> querylist(String prftrcno);
	
	public void add(FnncPrfdtl fnncPrfdtl);
	
	public void addAll(FnncPrfdtl fnncPrfdtl);
	
	public void delete(String id);
	
	public void deleteBysqnno(String sqnno);
	
	public void modify(FnncPrfdtl fnncPrfdtl);
	
	public FnncPrfdtl getById(String id);
	
	public List<FnncPrfdtl> findAll();
	
	public List<FnncPrfdtl> getByPrfrtcno(String prfrtcno);
	
	

}
