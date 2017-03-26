/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.cntrtmng.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.aftrmng.dao.AfterFvclassDao;
import com.mf.bsnsmng.entity.BsnsApply;
import com.mf.bsnsmng.service.BsnsApplyService;
import com.mf.client.entity.ClntClient;
import com.mf.client.service.ClntClientService;
import com.mf.cntrtmng.dao.BsnsBillDao;
import com.mf.cntrtmng.dao.BsnsCntrctDao;
import com.mf.cntrtmng.dao.BsnsExtendDao;
import com.mf.cntrtmng.dao.BsnsLnmainDao;
import com.mf.cntrtmng.dao.BsnsRepaylogDao;
import com.mf.cntrtmng.entity.BsnsBill;
import com.mf.cntrtmng.entity.BsnsCntrct;
import com.mf.cntrtmng.entity.BsnsExtend;
import com.mf.cntrtmng.entity.BsnsLnmain;
import com.mf.cntrtmng.entity.BsnsRepaylog;
import com.mf.cntrtmng.entity.BsnsRepaylogList;
import com.mf.cntrtmng.service.BsnsBillService;
import com.mf.cntrtmng.service.BsnsCntrctService;
import com.mf.cntrtmng.service.BsnsLnmainService;
import com.mf.cntrtmng.service.BsnsRepaylogService;
import com.mf.common.pub.PubConstants;
import com.mf.common.util.WaterIdGener;
import com.mf.financemng.dao.FnncVoucherDao;
import com.mf.financemng.entity.FnncChckprfbs;
import com.mf.financemng.entity.FnncChckprfdtl;
import com.mf.financemng.entity.FnncDealitem;
import com.mf.financemng.entity.FnncPrfbs;
import com.mf.financemng.entity.FnncPrfdtl;
import com.mf.financemng.entity.FnncVoucher;
import com.mf.financemng.service.FnncChckprfbsService;
import com.mf.financemng.service.FnncChckprfdtlService;
import com.mf.financemng.service.FnncDealitemService;
import com.mf.financemng.service.FnncPrfbsService;
import com.mf.financemng.service.FnncPrfdtlService;
import com.mf.financemng.service.FnncVoucherService;
import com.mf.org.entity.Operator;
import com.mf.sendFileImpl.dao.BsnsApplyDataDao;
import com.mf.sendFileImpl.entity.BsnsApplyData;
import com.mf.sendFileImpl.util.LoanUserUtil;
import com.mf.util.FormatDateUtil;
import com.mf.util.PageView;

