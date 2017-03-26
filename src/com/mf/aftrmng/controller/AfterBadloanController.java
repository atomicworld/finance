/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */


package com.mf.aftrmng.controller;

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

import com.ibm.icu.text.SimpleDateFormat;
import com.mf.aftrmng.entity.AfterBadloan;
import com.mf.aftrmng.entity.AfterFvclass;
import com.mf.aftrmng.service.AfterBadloanService;
import com.mf.aftrmng.service.AfterFvclassService;
import com.mf.cntrtmng.entity.BsnsBill;
import com.mf.cntrtmng.service.BsnsBillService;
import com.mf.common.util.WaterIdGener;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;

/**
 * @author wangyw
 * @2015-04-20
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/aftrmng/afterbadloan/")
public class AfterBadloanController {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	@Autowired
	private AfterBadloanService afterBadloanService;
	@Autowired
	private AfterFvclassService afterFvclassService;
	@Autowired
	private BsnsBillService bsnsBillService;
	
	
	/**
	* @Title: list
	* @Author: wangyw
	* @Description: TODO(跳转到首页)
	* @param model
	* @return    设定文件
	* @date 2015-4-20
	*/
	@RequestMapping(value="list")
	public String list(Model model){
		return "/mf/aftrmng/afterbadloan/tab";
	}
	
	/**
	* @Title: page1
	* @Author: wangyw
	* @Description: TODO(未处理不良贷款)
	* @param model
	* @return    设定文件
	* @date 2015-4-20
	*/
	@RequestMapping(value="page1")
	public String page1(Model model){ 
		return "/mf/aftrmng/afterbadloan/list1";
	}
	
	
	/**
	* @Title: page2
	* @Author: wangyw
	* @Description: TODO(已处理不良贷款)
	* @param model
	* @return    设定文件
	* @date 2015-4-20
	*/
	@RequestMapping(value="page2")
	public String page2(Model model){
		return "/mf/aftrmng/afterbadloan/list2";
	}
	@RequestMapping(value="addUI")
	public String addUI(Model model,HttpServletResponse response,HttpServletRequest request){ 
		String dueno=request.getParameter("dueno");
		BsnsBill bsnsbill=bsnsBillService.getById(dueno);
		model.addAttribute("bsnsbill", bsnsbill);
		return "/mf/aftrmng/afterbadloan/add";
	}
	/**
	 * 保存新增
	 * @param model
	 * @param afterbadloan
	 * @return
	 */
	@RequestMapping(value="addBadloan")
	public String addBadloan(Model model,AfterBadloan afterbadloan,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";;
		try {
			String rcrdid=WaterIdGener.getWaterId();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			afterbadloan.setCrtdate(sdf.format(new Date()));
			afterbadloan.setRecdid(rcrdid);
			afterBadloanService.add(afterbadloan);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param afterbadloan
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
		pageView = afterBadloanService.query(pageView, afterfvclass);
		List<AfterBadloan> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	* @Title: badloanList
	* @Author: wangyw
	* @Description: TODO(不良记录查询)
	* @param model
	* @param afterfvclass
	* @param request
	* @return    设定文件
	* @date 2015-4-20
	*/
	@RequestMapping(value="badloanList",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> badloanList(Model model,AfterBadloan afterbadloan,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = afterBadloanService.queryBadloan(pageView, afterbadloan);
		List<AfterBadloan> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param afterbadloanId
	 * @return
	 */
	@RequestMapping(value = "deleteById", method = RequestMethod.POST)
	public String deleteById(Model model, String recdid,HttpServletResponse response) {
		String result = null;
		try {
			afterBadloanService.delete(recdid);
			result = "{\"status\":1,\"message\":\"删除成功！\"}";
		} catch (Exception e) {
			result = "{\"status\":0,\"message\":\""	+ WebTool.getErrorMsg(e.getMessage()) + "\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	/**
	 * 查询&修改单条记录
	 * @param model
	 * @param afterbadloanId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String recdid,int typeKey){
		AfterBadloan afterbadloan = afterBadloanService.getById(recdid);
		model.addAttribute("afterbadloan", afterbadloan);
		if(typeKey == 1){
			return "/mf/aftrmng/afterbadloan/edit";
		}else if(typeKey == 2){
			return "/mf/aftrmng/afterbadloan/view";
		}else{
			return "/mf/aftrmng/afterbadloan/view_1";
		}
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param afterbadloan
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateAfterBadloan(Model model,AfterBadloan afterbadloan,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";;
		try {			
			afterBadloanService.modify(afterbadloan);
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
				afterBadloanService.delete(id);
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

