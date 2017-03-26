package com.mf.acctmoduel.controller;

import java.math.BigDecimal;
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

import com.mf.acctmoduel.entity.AdvancePay;
import com.mf.cntrtmng.entity.BsnsBill;
import com.mf.cntrtmng.entity.BsnsCntrct;
import com.mf.cntrtmng.entity.BsnsLnmain;
import com.mf.cntrtmng.entity.BsnsPrePaymentBean;
import com.mf.cntrtmng.entity.BsnsRepaylog;
import com.mf.cntrtmng.entity.BsnsRepayplan;
import com.mf.cntrtmng.service.BsnsBillService;
import com.mf.cntrtmng.service.BsnsCntrctService;
import com.mf.cntrtmng.service.BsnsLnmainService;
import com.mf.cntrtmng.service.BsnsLnoutService;
import com.mf.cntrtmng.service.BsnsRepaylogService;
import com.mf.cntrtmng.service.BsnsRepayplanService;
import com.mf.common.pub.PubConstants;
import com.mf.common.util.WaterIdGener;
import com.mf.org.entity.Operator;
import com.mf.sys.entity.SysDictionary;
import com.mf.sys.service.SysDictionaryService;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;

@Controller
@RequestMapping(value="/mf/acctmoduel/advancePay")
public class AdvancePayMoneyController {
	
	@Autowired
	private BsnsRepayplanService bsnsRepayplanService;
	@Autowired
	private SysDictionaryService sysDictionaryService;
	@Autowired
	private BsnsBillService bsnsBillService;
	@Autowired
	private BsnsLnmainService bsnsLnmainService;
	@Autowired
	private BsnsCntrctService bsnsCntrctService;
	@Autowired
	private BsnsRepaylogService bsnsRepaylogService;
	@Autowired
	private BsnsLnoutService bsnsLnoutService;

	
	// 提前还款首页
	@RequestMapping(value="indexforward")
    public String indexforward(Model model,HttpServletRequest request){
		return "/mf/acctmoduel/advancepay/index";  
    }
	
	//提前还款信息（获取自 ‘bsnsbill-mapper’ 中的 “queryAdvance” 方法）
	@RequestMapping(value="forwardList")
	public String forwardList(Model model,HttpServletRequest request){
	    return "/mf/acctmoduel/advancepay/listInfo";  
	}
	
