package com.mf.sms.controller;

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

import com.mf.sms.entity.MessageModel;
import com.mf.sms.service.MessageModelService;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;


@Controller
@RequestMapping(value = "/mf/sms/message/")
public class MessageServerController {
	
	@Autowired
	private MessageModelService messageModelService;
	
	/**
	 * 跳到展示页面
	 * @return
	 */
	@RequestMapping(value="list")
	public String list(){
		return "/mf/sys/message/msgview";
	}
	
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		return "/mf/sys/message/msgadd";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param comstructure
	 */
	@RequestMapping(value="add")
	public String add(Model model,MessageModel messageModel,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";
		messageModelService.add(messageModel);
		WebTool.writeJson(result, response);
		return null;
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param comstructure
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(Model model,MessageModel messageModel,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";
		try {			
			System.out.println("begin");
			messageModelService.update(messageModel);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;		
	}
	
	
	/**
	 * 查询&修改单条记录
	 * @param model
	 * @param sysroleId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String id,int typeKey){
		MessageModel messageModel = messageModelService.getById(id);
		model.addAttribute("messageModel",messageModel);
		if(typeKey == 1){
			return "/mf/sys/message/msgedit";
		}else{
			return "/mf/sys/message/msgview";
		}
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param sysroleId
	 * @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			//先判断是否有相应短信模板,若存在则无法删除
			if(messageModelService.getById(ids)!=null){
				messageModelService.delete(ids);
			    result="{\"status\":1,\"message\":\"删除成功！\"}";
			}else{
				result="{\"status\":2,\"message\":\"存在该角色类型的操作员.\"}";
			}
			
		}catch(Exception e){
			result="{\"status\":0,\"message\":\"" +"删除失败!"+"\"}"; //WebTool.getErrorMsg(e.getMessage())
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param sysrole
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,MessageModel messageModel,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = messageModelService.query(pageView, messageModel);
		List<MessageModel> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/changeStatus.html")
	@ResponseBody
	public Map<String, Object> changeStatus(HttpServletRequest request) {
		String id = request.getParameter("id");
		String isused=request.getParameter("isused");
		Map resultMap = new HashMap();
		try {
			messageModelService.changeStatus(id,isused);
			resultMap.put("resCode", "1");
		}catch (Exception e) {
			e.printStackTrace();
			resultMap.put("resCode", "-1");
			resultMap.put("resDesc", e.getMessage());
		}
		return resultMap;
	}
}
