/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.client.dao.ClntPersonShopDao;
import com.mf.client.entity.ClntPersonShop;
import com.mf.client.service.ClntPersonShopService;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-16
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("clntPersonShopService")
public class ClntPersonShopServiceImpl implements ClntPersonShopService {
	@Autowired
	private ClntPersonShopDao clntPersonShopDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param clntPersonShop
	 * @return
	 */
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, ClntPersonShop clntPersonShop) {
		List<ClntPersonShop> list = clntPersonShopDao.query(pageView, clntPersonShop);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param ClntPersonShop clntPersonShop
	 * @return List<ClntPersonShop>
	 */
	@Transactional(readOnly=true)
	public List<ClntPersonShop> queryAll(ClntPersonShop clntPersonShop) {
		List<ClntPersonShop> list = clntPersonShopDao.queryAll(clntPersonShop);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param clntPersonShop
	 * @return
	 */
	public void add(ClntPersonShop clntPersonShop) {
		clntPersonShopDao.add(clntPersonShop);
	}
	
	/**
	 * 新增操作
	 * @param clntPersonShop
	 * @return
	 */
	public void addAll(ClntPersonShop clntPersonShop) {
		clntPersonShopDao.addAll(clntPersonShop);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	public void delete(String id) {
		clntPersonShopDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	@Transactional(readOnly=true)
	public ClntPersonShop getById(String id) {
		return clntPersonShopDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param clntPersonShop
	 * @return
	 */
	public void modify(ClntPersonShop clntPersonShop) {
		clntPersonShopDao.modify(clntPersonShop);
	}

	/**
	 * 查找所有
	 * @return
	 */
	@Transactional(readOnly=true)
	public List<ClntPersonShop> findAll() {
		return clntPersonShopDao.findAll();
	}
	
}
