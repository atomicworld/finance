/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service;

import java.util.List;

import com.mf.client.entity.Fixedassets;
import com.mf.financemng.entity.FinanceShareholder;
import com.mf.util.*;
/**
 * @author wangyw
 * @2015-08-23
 * @version 1.0
 * @param <T>
 */

public interface FinanceShareholderService{

	public PageView query(PageView pageView,FinanceShareholder financeShareholder);
	
	public List<FinanceShareholder> queryAll(FinanceShareholder financeShareholder);
	
	public void add(FinanceShareholder financeShareholder);
	
	public void addAll(FinanceShareholder financeShareholder);
	
	public void deleteById(int id);
	
	public void modify(FinanceShareholder financeShareholder);
	
	public void batchUpdate(List<FinanceShareholder> list);

	public void deleteByIdRptid(String ids);

	public void addlistbean(List<FinanceShareholder> listsh);

	public void delete(String id);

	public FinanceShareholder getById(String reportMonth);

	
}
