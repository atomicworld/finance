package com.mf.financemng.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.common.util.StringUtil;
import com.mf.financemng.dao.FnncShareholderDao;
import com.mf.financemng.entity.FnncShareholder;
import com.mf.financemng.service.FnncShareholderService;
import com.mf.org.entity.Operator;
import com.mf.util.PageView;
/**
 * @author chenenze
 * @2015-02-10
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("fnncShareholderService")
public class FnncShareholderServiceImpl implements FnncShareholderService {
	@Autowired
	private FnncShareholderDao fnncShareholderDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param fnncShareholder
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, FnncShareholder fnncShareholder) {
		List<FnncShareholder> list = fnncShareholderDao.query(pageView, fnncShareholder);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param FnncShareholder fnncShareholder
	 * @return List<FnncShareholder>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FnncShareholder> queryAll(FnncShareholder fnncShareholder) {
		List<FnncShareholder> list = fnncShareholderDao.queryAll(fnncShareholder);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param fnncShareholder
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(FnncShareholder fnncShareholder,HttpServletRequest request) {
		
		//新增股东时，出资金额（比例）默认赋值变股后金额（比例），在列表显示变股后的金额（比例）
		fnncShareholder.setUpinvamt(fnncShareholder.getInvamt());
		fnncShareholder.setUpprate(fnncShareholder.getPrate());
		fnncShareholder.setUpsharesdate(fnncShareholder.getSharesdate());
		//新增部门编号  
		Operator user = (Operator)request.getSession().getAttribute("operator");
		String dptno = user.getDptno();
		String opno = user.getEmplyno();	
		fnncShareholder.setRegopno(opno);
		fnncShareholder.setDepno(dptno);
		//登记日期
		String nowDt = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
		fnncShareholder.setScdate(nowDt);
		
		fnncShareholderDao.add(fnncShareholder);
	}
	
	/**
	 * 新增操作
	 * @param fnncShareholder
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(FnncShareholder fnncShareholder) {
		fnncShareholderDao.addAll(fnncShareholder);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		fnncShareholderDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public FnncShareholder getById(String id) {
		return fnncShareholderDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param fnncShareholder
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(FnncShareholder fnncShareholder) {
		String nowDt = StringUtil.getFormatDate(new Date(), "yyyyMMdd");	
		fnncShareholder.setLastmoddate(nowDt);
		fnncShareholderDao.modify(fnncShareholder);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FnncShareholder> findAll() {
		return fnncShareholderDao.findAll();
	}
	//查询股东信息
	@Override
	public FnncShareholder findbynm(String sharholdnm) {
		FnncShareholder fnncShareholder=fnncShareholderDao.findbynm(sharholdnm);
		return fnncShareholder;
	}
	/**
	 * 分页查询
	 * @param pageView
	 * @param fnncShareholder
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView queryhistory(PageView pageView,FnncShareholder fnncShareholder) {
		List<FnncShareholder> list=fnncShareholderDao.queryhistory(pageView, fnncShareholder);
		pageView.setRecords(list);
		return pageView;
	}
	
}