/**
 * @author yangchao
 * @2015-01-30
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("bsnsRepaylogService")
public class BsnsRepaylogServiceImpl implements BsnsRepaylogService {
	@Autowired
	private BsnsRepaylogDao bsnsRepaylogDao;
	@Autowired
	private BsnsLnmainDao bsnsLnmainDao;
	@Autowired
	private FnncVoucherDao fnncVoucherDao;
	@Autowired
	private BsnsCntrctDao bsnsCntrctDao;
	@Autowired
	private BsnsBillDao bsnsBillDao;
	@Autowired
	private BsnsCntrctService bsnsCntrctService;
	@Autowired
	private FnncVoucherService fnncVoucherService;
	@Autowired
	private FnncPrfbsService fnncprfbsservice;
	@Autowired
	private FnncPrfdtlService fnncprfdtlservice;
	@Autowired
	private FnncChckprfbsService fnncChckprfbsService;
	@Autowired
	private FnncChckprfdtlService fnncChckprfdtlService;
	@Autowired
	private FnncDealitemService fnncDealitemService;
	@Autowired
	private BsnsApplyDataDao bsnsApplyDataDao;
	@Autowired
	private BsnsApplyService bsnsApplyService;
	@Autowired
	private BsnsLnmainService bsnsLnmainService;
	@Autowired
	private ClntClientService clntClientService;
	@Autowired
	private BsnsExtendDao bsnsExtendDao;
	/**
	 * 分页查询
	 * @param pageView
	 * @param bsnsRepaylog
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, BsnsRepaylog bsnsRepaylog) {
		List<BsnsRepaylog> list = bsnsRepaylogDao.query(pageView, bsnsRepaylog);
		pageView.setRecords(list);
		return pageView;
	}
	/**
	 * 不分页查询
	 * @param BsnsRepaylog bsnsRepaylog
	 * @return List<BsnsRepaylog>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<BsnsRepaylog> queryAll(BsnsRepaylog bsnsRepaylog) {
		List<BsnsRepaylog> list = bsnsRepaylogDao.queryAll(bsnsRepaylog);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param bsnsRepaylog
	 * @return
	 * wangyaowei
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(BsnsRepaylog bsnsRepaylog,Operator operator) {
		bsnsRepaylogDao.add(bsnsRepaylog);
		//保存还款计划时 已确认还款的 生成凭证
		//还款状态非空，且不是“未还款”
		 if(bsnsRepaylog.getFinanceflg()!=null && !(PubConstants.HKBJ_FINANCEFLG_ZERO.equals(bsnsRepaylog.getFinanceflg()))){
				//主业务信息表
				BsnsLnmain bsnslnmain =bsnsLnmainDao.findByBsnsno(bsnsRepaylog.getBsnsno()); 
				bsnslnmain.setLnblnc(bsnslnmain.getLnblnc().subtract(bsnsRepaylog.getRcvprinamnt().abs()));//更新贷款余额
				bsnsLnmainDao.modify(bsnslnmain);
				
				//add by hw start 20151010,根据借据号找，合同
				BsnsBill bsnsBill = bsnsBillDao.findByDueno(bsnsRepaylog.getBsnsno());
				BsnsCntrct bsnsCntrct = bsnsCntrctService.getById(bsnsBill.getCntrctno());
				bsnsCntrct.setLnamnt(bsnsCntrct.getLnamnt().subtract(bsnsRepaylog.getRcvprinamnt().abs()));//更新合同表余额
				bsnsCntrctDao.update(bsnsCntrct);
				//end
				
				//自动生成凭证			    
		    	FnncVoucher fv=new FnncVoucher();
				fv.setPzno(WaterIdGener.getWaterId());
				fv.setCntrctno(bsnslnmain.getCntrctno());
				fv.setDueno(bsnsRepaylog.getBsnsno());
				fv.setLogid(bsnsRepaylog.getLogid());
				fv.setType("2");
				fv.setStatus("1");//还款已复核
				fnncVoucherDao.add(fv);
				
				String cntrctno=bsnslnmain.getCntrctno();
				BsnsCntrct bsnscntrct=bsnsCntrctDao.findByCntrctno(cntrctno);
			    if(!(bsnscntrct.getCntrctedflg().equals(PubConstants.CNTRCTEDFLG_YES))){//判断是否是已完结合同， 已完结合同不更新状态
					// 贷款余额减去还款额 是否等于零 为零则借据还款完毕。
					if(bsnslnmain.getLnblnc().subtract(bsnsRepaylog.getRcvprinamnt().abs()).doubleValue()<=0){
						BsnsBill bill=bsnsBillDao.findByDueno(bsnslnmain.getBsnsno());
						bill.setRecflg(PubConstants.HK_RECFLG);//更新借据状态 标记本金一还款完毕
						bill.setRledate(FormatDateUtil.getFormatDate("yyyy-MM-dd"));//实际完结日期
						bsnsBillDao.modify(bill);
						BsnsLnmain bs=bsnsLnmainDao.cougtCntrctno(cntrctno);//统计还款总额
						if(bs!=null){
							double cntrcnt=bsnscntrct.getCntrctamnt().doubleValue();//合同金额
							double duenoamnt=bs.getCrrntamnt().doubleValue();//还款金额
							if(cntrcnt==duenoamnt){//还款金额等于合同金额 则合同结束 
								bsnscntrct.setCntrctedflg(PubConstants.CNTRCTEDFLG_YES);// 标记为结束状态
								bsnsCntrctDao.update (bsnscntrct);									
							}
						}
					}
			    }
			   //zc 还款凭证复核
				 this.payCheckIn(bsnsRepaylog,bsnscntrct,operator);
				 
			  //add by wangzhi 生成广西还款计划接口文件数据
				BsnsApplyData bsnsApplyData = new BsnsApplyData();
				BsnsApply bsnsApply = bsnsApplyService.getById(bsnsCntrct.getApplyno());
				bsnsApplyData.setConCode(bsnslnmain.getCntrctno());//合同编号
				bsnsApplyData.setConAmount(bsnslnmain.getLnblnc());//贷款金额
				bsnsApplyData.setConSignDate(bsnsCntrct.getCntrctsdate());//合同签订日期
				bsnsApplyData.setConStartDate(bsnsCntrct.getCntrctsdate());//合同有效起始日期
				//根据利率类型判断年利率是多少
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
				bsnsApplyData.setSendDate(bsnsBill.getOutdate());//贷款发放日期
				bsnsApplyData.setEndDate(bsnsCntrct.getCntrctedate());//贷款结束时间
				BsnsExtend bsnsExtend =  bsnsExtendDao.getByDueno(bsnsRepaylog.getBsnsno());
				if (bsnsExtend!=null) {
					bsnsApplyData.setExpireDate(bsnsExtend.getExtendsdate());//贷款展期到期时间
				}else {
					bsnsApplyData.setExpireDate("");//贷款展期到期时间
				}
				bsnsApplyData.setAmount(bsnsCntrct.getCntrctamnt());//贷款金额
				bsnsApplyData.setSolutionWay(bsnsApply.getSolutionWay());//争议解决方案
				bsnsApplyData.setLoanerType(bsnsApply.getLoanerType());//贷款对象
				bsnsApplyData.setLoanUsage(bsnsApply.getLoanUsage());//贷款用途
				//投向行业useno
				bsnsApplyData.setLoanTrade(LoanUserUtil.getLoanTradeCode(bsnsApply.getUseno()));
				bsnsApplyData.setLoanArea(bsnsApply.getLoanArea());//投向区域
				bsnsApplyData.setRepaymentWay(Integer.parseInt(bsnsRepaylog.getPaymode()));//付款方式
				bsnsApplyData.setReturnMode(Integer.parseInt(bsnsApply.getRpmntway()));//计息方式
				bsnsApplyData.setDanbaoMode(Integer.parseInt(bsnsApply.getGrtway()));//担保方式
				bsnsApplyData.setRateProp(Integer.parseInt(bsnsApply.getIntrstmd()));//利率性质
				//委托这块不写默认为空，此功能暂时不使用
				if(!(bsnscntrct.getCntrctedflg().equals(PubConstants.CNTRCTEDFLG_YES))){
					//判断已经结清
					bsnsApplyData.setStatus(6);//贷款五级分类状态
				}else {
					bsnsApplyData.setStatus(Integer.parseInt(bsnslnmain.getFvclsstt()));//贷款五级分类状态
				}
				bsnsApplyData.setReturnDate(bsnsRepaylog.getPaydt());//还款日期
				bsnsApplyData.setRbeginDate(bsnsCntrct.getCntrctsdate());//起息日期
				bsnsApplyData.setRendDate(bsnsCntrct.getCntrctedate());//止息日期
				bsnsApplyData.setDelayFee(new BigDecimal(0.00));//收回逾期滞纳金
				bsnsApplyData.setDelayInterest(new BigDecimal(0.00));//收回逾期利息(元)
				bsnsApplyData.setReturnInterest(bsnsRepaylog.getRcvinstamnt());//收回利息（元）
				bsnsApplyData.setReturnAmt(bsnsRepaylog.getRcvprinamnt());//收回本金
				bsnsApplyData.setIsDelay(3);//收回状态
				bsnsApplyData.setIsTch(bsnsApply.getIsTch());//是否同城化业务
				bsnsApplyData.setFlag(1);//设置为1代表没有生成xml文件
				bsnsApplyDataDao.add(bsnsApplyData);
				System.out.println("接口执行完成");
				// 生成接口文件end
			  
		    }
	}
	
	public void payCheckIn(BsnsRepaylog bsnsrepaylog,BsnsCntrct bsnscntrct,Operator operator) {
		String pay=bsnsrepaylog.getPaymode();//支付方式
		String remarks=bsnscntrct.getClntnm()+"还款 合同号:"+bsnscntrct.getCntrctno()+" 贷款本金:"+bsnsrepaylog.getRcvprinamnt().add(bsnsrepaylog.getRcvinstamnt());
		String prefix="XF";//现付
		if(!"430003".equals(pay)){
			prefix="YF";//银付
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		
		String opno=operator.getEmplyno();//操作员编号
		String dptno=operator.getDptno();//部门编号
		FnncPrfbs fnncprfbs=new FnncPrfbs();
		String accntxx=WaterIdGener.getWaterId();//流水号
		fnncprfbs.setPrftrcno(accntxx+opno);//流水号
		fnncprfbs.setOpno(opno);//操作员
		fnncprfbs.setDptno(dptno);//部门编号
		fnncprfbs.setTxdt(sdf.format(new Date()));//发生日期
		fnncprfbs.setRegdt(sdf.format(new Date()));//登记日期
		fnncprfbs.setRemark(remarks);//摘要
		fnncprfbs.setStt("3");//凭证已复核
		fnncprfbs.setPrftyp(prefix);//凭证状态
		fnncprfbs.setPrfno(prefix+accntxx);//凭证编号
		fnncprfbs.setCheckdt(sdf.format(new Date()));//复核日期
		fnncprfbsservice.add(fnncprfbs);//保存
		
		//==============================================chiled1 总额
		FnncPrfdtl spl=new FnncPrfdtl();
		 String sqnno=WaterIdGener.getWaterId();
		 spl.setPrftrcno(accntxx+opno);//流水号
		 spl.setSqnno(sqnno+"1");//顺序号
		/* if("2".equals(pay)){//银付
			 spl.setAccntno(bsnsrepaylog.getAccno());//科目编号
			 spl.setUpaccntno("1002");//所属科目编号
		 }else{//现付
			 spl.setAccntno("1001");//科目编号
			 spl.setUpaccntno("100101");//所属科目编号
		 }*/
		 FnncDealitem item=new FnncDealitem();
		 item.setDealtype("LNHK");
		 item.setDlflg("1");
		 if(!"430003".equals(pay)){//银付
			 item.setAccnttype(PubConstants.ACCNTTYPE_2);
		 }else{//现付
			 item.setAccnttype(PubConstants.ACCNTTYPE_1);
		 }
		 FnncDealitem fnncdealitem= fnncDealitemService.queryItem(item);
		 String accntno=fnncdealitem.getAccntno();
		 spl.setAccntno(accntno);
		 spl.setUpaccntno(accntno.substring(0,4));
		 spl.setRemark("");//摘要
		 spl.setSqsort("1");//顺序号
		 spl.setJdflg("1");//贷标志
		 spl.setAmnt(bsnsrepaylog.getRcvprinamnt().add(bsnsrepaylog.getRcvinstamnt()));//发生金额
		 fnncprfdtlservice.add(spl);
		//==============================================chiled2本金
			FnncPrfdtl spl2=new FnncPrfdtl();
			 String sqnno2=WaterIdGener.getWaterId();
			 spl2.setPrftrcno(accntxx+opno);//流水号
			 spl2.setSqnno(sqnno2+"2");//顺序号
			 FnncDealitem item2=new FnncDealitem();
				 item2.setDealtype("LNHK");
				 item2.setDlflg("2");
				 item2.setAccnttype(PubConstants.ACCNTTYPE_4);//本金科目
			 FnncDealitem fnncdealitem2= fnncDealitemService.queryItem(item2);
			 String accntno2=fnncdealitem2.getAccntno();
			 spl2.setAccntno(accntno2);
			 spl2.setUpaccntno(accntno2.substring(0,4));
			 spl2.setRemark("");//摘要
			 spl2.setSqsort("2");//顺序号
			 spl2.setJdflg("2");//借标志
			 spl2.setAmnt(bsnsrepaylog.getRcvprinamnt());//发生金额
			 fnncprfdtlservice.add(spl2);
			//==============================================chiled3 利息
				FnncPrfdtl spl3=new FnncPrfdtl();
				 String sqnno3=WaterIdGener.getWaterId();
				 spl3.setPrftrcno(accntxx+opno);//流水号
				 spl3.setSqnno(sqnno3+"3");//顺序号
				 FnncDealitem item3=new FnncDealitem();
				 item3.setDealtype("LNHK");
				 item3.setAccnttype(PubConstants.ACCNTTYPE_3);//利息科目
				 FnncDealitem fnncdealitem3= fnncDealitemService.queryItem(item3);
				 String accntno3=fnncdealitem3.getAccntno();
				 spl3.setAccntno(accntno3);
				 spl3.setUpaccntno(accntno3.substring(0,4));
				 spl3.setRemark("");//摘要
				 spl3.setSqsort("2");//顺序号
				 spl3.setJdflg("2");//借标志
				 spl3.setAmnt(bsnsrepaylog.getRcvinstamnt());//发生金额
				 fnncprfdtlservice.add(spl3);
		// xjh 复核时，向复核表和详情表插入数据 start
		if(PubConstants.PRFBS_STT_CHECK_YES.equals(fnncprfbs.getStt())){
				//add to 复核表 start
				FnncChckprfbs fnncChckprfbs = new FnncChckprfbs();
				/**原始凭证流水号==>db_column: PRFTRCNO*/
				fnncChckprfbs.setPrftrcno(fnncprfbs.getPrftrcno());
				/**复核凭证类型==>db_column: CHCKPRFTYP*/
				fnncChckprfbs.setChckprftyp(fnncprfbs.getPrftyp());
				/**原始凭证生成日期==>db_column: PRFCRTDT*/
				fnncChckprfbs.setPrfcrtdt(fnncprfbs.getRegdt());
				/**操作员编号==>db_column: OPNO*/
				fnncChckprfbs.setOpno(fnncprfbs.getOpno());
				/**备注==>db_column: REMARK*/
				fnncChckprfbs.setRemark(fnncprfbs.getRemark());
				/**复核流水号==>db_column: CHCKTRCNO*/
				fnncChckprfbs.setChcktrcno("FH" + WaterIdGener.getWaterId());
				/**记账标识==>db_column: ACCNTFLG*/
				fnncChckprfbs.setAccntflg(PubConstants.CHCKPRFBS_ACCNTFLG_NO);
				
				fnncChckprfbsService.add(fnncChckprfbs);
				//add to 复核表 end
				//========================================================
				
				//add to 复核详细表 start
				/**原始凭证生成日期==>db_column: PRFCRTDT*/
				String prfcrtdt = fnncprfbs.getTxdt();
				/**复核流水号==>db_column: CHCKTRCNO*/
				String chcktrcno = fnncChckprfbs.getChcktrcno();
				/**部门编号==>db_column: DPTNO*/
				//String dptno = fnncprfbs.getDptno();
				/**币种==>db_column: CURRNCY*/
				String currncy = "CNY";
				/**凭证类型==>db_column: CHCKPRFTYP*/
				String chckprftyp = fnncprfbs.getPrftyp();
				/**操作员编号==>db_column: OPNO*/
				//String opno = fnncprfbs.getOpno();
				/**状态==>db_column: STT*/
				String stt = fnncprfbs.getStt();
				//=======================================================fh1
					FnncChckprfdtl fnncChckprfdtl = new FnncChckprfdtl();
					/**顺序号==>db_column: SQNNO*/
					String sqnno1 = spl.getSqnno();
					/**科目控制码==>db_column: ACCNTCTLCD*/
					String accntno_1 = spl.getAccntno();
					/**借贷标识==>db_column: JDFLG*/
					String jdflg = spl.getJdflg();
					/**发生金额==>db_column: AMNT*/
					BigDecimal amnt = spl.getAmnt();
					fnncChckprfdtl.setPrfcrtdt(prfcrtdt);
					fnncChckprfdtl.setChcktrcno(chcktrcno);
					fnncChckprfdtl.setDptno(dptno);
					fnncChckprfdtl.setCurrncy(currncy);
					fnncChckprfdtl.setChckprftyp(chckprftyp);
					fnncChckprfdtl.setOpno(opno);
					fnncChckprfdtl.setStt(stt);
					fnncChckprfdtl.setSqnno(sqnno1);
					fnncChckprfdtl.setAccntno(accntno_1);
					fnncChckprfdtl.setJdflg(jdflg);
					fnncChckprfdtl.setAmnt(amnt);
					fnncChckprfdtlService.add(fnncChckprfdtl);
					//=======================================================fh2
					FnncChckprfdtl fnncChckprfdtl2 = new FnncChckprfdtl();
					/**顺序号==>db_column: SQNNO*/
					String sqnno4 = spl2.getSqnno();
					/**科目控制码==>db_column: ACCNTCTLCD*/
					String accntno_2 = spl2.getAccntno();
					/**借贷标识==>db_column: JDFLG*/
					String jdflg2 = spl2.getJdflg();
					/**发生金额==>db_column: AMNT*/
					BigDecimal amnt2 = spl2.getAmnt();
					fnncChckprfdtl2.setPrfcrtdt(prfcrtdt);
					fnncChckprfdtl2.setChcktrcno(chcktrcno);
					fnncChckprfdtl2.setDptno(dptno);
					fnncChckprfdtl2.setCurrncy(currncy);
					fnncChckprfdtl2.setChckprftyp(chckprftyp);
					fnncChckprfdtl2.setOpno(opno);
					fnncChckprfdtl2.setStt(stt);
					fnncChckprfdtl2.setSqnno(sqnno4);
					fnncChckprfdtl2.setAccntno(accntno_2);
					fnncChckprfdtl2.setJdflg(jdflg2);
					fnncChckprfdtl2.setAmnt(amnt2);
					fnncChckprfdtlService.add(fnncChckprfdtl2);
					//=======================================================fh3
					FnncChckprfdtl fnncChckprfdtl3 = new FnncChckprfdtl();
					/**顺序号==>db_column: SQNNO*/
					String sqnno5 = spl3.getSqnno();
					/**科目控制码==>db_column: ACCNTCTLCD*/
					String accntno_3 = spl3.getAccntno();
					/**借贷标识==>db_column: JDFLG*/
					String jdflg3 = spl3.getJdflg();
					/**发生金额==>db_column: AMNT*/
					BigDecimal amnt3 = spl3.getAmnt();
					fnncChckprfdtl3.setPrfcrtdt(prfcrtdt);
					fnncChckprfdtl3.setChcktrcno(chcktrcno);
					fnncChckprfdtl3.setDptno(dptno);
					fnncChckprfdtl3.setCurrncy(currncy);
					fnncChckprfdtl3.setChckprftyp(chckprftyp);
					fnncChckprfdtl3.setOpno(opno);
					fnncChckprfdtl3.setStt(stt);
					fnncChckprfdtl3.setSqnno(sqnno5);
					fnncChckprfdtl3.setAccntno(accntno_3);
					fnncChckprfdtl3.setJdflg(jdflg3);
					fnncChckprfdtl3.setAmnt(amnt3);
					fnncChckprfdtlService.add(fnncChckprfdtl3);
		 }
	}
	
	/**
	 * 新增操作
	 * @param bsnsRepaylog
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(BsnsRepaylog bsnsRepaylog) {
		bsnsRepaylogDao.addAll(bsnsRepaylog);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		bsnsRepaylogDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public BsnsRepaylog getById(String logid) {
		return bsnsRepaylogDao.getById(logid);
	}
	//wyy
	@Transactional(readOnly=true)
	/*public BsnsRepaylog getBySrlno(String srlno){*/
	public List<BsnsRepaylog> getBySrlno(String srlno){
		return bsnsRepaylogDao.getBySrlno(srlno);
	}
	/**
	 * 修改实体类
	 * @param bsnsRepaylog
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(BsnsRepaylog bsnsRepaylog) {
		bsnsRepaylogDao.modify(bsnsRepaylog);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<BsnsRepaylog> findAll() {
		return bsnsRepaylogDao.findAll();
	}
	public int getCountPlan(String dueno){
		return bsnsRepaylogDao.getCountPlan(dueno);
	}
	public  List<BsnsRepaylogList> getByDueno(String dueno){
		return bsnsRepaylogDao.getByDueno(dueno);
	}
	public  List<BsnsRepaylogList> getByDuenoCount(String dueno){
		return bsnsRepaylogDao.getByDuenoCount(dueno);
	}
	
	// add by hw
	public BsnsRepaylog getForMaxDt(String dueno){
		return bsnsRepaylogDao.getForMaxDt(dueno);
	}

	public void update(BsnsRepaylog bsnsRepaylog){
		 bsnsRepaylogDao.update(bsnsRepaylog);
		 if(bsnsRepaylog.getFinanceflg()!=null && !(PubConstants.HKBJ_FINANCEFLG_ZERO.equals(bsnsRepaylog.getFinanceflg()))){//保存还款计划时 已确认还款的 生成凭证
				//主业务信息表
				BsnsLnmain bsnslnmain =bsnsLnmainDao.findByBsnsno(bsnsRepaylog.getBsnsno()); 
				bsnslnmain.setLnblnc(bsnslnmain.getLnblnc().subtract(bsnsRepaylog.getRcvprinamnt().abs()));//更新贷款余额
				bsnsLnmainDao.modify(bsnslnmain);
				//自动生成凭证
			    if(true){
			    	FnncVoucher fv=new FnncVoucher();
					fv.setPzno(WaterIdGener.getWaterId());
					fv.setCntrctno(bsnslnmain.getCntrctno());
					fv.setDueno(bsnsRepaylog.getBsnsno());
					fv.setLogid(bsnsRepaylog.getLogid());
					fv.setType("2");
					fv.setStatus("0");
					fnncVoucherDao.add(fv);
			    }
			    String cntrctno=bsnslnmain.getCntrctno();
				BsnsCntrct bsnscntrct=bsnsCntrctDao.findByCntrctno(cntrctno);
				 if(!(bsnscntrct.getCntrctedflg().equals(PubConstants.CNTRCTEDFLG_YES))){//判断是否是已完结合格 已完结合同不更新状态
						// 贷款余额减去还款额 是否等于零 为零则借据还款完毕。
				  if(bsnslnmain.getLnblnc().subtract(bsnsRepaylog.getRcvprinamnt().abs()).doubleValue()<=0){
					BsnsBill bill=bsnsBillDao.findByDueno(bsnslnmain.getBsnsno());
					bill.setRecflg(PubConstants.HK_RECFLG);//更新借据状态 标记本金一还款完毕
					bsnsBillDao.modify(bill);
					BsnsLnmain bs=bsnsLnmainDao.cougtCntrctno(cntrctno);//统计还款总额
					if(bs!=null){
							if(bs.getCrrntamnt()!=null){
								double cntrcnt=bsnscntrct.getCntrctamnt().doubleValue();
								double duenoamnt=bs.getCrrntamnt().doubleValue();
									if(cntrcnt==duenoamnt){
										bsnscntrct.setCntrctedflg(PubConstants.CNTRCTEDFLG_YES);
										bsnsCntrctDao.update (bsnscntrct);
										
									}
							}
						}
				    	}
					}
					
				}
		}
}
