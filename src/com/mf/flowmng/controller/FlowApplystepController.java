package com.mf.flowmng.controller;

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



import com.mf.flowmng.entity.FlowApplystep;
import com.mf.flowmng.entity.FlowApprlBase;
import com.mf.flowmng.service.FlowApplystepService;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;

@Controller
@RequestMapping(value="/mf/flowApplystep")
public class FlowApplystepController {
	@Autowired
	private  FlowApplystepService  flowApplystepService; 
	
	@RequestMapping(value="list")
	public String getList(Model model){
		return "/mf/flowmng/list";
	}
	
	
	/**
	 * post方式分页查询 
	 * @param model
	 * @param combo
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,FlowApplystep flowApplystep,HttpServletRequest request){
		//User u = (User)request.getSession().getAttribute("userSession");
	    PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = flowApplystepService.query(pageView, flowApplystep);
		List<FlowApplystep> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
    /**
     * 跳转到新增页面
     */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		
		return "/mf/flowmng/flowStepAdd";
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value="add")
	public String add(Model model,FlowApplystep flowApplyStep,HttpServletResponse response,HttpServletRequest request){
		   String result="{\"msg\":\"suc\"}";
		  /**
		   * 算stepxy
		   */
		   int y =0;
		   FlowApplystep flowApplystep1 = flowApplystepService.getMax();
		   if(flowApplystep1!=null){
			   String stepXy = flowApplystep1 .getStepxy();
			   String[] stepXys = stepXy.split(":");
			   y =Integer.parseInt(stepXys[1])+60;
		   }
		   String stepXy = "121"+":"+y+":"+"90"+":"+"35";
		   
		   System.out.println("----------"+stepXy);
		   flowApplyStep.setApprltyp("0");
		   flowApplyStep.setSteplvl("0");
		   flowApplyStep.setStepxy(stepXy);
		   flowApplystepService.add(flowApplyStep);
		   WebTool.writeJson(result, response);
		   return null;
	}
	/**
	 * 跳转到修改页面
	 */
	
	@RequestMapping(value="modifyUI")
	public String modifyUI(Model model,HttpServletRequest request){
		String apprlno = request.getParameter("apprlno");
		FlowApplystep flowApplystep = flowApplystepService.getByapprlno(apprlno);
		System.out.println("---------"+flowApplystep.getStepflg());
	
		model.addAttribute("flowApplystep", flowApplystep);
	
		return "/mf/flowmng/flowStepEdit";
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value="modify")
	public String modify(Model model,FlowApplystep flowApplyStep,HttpServletResponse response,HttpServletRequest request){
		   String result="{\"msg\":\"suc\"}";
		
		   flowApplystepService.modify(flowApplyStep);
		   WebTool.writeJson(result, response);
		   return null;
	}
	/**
	 * 通过流程标号获取流程步骤名称
	 */
    @RequestMapping(value="getStepNm")
    public String getStepNm(Model model ,HttpServletResponse response,HttpServletRequest request){
    	String curstep = request.getParameter("curstep");
    	System.out.println(curstep+"////////////////");
    	FlowApplystep flowApplystep = flowApplystepService.getByapprlno(curstep);
    	String result = "{\"status\":true,\"message\":\""+flowApplystep.getStepnm()+"\"}";
    	 WebTool.writeJson(result, response);
    	return null;
    }
    
    /**
	 * 批量删除数据
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
					flowApplystepService.delete(id);
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
