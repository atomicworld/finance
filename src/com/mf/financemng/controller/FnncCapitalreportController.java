package com.mf.financemng.controller;

import java.util.ArrayList;
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
import com.mf.financemng.entity.FnncCapitalreport;
import com.mf.financemng.entity.FnncCapitalreportmain;
import com.mf.financemng.entity.FnncShareholder;
import com.mf.financemng.service.FnncCapitalreportService;
import com.mf.financemng.service.FnncCapitalreportmainService;
import com.mf.financemng.service.FnncShareholderService;
import com.mf.json.Entity;
import com.mf.org.entity.Operator;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;

/**
 * @author chenenze
 * @2015-02-11
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/financemng/capitalreport/")
public class FnncCapitalreportController {
	
	@Autowired
	private FnncCapitalreportService fnncCapitalreportService;
	
	@Autowired
	private FnncShareholderService fnncShareholderService;
	
	@Autowired
	private FnncCapitalreportmainService fnncCapitalreportmainService;
	/**
	 * 跳转到list展示页面
	 * @return
	 */
	@RequestMapping(value="list")
	public String list(){
		return "/mf/financemng/capitalreport/list";
	}
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model,String id){
		FnncCapitalreportmain fnnccapitalreportmain = fnncCapitalreportmainService.getById(id);
		model.addAttribute("fnnccapitalreportmain", fnnccapitalreportmain);
		List<FnncCapitalreport> fnnccapitalreport=fnncCapitalreportService.findAll(id);
		//判断验资报告子表是否有值，如果没有值，跳转到新增页面；有值，跳转到查看页面
		if(fnnccapitalreport.size()==0){
			return "/mf/financemng/capitalreport/add";
		}else{
			model.addAttribute("report", fnnccapitalreport);
			model.addAttribute("fnnc", fnnccapitalreport.get(0));
			return "/mf/financemng/capitalreport/view";
		}
		
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param fnnccapitalreport
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,FnncCapitalreport fnnccapitalreport,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";;
		try {
			//验资报告内容
			String sharholdnm[]=request.getParameterValues("sharholdnm");
			String registcapit[]=request.getParameterValues("registcapit");
			String reprate[]=request.getParameterValues("reprate");
			String earpaidcapit[]=request.getParameterValues("earpaidcapit");
			String earprate[]=request.getParameterValues("earprate");
			String growpaidcapit[]=request.getParameterValues("growpaidcapit");
			String growprate[]=request.getParameterValues("growprate");
			String currpaidcapit[]=request.getParameterValues("currpaidcapit");
			String currprate[]=request.getParameterValues("currprate");
			
//			System.out.println("sharholdnm:=====1====="+java.util.Arrays.toString(sharholdnm));
//			System.out.println("registcapit:===2======="+java.util.Arrays.toString(registcapit));
//			System.out.println("reprate:=======3==="+java.util.Arrays.toString(reprate));
//			System.out.println("earpaidcapit:===4======="+java.util.Arrays.toString(earpaidcapit));
//			System.out.println("earprate:======5===="+java.util.Arrays.toString(earprate));
//			System.out.println("growpaidcapit:==6========"+java.util.Arrays.toString(growpaidcapit));
//			System.out.println("growprate:======7===="+java.util.Arrays.toString(growprate));
//			System.out.println("currpaidcapit:===8======="+java.util.Arrays.toString(currpaidcapit));
//			System.out.println("currprate:=======9==="+java.util.Arrays.toString(currprate));

			
			for(int i=0;i<sharholdnm.length;i++){						
				//报告编号和报告名称(报告名称"验资报告"+"_"+顺序号,暂时用流水号代替)
				String docno=request.getParameter("docno");
				fnnccapitalreport.setDocno(docno);
				String docnm =request.getParameter("docnm");
				fnnccapitalreport.setDocnm(docnm);
				//子表唯一标识
				String sharno=WaterIdGener.getWaterId();
				fnnccapitalreport.setSharholdno(sharno);
				//登记日期
				String nowDt = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
				fnnccapitalreport.setScdate(nowDt);
				//部门编号
				Operator user = (Operator)request.getSession().getAttribute("operator");
				String dptno = user.getDptno();
				String opno = user.getEmplyno();
				fnnccapitalreport.setRegopno(opno);
				fnnccapitalreport.setDepno(dptno);
				//报告日期
				String docdt=request.getParameter("docdt");
				fnnccapitalreport.setDocdt(docdt);			
				//报告合计信息
				String registcapitota=request.getParameter("registcapitota");
				String repratetota=request.getParameter("repratetota");
				String earpaidcapitota=request.getParameter("earpaidcapitota");
				String earpratetota=request.getParameter("earpratetota");
				String growpaidcapitota=request.getParameter("growpaidcapitota");
				String growpratetota=request.getParameter("growpratetota");
				String currpaidcapitota=request.getParameter("currpaidcapitota");
				String currpratetota=request.getParameter("currpratetota");
				fnnccapitalreport.setRegistcapitota(registcapitota);
				fnnccapitalreport.setRepratetota(repratetota);
				fnnccapitalreport.setEarpaidcapitota(earpaidcapitota);
				fnnccapitalreport.setEarpratetota(earpratetota);
				fnnccapitalreport.setGrowpaidcapitota(growpaidcapitota);
				fnnccapitalreport.setGrowpratetota(growpratetota);
				fnnccapitalreport.setCurrpaidcapitota(currpaidcapitota);
				fnnccapitalreport.setCurrpratetota(currpratetota);
				
				//数组数据				 
				fnnccapitalreport.setSharholdnm(sharholdnm[i]);
				fnnccapitalreport.setRegistcapit(registcapit[i]);
				fnnccapitalreport.setReprate(reprate[i]);
				fnnccapitalreport.setEarpaidcapit(earpaidcapit[i]);
				fnnccapitalreport.setEarprate(earprate[i]);
				fnnccapitalreport.setGrowpaidcapit(growpaidcapit[i]);
				fnnccapitalreport.setGrowprate(growprate[i]);
				fnnccapitalreport.setCurrpaidcapit(currpaidcapit[i]);
				fnnccapitalreport.setCurrprate(currprate[i]);				 

				 fnncCapitalreportService.add(fnnccapitalreport,request);
			}		
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
	 * @param fnnccapitalreport
	 * @return
	 */
	@RequestMapping(value="addnull")
	public String addnull(Model model,HttpServletResponse response,HttpServletRequest request){
		String result="";
		try {
			FnncCapitalreport fnnccapitalreport = new FnncCapitalreport();
			fnncCapitalreportService.addAll(fnnccapitalreport);
			result="{\"id\":" + fnnccapitalreport.getDocno() + ",\"message\":\"新增成功！\"}";
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
	 * @param fnnccapitalreport
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="query")
	public String query(Model model,FnncCapitalreport fnnccapitalreport,String pageNow, String pageSize){
		return "/mf/financemng/fnnccapitalreport/list_list";
	}
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param fnnccapitalreport
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,FnncCapitalreport fnnccapitalreport,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = fnncCapitalreportService.query(pageView, fnnccapitalreport);
		List<FnncCapitalreport> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String deleteById(Model model,String id, HttpServletResponse response){
		String result=null;
		try{
			fnncCapitalreportService.delete(id);
			fnncCapitalreportmainService.delete(id);
			
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
	 * @param id
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String id,int typeKey){
		List<FnncCapitalreport> fnnccapitalreport=fnncCapitalreportService.findAll(id);
		//System.out.println("================"+fnnccapitalreport.size());
		model.addAttribute("report", fnnccapitalreport);
		//判断验资报告子表是否有值，如果没有值，跳转到新增页面
		if(fnnccapitalreport.size()==0){
			return "/mf/financemng/capitalreport/add";
		}
		model.addAttribute("fnnc", fnnccapitalreport.get(0));

		if(typeKey == 1){
			return "/mf/financemng/capitalreport/edit";
		}else if(typeKey == 2){
			return "/mf/financemng/capitalreport/view";
		}else{
			return "/mf/financemng/capitalreport/view_1";
		}
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param fnnccapitalreport
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateFnncCapitalreport(Model model,FnncCapitalreport fnnccapitalreport,HttpServletResponse response,HttpServletRequest request){		
		String result="{\"msg\":\"suc\"}";;
		try {	
			String sharholdno[]=request.getParameterValues("sharholdno");
			String sharholdnm[]=request.getParameterValues("sharholdnm");
			String registcapit[]=request.getParameterValues("registcapit");
			String reprate[]=request.getParameterValues("reprate");
			String earpaidcapit[]=request.getParameterValues("earpaidcapit");
			String earprate[]=request.getParameterValues("earprate");
			String growpaidcapit[]=request.getParameterValues("growpaidcapit");
			String growprate[]=request.getParameterValues("growprate");
			String currpaidcapit[]=request.getParameterValues("currpaidcapit");
			String currprate[]=request.getParameterValues("currprate");
			//=======================更新基本信息======================================
			for(int i=0;i<sharholdno.length;i++){	
				//登记日期
				String nowDt = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
				fnnccapitalreport.setLastmoddate(nowDt);
				//部门编号
				Operator user = (Operator)request.getSession().getAttribute("operator");
				String dptno = user.getDptno();
				String opno = user.getEmplyno();
				fnnccapitalreport.setRegopno(opno);
				fnnccapitalreport.setDepno(dptno);		
				//报告合计信息
				String registcapitota=request.getParameter("registcapitota");
				String repratetota=request.getParameter("repratetota");
				String earpaidcapitota=request.getParameter("earpaidcapitota");
				String earpratetota=request.getParameter("earpratetota");
				String growpaidcapitota=request.getParameter("growpaidcapitota");
				String growpratetota=request.getParameter("growpratetota");
				String currpaidcapitota=request.getParameter("currpaidcapitota");
				String currpratetota=request.getParameter("currpratetota");
				fnnccapitalreport.setRegistcapitota(registcapitota);
				fnnccapitalreport.setRepratetota(repratetota);
				fnnccapitalreport.setEarpaidcapitota(earpaidcapitota);
				fnnccapitalreport.setEarpratetota(earpratetota);
				fnnccapitalreport.setGrowpaidcapitota(growpaidcapitota);
				fnnccapitalreport.setGrowpratetota(growpratetota);
				fnnccapitalreport.setCurrpaidcapitota(currpaidcapitota);
				fnnccapitalreport.setCurrpratetota(currpratetota);
				
				//数组数据		
				fnnccapitalreport.setSharholdno(sharholdno[i]);
				fnnccapitalreport.setSharholdnm(sharholdnm[i]);
				fnnccapitalreport.setRegistcapit(registcapit[i]);
				fnnccapitalreport.setReprate(reprate[i]);
				fnnccapitalreport.setEarpaidcapit(earpaidcapit[i]);
				fnnccapitalreport.setEarprate(earprate[i]);
				fnnccapitalreport.setGrowpaidcapit(growpaidcapit[i]);
				fnnccapitalreport.setGrowprate(growprate[i]);
				fnnccapitalreport.setCurrpaidcapit(currpaidcapit[i]);
				fnnccapitalreport.setCurrprate(currprate[i]);
				
				fnncCapitalreportService.modify(fnnccapitalreport);
			}
				//=======================删除详细信息======================================
			List<FnncCapitalreport> report=fnncCapitalreportService.findAll(fnnccapitalreport.getDocno());
			for(int i=0;i<report.size();i++){
				boolean ishave=false;
				for(int j=0;j<sharholdno.length;j++){
					if(report.get(i).getSharholdno().equals(sharholdno[j])){
						ishave=true;
						break;
					}
				}
				if(!ishave){
					System.out.println("ishave======="+report.get(i).getSharholdno());
					fnncCapitalreportService.delete(report.get(i).getSharholdno());	
				}
			}
			//=======================新增详细信息======================================
			for(int i=sharholdno.length;i<sharholdnm.length;i++){	
				//登记日期
				String nowDt = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
				fnnccapitalreport.setLastmoddate(nowDt);
				//部门编号
				Operator user = (Operator)request.getSession().getAttribute("operator");
				String dptno = user.getDptno();
				String opno = user.getEmplyno();
				fnnccapitalreport.setRegopno(opno);
				fnnccapitalreport.setDepno(dptno);		
				//报告合计信息
				String registcapitota=request.getParameter("registcapitota");
				String repratetota=request.getParameter("repratetota");
				String earpaidcapitota=request.getParameter("earpaidcapitota");
				String earpratetota=request.getParameter("earpratetota");
				String growpaidcapitota=request.getParameter("growpaidcapitota");
				String growpratetota=request.getParameter("growpratetota");
				String currpaidcapitota=request.getParameter("currpaidcapitota");
				String currpratetota=request.getParameter("currpratetota");
				fnnccapitalreport.setRegistcapitota(registcapitota);
				fnnccapitalreport.setRepratetota(repratetota);
				fnnccapitalreport.setEarpaidcapitota(earpaidcapitota);
				fnnccapitalreport.setEarpratetota(earpratetota);
				fnnccapitalreport.setGrowpaidcapitota(growpaidcapitota);
				fnnccapitalreport.setGrowpratetota(growpratetota);
				fnnccapitalreport.setCurrpaidcapitota(currpaidcapitota);
				fnnccapitalreport.setCurrpratetota(currpratetota);
				
				//数组数据	
				
				//子表唯一标识
				String sharno=WaterIdGener.getWaterId();
				fnnccapitalreport.setSharholdno(sharno);
				
				fnnccapitalreport.setSharholdnm(sharholdnm[i]);
				fnnccapitalreport.setRegistcapit(registcapit[i]);
				fnnccapitalreport.setReprate(reprate[i]);
				fnnccapitalreport.setEarpaidcapit(earpaidcapit[i]);
				fnnccapitalreport.setEarprate(earprate[i]);
				fnnccapitalreport.setGrowpaidcapit(growpaidcapit[i]);
				fnnccapitalreport.setGrowprate(growprate[i]);
				fnnccapitalreport.setCurrpaidcapit(currpaidcapit[i]);
				fnnccapitalreport.setCurrprate(currprate[i]);
				
				fnncCapitalreportService.add(fnnccapitalreport,request);
			}
			
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
				fnncCapitalreportService.delete(id);
			}
			result = "{\"status\":1,\"message\":\"删除成功！\"}";
		} catch (Exception e) {
			result="{\"status\":0,\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/getByshno.html")
	@ResponseBody
	public Map<String, List> getByshno(){
		//新增时下拉选择框
		Entity entity;
		List<FnncShareholder> fnncShareholder = fnncShareholderService.findAll();
		//System.out.println("-----------------"+fnncShareholder);
		List<Entity> list = new ArrayList<Entity>();
		Map<String,List> resMap = new HashMap<String,List>();
		for(FnncShareholder sd : fnncShareholder){
			entity = new Entity();
			entity.setKey(sd.getSharholdnm());
			entity.setValue(sd.getSharholdnm());
			list.add(entity);
		}
		resMap.put("list", list);
		return resMap;
	}
	
}

