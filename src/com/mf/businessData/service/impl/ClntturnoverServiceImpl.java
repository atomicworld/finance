/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.businessData.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.businessData.dao.ClntturnoverDao;
import com.mf.businessData.entity.Clntturnover;
import com.mf.businessData.service.ClntturnoverService;
import com.mf.client.dao.ClntClientDao;
import com.mf.client.entity.ClntClient;
import com.mf.util.PageView;

import java.util.List;

/**
 * @author yangchao
 * @2015-04-02
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("clntturnoverService")
public class ClntturnoverServiceImpl implements ClntturnoverService {
	@Autowired
	private ClntturnoverDao clntturnoverDao;
	@Autowired
	private ClntClientDao clntClientDao;
	/**
	 * 分页查询
	 * @param pageView
	 * @param clntturnover
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, Clntturnover clntturnover) {
		List<Clntturnover> list = clntturnoverDao.query(pageView, clntturnover);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param Clntturnover clntturnover
	 * @return List<Clntturnover>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<Clntturnover> queryAll(Clntturnover clntturnover) {
		List<Clntturnover> list = clntturnoverDao.queryAll(clntturnover);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param clntturnover
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(Clntturnover clntturnover) {
		clntturnoverDao.add(clntturnover);
		ClntClient clntClient=new ClntClient();
		clntClient.setUserid(clntturnover.getRcvopno());//接受人
		clntClient.setClntname(clntturnover.getOutopno());//移交人
		clntClientDao.updateAll(clntClient);
	}
	
	/**
	 * 新增操作
	 * @param clntturnover
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(Clntturnover clntturnover) {
		clntturnoverDao.addAll(clntturnover);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		clntturnoverDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public Clntturnover getById(String id) {
		return clntturnoverDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param clntturnover
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(Clntturnover clntturnover) {
		clntturnoverDao.modify(clntturnover);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<Clntturnover> findAll() {
		return clntturnoverDao.findAll();
	}
	
}
