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
import com.mf.client.entity.Fixedassets;
import com.mf.financemng.entity.FinanceCashFlow;
import com.mf.financemng.entity.FinanceShareholder;

/**
 * @author wangzhi
 * @2015-08-23
 * @version 1.0
 * @param <T>
 */
public interface FinanceShareholderDao extends BaseDao<FinanceShareholder>{
	
	/*public List<FinanceShareholder> getParendId(FinanceShareholder financeShareholder) throws DataAccessException;*/
	
	public void deleteById(int id) throws DataAccessException;
	
	public void batchUpdate(List<FinanceShareholder> list) throws DataAccessException;

	public void deleteByIdRptid(String ids);

	public void addlistbean(@Param("listsh")List<FinanceShareholder> listsh);

}
