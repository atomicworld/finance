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

import com.mf.flowmng.dao.FlowIncreaseCapitalDao;
import com.mf.flowmng.entity.FlowIncreaseCapital;
import com.mf.flowmng.service.FlowIncreaseCapitalService;
import com.mf.util.*;
/**
 * @author wangzhi
 * @2015-08-12
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("flowIncreaseCapitalService")
public class FlowIncreaseCapitalServiceImpl implements FlowIncreaseCapitalService {
	@Autowired
	private FlowIncreaseCapitalDao flowIncreaseCapitalDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param flowIncreaseCapital
	 * @return
	 */
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, FlowIncreaseCapital flowIncreaseCapital) {
		List<FlowIncreaseCapital> list = flowIncreaseCapitalDao.query(pageView, flowIncreaseCapital);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 新增操作
	 * @param flowIncreaseCapital
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(FlowIncreaseCapital flowIncreaseCapital) {
		flowIncreaseCapitalDao.add(flowIncreaseCapital);
	}
	
	/**
	 * 新增操作
	 * @param flowIncreaseCapital
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(FlowIncreaseCapital flowIncreaseCapital) {
		flowIncreaseCapitalDao.addAll(flowIncreaseCapital);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		flowIncreaseCapitalDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public FlowIncreaseCapital getById(String id) {
		return flowIncreaseCapitalDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param flowIncreaseCapital
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(FlowIncreaseCapital flowIncreaseCapital) {
		flowIncreaseCapitalDao.modify(flowIncreaseCapital);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FlowIncreaseCapital> findAll() {
		return flowIncreaseCapitalDao.findAll();
	}

	@Override
	public List<FlowIncreaseCapital> queryAll(
			FlowIncreaseCapital flowIncreaseCapital) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FlowIncreaseCapital getById(int id) {
		// TODO Auto-generated method stub
		return flowIncreaseCapitalDao.getCapitalById(id);
	}

	@Override
	public void delete(int id){
		flowIncreaseCapitalDao.deleteById(id);
		
	}
	
}
