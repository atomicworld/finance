/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.cntrtmng.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.cntrtmng.entity.BsnsCntrct;
import com.mf.util.PageView;


public interface BsnsCntrctDao extends BaseDao<BsnsCntrct>{
	public List<BsnsCntrct> findAll() throws DataAccessException;

	/**
	 * 返回分页后的待签订合同列表数据
	 * @param pageView
	 * @param t
	 * @return
	 */
	public List<BsnsCntrct> queryPend(@Param("pageView")PageView pageView, @Param("t")BsnsCntrct t) throws DataAccessException;
	public List<BsnsCntrct> queryOuting(@Param("pageView")PageView pageView, @Param("sttList")List<String> sttList,@Param("t")BsnsCntrct t) throws DataAccessException;
	public void signCntrct(BsnsCntrct bsnsCntrct) throws DataAccessException;
	public void update(BsnsCntrct bsnsCntrct) throws DataAccessException;
	public String  getByClntNo(String cntrctno) throws DataAccessException;
	public BsnsCntrct findByCntrctno(String cntrctno);
    public int isHave(String clntno);
	public List<BsnsCntrct> querySignNew(@Param("pageView")PageView pageView, @Param("t")BsnsCntrct t);

	public List<BsnsCntrct> querySignEnd(@Param("pageView")PageView pageView, @Param("t")BsnsCntrct t);

	public List<BsnsCntrct> queryCntrctEnd(@Param("pageView")PageView pageView, @Param("t")BsnsCntrct t);
	
	public List<BsnsCntrct> queryCancel(@Param("pageView")PageView pageView,@Param("t")BsnsCntrct bsnsCntrct);

	public List<BsnsCntrct> queryNrmlOuted(@Param("pageView")PageView pageView, @Param("t")BsnsCntrct t) throws DataAccessException;
	
	public List<BsnsCntrct> queryBlOuted(@Param("pageView")PageView pageView, @Param("t")BsnsCntrct t) throws DataAccessException;
	
	public List<BsnsCntrct> queryNine(@Param("pageView")PageView pageView, @Param("t")BsnsCntrct t) throws DataAccessException;
	//wyy导出
	public List<BsnsCntrct> queryExcel(BsnsCntrct bsnsCntrct);
	//wyy
	public void delCntrct(String cntrctno);
	//wyy
	public void copyLog(String cntrctno);
	//wyy
	public BsnsCntrct getByPrintInfo(String cntrctno);
	//wyy
	public List<BsnsCntrct> findList(BsnsCntrct bsnscntrct);
	//wyy
	public BsnsCntrct getByApplyno(String applyno);
	
	// add by hw
	public List<BsnsCntrct> queryCntrctRevoke(@Param("pageView")PageView pageView, @Param("t")BsnsCntrct bsnscntrct) throws DataAccessException;
	public void revokeCntrct(String cntrctno);
	public List<BsnsCntrct> queryRevokeExcel(BsnsCntrct bsnscntrct);//导出
}
