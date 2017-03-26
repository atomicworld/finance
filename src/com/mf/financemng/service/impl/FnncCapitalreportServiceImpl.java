package com.mf.financemng.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.financemng.dao.FnncCapitalreportDao;
import com.mf.financemng.dao.FnncCapitalreportmainDao;
import com.mf.financemng.entity.FnncCapitalreport;
import com.mf.financemng.service.FnncCapitalreportService;
import com.mf.util.PageView;
/**
 * @author chenenze
 * @2015-02-11
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("fnncCapitalreportService")
public class FnncCapitalreportServiceImpl implements FnncCapitalreportService {
	@Autowired
	private FnncCapitalreportDao fnncCapitalreportDao;
	@Autowired
	private FnncCapitalreportmainDao fnncCapitalreportmainDao;
	/**
	 * 分页查询
	 * @param pageView
	 * @param fnncCapitalreport
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, FnncCapitalreport fnncCapitalreport) {
		List<FnncCapitalreport> list = fnncCapitalreportDao.query(pageView, fnncCapitalreport);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param FnncCapitalreport fnncCapitalreport
	 * @return List<FnncCapitalreport>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FnncCapitalreport> queryAll(FnncCapitalreport fnncCapitalreport) {
		List<FnncCapitalreport> list = fnncCapitalreportDao.queryAll(fnncCapitalreport);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param fnncCapitalreport
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(FnncCapitalreport fnncCapitalreport,HttpServletRequest request) {

		fnncCapitalreportDao.add(fnncCapitalreport);
	
	}
	
	/**
	 * 新增操作
	 * @param fnncCapitalreport
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(FnncCapitalreport fnncCapitalreport) {
		fnncCapitalreportDao.addAll(fnncCapitalreport);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		fnncCapitalreportDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public FnncCapitalreport getById(String id) {
		return fnncCapitalreportDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param fnncCapitalreport
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(FnncCapitalreport fnncCapitalreport) {
		fnncCapitalreportDao.modify(fnncCapitalreport);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FnncCapitalreport> findAll(String id) {
		return fnncCapitalreportDao.findAll(id);
	}
	
}
