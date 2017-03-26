/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.aop.service;

import java.util.List;

import com.mf.aop.entity.AopModule;
import com.mf.util.*;
/**
 * @author wangzhi
 * @2015-09-21
 * @version 1.0
 * @param <T>
 */

public interface AopModuleService{

	public PageView query(PageView pageView,AopModule aopModule);
	
	public List<AopModule> queryAll(AopModule aopModule);
	
	public void add(AopModule aopModule);
	
	public void addAll(AopModule aopModule);
	
	public void delete(String id);
	
	public void modify(AopModule aopModule);
	
	public AopModule getById(String id);
	
	public List<AopModule> findAll();
	
	
}
