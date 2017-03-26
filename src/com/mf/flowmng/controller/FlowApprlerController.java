/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */


package com.mf.flowmng.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.flowmng.entity.FlowApplystep;
import com.mf.flowmng.entity.FlowApprler;
import com.mf.flowmng.service.FlowApplystepService;
import com.mf.flowmng.service.FlowApprlerService;
import com.mf.json.Entity;
import com.mf.org.entity.Dept;
import com.mf.org.entity.Operator;
import com.mf.org.service.DeptService;
import com.mf.org.service.impl.OperatorServiceImpl;
import com.mf.sys.entity.SysDictionary;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;


/**
 * @author yangchao
 * @2015-03-16
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/flowapprler/")
public class FlowApprlerController {
	
	
	@Autowired
	private FlowApprlerService flowApprlerService;

	@Autowired
	DeptService deptService;
	@Autowired
	private OperatorServiceImpl operatorService;
	@Autowired
	private FlowApplystepService flowApplystepService;
	
	

	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		return "/mf/flowmng/flowapprler/add";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param flowapprler
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,FlowApprler flowapprler,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\",\"info\":\" 保存成功！\"}";
		 String opno=flowapprler.getOpno();//获得操作员编号
		 int ishave=flowApprlerService.getByOpno(opno);
		 if(ishave>0){
			 result="{\"msg\":\"suc\",\"info\":\" 该用户已存在！\"}";
			 WebTool.writeJson(result, response);
			 return null;
		 }
		 System.out.println(flowapprler.getAppsteps()+"----------");
		 String appsteps = flowapprler.getAppsteps();
		 appsteps=appsteps.replaceAll(",","@");
		 System.out.println(appsteps);
		 flowapprler.setAppsteps(appsteps);
		 
		try {
			flowApprlerService.add(flowapprler);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	/**
	 * 跳转到列表页面
	 */
	@RequestMapping(value="query")
	public String query(Model model){
		return "/mf/flowmng/flowapprler/list";
	}
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param flowapprler
	 * @return map
	 */
	@RequestMapping(value="showlist")
    @ResponseBody
	public Map<String, Object> showlist(Model model,FlowApprler flowapprler,HttpServletRequest request){
		System.out.println("------------");
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		
		pageView = flowApprlerService.query(pageView, flowapprler);
		List<FlowApprler> list=pageView.getRecords();
		System.out.println("------------"+list.size());
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param flowapprlerId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			flowApprlerService.delete(ids);
		    result="{\"status\":1,\"message\":\"删除成功！\"}";
		}catch(Exception e){
			result="{\"status\":0,\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	
	/**
	 * 跳转到修改页面
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String id,int typeKey){
		FlowApprler flowapprler = flowApprlerService.getById1(id);
		String appsteps = flowapprler.getAppsteps();
		appsteps = appsteps.replaceAll("@", ",");
		flowapprler.setAppsteps(appsteps);
		model.addAttribute("flowapprler", flowapprler);
		
	   return "/mf/flowmng/flowapprler/edit";
		
	}
	/**
	 * 更新修改的信息
	 * @param model
	 * @param flowapprler
	 * @return
	 */
	@RequestMapping(value="edit",method=RequestMethod.POST)
	public String updateFlowApprler(Model model,FlowApprler flowapprler,HttpServletResponse response){		
		String result="{\"msg\":\"suc\",\"info\":\" 保存成功！\"}";;
		try {			
			String opno=flowapprler.getOpno();
			flowApprlerService.modify(flowapprler);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		 return null;		
		
	}
	
	

	

	
	/**
	 * 获取部门名称 下拉框
	 * @param code
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/getBmname")
	@ResponseBody
	public Map<String, List> getSdBySdtCode(HttpServletRequest request){
		//字典类型编码
		Entity entity;
	    List<Dept>	deptlist=  deptService.queryAll();
	    System.out.println("---"+request.getParameter("sdvalue"));
		//List<SysDictionary> sysDictionarys = sysDictionaryService.findSdBySdtCode(code);
		List<Entity> list = new ArrayList<Entity>();
		Map<String,List> resMap = new HashMap<String,List>();
		for(Dept st : deptlist){
			entity = new Entity();
			entity.setKey(st.getDptname());
			entity.setValue(st.getDptno());
			list.add(entity);
		}
		resMap.put("list", list);
		return resMap;
	}
	
	/**
	 * 获取部门下操作员 下拉框
	 * @param code
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/getCzyname")
	@ResponseBody
	public Map<String, List> getCzyBySdtCode(HttpServletRequest request){
		//字典类型编码
		Entity entity;
	    List<Operator>	deptlist=  operatorService.getByCzy(request.getParameter("sdvalue"));
	    System.out.println("---"+request.getParameter("sdvalue"));
		//List<SysDictionary> sysDictionarys = sysDictionaryService.findSdBySdtCode(code);
		List<Entity> list = new ArrayList<Entity>();
		Map<String,List> resMap = new HashMap<String,List>();
		for(Operator st : deptlist){
			entity = new Entity();
			entity.setKey(st.getOpnm()+"("+st.getVpnacct()+")");
			entity.setValue(st.getEmplyno());
			list.add(entity);
		}
		resMap.put("list", list);
		return resMap;
	}
	
	/**
	 * @param code
	 * @param sdvalue
	 * @param request
	 * @return
	 * 多选下拉框查询
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/getSpgw")
	@ResponseBody
	public String getSdBySdtCode(String code, HttpServletRequest request){
		//字典类型编码
		List<FlowApplystep>     list         = flowApplystepService.findAll();
		StringBuffer sb=new StringBuffer();
		for(FlowApplystep sd : list){
			sb.append("{");
			sb.append("\"id\":\""+sd.getApprlno()+"\",");
			sb.append("\"parentId\":\"0\",");
			sb.append("\"name\":\""+sd.getStepnm()+"\"");
			sb.append("},");
		}
		String result=sb.toString();
		System.out.println(result);
			   result=result.substring(0,result.length()-1);
			   result="{\"treeNodes\":["+result+"]}";
			   System.out.println(result);
		return result;
	}
	
}

