/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */


package com.mf.financemng.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.common.pub.PubConstants;
import com.mf.financemng.entity.*;
import com.mf.financemng.service.*;
import com.mf.sys.entity.CompanyInfo;
import com.mf.sys.service.impl.CompanyInfoServiceImpl;
import com.mf.sys.service.impl.MappingtoolServiceImpl;
import com.mf.util.*;

/**
 * @author wangyw
 * @2015-08-18
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/financemng/taxsub/")
public class FnncTaxsubController {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	@Autowired
	private FnncTaxsubService fnncTaxsubService;
	@Autowired
	CompanyInfoServiceImpl  companyInfoService;
	@Autowired
	private MappingtoolServiceImpl mappingtoolService;
	
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		return "/mf/financemng/taxsub/add";
	}
	/*
	 * 页面跳转
	 */
	@RequestMapping(value="list")
	public String list(HttpServletRequest request){
		String tmp = request.getSession().getAttribute("operator").toString();
		if(tmp.equals(PubConstants.SuperAdmin))
			return "/mf/financemng/taxsub/list1";
		return "/mf/financemng/taxsub/list";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param financebank
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(FnncTaxsub fnncTaxsub,HttpServletResponse response,HttpServletRequest request){
        
		String result="{\"msg\":\"suc\"}";
		try {
			CompanyInfo companyInfo=new CompanyInfo();
			companyInfo=companyInfoService.getCompanyInfo(companyInfo);
				Date date = new Date();
				java.sql.Date upd_date = new java.sql.Date(date.getTime());
				String id;
				SimpleDateFormat sf=new SimpleDateFormat("yyyyMMdd");
				 String s= sf.format(new java.sql.Date(date.getTime()));
				String ids = mappingtoolService.getSerialnumber(s, "AT");
				String opname = (String)request.getSession().getAttribute("opname");//得到 操作员
				fnncTaxsub.setPaytaxid(ids);
				fnncTaxsub.setUpdatedate(s);
				fnncTaxsub.setCreatedate(s);
				fnncTaxsub.setCreateby(opname);
				fnncTaxsub.setDeleteflag(0);
			fnncTaxsub.setOrgcode(companyInfo.getOrgcode());
			fnncTaxsub.setEleaveamount("0");
			fnncTaxsub.setEamount("0");
			fnncTaxsub.setBleaveamount("0");
			fnncTaxsubService.add(fnncTaxsub);
		} catch (Exception e) {
			result="{\"msg\":\"fail\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}

	/**
	 * post方式分页查询
	 * @param model
	 * @param fnnctaxsub
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,String search,FnncTaxsub fnnctaxsub,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		fnnctaxsub.setDeleteflag(0);
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = fnncTaxsubService.query(pageView,fnnctaxsub,search);
		List<FnncTaxsub> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param fnnctaxsubId
	 * @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String deleteById(Model model,String id, HttpServletResponse response){
		String result=null;
		try{
			fnncTaxsubService.deleteById(id);
			result = "{\"msg\":\"suc\"}";
		}catch(Exception e){
			result = "{\"msg\":\"fail\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	
	
	/**
	 * 查询&修改单条记录
	 * @param model
	 * @param fnnctaxsubId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String taxid){
		FnncTaxsub fnnctaxsub = fnncTaxsubService.getById(taxid);
		model.addAttribute("fnnctaxsub", fnnctaxsub);
		return "/mf/financemng/taxsub/edit";
		
	}
	@RequestMapping(value="view")
	public String getview(Model model,String taxid){
		FnncTaxsub fnnctaxsub = fnncTaxsubService.getById(taxid);
		model.addAttribute("fnnctaxsub", fnnctaxsub);
		return "/mf/financemng/taxsub/view";
		
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param fnnctaxsub
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateFnncTaxsub(Model model,FnncTaxsub fnnctaxsub,HttpServletResponse response,HttpServletRequest request){		
		String result="{\"msg\":\"suc\"}";;
		try {	
			Date date=new Date();
			SimpleDateFormat sf=new SimpleDateFormat("yyyyMMdd");
			String opname = (String)request.getSession().getAttribute("opname");//得到 操作员
			fnnctaxsub.setUpdateby(opname);
			fnnctaxsub.setUpdatedate(sf.format(date));
			fnncTaxsubService.modify(fnnctaxsub);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;		
		
	}
	
}

