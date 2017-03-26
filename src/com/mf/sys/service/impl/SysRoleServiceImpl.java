/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;

import com.mf.sys.entity.*;
import com.mf.sys.dao.*;
import com.mf.sys.service.*;
import com.mf.util.*;
/**
 * @author yangchao
 * @2014-12-29
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
	@Autowired
	private SysRoleDao sysRoleDao;
	
	@Autowired
	private SysMenuDao sysMenuDao;
	
	@Autowired
	private SysRightDao sysRightDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param sysRole
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, SysRole sysRole) {
		List<SysRole> list = sysRoleDao.query(pageView, sysRole);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param SysRole sysRole
	 * @return List<SysRole>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<SysRole> queryAll(SysRole sysRole) {
		List<SysRole> list = null;
		//list = sysRoleDao.queryAll(sysRole);
		return list;
	}
	
	@Transactional(readOnly=true)
	public List<SysRole> getByLvl(String lvl){
		List<SysRole> list = sysRoleDao.getByLvl(lvl);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param sysRole
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(SysRole sysRole) {
		sysRoleDao.add(sysRole);
	}
	
	/**
	 * 计算权限字符串
	 * @param sysRole
	 * @return
	 */
	public StringBuffer calcRightStr(SysRole sysRole){
		String rlright = sysRole.getRlright();
		String[] rlrightArray = null;
		if(rlright.length() > 1){
			rlright = rlright.substring(1);
			rlrightArray = rlright.split("@");
		}
		String rightMaxNo = sysRightDao.getMaxRghtNo();
		int rightNum = 0;
		
		if(rightMaxNo != null && (!rightMaxNo.equals(""))){
			rightNum = Integer.parseInt(rightMaxNo);
		}
		List<String> lst = new ArrayList<String>();
		for (int i = 0; i < rightNum; i++) {
			lst.add("0");
		}
	 
		if ((rlrightArray != null) && (rlrightArray.length > 0)){
			for (int i = 0; i < rlrightArray.length; i++){
				lst.set(Integer.parseInt(rlrightArray[i]) - 1, "1");
			}
		}
	 
		StringBuffer sb = new StringBuffer();
		for (String one : lst) {
			sb.append(one);
		}
		return sb;
	} 
	/**
	 * 新增操作
	 * @param sysRole
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(SysRole sysRole) {
		//计算新增id
		String newRoleId = calcNewRoleId(sysRole.getRllvl());
		sysRole.setRlid(newRoleId);
		//计算权限字符串
		StringBuffer sb = calcRightStr(sysRole);
		sysRole.setRlright(sb.toString());
		
		sysRoleDao.addAll(sysRole);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		sysRoleDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public SysRole getById(String id) {
		return sysRoleDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param sysRole
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(SysRole sysRole) {
		StringBuffer sb = calcRightStr(sysRole);
		sysRole.setRlright(sb.toString());
		
		sysRoleDao.modify(sysRole);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<SysRole> findAll() {
		return sysRoleDao.findAll();
	}
	
	/**
	 * 查询一级菜单和对应权限的Map
	 */
	public Map<SysMenu, List<SysRight>> findMenuRightMap(){
		Map<SysMenu, List<SysRight>> menuRightMap = new LinkedHashMap<SysMenu, List<SysRight>>();
		
		//获取一级菜单项目
		List<SysMenu> firstLvlMnList = sysMenuDao.findByMnLen(1);
		
		for(int i=0; i<firstLvlMnList.size(); i++){
			SysMenu menu = firstLvlMnList.get(i);
			String menuNo = menu.getMnno();
			List<SysRight> rightList = sysRightDao.getRghtByFirstMn(menuNo);
			
			menuRightMap.put(menu, rightList);
		}
		return menuRightMap;
	}
	
	public String calcNewRoleId(String rllvl){
		String newRoleId = sysRoleDao.calcNewRoleId(rllvl);
		if(newRoleId != null){
			if (newRoleId.length() == 1){
				newRoleId = rllvl + "0" + newRoleId;
			}
			if (newRoleId.length() == 2){
				newRoleId = rllvl + newRoleId;
		    }
		}else{
			newRoleId = rllvl + "01";
		}
		return newRoleId;
	}
	
	//查询该角色
	public int countOp(String rlid){
		return sysRoleDao.countOp(rlid);
	}
}
