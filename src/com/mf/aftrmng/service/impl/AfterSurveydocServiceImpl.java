/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.aftrmng.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.aftrmng.dao.AfterSurveydocDao;
import com.mf.aftrmng.entity.AfterSurveydoc;
import com.mf.aftrmng.service.AfterSurveydocService;
import com.mf.common.util.StringUtil;
import com.mf.common.util.WaterIdGener;
import com.mf.org.entity.Operator;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2015-01-21
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("afterSurveydocService")
public class AfterSurveydocServiceImpl implements AfterSurveydocService {
	@Autowired
	private AfterSurveydocDao afterSurveydocDao;
	
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param afterSurveydoc
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, AfterSurveydoc afterSurveydoc) {
		List<AfterSurveydoc> list = afterSurveydocDao.query(pageView, afterSurveydoc);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param AfterSurveydoc afterSurveydoc
	 * @return List<AfterSurveydoc>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<AfterSurveydoc> queryAll(AfterSurveydoc afterSurveydoc) {
		List<AfterSurveydoc> list = afterSurveydocDao.queryAll(afterSurveydoc);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param afterSurveydoc
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(AfterSurveydoc afterSurveydoc,HttpServletRequest request) {
		String srlno = WaterIdGener.getWaterId();		
		afterSurveydoc.setSrlno(srlno);

		String nowDt = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
		//报告名称"贷后跟踪报告"+"_"+nowDt+"_"+顺序号；暂时用流水号代替
		String docnm ="贷后跟踪报告"+"_"+srlno;
		afterSurveydoc.setDocdt(nowDt);	
		afterSurveydoc.setDocnm(docnm);
		
		//设置部门编号和操作员编号
		Operator user = (Operator)request.getSession().getAttribute("operator");
		String dptno = user.getDptno();
		String opno = user.getEmplyno();
		afterSurveydoc.setDptno(dptno);
		afterSurveydoc.setOpno(opno);

		//向Afer_Surveydoc表插入数据
		afterSurveydocDao.add(afterSurveydoc);
	}
	
	/**
	 * 新增操作
	 * @param afterSurveydoc
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(AfterSurveydoc afterSurveydoc) {
		afterSurveydocDao.addAll(afterSurveydoc);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		afterSurveydocDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public AfterSurveydoc getById(String id) {
		return afterSurveydocDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param afterSurveydoc
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(AfterSurveydoc afterSurveydoc) {
		
		String nowDt = StringUtil.getFormatDate(new Date(), "yyyyMMdd");	
		afterSurveydoc.setUpdtdt(nowDt);
		afterSurveydocDao.modify(afterSurveydoc);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<AfterSurveydoc> findAll() {
		return afterSurveydocDao.findAll();
	}


	
}
