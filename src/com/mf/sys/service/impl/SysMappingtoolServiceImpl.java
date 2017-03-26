package com.mf.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.mf.sys.entity.*;
import com.mf.sys.dao.*;
import com.mf.sys.service.*;
import com.mf.util.*;

@Transactional
@Service("sysMappingtoolService")
public class SysMappingtoolServiceImpl implements SysMappingtoolService {
	@Autowired
	private SysMappingtoolDao sysMappingtoolDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param sysMappingtool
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, SysMappingtool sysMappingtool) {
		List<SysMappingtool> list = sysMappingtoolDao.query(pageView, sysMappingtool);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param SysMappingtool sysMappingtool
	 * @return List<SysMappingtool>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<SysMappingtool> queryAll(SysMappingtool sysMappingtool) {
		List<SysMappingtool> list = sysMappingtoolDao.queryAll(sysMappingtool);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param sysMappingtool
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(SysMappingtool sysMappingtool) {
		sysMappingtoolDao.add(sysMappingtool);
	}
	
	/**
	 * 新增操作
	 * @param sysMappingtool
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(SysMappingtool sysMappingtool) {
		sysMappingtoolDao.addAll(sysMappingtool);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		sysMappingtoolDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public SysMappingtool getByPreKey(String prekey) {
		return sysMappingtoolDao.getById(prekey);
	}
	
	/**
	 * 修改实体类
	 * @param sysMappingtool
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(SysMappingtool sysMappingtool) {
		sysMappingtoolDao.modify(sysMappingtool);
	}

	
	public String getSerialnumber(SysMappingtool sysMappingtool){
		return sysMappingtoolDao.getSerialnumber(sysMappingtool);
	}
	public void modifySerialnumber(SysMappingtool sysMappingtool){
		sysMappingtoolDao.modifySerialnumber(sysMappingtool);
	}
	public void initSerialnumber(SysMappingtool sysMappingtool){
		sysMappingtoolDao.initSerialnumber(sysMappingtool);
	}
}
