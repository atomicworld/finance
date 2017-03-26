/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.common.pub.PubConstants;
import com.mf.financemng.dao.FnncAccntitemDao;
import com.mf.financemng.dao.FnncLedgerDao;
import com.mf.financemng.entity.FnncAccntitem;
import com.mf.financemng.entity.FnncLedger;
import com.mf.financemng.entity.FnncPrfdtlList;
import com.mf.financemng.service.FnncLedgerService;
import com.mf.util.PageView;


/**
 * @author shenguangdong 
 * @2015-02-10
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("fnncLedgerService")
public class FnncLedgerServiceImpl implements FnncLedgerService {
	@Autowired
	private FnncLedgerDao fnncLedgerDao;
	@Autowired
	private FnncAccntitemDao fnncAccntitemDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param fnncLedger
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, FnncLedger fnncLedger) {
		List<FnncLedger> list = fnncLedgerDao.query(pageView, fnncLedger);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param FnncLedger fnncLedger
	 * @return List<FnncLedger>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FnncLedger> queryAll(FnncLedger fnncLedger) {
		List<FnncLedger> list = fnncLedgerDao.queryAll(fnncLedger);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param fnncLedger
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(FnncLedger fnncLedger) {
		fnncLedgerDao.add(fnncLedger);
	}
	
	/**
	 * 初始化财务
	 * @param fnncLedger
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void initFromExcel(FnncLedger fnncLedger, String[][] a) {
		int rows = a.length; // excel的行
		fnncLedgerDao.del();
		List<FnncLedger> fnncLedgerList = new ArrayList<FnncLedger>();
		for (int j = 1; j < rows; j++) {
			FnncLedger newFnncLedger = new FnncLedger();
			String curtp = "CNY";// 币种
			String accntno = a[j][0].trim();// 科目编码
			String accntdrct = a[j][2];// 科目余额方向
			if ("借".equals(accntdrct)) {
				accntdrct = PubConstants.ACCNTDRCT_J;
			}
			if ("贷".equals(accntdrct)) {
				accntdrct = PubConstants.ACCNTDRCT_D;
			}
			FnncAccntitem fnncAccntitem = fnncAccntitemDao.getById(accntno);
			String upaccntno = fnncAccntitem.getUpaccntno();// 所属科目编码
			String jqmBal = a[j][3];// 期末余额借方
			String dqmBal = a[j][4];// 期末余额贷方

			newFnncLedger.setCurtp(curtp);
			newFnncLedger.setAccntno(accntno);
			newFnncLedger.setLedgerdate(fnncLedger.getLedgerdate());
			newFnncLedger.setAccntdrct(accntdrct);
			newFnncLedger.setUpaccntno(upaccntno);
			newFnncLedger.setJqmBal(new BigDecimal(jqmBal));
			newFnncLedger.setDqmBal(new BigDecimal(dqmBal));
			// xjh add 20150311 start
			newFnncLedger.setJqcBal(new BigDecimal(0));
			newFnncLedger.setDqcBal(new BigDecimal(0));
			newFnncLedger.setJbqAmt(new BigDecimal(0));
			newFnncLedger.setDbqAmt(new BigDecimal(0));
			newFnncLedger.setJysumAmt(new BigDecimal(0));
			newFnncLedger.setDysumAmt(new BigDecimal(0));
			newFnncLedger.setFlag("0");
			// xjh add 20150311 end
			
			fnncLedgerList.add(newFnncLedger);
		}
		
		// 平衡校验 
		//validBalance(fnncLedger, fnncAccntitem);
		
		
		// 循环插入信息
		for(FnncLedger fr : fnncLedgerList){
			fnncLedgerDao.add(fr);
		}
		
	}
	
	/**
	 * 校验平衡和合法性
	 * @param fnncLedger
	 * @param fnncAccntitem
	 */
	private String validBalance(FnncLedger fnncLedger, FnncAccntitem fnncAccntitem) {
		// 1、余额方向借方，只能在借方填值，余额方向贷方，只能在贷方填值
		String accntdrct = fnncAccntitem.getAccntdrct();
		BigDecimal jqmBal = fnncLedger.getJqmBal();
		BigDecimal dqmBal = fnncLedger.getDqmBal();
		if ((PubConstants.ACCNTDRCT_J.equals(accntdrct) && !dqmBal.equals(BigDecimal.ZERO))
				|| (PubConstants.ACCNTDRCT_D.equals(accntdrct) && !jqmBal.equals(BigDecimal.ZERO))) {
			return "请按照余额方向填值";
		}else{
			// 2、针对一个科目的值，它的下级所有科目和值必须等于当前科目的值
			// a、把属于同一个一级科目的值放在一个list中
		}
		
		
		
		
		
		
		// 3、所有一级科目的借方值等于所有一级科目贷方值
		return "ok";
		
	}
	
	
	
	
	/**
	 * 新增操作
	 * @param fnncLedger
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(FnncLedger fnncLedger) {
		fnncLedgerDao.addAll(fnncLedger);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		fnncLedgerDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public FnncLedger getById(String id) {
		return fnncLedgerDao.getById(id);
	}
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public FnncLedger getByAccntno(String accntno) {
		return fnncLedgerDao.getByAccntno(accntno);
	}
	@Transactional(readOnly=true)
	public List<FnncLedger> crryOvr() {
		return fnncLedgerDao.crryOvr();
	}
	@Transactional(readOnly=true)
	public List<FnncLedger> getInfo() {
		return fnncLedgerDao.getInfo();
	}
	
	/**
	 * 修改实体类
	 * @param fnncLedger
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(FnncLedger fnncLedger) {
		fnncLedgerDao.modify(fnncLedger);
	}
	public void updateByAccntno(FnncLedger fnncLedger) {
		fnncLedgerDao.updateByAccntno(fnncLedger);
	}
	
	public void updateAccntflg(String accntflg){
		fnncLedgerDao.updateAccntflg(accntflg);
	}
	public void changeAccntflg(String accntflg){
		fnncLedgerDao.changeAccntflg(accntflg);
	}
	
	public int getCount(String accntflg){
		return fnncLedgerDao.getCount(accntflg);
	}
	
	
	public int getAllCount(){
		return fnncLedgerDao.getAllCount();
	}
	
	public int getLogCount(){
		return fnncLedgerDao.getLogCount();
	}
	public void copyFnncLedger(){
		 fnncLedgerDao.copyFnncLedger();
	}
	public void updateLedger(String flag){
		 fnncLedgerDao.updateLedger(flag);
	}
	public void updateJtoD(){
		fnncLedgerDao.updateJtoD();
	}
	public void updateLedgerDate(String date){
		 fnncLedgerDao.updateLedgerDate(date);
	}
	
	public void updateBqAmt(){
		 fnncLedgerDao.updateBqAmt();
	}
	public void updatejy(){
		fnncLedgerDao.updatejy();
	}
	
	public void updatejd(){
		fnncLedgerDao.updatejd();
	}
	
	public void updateSixPrfix(String accntno){
		 fnncLedgerDao.updateSixPrfix(accntno);
	}
	
	
	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FnncLedger> findAll() {
		return fnncLedgerDao.findAll();
	}
	
	public void del(){
		fnncLedgerDao.del();
	}
	public void delefnncledgerlog(String accntflg){
		fnncLedgerDao.delefnncledgerlog(accntflg);
	}
	
	public void deleteLedgerInfo(String stt){
		fnncLedgerDao.deleteLedgerInfo(stt);
	}
	public void recoverFnncLedger(){
		fnncLedgerDao.recoverFnncLedger();
	}
	
	public String getMaxMonth(String prfcrtdt){
		return fnncLedgerDao.getMaxMonth(prfcrtdt);
	}
	
	public int  isHave(String ledgerdate){
		return fnncLedgerDao.isHave(ledgerdate);
	}
	public String getJzkm(){
		return fnncLedgerDao.getJzkm();
	}
	
	public void recoverFnncChckprfbs(String prfcrtdt){
		fnncLedgerDao.recoverFnncChckprfbs(prfcrtdt);
	}
	public void recoverFnncChckprfdtl(String prfcrtdt){
		fnncLedgerDao.recoverFnncChckprfdtl(prfcrtdt);
	}
	
	
	@Transactional(readOnly=true)
	public List<FnncPrfdtlList> getAccntList(FnncPrfdtlList fnncprfdtllist) {
		return fnncLedgerDao.getAccntList(fnncprfdtllist);
	}
	
	public List<FnncAccntitem> getInstr(){
		return fnncLedgerDao.getInstr();

	}
	
	
	
}
