/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.cntrtmng.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.aftrmng.entity.AfterFvclass;
import com.mf.aftrmng.service.AfterFvclassService;
import com.mf.bsnsmng.entity.BsnsApply;
import com.mf.bsnsmng.service.BsnsApplyService;
import com.mf.bsnsmng.service.BsnsApplydtlService;
import com.mf.client.dao.ClntClientDao;
import com.mf.client.entity.ClntClient;
import com.mf.client.service.ClntClientService;
import com.mf.cntrtmng.dao.BsnsBillDao;
import com.mf.cntrtmng.dao.BsnsCntrctDao;
import com.mf.cntrtmng.dao.BsnsLnmainDao;
import com.mf.cntrtmng.dao.BsnsLnoutDao;
import com.mf.cntrtmng.entity.BsnsBill;
import com.mf.cntrtmng.entity.BsnsCntrct;
import com.mf.cntrtmng.entity.BsnsLnmain;
import com.mf.cntrtmng.entity.BsnsLnout;
import com.mf.cntrtmng.service.BsnsBillService;
import com.mf.cntrtmng.service.BsnsLnmainService;
import com.mf.cntrtmng.service.BsnsLnoutService;
import com.mf.common.pub.PubConstants;
import com.mf.common.util.StringUtil;
import com.mf.common.util.WaterIdGener;
import com.mf.financemng.service.FnncVoucherService;
import com.mf.org.dao.OperatorDao;
import com.mf.org.entity.Operator;
import com.mf.sendFileImpl.entity.BsnsApplyData;
import com.mf.sendFileImpl.service.BsnsApplyDataService;
import com.mf.sendFileImpl.util.LoanUserUtil;
import com.mf.sys.service.impl.MappingtoolServiceImpl;
import com.mf.util.FormatDateUtil;
import com.mf.util.PageView;
@Transactional
@Service("bsnsLnoutService")
public class BsnsLnoutServiceImpl implements BsnsLnoutService {
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
	private OperatorDao loginDao;
	
	@Autowired
	private FnncVoucherService fnncvoucherservice;
	
