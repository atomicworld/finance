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
import com.mf.util.PageView;
import com.mf.util.*;
/**
 * @author yangchao
 * @2014-12-24
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface SysMenuService{

	public PageView query(PageView pageView,SysMenu sysMenu);
	
	public List<SysMenu> queryAll(SysMenu sysMenu);
	
	public void add(SysMenu sysMenu);
	
	public void addAll(SysMenu sysMenu);
	
	public void delete(String mnno);
	
	public void modify(SysMenu sysMenu);
	
	public SysMenu findById(String id);
	
	public List<SysMenu> findAll();
	
	
}
