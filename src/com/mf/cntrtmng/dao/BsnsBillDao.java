/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.cntrtmng.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import com.mf.acctmoduel.entity.AdvancePay;
import com.mf.acctmoduel.entity.AdvancePayMoney;
import com.mf.aftrmng.entity.BsnsRepayplanAll;
import com.mf.base.BaseDao;
import com.mf.cntrtmng.entity.BsnsBill;
import com.mf.cntrtmng.entity.BsnsCntrct;
import com.mf.util.PageView;

/**
 * @author xujiuhua
 * @2015-01-13
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
public interface BsnsBillDao extends BaseDao<BsnsBill>{
	public List<BsnsBill> findAll() throws DataAccessException;

	public BsnsBill findByDueno(String deuno);
	public String getTotal(String cntrctno);
	public BsnsBill getByCntrctno(String cntrctno);
	public List<BsnsBill> queryWarn(@Param("pageView")PageView pageView, @Param("t")Map<String, Object> t) throws DataAccessException;
	public List<BsnsBill> queryOverWarn(@Param("pageView")PageView pageView, @Param("t")Map<String, Object> t) throws DataAccessException;
	
	public List<BsnsRepayplanAll> queryRtrnTimeWarn(@Param("pageView")PageView pageView, @Param("t")Map<String, Object> t) throws DataAccessException;
	public List<BsnsRepayplanAll> queryRtrnOverWarn(@Param("pageView")PageView pageView, @Param("t")Map<String, Object> t) throws DataAccessException;
	
//	public List<AdvancePayMoney> queryAdvance(@Param("pageView")PageView pageView, @Param("t")BsnsBill bsnsBill) throws DataAccessException;
	public List<AdvancePay> queryAdvance(@Param("pageView")PageView pageView, @Param("t")BsnsBill bsnsBill) throws DataAccessException;

	public List<BsnsBill> queryBillouted(@Param("pageView")PageView pageView, @Param("t")BsnsBill bsnsBill);
	public List<BsnsBill> queryCancel(@Param("pageView")PageView pageView, @Param("t")BsnsBill t) throws DataAccessException;
	
	public void deleteById(String id);
	
	public int count(BsnsBill bsnsBill);

	public List<BsnsBill> queryBLBill(@Param("pageView")PageView pageView, @Param("t")BsnsBill t)  throws DataAccessException;
}
