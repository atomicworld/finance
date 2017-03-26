/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service;

import java.util.List;

import com.mf.financemng.entity.FnncAccntitem;
import com.mf.financemng.entity.FnncLedger;
import com.mf.financemng.entity.FnncPrfdtlList;
import com.mf.util.PageView;

/**
 * @author shenguangdong
 * @2015-02-10
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface FnncLedgerService{

	public PageView query(PageView pageView,FnncLedger fnncLedger);
	
	public List<FnncLedger> queryAll(FnncLedger fnncLedger);
	
	public void initFromExcel(FnncLedger fnncLedger, String[][] a);
	
	public void add(FnncLedger fnncLedger);
	
	public void addAll(FnncLedger fnncLedger);
	
	public void delete(String id);
	
	public void modify(FnncLedger fnncLedger);
	
	public void updateByAccntno(FnncLedger fnncLedger);
	
	public void updateAccntflg(String accntflg);
	
	public void changeAccntflg(String accntflg);
	
	public FnncLedger getById(String id);
	
	public List<FnncLedger> crryOvr();
	
	public List<FnncLedger> getInfo();
	
	public FnncLedger getByAccntno(String accntno);
	
	public List<FnncLedger> findAll();
	
	public void del();
	
	public void delefnncledgerlog(String accntflg);
	
	public void deleteLedgerInfo(String stt);
	
	public void recoverFnncLedger();
	
	public String getMaxMonth(String prfcrtdt);
	
	public int  isHave(String ledgerdate);
	
	public String getJzkm();
	
	public void recoverFnncChckprfbs(String prfcrtdt);
	
	public void recoverFnncChckprfdtl(String prfcrtdt);

	public int getCount(String accntflg);
	
	public int getAllCount();
	
	public int getLogCount();
	
	public void copyFnncLedger();
	
	public void updateLedger(String flag);
	
	public void updateJtoD();
	
	public void updateLedgerDate(String date);
	
	public void updateBqAmt();
	
	public void updatejy();
	
	public void updatejd();
	
	public void updateSixPrfix(String accntno);
	
	public List<FnncPrfdtlList> getAccntList(FnncPrfdtlList fnncprfdtllist);
	
	public List<FnncAccntitem> getInstr();
}
