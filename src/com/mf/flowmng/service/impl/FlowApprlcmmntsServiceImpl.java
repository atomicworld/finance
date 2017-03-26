/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.flowmng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.flowmng.dao.FlowApprlcmmntsDao;
import com.mf.flowmng.entity.FlowApprlcmmnts;
import com.mf.flowmng.service.FlowApprlcmmntsService;
import com.mf.util.PageView;

import java.util.List;

	
/**
 * @author yangchao
 * @2015-01-18
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("flowApprlcmmntsService")
public class FlowApprlcmmntsServiceImpl implements FlowApprlcmmntsService {
	@Autowired
	private FlowApprlcmmntsDao flowApprlcmmntsDao;
	
	/**
	 * 分页查询 
	 * @param pageView
	 * @param flowApprlcmmnts
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	//@Transactional(readOnly=true)
	public PageView query(PageView pageView, FlowApprlcmmnts flowApprlcmmnts) {
		List<FlowApprlcmmnts> list = flowApprlcmmntsDao.query(pageView, flowApprlcmmnts);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param FlowApprlcmmnts flowApprlcmmnts
	 * @return List<FlowApprlcmmnts>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FlowApprlcmmnts> queryAll(FlowApprlcmmnts flowApprlcmmnts) {
		List<FlowApprlcmmnts> list = flowApprlcmmntsDao.queryAll(flowApprlcmmnts);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param flowApprlcmmnts
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(FlowApprlcmmnts flowApprlcmmnts) {
		flowApprlcmmntsDao.add(flowApprlcmmnts);
	}
	
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		flowApprlcmmntsDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	//@Transactional(readOnly=true)
	public FlowApprlcmmnts getById(String id) {
		return flowApprlcmmntsDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param flowApprlcmmnts
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(FlowApprlcmmnts flowApprlcmmnts) {
		flowApprlcmmntsDao.modify(flowApprlcmmnts);
	}

	 public PageView query1(PageView pageView,String applyno){
  	     List<FlowApprlcmmnts> list = flowApprlcmmntsDao.query1(pageView, applyno);
   		 pageView.setRecords(list);
   		 return pageView;
     }
	
}
