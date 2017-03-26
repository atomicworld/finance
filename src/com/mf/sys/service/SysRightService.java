/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.sys.service;

import java.util.List;
import com.mf.sys.entity.*;
import com.mf.sys.dao.*;
import com.mf.sys.service.*;
import com.mf.util.*;
/**
 * @author yangchao
 * @2014-12-24
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface SysRightService{

	public PageView query(PageView pageView,SysRight sysRight);
	
	public List<SysRight> queryAll(SysRight sysRight);
	
	public void add(SysRight sysRight);
	
	public void addAll(SysRight sysRight);
	
	public void delete(String id);
	
	public void modify(SysRight sysRight);
	
	public SysRight getById(String id);
	
	public List<SysRight> findAll();
	
	
}
