/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.flowmng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.mf.flowmng.dao.FlowApprlerDao;
import com.mf.flowmng.entity.FlowApprler;
import com.mf.flowmng.service.FlowApprlerService;
import com.mf.util.PageView;



/**
 * @author yangchao
 * @2015-01-16
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("flowApprlerService")
public class FlowApprlerServiceImpl implements FlowApprlerService {
	@Autowired
	private FlowApprlerDao flowApprlerDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param flowApprler
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, FlowApprler flowApprler) {
		List<FlowApprler> list = flowApprlerDao.query(pageView, flowApprler);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param FlowApprler flowApprler
	 * @return List<FlowApprler>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FlowApprler> queryAll(FlowApprler flowApprler) {
		List<FlowApprler> list = flowApprlerDao.queryAll(flowApprler);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param flowApprler
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(FlowApprler flowApprler) {
		flowApprlerDao.add(flowApprler);
	}
	

	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		flowApprlerDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public FlowApprler getById(String id) {
		return flowApprlerDao.getById(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public FlowApprler getById1(String id) {
		return flowApprlerDao.getById1(id);
	}
	//wyy
	@Transactional(readOnly=true)
	public int getByOpno(String opno){
		return  flowApprlerDao.getByOpno(opno);
	}
	/**
	 * 修改实体类
	 * @param flowApprler
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(FlowApprler flowApprler) {
		flowApprlerDao.modify(flowApprler);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FlowApprler> findAll() {
		return flowApprlerDao.findAll();
	}
	
}
