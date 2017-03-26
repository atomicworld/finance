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

import com.mf.financemng.dao.FnncPrfdtlDao;
import com.mf.financemng.entity.FnncPrfbsList;
import com.mf.financemng.entity.FnncPrfdtl;
import com.mf.financemng.entity.FnncPrfdtlList;
import com.mf.financemng.service.FnncPrfdtlService;
import com.mf.util.PageView;
/**
 * @author yangchao
 * @2015-02-11
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("fnncPrfdtlService")
public class FnncPrfdtlServiceImpl implements FnncPrfdtlService {
	@Autowired
	private FnncPrfdtlDao fnncPrfdtlDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param fnncPrfdtl
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, FnncPrfdtl fnncPrfdtl) {
		List<FnncPrfdtl> list = fnncPrfdtlDao.query(pageView, fnncPrfdtl);
		pageView.setRecords(list);
		return pageView;
	}
	//汇总查询wangyw
	@Transactional(readOnly=true)
	public PageView queryAccnt(PageView pageView, FnncPrfdtlList fnncprfdtllist) {
		List<FnncPrfdtlList> list = fnncPrfdtlDao.queryAccnt(pageView, fnncprfdtllist);
		pageView.setRecords(list);
		return pageView;
	}
	//汇总查询- 恢复数据-wyy
		@Transactional(readOnly=true)
		public PageView queryAccntAll(PageView pageView, FnncPrfdtlList fnncprfdtllist) {
			List<FnncPrfdtlList> list = fnncPrfdtlDao.queryAccntAll(pageView, fnncprfdtllist);
			pageView.setRecords(list);
			return pageView;
		}
	
	/**
	 * 不分页查询
	 * @param FnncPrfdtl fnncPrfdtl
	 * @return List<FnncPrfdtl>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FnncPrfdtl> queryAll(FnncPrfdtl fnncPrfdtl) {
		List<FnncPrfdtl> list = fnncPrfdtlDao.queryAll(fnncPrfdtl);
		return list;
	}
	@Transactional(readOnly=true)
	public List<FnncPrfdtlList> querylist(String prftrcno){
		List<FnncPrfdtlList> list = fnncPrfdtlDao.querylist(prftrcno);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param fnncPrfdtl
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(FnncPrfdtl fnncPrfdtl) {
		fnncPrfdtlDao.add(fnncPrfdtl);
	}
	
	/**
	 * 新增操作
	 * @param fnncPrfdtl
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(FnncPrfdtl fnncPrfdtl) {
		fnncPrfdtlDao.addAll(fnncPrfdtl);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		fnncPrfdtlDao.delete(id);
	}
	
	public void deleteBysqnno(String sqnno){
		fnncPrfdtlDao.deleteBysqnno(sqnno);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public FnncPrfdtl getById(String id) {
		return fnncPrfdtlDao.getById(id);
	}
	@Transactional(readOnly=true)
	public List<FnncPrfdtl> getByPrfrtcno(String prfrtcno) {
		return fnncPrfdtlDao.getByPrfrtcno(prfrtcno);
	}
	
	/**
	 * 修改实体类
	 * @param fnncPrfdtl
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(FnncPrfdtl fnncPrfdtl) {
		fnncPrfdtlDao.modify(fnncPrfdtl);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FnncPrfdtl> findAll() {
		return fnncPrfdtlDao.findAll();
	}
	
}
