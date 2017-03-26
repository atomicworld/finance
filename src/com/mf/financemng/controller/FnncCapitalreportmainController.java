package com.mf.financemng.controller;

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

import com.mf.common.util.StringUtil;
import com.mf.common.util.WaterIdGener;
import com.mf.financemng.entity.FnncCapitalreportmain;
import com.mf.financemng.service.FnncCapitalreportmainService;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;
/**
 * @author chenenze
 * @2015-02-14
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/financemng/capitalreportmain/")
public class FnncCapitalreportmainController {
	
	@Autowired
	private FnncCapitalreportmainService fnncCapitalreportmainService;
	
	
	
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addMa")
	public String addUI(Model model,FnncCapitalreportmain fnnccapitalreportmain){
		
		String docno = WaterIdGener.getWaterId();		
		fnnccapitalreportmain.setDocno(docno);
		
		String nowDt = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
		//报告名称"验资报告"+"_"+nowDt+"_"+顺序号；暂时用流水号代替
		String docnm ="验资报告"+"_"+docno;
		fnnccapitalreportmain.setDocnm(docnm);
		model.addAttribute( "fnnccapitalreportmain",fnnccapitalreportmain);
		
		return "/mf/financemng/capitalreport/addmain";
	}
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		
		
		
		return "/mf/financemng/capitalreport/add";
	}
	/**
	 * 保存新增
	 * @param model
	 * @param fnnccapitalreportmain
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,FnncCapitalreportmain fnnccapitalreportmain,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";;
		try {
			fnncCapitalreportmainService.add(fnnccapitalreportmain);
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
	 * @param fnnccapitalreportmain
	 * @return
	 */
	@RequestMapping(value="addnull")
	public String addnull(Model model,HttpServletResponse response,HttpServletRequest request){
		String result="";
		try {
			FnncCapitalreportmain fnnccapitalreportmain = new FnncCapitalreportmain();
			fnncCapitalreportmainService.addAll(fnnccapitalreportmain);
			result="{\"id\":" + fnnccapitalreportmain.getDocno() + ",\"message\":\"新增成功！\"}";
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
	 * @param fnnccapitalreportmain
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="query")
	public String query(Model model,FnncCapitalreportmain fnnccapitalreportmain,String pageNow, String pageSize){
		return "/mf/financemng/fnnccapitalreportmain/list_list";
	}
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param fnnccapitalreportmain
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,FnncCapitalreportmain fnnccapitalreportmain,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = fnncCapitalreportmainService.query(pageView, fnnccapitalreportmain);
		List<FnncCapitalreportmain> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param fnnccapitalreportmainId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			fnncCapitalreportmainService.delete(ids);
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
	 * @param fnnccapitalreportmainId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String id,int typeKey){
		FnncCapitalreportmain fnnccapitalreportmain = fnncCapitalreportmainService.getById(id);
		model.addAttribute("fnnccapitalreportmain", fnnccapitalreportmain);
		if(typeKey == 1){
			return "/mf/financemng/capitalreport/editmain";
		}else if(typeKey == 2){
			return "/mf/financemng/capitalreport/viewmain";
		}else{
			return "/mf/financemng/fnnccapitalreportmain/view_1";
		}
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param fnnccapitalreportmain
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateFnncCapitalreportmain(Model model,FnncCapitalreportmain fnnccapitalreportmain,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";;
		try {			
			fnncCapitalreportmainService.modify(fnnccapitalreportmain);
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
				fnncCapitalreportmainService.delete(id);
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