	@Autowired
	private AfterFvclassService afterFvclassService;
	@Autowired
	private BsnsApplyService bsnsApplyService;
	@Autowired
	private BsnsLnmainService bsnsLnmainService;
	@Autowired
	private ClntClientService clntClientService;
	@Autowired
	private BsnsApplyDataService bsnsApplyDataService;
	@Autowired
	private BsnsBillService bsnsBillService;
	@Autowired
	public MappingtoolServiceImpl mappingtoolService;
	/**
	 * 分页查询
	 * @param pageView
	 * @param bsnsLnout
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, BsnsLnout bsnsLnout) {
		List<BsnsLnout> list = bsnsLnoutDao.query(pageView, bsnsLnout);
		pageView.setRecords(list);
		return pageView;
	}
	
	public PageView queryoutable(PageView pageView,BsnsLnout bsnsLnout){
		List<BsnsLnout> list = bsnsLnoutDao.queryoutable(pageView, bsnsLnout);
		pageView.setRecords(list);
		return pageView;
	}
	public List<BsnsLnout> queryList(BsnsLnout bsnsLnout){
		List<BsnsLnout> list = bsnsLnoutDao.queryList(bsnsLnout);
		return list;
	}
	
	public PageView showoutInfo(PageView pageView,BsnsLnout bsnsLnout){
		List<BsnsLnout> list = bsnsLnoutDao.showoutInfo(pageView, bsnsLnout);
		pageView.setRecords(list);
		return pageView;
	}
	
	// 执行放款操作
	public void exeout(BsnsLnout bsnslnout, String date,String pay,String bnkno){
		String outno = bsnslnout.getOutno();
		bsnslnout = bsnsLnoutDao.findOneByOutno(outno);
		
		//更新BSNS_LNOUT的OUTSTT字段为1-待制定还款计划
		bsnsLnoutDao.exeout(outno);
		
		//xjh 新增借据数据-BSNS_BILL start
		BsnsBill bsnsBill = new BsnsBill();
		bsnsBill.setDueno(outno); // 借据编号使用放款编号
		bsnsBill.setOutno(outno); // 放款编号
		String cntrctno = bsnslnout.getCntrctno();
		bsnsBill.setCntrctno(cntrctno); // 合同编号
		String applyno = bsnslnout.getApplyno();
		bsnsBill.setApplyno(applyno); // 申请编号
		String occrdate = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
		bsnsBill.setOccrdate(occrdate); // 发生日期
		String clntno = bsnslnout.getClntno();
		bsnsBill.setClntno(clntno); // 客户编号
		String clntnm = bsnslnout.getClntnm();
		bsnsBill.setClntnm(clntnm); // 客户名称
		BigDecimal dueamnt = bsnslnout.getOutamnt();
		bsnsBill.setDueamnt(dueamnt); // 借据金额(放款金额bsns_lnout OUTAMNT)
		
		//放款日期改为页面选定的放款日期
		//add by hw start
		if(StringUtil.isNotEmpty(date) ) {
			bsnsBill.setOutdate(date);
		//add by hw end
		/*		if(StringUtil.isNotEmpty( bsnslnout.getOutdate())) {
		bsnsBill.setOutdate(bsnslnout.getOutdate());*/
		}else {		
			bsnsBill.setOutdate(StringUtil.getFormatDate(new Date(), "yyyyMMdd")); // 放款日期(放款申请日期bsns_lnout OUTDATE参考)
		}
		// 到期日期=放款日期+合同期限==>原来是用合同结束日期作为贷款最后到期日期
		//String mtrtydate = bsnslnout.getCntrctedate();
		int termNum = 0;
		BsnsCntrct bsnsCntrct = bsnsCntrctDao.findByCntrctno(bsnsBill.getCntrctno());
		if(bsnsCntrct.getTrmmnth()>0 && bsnsCntrct.getTrmday() >0) {
			termNum = bsnsCntrct.getTrmmnth()+1;
		} else if(bsnsCntrct.getTrmmnth()>0 && bsnsCntrct.getTrmday()==0) {
			termNum = bsnsCntrct.getTrmmnth();
		} else if(bsnsCntrct.getTrmmnth()==0 && bsnsCntrct.getTrmday() >0) {
			termNum = 1;
		} 
		String mtrtydate ;
		if(bsnsCntrct.getTrmday() >0) {
			mtrtydate =  FormatDateUtil.changeDateAsMonth(bsnsBill.getOutdate(),termNum-1);	
			Date tmpDate=  FormatDateUtil.changeDateAsDays(FormatDateUtil.strToDate(mtrtydate, "yyyy-MM-dd"),bsnsCntrct.getTrmday());
			bsnsBill.setMtrtydate(FormatDateUtil.dateToStr(tmpDate,"yyyyMMdd")); 
		}else {
			mtrtydate =  FormatDateUtil.changeDateAsMonth(bsnsBill.getOutdate(),termNum);	
			bsnsBill.setMtrtydate(FormatDateUtil.dateToStr(FormatDateUtil.strToDate(mtrtydate, "yyyy-MM-dd"),"yyyyMMdd")); 
		}
		
//		String rledate = "";
//		bsnsBill.setRledate(rledate); // 实际完结日期
//		String extno = "";
//		bsnsBill.setExtno(extno); // 展期编号
		
		String dlflg = PubConstants.DLFLG_HKJH_NO; // 暂时默认
		bsnsBill.setDlflg(dlflg); // 处理标志
		BigDecimal lnamnt = bsnslnout.getCntrctamnt();
		bsnsBill.setLnamnt(lnamnt); // 贷款金额等于合同金额
		
