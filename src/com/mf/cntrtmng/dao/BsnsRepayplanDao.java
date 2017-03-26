/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.cntrtmng.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.cntrtmng.entity.BsnsRepayplan;
import com.mf.util.PageView;

/**
 * @author xujiuhua
 * @2015-01-13
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
public interface BsnsRepayplanDao extends BaseDao<BsnsRepayplan>{
	public List<BsnsRepayplan> findAll() throws DataAccessException;
	
	public List<BsnsRepayplan> queryStatus(@Param("pageView")PageView pageView, @Param("t")BsnsRepayplan t)throws DataAccessException;
	
	public List<BsnsRepayplan> queryDueno(PageView pageView,@Param("t") BsnsRepayplan t);
	
	public int getCountPlan(String dueno) throws DataAccessException;
	
	public List<BsnsRepayplan> getByDueno(String dueno)throws DataAccessException;
	
	//add by zhangcong
	public BsnsRepayplan getMaxByDueno(String dueno) throws DataAccessException;
	
	//从还款计划表中查找指定借据号，计划还款日期<当前日期的所有还款记录
	public List<BsnsRepayplan> getByDuenoPayed(String dueno) throws DataAccessException;
	
	public List<BsnsRepayplan> getByDuenoUnpay(BsnsRepayplan bsnsRepayplan) throws DataAccessException;
	
	public List<BsnsRepayplan> getByDuenoOldPlan(String dueno) throws DataAccessException;
	
	public List<BsnsRepayplan> getIsUnpayPlan(BsnsRepayplan bsnsRepayplan) throws DataAccessException;
	
	// hw end
	//wangzhi
	public List<BsnsRepayplan> queryBycyclesdt(BsnsRepayplan bsnsRepayplan) throws DataAccessException;
	
	// add by Fankb
	//根据借据号和还款日期获取还款计划信息
	public List<BsnsRepayplan> findAsEndDate(BsnsRepayplan bsnsRepayplan) throws DataAccessException;
	//根据借据号和还款期数号获取还款计划信息
	public double getMaxPayedSumAsDueNo(String dueno) throws DataAccessException;
	
	public List<BsnsRepayplan> query1(@Param("pageView")PageView pageView, @Param("t")BsnsRepayplan t)throws DataAccessException;
	public List<BsnsRepayplan> queryNew(BsnsRepayplan t)throws DataAccessException;

	public BsnsRepayplan getBySrlNo(String srlNo) throws DataAccessException;
	
	public List<BsnsRepayplan> query2(@Param("pageView")PageView pageView, @Param("t")BsnsRepayplan t)throws DataAccessException;

}
