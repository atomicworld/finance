package com.mf.sys.service;

import java.util.List;
import com.mf.sys.entity.*;
import com.mf.util.*;
/**
 * @author hw
 * @2015-08-20
 */

public interface CompanyChangeService{

	public PageView query(PageView pageView,CompanyChange companyChange);
	
	public List<CompanyChange> queryAll(CompanyChange companyChange);
	
	public void add(CompanyChange companyChange);
	
	public void addAll(CompanyChange companyChange);
	
	public void delete(String id);
	
	public void modify(CompanyChange companyChange);
	
	public CompanyChange getById(String id);
	
	public List<CompanyChange> findAll();
	
}
