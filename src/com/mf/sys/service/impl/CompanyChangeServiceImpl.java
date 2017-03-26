package com.mf.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.mf.sys.entity.*;
import com.mf.sys.dao.*;
import com.mf.sys.service.*;
import com.mf.util.*;
/**
 * @author hw
 * @2015-08-20
 */
@Transactional
@Service("companyChangeService")
public class CompanyChangeServiceImpl implements CompanyChangeService {
	@Autowired
	private CompanyChangeDao companyChangeDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param companyChange
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, CompanyChange companyChange) {
		List<CompanyChange> list = companyChangeDao.query(pageView, companyChange);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param CompanyChange companyChange
	 * @return List<CompanyChange>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<CompanyChange> queryAll(CompanyChange companyChange) {
		List<CompanyChange> list = companyChangeDao.queryAll(companyChange);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param companyChange
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(CompanyChange companyChange) {
		companyChangeDao.add(companyChange);
	}
	
	/**
	 * 新增操作
	 * @param companyChange
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(CompanyChange companyChange) {
		companyChangeDao.addAll(companyChange);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		companyChangeDao.deleteById(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public CompanyChange getById(String id) {
		return companyChangeDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param companyChange
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(CompanyChange companyChange) {
		companyChangeDao.modify(companyChange);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<CompanyChange> findAll() {
		return companyChangeDao.findAll();
	}
	
}
