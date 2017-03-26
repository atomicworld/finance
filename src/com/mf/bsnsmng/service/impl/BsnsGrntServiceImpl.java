/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.bsnsmng.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.bsnsmng.service.BsnsGrntService;
import com.mf.bsnsmng.dao.BsnsGrntDao;
import com.mf.bsnsmng.entity.BsnsGrnt;
import com.mf.util.PageView;



/**
 * @author yangchao
 * @2015-01-07
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("bsnsGrntService")
public class BsnsGrntServiceImpl implements BsnsGrntService {
	@Autowired
	private BsnsGrntDao bsnsGrntDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param bsnsGrnt
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, BsnsGrnt bsnsGrnt) {
		List<BsnsGrnt> list = bsnsGrntDao.query(pageView, bsnsGrnt);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param BsnsGrnt bsnsGrnt
	 * @return List<BsnsGrnt>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<BsnsGrnt> queryAll(BsnsGrnt bsnsGrnt) {
		List<BsnsGrnt> list = bsnsGrntDao.queryAll(bsnsGrnt);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param bsnsGrnt
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(BsnsGrnt bsnsGrnt) {
		bsnsGrntDao.add(bsnsGrnt);
	}
	
	
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		bsnsGrntDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public BsnsGrnt getById(String id) {
		return bsnsGrntDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param bsnsGrnt
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(BsnsGrnt bsnsGrnt) {
		bsnsGrntDao.modify(bsnsGrnt);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<BsnsGrnt> findAll() {
		return bsnsGrntDao.findAll();
	}
	
	/**
	 * 根据申请编号查
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<BsnsGrnt> getByApplyno(String applyno) {
		return bsnsGrntDao.getByApplyno(applyno);
	}
	
}
