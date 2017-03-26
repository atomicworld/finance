/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.financemng.entity.FnncAccntitem;
import com.mf.financemng.entity.FnncLedger;
import com.mf.financemng.entity.FnncPrfdtlList;


/**
 * @author shenguangdong 
 * @2015-02-10
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
public interface FnncLedgerDao extends BaseDao<FnncLedger>{
	public List<FnncPrfdtlList> getAccntList(FnncPrfdtlList fnncprfdtllist)throws DataAccessException;
	public List<FnncLedger> findAll() throws DataAccessException;
	public FnncLedger getByAccntno(String accntno) throws DataAccessException;
	public List<FnncLedger> crryOvr() throws DataAccessException;
	public List<FnncLedger> getInfo() throws DataAccessException;
	public void updateByAccntno(FnncLedger fnncLedger) throws DataAccessException;
	public void updateAccntflg(String accntflg)throws DataAccessException;
	public void changeAccntflg(String accntflg)throws DataAccessException;
	public int getCount(String accntflg)throws DataAccessException;
	public int getAllCount()throws DataAccessException;
	public int getLogCount()throws DataAccessException;
	public void copyFnncLedger()throws DataAccessException;
	public void updateLedger(String flag)throws DataAccessException;
	public void updateJtoD();
	public void updateLedgerDate(String date)throws DataAccessException;
	public List<FnncAccntitem> getInstr()throws DataAccessException;
	public void del() throws DataAccessException;
	public void recoverFnncLedger()throws DataAccessException;
	public void recoverFnncChckprfbs(String prfcrtdt)throws DataAccessException;
	public void recoverFnncChckprfdtl(String prfcrtdt)throws DataAccessException;
	public String getMaxMonth(String prfcrtdt);
	public int isHave(String ledgerdate);
	public String getJzkm();
	public void updateBqAmt();
	public void updatejy();
	public void updatejd();
	public void updateSixPrfix(String accntno);
	public void delefnncledgerlog(String accntflg)throws DataAccessException;
	public void deleteLedgerInfo(String stt)throws DataAccessException;
}
