/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;
import com.mf.base.BaseDao;
import com.mf.financemng.entity.AuditReport;
import com.mf.financemng.entity.Profit;
import com.mf.util.PageView;

/**
 * @author wangyw
 * @2015-08-20
 * @version 1.0
 * @param <T>
 */
public interface ProfitDao extends BaseDao<Profit>{
	public List<Profit> findAll() throws DataAccessException;
	public Profit getById(int id) throws DataAccessException;
	public void deleteById(String rptid) throws DataAccessException;
	public Profit getProfit(Profit p) throws DataAccessException;
	public void updateProfit(Profit profit) throws DataAccessException;
	public void deleteProfit(String rptmonth) throws DataAccessException;
	public List<Profit> query1(Profit profit) throws DataAccessException;
	public List<Profit> query2(Profit profit) throws DataAccessException;
	public List<Profit> getByRptid(String rptid) throws DataAccessException;
	public List<Profit> getByRptmonth(String rptmonth) throws DataAccessException;
	


}
