package com.mf.financemng.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mf.financemng.entity.FnncCapitalreport;
import com.mf.util.PageView;
/**
 * @author chenenze
 * @2015-02-11
 * @version 1.0
 * @param <T>
 */

public interface FnncCapitalreportService{

	public PageView query(PageView pageView,FnncCapitalreport fnncCapitalreport);
	
	public List<FnncCapitalreport> queryAll(FnncCapitalreport fnncCapitalreport);
	
	public void add(FnncCapitalreport fnncCapitalreport,HttpServletRequest request);
	
	public void addAll(FnncCapitalreport fnncCapitalreport);
	
	public void delete(String id);
	
	public void modify(FnncCapitalreport fnncCapitalreport);
	
	public FnncCapitalreport getById(String id);
	
	public List<FnncCapitalreport> findAll(String id);
	
	
}
