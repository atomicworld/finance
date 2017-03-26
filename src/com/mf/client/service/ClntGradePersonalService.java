/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.client.service;

import java.util.List;

import com.mf.client.entity.ClntGradePersonal;
import com.mf.util.*;
/**
 * @author wangyw
 * @2015-04-09
 * @version 1.0
 * @param <T>
 */

public interface ClntGradePersonalService{

	public PageView query(PageView pageView,ClntGradePersonal clntGradePersonal);
	
	public List<ClntGradePersonal> queryAll(ClntGradePersonal clntGradePersonal);
	
	public void add(ClntGradePersonal clntGradePersonal);
	
	public void addAll(ClntGradePersonal clntGradePersonal);
	
	public void delete(String id);
	
	public void modify(ClntGradePersonal clntGradePersonal);
	
	public ClntGradePersonal getById(String id);
	
	public List<ClntGradePersonal> findAll();
	
	
}
