/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.cntrtmng.service;

import com.mf.cntrtmng.entity.*;

import java.util.*;

import org.springframework.dao.DataAccessException;

import com.mf.org.entity.Operator;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2015-01-13
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface BsnsRepayplanService {
	public PageView query(PageView pageView,BsnsRepayplan bsnsRepayplan);
	
	public PageView queryStatus(PageView pageView,BsnsRepayplan bsnsRepayplan);

	public List<BsnsRepayplan> queryAll(BsnsRepayplan bsnsRepayplan);
	
	public void add(BsnsRepayplan bsnsRepayplan);
	
	public void addAll(BsnsRepayplan bsnsRepayplan);
	
	public void delete(String id);
	
	public void modify(BsnsRepayplan bsnsRepayplan);
	
	public BsnsRepayplan getById(String id);
	
	//根据还款计划，获取还款计划中应还本金及应还利息（add by fankb）
	public BsnsRepayplan getBySrlNo(String srlNo);
	//判断是否已生成还款计划
	public int getCountPlan(String dueno);
	//查看已生成的还款计划
	public List<BsnsRepayplan> getByDueno(String dueno);
	
	public List<BsnsRepayplan> findAll();

	public PageView queryDueno(PageView pageView, BsnsRepayplan bsnsrepayplan);
	//计算默认的还款计划
	public List<BsnsRepayplan> createDefaultPlan(String dueno, String hkr);

	public void addList(List<BsnsRepayplan> list, String dueno, String payday,String specailDay);
	/**	201508， zc	--begin*/
	//合同展期制定的还款计划
	public List<BsnsRepayplan> createExtendPlan(String dueno,BsnsExtend bsnsExtend,BsnsBill bsnsBill);
	public void addExtendList(List<BsnsRepayplan> list, String dueno);
	//上一期还款计划
	public BsnsRepayplan getMaxByDueno(String id);
	/**	201508， zc--begin*/
	
	/**	提前还款， hw	--begin*/
	//查找已生成的，已还款的还款计划
	public List<BsnsRepayplan> getByDuenoPayed(String dueno);
	
	//重新生成还款计划
	public  List<BsnsRepayplan> countNewPlan(BsnsBill bsnsBill);
	
	//查看已生成的，未还款的还款计划
	public List<BsnsRepayplan> getByDuenoUnpay(BsnsRepayplan bsnsRepayplan);
	
	//查看当前日期之前的还款计划
	public List<BsnsRepayplan> getByDuenoOldPlan(String dueno);
	
	public List<BsnsRepayplan> getIsUnpayPlan(BsnsRepayplan bsnsRepayplan);
	
	public List<BsnsRepayplan> findAsEndDate(BsnsRepayplan bsnsRepayplan);
	
	/**	提前还款， hw	--end*/
	
	public int  execPrePayment(BsnsPrePaymentBean prePamentBean,Operator operator);
	
	public List<BsnsRepayplan> queryBycyclesdt(BsnsRepayplan bsnsRepayplan);
	
	public PageView query1(PageView pageView,BsnsRepayplan bsnsRepayplan);
	
	//add by hw
	public List<BsnsRepayplan> queryNew(BsnsRepayplan bsnsRepayplan);

	
	//根据借据号和还款期数号获取还款计划信息
	public double getMaxPayedSumAsDueNo(String dueNo) ;

	
	public PageView query2(PageView pageView,BsnsRepayplan bsnsRepayplan);

}
