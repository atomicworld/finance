package com.mf.sys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.common.pub.PubConstants;
import com.mf.json.Entity;
import com.mf.sys.entity.SysDicType;
import com.mf.sys.entity.SysDictionary;
import com.mf.sys.service.SysDicTypeService;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;
import com.mf.common.pub.*;

@Controller
@RequestMapping(value = "/mf/devmng/sysDicType")
public class SysDicTypeController {
	
	@Autowired
	private SysDicTypeService sysDicTypeService;
	
	/**
	 * 跳转到list展示页面
	 * @return
	 */
	@RequestMapping(value="/list.html")
	public String list(){
		return "/mf/devmng/sysDicType/list";
	}

	/**
	 * 提供list展示界面的数据
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/query.html")
	@ResponseBody
	public Map<String, Object> getSysDicTypeList(Model model, SysDicType sysDicType, 
			HttpServletRequest request) {
		PageView pageView = null;
		String pageNow = request.getParameter("pager.pageNo");
		String pageSize = request.getParameter("pager.pageSize");
		if (Common.isEmpty(pageNow))
			pageView = new PageView(1);
		else {
			pageView = new PageView(Integer.parseInt(pageSize),
					Integer.parseInt(pageNow));
		}
		Map map = new HashMap();
		pageView = this.sysDicTypeService.query(pageView, sysDicType);
		List list = pageView.getRecords();
		map.put("rows", list);
		map.put("pager.pageNo", Integer.valueOf(pageView.getPageNow()));
		map.put("pager.totalRows", Long.valueOf(pageView.getRowCount()));
		return map;

	}
	/**
	 * 跳转到新增界面
	 * @return
	 */
	@RequestMapping(value="/addUI.html")
	public String addUI(){
		return "/mf/devmng/sysDicType/add";
	}
	
	/**
	 * 保存数据
	 * @param model
	 * @param sysDicType
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/add.html")
	@ResponseBody
	public String add(Model model, SysDicType sysDicType, HttpServletResponse response){
		String result = "{\"msg\":\"suc\"}";
		SysDicType sd = sysDicTypeService.findByCode(sysDicType.getCode());
		if(null != sd){
			result = "{\"msg\":\"fail\"}";
		}else{
			sysDicTypeService.add(sysDicType);
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	@RequestMapping(value="/findByCode.html")
	public String getById(Model model, String code, String pageType, HttpServletResponse response){
		SysDicType sysDicType = sysDicTypeService.findByCode(code);
		model.addAttribute("sysDicType", sysDicType);
		if(null != pageType){
			if(PubConstants.PAGE_TYPE_VIEW.equals(pageType)){
				return "/mf/devmng/sysDicType/info";
			}else{
				return "/mf/devmng/sysDicType/edit";
			}
		}else{
			return null;
		}
	}
	
	@RequestMapping(value = "/modify.html")
	public String modify(SysDicType sysDicType, HttpServletResponse response){
		String result = null;
		try {
			sysDicTypeService.modify(sysDicType);
			result = "{\"msg\":\"suc\"}";
		} catch (Exception e) {
			result = "{\"msg\":\"fail\"}";
		}
		WebTool.writeJson(result, response);
		return null;
	}
	//chenze--start
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/getSdBySdtCode.html")
	@ResponseBody
	public Map<String, List> getSdBySdtCode(){
		//新增时下拉选择框
		Entity entity;
		List<SysDicType> sysDicTypes = sysDicTypeService.findAll();
		List<Entity> list = new ArrayList<Entity>();
		Map<String,List> resMap = new HashMap<String,List>();
		for(SysDicType sd : sysDicTypes){
			entity = new Entity();
			entity.setKey(sd.getName());
			entity.setValue(sd.getCode());
			list.add(entity);
		}
		resMap.put("list", list);
		return resMap;
	}
	//chenze--end
}
