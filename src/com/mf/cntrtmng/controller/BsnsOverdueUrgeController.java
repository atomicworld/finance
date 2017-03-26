package com.mf.cntrtmng.controller;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mf.client.service.ClntClientService;
import com.mf.cntrtmng.entity.BsnsCntrct;
import com.mf.cntrtmng.entity.BsnsOverdueUrge;
import com.mf.cntrtmng.entity.BsnsRepayplan;
import com.mf.cntrtmng.service.BsnsCntrctService;
import com.mf.cntrtmng.service.BsnsOverdueUrgeService;
import com.mf.cntrtmng.service.BsnsRepayplanService;
import com.mf.common.util.NOSUtil;
import com.mf.common.util.StringUtil;
import com.mf.org.entity.Operator;
import com.mf.util.FormatDateUtil;

/**
 * @author huangw
 * @2015-05-29
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/cntrtmng/bsnsoverdueurge/")
public class BsnsOverdueUrgeController {
	
	@Autowired
	private ClntClientService clntClientService;
	@Autowired
	private BsnsOverdueUrgeService bsnsOverdueUrgeService;
	@Autowired
	private BsnsRepayplanService bsnsRepayplanService;
	@Autowired
	private BsnsCntrctService bsnsCntrctService;
	
	/**
	* @author huangwen
	* @date 2015-5-28下午5:34:27
	* @Title: showTabInfo
	* @Description: TODO(逾期贷款催收 查看页面)
	* @param model
	* @param outno
	* @return String    返回类型
	*/
	@RequestMapping(value="showUrgeInfo")
	public String showUrgeInfo(Model model, String srlno, String cntrctno, HttpServletRequest request){
		model.addAttribute("srlno",srlno);
		model.addAttribute("cntrctno",cntrctno);
		BsnsOverdueUrge bsnsOverdueUrge = new BsnsOverdueUrge();
		String date = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
		//判断当天是否已经催收s
		if(bsnsOverdueUrgeService.exist(srlno,date)){
			bsnsOverdueUrge.setSrlno(srlno);
			BsnsRepayplan bsnsRepayplan =  bsnsRepayplanService.getById(srlno);
			bsnsOverdueUrge.setClntno(bsnsRepayplan.getClntnm());
			bsnsOverdueUrge.setUrgedate(date.toString());
			bsnsOverdueUrge.setCntrctno(cntrctno.toString());
			Operator operator = (Operator)request.getSession().getAttribute("operator");
			bsnsOverdueUrge.setUrgeid(operator.getEmplyno());
			bsnsOverdueUrge.setUrgename(operator.getOpnm());
			bsnsOverdueUrgeService.add(bsnsOverdueUrge);
		}
		return "/mf/aftrmng/rtrnOver/UrgeJsp";
	}
	
	/**
	* @author huangwen
	* @date 2015-5-28下午5:34:27
	* @Title: showTabInfo
	* @Description: TODO(逾期催收表  页面)
	* @param model
	* @param 
	* @return String    返回类型
	*/
	@RequestMapping(value="showUrgeTable")
	public String showUrgeTable(Model model,String srlno){
		//找到逾期催收表
		String date = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
		List<BsnsOverdueUrge> list = bsnsOverdueUrgeService.findBy(srlno,date);
		if(list.size()>0){
			BsnsOverdueUrge bsnsoverdueurge = list.get(0);
			model.addAttribute("bsnsoverdueurge", bsnsoverdueurge);
		}
		return "/mf/aftrmng/rtrnOver/UrgeTable";
	}
	
	/**
	* @author huangwen
	* @Title: printOverdue
	* @Description: TODO(打印催收通知单)
	* @param model
	* @param request
	* @return String    返回类型
	* @throws
	*/
	@RequestMapping(value = "printOverdue")
	public String printOverdue(Model model,String srlno,HttpServletRequest request) {
		String date = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
		String filename=request.getParameter("filename");
		List<BsnsOverdueUrge> list = bsnsOverdueUrgeService.findBy(srlno,date);	
		BsnsRepayplan bsnsRepayplan = bsnsRepayplanService.getById(srlno);	//还款计划表
		
		if(list.size()>0){
			BsnsOverdueUrge bsnsoverdueurge = list.get(0);
			BsnsCntrct bsnscntrct=bsnsCntrctService.findByCntrctno(bsnsoverdueurge.getCntrctno());//合同信息表
//			String e_date=PraseDate.prase(bsnscntrct.getCntrctedate());//借款开始日期
//			String s_date=PraseDate.prase(bsnscntrct.getCntrctsdate());//借款到期日期
			String money = NOSUtil.change(bsnscntrct.getCntrctamnt().doubleValue());
			String e_date = FormatDateUtil.prase(bsnsRepayplan.getCycleedt());//还款周期结束日期
			String s_date = FormatDateUtil.prase(bsnsRepayplan.getCyclesdt());//还款周期开始日期
			
			StringBuffer params=new StringBuffer();	
			
			String clntnm = bsnsRepayplan.getClntnm();	//客户姓名
			String urgename = bsnsoverdueurge.getUrgename();	//催收人姓名
			String t_date = bsnsoverdueurge.getUrgedate();	//当前日期
			
			String currepayamnt = NOSUtil.change(bsnsRepayplan.getCurrepayamnt().doubleValue());//须还本金金额
			String repayinstamnt = NOSUtil.change(bsnsRepayplan.getRepayinstamnt().doubleValue());//须还本金金额
			
			params.append("clntnm,"+clntnm);
			params.append(";urgename,"+urgename);
			params.append(";t_date_ty,"+t_date.substring(0,4).trim());
			params.append(";t_date_ty1,"+t_date.substring(0,4).trim());
			params.append(";t_date_tm,"+t_date.substring(4,6).trim());
			params.append(";t_date_tm1,"+t_date.substring(4,6).trim());
			params.append(";t_date_td,"+t_date.substring(6,8).trim());
			params.append(";t_date_td1,"+t_date.substring(6,8).trim());
			params.append(";t_date_sy,"+s_date.substring(0,4).trim());
			params.append(";t_date_sm,"+s_date.substring(5,7).trim()); 
			params.append(";t_date_sd,"+s_date.substring(8,10).trim());
			params.append(";t_date_ey,"+e_date.substring(0,4).trim());
			params.append(";t_date_em,"+e_date.substring(5,7).trim());
			params.append(";t_date_ed,"+e_date.substring(8,10).trim());
			params.append(";currepayamnt,"+currepayamnt);
			params.append(";repayinstamnt,"+repayinstamnt);
			params.append(";money,"+money);
			model.addAttribute("params", params.toString());
			model.addAttribute("filename", filename);
		}
		return "/mf/temp/word";
	}
	
}

