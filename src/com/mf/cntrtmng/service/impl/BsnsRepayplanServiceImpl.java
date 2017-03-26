package com.mf.cntrtmng.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.client.dao.ClntClientDao;
import com.mf.client.entity.ClntClient;
import com.mf.cntrtmng.dao.BsnsBillDao;
import com.mf.cntrtmng.dao.BsnsCntrctDao;
import com.mf.cntrtmng.dao.BsnsLnmainDao;
import com.mf.cntrtmng.dao.BsnsLnoutDao;
import com.mf.cntrtmng.dao.BsnsRepaylogDao;
import com.mf.cntrtmng.dao.BsnsRepayplanDao;
import com.mf.cntrtmng.entity.BsnsBill;
import com.mf.cntrtmng.entity.BsnsCntrct;
import com.mf.cntrtmng.entity.BsnsExtend;
import com.mf.cntrtmng.entity.BsnsLnmain;
import com.mf.cntrtmng.entity.BsnsLnout;
import com.mf.cntrtmng.entity.BsnsPrePaymentBean;
import com.mf.cntrtmng.entity.BsnsRepaylog;
import com.mf.cntrtmng.entity.BsnsRepayplan;
import com.mf.cntrtmng.service.BsnsBillService;
import com.mf.cntrtmng.service.BsnsCntrctService;
import com.mf.cntrtmng.service.BsnsLnoutService;
import com.mf.cntrtmng.service.BsnsRepaylogService;
import com.mf.cntrtmng.service.BsnsRepayplanService;
import com.mf.common.bsnstool.BsnsCalcTool;
import com.mf.common.bsnstool.BsnsExtendCalcTool;
import com.mf.common.pub.PubConstants;
import com.mf.common.util.StringUtil;
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
import com.mf.org.dao.OperatorDao;
import com.mf.org.entity.Operator;
import com.mf.util.Common;
import com.mf.util.PageView;

@Transactional
@Service("bsnsRepayplanService")
public class BsnsRepayplanServiceImpl implements BsnsRepayplanService {
	@Autowired
	private BsnsRepaylogDao bsnsRepaylogDao;
	@Autowired
	private FnncVoucherDao fnncVoucherDao;
	
