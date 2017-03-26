/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.cntrtmng.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.acctmoduel.entity.AdvancePay;
import com.mf.acctmoduel.entity.AdvancePayMoney;
import com.mf.aftrmng.entity.AfterFvclass;
import com.mf.aftrmng.entity.BsnsRepayplanAll;
import com.mf.aftrmng.service.AfterFvclassService;
import com.mf.client.dao.ClntClientDao;
import com.mf.client.entity.ClntClient;
import com.mf.cntrtmng.dao.BsnsBillDao;
import com.mf.cntrtmng.dao.BsnsCntrctDao;
import com.mf.cntrtmng.dao.BsnsLnmainDao;
import com.mf.cntrtmng.dao.BsnsLnoutDao;
import com.mf.cntrtmng.entity.BsnsBill;
import com.mf.cntrtmng.entity.BsnsCntrct;
import com.mf.cntrtmng.entity.BsnsLnmain;
import com.mf.cntrtmng.service.BsnsBillService;
import com.mf.cntrtmng.service.BsnsCntrctService;
import com.mf.common.pub.PubConstants;
import com.mf.common.util.StringUtil;
import com.mf.financemng.dao.FnncVoucherDao;
import com.mf.org.dao.OperatorDao;
import com.mf.org.entity.Operator;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2015-01-13
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("bsnsBillService")
public class BsnsBillServiceImpl implements BsnsBillService {
	@Autowired
	private BsnsLnoutDao bsnsLnoutDao;
	
	@Autowired
	private BsnsCntrctDao bsnsCntrctDao;
	
	@Autowired
	private BsnsBillDao bsnsBillDao;
	
	@Autowired
	private BsnsLnmainDao bsnsLnmainDao;
	
	@Autowired
	private ClntClientDao clntClientDao;
	
