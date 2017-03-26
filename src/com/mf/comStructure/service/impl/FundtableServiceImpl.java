package com.mf.comStructure.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.mf.comStructure.entity.*;
import com.mf.comStructure.dao.*;
import com.mf.comStructure.service.*;
import com.mf.util.*;

@Transactional
@Service("fundtableService")
public class FundtableServiceImpl implements FundtableService {
	@Autowired
	private FundtableDao fundtableDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param fundtable
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, Fundtable fundtable) {
		List<Fundtable> list = fundtableDao.query(pageView, fundtable);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param Fundtable fundtable
	 * @return List<Fundtable>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<Fundtable> queryAll(Fundtable fundtable) {
		List<Fundtable> list = fundtableDao.queryAll(fundtable);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param fundtable
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(Fundtable fundtable) {
		fundtableDao.add(fundtable);
	}
	
	/**
	 * 新增操作
	 * @param fundtable
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(Fundtable fundtable) {
		fundtableDao.addAll(fundtable);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		fundtableDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public Fundtable getById(String id) {
		return fundtableDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param fundtable
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(Fundtable fundtable) {
		fundtableDao.modify(fundtable);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<Fundtable> findAll() {
		return fundtableDao.findAll();
	}
	
	//提交
	public void submit(String id){
		fundtableDao.submit(id);
	}
	
}
