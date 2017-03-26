package com.mf.sys.controller;

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

import com.mf.common.pub.PubConstants;
import com.mf.common.util.WaterIdGener;
import com.mf.sys.entity.CompanyChange;
import com.mf.sys.entity.CompanyInfo;
import com.mf.sys.service.CompanyChangeService;
import com.mf.sys.service.impl.CompanyInfoServiceImpl;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;


/**
 * @author hw
 * @2015-08-20
 */
@Controller
@RequestMapping(value="/mf/companychange/")
public class CompanyChangeController {
	
	@Autowired
	private CompanyChangeService companyChangeService;
	@Autowired
	private CompanyInfoServiceImpl companyInfoService;
	
	
	@RequestMapping(value="list")
	public String list(HttpServletRequest request){
		String tmp = request.getSession().getAttribute("operator").toString();
		if(tmp.equals(PubConstants.SuperAdmin))
			return "/mf/sys/company/change/list1";
		return "/mf/sys/company/change/list";
	}
	
	@RequestMapping(value="showlist")
	@ResponseBody
	public Map<String, Object> showlist(Model model, CompanyChange companyChange, HttpServletRequest request) {
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView =companyChangeService.query(pageView, companyChange);
		List<CompanyChange> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
		
	}
	
	@RequestMapping(value="addUI")
	public String addUI(){
		return "/mf/sys/company/change/add";
	}
	
	@RequestMapping(value="add")
	public String add(Model model, CompanyChange companyChange, HttpServletRequest request, HttpServletResponse response){
		String result="{\"msg\":\"suc\"}";
		try {
			//设置主键
			String logid = WaterIdGener.getWaterId();
			companyChange.setChangeno(logid);
			//这个公司编号
			CompanyInfo companyInfo=new CompanyInfo();
			companyInfo=companyInfoService.getCompanyInfo(companyInfo);
			companyChange.setCompanyno(companyInfo.getCmpno());
			System.out.println(companyChange);
			
			companyChangeService.add(companyChange);
			
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		 return null;
	}

	@RequestMapping(value="getById")
	private String getById(Model model, String changeno){
		CompanyChange companyChange = companyChangeService.getById(changeno);
		model.addAttribute("companyChange",companyChange);
		return "/mf/sys/company/change/edit";
	}
	
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			System.out.println(ids);
			companyChangeService.delete(ids);
		    result="{\"status\":1,\"message\":\"删除成功！\"}";
		}catch(Exception e){
			result="{\"status\":0,\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	@RequestMapping(value="update")
	public String update(Model model, CompanyChange companyChange, HttpServletRequest request, HttpServletResponse response){
		String result="{\"msg\":\"suc\"}";
		try {
			//找到主键
			companyChangeService.modify(companyChange);
			
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		 return null;
	}
	
}

