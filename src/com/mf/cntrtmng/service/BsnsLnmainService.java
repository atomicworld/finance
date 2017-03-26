/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.cntrtmng.service;

import java.util.List;

import com.mf.cntrtmng.entity.BsnsLnmain;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2015-01-21
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface BsnsLnmainService{

	public PageView query(PageView pageView,BsnsLnmain bsnsLnmain);
	
	public List<BsnsLnmain> queryAll(BsnsLnmain bsnsLnmain);
	
	public void add(BsnsLnmain bsnsLnmain);
	
	public void addAll(BsnsLnmain bsnsLnmain);
	
	public void delete(String id);
	
	public void modify(BsnsLnmain bsnsLnmain);
	
	public BsnsLnmain getById(String id);
	
	public List<BsnsLnmain> findAll();
	
	public BsnsLnmain findByBsnsno(String bsnsno);
	
	public BsnsLnmain cougtCntrctno(String cntrctno);
	
	public PageView queryextend(PageView pageView,BsnsLnmain bsnsLnmain);
}
