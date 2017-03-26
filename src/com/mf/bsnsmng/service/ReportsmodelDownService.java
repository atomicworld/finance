package com.mf.bsnsmng.service;

import java.util.List;
import com.mf.bsnsmng.entity.*;
import com.mf.util.*;
/**
 * @author wangyw
 * @2015-06-24
 * @version 1.0
 * @param <T>
 */

public interface ReportsmodelDownService{

	public PageView query(PageView pageView,ReportsmodelDown reportsmodelDown);
	
	public List<ReportsmodelDown> queryAll(ReportsmodelDown reportsmodelDown);
	
	public void add(ReportsmodelDown reportsmodelDown);
	
	public void addAll(ReportsmodelDown reportsmodelDown);
	
	public void delete(String id);
	
	public void modify(ReportsmodelDown reportsmodelDown);
	
	public ReportsmodelDown getById(String id);
	
	public List<ReportsmodelDown> findAll();
	
	
}
