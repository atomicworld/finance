/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.mf.financemng.dao.ProfitDao;
import com.mf.financemng.entity.Profit;
import com.mf.financemng.service.ProfitService;
import com.mf.util.*;
/**
 * @author wangyw
 * @2015-08-20
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("profitService")
public class ProfitServiceImpl implements ProfitService {
	@Autowired
	private ProfitDao profitDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param profit
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, Profit profit) {
		List<Profit> list = profitDao.query(pageView, profit);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param Profit profit
	 * @return List<Profit>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<Profit> queryAll(Profit profit) {
		List<Profit> list = profitDao.queryAll(profit);
		return list;
	}
	
	/**
	 * 查询比当前时间小的记录
	 * @param profit
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<Profit> query1(Profit profit) {
		List<Profit> list = profitDao.query1(profit);
		return list;
	}
	
	/**
	 * 查询时间记录
	 * @param profit
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<Profit> query2(Profit profit) {
		List<Profit> list = profitDao.query2(profit);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param profit
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(Profit profit) {
		profitDao.add(profit);
	}
	
	/**
	 * 新增操作
	 * @param profit
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(Profit profit) {
		profitDao.addAll(profit);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void deleteById(String rptid) {
		profitDao.deleteById(rptid);
	}
	
	/**
	 * 删除利润表记录
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void deleteProfit(String rptmonth) {
		profitDao.deleteProfit(rptmonth);
	}
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public Profit getById(int id) {
		return profitDao.getById(id);
	}
	
	/**
	 * 根据montime查找实体类
	 * @param montime
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<Profit> getByRptmonth(String rptmonth) {
		List<Profit> list = profitDao.getByRptmonth(rptmonth);
		return list;
	}
	
	/**
	 * 根据montime和parentId查找实体类
	 * @param montime
	 * @param parentId
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public Profit getProfit(Profit p) {
		return profitDao.getProfit(p);
	}
	
	/**
	 * 修改实体类
	 * @param profit
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(Profit profit) {
		profitDao.modify(profit);
	}
	
	/**
	 * 修改利润表实体类
	 * @param profit
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void updateProfit(Profit profit) {
		profitDao.updateProfit(profit);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<Profit> findAll() {
		return profitDao.findAll();
	}

	@Override
	public List<Profit> getByRptid(String rptid) {
		List<Profit> list = profitDao.getByRptid(rptid);
		return list;
	}
	
}
