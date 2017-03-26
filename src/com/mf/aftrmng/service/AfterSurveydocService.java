package com.mf.aftrmng.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mf.aftrmng.entity.AfterSurveydoc;
import com.mf.util.PageView;
/**
 * @author chenenze
 * @2015-01-20
 * @version 1.0
 * @param <T>
 */

public interface AfterSurveydocService{

	public PageView query(PageView pageView,AfterSurveydoc afterSurveydoc);
	
	public List<AfterSurveydoc> queryAll(AfterSurveydoc afterSurveydoc);
	
	public void add(AfterSurveydoc afterSurveydoc,HttpServletRequest request);
	
	public void addAll(AfterSurveydoc afterSurveydoc);
	
	public void delete(String id);
	
	public void modify(AfterSurveydoc afterSurveydoc);
	
	public AfterSurveydoc getById(String id);
	
	public List<AfterSurveydoc> findAll();
	
	
}