	// 查找列出来的借据信息
	@RequestMapping(value="advancelist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> advancelist(Model model,BsnsBill bsnsBill,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		List<SysDictionary> dic=sysDictionaryService.findSdBySdtCode("2002");//固定利率
		List<SysDictionary> repayWay=sysDictionaryService.findSdBySdtCode("2001");//还款方式
		Map<String, String> dicmap=new HashMap<String, String>();
		Map<String, String> repayWayMap=new HashMap<String, String>();
		for(int i=0;i<dic.size();i++){
			dicmap.put(dic.get(i).getSdvalue(),dic.get(i).getSdkey());
		}
		for(int i=0;i<repayWay.size();i++){
			repayWayMap.put(repayWay.get(i).getSdvalue(),repayWay.get(i).getSdkey());
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView =bsnsBillService.queryAdvance(pageView, bsnsBill);
		List<AdvancePay> list=pageView.getRecords();
		for(int i=0;i<list.size();i++){
			list.get(i).setIntrstmd(dicmap.get(list.get(i).getIntrstmd()));
			list.get(i).setRpmntway(repayWayMap.get(list.get(i).getRpmntway()));
		}
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	//提前还款按钮，展示界面
	@RequestMapping(value="doAdvancePay")
    public String doAdvancePay(Model model,HttpServletRequest request,HttpServletResponse response){
		String dueno = request.getParameter("dueno");
		//借据信息
		BsnsBill bsnsbill=bsnsBillService.getById(dueno);
		model.addAttribute("bsnsbill",bsnsbill);
		
		//合同信息
		BsnsCntrct bsnsCntrct = bsnsCntrctService.getById(bsnsbill.getCntrctno());
		model.addAttribute("bsnscntrct",bsnsCntrct);
		
		//五级分类参数
		List<SysDictionary> Fvc= sysDictionaryService.findSdBySdtCode("4000");
		Map<String,String> map_Fvc=new HashMap<String,String>();
		for(int i=0;i<Fvc.size();i++){
			map_Fvc.put(Fvc.get(i).getSdvalue(), Fvc.get(i).getSdkey());
		}
		BsnsLnmain bsnsLnmain = new BsnsLnmain(); 
		bsnsLnmain.setBsnsno(dueno);
		BsnsLnmain bsnsLnmain_t = bsnsLnmainService.findByBsnsno(dueno);
		bsnsLnmain_t.setFvclsstt(map_Fvc.get(bsnsLnmain_t.getFvclsstt()));		//五级分类
		bsnsLnmain_t.setCrrntamnt(bsnsLnmain_t.getCrrntamnt().subtract(bsnsLnmain_t.getLnblnc()));//已还本金
		model.addAttribute("bsnsLnmain",bsnsLnmain_t);
		
		//根据“借据号”，查找所有还款历史。计算已还款信息
		BsnsRepaylog bsnsrepaylog_1=new BsnsRepaylog();
		bsnsrepaylog_1.setBsnsno(dueno);//借据号
		BigDecimal a=new BigDecimal(0.0);
		BigDecimal b=new BigDecimal(0.0);
		BigDecimal c=new BigDecimal(0.0);
		List<BsnsRepaylog> bsnsrepaylogList=bsnsRepaylogService.queryAll(bsnsrepaylog_1);
		for(int i=0;i<bsnsrepaylogList.size();i++){
			a=a.add(bsnsrepaylogList.get(i).getRcvprinamnt());//实收金额
			b=b.add(bsnsrepaylogList.get(i).getRcvinstamnt());//实收利息
			c=c.add(bsnsrepaylogList.get(i).getDiscountamnt());//优惠金额
		}
		bsnsrepaylog_1.setRcvprinamnt(a);
		bsnsrepaylog_1.setRcvinstamnt(b);
		bsnsrepaylog_1.setDiscountamnt(c);
		model.addAttribute("bsnsrepaylog_1",bsnsrepaylog_1);//实收金额
		
		//	因为提前还款必须，前提是必须之前的都还完了，这个约束在，下面的做法没意义！  注释掉，hw 20150929
/*		//查找： 应还本金和应还利息，用于业务员对提前还款时，是否前面的已经完全做记录还款
		//	1.根据当前日期，找到之前的还款计划，
		//	2.并求和得出：应还本金与应还利息
		BigDecimal yhbj=new BigDecimal(0.0);//应还本金
		BigDecimal yhlx=new BigDecimal(0.0);//应还利息
		BsnsRepayplan bsnsRepayplan_1 = new BsnsRepayplan();
		
		//取到计划还款日小于当前日期的记录
		List<BsnsRepayplan> bsnsRepayplanList_1 = bsnsRepayplanService.getByDuenoPayed(dueno);
		for(int i=0;i<bsnsRepayplanList_1.size();i++){
			yhbj=yhbj.add(bsnsRepayplanList_1.get(i).getTbrepaypttl());//应还本金
			yhlx=yhlx.add(bsnsRepayplanList_1.get(i).getRepayinstamnt());//应还利息
		}
		bsnsRepayplan_1.setTbrepaypttl(yhbj);
		bsnsRepayplan_1.setRepayinstamnt(yhlx);
		model.addAttribute("bsnsRepayplan_1",bsnsRepayplan_1);//所有应还金额；用于后面的金额比对
*/		
		
		//根据“借据号”，找到所有的还款计划表
		List<SysDictionary> dic= sysDictionaryService.findSdBySdtCode("2019");//把还款状态设置为中文
		Map<String,String> map=new HashMap<String,String>();
		for(int i=0;i<dic.size();i++){
			map.put(dic.get(i).getSdvalue(), dic.get(i).getSdkey());
		}
		BsnsRepayplan bsnsRepayplan = new BsnsRepayplan();
		bsnsRepayplan.setDueno(dueno);		
/*		PageView pageView= bsnsRepayplanService.query1(new PageView(1),bsnsRepayplan);
		List<BsnsRepayplan> list = pageView.getRecords();*/
		List<BsnsRepayplan> list = bsnsRepayplanService.queryNew(bsnsRepayplan);
		int iFlg =0;
		for(int j=0;j<list.size();j++){		
			//去最近一笔未还款的金额,用作提前还款的判断标志
			if(list.get(j).getRepaystt().equals(PubConstants.HKBJ_FINANCEFLG_ZERO) && iFlg ==0) {
				//未还款
				iFlg =1;
				//本期应还款金额
				model.addAttribute("normalAmount",list.get(j).getCurrepayamnt());
				//本期还款日
				model.addAttribute("normalPayDate",list.get(j).getCycleedt());
				
				//如果提前还款日是最后一期，那么就不能做提前还款
				if(list.get(j).getCycleedt().equals(bsnsbill.getMtrtydate())) {					 
					 WebTool.writeJson("最后一期还款不能做提前还款操作，请使用正常还款功能！", response);
					 return null;
				}
			}
			list.get(j).setRepaystt(map.get(list.get(j).getRepaystt()));
		}
		model.addAttribute("planlist",list);
		
		//查找所有的还款记录中，还款计划为提前还款的，最大的当前还款日期
		BsnsRepaylog bsnsRepaylog_dt = bsnsRepaylogService.getForMaxDt(dueno);
		if(bsnsRepaylog_dt!=null){
			model.addAttribute("bsnsRepaylog_dt",bsnsRepaylog_dt);
		}
				
		return "/mf/acctmoduel/advancepay/doAdvancePay";
	}
	
	
	//展示还款历史界面
	@RequestMapping(value="viewHistory")
	public String viewHistory(Model model,HttpServletRequest request){
		//根据 “计划还款编号”，查找当期还款历史
		String t_srlno = request.getParameter("srlno");
		//计划还款信息
		BsnsRepayplan bsnsRepayplan = bsnsRepayplanService.getById(t_srlno);
		model.addAttribute("bsnsrepayplan",bsnsRepayplan);
		
		//合同信息
		BsnsCntrct bsnsCntrct = bsnsCntrctService.getById(bsnsRepayplan.getCntrctno());
		model.addAttribute("bsnscntrct",bsnsCntrct);
		
		//已还款信息
		BsnsRepaylog bsnsrepaylog=new BsnsRepaylog();
		bsnsrepaylog.setSrlno(t_srlno);
		BigDecimal a=new BigDecimal(0.0);
		BigDecimal b=new BigDecimal(0.0);
		BigDecimal c=new BigDecimal(0.0);
		List<BsnsRepaylog> bsnsrepaylogList=bsnsRepaylogService.queryAll(bsnsrepaylog);
		model.addAttribute("bsnsrepaylogList",bsnsrepaylogList);
		for(int i=0;i<bsnsrepaylogList.size();i++){
			a=a.add(bsnsrepaylogList.get(i).getRcvprinamnt());//实收金额
			b=b.add(bsnsrepaylogList.get(i).getRcvinstamnt());//实收利息
			c=c.add(bsnsrepaylogList.get(i).getDiscountamnt());//优惠金额
		}
		bsnsrepaylog.setRcvprinamnt(a);
		bsnsrepaylog.setRcvinstamnt(b);
		bsnsrepaylog.setDiscountamnt(c);
		model.addAttribute("bsnsrepaylog",bsnsrepaylog);
		
		return "/mf/acctmoduel/advancepay/repayhistory";
	}
	
	
	//重新计算还款计划，
	@RequestMapping(value="reCountPlan")
	public String reCountPlan(Model model,HttpServletRequest request){
		//由dueno查询借据信息,借据信息通过对象传递到前台 - TBD
		String dueno = request.getParameter("dueno");
		
		//获取已还本金和已还利息
		String yhbj = request.getParameter("yhbj");
		String yhlx = request.getParameter("yhlx");
		model.addAttribute("yhbj",yhbj);
		model.addAttribute("yhlx",yhlx);
		
		//提前还款日期
		String paydt = request.getParameter("paydt");
		String accno = request.getParameter("accno");	//银行名称
		String accnum = request.getParameter("accnum");	//账号
		model.addAttribute("accno",accno);
		if(!Common.isEmpty(accnum) ){
			accno = accno +"|"+accnum;
		}
		
		String needpayamnt = request.getParameter("needpayamnt");//仍然欠本金
		
		String fnamnt_s = request.getParameter("fnamnt");//违约金
		String fninstamnt_s = request.getParameter("fninstamnt");//罚息
		
		//临时生成还款记录的信息
		String paymode = request.getParameter("paymode");//支付方式
		String prepayamnt = request.getParameter("prepayamnt");//实还本金
		String prepayblaamnt = request.getParameter("prepayblaamnt");//实还利息
		String receviedamnt = request.getParameter("receviedamnt");//实收总额
		BigDecimal rcvamnt = new BigDecimal(receviedamnt);
		BigDecimal rcvprinamnt = new BigDecimal(prepayamnt);
		BigDecimal rcvinstamnt = new BigDecimal(prepayblaamnt);
		BigDecimal money = new BigDecimal(needpayamnt);
		BigDecimal fnamnt = new BigDecimal(fnamnt_s);
		BigDecimal fninstamnt = new BigDecimal(fninstamnt_s);
		
		
		//记录应还款信息
		BsnsRepaylog bsnsRepaylog_tmp = new BsnsRepaylog();
		String logid=WaterIdGener.getWaterId();
		bsnsRepaylog_tmp.setLogid(logid);	//支付方式
		bsnsRepaylog_tmp.setBsnsno(dueno);	//业务编号
		bsnsRepaylog_tmp.setFinanceflg("1");//还款状态 1已还、0未还款、
		bsnsRepaylog_tmp.setPaymode(paymode);	//支付方式
		bsnsRepaylog_tmp.setAccno(accno);	//银行名字
		bsnsRepaylog_tmp.setRcvamnt(rcvamnt);	//实收总额
		bsnsRepaylog_tmp.setRcvprinamnt(rcvprinamnt);//实收本金金额
		bsnsRepaylog_tmp.setRcvinstamnt(rcvinstamnt);//实收利息金额
		bsnsRepaylog_tmp.setPaydt(paydt);	//还款日期
		bsnsRepaylog_tmp.setFnamnt(fnamnt);	//违约金
		bsnsRepaylog_tmp.setFninstamnt(fninstamnt);	//罚息
		model.addAttribute("bsnsRepaylog_tmp",bsnsRepaylog_tmp)	;
		
		//临时记录借据（改变开始日期，合同金额，用于生成新的还款计划）
		BsnsBill bsnsBill = bsnsBillService.findByDueno(dueno);
		bsnsBill.setOutdate(paydt);
		bsnsBill.setDueamnt(money);
		model.addAttribute("bsnsBill",bsnsBill);
		
		//找到合同
		BsnsCntrct bsnsCntrct = bsnsCntrctService.findByCntrctno(bsnsBill.getCntrctno());
		model.addAttribute("bsnsCntrct",bsnsCntrct);
		
		//同时计算默认的还款计划()
		BigDecimal m = new BigDecimal(0);
		if(money.compareTo(m) == 1){   //money > 0
			List<BsnsRepayplan> newPlanlist = bsnsRepayplanService.countNewPlan(bsnsBill);
			model.addAttribute("planlist", newPlanlist);
		}
		
		return "/mf/acctmoduel/advancepay/shownewplan";
	}
	
	
	//更新还款计划,并存入收款记录
	@RequestMapping(value="updatePlan")
	public String updatePlan(Model model,BsnsRepayplan bsnsrepayplan, HttpServletResponse response,HttpServletRequest request){
		String result = "{\"msg\":\"suc\",\"message\":\" suc\"}";
		String dueno = bsnsrepayplan.getDueno();
		
		//实收本金金额
		String rcvprinamnt = request.getParameter("rcvprinamnt");
		//实收利息金额
		String rcvinstamnt = request.getParameter("rcvinstamnt");
		//实收总额
		String rcvamnt = request.getParameter("rcvamnt");
		//还款日期
		String paydt = request.getParameter("paydt");
		//支付方式
		String paymode = request.getParameter("paymode");
		//银行卡账户
		String accno = request.getParameter("accno");
		String fnamnt_s = request.getParameter("fnamnt");//违约金
		String fninstamnt_s = request.getParameter("fninstamnt");//罚息
		
		BigDecimal benjin = new BigDecimal(rcvprinamnt);
		BigDecimal lixi = new BigDecimal(rcvinstamnt);
		BigDecimal zonge = new BigDecimal(rcvamnt);
		BigDecimal fnamnt = new BigDecimal(fnamnt_s);
		BigDecimal fninstamnt = new BigDecimal(fninstamnt_s);
		
		BsnsPrePaymentBean prePamentBean = new BsnsPrePaymentBean();
		//期数
		prePamentBean.setRepaytermnoArray(request.getParameterValues("repaytermno"));
		// 还款计划编号
		prePamentBean.setSrlnoArray(request.getParameterValues("srlno"));		
		// 还款周期开始日期
		prePamentBean.setCyclesdtArray(request.getParameterValues("cyclesdt"));
		// 还款周期结束日期
		prePamentBean.setCycleedtArray(request.getParameterValues("cycleedt"));	
		if(request.getParameterValues("repayinstamnt") != null){
			// 需归还利息金额(应还利息)
			prePamentBean.setRepayinstamntArray(castArrayStrToBd(request.getParameterValues("repayinstamnt")));
			// 需归还本金金额(应还本金)
			prePamentBean.setCurrepayamntArray(castArrayStrToBd(request.getParameterValues("currepayamnt")));
			//待还款本金金额
			prePamentBean.setTbrepaypttlArray(castArrayStrToBd(request.getParameterValues("tbrepaypttl")));		
			//待还款本金余额
			prePamentBean.setTbrepaybalArray(castArrayStrToBd(request.getParameterValues("tbrepaybal")));
			//累计归还本金金额
			prePamentBean.setRepayedprinsumArray(castArrayStrToBd(request.getParameterValues("repayedprinsum")));
		}
		
								
		try {
			/** 
			 * 	判断旧的还款计划是否全部做完还款
			 * 	1.没做完，返回做正常还款
			 * 	2.假如做完了，继续
			 */
//			BsnsRepayplan bsnsRepayplan_2 = new BsnsRepayplan();
//			bsnsRepayplan_2.setDueno(dueno);
//			bsnsRepayplan_2.setCyclesdt(paydt);
//			List<BsnsRepayplan> list_2 = bsnsRepayplanService.getIsUnpayPlan(bsnsRepayplan_2);//查找提前还款日期之前的提前还款状态
//			if(list_2.size()>0){
//				//存在未还款的还款计划，需要做正常还款
//				result = "{\"msg\":\"fail\",\"message\":\""
//						+ WebTool.getErrorMsg("该客户在"+paydt+"日之前有未做完的还款，请正常还款后，再做提前还款！")+ "\"}";
//				WebTool.writeJson(result, response);
//				return null;
//			}else{				
 
					//准备【还款日志表数据】
					BsnsRepaylog bsnsRepaylog = new BsnsRepaylog();
					String logid=WaterIdGener.getWaterId();// 生成主键
					bsnsRepaylog.setLogid(logid);
					bsnsRepaylog.setBsnsno(dueno);
					bsnsRepaylog.setRcvprinamnt(benjin);
					bsnsRepaylog.setRcvinstamnt(lixi);
					bsnsRepaylog.setRcvamnt(zonge);
					bsnsRepaylog.setPaydt(paydt);//还款日期
					bsnsRepaylog.setPaymode(paymode);
					bsnsRepaylog.setAccno(accno);
					bsnsRepaylog.setFnamnt(fnamnt);
					bsnsRepaylog.setFninstamnt(fninstamnt);
					bsnsRepaylog.setFinanceflg(PubConstants.HKBJ_FINANCEFLG_ONE);//设置还款历史表中的[财务复核标识为“已还款”
					
					BsnsRepayplan bsnsRepayplan_t = new BsnsRepayplan();
					bsnsRepayplan_t.setDueno(bsnsRepaylog.getBsnsno());
					bsnsRepayplan_t.setCycleedt(bsnsRepaylog.getPaydt());			
					List<BsnsRepayplan> listBean = bsnsRepayplanService.findAsEndDate(bsnsRepayplan_t);
					bsnsRepaylog.setSrlno(listBean.get(0).getSrlno());//还款编号设置为特殊字符
					/*bsnsRepaylog.setSrlno(PubConstants.G_Pre_PAYMENT_NO);//还款编号设置为特殊字符
*/					
					//保存还款日志对象到缓存对象中
					prePamentBean.setBsnsRepaylog(bsnsRepaylog);
					
					//临时记录借据（改变开始日期，合同金额，用于生成新的还款计划）
					BsnsBill bsnsBill = bsnsBillService.findByDueno(dueno);
					prePamentBean.setBsnsBill(bsnsBill);
					//执行提前还款操作，插入更新相关表
					Operator operator = (Operator)request.getSession().getAttribute("operator");
					 int iRet = bsnsRepayplanService.execPrePayment(prePamentBean,operator);						
//			}
		
		} catch (Exception e) {
			result = "{\"msg\":\"fail\",\"message\":\""
					+ WebTool.getErrorMsg(e.getMessage()) + "\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	// String[] 数组转换为 BigDecimal[]数组
	private BigDecimal[] castArrayStrToBd(Object[] oArr){
		BigDecimal bd = null;
		BigDecimal[] bdArr = new BigDecimal[oArr.length];
		for(int k = 0; k < oArr.length; k++){
			bd = new BigDecimal((String)oArr[k]); 
			bdArr[k] = bd;
		}
		return bdArr;
	}
	
	
}
