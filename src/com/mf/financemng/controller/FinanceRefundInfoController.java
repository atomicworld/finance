/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */


package com.mf.financemng.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xhs.poi.util.ExcelUtil;
import com.mf.financemng.entity.FinanceCondition;
import com.mf.financemng.entity.FinanceRefundInfo;
import com.mf.financemng.service.FinanceConditionService;
import com.mf.financemng.service.FinanceRefundInfoService;
import com.mf.flowmng.entity.FlowIncreaseCapital;
import com.mf.sys.entity.CompanyInfo;
import com.mf.sys.service.impl.CompanyInfoServiceImpl;
import com.mf.sys.service.impl.MappingtoolServiceImpl;
import com.mf.util.*;
/**
 * @author wangzhi
 * @2015-08-14
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/financerefundinfo/")
public class FinanceRefundInfoController {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	@Autowired
	private FinanceConditionService financeConditionService;
	@Autowired
	private FinanceRefundInfoService financeRefundInfoService;
	@Autowired
	CompanyInfoServiceImpl  companyInfoService;
	@Autowired
	private MappingtoolServiceImpl mappingtoolService;
	/**
	 * 提供list展示界面的数据
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "query")
	@ResponseBody
	public Map<String, Object> showList(Model model,FinanceRefundInfo financeRefundInfo, HttpServletRequest request) {
		PageView pageView = null;
		String pageNow = request.getParameter("pager.pageNo");
		String pageSize = request.getParameter("pager.pageSize");
		if (Common.isEmpty(pageNow))
			pageView = new PageView(1);
		else {
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map map = new HashMap();
		pageView = financeRefundInfoService.query(pageView,financeRefundInfo);
		List list = pageView.getRecords();
		map.put("rows", list);
		map.put("pager.pageNo", Integer.valueOf(pageView.getPageNow()));
		map.put("pager.totalRows", Long.valueOf(pageView.getRowCount()));
		return map;
	}
	/**
	 * 跳转到融资还款明细添加
	 * @return
	 */
	@RequestMapping(value = "addUI")
	public String addUI(String loanno,String loanbalance,String sumamount,String bankno,Model model,HttpServletRequest request) {
		model.addAttribute("loanno",loanno);
		model.addAttribute("sumamount",sumamount);
		model.addAttribute("loanbalance",loanbalance);
		String bankseril=bankno;
		try {
		bankseril=new String(request.getParameter("bankno").getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("bankno",bankseril);
		return "/mf/financemng/fnnrefundinfo/add";
	}
	
	@RequestMapping(value="add")
	@ResponseBody
	public String add(FinanceRefundInfo financeRefundInfo,String loanbalance,String sumamount, HttpServletResponse response, HttpServletRequest request){
		String result = "{\"msg\":\"suc\"}";
		try {
			//id   orgcode  
			Date date = new Date();
			java.sql.Date upd_date = new java.sql.Date(date.getTime());
			SimpleDateFormat sf=new SimpleDateFormat("yyyyMMdd");
			 String s= sf.format(new java.sql.Date(date.getTime()));
			String id = mappingtoolService.getSerialnumber(s, "AR");
			String opname = (String)request.getSession().getAttribute("opname");
			CompanyInfo companyInfo=new CompanyInfo();
			companyInfo=companyInfoService.getCompanyInfo(companyInfo);
			financeRefundInfo.setOrgcode(companyInfo.getOrgcode());
			financeRefundInfo.setReturnloanmoneyid(id);
			
			//update loanmoney table  sumreturn coloun  by loanmoneyid 
			// loanbalance==no return money; sumamount==all loanmoney
			//当还款日期大于 loandate 时不执行插入  
			String ids=financeRefundInfo.getLoanmoneyid();
			String loandate=financeConditionService.getById(ids).getLoandate();
			 int flag=loandate.compareTo(financeRefundInfo.getReturndate());
			if(flag>=0){
				result = "{\"msg\":\"errordate\"}";
				System.out.println(sf.parse(loandate).getTime()+"----"+sf.parse(financeRefundInfo.getReturndate()).getTime());
			}else{
			FinanceCondition financeCondition=new FinanceCondition();
			float ff=Float.valueOf(loanbalance)-Float.valueOf(financeRefundInfo.getReturnamount());
			float f=Float.valueOf(sumamount)-ff;
			if(ff>=0){
			financeCondition.setLoanbalance(ff+"");
			financeCondition.setSumreturn(f+"");
			financeCondition.setLoanmoneyid(ids);
			financeCondition.setUpdateby(opname);
			financeCondition.setUpdatedate(s);
			financeConditionService.modify(financeCondition);
			financeRefundInfoService.add(financeRefundInfo);
			}else{
				result = "{\"msg\":\"error\"}";
			}
			}
			} catch (Exception e) {
				result = "{\"msg\":\"fail\"}";
			}
		WebTool.writeJson(result, response);
		return null;
	}
	
	@RequestMapping(value = "view")
	public String view(String id, HttpServletRequest request, Model model) {
		FinanceRefundInfo financeRefundInfo = financeRefundInfoService.getById(id);
		model.addAttribute("financeRefundInfo", financeRefundInfo);
		return "/mf/financemng/fnnrefundinfo/view";
	}
	
	@RequestMapping(value = "editUI")
	public String editUI(String id,Model model) {
		FinanceRefundInfo financeRefundInfo = financeRefundInfoService.getById(id);
		model.addAttribute("financeRefundInfo",financeRefundInfo);
		return "/mf/financemng/fnnrefundinfo/edit";
	}
	
	@RequestMapping(value="edit")
	@ResponseBody
	public String edit(FinanceRefundInfo financeRefundInfo,String reutrnamount1,HttpServletResponse response, HttpServletRequest request){
		String result = "{\"msg\":\"suc\"}";
		try {
			String parentId=financeRefundInfo.getLoanmoneyid();
			FinanceCondition financeCondition = financeConditionService.getById(parentId);
			//financeCondition.getSumamount();//all amount
			//financeCondition.getSumreturn();//all rerutn money
			//financeRefundInfo.getReturnamount();//getedie now  // get older  reutrnamount1
			float nowreturn=Float.valueOf(financeCondition.getSumreturn())-Float.valueOf(reutrnamount1)-Float.valueOf(financeRefundInfo.getReturnamount());
			float nowremain=Float.valueOf(financeCondition.getSumamount())-nowreturn;
			//判断修改后余额是否正确
			if(nowremain>=0){
			financeCondition.setSumreturn(nowreturn+"");
			financeCondition.setLoanbalance(nowremain+"");
			//EDIT 还款 也要修改贷款 表剩余  和已还款
				financeRefundInfoService.modify(financeRefundInfo);
				financeConditionService.modify(financeCondition);
			}else{
				result = "{\"msg\":\"error\"}";
			}
			} catch (Exception e) {
				result = "{\"msg\":\"fail\"}";
			}
		WebTool.writeJson(result, response);
		return null;
	}
	
	@RequestMapping(value="delete")
	@ResponseBody
	public String delete(String id,String ids, HttpServletResponse response, HttpServletRequest request){
		String result = "{\"msg\":\"suc\"}";
		try {
			//get child id
			FinanceRefundInfo child = financeRefundInfoService.getById(id);
			//get father id
			FinanceCondition father=new FinanceCondition();
			father=financeConditionService.getById(ids);
			float ch=Float.valueOf(child.getReturnamount());
			float faleave=Float.valueOf(father.getLoanbalance());
			float fasum=Float.valueOf(father.getSumreturn());
			float ff=ch+faleave;
			float f=fasum-ch;
			Date date = new Date();
			SimpleDateFormat sf=new SimpleDateFormat("yyyyMMdd");
			String opname = (String)request.getSession().getAttribute("opname");
			father.setLoanbalance(ff+"");
			father.setSumreturn(f+"");
			father.setLoanmoneyid(ids);
			father.setUpdateby(opname);
			father.setUpdatedate(sf.format(date));
			financeConditionService.modify(father);
			
				financeRefundInfoService.delete(id);
			} catch (Exception e) {
				result = "{\"msg\":\"fail\"}";
			}
		WebTool.writeJson(result, response);
		return null;
	}
}

