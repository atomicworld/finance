/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.cntrtmng.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.cntrtmng.dao.BsnsCntrctDao;
import com.mf.cntrtmng.entity.BsnsCntrct;
import com.mf.cntrtmng.service.BsnsCntrctService;
import com.mf.common.pub.PubConstants;
import com.mf.util.PageView;
@Transactional
@Service("bsnsCntrctService")
public class BsnsCntrctServiceImpl implements BsnsCntrctService {
	@Autowired
	private BsnsCntrctDao bsnsCntrctDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param bsnsCntrct
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, BsnsCntrct bsnsCntrct) {
		List<BsnsCntrct> list = bsnsCntrctDao.query(pageView, bsnsCntrct);
		pageView.setRecords(list);
		return pageView;
	}
	//wangyaowei
	@Transactional(readOnly=true)
	public PageView queryNine(PageView pageView, BsnsCntrct bsnsCntrct) {
		List<BsnsCntrct> list = bsnsCntrctDao.queryNine(pageView, bsnsCntrct);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 列出待签订合同的信息列表
	 */
	public PageView queryPend(PageView pageView, BsnsCntrct bsnsCntrct) {
		List<BsnsCntrct> list = bsnsCntrctDao.queryPend(pageView, bsnsCntrct);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 查询待发放贷款合同信息列表
	 * @param pageView
	 * @param bsnsCntrct
	 * @return
	 */
	public PageView queryOuting(PageView pageView, List<String> sttList, BsnsCntrct bsnsCntrct){
		List<BsnsCntrct> list = bsnsCntrctDao.queryOuting(pageView, sttList, bsnsCntrct);
		pageView.setRecords(list);
		return pageView;
	}
	
	
	/**
	 * 新增操作
	 * @param bsnsCntrct
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(BsnsCntrct bsnsCntrct) {
		bsnsCntrctDao.add(bsnsCntrct);
	}
	
	/**
	 * 新增操作
	 * @param bsnsCntrct
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(BsnsCntrct bsnsCntrct) {
		bsnsCntrctDao.addAll(bsnsCntrct);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		bsnsCntrctDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public BsnsCntrct getById(String id) {
		BsnsCntrct cntrct=bsnsCntrctDao.getById(id);
		BigDecimal rtno=new BigDecimal(cntrct.getRtno());
		rtno=rtno.setScale(2, BigDecimal.ROUND_HALF_UP);
		cntrct.setRtno(rtno.toString());
		return cntrct;
	}
	@Transactional(readOnly=true)
	public BsnsCntrct getByPrintInfo(String cntrctno) {
		return bsnsCntrctDao.getByPrintInfo(cntrctno);
	}
	
	
	/**
	 * 修改实体类
	 * @param bsnsCntrct
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void signCntrct(BsnsCntrct bsnsCntrct) {
		//置CNTRCTSTT字段为 2
		bsnsCntrct.setCntrctstt(PubConstants.CNTRCTSTT_SIGNED);
		
		/** add by hw start 
		 * 合同签订的时候：
		 * 1.剩余金额（RMNAMNT）为合同金额
		 * 2.贷款剩余金额（LNAMNT） 为 0.0；
		*/
		System.out.println(bsnsCntrct.getCntrctamnt());
		System.out.println(new BigDecimal(0.0));
		bsnsCntrct.setRmnamnt(bsnsCntrct.getCntrctamnt());
		bsnsCntrct.setLnamnt(new BigDecimal(0.0));
		/** add by hw end */
		
		//更新合同信息表的相应字段信息
		bsnsCntrctDao.signCntrct(bsnsCntrct);
		//更新从合同相关信息
	}
	/* 
	 * 修改补录合同信息
	 */
	public void update(BsnsCntrct bsnsCntrct){
		//更新合同信息表的相应字段信息
		bsnsCntrctDao.update(bsnsCntrct);
	}
	
	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<BsnsCntrct> findAll() {
		return bsnsCntrctDao.findAll();
	}
	/**
	 * 查询合同编号
	 */
	public String getByClntNo(String cntrctno){
		 return bsnsCntrctDao.getByClntNo(cntrctno);
	}
	//wyw
	public int isHave(String clntno){
		return bsnsCntrctDao.isHave(clntno);
	}
		@Override
	public BsnsCntrct findByCntrctno(String cntrctno) {
		return bsnsCntrctDao.findByCntrctno(cntrctno);
	}

	@Override
	public PageView querySignNew(PageView pageView, BsnsCntrct bsnscntrct) {
		List<BsnsCntrct> list = bsnsCntrctDao.querySignNew(pageView,bsnscntrct);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public PageView querySignEnd(PageView pageView, BsnsCntrct bsnscntrct) {
		List<BsnsCntrct> list = bsnsCntrctDao.querySignEnd(pageView,bsnscntrct);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public PageView queryCntrctEnd(PageView pageView, BsnsCntrct bsnscntrct) {
		List<BsnsCntrct> list = bsnsCntrctDao.queryCntrctEnd(pageView,bsnscntrct);
		pageView.setRecords(list);
		return pageView;
	}

	/**
	 * 获取可取消借据信息列表
	 * @param pageView
	 * @param bsnsCntrct
	 * @return
	 */
	public PageView queryCancel(PageView pageView, BsnsCntrct bsnsCntrct) {
		List<BsnsCntrct> list = bsnsCntrctDao.queryCancel(pageView, bsnsCntrct);
		pageView.setRecords(list);
		return pageView;
	}

	/**
	 * 查询常规已放款合同
	 */
	public PageView queryNrmlOuted(PageView pageView, BsnsCntrct bsnsCntrct) {
		List<BsnsCntrct> list = bsnsCntrctDao.queryNrmlOuted(pageView, bsnsCntrct);
		pageView.setRecords(list);
		return pageView;
	}

	/**
	 * 查询补录已放款合同
	 */
	@Override
	public PageView queryBlOuted(PageView pageView, BsnsCntrct bsnsCntrct) {
		List<BsnsCntrct> list = bsnsCntrctDao.queryBlOuted(pageView, bsnsCntrct);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public List<BsnsCntrct> queryExcel(BsnsCntrct bsnscntrct) {
		return bsnsCntrctDao.queryExcel(bsnscntrct);
	}
	
	public void delCntrct(String cntrctno){
		bsnsCntrctDao.copyLog(cntrctno);
		bsnsCntrctDao.delCntrct(cntrctno);
	}
	public List<BsnsCntrct> findList(BsnsCntrct bsnscntrct){
		return bsnsCntrctDao.findList(bsnscntrct);
	}
	public BsnsCntrct getByApplyno(String applyno){
		return bsnsCntrctDao.getByApplyno(applyno);
	}
	
	//add by hw
	@Override
	public PageView queryCntrctRevoke(PageView pageView, BsnsCntrct bsnscntrct) {
		List<BsnsCntrct> list = bsnsCntrctDao.queryCntrctRevoke(pageView,bsnscntrct);
		pageView.setRecords(list);
		return pageView;
	}
	/* 撤销合同操作	*/
	public void revokeCntrct(String cntrctno){
		//更新合同信息表的相应字段信息
		bsnsCntrctDao.revokeCntrct(cntrctno);
	}
	public List<BsnsCntrct> queryRevokeExcel(BsnsCntrct bsnscntrct){
		return bsnsCntrctDao.queryRevokeExcel(bsnscntrct);
	}
	
	
}