	@Autowired
	private BsnsRepayplanDao bsnsRepayplanDao;
	@Autowired
	private BsnsLnmainDao bsnsLnmainDao;
	@Autowired
	private BsnsCntrctDao bsnsCntrctDao;
	@Autowired
	private BsnsBillDao bsnsBillDao;
	@Autowired
	private ClntClientDao clntClientDao;
	@Autowired
	private OperatorDao loginDao;
	@Autowired
	private BsnsLnoutDao bsnsLnoutDao;
	@Autowired
	private FnncVoucherService fnncvoucherservice;
	@Autowired
	private BsnsLnoutService bsnsLnoutService;
	@Autowired
	private BsnsCntrctService bsnsCntrctService;
	@Autowired
	private BsnsBillService bsnsBillService;
	
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
	private BsnsRepaylogService bsnsRepaylogService;
	
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param bsnsRepayplan
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, BsnsRepayplan bsnsRepayplan) {
		List<BsnsRepayplan> list = bsnsRepayplanDao.query(pageView, bsnsRepayplan);
		pageView.setRecords(list);
		return pageView;
	}
	@Transactional(readOnly=true)
	public PageView queryStatus(PageView pageView, BsnsRepayplan bsnsRepayplan) {
		List<BsnsRepayplan> list = bsnsRepayplanDao.queryStatus(pageView, bsnsRepayplan);
		pageView.setRecords(list);
		return pageView;
	}
	
	@Transactional(readOnly=true)
	public PageView query1(PageView pageView, BsnsRepayplan bsnsRepayplan) {
		List<BsnsRepayplan> list = bsnsRepayplanDao.query1(pageView, bsnsRepayplan);
		pageView.setRecords(list);
		return pageView;
	}
	
	@Transactional(readOnly=true)
	public List<BsnsRepayplan> queryNew(BsnsRepayplan bsnsRepayplan){
		return bsnsRepayplanDao.queryNew(bsnsRepayplan);
	}
	
	@Transactional(readOnly=true)
	public PageView query2(PageView pageView, BsnsRepayplan bsnsRepayplan) {
		List<BsnsRepayplan> list = bsnsRepayplanDao.query2(pageView, bsnsRepayplan);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param BsnsRepayplan bsnsRepayplan
	 * @return List<BsnsRepayplan>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<BsnsRepayplan> queryAll(BsnsRepayplan bsnsRepayplan) {
		List<BsnsRepayplan> list = bsnsRepayplanDao.queryAll(bsnsRepayplan);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param bsnsRepayplan
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(BsnsRepayplan bsnsRepayplan) {
		
	}
	
	/**
	 * 新增操作
	 * @param bsnsRepayplan
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(BsnsRepayplan bsnsRepayplan) {
		bsnsRepayplanDao.addAll(bsnsRepayplan);
		
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public  void delete(String id) {
		bsnsRepayplanDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public BsnsRepayplan getById(String id) {
		return bsnsRepayplanDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param bsnsRepayplan
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(BsnsRepayplan bsnsRepayplan) {
		bsnsRepayplanDao.modify(bsnsRepayplan);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<BsnsRepayplan> findAll() {
		return bsnsRepayplanDao.findAll();
	}

	@Override
	public PageView queryDueno(PageView pageView, BsnsRepayplan bsnsRepayplan) {
		List<BsnsRepayplan> list = bsnsRepayplanDao.queryDueno(pageView, bsnsRepayplan);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public  List<BsnsRepayplan> createDefaultPlan(String dueno, String hkr) {
		BsnsCalcTool bsnsCalcTool = new BsnsCalcTool();
		// 通过dueno查询BsnsLnmain对象 loan
		String bsnsno = dueno; // 业务编号同借据编号
		BsnsBill bsnsBill = bsnsBillDao.findByDueno(dueno);
		BsnsLnmain loan = bsnsLnmainDao.findByBsnsno(bsnsno);
		BsnsCntrct bsnsCntrct = bsnsCntrctDao.findByCntrctno(loan.getCntrctno());
		List<BsnsRepayplan> planList = bsnsCalcTool.CreatNewPlan(loan, bsnsBill, bsnsCntrct, hkr);
		return planList;
	}
	
	//判断是否已生成还款计划
	public int getCountPlan(String dueno){
		return bsnsRepayplanDao.getCountPlan(dueno);
	}
	
	//查看已生成的还款计划
	public List<BsnsRepayplan> getByDueno(String dueno){
		return bsnsRepayplanDao.getByDueno(dueno);
	}
	
	/**
	 * 保存还款计划
	 * xjh
	 */
	@Override
	public void addList(List<BsnsRepayplan> list, String dueno, String payday, String specailDay) {
		// 获取借据信息
		BsnsBill bsnsBill = bsnsBillDao.findByDueno(dueno);
		
		// 获取合同信息
		String cntrctno = bsnsBill.getCntrctno();
		BsnsCntrct bsnsCntrct = bsnsCntrctDao.findByCntrctno(cntrctno);
		
		// 获取客户信息
		String clntno = bsnsBill.getClntno();
		ClntClient clntClient = clntClientDao.getById(clntno);
		
		// 获取管户人信息
		String userId = clntClient.getUserid();
		Operator operator = loginDao.findByEmpno(userId);
		
		for(int i = 0; i < list.size(); i++){
			BsnsRepayplan bsnsRepayplan = list.get(i);
			bsnsRepayplan.setSrlno(WaterIdGener.genPKWithPrefix("JH"));
			bsnsRepayplan.setClntno(clntno);
			bsnsRepayplan.setClntnm(clntClient.getClntname());
			bsnsRepayplan.setCntrctno(cntrctno);
			bsnsRepayplan.setIntrstmd(bsnsCntrct.getIntrstmd());
			bsnsRepayplan.setOpno(userId);
			bsnsRepayplan.setDptno(operator.getDptno());
			bsnsRepayplan.setDueno(dueno);
			//设置新建时间以及更新时间
			bsnsRepayplan.setCreatedate(StringUtil.getFormatDate(new Date(), "yyyyMMdd"));
			bsnsRepayplan.setUpdatedate(StringUtil.getFormatDate(new Date(), "yyyyMMdd"));
			bsnsRepayplanDao.add(bsnsRepayplan);
		}
		
		BsnsLnout bsnsLnout = new BsnsLnout();
		bsnsLnout.setOutno(dueno);
		bsnsLnout.setOutstt(PubConstants.OUTSTT_OUTED);
	    bsnsLnoutDao.billoutEnd(bsnsLnout);
		
		//add by xjh for 更新bsns_lnmain表，ISFIXREPAY（是否固定还款日）20150329 start
		BsnsLnmain bsnsLnmain =  bsnsLnmainDao.findByBsnsno(dueno);
		if(null != bsnsLnmain){
			BsnsLnmain bsnsLnmainUpdate = new BsnsLnmain(bsnsLnmain.getBsnsid());
			//zc修改  固定还款日
			if(PubConstants.FIXREPAY_YES.equals(payday)){
				bsnsLnmainUpdate.setIsfixrepay(PubConstants.FIXREPAY_YES);
				bsnsLnmainUpdate.setFixdate(specailDay);
			}else{				
				bsnsLnmainUpdate.setIsfixrepay(PubConstants.FIXREPAY_NO);
			}
			bsnsLnmainDao.modify(bsnsLnmainUpdate);
		}
		// add by xjh for 更新bsns_lnmain表，ISFIXREPAY（是否固定还款日）20150329 end
		
		// ====补录合同，生成还款计划后，属于已放款合同====
		// add by xjh for 更新bsns_cntrct表，OUTFLG（放款标志）20150403 start
		if(null != bsnsCntrct){
			if(PubConstants.CNTRCTSTT_HISTORY_BILL.equals(bsnsCntrct.getCntrctstt()) && !PubConstants.OUTFLG_YES.equals(bsnsCntrct.getOutflg())){
				bsnsCntrct = new BsnsCntrct(bsnsCntrct.getCntrctno());
				bsnsCntrct.setOutflg(PubConstants.OUTFLG_YES);
				bsnsCntrctDao.update(bsnsCntrct);
			}
		}
		// add by xjh for 更新bsns_cntrct表，OUTFLG（放款标志）20150403 end
		
		// ====生成还款计划后，更新BSNS_BILL表DLFLG（是否已生成还款计划）====
		// add by xjh for 更新BSNS_BILL表DLFLG 20150407 start
		bsnsBill.setDlflg(PubConstants.DLFLG_HKJH_YES);
		if(null != bsnsCntrct){
			if(PubConstants.CNTRCTSTT_HISTORY_BILL.equals(bsnsCntrct.getCntrctstt()) ){
				bsnsBill.setOutflg(PubConstants.FK_OUTFLG);
			}
		}
		
		bsnsBillDao.modify(bsnsBill);
		// add by xjh for 更新BSNS_BILL表DLFLG 20150407 end
		
		//生成凭证
		FnncVoucher fv=new FnncVoucher();
		fv.setPzno(WaterIdGener.getWaterId());
		fv.setCntrctno(cntrctno);
		fv.setDueno(dueno);
		fv.setType("1");
		//fv.setStatus("0");
		fv.setStatus("1");//放款已复核(zc修改，省去复核)
		fnncvoucherservice.add(fv);
		
		//  add  by  zc
		//放款复核
		String pay = "";
		if(null != bsnsLnmain){
			pay = bsnsLnmain.getOutyp();
		}
		this.checkIn(dueno,operator,pay);
	}
	
	public  void checkIn(String dueno,Operator operator,String pay) {
		BsnsLnout bsnslnout=bsnsLnoutService.getById(dueno);
		String remarks=bsnslnout.getClntnm()+"领取 合同号:"+bsnslnout.getCntrctno()+" 贷款本金:"+bsnslnout.getOutamnt();
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
		
		//==============================================chiled1
		FnncPrfdtl spl=new FnncPrfdtl();
		 String sqnno=WaterIdGener.getWaterId();
		 spl.setPrftrcno(accntxx+opno);//流水号
		 spl.setSqnno(sqnno);//顺序号
		/* if("2".equals(pay)){//银付
			 spl.setAccntno(bankno);//科目编号
			 spl.setUpaccntno("1002");//所属科目编号
		 }else{//现付
			 spl.setAccntno("1001");//科目编号
			 spl.setUpaccntno("100101");//所属科目编号
		 }*/
		 FnncDealitem item=new FnncDealitem();
		 item.setDealtype("LNFK");
		 item.setDlflg("1");
		 item.setAccnttype(PubConstants.ACCNTTYPE_0);//贷款科目
		 FnncDealitem fnncdealitem= fnncDealitemService.queryItem(item);
		 String accntno=fnncdealitem.getAccntno();
		 spl.setAccntno(accntno);
		 spl.setUpaccntno(accntno.substring(0,4));
		 spl.setRemark("");//摘要
		 spl.setSqsort("1");//顺序号
		 spl.setJdflg("1");//贷标志
		 spl.setAmnt(bsnslnout.getOutamnt());//发生金额
		 fnncprfdtlservice.add(spl);
		//==============================================chiled2
			FnncPrfdtl spl2=new FnncPrfdtl();
			 String sqnno2=WaterIdGener.getWaterId();
			 spl2.setPrftrcno(accntxx+opno);//流水号
			 spl2.setSqnno(sqnno2);//顺序号
			/* if("2".equals(pay)){//银付
				 spl2.setAccntno(bankno);//科目编号
				 spl2.setUpaccntno("1002");//所属科目编号
			 }else{//现付
				 spl2.setAccntno("1001");//科目编号
				 spl2.setUpaccntno("100101");//所属科目编号
			 }*/
			 FnncDealitem item2=new FnncDealitem();
			 if(!"430003".equals(pay)){//银付
				 item2.setDealtype("LNFK");
				 item2.setDlflg("2");
				 item2.setAccnttype(PubConstants.ACCNTTYPE_2);//贷款科目
			 }else{//现付
				 item2.setDealtype("LNFK");
				 item2.setDlflg("2");
				 item2.setAccnttype(PubConstants.ACCNTTYPE_1);//贷款科目
			 }
			 FnncDealitem fnncdealitem2= fnncDealitemService.queryItem(item2);
			 String accntno2=fnncdealitem2.getAccntno();
			 spl2.setAccntno(accntno2);
			 spl2.setUpaccntno(accntno2.substring(0,4));
			 spl2.setRemark("");//摘要
			 spl2.setSqsort("2");//顺序号
			 spl2.setJdflg("2");//借标志
			 spl2.setAmnt(bsnslnout.getOutamnt());//发生金额
			 fnncprfdtlservice.add(spl2);
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
					String sqnno3 = spl.getSqnno();
					/**科目控制码==>db_column: ACCNTCTLCD*/
					String accntno1 = spl.getAccntno();
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
					fnncChckprfdtl.setSqnno(sqnno3);
					fnncChckprfdtl.setAccntno(accntno1);
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
					BigDecimal amnt2 = spl.getAmnt();
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
				//add to 复核详细表 end
					
					// add by xjh for 合同“放款标志”更新为“已放款”,方便数据查询，20150325 start
					String cntrctno = bsnslnout.getCntrctno();
					BsnsCntrct bsnsCntrct = bsnsCntrctService.findByCntrctno(cntrctno);
					String outflg = bsnsCntrct.getOutflg(); // 放款标志，财务确认后，相应的合同才属于已放款合同
					if(Common.isEmpty(outflg) || PubConstants.OUTFLG_NO.equals(outflg)){
						bsnsCntrct = new BsnsCntrct(cntrctno);
						bsnsCntrct.setOutflg(PubConstants.OUTFLG_YES);
						bsnsCntrctService.update(bsnsCntrct);
					}
					// add by xjh for 合同“放款标志”更新为“已放款”,方便数据查询，20150325 end
					BsnsBill bbill=bsnsBillService.getById(dueno);
					bbill.setOutflg(PubConstants.FK_OUTFLG);
					bsnsBillService.modify(bbill);
			}
	}
	
	
	@Override
	public  List<BsnsRepayplan> createExtendPlan(String dueno,BsnsExtend bsnsExtend,BsnsBill bsnsBill) {
		BsnsExtendCalcTool bsnsExtendCalcTool = new BsnsExtendCalcTool();
		// 通过dueno查询BsnsLnmain对象 loan
		String bsnsno = dueno; // 业务编号同借据编号
		BsnsLnmain loan = bsnsLnmainDao.findByBsnsno(bsnsno);
		BsnsCntrct bsnsCntrct = bsnsCntrctDao.findByCntrctno(loan.getCntrctno());
		
		String hkr = null; // 固定还款日
		if(PubConstants.FIXREPAY_YES.equals(loan.getIsfixrepay())){
			hkr = loan.getFixdate();
		}
		List<BsnsRepayplan> planList = bsnsExtendCalcTool.CreatNewPlan(loan, bsnsBill, bsnsCntrct, hkr, bsnsExtend);
		return planList;
	}
	
	/**
	 * 保存还款计划
	 * zc
	 */
	@Override
	public void addExtendList(List<BsnsRepayplan> list, String dueno) {
		// 获取借据信息
		BsnsBill bsnsBill = bsnsBillDao.findByDueno(dueno);
		
		// 获取合同信息
		String cntrctno = bsnsBill.getCntrctno();
		BsnsCntrct bsnsCntrct = bsnsCntrctDao.findByCntrctno(cntrctno);
		
		// 获取客户信息
		String clntno = bsnsBill.getClntno();
		ClntClient clntClient = clntClientDao.getById(clntno);
		
		// 获取管户人信息
		String userId = clntClient.getUserid();
		Operator operator = loginDao.findByEmpno(userId);
		
		for(int i = 0; i < list.size(); i++){
			BsnsRepayplan bsnsRepayplan = list.get(i);
			bsnsRepayplan.setSrlno(WaterIdGener.genPKWithPrefix("JH"));
			bsnsRepayplan.setClntno(clntno);
			bsnsRepayplan.setClntnm(clntClient.getClntname());
			bsnsRepayplan.setCntrctno(cntrctno);
			bsnsRepayplan.setIntrstmd(bsnsCntrct.getIntrstmd());
			bsnsRepayplan.setOpno(userId);
			bsnsRepayplan.setDptno(operator.getDptno());
			bsnsRepayplan.setDueno(dueno);
			bsnsRepayplan.setActualrepaydt(null);//实际还款日期
			//设置新建时间以及更新时间
			bsnsRepayplan.setCreatedate(StringUtil.getFormatDate(new Date(), "yyyyMMdd"));
			bsnsRepayplan.setUpdatedate(StringUtil.getFormatDate(new Date(), "yyyyMMdd"));
			bsnsRepayplanDao.add(bsnsRepayplan);
		}
		
	}
	
	public BsnsRepayplan getMaxByDueno(String id) {
		return bsnsRepayplanDao.getMaxByDueno(id);
	}
	
	/**	add by hw  begin	*/
	//查找提前还款之前，应还利息和应还本金的  还款计划；
	@Override
	public List<BsnsRepayplan> getByDuenoPayed(String dueno){
		List<BsnsRepayplan> list = bsnsRepayplanDao.getByDuenoPayed(dueno);
		return list;
	}
	
	//提前还款之后，计算新的还款计划
	@Override
	public  List<BsnsRepayplan> countNewPlan(BsnsBill bsnsBill) {
		BsnsCalcTool bsnsCalcUpdateTool = new BsnsCalcTool();//提前还款
		// 通过dueno查询BsnsLnmain对象 loan
		String bsnsno = bsnsBill.getDueno(); // 业务编号同借据编号
		BsnsLnmain lnmain = bsnsLnmainDao.findByBsnsno(bsnsno);
		BsnsCntrct bsnsCntrct = bsnsCntrctDao.findByCntrctno(bsnsBill.getCntrctno());
		String hkr = lnmain.getFixdate();
		List<BsnsRepayplan> newPlanList = bsnsCalcUpdateTool.CreatNewPlan(lnmain, bsnsBill, bsnsCntrct, hkr);
		return newPlanList;
	}
	
	//查看已生成的，未还款的还款计划
	@Override
	public List<BsnsRepayplan> getByDuenoUnpay(BsnsRepayplan bsnsRepayplan){
		return bsnsRepayplanDao.getByDuenoUnpay(bsnsRepayplan);
	}
	
	//查看当前日期之前的还款计划
	@Override
	public List<BsnsRepayplan> getByDuenoOldPlan(String dueno){
		return bsnsRepayplanDao.getByDuenoOldPlan(dueno);
	}
	
	public List<BsnsRepayplan> getIsUnpayPlan(BsnsRepayplan bsnsRepayplan){
		return bsnsRepayplanDao.getIsUnpayPlan(bsnsRepayplan);
	}
	@Override
	public List<BsnsRepayplan> queryBycyclesdt(BsnsRepayplan bsnsRepayplan) {
		// TODO Auto-generated method stub
		return bsnsRepayplanDao.queryBycyclesdt(bsnsRepayplan);
	}
	
	public List<BsnsRepayplan> findAsEndDate(BsnsRepayplan bsnsRepayplan){
		return bsnsRepayplanDao.findAsEndDate(bsnsRepayplan);
	}
	
	/**	add by hw end	*/
	
	//执行提前还款操作(0:操作成功，1：操作失败)
	@Override
	public int  execPrePayment(BsnsPrePaymentBean prePamentBean,Operator operator) {
			
		//先做还款操作,再做更新还款计划操作
		try {
			//累计归还本金金额
			BigDecimal payedSum = new BigDecimal(0);
			
			//插入还款日志表
			BsnsRepaylog bsnsRepaylog = prePamentBean.getBsnsRepaylog();
			bsnsRepaylogDao.add(bsnsRepaylog);		
			//更新本次还款计划（还款计划表）
			BsnsRepayplan bsnsRepayplan = new BsnsRepayplan();
			//借据编号
			bsnsRepayplan.setDueno(bsnsRepaylog.getBsnsno());
			bsnsRepayplan.setCycleedt(bsnsRepaylog.getPaydt());			
			List<BsnsRepayplan> listBean = bsnsRepayplanDao.findAsEndDate(bsnsRepayplan);
			if(listBean != null && listBean.size()>0) {				
				/** 更新剩余每期的【待还款本金金额、待还款本金余额、需归还本金金额、累计归还本金金额、需归还利息金额】
				 *	更新条件：借据编号+还款周期结束日期 
				 * **/
				BsnsRepayplan repayplanBean = listBean.get(0);
				//根据票据号取最大的【累计归还本金金额】								
				double dblPayedSum = bsnsRepayplanDao.getMaxPayedSumAsDueNo(repayplanBean.getDueno());
				payedSum = new BigDecimal(dblPayedSum);
				//实际还款日期
				repayplanBean.setActualrepaydt(bsnsRepaylog.getPaydt());
				//实际还本金额（需归还本金金额）
				repayplanBean.setCurrepayamnt(repayplanBean.getCurrepayamnt().add(bsnsRepaylog.getRcvprinamnt()));
				//累计归还本金金额=上期累计还款本金+本次归还的本金
				repayplanBean.setRepayedprinsum(payedSum.add(bsnsRepaylog.getRcvprinamnt()));
				//还款状态
				repayplanBean.setRepaystt(PubConstants.CNTRCTEDFLG_YES);
				repayplanBean.setUpdatedate(StringUtil.getFormatDate(new Date(), "yyyyMMdd"));
				//更新操作
				bsnsRepayplanDao.modify(repayplanBean);
			}				
			
			if(bsnsRepaylog.getFinanceflg()!=null && !(PubConstants.HKBJ_FINANCEFLG_ZERO.equals(bsnsRepaylog.getFinanceflg()))){
				//主业务信息表
				BsnsLnmain bsnslnmain =bsnsLnmainDao.findByBsnsno(bsnsRepaylog.getBsnsno()); 
				bsnslnmain.setLnblnc(bsnslnmain.getLnblnc().subtract(bsnsRepaylog.getRcvprinamnt()));//更新贷款余额
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
//				//判断是否是已完结合同， 已完结合同不更新状态 【此判断似乎是多余的 fankb 2015-09-14】
//			    if(!(bsnscntrct.getCntrctedflg().equals(PubConstants.CNTRCTEDFLG_YES))){
//			    	
					// 贷款余额减去还款额 是否等于零 为零则借据还款完毕。
				if(bsnslnmain.getLnblnc().doubleValue()<=0){
					BsnsBill bill=bsnsBillDao.findByDueno(bsnslnmain.getBsnsno());
					bill.setRecflg(PubConstants.HK_RECFLG);//更新借据状态 标记本金一还款完毕
					bsnsBillDao.modify(bill);
					//统计还款总额【一笔合同，多次放款的情形时，需统计每笔已完成还款的借据金额】
					BsnsLnmain bs=bsnsLnmainDao.cougtCntrctno(cntrctno);
					if(bs!=null){
						double cntrcnt=bsnscntrct.getCntrctamnt().doubleValue();//合同金额
						double duenoamnt=bs.getCrrntamnt().doubleValue();//还款金额
						if(cntrcnt==duenoamnt){//还款金额等于合同金额 则合同结束 
							bsnscntrct.setCntrctedflg(PubConstants.CNTRCTEDFLG_YES);// 标记为结束状态
							bsnsCntrctDao.update (bsnscntrct);									
						}
					}
					//更新剩余还款计划为已还款
					/*for(int i=0; i < prePamentBean.getRepaytermnoArray().length; i++) {
						bsnsRepayplan = new BsnsRepayplan();
						bsnsRepayplan.setRepaystt(PubConstants.HKBJ_FINANCEFLG_ONE);
						//实际还款日期
						bsnsRepayplan.setActualrepaydt(bsnsRepaylog.getPaydt());
					}*/
				} else { //部分还款部分还款，则需要做新的还款计划						
					
					//缓存上一个bean对象
					BsnsRepayplan preBsnsrepayplan = new BsnsRepayplan();

			    	//新的还款计划就是更新原来的还款计划表【条件：借据编号+还款周期结束日期】				 
					for(int i=0; i < prePamentBean.getRepaytermnoArray().length; i++) {
						bsnsRepayplan = new BsnsRepayplan();
						//借据编号
						bsnsRepayplan.setDueno(bsnsRepaylog.getBsnsno());
						bsnsRepayplan.setCycleedt(prePamentBean.getCycleedtArray()[i]);			
						listBean = bsnsRepayplanDao.findAsEndDate(bsnsRepayplan);
						if(listBean != null && listBean.size()>0) {
							/** 更新剩余每期的【待还款本金金额、待还款本金余额、需归还本金金额、累计归还本金金额、需归还利息金额】
							 *	更新条件：借据编号+还款周期结束日期 
							 * **/
							BsnsRepayplan repayplanBean = listBean.get(0);
							repayplanBean.setCurrepayamnt(new BigDecimal(0));
							//需归还利息金额(应还利息)
							repayplanBean.setRepayinstamnt(prePamentBean.getRepayinstamntArray()[i]);							
							//待还款本金金额=需归还本金金额
							repayplanBean.setTbrepaypttl(prePamentBean.getCurrepayamntArray()[i]);	
							
							// 待还款本金余额 ， 累计归还本金金额
							if(i==0) {
								//第一期的待还本金余额就是借据总额								
								repayplanBean.setTbrepaybal(prePamentBean.getTbrepaybalArray()[i]);							
							} else {
								//其余的待还本金余额=上期的余额- 上期归还本金金额
								repayplanBean.setTbrepaybal(preBsnsrepayplan.getTbrepaybal().subtract(preBsnsrepayplan.getTbrepaypttl()));
							}					
							//累计归还本金金额
							repayplanBean.setRepayedprinsum(new BigDecimal(0));	
							//更新时间
							repayplanBean.setUpdatedate(StringUtil.getFormatDate(new Date(), "yyyyMMdd"));
							bsnsRepayplanDao.modify(repayplanBean);
							
							//缓存当前bean的累计值
							preBsnsrepayplan.setTbrepaybal(repayplanBean.getTbrepaybal());
							preBsnsrepayplan.setTbrepaypttl(repayplanBean.getTbrepaypttl());
																
						}							    	
				    }
			    }
				
				//zc 还款凭证复核
				bsnsRepaylogService.payCheckIn(bsnsRepaylog,bsnscntrct,operator);
			}
		}catch(Exception  e) {
			throw new RuntimeException("系统更新还款计划出现异常情况，生成新的还款计划失败" );			
		}		
		//如果是
		return 0;
	}
	
	//根据借据号和还款期数号获取还款计划信息
	public double getMaxPayedSumAsDueNo(String dueNo){
		return bsnsRepayplanDao.getMaxPayedSumAsDueNo(dueNo);
	}
	
	public BsnsRepayplan getBySrlNo(String srlNo){
		return bsnsRepayplanDao.getBySrlNo(srlNo);
	}
	
}
