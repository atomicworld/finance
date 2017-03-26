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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.common.pub.PubConstants;
import com.mf.json.Entity;
import com.mf.sys.entity.SysDicType;
import com.mf.sys.entity.SysDictionary;
import com.mf.sys.service.SysDictionaryService;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;

@Controller
@RequestMapping(value = "/mf/devmng/sysDictionary")
public class SysDictionaryController {

	@Autowired
	private SysDictionaryService sysDictionaryService;
	
	/**
	 * 跳转到list展示页面
	 * @return
	 */
	@RequestMapping(value="/list.html")
	public String list(){
		return "/mf/devmng/sysDictionary/list";
	}
	@RequestMapping(value = "/getPageList.html")
	@ResponseBody
	public Map<String, Object> getSysDicTypeList(Model model, SysDictionary sysDictionary, 
			HttpServletRequest request) {
		PageView pageView = null;
		String pageNow = request.getParameter("pager.pageNo");
		System.out.println("pageNow:" + pageNow);
		String pageSize = request.getParameter("pager.pageSize");
		if (Common.isEmpty(pageNow))
			pageView = new PageView(1);
		else {
			pageView = new PageView(Integer.parseInt(pageSize),
					Integer.parseInt(pageNow));
		}
		Map map = new HashMap();
		pageView = this.sysDictionaryService.query(pageView, sysDictionary);
		List list = pageView.getRecords();
		map.put("rows", list);
		map.put("pager.pageNo", Integer.valueOf(pageView.getPageNow()));
		map.put("pager.totalRows", Long.valueOf(pageView.getRowCount()));
		return map;
	}
	
	/**
	 * 数据字典单选下拉框
	 * @param code
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/getSdBySdtCode")
	@ResponseBody
	public Map<String, List> getSdBySdtCode(String code, HttpServletRequest request){
		//字典类型编码
		code = request.getParameter("code");
		Entity entity;
		List<SysDictionary> sysDictionarys = sysDictionaryService.findSdBySdtCode(code);
		List<Entity> list = new ArrayList<Entity>();
		Map<String,List> resMap = new HashMap<String,List>();
		for(SysDictionary sd : sysDictionarys){
			entity = new Entity();
			entity.setKey(sd.getSdkey());
			entity.setValue(sd.getSdvalue());
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
	 * 多条件查询
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/getSdBySdtCode1")
	@ResponseBody
	public Map<String, List> getSdBySdtCode1(String code,String sdvalue, HttpServletRequest request){
		//字典类型编码
		code = request.getParameter("code");
		sdvalue =request.getParameter("sdvalue").substring(5, 6);
		SysDictionary newDic=new SysDictionary();
		newDic.setCode(code);
		newDic.setSdvalue(sdvalue);
		Entity entity;
		List<SysDictionary> sysDictionarys = sysDictionaryService.findSdBySdtCode2(newDic);
		List<Entity> list = new ArrayList<Entity>();
		Map<String,List> resMap = new HashMap<String,List>();
		for(SysDictionary sd : sysDictionarys){
			entity = new Entity();
			entity.setKey(sd.getSdkey());
			entity.setValue(sd.getSdvalue());
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
	@RequestMapping(value="/getSdBySdtCode2")
	@ResponseBody
	public String getSdBySdtCode2(String code, HttpServletRequest request){
		//字典类型编码
		code = request.getParameter("code");
		String stat =request.getParameter("stat");
		
		List<SysDictionary> sysDictionarys = sysDictionaryService.findSdBySdtCode(code);
		StringBuffer sb=new StringBuffer();
		for(SysDictionary sd : sysDictionarys){
			sb.append("{");
			sb.append("\"id\":\""+sd.getId()+"\",");
			sb.append("\"parentId\":\"0\",");
			sb.append("\"name\":\""+sd.getSdkey()+"\"");
			sb.append("},");
		}
		String result=sb.toString();
			   result=result.substring(0,result.length()-1);
			   result="{\"treeNodes\":["+result+"]}";
		return result;
	}
	
	@RequestMapping(value="/findKeyByValue",method=RequestMethod.POST)
	public String findKeyByValue(SysDictionary sysDictionary, HttpServletResponse response){
		String result=null;
		List<SysDictionary> sysDictionaryList = sysDictionaryService.findKeyByCodeAndValue(sysDictionary);
		if(null == sysDictionaryList){
			result = "{\"msg\":\"不存在的空值\"}";
		}else if(sysDictionaryList.size() == 0){
			result = "{\"msg\":\"不存在的空值\"}";
		}else if(sysDictionaryList.size() > 1){
			result = "{\"msg\":\"异常，存在多个值\"}";
		}else{
			sysDictionary = sysDictionaryList.get(0);
			String sdkey = sysDictionary.getSdkey();
			result = "{\"sdkey\":\""+ sdkey + "\"}";
		}
		WebTool.writeJson(result, response);
		return null;
	}
	//chenenze - start
		/**
		 * 提供list展示界面的数据
		 * @param model
		 * @param request
		 * @return
		 */
		@RequestMapping(value = "/query.html")
		@ResponseBody
		public Map<String, Object> getSysDictionary(Model model, SysDictionary sysDictionary, 
				HttpServletRequest request) {
			PageView pageView = null;
			String pageNow = request.getParameter("pager.pageNo");
			System.out.println("pageNow:" + pageNow);
			String pageSize = request.getParameter("pager.pageSize");
			if (Common.isEmpty(pageNow))
				pageView = new PageView(1);
			else {
				pageView = new PageView(Integer.parseInt(pageSize),
						Integer.parseInt(pageNow));
			}
			Map map = new HashMap();
			pageView = this.sysDictionaryService.query(pageView, sysDictionary);
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
		return "/mf/devmng/sysDictionary/add";
	}
	
