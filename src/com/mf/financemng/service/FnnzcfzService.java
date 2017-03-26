/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service;

import java.util.List;

import com.mf.financemng.entity.Fnnzcfz;
import com.mf.financemng.entity.Profit;
import com.mf.util.*;
/**
 * @author wangzhi
 * @2015-08-19
 * @version 1.0
 * @param <T>
 */

public interface FnnzcfzService{

	public PageView query(PageView pageView,Fnnzcfz fnnzcfz);
	
	public List<Fnnzcfz> queryAll(Fnnzcfz fnnzcfz);
	
	public void add(Fnnzcfz fnnzcfz);
	
	public void addAll(Fnnzcfz fnnzcfz);
	
	public void delete(String id);
	public void deleteById(int id);
	public Fnnzcfz getByZcfzId(int id);
	public void modify(Fnnzcfz fnnzcfz);
	public Fnnzcfz getById(String id);
	
	public List<Fnnzcfz> findAll();
	
	public Fnnzcfz getFnnzcfz(Fnnzcfz f);
	
	public void updateFnnzcfz(Fnnzcfz fnnzcfz);
	
	public void deleteFnnzcfz(String reportMonth);
	
	public Fnnzcfz getByReport(String reportMonth);

	public void deleteByFlag(String id);
	
	
}
