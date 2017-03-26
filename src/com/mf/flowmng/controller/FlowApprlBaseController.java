/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */


package com.mf.flowmng.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mf.businessParam.entity.BusinessKind;
import com.mf.businessParam.service.impl.BusinessKindServiceImpl;
import com.mf.common.util.JsonFormat;
import com.mf.flowmng.entity.FlowApplystep;
import com.mf.flowmng.entity.FlowApprlBase;
import com.mf.flowmng.entity.FlowBean;
import com.mf.flowmng.entity.LineBean;
import com.mf.flowmng.service.FlowApplystepService;
import com.mf.flowmng.service.FlowApprlBaseService;
import com.mf.json.Entity;
import com.mf.sys.entity.SysDictionary;
import com.mf.sys.service.SysDictionaryService;
import com.mf.util.PageView;
import com.mf.util.WebTool;

/**
 * @author yangchao
 * @2015-01-09
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/flowmng/")
public class FlowApprlBaseController {
	
	//add by fangzp 2015-01-20  获得流程步骤
	@Autowired
	private  FlowApplystepService flowApplystepService; 

	
	@Autowired
	private  FlowApprlBaseService flowApprlBaseService; 
	@Autowired
	private  BusinessKindServiceImpl businessKidServiceImpl;
	
	@Autowired
	private SysDictionaryService sysDictionaryService;
    /**
     * 跳转到新增页面
     */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		FlowApprlBase flowApprlBase = new FlowApprlBase();
		flowApprlBase.setFlowdsgninf(jsonInfor());
		model.addAttribute("flowApprlBase", flowApprlBase);
		return "/mf/flowmng/flowBaseAdd";
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value="add")
	public String add(Model model,FlowApprlBase flowApprlBase,HttpServletResponse response){
		   SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		   SimpleDateFormat sf1 = new SimpleDateFormat("yyyyMMddhhmmss");
		   flowApprlBase.setFlowno(sf1.format(new Date()));
		   flowApprlBase.setCrtdate(sf.format(new Date()));
		   flowApprlBase.setApprltyp("0");
		   String result="{\"msg\":\"suc\"}";
		   //add by fangzp 转换为流程步骤@分割
		   flowApprlBase.setFlowsteps(this.flowStep(flowApprlBase.getFlowdsgninf())); 
		   flowApprlBaseService.add(flowApprlBase);
		   WebTool.writeJson(result, response);
		   return null;
	}
	/**
	 * 分页查询跳转
	 * @param model
	 * @param flowapprlbase
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="query")
	public String query(Model model,FlowApprlBase flowapprlbase,String pageNow, String pageSize){
		   return "/mf/flowmng/flowBaseList";
	}
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param flowapprlbase
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,FlowApprlBase flowapprlbase,HttpServletRequest request){
		
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(com.mf.util.Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
	
		
		pageView = flowApprlBaseService.query(pageView, flowapprlbase);
		List<FlowApprlBase> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param flowapprlbaseId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			flowApprlBaseService.delete(ids);
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
	 * @param flowapprlbaseId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String flowapprlbaseId,int typeKey){
		FlowApprlBase flowApprlBase = flowApprlBaseService.getById(flowapprlbaseId);
		String bsnsprdtno = flowApprlBase.getBsnsprdtno();
		if(bsnsprdtno!=null&&bsnsprdtno.indexOf("@")>0){
			bsnsprdtno = flowApprlBase.getBsnsprdtno().replace("@",",");
		}
		
		String assrtyp =flowApprlBase.getAssrtyp();
		if(assrtyp!=null&&assrtyp.indexOf("@")>0){
			assrtyp =flowApprlBase.getAssrtyp().replace("@", ",");
			
		}
		String cstmrtyp = flowApprlBase.getCstmrtyp();
		if(cstmrtyp!=null&&cstmrtyp.indexOf("@")>0){
			cstmrtyp = flowApprlBase.getCstmrtyp().replace("@", ",");
		}
		String mngdptno = flowApprlBase.getMngdptno();
		if(mngdptno!=null&&mngdptno.indexOf("@")>0){
			mngdptno = flowApprlBase.getMngdptno().replace("@", ",");
		}
		String bsnstyp = flowApprlBase.getBsnstyp();
		if(bsnstyp!=null&&bsnstyp.indexOf("@")>0){
			bsnstyp = flowApprlBase.getBsnstyp().replace("@", ",");
		}
		model.addAttribute("bsnsprdtno", bsnsprdtno);
		model.addAttribute("assrtyp", assrtyp);
		model.addAttribute("cstmrtyp", cstmrtyp);
		model.addAttribute("bsnstyp", bsnstyp);
		model.addAttribute("mngdptno", mngdptno);
		model.addAttribute("flowApprlBase", flowApprlBase);
		
		//add by fangzp
		String flowDesign = flowApprlBase.getFlowdsgninf();
		if(flowDesign ==null || "".equals(flowDesign)){
			model.addAttribute("flowdsgninf", jsonInfor());
		}else{
			model.addAttribute("flowdsgninf", flowDesign);
		}
		
		if(typeKey == 1){
			return "/mf/flowmng/flowBaseEdit";
		}else if(typeKey == 2){
			return "/mf/flowmng/flowBaseView";
		}else{	
			return "/background/flowapprlbase/view_1";
		}
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param flowapprlbase
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateFlowApprlBase(Model model,FlowApprlBase flowapprlbase,HttpServletResponse response){		
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		String result="{\"msg\":\"suc\"}";;
		flowapprlbase.setUpdtdate(sf.format(new Date()));
		//add by fangzp 转换为流程步骤@分割
	    flowapprlbase.setFlowsteps(this.flowStep(flowapprlbase.getFlowdsgninf()));
		try {			
			flowApprlBaseService.modify(flowapprlbase);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		 return null;		
		
	}
	
	
	
	
	
	/**
	 * add by fangzp 2015.1.20
	 * @return
	 */
	private String jsonInfor(){
		//{'title':'流程设计器','nodes':{'demo_node_1':{'name':'检查','left':121,'top':110,'type':'task','width':90,'height':35,'alt':true},'demo_node_2':{'name':'复核','left':121,'top':170,'type':'task','width':90,'height':35,'alt':true},'demo_node_3':{'name':'开始','left':121,'top':50,'type':'start','width':90,'height':35,'alt':true},'demo_node_6':{'name':'财务复核','left':121,'top':230,'type':'task','width':90,'height':35,'alt':true}},'lines':{},'areas':{},'initNum':8}
		StringBuffer bf = new StringBuffer();
		bf.append("{'title':'流程设计器','nodes':{");
		List<FlowApplystep> flowList = flowApplystepService.findAll();
		if(flowList != null && flowList.size()>0){
			int i=0;
			for(FlowApplystep step:flowList){ 
				String[] xywh = null;
				if(step.getStepxy() != null && !"".equals(step.getStepxy().trim()))xywh = step.getStepxy().split(":");
				if(i==0){
					bf.append("'demo_node_").append(step.getApprlno()).append("'")
					  .append(":{'name':'").append(step.getStepnm()).append("',")
					  .append("'type':'start',")
					  .append("'left':").append(xywh[0]).append(",")
					  .append("'top':").append(xywh[1]).append(",")
					  .append("'width':").append(xywh[2]).append(",")
					  .append("'height':").append(xywh[3]).append(",")
					  .append("'alt':true}");
				}else{
					bf.append(",")
					  .append("'demo_node_").append(step.getApprlno()).append("'")
					  .append(":{'name':'").append(step.getStepnm()).append("',")
					  .append("'type':'task',")
					  .append("'left':").append(xywh[0]).append(",")
					  .append("'top':").append(xywh[1]).append(",")
					  .append("'width':").append(xywh[2]).append(",")
					  .append("'height':").append(xywh[3]).append(",")
					  .append("'alt':true}");
				}
				i++;
			}
		}
		bf.append("},'lines':{},'areas':{},'initNum':8}");
	    return bf.toString();
	}
	/**
	 *  add by fangzp 2015.1.20
	 * @param designInfo
	 * @return
	 */
	private String flowStep(String designInfo){
		if(designInfo != null && !"".equals(designInfo.trim())){
			designInfo.replace('\'', '"');
		}
	    JsonFormat  jf = new JsonFormat();
	    FlowBean fb = jf.getFlowBean(designInfo);
	    List<LineBean> lineList = jf.getLineBean(fb.getLines());
	    StringBuffer bf = new StringBuffer();
	    int i=0;
	    if(lineList != null && lineList.size()>0)
		for(LineBean lb:lineList){
			if(i==0){
				bf.append(lb.getFrom().substring(10)).append("@").append(lb.getTo().substring(10));
			}else{
				bf.append("@").append(lb.getTo().substring(10));  
			}
		 i++;   
		}
		return bf.toString();
	}
	/**
	 * 获取贷款业务品种多选下拉框
	 * 
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/getDkpz")
	@ResponseBody
	public String getSdBySdtCode(String code,HttpServletRequest request){
		//字典类型编码
		List<BusinessKind> bsnsKindlist =  businessKidServiceImpl.queryAll();
		
		//List<FlowApplystep> list= flowApplystepService.findAll();
		StringBuffer sb=new StringBuffer();
		for(BusinessKind bk : bsnsKindlist){
			sb.append("{");
			sb.append("\"id\":\""+bk.getKndno()+"\",");
			sb.append("\"parentId\":\"0\",");
			sb.append("\"name\":\""+bk.getKndnm()+"\"");
			sb.append("},");
		}
		String result=sb.toString();
		System.out.println(result);
			   result=result.substring(0,result.length()-1);
			   result="{\"treeNodes\":["+result+"]}";
		System.out.println(result);
		return result;
	}
	
	
	/**
	 * 数据字典多选下拉框
	 * @param code
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/getCode")
	@ResponseBody
	public String getSdBySdtCode1(String code, HttpServletRequest request){
		//字典类型编码
		code = request.getParameter("code");
		Entity entity;
		List<SysDictionary> sysDictionarys = sysDictionaryService.findSdBySdtCode(code);
		
		StringBuffer sb=new StringBuffer();
		for(SysDictionary bk : sysDictionarys){
			sb.append("{");
			sb.append("\"id\":\""+bk.getSdvalue()+"\",");
			sb.append("\"parentId\":\"0\",");
			sb.append("\"name\":\""+ bk.getSdkey()+"\"");
			sb.append("},");
		}
		String result=sb.toString();
		System.out.println(result);
			   result=result.substring(0,result.length()-1);
			   result="{\"treeNodes\":["+result+"]}";
		System.out.println(result);
		return result;
	}
}

