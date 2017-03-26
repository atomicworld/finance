package com.mf.financemng.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.cntrtmng.entity.BsnsBill;
import com.mf.cntrtmng.entity.BsnsCntrct;
import com.mf.cntrtmng.entity.BsnsLnout;
import com.mf.cntrtmng.entity.BsnsRepaylog;
import com.mf.cntrtmng.service.BsnsBillService;
import com.mf.cntrtmng.service.BsnsCntrctService;
import com.mf.cntrtmng.service.BsnsLnoutService;
import com.mf.cntrtmng.service.BsnsRepaylogService;
import com.mf.common.pub.PubConstants;
import com.mf.common.util.WaterIdGener;
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
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;

/**      
* 类名称：FnncVoucherController   
* 类描述：自动生成凭证（放款 和 还款）
* 创建人：wangyaowei  
* 创建时间：2015-3-3 下午6:02:30   
* 修改人：wangyaowei  
* 修改时间：2015-3-3 下午6:02:30   
* 修改备注：   
* @version    
*    
*/
@Controller
@RequestMapping(value="/mf/fnncvoucher/")
public class FnncVoucherController {
	@Autowired
	private FnncVoucherService fnncVoucherService;
	@Autowired
	private BsnsCntrctService bsnsCntrctService;
	@Autowired
	private BsnsLnoutService bsnsLnoutService;
	@Autowired
	private FnncPrfbsService fnncprfbsservice;
	@Autowired
	private FnncPrfdtlService fnncprfdtlservice;
	@Autowired
	private FnncChckprfbsService fnncChckprfbsService;
	@Autowired
	private FnncChckprfdtlService fnncChckprfdtlService;
	@Autowired
	private BsnsRepaylogService bsnsRepaylogService;
	@Autowired
	private FnncDealitemService fnncDealitemService;
	@Autowired
	private BsnsBillService bsnsBillService;
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="voucherUI")
	public String addUI(Model model){
		return "/mf/financemng/voucher/voucherUI";
	}
	@RequestMapping(value="page1")
	public String page1(Model model){
		return "/mf/financemng/voucher/page1";
	}
	@RequestMapping(value="page2")
	public String page2(Model model){
		return "/mf/financemng/voucher/page2";
	}
	
	
	@RequestMapping(value="view1")
	public String view1(Model model,String pzno){
		FnncVoucher fnncvoucher=fnncVoucherService.getById(pzno);
		BsnsCntrct bsnscntrct=bsnsCntrctService.getById(fnncvoucher.getCntrctno());
		BsnsLnout bsnslnout=bsnsLnoutService.getById(fnncvoucher.getDueno());
		model.addAttribute("bsnscntrct", bsnscntrct);
		model.addAttribute("bsnslnout", bsnslnout);
		model.addAttribute("pzno",pzno);
		return "/mf/financemng/voucher/view1";
	}
	
	@RequestMapping(value="view2")
	public String view2(Model model,String pzno){
		FnncVoucher fnncvoucher=fnncVoucherService.getById(pzno);
		BsnsCntrct bsnscntrct=bsnsCntrctService.getById(fnncvoucher.getCntrctno());
		BsnsRepaylog bsnsrepaylog=bsnsRepaylogService.getById(fnncvoucher.getLogid());
		model.addAttribute("bsnscntrct", bsnscntrct);
		model.addAttribute("bsnsrepaylog", bsnsrepaylog);
		model.addAttribute("pzno",pzno);
		return "/mf/financemng/voucher/view2";
	}
	
	/**
	* @author wangyaowei
	* @date 2015-3-5上午2:39:59
	* @Title: checkIn
	* @Description: TODO(放款凭证复核)
	* @param model
	* @param response
	* @param request
	* @return
	* @return String    返回类型
	* @throws
	*/
	@RequestMapping(value="checkIn")
	public String checkIn(Model model,HttpServletResponse response,HttpServletRequest request){
		String result = "{\"status\":1,\"message\":\"复合成功！\"}";
		try {
			String pzno=request.getParameter("pzno");
			String pay=request.getParameter("pay");
			String bankno=request.getParameter("bank");
			System.out.println("====="+pzno+"===="+pay+"==="+bankno);
			FnncVoucher fnncvoucher=fnncVoucherService.getById(pzno);
			
			BsnsLnout bsnslnout=bsnsLnoutService.getById(fnncvoucher.getDueno());
			String remarks=bsnslnout.getClntnm()+"领取 合同号:"+bsnslnout.getCntrctno()+" 贷款本金:"+bsnslnout.getOutamnt();
			String prefix="XF";//现付
			if(!"430003".equals(pay)){
				prefix="YF";//银付
			}
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			Operator operator = (Operator)request.getSession().getAttribute("operator");
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
						fnncvoucher.setStatus("1");
						fnncVoucherService.modify(fnncvoucher);
						
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
						BsnsBill bbill=bsnsBillService.getById(fnncvoucher.getDueno());
						bbill.setOutflg(PubConstants.FK_OUTFLG);
						bsnsBillService.modify(bbill);
						
				}
		} catch (Exception e) {
			result="{\"status\":0,\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	/**
	* @author wangyaowei
	* @date 2015-3-5下午5:38:28
	* @Title: payCheckIn
	* @Description: TODO(还款复核操作)
	* @param model
	* @param response
	* @param request
	* @return
	* @return String    返回类型
	* @throws
	*/
	@RequestMapping(value="payCheckIn")
	public String payCheckIn(Model model,HttpServletResponse response,HttpServletRequest request){
		String result = "{\"status\":1,\"message\":\"复合成功！\"}";
		try {
			String pzno=request.getParameter("pzno");//凭证号
			String pay=request.getParameter("pay");//支付方式
			FnncVoucher fnncvoucher=fnncVoucherService.getById(pzno);
			BsnsCntrct bsnscntrct=bsnsCntrctService.getById(fnncvoucher.getCntrctno());
			BsnsRepaylog bsnsrepaylog=bsnsRepaylogService.getById(fnncvoucher.getLogid());
			String remarks=bsnscntrct.getClntnm()+"还款 合同号:"+bsnscntrct.getCntrctno()+" 贷款本金:"+bsnsrepaylog.getRcvprinamnt().add(bsnsrepaylog.getRcvinstamnt());
			String prefix="XF";//现付
			if(!"430003".equals(pay)){
				prefix="YF";//银付
			}
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			Operator operator = (Operator)request.getSession().getAttribute("operator");
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
					//add to 复核详细表 end
						fnncvoucher.setStatus("1");
						fnncVoucherService.modify(fnncvoucher);
				}
		} catch (Exception e) {
			result="{\"status\":0,\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param fnncvoucher
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,BsnsCntrct bsnscntrct,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = fnncVoucherService.queryOutmnt(pageView, bsnscntrct);
		List<FnncVoucher> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	@RequestMapping(value="showpaylist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showpaylist(Model model,BsnsCntrct bsnscntrct,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = fnncVoucherService.queryPaymnt(pageView, bsnscntrct);
		List<FnncVoucher> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
}

