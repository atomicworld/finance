/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.financemng.entity.*;
import com.mf.financemng.dao.*;
import com.mf.financemng.service.*;
import com.mf.common.pub.PubConstants;
import com.mf.common.util.*;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2015-01-29
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("fnncPrfbsService")
public class FnncPrfbsServiceImpl implements FnncPrfbsService {
	@Autowired
	private FnncPrfbsDao fnncPrfbsDao;
	@Autowired
	private FnncPrfdtlDao fnncPrfdtlDao;
	@Autowired
	private FnncChckprfbsDao fnncChckprfbsDao;
	@Autowired
	private FnncChckprfdtlDao fnncChckprfdtlDao;
	@Autowired
	private FnncAccntctlcdDao fnncAccntctlcdDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param fnncPrfbs
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, FnncPrfbs fnncPrfbs) {
		List<FnncPrfbs> list = fnncPrfbsDao.query(pageView, fnncPrfbs);
		pageView.setRecords(list);
		return pageView;
	}
	@Transactional(readOnly=true)
	public PageView querylist(PageView pageView, FnncPrfbsList fnncprfbslist) {
		List<FnncPrfbsList> list = fnncPrfbsDao.querylist(pageView, fnncprfbslist);
		pageView.setRecords(list);
		return pageView;
	}
	
	@Transactional(readOnly=true)
	public PageView queryWFHBase(PageView pageView, FnncPrfbs fnncPrfbs){
		List<FnncPrfbs> list = fnncPrfbsDao.queryWFHBase(pageView, fnncPrfbs);
		pageView.setRecords(list);
		return pageView;
	}
	/**
	 * 不分页查询
	 * @param FnncPrfbs fnncPrfbs
	 * @return List<FnncPrfbs>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FnncPrfbs> queryAll(FnncPrfbs fnncPrfbs) {
		List<FnncPrfbs> list = fnncPrfbsDao.queryAll(fnncPrfbs);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param fnncPrfbs
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(FnncPrfbs fnncPrfbs) {
		fnncPrfbsDao.add(fnncPrfbs);
	}
	
	/**
	 * 新增操作
	 * @param fnncPrfbs
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(FnncPrfbs fnncPrfbs) {
		fnncPrfbsDao.addAll(fnncPrfbs);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		fnncPrfbsDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public FnncPrfbs getById(String id) {
		return fnncPrfbsDao.getById(id);
	}
	
	@Transactional(readOnly=true)
	public FnncPrfbs getByprfno(String prfno) {
		return fnncPrfbsDao.getByprfno(prfno);
	}
	
	/**
	 * 修改实体类
	 * @param fnncPrfbs
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(FnncPrfbs fnncPrfbs) {
		// xjh 更新复核日期 start
		if(PubConstants.PRFBS_STT_CHECK_YES.equals(fnncPrfbs.getStt())){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			fnncPrfbs.setCheckdt(sdf.format(new Date()));
		}
		// xjh 更新复核日期 end
		fnncPrfbsDao.modify(fnncPrfbs);
		// xjh 复核时，向复核表和详情表插入数据 start
		if(PubConstants.PRFBS_STT_CHECK_YES.equals(fnncPrfbs.getStt())){
			fnncPrfbs = fnncPrfbsDao.getByprfno(fnncPrfbs.getPrfno());
			//add to 复核表 start
			FnncChckprfbs fnncChckprfbs = new FnncChckprfbs();
			/**原始凭证流水号==>db_column: PRFTRCNO*/
			fnncChckprfbs.setPrftrcno(fnncPrfbs.getPrftrcno());
			/**复核凭证类型==>db_column: CHCKPRFTYP*/
			fnncChckprfbs.setChckprftyp(fnncPrfbs.getPrftyp());
			/**原始凭证生成日期==>db_column: PRFCRTDT*/
			fnncChckprfbs.setPrfcrtdt(fnncPrfbs.getTxdt());
			/**操作员编号==>db_column: OPNO*/
			fnncChckprfbs.setOpno(fnncPrfbs.getOpno());
			/**备注==>db_column: REMARK*/
			fnncChckprfbs.setRemark(fnncPrfbs.getRemark());
			/**复核流水号==>db_column: CHCKTRCNO*/
			fnncChckprfbs.setChcktrcno("FH" + WaterIdGener.getWaterId());
			/**记账标识==>db_column: ACCNTFLG*/
			fnncChckprfbs.setAccntflg(PubConstants.CHCKPRFBS_ACCNTFLG_NO);
			fnncChckprfbsDao.add(fnncChckprfbs);
			//add to 复核表 end
			
			//add to 复核详细表 start
			List<FnncPrfdtl> fnncPrfdtls = fnncPrfdtlDao.getByPrfrtcno(fnncPrfbs.getPrftrcno());
			/**原始凭证生成日期==>db_column: PRFCRTDT*/
			String prfcrtdt = fnncPrfbs.getTxdt();
			/**复核流水号==>db_column: CHCKTRCNO*/
			String chcktrcno = fnncChckprfbs.getChcktrcno();
			/**部门编号==>db_column: DPTNO*/
			String dptno = fnncPrfbs.getDptno();
			/**币种==>db_column: CURRNCY*/
			String currncy = "CNY";
			/**凭证类型==>db_column: CHCKPRFTYP*/
			String chckprftyp = fnncPrfbs.getPrftyp();
			/**操作员编号==>db_column: OPNO*/
			String opno = fnncPrfbs.getOpno();
			/**状态==>db_column: STT*/
			String stt = fnncPrfbs.getStt();
			for(FnncPrfdtl fnncPrfdtl : fnncPrfdtls){
				FnncChckprfdtl fnncChckprfdtl = new FnncChckprfdtl();
				/**顺序号==>db_column: SQNNO*/
				String sqnno = fnncPrfdtl.getSqnno();
				/**科目控制码==>db_column: ACCNTCTLCD*/
				String accntno = fnncPrfdtl.getAccntno();
				/**借贷标识==>db_column: JDFLG*/
				String jdflg = fnncPrfdtl.getJdflg();
				/**发生金额==>db_column: AMNT*/
				BigDecimal amnt = fnncPrfdtl.getAmnt();
				
				fnncChckprfdtl.setPrfcrtdt(prfcrtdt);
				fnncChckprfdtl.setChcktrcno(chcktrcno);
				fnncChckprfdtl.setDptno(dptno);
				fnncChckprfdtl.setCurrncy(currncy);
				fnncChckprfdtl.setChckprftyp(chckprftyp);
				fnncChckprfdtl.setOpno(opno);
				fnncChckprfdtl.setStt(stt);
				fnncChckprfdtl.setSqnno(sqnno);
				fnncChckprfdtl.setAccntno(accntno);
				fnncChckprfdtl.setJdflg(jdflg);
				fnncChckprfdtl.setAmnt(amnt);
				fnncChckprfdtlDao.add(fnncChckprfdtl);
			}
			//add to 复核详细表 end
			
			
		}
		// xjh 复核时，向复核表插入数据 end
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FnncPrfbs> findAll() {
		return fnncPrfbsDao.findAll();
	}
	
}
