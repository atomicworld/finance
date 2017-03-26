package com.mf.financemng.service;

import java.util.List;

import com.mf.financemng.entity.FnncCapitalreportmain;
import com.mf.util.PageView;
/**
 * @author chenenze
 * @2015-02-14
 * @version 1.0
 * @param <T>
 */

public interface FnncCapitalreportmainService{

	public PageView query(PageView pageView,FnncCapitalreportmain fnncCapitalreportmain);
	
	public List<FnncCapitalreportmain> queryAll(FnncCapitalreportmain fnncCapitalreportmain);
	
	public void add(FnncCapitalreportmain fnncCapitalreportmain);
	
	public void addAll(FnncCapitalreportmain fnncCapitalreportmain);
	
	public void delete(String id);
	
	public void modify(FnncCapitalreportmain fnncCapitalreportmain);
	
	public FnncCapitalreportmain getById(String id);
	
	public List<FnncCapitalreportmain> findAll();
	
	
}
