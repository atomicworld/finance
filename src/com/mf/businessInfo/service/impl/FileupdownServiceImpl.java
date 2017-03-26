/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.businessInfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.mf.businessInfo.entity.*;
import com.mf.businessInfo.dao.*;
import com.mf.businessInfo.service.*;
import com.mf.util.*;
/**
 * @author wangyw
 * @2015-08-26
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("fileupdownService")
public class FileupdownServiceImpl implements FileupdownService {
	@Autowired
	private FileupdownDao fileupdownDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param fileupdown
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, Fileupdown fileupdown) {
		List<Fileupdown> list = fileupdownDao.query(pageView, fileupdown);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param Fileupdown fileupdown
	 * @return List<Fileupdown>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<Fileupdown> queryAll(Fileupdown fileupdown) {
		List<Fileupdown> list = fileupdownDao.queryAll(fileupdown);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param fileupdown
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(Fileupdown fileupdown) {
		fileupdownDao.add(fileupdown);
	}
	
	/**
	 * 新增操作
	 * @param fileupdown
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(Fileupdown fileupdown) {
		fileupdownDao.addAll(fileupdown);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		fileupdownDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public Fileupdown getById(String id) {
		return fileupdownDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param fileupdown
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(Fileupdown fileupdown) {
		fileupdownDao.modify(fileupdown);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<Fileupdown> findAll() {
		return fileupdownDao.findAll();
	}
	// test   can delete it .
	public int count(Fileupdown test) {
		return ((FileupdownServiceImpl) fileupdownDao).count(test);
	}

	@Override
	public int count(String id) {
		
		return fileupdownDao.count(id);
	}
	
	/**
	 * 删除审计id
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void deleteByReportid(String reportid) {
		fileupdownDao.deleteByReportid(reportid);
	}
	
	/**
	 * 根据parentId查找记录
	 */
	public List<Fileupdown> getByReportid(String reportid) {
		List<Fileupdown> list = fileupdownDao.getByReportid(reportid);
		return list;
	}
	
	


}