//		BigDecimal othramnt = null;
//		bsnsBill.setOthramnt(othramnt); // 其他金额
		
		String nowDt = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
		bsnsBill.setRegdate(nowDt);
		bsnsBill.setUpdtdate(nowDt);
		String clssflg = "0"; // 暂时默认
		bsnsBill.setClssflg(clssflg); // 五级分类标志
		bsnsBillDao.add(bsnsBill);
		
		AfterFvclass afterFvclass = afterFvclassService.getByCntrctno(bsnsBill.getCntrctno());
		if(afterFvclass==null){
			afterFvclassService.addauto(bsnsBill);
		}
		//xjh 新增借据数据-BSNS_BILL end
		
		System.out.println("=========新增业务主信息数据-BSNS_LNMAIN start===========>>");
		// xjh 新增业务主信息数据-BSNS_LNMAIN start
		BsnsLnmain bsnsLnmain = new BsnsLnmain();
		
		/** 业务编号（同借据号）==>db_column: BSNSNO */
		String bsnsno = outno;
		bsnsLnmain.setBsnsno(bsnsno);
		/** 开办部门==>db_column: DEPNO */
		ClntClient clntClient = clntClientDao.getById(clntno);
		String emplyno = clntClient.getUserid();
		Operator operator = loginDao.findByEmpno(emplyno);
		String depno = operator.getDptno();
		bsnsLnmain.setDepno(depno);
		/** 贷款余额==>db_column: LNBLNC */		
		bsnsLnmain.setLnblnc(dueamnt); // 同借据金额，还款时更新 
		/** 发放金额==>db_column: CRRNTAMNT */		
		bsnsLnmain.setCrrntamnt(dueamnt); // 借据金额
		/** 实际放款日期（计息起始日）==>db_column: INTSTSDATE */ 	
		bsnsLnmain.setIntstsdate(bsnsBill.getOutdate());
		/** 预计结束日期==>db_column: INTSTEDATE */		
		bsnsLnmain.setIntstedate(bsnsBill.getMtrtydate());
		/** 最近更新日期==>db_column: UPDTDATE */		
		bsnsLnmain.setUpdtdate(StringUtil.getFormatDate(new Date(), "yyyyMMdd"));
		/** 账户状态==>db_column: ACCNTSTT */
		String accntstt = "0";
		bsnsLnmain.setAccntstt(accntstt); 
		/** 五级分类状态==>db_column: FVCLSSTT */
		String fvclsstt = "0";
		bsnsLnmain.setFvclsstt(fvclsstt);
		/** 客户编号==>db_column: CLNTNO */
		bsnsLnmain.setClntno(clntno);
		/** 客户名称==>db_column: CLNTNM */
		bsnsLnmain.setClntnm(clntnm);
		/** 合同编号==>db_column: CNTRCTNO */
		bsnsLnmain.setCntrctno(cntrctno);
		/** 合同期间（天）==>db_column: LNTMDY */		
		bsnsLnmain.setLntmdy("");
		/** 当前账单日期==>db_column: CURBLLDATE */
//		String curblldate = "";
//		bsnsLnmain.setCurblldate(curblldate);
		/** 下一账单日期==>db_column: NXTBLLDATE */
//		String nxtblldate = "";
//		bsnsLnmain.setNxtblldate(nxtblldate);
		/** 业务标识==>db_column: BSNSFLG */
		String bsnsflg = "0";
		bsnsLnmain.setBsnsflg(bsnsflg);
		/** 是否固定还款日==>db_column: ISFIXREPAY */		
		bsnsLnmain.setIsfixrepay("0"); // 生成还款计划时更新
		/** 银行账户==>db_column: BNKNO */
		//String bnkno = "";
		bsnsLnmain.setBnkno(bnkno);
		/** 放款类型==>db_column: OUTYP */
		//String outyp = "0";
		bsnsLnmain.setOutyp(pay); // 现金或者银行转账
		/** 固定还款日==>db_column: FIXDATE */
