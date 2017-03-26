package com.mf.cntrtmng.service;

import java.util.List;

import com.mf.cntrtmng.entity.BsnsExtend;
import com.mf.util.*;
/**
 * @author wangyw
 * @2015-08-12
 * @version 1.0
 * @param <T>
 */

public interface BsnsExtendService{

	public PageView query(PageView pageView,BsnsExtend bsnsExtend);
	
	public List<BsnsExtend> queryAll(BsnsExtend bsnsExtend);
	
	public void add(BsnsExtend bsnsExtend);
	
	public void addAll(BsnsExtend bsnsExtend);
	
	public void delete(String id);
	
	public void modify(BsnsExtend bsnsExtend);
	
	public BsnsExtend getById(String id);
	
	public List<BsnsExtend> findAll();
	
	public boolean extend(BsnsExtend bsnsExtend);
	
	public BsnsExtend getByDueno(String dueno);
	
}