	/**
	 * 保存数据
	 * @param model
	 * @param sysDictionary
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/add.html")
	@ResponseBody
	public String add(Model model, SysDictionary sysDictionary, HttpServletResponse response){
		String result = "{\"msg\":\"suc\"}";
		//判断字典编号和findByCodeAndValue里的key和value是否同时存在
		String code=sysDictionary.getCode();
		String sdvalue=sysDictionary.getSdvalue();
		System.out.println(code + " " + sdvalue);
		SysDictionary sv=sysDictionaryService.findByCodeAndValue(sysDictionary);
		System.out.println("sv:"+sv);
		if(null != sv){
			System.out.println("--------------");
			result = "{\"msg\":\"fail\"}";
		}else{
			sysDictionaryService.add(sysDictionary);
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	@RequestMapping(value="/findByCode.html")
	public String getById(Model model, String id, String pageType, HttpServletResponse response){
		SysDictionary sysDictionary = sysDictionaryService.findByCode(id);
		model.addAttribute("sysDictionary", sysDictionary);
		if(null != pageType){
			if(PubConstants.PAGE_TYPE_VIEW.equals(pageType)){
				return "/mf/devmng/sysDictionary/info";
			}else{
				return "/mf/devmng/sysDictionary/edit";
			}
		}else{
			return null;
		}
	}
	@RequestMapping(value="/prefix.html")
	public String prefix(Model model, String id, String pageType, HttpServletResponse response){
		  SysDictionary sysDictionary = sysDictionaryService.findByCode("8000");
		   model.addAttribute("prefix", sysDictionary);
		   return "/mf/sys/prefix/edit";
	}
	@RequestMapping(value = "/modify.html")
	public String modify(SysDictionary sysDictionary, HttpServletResponse response){
		String result = null;
		try {
			sysDictionaryService.modify(sysDictionary);
			result = "{\"msg\":\"suc\"}";
		} catch (Exception e) {
			result = "{\"msg\":\"fail\"}";
		}
		WebTool.writeJson(result, response);
		return null;
	}
	//chenenze - end


}
