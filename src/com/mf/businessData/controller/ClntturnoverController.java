/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */


package com.mf.businessData.controller;

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
import com.mf.businessData.entity.Clntturnover;
import com.mf.businessData.service.ClntturnoverService;
import com.mf.common.util.WaterIdGener;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;
/**      
* 类名称：ClntturnoverController   
* 类描述：  客户移交功能
* 创建人：wangyaowei  
* 创建时间：2015-4-2 上午12:45:58   
* 修改人：wangyaowei  
* 修改时间：2015-4-2 上午12:45:58   
* 修改备注：   
* @version    
*    
*/
@Controller
@RequestMapping(value="/mf/clntturnover/")
public class ClntturnoverController {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	@Autowired
	private ClntturnoverService clntturnoverService;
	
	
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		return "/mf/businessData/deliver/deliver_cust";
	}
	@RequestMapping(value="list")
	public String list(Model model){
		return "/mf/businessData/deliver/deliver_list";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param clntturnover
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,Clntturnover clntturnover,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";;
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			clntturnover.setTurnovrdate(sdf.format(new Date()));
			clntturnover.setRecordid(WaterIdGener.getWaterId());
			clntturnoverService.add(clntturnover);
		} catch (Exception e) {
			result="{\"msg\":\"fail\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param clntturnover
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,Clntturnover clntturnover,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = clntturnoverService.query(pageView, clntturnover);
		List<Clntturnover> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param clntturnoverId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			clntturnoverService.delete(ids);
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
	 * @param clntturnoverId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String clntturnoverId,int typeKey){
		Clntturnover clntturnover = clntturnoverService.getById(clntturnoverId);
		model.addAttribute("clntturnover", clntturnover);
		if(typeKey == 1){
			return "/background/clntturnover/edit";
		}else if(typeKey == 2){
			return "/background/clntturnover/view";
		}else{
			return "/background/clntturnover/view_1";
		}
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param clntturnover
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateClntturnover(Model model,Clntturnover clntturnover,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";;
		try {			
			clntturnoverService.modify(clntturnover);
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
				clntturnoverService.delete(id);
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
	 * 跳到上传页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "upLoadUI")
	public String uploadUI(Model model) {
		return "/background/clntturnover/upload";
	}
}

