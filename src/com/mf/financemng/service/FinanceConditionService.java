/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service;

import java.util.List;

import com.mf.financemng.entity.FinanceCondition;
import com.mf.util.*;
/**
 * @author wangzhi
 * @2015-08-14
 * @version 1.0
 * @param <T>
 */

public interface FinanceConditionService{

	public PageView query(PageView pageView,FinanceCondition financeCondition);
	
	public List<FinanceCondition> queryAll(FinanceCondition financeCondition);
	
	public void add(FinanceCondition financeCondition);
	
	public void addAll(FinanceCondition financeCondition);
	
	public void delete(String id);
	
	public void modify(FinanceCondition financeCondition);
	
	public FinanceCondition getById(String id);
	
	public List<FinanceCondition> findAll();

	public FinanceCondition checkbankno(String bankno);
	
	
}
