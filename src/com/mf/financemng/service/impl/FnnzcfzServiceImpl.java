/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.mf.financemng.dao.FnnzcfzDao;
import com.mf.financemng.entity.Fnnzcfz;
import com.mf.financemng.entity.Profit;
import com.mf.financemng.service.FnnzcfzService;
import com.mf.util.*;
/**
 * @author wangzhi
 * @2015-08-19
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("fnnzcfzService")
public class FnnzcfzServiceImpl implements FnnzcfzService {
	@Autowired
	private FnnzcfzDao fnnzcfzDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param fnnzcfz
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, Fnnzcfz fnnzcfz) {
		List<Fnnzcfz> list = fnnzcfzDao.query(pageView, fnnzcfz);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param Fnnzcfz fnnzcfz
	 * @return List<Fnnzcfz>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<Fnnzcfz> queryAll(Fnnzcfz fnnzcfz) {
		List<Fnnzcfz> list = fnnzcfzDao.queryAll(fnnzcfz);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param fnnzcfz
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(Fnnzcfz fnnzcfz) {
		fnnzcfzDao.add(fnnzcfz);
	}
	
	/**
	 * 新增操作
	 * @param fnnzcfz
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(Fnnzcfz fnnzcfz) {
		fnnzcfzDao.addAll(fnnzcfz);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		fnnzcfzDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public Fnnzcfz getById(String id) {
		return fnnzcfzDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param fnnzcfz
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(Fnnzcfz fnnzcfz) {
		fnnzcfzDao.modify(fnnzcfz);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<Fnnzcfz> findAll() {
		return fnnzcfzDao.findAll();
	}

	@Override
	public void deleteById(int id) {
		fnnzcfzDao.deleteById(id);
		
	}

	@Override
	public Fnnzcfz getByZcfzId(int id) {
		// TODO Auto-generated method stub
		return fnnzcfzDao.getByZcfzId(id);
	}
	
	/**
	 * 删除资产负债表记录
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void deleteFnnzcfz(String reportMonth) {
		fnnzcfzDao.deleteFnnzcfz(reportMonth);
	}
	
	/**
	 * 根据reportMonth和parentId查找实体类
	 * @param reportMonth
	 * @param parentId
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public Fnnzcfz getFnnzcfz(Fnnzcfz f) {
		return fnnzcfzDao.getFnnzcfz(f);
	}
	

	/**
	 * 修改资产负债表实体类
	 * @param profit
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void updateFnnzcfz(Fnnzcfz fnnzcfz) {
		fnnzcfzDao.updateFnnzcfz(fnnzcfz);
	}

	@Override
	public Fnnzcfz getByReport(String reportMonth) {
		// TODO Auto-generated method stub
		return fnnzcfzDao.getByReport(reportMonth);
	}

	@Override
	public void deleteByFlag(String id) {
		// deleteByFlag
		fnnzcfzDao.deleteByFlag(id);
	}
	
}
