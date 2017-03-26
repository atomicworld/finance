/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.financemng.entity.FinanceSupple;
import com.mf.util.*;
/**
 * @author wangzhi
 * @2015-08-20
 * @version 1.0
 * @param <T>
 */

public interface FinanceSuppleService{

	public PageView query(PageView pageView,FinanceSupple financeSupple);
	
	public List<FinanceSupple> queryAll(FinanceSupple financeSupple);
	
	public void add(FinanceSupple financeSupple);
	
	public void addAll(FinanceSupple financeSupple);
	
	public void delete(String id);
	
	public void modify(FinanceSupple financeSupple);
	
	public FinanceSupple getById(String id);

	public FinanceSupple getBysuppleId(int id) ;
	
	public void deleteById(int id);
	
	public FinanceSupple getByReport(String reportMonth);

	public void deleteByFlag(String id);
	
}
