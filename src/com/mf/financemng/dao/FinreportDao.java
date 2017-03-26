/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2016
 */

package com.mf.financemng.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mf.base.BaseDao;
import com.mf.financemng.entity.Finreport;
import com.mf.financemng.entity.Profit;

/**
 * @author wangyw
 * @2016-01-07
 * @version 1.0
 * @param <T>
 */
public interface FinreportDao extends BaseDao<Finreport>{
	public List<Finreport> findAll() throws DataAccessException;
	
	public Finreport getByRptmonth(Finreport finreport) throws DataAccessException;
	
	public void deleteByRptmonth(Finreport finreport) throws DataAccessException;
	
	public void deleteByRptid(String rptid) throws DataAccessException;
	
	public Finreport getByRptid(String rptid) throws DataAccessException;


}
