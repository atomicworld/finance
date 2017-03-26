/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.flowmng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.flowmng.dao.FlowApprlBaseDao;
import com.mf.flowmng.entity.FlowApprlBase;
import com.mf.flowmng.service.FlowApprlBaseService;
import com.mf.util.PageView;

import java.util.List;


/**
 * @author shenguangdong
 * @2015-01-09
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("flowApprlBaseService")
public class FlowApprlBaseServiceImpl implements FlowApprlBaseService {
	@Autowired
	private FlowApprlBaseDao flowApprlBaseDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param flowApprlBase
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, FlowApprlBase flowApprlBase) {
		List<FlowApprlBase> list = flowApprlBaseDao.query(pageView, flowApprlBase);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param FlowApprlBase flowApprlBase
	 * @return List<FlowApprlBase>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FlowApprlBase> queryAll(FlowApprlBase flowApprlBase) {
		List<FlowApprlBase> list = flowApprlBaseDao.queryAll(flowApprlBase);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param flowApprlBase
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(FlowApprlBase flowApprlBase) {
		flowApprlBaseDao.add(flowApprlBase);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		flowApprlBaseDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public FlowApprlBase getById(String id) {
		return flowApprlBaseDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param flowApprlBase
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(FlowApprlBase flowApprlBase) {
		flowApprlBaseDao.modify(flowApprlBase);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FlowApprlBase> findAll() {
		return flowApprlBaseDao.findAll();
	}
	
}
