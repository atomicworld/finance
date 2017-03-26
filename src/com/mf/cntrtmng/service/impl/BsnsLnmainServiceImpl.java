/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.cntrtmng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.cntrtmng.dao.BsnsLnmainDao;
import com.mf.cntrtmng.entity.BsnsLnmain;
import com.mf.cntrtmng.service.BsnsLnmainService;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2015-01-21
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("bsnsLnmainService")
public class BsnsLnmainServiceImpl implements BsnsLnmainService {
	@Autowired
	private BsnsLnmainDao bsnsLnmainDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param bsnsLnmain
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, BsnsLnmain bsnsLnmain) {
		List<BsnsLnmain> list = bsnsLnmainDao.query(pageView, bsnsLnmain);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param BsnsLnmain bsnsLnmain
	 * @return List<BsnsLnmain>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<BsnsLnmain> queryAll(BsnsLnmain bsnsLnmain) {
		List<BsnsLnmain> list = bsnsLnmainDao.queryAll(bsnsLnmain);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param bsnsLnmain
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(BsnsLnmain bsnsLnmain) {
		bsnsLnmainDao.add(bsnsLnmain);
	}
	
	/**
	 * 新增操作
	 * @param bsnsLnmain
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(BsnsLnmain bsnsLnmain) {
		bsnsLnmainDao.addAll(bsnsLnmain);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		bsnsLnmainDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public BsnsLnmain getById(String id) {
		return bsnsLnmainDao.getById(id);
	}
	/**
	 * 根据业务编号（借据号）查找实体类
	 * @param bsnsno
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public BsnsLnmain findByBsnsno(String bsnsno) {
		return bsnsLnmainDao.findByBsnsno(bsnsno);
	}
	
	public BsnsLnmain cougtCntrctno(String cntrctno){
		return bsnsLnmainDao.cougtCntrctno(cntrctno);
	}
	
	/**
	 * 修改实体类
	 * @param bsnsLnmain
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(BsnsLnmain bsnsLnmain) {
		bsnsLnmainDao.modify(bsnsLnmain);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<BsnsLnmain> findAll() {
		return bsnsLnmainDao.findAll();
	}
	
	@Transactional(readOnly=true)
	public PageView queryextend(PageView pageView, BsnsLnmain bsnsLnmain) {
		List<BsnsLnmain> list = bsnsLnmainDao.queryextend(pageView, bsnsLnmain);
		pageView.setRecords(list);
		return pageView;
	}
}
