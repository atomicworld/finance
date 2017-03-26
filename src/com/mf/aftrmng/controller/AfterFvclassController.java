package com.mf.aftrmng.controller;

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

import com.mf.aftrmng.entity.AfterFvclass;
import com.mf.aftrmng.service.AfterFvclassService;
import com.mf.cntrtmng.entity.BsnsBill;
import com.mf.cntrtmng.entity.BsnsLnmain;
import com.mf.cntrtmng.service.BsnsBillService;
import com.mf.cntrtmng.service.BsnsLnmainService;
import com.mf.org.entity.Operator;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;
/**
 * @author chenenze
 * @2015-01-20
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/aftermng/afterfvclass/")
public class AfterFvclassController {
	
	@Autowired
	private AfterFvclassService afterFvclassService;
		
	@Autowired
	private BsnsBillService bsnsBillService;
	@Autowired
	private BsnsLnmainService bsnsLnmainService;
	/**
	 * 跳转到list展示页面
	 * @return
	 */
	@RequestMapping(value="list")
	public String list(){
		return "/mf/aftrmng/aftrfclass/list";
	}
	/**
	 * 跳转到新增界面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(){		
		return"/mf/aftrmng/aftrfclass/add";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param afterfvclass
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,AfterFvclass afterfvclass,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";;
		try {
			afterFvclassService.add(afterfvclass);
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
	 * @param afterfvclass
	 * @return
	 */
	@RequestMapping(value="addnull")
	public String addnull(Model model,HttpServletResponse response,HttpServletRequest request){	
		String result="";
		try {
			AfterFvclass afterfvclass = new AfterFvclass();
			afterFvclassService.addAll(afterfvclass);
			result="{\"id\":" + afterfvclass.getRcrdid() + ",\"message\":\"新增成功！\"}";
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
	 * @param afterfvclass
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="query")
	public String query(Model model,AfterFvclass afterfvclass,String pageNow, String pageSize){
		return "/mf/aftrmng/aftrfclass/list_list";
	}
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param afterfvclass
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,AfterFvclass afterfvclass,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = afterFvclassService.query(pageView, afterfvclass);
		List<AfterFvclass> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param afterfvclassId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			afterFvclassService.delete(ids);
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
	 * @param Id
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getByDue")
	public String getByDue(Model model,String Id,int typeKey,HttpServletRequest request){
		AfterFvclass afterfvclass = afterFvclassService.getByDue(Id,request);
		model.addAttribute("afterfvclass", afterfvclass);
		//获得操作员信息
		Operator user = (Operator)request.getSession().getAttribute("operator");
		model.addAttribute("user", user);	
		//显示借据信息表里的信息
		BsnsBill bsnsbill=bsnsBillService.findByDueno(Id);
		model.addAttribute("bsnsbill",bsnsbill);
		//显示合同里的信息
		BsnsLnmain bsnslnmain = bsnsLnmainService.findByBsnsno(Id);
		model.addAttribute("bsnslnmain", bsnslnmain);
		
		if(typeKey == 1){
			return "/mf/aftrmng/aftrfclass/edit";
		}else if(typeKey == 2){
			return "/mf/aftrmng/aftrfclass/view";
		}else{
			return "/mf/aftrmng/aftrfclass/view_1";
		}
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param afterfvclass
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateAfterFvclass(Model model,AfterFvclass afterfvclass,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";
		try {			
			afterfvclass.setClsstyp(afterfvclass.getManualrslt());
			afterFvclassService.modify(afterfvclass);
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
	 *  [] ids
	 * @return
	 */
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String[] ids, Model model, HttpServletResponse response) {
		String result = null;
		try {
			for (String id : ids) {
				afterFvclassService.delete(id);
			}
			result = "{\"status\":1,\"message\":\"删除成功！\"}";
		} catch (Exception e) {
			result="{\"status\":0,\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	/**
	 * 跳转到fvclass展示页面,如果五级分类数据字典有变动,返回的页面里也需要做相应的改动
	 * @return
	 */
	@RequestMapping(value="fvclass")
	public String fvclass(){
		return "/mf/aftrmng/aftrfclass/fvclass";
	}
	
}

