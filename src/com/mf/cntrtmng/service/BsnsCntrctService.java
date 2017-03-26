
package com.mf.cntrtmng.service;

import java.util.List;
import com.mf.cntrtmng.entity.*;
import com.mf.cntrtmng.dao.*;
import com.mf.cntrtmng.service.*;
import com.mf.util.*;


public interface BsnsCntrctService{

	public PageView query(PageView pageView,BsnsCntrct bsnsCntrct);
	
	public PageView queryNine(PageView pageView,BsnsCntrct bsnsCntrct);
	
	public PageView queryPend(PageView pageView,BsnsCntrct bsnsCntrct);
	
	public PageView queryOuting(PageView pageView, List<String> sttList, BsnsCntrct bsnsCntrct);
	
	public void signCntrct(BsnsCntrct bsnsCntrct);
	
	public void add(BsnsCntrct bsnsCntrct);
	
	public void addAll(BsnsCntrct bsnsCntrct);
	
	public void delete(String id);
	
	public BsnsCntrct getById(String id);
	
	public BsnsCntrct getByPrintInfo(String cntrctno);
	
	public List<BsnsCntrct> findAll();
	
	public String getByClntNo(String cntrctno);
	
	public int isHave(String clntno);
	
	public void update(BsnsCntrct bsnsCntrct);
	/**
	 * 获取可取消借据信息列表
	 * @param pageView
	 * @param bsnsCntrct
	 * @return
	 */
	public PageView queryCancel(PageView pageView, BsnsCntrct bsnsCntrct) ;
	
	public BsnsCntrct findByCntrctno(String cntrctno);

	public PageView querySignNew(PageView pageView, BsnsCntrct bsnscntrct);

	public PageView querySignEnd(PageView pageView, BsnsCntrct bsnscntrct);

	public PageView queryCntrctEnd(PageView pageView, BsnsCntrct bsnscntrct);

	public PageView queryNrmlOuted(PageView pageView, BsnsCntrct bsnsCntrct);
	
	public PageView queryBlOuted(PageView pageView, BsnsCntrct bsnsCntrct);
	
	public List<BsnsCntrct> queryExcel(BsnsCntrct bsnscntrct);
	
	public void delCntrct(String cntrctno);
	
	public List<BsnsCntrct> findList(BsnsCntrct bsnscntrct);
	
	public BsnsCntrct getByApplyno(String applyno);
	
	//add by hw
	public PageView queryCntrctRevoke(PageView pageView, BsnsCntrct bsnscntrct);
	public void revokeCntrct(String cntrctno);
	public List<BsnsCntrct> queryRevokeExcel(BsnsCntrct bsnscntrct);
	
}
