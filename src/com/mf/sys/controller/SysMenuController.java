package com.mf.sys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.common.pub.PubConstants;
import com.mf.sys.entity.SysMenu;
import com.mf.sys.entity.SysRight;
import com.mf.sys.service.SysMenuService;
import com.mf.sys.service.SysRightService;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;

@Controller
@RequestMapping(value ="/mf/devmng/sysmenu")
public class SysMenuController {

	@Autowired
	private SysMenuService sysMenuService;
	
	@Autowired
	private SysRightService sysRightService;

	
	/**
	 * 跳转到list展示页面
	 * @return
	 */
	@RequestMapping(value="/list.html")
	public String list(){
		return "/mf/devmng/sysMenu/list";
	}
	
	/**
	 * 提供list展示界面的数据
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/query.html")
	@ResponseBody
	public Map<String, Object> getSysMenuList(Model model,SysMenu sysMenu,
			HttpServletRequest request){
		System.out.println("sysMenu-->>"+sysMenu);
		System.out.println("sysMenu.mnnm-->>"+sysMenu.getMnnm());
		PageView pageView=null;
		String pageNow =request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if (Common.isEmpty(pageNow))
			pageView=new PageView(1);
		else{
			pageView=new PageView(Integer.parseInt(pageSize),
					Integer.parseInt(pageNow));
		}
		if (Common.isEmpty(pageNow))
			pageView = new PageView(1);
		else {
			pageView = new PageView(Integer.parseInt(pageSize),
					Integer.parseInt(pageNow));
		}
		Map map = new HashMap();
		pageView = this.sysMenuService.query(pageView, sysMenu);
		List list = pageView.getRecords();
		//System.out.println("getrecords " + ((SysMenu)list.get(0)).getMnno());
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
		return"/mf/devmng/sysMenu/add";
	}
	/**
	 * 保存数据
	 * @param model
	 * @param sysMenuType
	 * @param response
	 * @param sysRightService 
	 * @return
	 */
	@RequestMapping(value="/add.html")
	@ResponseBody
	public String add(Model model, SysMenu sysMenu,SysRight sysright, HttpServletResponse response){
		
		String result = "{\"msg\":\"suc\"}";
		String mnno=sysMenu.getMnno();
		SysMenu sd = sysMenuService.findById(mnno);
		

		try{
			if(mnno.length() ==3){
				sysright.setMnno(mnno);
				
				String isuesd=sysMenu.getIsused();		
				sysright.setIsused(isuesd);
				
				String mnnm=sysMenu.getMnnm();
				sysright.setRghtnm(mnnm);
				sysRightService.add(sysright);	
			}
			
			sysMenuService.add(sysMenu);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	@RequestMapping(value="/findById.html")
	public String getById(Model model, String mnno, String type, HttpServletResponse response){
		SysMenu sysMenu=sysMenuService.findById(mnno);
		model.addAttribute("sysMenu",sysMenu);

		if(null != type){
			if(PubConstants.PAGE_TYPE_VIEW.equals(type)){
				return "/mf/devmng/sysMenu/info";
			}else{
				return "/mf/devmng/sysMenu/edit";
			}
		}else{
			return null;
		}
	}
	//修改页面
	@RequestMapping(value = "/updateAll.html")
	public String modify(SysMenu sysMenu, HttpServletResponse response){
		String result = null;
		try {
			sysMenuService.modify(sysMenu);
			System.out.println(sysMenu);
			result = "{\"msg\":\"suc\"}";
		} catch (Exception e) {
			result = "{\"msg\":\"fail\"}";
		}
		WebTool.writeJson(result, response);
		return null;
	}
	/***
	 * 删除用户
	 * @return
*/
	@RequestMapping(value="/delete.html")
	public String delete(SysMenu sysMenu, HttpServletResponse response){
		String result = null;
		try {
			sysMenuService.delete(sysMenu.getMnno());
			result = "{\"msg\":\"suc\"}";
		} catch (Exception e) {
			result = "{\"msg\":\"fail\"}";
		}
		WebTool.writeJson(result, response);
		return null;
		}
}
