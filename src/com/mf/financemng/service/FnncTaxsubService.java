/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service;

import java.util.List;

import com.mf.financemng.entity.*;
import com.mf.util.*;

/**
 * @author wangyw
 * @2015-08-19
 * @version 1.0
 * @param <T>
 */

public interface FnncTaxsubService{

	public PageView query(PageView pageView,FnncTaxsub fnncTaxsub,String search);
	
	public List<FnncTaxsub> queryAll(FnncTaxsub fnncTaxsub);
	
	public void add(FnncTaxsub fnncTaxsub);
	
	public void addAll(FnncTaxsub fnncTaxsub);
	
	public void delete(String id);
	
	public void deleteById(String id);
	
	public void modify(FnncTaxsub fnncTaxsub);
	
	public FnncTaxsub getById(String id);
	
	public List<FnncTaxsub> findAll();
	
	
}
