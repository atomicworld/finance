/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.sys.service;

import java.util.List;
import java.util.Map;
import com.mf.sys.entity.*;
import com.mf.sys.dao.*;
import com.mf.sys.service.*;
import com.mf.util.*;


public interface SysRoleService{

	public PageView query(PageView pageView,SysRole sysRole);
	
	public List<SysRole> queryAll(SysRole sysRole);
	
	public void add(SysRole sysRole);
	
	public void addAll(SysRole sysRole);
	
	public void delete(String id);
	
	public void modify(SysRole sysRole);
	
	public SysRole getById(String id);
	
	public List<SysRole> findAll();
	
	public List<SysRole> getByLvl(String lvl);
	
	public Map<SysMenu, List<SysRight>> findMenuRightMap();
	
	public String calcNewRoleId(String rllvl);
	
	public int countOp(String rlid);
}
