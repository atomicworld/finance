package com.mf.financemng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.financemng.dao.FnncCapitalreportmainDao;
import com.mf.financemng.entity.FnncCapitalreportmain;
import com.mf.financemng.service.FnncCapitalreportmainService;
import com.mf.util.PageView;

/**
 * @author chenenze
 * @2015-02-14
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("fnncCapitalreportmainService")
public class FnncCapitalreportmainServiceImpl implements FnncCapitalreportmainService {
	@Autowired
	private FnncCapitalreportmainDao fnncCapitalreportmainDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param fnncCapitalreportmain
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, FnncCapitalreportmain fnncCapitalreportmain) {
		List<FnncCapitalreportmain> list = fnncCapitalreportmainDao.query(pageView, fnncCapitalreportmain);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param FnncCapitalreportmain fnncCapitalreportmain
	 * @return List<FnncCapitalreportmain>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FnncCapitalreportmain> queryAll(FnncCapitalreportmain fnncCapitalreportmain) {
		List<FnncCapitalreportmain> list = fnncCapitalreportmainDao.queryAll(fnncCapitalreportmain);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param fnncCapitalreportmain
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(FnncCapitalreportmain fnncCapitalreportmain) {
		fnncCapitalreportmainDao.add(fnncCapitalreportmain);
	}
	
	/**
	 * 新增操作
	 * @param fnncCapitalreportmain
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(FnncCapitalreportmain fnncCapitalreportmain) {
		fnncCapitalreportmainDao.addAll(fnncCapitalreportmain);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		fnncCapitalreportmainDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public FnncCapitalreportmain getById(String id) {
		return fnncCapitalreportmainDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param fnncCapitalreportmain
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(FnncCapitalreportmain fnncCapitalreportmain) {
		fnncCapitalreportmainDao.modify(fnncCapitalreportmain);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FnncCapitalreportmain> findAll() {
		return fnncCapitalreportmainDao.findAll();
	}
	
}
