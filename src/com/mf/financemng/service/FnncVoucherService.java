/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service;

import java.util.List;

import com.mf.cntrtmng.entity.BsnsCntrct;
import com.mf.financemng.entity.FnncVoucher;
import com.mf.util.PageView;
/**
 * @author yangchao
 * @2015-03-03
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface FnncVoucherService{

	public PageView query(PageView pageView,FnncVoucher fnncVoucher);
	
	public PageView queryOutmnt(PageView pageView,BsnsCntrct bsnscntrct);
	
	public PageView queryPaymnt(PageView pageView,BsnsCntrct bsnscntrct);
	
	public List<FnncVoucher> queryAll(FnncVoucher fnncVoucher);
	
	public void add(FnncVoucher fnncVoucher);
	
	public void addAll(FnncVoucher fnncVoucher);
	
	public void delete(String id);
	
	public void modify(FnncVoucher fnncVoucher);
	
	public FnncVoucher getById(String id);
	
}
