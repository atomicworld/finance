/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.cntrtmng.service;

import java.util.List;

import com.mf.cntrtmng.entity.BsnsCntrct;
import com.mf.cntrtmng.entity.BsnsRepaylog;
import com.mf.cntrtmng.entity.BsnsRepaylogList;
import com.mf.financemng.entity.FnncVoucher;
import com.mf.org.entity.Operator;
import com.mf.util.PageView;
/**
 * @author yangchao
 * @2015-01-30
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface BsnsRepaylogService{

	public PageView query(PageView pageView,BsnsRepaylog bsnsRepaylog);
	
	public List<BsnsRepaylog> queryAll(BsnsRepaylog bsnsRepaylog);
	
	public void add(BsnsRepaylog bsnsRepaylog,Operator operator);
	
	public void payCheckIn(BsnsRepaylog bsnsRepaylog,BsnsCntrct bsnscntrct,Operator operator);
	
	public void addAll(BsnsRepaylog bsnsRepaylog);
	
	public void delete(String id);
	
	public void modify(BsnsRepaylog bsnsRepaylog);
	
	public BsnsRepaylog getById(String id);
	
	/*public BsnsRepaylog getBySrlno(String srlno);*/
	//edit by hw
	public List<BsnsRepaylog> getBySrlno(String srlno);
	
	public List<BsnsRepaylog> findAll();
	
	public int getCountPlan(String dueno);
	
	public  List<BsnsRepaylogList> getByDueno(String dueno);
	
	public  List<BsnsRepaylogList> getByDuenoCount(String dueno);
	
	//add by hw
	public BsnsRepaylog getForMaxDt(String dueno);
	
	public void update(BsnsRepaylog bsnsRepaylog);
	
}
