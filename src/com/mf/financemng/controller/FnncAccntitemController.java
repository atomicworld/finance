package com.mf.financemng.controller;

import java.util.ArrayList;
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

import com.mf.base.AutoCompleteEntity;
import com.mf.bsnsmng.entity.Client;
import com.mf.businessParam.entity.BusinessKind;
import com.mf.financemng.entity.FnncAccntitem;
import com.mf.financemng.service.FnncAccntitemService;
import com.mf.json.Entity;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;

@Controller
@RequestMapping(value="/mf/fnncatitem/")
public class FnncAccntitemController {
	@Autowired
	private FnncAccntitemService fnncAccntitemService;
     
	/**
	 * 跳转到科目设置主页面
	 * {@link Autowired} shenguangdong
	 * at 2015-02-11
	 */
	
	@RequestMapping(value="query")
	public String query(Model model){
		  
		return "/mf/financemng/fnncatitem/query";
	}
	/**
	 * 跳转到列表页面
	 */
	@RequestMapping(value="list")
	public String List(Model model,HttpServletRequest request){
		/**
		 * accntdrct =1 为资产
		 * accntdrct =2 为负债
		 * accntdrct =3 为所有者权益
		 * accntdrct =4 为损益
		 * accntdrct =5为表外
		 */
		String  stat = request.getParameter("stat");
	
	
		List<FnncAccntitem> list = fnncAccntitemService.getByAccntno(stat);
		
		/**
		 * 由于数据库结构不是树结构，为此构造一个二叉树
		 */
		List<FnncAccntitem> zcslist=new ArrayList<FnncAccntitem>();//
		for(int i=0;i<list.size();i++){
			FnncAccntitem fnnc = list.get(i);
			if(fnnc.getAccntno().length()==4){
				fnnc.setAccntkndcode("0");
			}
			if(fnnc.getAccntno().length()==6){
				fnnc.setAccntkndcode(fnnc.getAccntno().substring(0, 4));
			}
			if(fnnc.getAccntno().length()==8){
				fnnc.setAccntkndcode(fnnc.getAccntno().substring(0, 6));
			}
			zcslist.add(fnnc);
		}
		model.addAttribute("zcslist", zcslist);
	
		return "/mf/financemng/fnncatitem/infoList";
	}
	
	
	/**
	 * 跳转到查看详情页面
	 */
	@RequestMapping(value="view")
	public String view(Model model,HttpServletRequest request){
		  String accntno=request.getParameter("accntno");
		  FnncAccntitem fnncAccntitem =fnncAccntitemService.getById(accntno);
		  model.addAttribute("fnncAccntitem", fnncAccntitem);
		  return "/mf/financemng/fnncatitem/view";
	}
	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(value="add")
	public String add(Model model,HttpServletRequest request){
		String accntno = request.getParameter("accntno");
		FnncAccntitem fnncAccntitem =fnncAccntitemService.getById(accntno);
		String nextaccntno = fnncAccntitemService.getChild(fnncAccntitem.getAccntno());
		if(nextaccntno==null){
			nextaccntno=fnncAccntitem.getAccntno()+"01";
		}
		model.addAttribute("nextaccntno", nextaccntno);
	    model.addAttribute("fnncAccntitem", fnncAccntitem);
		return "/mf/financemng/fnncatitem/add";   
	}
	
	/**
	 * 保存科目
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model,FnncAccntitem fnncAccntitem,HttpServletResponse response){
		System.out.println("----------");
		   String result="{\"msg\":\"suc\"}";
		   System.out.println(fnncAccntitem.getAccntnm()+"----------");
		   fnncAccntitem.setHaschildaccnt("N");
		   try {
			   fnncAccntitemService.add(fnncAccntitem);
		} catch (Exception e) {
			 result="{\"msg\":\"false\"}";
		}
		   
		WebTool.writeJson(result, response);
		return null;
	}
	@RequestMapping(value="isChild")
	public String isChild(Model model,FnncAccntitem fnncAccntitem,HttpServletResponse response){
	String result="";
	try {
			   FnncAccntitem fa=fnncAccntitemService.getById(fnncAccntitem.getAccntno());
			   if("N".equals(fa.getHaschildaccnt())){
				   result="{\"msg\":\"true\"}";
			   }else{
				   result="{\"msg\":\"false\"}";
			   }
		} catch (Exception e) {
			 result="{\"msg\":\"false\"}";
		}
		   
		WebTool.writeJson(result, response);
		return null;
	}
	
	
	/**
	* @author wangyaowei
	* @date 2015-2-11下午4:48:24
	* @Title: getAccntnm
	* @Description: TODO(获取所属科目)
	* @param accntno
	* @return Object    返回类型
	*/
	@RequestMapping(value="getAccntnm")
	@ResponseBody
	public Object getAccntnm(String accntno){
		 List<FnncAccntitem> list=new ArrayList<FnncAccntitem>();
		FnncAccntitem  entity = fnncAccntitemService.getById(accntno);
		FnncAccntitem  fa=new FnncAccntitem();
		fa.setUpaccntno(entity.getUpaccntno());
		fa.setHaschildaccnt("Y");
		String paccntno=accntno.substring(0,accntno.length()-2);
		fa.setAccntno(paccntno);
		FnncAccntitem  entity2 = fnncAccntitemService.getByUp(fa);
		list.add(entity2);
		return list;
	}
	
	@RequestMapping(value="getAllItem")
	@ResponseBody
	public Map<String, List<AutoCompleteEntity>> getAllItem(){
		Map<String,List<AutoCompleteEntity>> map;
		//查询所有科目信息
		map = fnncAccntitemService.getAllItemForAutoCmp();
		return map;
	}
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/getType")
	@ResponseBody
	public Map<String, List> getType(String code, HttpServletRequest request){
		//字典类型编码
		String accntkndcode = request.getParameter("code");
		Entity entity;
		List<FnncAccntitem> fnncaccntitem;
		fnncaccntitem=fnncAccntitemService.getType(accntkndcode);
		List<Entity> list = new ArrayList<Entity>();
		Map<String,List> resMap = new HashMap<String,List>();
		for(FnncAccntitem sd : fnncaccntitem){
			entity = new Entity();
			entity.setKey(sd.getAccntnm());
			entity.setValue(sd.getAccntno());
			list.add(entity);
		}
		resMap.put("list", list);
		return resMap;
	}

	
}

