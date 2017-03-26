/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service;

import java.util.List;

import com.mf.financemng.entity.FinanceRefundInfo;
import com.mf.util.*;
/**
 * @author wangzhi
 * @2015-08-14
 * @version 1.0
 * @param <T>
 */

public interface FinanceRefundInfoService{

	public PageView query(PageView pageView,FinanceRefundInfo financeRefundInfo);
	
	public List<FinanceRefundInfo> queryAll(FinanceRefundInfo financeRefundInfo);
	
	public void add(FinanceRefundInfo financeRefundInfo);
	
	public void addAll(FinanceRefundInfo financeRefundInfo);
	
	
	public void modify(FinanceRefundInfo financeRefundInfo);
	
	public FinanceRefundInfo getById(String id);
	
	public List<FinanceRefundInfo> findAll();

	public void delete(String id);

	public void deleteParentId(String loanno);
	
	
}