	@Autowired
	private OperatorDao  loginDao;
	@Autowired
	private AfterFvclassService afterFvclassService;
	@Autowired
	private FnncVoucherDao fnncVoucherDao;
	@Autowired
	private BsnsCntrctService bsnsCntrctService;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param bsnsBill
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, BsnsBill bsnsBill) {
		List<BsnsBill> list = bsnsBillDao.query(pageView, bsnsBill);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param BsnsBill bsnsBill
	 * @return List<BsnsBill>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<BsnsBill> queryAll(BsnsBill bsnsBill) {
		List<BsnsBill> list = bsnsBillDao.queryAll(bsnsBill);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param bsnsBill
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(BsnsBill bsnsBill) {
		bsnsBillDao.add(bsnsBill);
		//更新合同的放款金额 可放余额
		BsnsCntrct bsnscntrct = bsnsCntrctDao.getById(bsnsBill.getCntrctno());
		BigDecimal amnt;
			if(bsnscntrct.getOutamnt()!=null){
				amnt=bsnscntrct.getOutamnt().add(bsnsBill.getDueamnt());//已放款金额
			}else{
				amnt=bsnsBill.getDueamnt();
			}
		bsnscntrct.setOutamnt(amnt);//已放金额
		bsnscntrct.setRmnamnt(bsnscntrct.getCntrctamnt().subtract(amnt));//可放余额
		bsnsCntrctDao.update(bsnscntrct);
		// xjh 新增业务主信息数据-BSNS_LNMAIN start
		BsnsLnmain bsnsLnmain = new BsnsLnmain();

		/** 业务编号（同借据号）==>db_column: BSNSNO */
		String bsnsno = bsnsBill.getDueno();
		bsnsLnmain.setBsnsno(bsnsno);
		/** 开办部门==>db_column: DEPNO */
		ClntClient clntClient = clntClientDao.getById(bsnscntrct.getClntno());
		String emplyno = clntClient.getUserid();
		Operator operator = loginDao.findByEmpno(emplyno);
		String depno = operator.getDptno();
		bsnsLnmain.setDepno(depno); 
		/** 贷款余额==>db_column: LNBLNC */
		bsnsLnmain.setLnblnc( bsnsBill.getDueamnt()); //贷款余额 即发放金额
		/** 发放金额==>db_column: CRRNTAMNT */
		BigDecimal crrntamnt = bsnsBill.getDueamnt();
		bsnsLnmain.setCrrntamnt(crrntamnt); // 同借据金额
		/** 实际放款日期（计息起始日）==>db_column: INTSTSDATE */
		String intstsdate = bsnsBill.getOutdate();
		bsnsLnmain.setIntstsdate(intstsdate); 
		/** 预计结束日期==>db_column: INTSTEDATE */
		String intstedate = bsnsBill.getMtrtydate();
		bsnsLnmain.setIntstedate(intstedate);
		/** 最近更新日期==>db_column: UPDTDATE */
		String updtdate = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
		bsnsLnmain.setUpdtdate(updtdate);
		/** 账户状态==>db_column: ACCNTSTT */
		String accntstt = "0";
		bsnsLnmain.setAccntstt(accntstt); 
		/** 五级分类状态==>db_column: FVCLSSTT */
		String fvclsstt = "0";
		bsnsLnmain.setFvclsstt(fvclsstt);
		/** 客户编号==>db_column: CLNTNO */
		bsnsLnmain.setClntno(bsnscntrct.getClntno());
		/** 客户名称==>db_column: CLNTNM */
		bsnsLnmain.setClntnm(bsnscntrct.getClntbnknm());
		/** 合同编号==>db_column: CNTRCTNO */
		bsnsLnmain.setCntrctno(bsnscntrct.getCntrctno());
		/** 合同期间（天）==>db_column: LNTMDY */
		String lntmdy = "";
		bsnsLnmain.setLntmdy(lntmdy);
		/** 当前账单日期==>db_column: CURBLLDATE */
		String curblldate = "";
		bsnsLnmain.setCurblldate(curblldate);
		/** 下一账单日期==>db_column: NXTBLLDATE */
		String nxtblldate = "";
		bsnsLnmain.setNxtblldate(nxtblldate);
		/** 业务标识==>db_column: BSNSFLG */
		String bsnsflg = "";
		bsnsLnmain.setBsnsflg(bsnsflg);
		/** 是否固定还款日==>db_column: ISFIXREPAY */
		String isfixrepay = "";
		bsnsLnmain.setIsfixrepay(isfixrepay);
		/** 银行账户==>db_column: BNKNO */
		String bnkno = "";
		bsnsLnmain.setBnkno(bnkno);
		/** 放款类型==>db_column: OUTYP */
		String outyp = "";
		bsnsLnmain.setOutyp(outyp);
		/** 固定还款日==>db_column: FIXDATE */
		String fixdate = "";
		bsnsLnmain.setFixdate(fixdate);
		bsnsLnmainDao.add(bsnsLnmain);
		
//		afterFvclassService.addauto(bsnsBill);// 添加到五级类
		//确保 每个合同只增加一条5级分类信息
		AfterFvclass afterFvclass = afterFvclassService.getByCntrctno(bsnsBill.getCntrctno());
		if(afterFvclass==null){
			afterFvclassService.addauto(bsnsBill);
		}
		
		
	}
	
	/**
	 * 新增操作
	 * @param bsnsBill
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(BsnsBill bsnsBill) {
		bsnsBillDao.addAll(bsnsBill);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String dueno) {
		
		BsnsBill bsnsBill=bsnsBillDao.getById(dueno);
		BsnsBill bill=new BsnsBill();
		bill.setCntrctno(bsnsBill.getCntrctno());
		int ishaveBill=bsnsBillDao.count(bill);
		BsnsCntrct bsnscntrct = bsnsCntrctDao.getById(bsnsBill.getCntrctno());
		BigDecimal amnt=bsnscntrct.getOutamnt().subtract(bsnsBill.getDueamnt());//已放款金额
		bsnscntrct.setOutamnt(amnt);//已放金额
		bsnscntrct.setRmnamnt(bsnscntrct.getCntrctamnt().subtract(amnt));//可放余额
		if(ishaveBill<1 &&PubConstants.CNTRCTSTT_HISTORY.equals(bsnscntrct.getCntrctstt())){//如果不存在借据 状态设为补录状态9
			bsnscntrct.setCntrctstt(PubConstants.CNTRCTSTT_HISTORY_BILL);
		}
		bsnsCntrctDao.update(bsnscntrct);
		bsnsBillDao.delete(dueno);
		bsnsLnmainDao.deleteDueno(dueno);//删除业务主信息表数据
		
//		afterFvclassService.delete(dueno);//删除五级分类
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public BsnsBill getById(String id) {
		return bsnsBillDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param bsnsBill
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(BsnsBill bsnsBill) {
		bsnsBillDao.modify(bsnsBill);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<BsnsBill> findAll() {
		return bsnsBillDao.findAll();
	}

	@Override
	public BsnsBill findByDueno(String dueno) {
		return bsnsBillDao.findByDueno(dueno);
	}

	@Override
	public String getTotal(String cntrctno) {
		// TODO Auto-generated method stub
		
		return bsnsBillDao.getTotal(cntrctno);
	}
	/* (non-Javadoc)贷款到期查询
	 * @see com.mf.cntrtmng.service.BsnsBillService#queryWarn(com.mf.util.PageView, java.util.Map)
	 */
	public PageView queryWarn(PageView pageView,Map<String, Object> param){
		 List<BsnsBill> list =bsnsBillDao.queryWarn(pageView,param);
		 pageView.setRecords(list);
		 return pageView;
	}
	/* (non-Javadoc)贷款逾期查询
	 * @see com.mf.cntrtmng.service.BsnsBillService#queryOverWarn(com.mf.util.PageView, java.util.Map)
	 */
	public PageView queryOverWarn(PageView pageView,Map<String, Object> param){
		 List<BsnsBill> list =bsnsBillDao.queryOverWarn(pageView,param);
		 pageView.setRecords(list);
		 return pageView;
	}
	public PageView queryRtrnTimeWarn(PageView pageView,Map<String, Object> param){
		 List<BsnsRepayplanAll> list =bsnsBillDao.queryRtrnTimeWarn(pageView,param);
		 pageView.setRecords(list);
		 return pageView;
	}
	
	public PageView queryRtrnOverWarn(PageView pageView,Map<String, Object> param){
		 List<BsnsRepayplanAll> list =bsnsBillDao.queryRtrnOverWarn(pageView,param);
		 pageView.setRecords(list);
		 return pageView;
	}
	public PageView queryAdvance(PageView pageView,BsnsBill bsnsBill){
//		 List<AdvancePayMoney> list =bsnsBillDao.queryAdvance(pageView,bsnsBill);
		 List<AdvancePay> list =bsnsBillDao.queryAdvance(pageView,bsnsBill);
		 pageView.setRecords(list);
		 return pageView;
	}
	

	/**
	 * 通过合同号，找到BSNS_LNOUT表OUTSTT=3 的借据号
	 */
	@Override
	public PageView queryBillouted(PageView pageView, BsnsBill bsnsBill) {
		List<BsnsBill> list = bsnsBillDao.queryBillouted(pageView, bsnsBill);
		pageView.setRecords(list);
		return pageView;
	}
	

	/**
	 * 查询可取消列表
	 */
	public PageView queryCancel(PageView pageView,BsnsBill bsnsBill){
		List list= bsnsBillDao.queryCancel(pageView, bsnsBill);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public PageView queryBLBill(PageView pageView, BsnsBill bsnsBill) {
		List<BsnsBill> list= bsnsBillDao.queryBLBill(pageView, bsnsBill);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public BsnsBill findByCntrctno(String cntrctno) {
		// TODO Auto-generated method stub
		return bsnsBillDao.getByCntrctno(cntrctno);
		
	}
	
}
