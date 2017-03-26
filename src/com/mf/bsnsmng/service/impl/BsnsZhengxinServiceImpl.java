/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.bsnsmng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.bsnsmng.dao.BsnsZhengxinDao;
import com.mf.bsnsmng.entity.BsnsZhengxin;
import com.mf.bsnsmng.service.BsnsZhengxinService;
/**
 * @author wangyw
 * @2015-07-13
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("bsnsZhengxinService")
public class BsnsZhengxinServiceImpl implements BsnsZhengxinService {
	@Autowired
	private BsnsZhengxinDao bsnsZhengxinDao;
	
	/**
	 * 新增操作
	 * @param bsnsZhengxin
	 * @return
	 */
	public void add(BsnsZhengxin bsnsZhengxin) {
		bsnsZhengxinDao.add(bsnsZhengxin);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	public void delete(String id) {
		bsnsZhengxinDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	@Transactional(readOnly=true)
	public BsnsZhengxin getById(String id) {
		return bsnsZhengxinDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param bsnsZhengxin
	 * @return
	 */
	public void modify(BsnsZhengxin bsnsZhengxin) {
		bsnsZhengxinDao.modify(bsnsZhengxin);
	}

}
