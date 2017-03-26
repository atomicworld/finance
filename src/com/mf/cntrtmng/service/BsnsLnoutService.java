/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.cntrtmng.service;

import java.util.List;

import com.mf.cntrtmng.entity.*;
import com.mf.cntrtmng.dao.*;
import com.mf.cntrtmng.service.*;
import com.mf.common.util.*;
import com.mf.util.*;
/**
 * @author yangchao
 * @2015-01-04
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface BsnsLnoutService{

	public PageView query(PageView pageView,BsnsLnout bsnsLnout);
	
	public PageView queryoutable(PageView pageView,BsnsLnout bsnsLnout);
	
	public List<BsnsLnout> queryList(BsnsLnout bsnsLnout);
	
	public PageView showoutInfo(PageView pageView,BsnsLnout bsnsLnout);
	
/*	public void exeout(BsnsLnout bsnslnout);*/
	//edit by hw
	public void exeout(BsnsLnout bsnslnout,String date,String pay,String bnkno);
	
	public List<BsnsLnout> queryAll(BsnsLnout bsnsLnout);
	
	public List<BsnsCntrct> queryExcel(BsnsCntrct bsnscntrct);
	
	public void add(BsnsLnout bsnsLnout);
	
	public void addAll(BsnsLnout bsnsLnout);
	
	public void delete(String id);
	
	public void modify(BsnsLnout bsnsLnout);
	
	public BsnsLnout getById(String id);
	
	public List<BsnsLnout> findAll();
	
	public BsnsLnout findBySrlno(String srlno);

	public PageView queryOuted(PageView pageView, BsnsLnout bsnslnout);
	
	
}
