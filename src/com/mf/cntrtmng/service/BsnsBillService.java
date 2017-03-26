/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.cntrtmng.service;

import java.util.List;
import java.util.Map;

import com.mf.cntrtmng.entity.BsnsBill;
import com.mf.cntrtmng.entity.BsnsCntrct;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2015-01-13
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface BsnsBillService{

	public PageView query(PageView pageView,BsnsBill bsnsBill);
	
	public List<BsnsBill> queryAll(BsnsBill bsnsBill);
	
	public void add(BsnsBill bsnsBill);
	
	public void addAll(BsnsBill bsnsBill);
	
	public void delete(String dueno);
	
	public void modify(BsnsBill bsnsBill);
	
	public BsnsBill getById(String id);
	
	public List<BsnsBill> findAll();

	public BsnsBill findByDueno(String deuno);
	
	public String getTotal(String cntrctno);
	
	public BsnsBill findByCntrctno(String cntrctno);
	//贷款到期查询
	public PageView queryWarn(PageView pageView,Map<String, Object> param);
	//贷款逾期查询
	public PageView queryOverWarn(PageView pageView,Map<String, Object> param);
	//还款到期查询
	public PageView queryRtrnTimeWarn(PageView pageView,Map<String, Object> param);
	//还款逾期查询
	public PageView queryRtrnOverWarn(PageView pageView,Map<String, Object> param);
	//提前还款查询
	public PageView queryAdvance(PageView pageView,BsnsBill bsnsBill);

	public PageView queryCancel(PageView pageView,BsnsBill bsnsBill);
	public PageView queryBillouted(PageView pageView, BsnsBill bsnsBill);
	
	// add by xjh for 查询补录借据 20150407 start
	public PageView queryBLBill(PageView pageView, BsnsBill bsnsbill);
	// add by xjh for 查询补录借据 20150407 end
	
	
}
