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

import com.mf.client.entity.Fixedassets;
import com.mf.financemng.dao.FinanceShareholderDao;
import com.mf.financemng.entity.FinanceShareholder;
import com.mf.financemng.service.FinanceShareholderService;
import com.mf.util.*;
/**
 * @author wangzhi
 * @2015-08-23
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("financeShareholderService")
public class FinanceShareholderServiceImpl implements FinanceShareholderService {
	@Autowired
	private FinanceShareholderDao financeShareholderDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param financeShareholder
	 * @return
	 */
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, FinanceShareholder financeShareholder) {
		List<FinanceShareholder> list = financeShareholderDao.query(pageView, financeShareholder);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param FinanceShareholder financeShareholder
	 * @return List<FinanceShareholder>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FinanceShareholder> queryAll(FinanceShareholder financeShareholder) {
		List<FinanceShareholder> list = financeShareholderDao.queryAll(financeShareholder);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param financeShareholder
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(FinanceShareholder financeShareholder) {
		financeShareholderDao.add(financeShareholder);
	}
	
	/**
	 * 新增操作
	 * @param financeShareholder
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(FinanceShareholder financeShareholder) {
		financeShareholderDao.addAll(financeShareholder);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		financeShareholderDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public FinanceShareholder getById(String id) {
		return financeShareholderDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param financeShareholder
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(FinanceShareholder financeShareholder) {
		financeShareholderDao.modify(financeShareholder);
	}

	@Override
	public void deleteById(int id) {
		financeShareholderDao.deleteById(id);
		
	}
	/**
	 * 批量修改
	 */
	@Override
	public void batchUpdate(List<FinanceShareholder> list) {
		financeShareholderDao.batchUpdate(list);
	}

	@Override
	public void deleteByIdRptid(String ids) {
		financeShareholderDao.deleteByIdRptid(ids);
	}

	@Override
	public void addlistbean(List<FinanceShareholder> listsh) {
		// TODO Auto-generated method stub
		financeShareholderDao.addlistbean(listsh);
	}


}
