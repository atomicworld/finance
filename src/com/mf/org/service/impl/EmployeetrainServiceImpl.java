package com.mf.org.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.mf.org.entity.*;
import com.mf.org.dao.*;
import com.mf.org.service.*;
import com.mf.util.*;
/**
 * @author hw
 * @2015-08-21
 */
@Transactional
@Service("employeetrainService")
public class EmployeetrainServiceImpl implements EmployeetrainService {
	@Autowired
	private EmployeetrainDao employeetrainDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param employeetrain
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, Employeetrain employeetrain) {
		List<Employeetrain> list = employeetrainDao.query(pageView, employeetrain);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param Employeetrain employeetrain
	 * @return List<Employeetrain>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<Employeetrain> queryAll(Employeetrain employeetrain) {
		List<Employeetrain> list = employeetrainDao.queryAll(employeetrain);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param employeetrain
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(Employeetrain employeetrain) {
		employeetrainDao.add(employeetrain);
	}
	
	/**
	 * 新增操作
	 * @param employeetrain
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(Employeetrain employeetrain) {
		employeetrainDao.addAll(employeetrain);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		employeetrainDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public Employeetrain getById(String id) {
		return employeetrainDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param employeetrain
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(Employeetrain employeetrain) {
		employeetrainDao.modify(employeetrain);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<Employeetrain> findAll() {
		return employeetrainDao.findAll();
	}
	
	public void deleteByTrainno(String id){
		employeetrainDao.deleteByTrainno(id);
	}
	
}
