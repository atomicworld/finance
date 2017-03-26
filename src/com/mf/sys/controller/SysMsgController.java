package com.mf.sys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.sms.entity.Message;
import com.mf.sms.service.MessageService;
import com.mf.util.Common;
import com.mf.util.PageView;


@Controller
@RequestMapping(value="/mf/sys/countmsg")
public class SysMsgController {
	
	@Autowired
	private MessageService messageService;
	
	/**
	 * 跳转到list展示页面
	 */
	@RequestMapping(value="/list.html")
	public String list(){
		return "/mf/sys/message/count/list";
	}
	
	/**
	 * 跳转到view展示页面
	 */
	@RequestMapping(value="getById")
	public String getById(Model model, String id){
		Message message = messageService.getById(id);
		model.addAttribute("message",message);
		return "/mf/sys/message/count/view";
	}
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param sysrole
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,Message message,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = messageService.query(pageView, message);
		List<Message> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
}
