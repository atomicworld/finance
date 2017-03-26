/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.financemng.dao.FnncTaxsubDao;
import com.mf.financemng.entity.FnncTaxsub;
import com.mf.financemng.service.FnncTaxsubService;
import com.mf.util.PageView;

/**
 * @author wangyw
 * @2015-08-19
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("fnncTaxsubService")
public class FnncTaxsubServiceImpl implements FnncTaxsubService {
	@Autowired
	private FnncTaxsubDao fnncTaxsubDao;

	/**
	 * 分页查询
	 * @param pageView
	 * @param fnncTaxsub
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView,FnncTaxsub fnncTaxsub,String search) {
		List<FnncTaxsub> list =null;
		
		if(fnncTaxsub.getEndmonth()!=null&&!"".equals(fnncTaxsub.getEndmonth().toString().trim())){
			if("1".equals(search.trim())){//等于
				 list = fnncTaxsubDao.query1(pageView, fnncTaxsub);
			}else if("2".equals(search.trim())){//大于
				 list = fnncTaxsubDao.query2(pageView, fnncTaxsub);
			}else if("3".equals(search.trim())){//小于
				 list = fnncTaxsubDao.query3(pageView, fnncTaxsub);
			}
		}else{
			list = fnncTaxsubDao.query(pageView, fnncTaxsub);
		}
		
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param FnncTaxsub fnncTaxsub
	 * @return List<FnncTaxsub>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FnncTaxsub> queryAll(FnncTaxsub fnncTaxsub) {
		List<FnncTaxsub> list = fnncTaxsubDao.queryAll(fnncTaxsub);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param fnncTaxsub
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(FnncTaxsub fnncTaxsub) {
		fnncTaxsubDao.add(fnncTaxsub);
	}
	
	/**
	 * 新增操作
	 * @param fnncTaxsub
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(FnncTaxsub fnncTaxsub) {
		fnncTaxsubDao.addAll(fnncTaxsub);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		fnncTaxsubDao.delete(id);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void deleteById(String id) {
		fnncTaxsubDao.deleteById(id);
	}
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public FnncTaxsub getById(String id) {
		return fnncTaxsubDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param fnncTaxsub
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(FnncTaxsub fnncTaxsub) {
		fnncTaxsubDao.modify(fnncTaxsub);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FnncTaxsub> findAll() {
		return fnncTaxsubDao.findAll();
	}
	
}
