/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service;

import java.util.List;

import com.mf.financemng.entity.FinanceBank;
import com.mf.util.*;
/**
 * @author wangzhi
 * @2015-08-13
 * @version 1.0
 * @param <T>
 */

public interface FinanceBankService{

	public PageView query(PageView pageView,FinanceBank financeBank);
	
	public List<FinanceBank> queryAll(FinanceBank financeBank);
	
	public void add(FinanceBank financeBank);
	
	public void addAll(FinanceBank financeBank);
	
	public void delete(String id);
	
	public void modify(FinanceBank financeBank);
	
	public FinanceBank getById(String id);
	
	public List<FinanceBank> findAll();
	
	
}
