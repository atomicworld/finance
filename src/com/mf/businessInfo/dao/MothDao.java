/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.businessInfo.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.businessInfo.entity.Checkinfo;
import com.raq.expression.function.datetime.Month;

/**
 * @author wangyw
 * @2015-08-22
 * @version 1.0
 * @param <T>
 */
public interface MothDao extends BaseDao<Checkinfo>{
	public List<Checkinfo> findAll() throws DataAccessException;

	public void deleteint(int id);
	public List<Checkinfo> getBank();
	//public Checkinfo isHave(String id);
	public List<Checkinfo> getById2( String month);

	public void delete2(String id);


}
