/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.flowmng.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.flowmng.entity.FlowApprler;


/**
 * @author yangchao
 * @2015-01-16
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
public interface FlowApprlerDao extends BaseDao<FlowApprler>{
	public List<FlowApprler> findAll() throws DataAccessException;
    public FlowApprler getById1(String id)throws DataAccessException;
    public int getByOpno(String opno);

}