//		String fixdate = ""; // 生成还款计划时更新
//		bsnsLnmain.setFixdate(fixdate);
		bsnsLnmainDao.add(bsnsLnmain);
		// xjh 新增业务主信息数据-BSNS_LNMAIN end
		System.out.println("=========新增业务主信息数据-BSNS_LNMAIN end===========>>");
		
		//-----生成提供给广西金融办监管系统用的接口数据 add by Wangzhi------
		BsnsApplyData bsnsApplyData = new BsnsApplyData();
		BsnsApply bsnsApply = bsnsApplyService.getById(bsnsCntrct.getApplyno());
		BsnsLnmain bsnslnmain=bsnsLnmainService.findByBsnsno(bsnsno);
		BsnsBill bsnsBill2 = bsnsBillService.findByDueno(bsnsBill.getDueno());
		AfterFvclass afterFvclass2 = afterFvclassService.getByCntrctno(cntrctno);
		bsnsApplyData.setConCode(bsnsCntrct.getCntrctno());//合同编号
		bsnsApplyData.setConAmount(bsnslnmain.getLnblnc());//合同金额
		bsnsApplyData.setConSignDate(bsnsCntrct.getCntrctsdate());//合同签订日期
		bsnsApplyData.setConStartDate(bsnsCntrct.getCntrctsdate());//合同有效起始日期
		//根据利率类型判断月利率是多少
		if (bsnsCntrct.getBsrtyp().equals("1")) {
			System.out.println("进入利率类型为1中");
			  double d1 = bsnsCntrct.getApplyrt().doubleValue();
			  BigDecimal b1 = new BigDecimal(d1);
		      BigDecimal b2 = new BigDecimal(12);
		      BigDecimal b3 = new BigDecimal(b1.divide(b2,6,BigDecimal.ROUND_HALF_UP).doubleValue());
		      bsnsApplyData.setConYearRate(b3);//合同月利率
		      bsnsApplyData.setConDelayYearRate(b3);//逾期月利率
		      bsnsApplyData.setYearRate(b3);//贷款月利率
		      bsnsApplyData.setDelayMonRate(b3);//贷款逾期月利率
		}else if (bsnsCntrct.getBsrtyp().equals("2")) {
			bsnsApplyData.setConYearRate(bsnsCntrct.getApplyrt());//合同月利率
			bsnsApplyData.setConDelayYearRate(bsnsCntrct.getApplyrt());//逾期月利率
			bsnsApplyData.setYearRate(bsnsCntrct.getApplyrt());//贷款月利率
			bsnsApplyData.setDelayMonRate(bsnsCntrct.getApplyrt());//贷款逾期月利率
		}else if (bsnsCntrct.getBsrtyp().equals("3")) {
			BigDecimal b4 = bsnsCntrct.getApplyrt().multiply(new BigDecimal(30));
			bsnsApplyData.setConYearRate(b4);//合同月利率
			 bsnsApplyData.setConDelayYearRate(b4);//逾期月利率
			 bsnsApplyData.setYearRate(b4);//贷款月利率
			 bsnsApplyData.setDelayMonRate(b4);//贷款逾期月利率
		}
		bsnsApplyData.setConStatus(1);//合同状态1有效，2合同终止
		bsnsApplyData.setLoanCode(bsnsCntrct.getApplyno());//合同申请编号
		bsnsApplyData.setLoanClass(1);//贷款主体1主贷人，2次贷人，3担保人
		bsnsApplyData.setConType(1);//贷款类别1自营贷款，2委托贷款
		//根据客户类型判断是否个人或者企业
		ClntClient client = clntClientService.getById(bsnslnmain.getClntno());
		
		if (PubConstants.CLNT_TYPE_EE.equals(client.getClnttype())) {
			bsnsApplyData.setCustClass(2);//2企业
		}else if (PubConstants.CLNT_TYPE_PERSON.equals(client.getClnttype())) {
			bsnsApplyData.setCustClass(1);//1个人
		}
		bsnsApplyData.setCustName(client.getClntname());//借款人名称
		bsnsApplyData.setCustDocType(Integer.parseInt(client.getCerttype()));//证件类型
		bsnsApplyData.setCustIdno(client.getCertno());//证件号码
		bsnsApplyData.setCustScale(bsnsApply.getCustScale());//贷款对象规模
		bsnsApplyData.setLoanDate(bsnsCntrct.getCntrctsdate());
		bsnsApplyData.setSendDate(bsnsBill2.getOutdate());//贷款发放日期
		bsnsApplyData.setEndDate(bsnsCntrct.getCntrctedate());//贷款结束时间
		bsnsApplyData.setExpireDate(null);//贷款展期到期时间为空，还未还款
		bsnsApplyData.setAmount(bsnsCntrct.getCntrctamnt());//贷款金额
		bsnsApplyData.setSolutionWay(bsnsApply.getSolutionWay());//争议解决方案
		bsnsApplyData.setLoanerType(bsnsApply.getLoanerType());//贷款对象
		bsnsApplyData.setLoanUsage(bsnsApply.getLoanUsage());//贷款用途
		bsnsApplyData.setLoanTrade(LoanUserUtil.getLoanTradeCode(bsnsApply.getUseno()));//投放行业
		bsnsApplyData.setLoanArea(bsnsApply.getLoanArea());//投向区域
		bsnsApplyData.setRepaymentWay(0);//付款方式，只有还款之后才知道
		bsnsApplyData.setReturnMode(Integer.parseInt(bsnsApply.getRpmntway()));//计息方式
		bsnsApplyData.setDanbaoMode(Integer.parseInt(bsnsApply.getGrtway()));//担保方式
		bsnsApplyData.setRateProp(Integer.parseInt(bsnsApply.getIntrstmd()));//利率性质
		//委托这块不写默认为空，此功能暂时不使用
		//五级分类这块，一个合同一个五级分类，从after_fvclass表取，根据合同关联。其他表中的五级分类值以后不再更新。
		bsnsApplyData.setStatus(Integer.parseInt(afterFvclass2.getClsstyp()));//贷款五级分类状态
		bsnsApplyData.setReturnDate("");//还款日期
		bsnsApplyData.setRbeginDate(bsnsCntrct.getCntrctsdate());//起息日期
		bsnsApplyData.setRendDate(bsnsCntrct.getCntrctedate());//止息日期
		bsnsApplyData.setDelayFee(new BigDecimal(0.00));//收回逾期滞纳金
		bsnsApplyData.setDelayInterest(new BigDecimal(0.00));//收回逾期利息(元)
		bsnsApplyData.setReturnInterest(new BigDecimal(0.00));//收回利息（元）
		bsnsApplyData.setReturnAmt(new BigDecimal(0.00));//收回本金
		bsnsApplyData.setIsDelay(3);//收回状态
		bsnsApplyData.setIsTch(bsnsApply.getIsTch());//是否同城化业务
		bsnsApplyData.setFlag(1);//设置为1代表没有生成xml文件
		bsnsApplyDataService.add(bsnsApplyData);
		System.out.println("接口执行完成");
		//-----wangzhi end------
		
	}
	
	/**
	 * 不分页查询
	 * @param BsnsLnout bsnsLnout
	 * @return List<BsnsLnout>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<BsnsLnout> queryAll(BsnsLnout bsnsLnout) {
		List<BsnsLnout> list = null;
		//list = bsnsLnoutDao.queryAll(bsnsLnout);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param bsnsLnout
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(BsnsLnout bsnsLnout) {
		String srlno = WaterIdGener.getWaterId();
		/*String outno = "cz" + srlno;*/
		
		//edit by hw , 放款编号修改
		String date = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
		String preKey = "FK";
		String waterID = mappingtoolService.getSerialnumber(date, preKey);
		String outno = preKey + waterID;
		bsnsLnout.setOutno(outno);
		bsnsLnout.setSrlno(srlno);
		
		String nowDt = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
		bsnsLnout.setRegdate(nowDt);
		bsnsLnout.setUpdtdate(nowDt);
		
		bsnsLnout.setOutstt(PubConstants.OUTSTT_OUTING);
		//1、向BSNS_LNOUT表插入数据
		bsnsLnoutDao.add(bsnsLnout);
		
		String cntrctno = bsnsLnout.getCntrctno(); 
		BsnsCntrct bsnsCtrct = bsnsCntrctDao.getById(cntrctno);
		//2、更新BSNS_CNTRCT表部分字段
		//查询合同金额,已申请放款金额,剩余可申请放款金额,
		BigDecimal cntrctamt = bsnsCtrct.getCntrctamnt();	//合同金额
		BigDecimal outamnt = bsnsCtrct.getOutamnt();		//已放款金额
		BigDecimal lnamnt = bsnsCtrct.getLnamnt();			//贷款剩余金额
		
		BigDecimal rmnamnt = bsnsCtrct.getRmnamnt();			//剩余金额
		//本次申请放款金额
		/**	add by hw
		 *	1.剩余金额（放款，rmnamnt）= 合同金额 - 放款金额
		 *	2.贷款剩余金额（还款，lnamnt）= lnamnt + 放款金额
		 */
		BigDecimal cur_outamnt = bsnsLnout.getOutamnt();
		lnamnt = lnamnt.add(cur_outamnt);
		rmnamnt = rmnamnt.subtract(cur_outamnt);
