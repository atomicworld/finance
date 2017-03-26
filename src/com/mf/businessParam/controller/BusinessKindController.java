package com.mf.businessParam.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.businessParam.entity.BaseRate;
import com.mf.businessParam.entity.BusinessKind;
import com.mf.businessParam.service.impl.BusinessKindServiceImpl;
import com.mf.json.Entity;
import com.mf.sys.entity.SysDictionary;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;

@Controller
@RequestMapping(value = "/mf/businessParam/businessKind")
public class BusinessKindController {

	private static final Logger logger = Logger
			.getLogger(BusinessKindController.class);

	@Autowired
	BusinessKindServiceImpl businessKindService;


	@RequestMapping(value = "/toBusinessKindList.html")
	public String list() {
		return "/mf/businessParam/businessKind/businessKind_list";
	}

	@RequestMapping(value = "/getBusinessKindPagerList.html")
	@ResponseBody
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String, Object> getBusinessKindPagerList(Model model, BusinessKind BusinessKind,
			HttpServletRequest request) {

		PageView pageView = null;
		String pageNow = request.getParameter("pager.pageNo");
		String pageSize = request.getParameter("pager.pageSize");
		if (Common.isEmpty(pageNow))
			pageView = new PageView(1);
		else {
			pageView = new PageView(Integer.parseInt(pageSize), Integer.parseInt(pageNow));
		}

		pageView = businessKindService.query(pageView, BusinessKind);
		List list = pageView.getRecords();

		Map resultMap = new HashMap();
 		resultMap.put("rows", list);
		resultMap.put("pager.pageNo", pageView.getPageNow());
		resultMap.put("pager.totalRows", pageView.getRowCount());
		return resultMap;
	}
	

	@RequestMapping(value = "/toBusinessKindAdd.html")
	public String toAddBusinessKind() {
		return "/mf/businessParam/businessKind/businessKind_add";
	}

//	// 绑定参数
//	@InitBinder("BusinessKind")
//	public void initBinderBusinessKind(WebDataBinder binder) {
//		binder.setFieldDefaultPrefix("businessKind.");
//	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/addBusinessKind.html")
	@ResponseBody
	public Map<String, Object> addBusinessKind(BusinessKind businessKind) {
		
		businessKindService.add(businessKind);
		Map resltMap = new HashMap();
		resltMap.put("resCode", 1);
		resltMap.put("resDesc", "保存成功！");
		return resltMap;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/delBusinessKind.html")
	@ResponseBody
	public Map<String, Object> delBusinessKind(HttpServletRequest request) {
		String id = request.getParameter("id");
		Map resultMap = new HashMap();
		try {
			businessKindService.delete(id);
			resultMap.put("resCode", "1");
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("resCode", "-1");
			resultMap.put("resDesc", e.getMessage());
		}

		return resultMap;
	}

	@RequestMapping(value = "/toEditBusinessKind.html")
	public String toEditBusinessKind(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		BusinessKind  businessKind=businessKindService.getById(id);
		model.addAttribute("businessKind", businessKind);
	   return "/mf/businessParam/businessKind/businessKind_add";
	}

	@RequestMapping(value = "/editBusinessKind.html")
	@ResponseBody
	public Map<String, Object> editBusinessKind(BusinessKind businessKind) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			businessKindService.modify(businessKind);
			resultMap.put("resCode", "1");
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("resCode", "-1");
			resultMap.put("resDesc", e.getMessage());
		}
		return resultMap;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/changeStatus.html")
	@ResponseBody
	public Map<String, Object> changeStatus(HttpServletRequest request) {
		String id = request.getParameter("id");
		String status=request.getParameter("status");
		Map resultMap = new HashMap();
		try {
			businessKindService.changeStatus(id,status);
			resultMap.put("resCode", "1");
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("resCode", "-1");
			resultMap.put("resDesc", e.getMessage());
		}

		return resultMap;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/getType")
	@ResponseBody
	public Map<String, List> getType(String code, HttpServletRequest request){
		//字典类型编码
		String cstmrtyp = request.getParameter("code");
		Entity entity;
		List<BusinessKind> businesskind;
		if(cstmrtyp!=null){
			businesskind= businessKindService.getType(cstmrtyp);
		}else{
			businesskind= businessKindService.getTypeAll(cstmrtyp);
		}
		
		List<Entity> list = new ArrayList<Entity>();
		Map<String,List> resMap = new HashMap<String,List>();
		for(BusinessKind sd : businesskind){
			entity = new Entity();
			entity.setKey(sd.getKndnm());
			entity.setValue(sd.getKndno());
			list.add(entity);
		}
		resMap.put("list", list);
		return resMap;
	}
	
	//add by hw 申请贷款的时候，需要判断该业务是否可以执行
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/getAbleType")
	@ResponseBody
	public Map<String, List> getAbleType(String code, HttpServletRequest request){
		//字典类型编码
		String cstmrtyp = request.getParameter("code");
		Entity entity;
		List<BusinessKind> businesskind = new ArrayList<BusinessKind>();
		if(cstmrtyp!=null){
			businesskind= businessKindService.getAbleType(cstmrtyp);
		}
		List<Entity> list = new ArrayList<Entity>();
		Map<String,List> resMap = new HashMap<String,List>();
		if(businesskind.size()>0){
			for(BusinessKind sd : businesskind){
				entity = new Entity();
				entity.setKey(sd.getKndnm());
				entity.setValue(sd.getKndno());
				list.add(entity);
			}
		}
		resMap.put("list", list);
		return resMap;
	}
	
	 /**
	    * 跟据期限种类获取基准利率
	    */
	   @RequestMapping(value="getLv")
		public String getLv(Model model,HttpServletResponse response,HttpServletRequest request){
		   String kndno = request.getParameter("kndno");
		   String result ="{\"status\":true,\"message\":\"删除成功！\",\"min\":\"\",\"max\":\"\"}";
		   String min="";
		   String max="";
		   try {
			    BusinessKind businessKind = businessKindService.getById(kndno);
			    min = businessKind.getMinamnt().toString();
			    max = businessKind.getMaxamnt().toString();
			    result ="{\"status\":true,\"message\":\"删除成功！\",\"min\":\""+min+"\",\"max\":\""+max+"\"}";
		 } catch (Exception e) {
			 result ="{\"status\":false,\"message\":\"删除成功！\",\"min\":\"\",\"max\":\"\"}";
		 }
		   WebTool.writeJson(result, response);
		   return null;
	   }   

}
