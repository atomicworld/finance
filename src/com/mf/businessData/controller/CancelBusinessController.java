package com.mf.businessData.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.bsnsmng.entity.BsnsApply;
import com.mf.bsnsmng.entity.BsnsApplydtl;
import com.mf.bsnsmng.service.BsnsApplyService;
import com.mf.bsnsmng.service.BsnsApplydtlService;
import com.mf.cntrtmng.entity.BsnsBill;
import com.mf.cntrtmng.entity.BsnsCntrct;
import com.mf.cntrtmng.service.BsnsBillService;
import com.mf.cntrtmng.service.BsnsCntrctService;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;

@Controller
@RequestMapping(value = "/mf/businessData/cancelBusiness/")
/**
 * 撤销业务操作
 * @author Administrator
 *
 */
public class CancelBusinessController {
	@Autowired
	BsnsApplydtlService bsnsApplydtlService;
	@Autowired
	BsnsCntrctService bsnsCntrctService;
	
	
	/**
	 * 跳转到业务取消界面 
	 * @return
	 */
	@RequestMapping(value = "toCanecelList.html")
	public String list() {
		return "/mf/businessData/cancel/cancel_list";
	}
	//申请信息
	@RequestMapping(value = "apply.html")
	public String apply() {
		return "/mf/businessData/cancel/apply";
	}
	//合同信息
	@RequestMapping(value = "cntrct.html")
	public String cntrct() {
		return "/mf/businessData/cancel/cntrct";
	}


	
	/**
	* @author wangyaowei
	* @date 2015-4-2上午5:36:38
	* @Title: getApplyPagerList
	* @Description: TODO(获取申请信息)
	* @param model
	* @param request
	* @param bsnsApplydtl
	* @return Map<String,Object>    返回类型
	* @throws
	*/
	@RequestMapping(value="getApplyPagerList",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> getApplyPagerList(Model model,HttpServletRequest request,BsnsApplydtl bsnsApplydtl) {

		PageView pageView = null;
		String pageNow = request.getParameter("pager.pageNo");
		String pageSize = request.getParameter("pager.pageSize");
		if (Common.isEmpty(pageNow))
			pageView = new PageView(1);
		else {
			pageView = new PageView(Integer.parseInt(pageSize),
					Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = bsnsApplydtlService.queryCancel(pageView, bsnsApplydtl);
		List list = pageView.getRecords();
		Map resultMap = new HashMap();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	
	
	/**
	* @author wangyaowei
	* @date 2015-4-2下午4:50:10
	* @Title: getCntrctList
	* @Description: TODO(查询合同表)
	* @param model
	* @param request
	* @param bsnsCntrct
	* @return
	* @return Map<String,Object>    返回类型
	* @throws
	*/
	@RequestMapping(value="getCntrctList",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> getCntrctList(Model model,HttpServletRequest request,BsnsCntrct bsnsCntrct) {

		PageView pageView = null;
		String pageNow = request.getParameter("pager.pageNo");
		String pageSize = request.getParameter("pager.pageSize");
		if (Common.isEmpty(pageNow))
			pageView = new PageView(1);
		else {
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = bsnsCntrctService.queryCancel(pageView, bsnsCntrct);
		List<BsnsCntrct> list = pageView.getRecords();
		map.put("rows", list);
		map.put("pager.pageNo", Integer.valueOf(pageView.getPageNow()));
		map.put("pager.totalRows", Long.valueOf(pageView.getRowCount()));
		return map;
	}
	
	  
	/**
	* @author wangyaowei
	* @date 2015-4-2下午5:37:20
	* @Title: del
	* @Description: TODO(查询申请)
	* @param model
	* @param request
	* @param response
	* @return String    返回类型
	* @throws
	*/
	@RequestMapping(value="del")
	   public String del(Model model,HttpServletRequest request,HttpServletResponse response){
		   String result ="{\"status\":true,\"message\":\"撤销成功！\"}";
		   try{
		   String rcrdid = request.getParameter("rcrdid");
		   BsnsApplydtl bsnsApplydtl = new BsnsApplydtl();
		   bsnsApplydtl.setRcrdid(Long.parseLong(rcrdid));
		   bsnsApplydtl.setApprvstt("99");
		   bsnsApplydtlService.modifyByRcrdid(bsnsApplydtl);
		   }catch(Exception e){
			   e.printStackTrace();
			   result ="{\"status\":false,\"message\":\"撤销失败！\"}";
		   }
		   WebTool.writeJson(result, response);
		   return null;
	   }
	
	
	
	/**
	* @author wangyaowei
	* @date 2015-4-2下午7:08:03
	* @Title: delCntrct
	* @Description: TODO(撤销合同)
	* @param model
	* @param request
	* @param response
	* @return
	* @return String    返回类型
	* @throws
	*/
	@RequestMapping(value="delCntrct")
	   public String delCntrct(Model model,HttpServletRequest request,HttpServletResponse response){
		   String result ="{\"status\":true,\"message\":\"撤销成功！\"}";
		   try{
		   String cntrctno = request.getParameter("cntrctno");
//		   bsnsCntrctService.delCntrct(cntrctno);
		   bsnsCntrctService.revokeCntrct(cntrctno);
		   }catch(Exception e){
			   e.printStackTrace();
			   result ="{\"status\":false,\"message\":\"撤销失败！\"}";
		   }
		   WebTool.writeJson(result, response);
		   return null;
	   }

}
