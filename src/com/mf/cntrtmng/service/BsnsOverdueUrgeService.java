/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.cntrtmng.service;

import java.util.List;
import java.util.Map;

import com.mf.cntrtmng.entity.BsnsOverdueUrge;
import com.mf.util.*;

/**
 * @author huangwen
 * @2015-05-29
 * @version 1.0
 * @param <T>
 */

public interface BsnsOverdueUrgeService{

	public void add(BsnsOverdueUrge bsnsOverdueUrge);
	
	public BsnsOverdueUrge getById(String id);
	
	public List<BsnsOverdueUrge> findBy(String srlno,String date);
	
	public List<BsnsOverdueUrge> findAll();
	
	public boolean exist(String srlno,String date);
	
	
}
