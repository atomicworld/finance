/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */


package com.mf.client.controller;

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

import com.mf.client.entity.Fixedassets;
import com.mf.client.service.FnncProService;
import com.mf.common.pub.PubConstants;
import com.mf.sys.entity.CompanyInfo;
import com.mf.sys.service.impl.CompanyInfoServiceImpl;
import com.mf.sys.service.impl.MappingtoolServiceImpl;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;
/**
 * @author wangyw
 * @2015-08-19
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/clnfnncpro/")
public class FnncProController {
	@Autowired
	private FnncProService fnncProService;
	@Autowired
	private MappingtoolServiceImpl mappingtoolService;
	@Autowired
	CompanyInfoServiceImpl  companyInfoService;
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		return "/mf/clientmng/clnfnnc/add";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param fnncpro
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,Fixedassets fnncpro,HttpServletResponse response,HttpServletRequest request){
		
		String result="{\"msg\":\"suc\"}";;
		try {
			//取orgcode
			CompanyInfo companyInfo=new CompanyInfo();
			companyInfo=companyInfoService.getCompanyInfo(companyInfo);
			//生成主键
			SimpleDateFormat sf=new SimpleDateFormat("yyyyMMdd");
			Date date = new Date();
			String value=sf.format(date);
			//java.sql.Date upd_date = new java.sql.Date(date.getTime());
			String key_name = "BB";//前缀监管
			String id = mappingtoolService.getSerialnumber(sf.format(date), key_name);
			fnncpro.setFixassetid(id);
			fnncpro.setDeleteflag(0);
			String opname = (String)request.getSession().getAttribute("opname");
			fnncpro.setCreateby(opname);
			fnncpro.setCreatedate(value);
			fnncpro.setOrgcode(companyInfo.getOrgcode());
			fnncpro.setUpdatedate(value);
			fnncpro.setRptdate(value);
			fnncProService.add(fnncpro);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	/**
	 * 保存新增--for 即时编辑
	 * @param model
	 * @param fnncpro
	 * @return
	 */
	@RequestMapping(value="addnull")
	public String addnull(Model model,HttpServletResponse response,HttpServletRequest request){
		String result="";
		try {
			Fixedassets fnncpro = new Fixedassets();
			fnncProService.addAll(fnncpro);
			result="{\"id\":" + fnncpro.getFixassetid() + ",\"message\":\"新增成功！\"}";
		} catch (Exception e) {
			result="{\"id\":\"0\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	/**
	 * 分页查询跳转
	 * @param model
	 * @param fnncpro
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="query")
	public Map<String, Object> getSysMenuList(Model model,Fixedassets sysMenu,
			HttpServletRequest request){
		PageView pageView=null;
		String pageNow =request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if (Common.isEmpty(pageNow))
			pageView=new PageView(1);
		else{
			pageView=new PageView(Integer.parseInt(pageSize),
					Integer.parseInt(pageNow));
		}
		if (Common.isEmpty(pageNow))
			pageView = new PageView(1);
		else {
			pageView = new PageView(Integer.parseInt(pageSize),
					Integer.parseInt(pageNow));
		}
		Map map = new HashMap();
		pageView = this.fnncProService.query(pageView, sysMenu);
		List list = pageView.getRecords();
		map.put("rows", list);
		map.put("pager.pageNo", Integer.valueOf(pageView.getPageNow()));
		map.put("pager.totalRows", Long.valueOf(pageView.getRowCount()));
		return map;
	}
	
	@RequestMapping(value="list")
	public String list(HttpServletRequest request){
		String tmp = request.getSession().getAttribute("operator").toString();
		if(tmp.equals(PubConstants.SuperAdmin))
			return "/mf/clientmng/clnfnnc/list1";
		return "/mf/clientmng/clnfnnc/list";
	}
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param fnncpro
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,Fixedassets fnncpro,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = fnncProService.query(pageView, fnncpro);
		List<Fixedassets> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param fnncproId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String proid, HttpServletResponse response){
		String result=null;
		try{
			fnncProService.delete(proid);
		    result="{\"status\":1,\"message\":\"删除成功！\"}";
		}catch(Exception e){
			result="{\"status\":0,\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	/**
	 * 查询&修改单条记录
	 * @param model
	 * @param fnncproId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String proid,String type){
		Fixedassets fnncpro = fnncProService.getById(proid);
		model.addAttribute("fnncpro", fnncpro);
	if(type.equals("1")){
		return "/mf/clientmng/clnfnnc/view";
		}else{
			return "/mf/clientmng/clnfnnc/edit";
		}
	}
	/**
	 * 更新修改的信息
	 * @param model
	 * @param fnncpro
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateFnncPro(Model model,Fixedassets fnncpro,HttpServletResponse response,HttpServletRequest request){		
		String result="{\"msg\":\"suc\"}";;
		try {	
			Date date= new Date();
			SimpleDateFormat sf=new SimpleDateFormat("yyyyMMdd");
			String opname = (String)request.getSession().getAttribute("opname");
			fnncpro.setUpdateby(opname);
			fnncpro.setUpdatedate(sf.format(date));
			fnncProService.modify(fnncpro);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;		
		
	}
	
	
	/**
	 * 批量删除数据
	 * 
	 * @param model
	 * @param String
	 *            [] ids
	 * @return
	 */
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String[] ids, Model model, HttpServletResponse response) {
		String result = null;
		try {
			for (String id : ids) {
				fnncProService.delete(id);
			}
			result = "{\"status\":1,\"message\":\"删除成功！\"}";
		} catch (Exception e) {
			result="{\"status\":0,\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	
}

