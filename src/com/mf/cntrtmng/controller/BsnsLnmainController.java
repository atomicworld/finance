/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */


package com.mf.cntrtmng.controller;

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

import com.mf.cntrtmng.entity.BsnsCntrct;
import com.mf.cntrtmng.entity.BsnsLnmain;
import com.mf.cntrtmng.service.BsnsCntrctService;
import com.mf.cntrtmng.service.BsnsLnmainService;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;
/**
 * @author xujiuhua
 * @2015-01-21
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/cntrtmng/bsnslnmain/")
public class BsnsLnmainController {
	
	@Autowired
	private BsnsLnmainService bsnsLnmainService;
	@Autowired
	private BsnsCntrctService bsnsCntrctService;
	
	
	
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		return "/mf/cntrtmng/bsnslnmain/add";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param bsnslnmain
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,BsnsLnmain bsnslnmain,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";;
		try {
			bsnsLnmainService.add(bsnslnmain);
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
	 * @param bsnslnmain
	 * @return
	 */
	@RequestMapping(value="addnull")
	public String addnull(Model model,HttpServletResponse response,HttpServletRequest request){
		String result="";
		try {
			BsnsLnmain bsnslnmain = new BsnsLnmain();
			bsnsLnmainService.addAll(bsnslnmain);
			result="{\"id\":" + bsnslnmain.getBsnsid()+ ",\"message\":\"新增成功！\"}";
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
	 * @param bsnslnmain
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="query")
	public String query(Model model,BsnsLnmain bsnslnmain,String pageNow, String pageSize){
		return "/mf/cntrtmng/bsnslnmain/list_list";
	}
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param bsnslnmain
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,BsnsLnmain bsnslnmain,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = bsnsLnmainService.query(pageView, bsnslnmain);
		List<BsnsLnmain> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param bsnslnmainId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			bsnsLnmainService.delete(ids);
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
	 * @param bsnslnmainId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String bsnslnmainId,int typeKey){
		BsnsLnmain bsnslnmain = bsnsLnmainService.getById(bsnslnmainId);
		model.addAttribute("bsnslnmain", bsnslnmain);
		if(typeKey == 1){
			return "/mf/cntrtmng/bsnslnmain/edit";
		}else if(typeKey == 2){
			return "/mf/cntrtmng/bsnslnmain/view";
		}else{
			return "/mf/cntrtmng/bsnslnmain/view_1";
		}
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param bsnslnmain
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateBsnsLnmain(Model model,BsnsLnmain bsnslnmain,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";;
		try {			
			bsnsLnmainService.modify(bsnslnmain);
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
				bsnsLnmainService.delete(id);
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
	 * 跳转到贷款发放页面显示待贷款发放合同信息页面
	 * @return
	 */
	@RequestMapping(value="/extendlist.html")
	public String extendlist(){
		return "/mf/cntrtmng/cntrctextend/list";
	}
	
	/**
	 * @param model
	 * @param bsnscntrct
	 * @return map
	 */
	@RequestMapping(value="showextendlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showextendlist(Model model,BsnsLnmain bsnsLnmain,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = bsnsLnmainService.queryextend(pageView, bsnsLnmain);
		List<BsnsCntrct> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	* @author wangyaowei
	* @date 2015-2-3下午5:30:30
	* @Title: childPage
	* @Description: 查看详细信息页面
	*/
	@RequestMapping(value="extendPage")
    public String extendPage(Model model,HttpServletRequest request){
			String bsnsno=request.getParameter("bsnsno");
			BsnsLnmain bsnslnmain = bsnsLnmainService.findByBsnsno(bsnsno);
			// 合同信息
			BsnsCntrct bsnsCntrct = bsnsCntrctService.findByCntrctno(bsnslnmain.getCntrctno());
			model.addAttribute("bsnsCntrct", bsnsCntrct);
			model.addAttribute("bsnslnmain",bsnslnmain);
			return "/mf/cntrtmng/cntrctextend/main";  
    }
}

