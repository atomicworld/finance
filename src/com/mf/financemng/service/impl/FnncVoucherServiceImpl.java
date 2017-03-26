/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.cntrtmng.entity.BsnsCntrct;
import com.mf.financemng.dao.FnncVoucherDao;
import com.mf.financemng.entity.FnncVoucher;
import com.mf.financemng.service.FnncVoucherService;
import com.mf.util.PageView;

import java.util.List;

/**
 * @author yangchao
 * @2015-03-03
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("fnncVoucherService")
public class FnncVoucherServiceImpl implements FnncVoucherService {
	@Autowired
	private FnncVoucherDao fnncVoucherDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param fnncVoucher
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, FnncVoucher fnncVoucher) {
		List<FnncVoucher> list = fnncVoucherDao.query(pageView, fnncVoucher);
		pageView.setRecords(list);
		return pageView;
	}
	@Transactional(readOnly=true)
	public PageView queryOutmnt(PageView pageView,BsnsCntrct bsnscntrct){
		List<BsnsCntrct> list = fnncVoucherDao.queryOutmnt(pageView, bsnscntrct);
		pageView.setRecords(list);
		return pageView;
	}
	@Transactional(readOnly=true)
	public PageView queryPaymnt(PageView pageView,BsnsCntrct bsnscntrct){
		List<BsnsCntrct> list = fnncVoucherDao.queryPaymnt(pageView, bsnscntrct);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param FnncVoucher fnncVoucher
	 * @return List<FnncVoucher>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FnncVoucher> queryAll(FnncVoucher fnncVoucher) {
		List<FnncVoucher> list = fnncVoucherDao.queryAll(fnncVoucher);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param fnncVoucher
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(FnncVoucher fnncVoucher) {
		fnncVoucherDao.add(fnncVoucher);
	}
	
	/**
	 * 新增操作
	 * @param fnncVoucher
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(FnncVoucher fnncVoucher) {
		fnncVoucherDao.addAll(fnncVoucher);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		fnncVoucherDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public FnncVoucher getById(String id) {
		return fnncVoucherDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param fnncVoucher
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(FnncVoucher fnncVoucher) {
		fnncVoucherDao.modify(fnncVoucher);
	}

}
