/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.businessInfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.businessInfo.dao.MothDao;
import com.mf.businessInfo.entity.Checkinfo;
import com.mf.businessInfo.service.MothService;
import com.mf.financemng.entity.FnncLedger;
import com.mf.util.PageView;
/**
 * @author wangyw
 * @2015-08-22
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("mothService")
public class MothServiceImpl implements MothService {
	@Autowired
	private MothDao mothDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param moth
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, Checkinfo moth) {
		List<Checkinfo> list = mothDao.query(pageView, moth);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param Moth moth
	 * @return List<Moth>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<Checkinfo> queryAll(Checkinfo moth) {
		List<Checkinfo> list = mothDao.queryAll(moth);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param moth
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(Checkinfo moth) {
		mothDao.add(moth);
	}
	
	/**
	 * 新增操作
	 * @param moth
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(Checkinfo moth) {
		mothDao.addAll(moth);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		mothDao.delete(id);
	}
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public Checkinfo getById(String id) {
		return mothDao.getById(id);
	}
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<Checkinfo> getById2(String id) {
		return mothDao.getById2(id);
	}
	/**
	 * 修改实体类
	 * @param moth
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(Checkinfo moth) {
		mothDao.modify(moth);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<Checkinfo> findAll() {
		return mothDao.findAll();
	}

	@Override
	public void initFromExcel(FnncLedger fnncLedger, String[][] a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Checkinfo> getBank() {
		// TODO Auto-generated method stub
		return mothDao.getBank();
	}

	@Override
	public void delete2(String month) {
		// TODO Auto-generated method stub
		mothDao.delete2(month);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
