package com.mf.aftrmng.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mf.aftrmng.entity.AfterFvclass;
import com.mf.cntrtmng.entity.BsnsBill;
import com.mf.util.PageView;
/**
 * @author chenenze
 * @2015-01-20
 * @version 1.0
 * @param <T>
 */

public interface AfterFvclassService{

	public PageView query(PageView pageView,AfterFvclass afterFvclass);
	
	public List<AfterFvclass> queryAll(AfterFvclass afterFvclass);
	
	public void add(AfterFvclass afterFvclass);
	
	public void addAll(AfterFvclass afterFvclass);
	
	public void delete(String id);
	
	public void modify(AfterFvclass afterFvclass);
	
	public AfterFvclass getById(String id);
	
	public List<AfterFvclass> findAll();
	
	public AfterFvclass getByDue(String id,HttpServletRequest request);
	
	public void addauto(BsnsBill bsnsbill);
	
	//add by hw
	public AfterFvclass getByCntrctno(String cntrctno);
}
