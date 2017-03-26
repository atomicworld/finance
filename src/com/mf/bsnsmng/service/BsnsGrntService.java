/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.bsnsmng.service;

import java.util.List;

import com.mf.bsnsmng.entity.BsnsGrnt;
import com.mf.util.PageView;

/**
 * @author yangchao
 * @2015-01-07
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface BsnsGrntService{

	public PageView query(PageView pageView,BsnsGrnt bsnsGrnt);
	
	public List<BsnsGrnt> queryAll(BsnsGrnt bsnsGrnt);
	
	public void add(BsnsGrnt bsnsGrnt);
	
	
	public void delete(String id);
	
	public void modify(BsnsGrnt bsnsGrnt);
	
	public BsnsGrnt getById(String id);
	
	public List<BsnsGrnt> findAll();
	
	public List<BsnsGrnt> getByApplyno(String applyno);
}