/*		lnamnt = lnamnt.subtract(cur_outamnt);*/
		outamnt = outamnt.add(cur_outamnt);
		//更新到BSNS_CNTRCT表
		bsnsCtrct.setOutamnt(outamnt);
		bsnsCtrct.setLnamnt(lnamnt);
//		bsnsCtrct.setRmnamnt(lnamnt);
		bsnsCtrct.setRmnamnt(rmnamnt);
		
//		int ifCompleted = lnamnt.compareTo(BigDecimal.ZERO);
		int ifCompleted = rmnamnt.compareTo(BigDecimal.ZERO);
		if(ifCompleted == 0){
			//如果剩余可申请放款金额为0
			bsnsCtrct.setCntrctstt(PubConstants.CNTRCTSTT_OUTAPPRED); // 合同放款申请结束，无金额可放
			bsnsCtrct.setFnshflg(PubConstants.FNSHFLG_YES); // 合同放款"申请"结束，无金额可申请,区别于合同的"实际正式"放款
		}else if(ifCompleted == 1){
			//如果剩余可申请放款金额大于0
			bsnsCtrct.setCntrctstt(PubConstants.CNTRCTSTT_OUTING);
		}else{
			//如果剩余可申请放款金额小于0
		}
		bsnsCntrctDao.update(bsnsCtrct);
	}

	
	/**
	 * 新增操作
	 * @param bsnsLnout
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(BsnsLnout bsnsLnout) {
		//bsnsLnoutDao.addAll(bsnsLnout);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		bsnsLnoutDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public BsnsLnout getById(String outno) {
		return bsnsLnoutDao.getById(outno);
	}
	
	/**
	 * 修改实体类
	 * @param bsnsLnout
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(BsnsLnout bsnsLnout) {
		bsnsLnoutDao.modify(bsnsLnout);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<BsnsLnout> findAll() {
		return bsnsLnoutDao.findAll();
	}

	
	@Override
	@Transactional(readOnly=true)
	public PageView queryOuted(PageView pageView, BsnsLnout bsnslnout) {
		List<BsnsLnout> list = bsnsLnoutDao.queryOuted(pageView, bsnslnout);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public List<BsnsCntrct> queryExcel(BsnsCntrct bsnscntrct) {
		return bsnsLnoutDao.queryExcel(bsnscntrct);
	}

	@Override
	public BsnsLnout findBySrlno(String srlno) {
		// TODO Auto-generated method stub
		return bsnsLnoutDao.findBySrlno(srlno);
	}
}
