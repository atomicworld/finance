/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */


package com.mf.cntrtmng.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.org.entity.Operator;
import com.mf.sys.entity.SysDictionary;
import com.mf.sys.service.SysDictionaryService;
import com.mf.util.Common;
import com.mf.util.FormatDateUtil;
import com.mf.util.WebTool;
import com.mf.bsnsmng.entity.BsnsApplydtl;
import com.mf.bsnsmng.entity.BsnsDiya;
import com.mf.bsnsmng.entity.BsnsZhiya;
import com.mf.bsnsmng.entity.Client;
import com.mf.bsnsmng.service.BsnsApplydtlService;
import com.mf.bsnsmng.service.BsnsDiyaService;
import com.mf.bsnsmng.service.BsnsZyService;
import com.mf.bsnsmng.service.ClientService;
import com.mf.businessParam.entity.BusinessKind;
import com.mf.businessParam.service.impl.BusinessKindServiceImpl;
import com.mf.client.entity.ClntClient;
import com.mf.cntrtmng.entity.*;
import com.mf.cntrtmng.service.*;
import com.mf.common.pub.PubConstants;
import com.mf.util.*;
/**
 * @author 
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/cntrtmng/")
public class BsnsCntrctController {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	@Autowired
	private BsnsCntrctService bsnsCntrctService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private BsnsZyService bsnsZyService;
	@Autowired
	private BsnsDiyaService bsnsDiyaService; 
	@Autowired
	private BusinessKindServiceImpl businessKindService;
	@Autowired
	private SysDictionaryService sysDictionaryService;
	@Autowired
	private BsnsApplydtlService bsnsApplydtlService;
	/** binder用于bean属性的设置 */
	@InitBinder  
	public void initBinder(WebDataBinder binder) {  
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));  
	}
	   
	/**
	 * 增加了@ModelAttribute的方法可以在本controller方法调用前执行,可以存放一些共享变量,如枚举值,或是一些初始化操作
	 */
	@ModelAttribute
	public void init(ModelMap model) {
		model.put("now", new java.sql.Timestamp(System.currentTimeMillis()));
	}
	
	/**
	 * 跳转到listlabel标签页，待签订合同，已签订合同
	 * @return
	 */
	@RequestMapping(value="listlabel")
	public String listlabel(){
		return "/mf/cntrtmng/pendcntrt/listlabel";
	}
	
	/**
	 * 跳转已签订合同list
	 * @return
	 */
	@RequestMapping(value="signEnd")
	public String signEnd(){
		return "/mf/cntrtmng/pendcntrt/signEnd";
	}
	
	/**
	 * 跳转到待签订合同list
	 * @return
	 */
	@RequestMapping(value="signNew")
	public String signNew(){
		return "/mf/cntrtmng/pendcntrt/signNew";
	}
  
  	
  
     /*
	 * 跳转到list展示页面显示待处理合同信息
	 * @return
	 */
	@RequestMapping(value="/list.html")
	public String list(){
		return "/mf/cntrtmng/pendcntrt/list";
	}
	
	/**
	 * 跳转到贷款发放页面显示待贷款发放合同信息页面
	 * @return
	 */
	@RequestMapping(value="/outlist.html")
	public String outlist(){
		return "/mf/cntrtmng/loanout/list";
	}
	
	/**
	 * post方式分页查询待贷款发放合同信息列表
	 * @param model
	 * @param bsnscntrct
	 * @return map
	 */
	@RequestMapping(value="showoutlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showoutlist(Model model,BsnsCntrct bsnscntrct,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		List<String> sttList = new ArrayList<String>();
		sttList.add(PubConstants.CNTRCTSTT_OUTING);//合同正在放款申请中【贷款发放】
		sttList.add(PubConstants.CNTRCTSTT_OUTAPPRED);// 合同申请放款结束，无金额可申请 【对已放款的合同，制定还款计划】
		/**
		 * 贷款发放一般只要有权限就可以发放，不一定是管护人自己		 * 
		 * 所以删除该检索条件（fankb on 20150602）
		 */
		//Operator operator = (Operator)request.getSession().getAttribute("operator");		
		//bsnscntrct.setRegopno(operator.getEmplyno());
		
		pageView = bsnsCntrctService.queryOuting(pageView, sttList, bsnscntrct);
		List<BsnsCntrct> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		return "/mf/cntrtmng/bsnscntrct/add";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param bsnscntrct
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,BsnsCntrct bsnscntrct,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";
		try {
			bsnscntrct.setBsnsrt(bsnscntrct.getApplyrt());//申请利率是执行利息
			bsnscntrct.setRmnamnt(bsnscntrct.getCntrctamnt());//合同金额是可发放余额
			bsnsCntrctService.add(bsnscntrct);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +"fail"+"\"}"; //WebUtil.getErrorMsg(e.getMessage())
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	
	/**
	 * post方式分页查询 显示待处理合同
	 * @param model
	 * @param bsnscntrct
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,BsnsCntrct bsnscntrct,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = bsnsCntrctService.queryPend(pageView, bsnscntrct);
		List<BsnsCntrct> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 显示待签订合同list
	 * @param model
	 * @param bsnscntrct
	 * @param request
	 * @return
	 */
	@RequestMapping(value="showSignNew",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showSignNew(Model model,BsnsCntrct bsnscntrct,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		//合同管理，各客户经理只管理自己的合同
		Operator operator = (Operator)request.getSession().getAttribute("operator");		
		bsnscntrct.setMngopno(operator.getEmplyno()); //管护人
		
		bsnscntrct.setCntrctstt(PubConstants.CNTRCTSTT_NEW);
		pageView = bsnsCntrctService.querySignNew(pageView, bsnscntrct);
		List<BsnsCntrct> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	
	/**
	 * 显示已签订合同list
	 * @param model
	 * @param bsnscntrct
	 * @param request
	 * @return
	 */
	@RequestMapping(value="showSignEnd",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showSignEnd(Model model,BsnsCntrct bsnscntrct,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		bsnscntrct.setCntrctstt(PubConstants.CNTRCTSTT_NEW);
//		String str = "(" + PubConstants.CNTRCTSTT_SIGNED + "," + PubConstants.CNTRCTSTT_OUTING + ")";
//		bsnscntrct.setCntrctstt(str);
		Operator operator = (Operator)request.getSession().getAttribute("operator");
		bsnscntrct.setMngopno(operator.getEmplyno());
		pageView = bsnsCntrctService.querySignEnd(pageView, bsnscntrct);
		List<BsnsCntrct> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param bsnscntrctId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String cntrctno, HttpServletResponse response){
		String result=null;
		try{
			bsnsCntrctService.delete(cntrctno);
		    result="{\"status\":1,\"message\":\"删除成功！\"}";
		}catch(Exception e){
			result="{\"status\":0,\"message\":\"" +"fail"+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	/**
	 * 查询&修改单条记录
	 * @param model
	 * @param bsnscntrctId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String bsnscntrctId,int typeKey){
		BsnsCntrct bsnscntrct = bsnsCntrctService.getById(bsnscntrctId);
		model.addAttribute("bsnscntrct", bsnscntrct);
		if(typeKey == 1){
			//显示合同签订
			return "/mf/cntrtmng/pendcntrt/sign";
		}else if(typeKey == 2){
			//显示放款申请
			return "/mf/cntrtmng/pendcntrt/applyout";
		}else{
			return "/mf/cntrtmng/pendcntrt/view_1";
		}
	}
	
	/**
	 * 合同签订操作,即更新合同起止日期和签订日期
	 * @param model
	 * @param bsnscntrct
	 * @return
	 */
	@RequestMapping(value="sign",method=RequestMethod.POST)
	public String signBsnsCntrct(Model model,BsnsCntrct bsnscntrct,HttpServletResponse response){		
		//设置合同号给抵押表中
		
		String result="{\"msg\":\"suc\"}";
		try {
			
			//更新合同信息表的相应字段信息
			bsnsCntrctService.signCntrct(bsnscntrct);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +"fail"+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;	
	}
	
	/**
	 * 跳转已完结合同
	 * @return
	 */
	@RequestMapping(value="wjlist")
	public String wjlist(){
		return "/mf/cntrtmng/loanout/wj/list";
	}
	
	
	/**
	 * 已完结合同
	 * @param model
	 * @param bsnscntrct
	 * @param request
	 * @return
	 */
	@RequestMapping(value="cntrctEnd",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> cntrctEnd(Model model,BsnsCntrct bsnscntrct,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		bsnscntrct.setCntrctedflg(PubConstants.CNTRCTEDFLG_YES);
		pageView = bsnsCntrctService.queryCntrctEnd(pageView, bsnscntrct);
		List<BsnsCntrct> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
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
	@ResponseBody
	public String deleteAll(String[] ids, Model model, HttpServletResponse response) {
		String result = null;
		try {
			for (String id : ids) {
				bsnsCntrctService.delete(id);
			}
			result = "{\"status\":1,\"message\":\"删除成功！\"}";
		} catch (Exception e) {
			result="{\"status\":0,\"message\":\"" +"fail"+"\"}";
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
		return "/mf/cntrtmng/bsnscntrct/upload";
	}
	//=====================================================wyy
    /**
     * @param model
     * @param request
     * @return
     * 合同补录页面
     */
    @RequestMapping(value="clientList")
    public String clientList(Model model,HttpServletRequest request){
    	return "/mf/cntrtmng/bsnscntrct/list";
    }
    /**
     * @param model
     * @param request
     * @retur
     * 客户列表
     */
    @RequestMapping(value="infoList")
    public String getInfoList(Model model,HttpServletRequest request){
    	String clntType = request.getParameter("clntType");
    	model.addAttribute("clntType", clntType);
    	return "/mf/cntrtmng/bsnscntrct/childList";  
    }
    
    /**
     * @param model
     * @param request
     * @return
     * 合同页面
     */
    @RequestMapping(value="agreement")
    public String agreement(Model model,HttpServletRequest request){
    	String clntId = request.getParameter("clntId");
    	model.addAttribute("clntId", clntId);
    	return "/mf/cntrtmng/bsnscntrct/agreement/agreement";  
    }
    /**
     * @param model
     * @param request
     * @return
     * 合同列表
     */
    @RequestMapping(value="agreementList")
    public String agreementList(Model model,HttpServletRequest request){
    	String clntId = request.getParameter("clntId");
    	model.addAttribute("clntId", clntId);
    	return "/mf/cntrtmng/bsnscntrct/agreement/agreementList";  
    }
    /**
     * @param model
     * @param request
     * @return
     * 跳转补录合同表单页面
     */
    @RequestMapping(value="agreementAdd")
    public String agreementAdd(Model model,HttpServletRequest request){
    	String clntId = request.getParameter("clntId");
    	Client client=clientService.getById(clntId);
    	
    	String a = bsnsCntrctService.getByClntNo(FormatDateUtil.getFormatDate("yyyyMMdd"));
    	Operator operator = (Operator)request.getSession().getAttribute("operator");
    	String cntrctno=null;
	    if(a==null){
 	    	  a="000001";
 	    	  cntrctno =  operator.getDptno()+FormatDateUtil.getFormatDate("yyyyMMdd")+a;//合同编号
 	      }else{
 	    	 cntrctno=operator.getDptno()+FormatDateUtil.getFormatDate("yyyyMMdd")+a.substring(2);
 	      }
	    SysDictionary sysDictionary = sysDictionaryService.findByCode("8000");
	    cntrctno=sysDictionary.getSdkey()+cntrctno;
    	model.addAttribute("client",client);
    	model.addAttribute("cntrctno",cntrctno);
    	return "/mf/cntrtmng/bsnscntrct/agreement/agreementAdd";  
    }
    /**
     * @param model
     * @param request
     * @return
     * 跳转补录合同详细页面
     */
    @RequestMapping(value="viewInfo")
    public String viewInfo(Model model,HttpServletRequest request){
    	String cntrctno = request.getParameter("cntrctno");
    	String clntId=request.getParameter("clntId");
    	model.addAttribute("cntrctno",cntrctno);
    	Client client=clientService.getById(clntId);
    	model.addAttribute("client",client);
    	return "/mf/cntrtmng/bsnscntrct/agreement/edit/viewInfo";  
    }
    @RequestMapping(value="applyInfo")
    public String applyInfo(Model model,HttpServletRequest request){
    	String applyno = request.getParameter("applyno");
    	String clntId=request.getParameter("clntId");
    	model.addAttribute("applyno",applyno);
    	Client client=clientService.getById(clntId);
    	model.addAttribute("client",client);
    	BsnsApplydtl bsnsApplydtl= bsnsApplydtlService.getByApplyno(applyno);
    	if (bsnsApplydtl.getApprvstt().equals("98")) {
    		return "/mf/util/apply/viewInfo1"; 
		}else {
			return "/mf/util/apply/viewInfo"; 
		}
    	 
    }
    /**
	 * 查询单条记录
	 * @param model
	 * @param bsnscntrctId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getByCntrctno")
	public String getById(Model model,String cntrctno,String clntType){
		BsnsCntrct bsnscntrct = bsnsCntrctService.getById(cntrctno);
		model.addAttribute("bsnscntrct", bsnscntrct);
		model.addAttribute("clntType",clntType);
	    return "/mf/cntrtmng/bsnscntrct/agreement/edit/agreementView"; 
	}
	/**
	 * 查询&修改单条记录
	 * @param model
	 * @param bsnscntrctId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="agreementEdit")
	public String agreementEdit(Model model,String cntrctno,String clntType){
		BsnsCntrct bsnscntrct = bsnsCntrctService.getById(cntrctno);
		model.addAttribute("bsnscntrct", bsnscntrct);
		model.addAttribute("clntType",clntType);
	    return "/mf/cntrtmng/bsnscntrct/agreement/edit/agreementEdit"; 
	}
	/**
	 * 保存新增
	 * @param model
	 * @param bsnscntrct
	 * @return
	 */
	@RequestMapping(value="update")
	public String update(Model model,BsnsCntrct bsnscntrct,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";
		try {
			
			bsnsCntrctService.update(bsnscntrct);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +"fail"+"\"}"; //WebUtil.getErrorMsg(e.getMessage())
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	 /**
     * @param model
     * @param request
     * @return
     * 附属合同信息
     */
    @RequestMapping(value="otherInfo")
    public String otherInfo(Model model,HttpServletRequest request){
    	String cntrctno = request.getParameter("cntrctno");
    	model.addAttribute("cntrctno",cntrctno);
    	String clntType=request.getParameter("clntType");
    	model.addAttribute("clntType",clntType);
    	return "/mf/cntrtmng/bsnscntrct/agreement/edit/otherInfo";  
    }
    /**
     * @param model
     * @param request
     * @return
     * 附属合同信息 质押信息添加
     */
    @RequestMapping(value="pledgeAdd")
    public String pledgeAdd(Model model,HttpServletRequest request){
    	String cntrctno = request.getParameter("cntrctno");
    	BsnsZhiya bsnsZhiya= bsnsZyService.getByCntrctno(cntrctno);
    	String clntType=request.getParameter("clntType");
		if(bsnsZhiya==null){
			BsnsCntrct bsnscntrct = bsnsCntrctService.getById(cntrctno);
			model.addAttribute("bsnscntrct", bsnscntrct);
			model.addAttribute("clntType",clntType);
			return "/mf/cntrtmng/bsnscntrct/agreement/edit/pledge/pledgeAdd";    
		}else{
			return  "redirect:/mf/cntrtmng/pledgeView.html?cntrctno="+cntrctno+"&clntType="+clntType;
		}
    }
    
    /**
     * @param model
     * @param request
     * @return
     * 附属合同信息 质押信息添加
     */
    @RequestMapping(value="pledgeView")
    public String pledgeView(Model model,HttpServletRequest request){
    	String cntrctno = request.getParameter("cntrctno");
    	BsnsZhiya bsnsZhiya= bsnsZyService.getByCntrctno(cntrctno);
    	model.addAttribute("bsnsZhiya", bsnsZhiya);
    	String clntType=request.getParameter("clntType");
    	model.addAttribute("clntType",clntType);
		return  "/mf/cntrtmng/bsnscntrct/agreement/edit/pledge/pledgeView";
    }
    
    /**
     * @param model
     * @param request
     * @return
     * 附属合同信息 质押信息修改
     */
    @RequestMapping(value="pledgeEdit")
    public String pledgeEdit(Model model,HttpServletRequest request){
    	String cntrctno = request.getParameter("cntrctno");
    	BsnsZhiya bsnsZhiya= bsnsZyService.getByCntrctno(cntrctno);
    	model.addAttribute("bsnsZhiya", bsnsZhiya);
    	String clntType=request.getParameter("clntType");
    	model.addAttribute("clntType",clntType);
		return  "/mf/cntrtmng/bsnscntrct/agreement/edit/pledge/pledgeEdit";
    }
    
    /**
	    * 附属合同信息 质押信息修改
	    */
	   @RequestMapping(value="pledgeEditUi")
	   public String pledgeEditUi(Model model,BsnsZhiya bsnsZhiya,HttpServletResponse response){
		   String result="{\"msg\":\"suc\"}";
		   bsnsZyService.modifyCntrct(bsnsZhiya);
		   System.out.println("---------------修改质押申请信息成功-------------------");
		   WebTool.writeJson(result, response);
		   return null;
	     }
	   
	   /**
	    * 删除质押信息
	    */
	   @RequestMapping(value="pledgeDel")
	   public String pledgeDel(Model model,HttpServletRequest request,HttpServletResponse response){
		   String result ="{\"status\":true,\"message\":\"删除成功！\"}";
		   String cntrctno = request.getParameter("cntrctno");
		   System.out.println("====="+cntrctno);
		   bsnsZyService.deleteCntrctno(cntrctno);
		   WebTool.writeJson(result, response);
		   return null;
	   }
    /**
     * @param model
     * @param request
     * @return
     * 附属合同信息 抵押信息添加
     */
    @RequestMapping(value="diyaAdd")
    public String diyaAdd(Model model,HttpServletRequest request){
    	String cntrctno = request.getParameter("cntrctno");
    	BsnsDiya bsnsDiya = bsnsDiyaService.getByCntrctno(cntrctno);
    	String clntType=request.getParameter("clntType");
		if(bsnsDiya==null){
			BsnsCntrct bsnscntrct = bsnsCntrctService.getById(cntrctno);
			model.addAttribute("bsnscntrct", bsnscntrct);
			model.addAttribute("clntType",clntType);
			return "/mf/cntrtmng/bsnscntrct/agreement/edit/diya/diyaAdd";  
		}else{
			return  "redirect:/mf/cntrtmng/diyaView.html?cntrctno="+cntrctno+"&clntType="+clntType;
		}
    	
    }
    /**
     * @param model
     * @param request
     * @return
     * 附属合同信息 抵押信息修改
     */
    @RequestMapping(value="diyaView")
    public String diyaView(Model model,HttpServletRequest request){
    	 String cntrctno = request.getParameter("cntrctno");
    	 BsnsDiya bsnsDiya = bsnsDiyaService.getByCntrctno(cntrctno);
		 model.addAttribute("bsnsDiya", bsnsDiya);
		 String clntType=request.getParameter("clntType");
		 model.addAttribute("clntType",clntType);
		return "/mf/cntrtmng/bsnscntrct/agreement/edit/diya/diyaView";  
    }
    
    /**
     * @param model
     * @param request
     * @return
     * 附属合同信息 抵押信息修改
     */
    @RequestMapping(value="diyaEdit")
    public String diyaEdit(Model model,HttpServletRequest request){
    	 String cntrctno = request.getParameter("cntrctno");
    	 BsnsDiya bsnsDiya = bsnsDiyaService.getByCntrctno(cntrctno);
		 model.addAttribute("bsnsDiya", bsnsDiya);
		 String clntType=request.getParameter("clntType");
		 model.addAttribute("clntType",clntType);
		return "/mf/cntrtmng/bsnscntrct/agreement/edit/diya/diyaEdit";  
    }
  
    	/**
    	 * 附属合同信息 保证人信息list页面
    	 */
    	@RequestMapping(value="bsnsgrnt")
    	public String bsnsgrnt(Model model,HttpServletRequest request){
    		String cntrctno = request.getParameter("cntrctno");
    		model.addAttribute("cntrctno",cntrctno);
    		return "/mf/cntrtmng/bsnscntrct/agreement/edit/bsnsgrnt/list";
    	}
    	
    	/**
    	 * @param model
    	 * @param cntrctno
    	 * @return
    	 * 添加保证信息
    	 */
    	@RequestMapping(value="addGrnt")
    	public String addGrnt(Model model,String cntrctno){
    		BsnsCntrct bsnscntrct = bsnsCntrctService.getById(cntrctno);
    		model.addAttribute("bsnscntrct", bsnscntrct);
    	    return "/mf/cntrtmng/bsnscntrct/agreement/edit/bsnsgrnt/add"; 
    	}

	
	/**
	* @author wangyaowei
	* @date 2015-3-29下午11:10:21
	* @Title: showNinelist
	* @Description: TODO(查询合同补录)
	* @param model
	* @param bsnscntrct
	* @param request
	* @return
	* @return Map<String,Object>    返回类型
	* @throws
	*/
	@RequestMapping(value="showNinelist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showNinelist(Model model,BsnsCntrct bsnscntrct,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = bsnsCntrctService.queryNine(pageView, bsnscntrct);
		List<BsnsCntrct> list=pageView.getRecords();
		//设置业务种类编号转汉字显示
		List<BusinessKind> type=businessKindService.getTypeAll("");
		Map<String,String> mapType=new HashMap<String,String>();
		for(int i=0;i<type.size();i++){
			mapType.put(type.get(i).getKndno(),type.get(i).getKndnm());
		}
		for(int j=0;j<list.size();j++){
			list.get(j).setKndno(mapType.get(list.get(j).getKndno()));
		}
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param bsnscntrct
	 * @return
	 */
	@RequestMapping(value="addagreement")
	public String addagreement(Model model,BsnsCntrct bsnscntrct,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		Operator operator = (Operator)request.getSession().getAttribute("operator");
		
		try {
		    bsnscntrct.setBsnsrt(bsnscntrct.getApplyrt());//申请利率等于执行利率
			bsnscntrct.setCntrctstt(PubConstants.CNTRCTSTT_HISTORY);//补录合同标记
			bsnscntrct.setBsnsdptno(operator.getDptno());//操作员部门编号
			bsnscntrct.setBsnsopno(operator.getEmplyno());//操作员员工编号
			bsnscntrct.setRegopno(operator.getEmplyno());//员工编号
			bsnscntrct.setRmnamnt(bsnscntrct.getCntrctamnt());
			bsnscntrct.setCntrctedflg(PubConstants.CNTRCTEDFLG_NO);
			bsnsCntrctService.add(bsnscntrct);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +"fail"+"\"}"; //WebUtil.getErrorMsg(e.getMessage())
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	/**
	 * 补录合同保存新增
	 * @param model
	 * @param bsnscntrct
	 * @return
	 * wyy
	 */
	@RequestMapping(value="agreementUpdate")
	public String agreementUpdate(Model model,BsnsCntrct bsnscntrct,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";
		try {
			bsnscntrct.setBsnsrt(bsnscntrct.getApplyrt());//申请利率等于执行利率
			bsnsCntrctService.update(bsnscntrct);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +"fail"+"\"}"; //WebUtil.getErrorMsg(e.getMessage())
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	/**
	 * 跳转已补录合同
	 * @return
	 */
	@RequestMapping(value="bllist")
	public String bllist(){
		return "/mf/cntrtmng/loanout/bl/list";
	}
	
	/**
	 * 查询常规已放款合同
	 * @param model
	 * @param bsnslnout
	 * @param request
	 * @return
	 */
	@RequestMapping(value="showNrmlOuted",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showNrmlOuted(Model model,BsnsCntrct bsnsCntrct, HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		bsnsCntrct.setOutflg(PubConstants.OUTFLG_YES);
		bsnsCntrct.setCntrctstt(PubConstants.CNTRCTSTT_HISTORY);
		pageView = bsnsCntrctService.queryNrmlOuted(pageView, bsnsCntrct);
		List<BsnsLnout> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 查询已放款补录合同
	 * @author xujiuhua
	 * @param model
	 * @param bsnslnout
	 * @param request
	 * @return
	 */
	@RequestMapping(value="showblOuted",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showblOuted(Model model,BsnsCntrct bsnsCntrct, HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		bsnsCntrct.setOutflg(PubConstants.OUTFLG_YES);
		bsnsCntrct.setCntrctstt(PubConstants.CNTRCTSTT_HISTORY);
		pageView = bsnsCntrctService.queryBlOuted(pageView, bsnsCntrct);
		List<BsnsLnout> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 正常合同的已放款
	 * @return
	 */
	@RequestMapping(value="normalfk")
	public String normallist(){
		return "/mf/cntrtmng/loanout/fk/normalfk";
	}
	
	/**
	 * 补录合同的已放款
	 * @return
	 */
	@RequestMapping(value="blfk")
	public String blfk(){
		return "/mf/cntrtmng/loanout/fk/blfk";
	}
		
	/**
	* @author wangyaowei
	* @date 2015-3-24下午11:14:25
	* @Title: exportExcel
	* @Description: TODO(历史合同补录信息导出)
	* @param response
	* @param request
	* @param bsnscntrct
	* @return void    返回类型
	* @throws
	*/
	@RequestMapping(value = "exportExcel")
	public void exportExcel(HttpServletResponse response,HttpServletRequest request,BsnsCntrct bsnscntrct) {
		  //type 判断导出的数据类型是个人用户数据还是公共用户数据
		  
		  WritableWorkbook wbook=null;
		  OutputStream os =null;
		  try { 
			  
			  String username=request.getParameter("username");
			  if(username!=null){
				  String clntname=new String(username.getBytes("iso-8859-1"),"utf-8");
				  bsnscntrct.setClntnm(clntname);
			  }
			  bsnscntrct.setCntrctstt("9");//注明是补录合同
			  List<BsnsCntrct> list=bsnsCntrctService.queryExcel(bsnscntrct);
			  String type="历史补录合同信息表";
			  os= response.getOutputStream();// 取得输出流   
		      response.reset(); // 清空输出流   
		      response.setHeader("Content-disposition", "attachment; filename="+new String(type.getBytes("gbk"),"iso8859-1")+".xls");// 设定输出文件头   
		      response.setContentType("application/msexcel");// 定义输出类型 
		      wbook = Workbook.createWorkbook(os); // 建立excel文件   
		      String tmptitle = "客户信息列表"; // 标题   
		      WritableSheet wsheet = wbook.createSheet(tmptitle, 0); // sheet名称  
		      //设置excel标题   
		      WritableFont wfont = new WritableFont(WritableFont.ARIAL, 12,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,Colour.BLACK);   
		      WritableCellFormat wcfFC = new WritableCellFormat(wfont); 
		      wcfFC.setAlignment(jxl.format.Alignment.CENTRE);
		      wsheet.setColumnView(0,20);//设置列宽
		      wsheet.setColumnView(1,15);
		      wsheet.setColumnView(2,15);
		      wsheet.setColumnView(3,15);
		      wsheet.setColumnView(4,15);
		      wsheet.setColumnView(5,15);
		      wsheet.setColumnView(6,15);
		      wsheet.setColumnView(7,15);
		      //开始生成主体内容    
		      wsheet.addCell(new Label(0, 0, "合同编号",wcfFC)); 
		      wsheet.addCell(new Label(1, 0, "客户名称",wcfFC)); 
		      wsheet.addCell(new Label(2, 0, "业务种类",wcfFC)); 
		      wsheet.addCell(new Label(3, 0, "合同金额(元)",wcfFC));
		      wsheet.addCell(new Label(4, 0, "合同期限",wcfFC));
		      wsheet.addCell(new Label(5, 0, "开始日期",wcfFC));
		      wsheet.addCell(new Label(6, 0, "结束日期",wcfFC));
		      wsheet.addCell(new Label(7, 0, "客户经理",wcfFC));
		      WritableCellFormat format = new WritableCellFormat(); 
		      format.setAlignment(jxl.format.Alignment.CENTRE);
		      for(int j=0;j<list.size();j++){
		    	
		    	BsnsCntrct bsnscntrctRow= list.get(j);
		  		wsheet.addCell(new Label(0, j+1,bsnscntrctRow.getCntrctno(),format));  
		        wsheet.addCell(new Label(1, j+1,bsnscntrctRow.getClntnm(),format));  
		        wsheet.addCell(new Label(2, j+1,bsnscntrctRow.getKndno(),format)); 
		        wsheet.addCell(new Label(3, j+1,bsnscntrctRow.getCntrctamnt().toString(),format)); 
		        wsheet.addCell(new Label(4, j+1,bsnscntrctRow.getApplydate().toString(),format)); 
		        wsheet.addCell(new Label(5, j+1,bsnscntrctRow.getCntrctsdate(),format)); 
		        wsheet.addCell(new Label(6, j+1,bsnscntrctRow.getCntrctedate(),format));
		        wsheet.addCell(new Label(7, j+1,bsnscntrctRow.getRegopno(),format));

		       }
		       //主体内容生成结束           
		       wbook.write(); // 写入文件   
		       }catch(Exception ex) { 
		           ex.printStackTrace(); 
		       }finally{
		        	try {
						wbook.close();
						os.close(); // 关闭流
					} catch (WriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
		         }
		      }  
	
	
	/**
	* @author wangyaowei
	* @date 2015-3-24下午11:46:08
	* @Title: cntrctEndExcel
	* @Description: TODO(完结合同报表导出)
	* @param response
	* @param request
	* @param bsnscntrct
	* @return void 返回类型
	* @throws
	*/
	@RequestMapping(value = "cntrctEndExcel")
	public void cntrctEndExcel(HttpServletResponse response,HttpServletRequest request,BsnsCntrct bsnscntrct) {
		  //type 判断导出的数据类型是个人用户数据还是公共用户数据
		  
		  WritableWorkbook wbook=null;
		  OutputStream os =null;
		  try { 
			  
			  String username=request.getParameter("username");
			  if(username!=null){
				  String clntname=new String(username.getBytes("iso-8859-1"),"utf-8");
				  bsnscntrct.setClntnm(clntname);
			  }
			  bsnscntrct.setCntrctedflg(PubConstants.CNTRCTEDFLG_YES);//注明是完结合同
			  List<BsnsCntrct> list=bsnsCntrctService.queryExcel(bsnscntrct);
			  String type="完结合同信息表";
			  os= response.getOutputStream();// 取得输出流   
		      response.reset(); // 清空输出流   
		      response.setHeader("Content-disposition", "attachment; filename="+new String(type.getBytes("gbk"),"iso8859-1")+".xls");// 设定输出文件头   
		      response.setContentType("application/msexcel");// 定义输出类型 
		      wbook = Workbook.createWorkbook(os); // 建立excel文件   
		      String tmptitle = "完结合同信息表"; // 标题   
		      WritableSheet wsheet = wbook.createSheet(tmptitle, 0); // sheet名称  
		      //设置excel标题   
		      WritableFont wfont = new WritableFont(WritableFont.ARIAL, 12,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,Colour.BLACK);   
		      WritableCellFormat wcfFC = new WritableCellFormat(wfont); 
		      wcfFC.setAlignment(jxl.format.Alignment.CENTRE);
		      wsheet.setColumnView(0,20);//设置列宽
		      wsheet.setColumnView(1,15);
		      wsheet.setColumnView(2,15);
		      wsheet.setColumnView(3,15);
		      wsheet.setColumnView(4,15);
		      wsheet.setColumnView(5,15);
		      //开始生成主体内容    
		      //开始生成主体内容    
		      wsheet.addCell(new Label(0, 0, "合同编号",wcfFC)); 
		      wsheet.addCell(new Label(1, 0, "客户名称",wcfFC)); 
		      wsheet.addCell(new Label(2, 0, "合同金额(元)",wcfFC));
		      wsheet.addCell(new Label(3, 0, "放款日期",wcfFC));
		      wsheet.addCell(new Label(4, 0, "结束日期",wcfFC));
		      wsheet.addCell(new Label(5, 0, "业务种类",wcfFC));
		      WritableCellFormat format = new WritableCellFormat(); 
		      format.setAlignment(jxl.format.Alignment.CENTRE);
		      for(int j=0;j<list.size();j++){
		    	BsnsCntrct bsnscntrctRow= list.get(j);
		    	wsheet.addCell(new Label(0, j+1,bsnscntrctRow.getCntrctno(),format));  
		        wsheet.addCell(new Label(1, j+1,bsnscntrctRow.getClntnm(),format));  
		        wsheet.addCell(new Label(2, j+1,bsnscntrctRow.getCntrctamnt().toString(),format)); 
		        wsheet.addCell(new Label(3, j+1,bsnscntrctRow.getCntrctsdate(),format)); 
		        wsheet.addCell(new Label(4, j+1,bsnscntrctRow.getCntrctedate(),format));
		        wsheet.addCell(new Label(5, j+1,bsnscntrctRow.getKndno(),format)); 
		       }
		       //主体内容生成结束           
		       wbook.write(); // 写入文件   
		       }catch(Exception ex) { 
		           ex.printStackTrace(); 
		       }finally{
		        	try {
						wbook.close();
						os.close(); // 关闭流
					} catch (WriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
		         }
		      }
	
	
	
	/****add by hw  已撤销合同****/
	@RequestMapping(value="revokelist")
	public String revokelist(){
		return "/mf/cntrtmng/revokelist/list";
	}
	
	@RequestMapping(value="cntrctRevoke",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> cntrctRevoke(Model model,BsnsCntrct bsnscntrct,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
//		bsnscntrct.setCntrctedflg(PubConstants.CNTRCTEDFLG_YES);
		bsnscntrct.setCntrctstt(PubConstants.CNTRCTSTT_REVOKE);//设为已撤销
		pageView = bsnsCntrctService.queryCntrctRevoke(pageView, bsnscntrct);
		List<BsnsCntrct> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**	(撤销合同报表导出)	*/
	@RequestMapping(value = "cntrctRevokeExcel")
	public void cntrctRevokeExcel(HttpServletResponse response,HttpServletRequest request,BsnsCntrct bsnscntrct) {
		  //type 判断导出的数据类型是个人用户数据还是公共用户数据
		  WritableWorkbook wbook=null;
		  OutputStream os =null;
		  try { 
			  String username=request.getParameter("username");
			  if(username!=null){
				  String clntname=new String(username.getBytes("iso-8859-1"),"utf-8");
				  bsnscntrct.setClntnm(clntname);
			  }
//			  bsnscntrct.setCntrctedflg(PubConstants.CNTRCTEDFLG_YES);//注明是完结合同
			  bsnscntrct.setCntrctstt(PubConstants.CNTRCTSTT_REVOKE);//注明是撤销合同
//			  List<BsnsCntrct> list=bsnsCntrctService.queryExcel(bsnscntrct);
			  List<BsnsCntrct> list=bsnsCntrctService.queryRevokeExcel(bsnscntrct);
			  String type="撤销合同信息表";
			  os= response.getOutputStream();// 取得输出流   
		      response.reset(); // 清空输出流   
		      response.setHeader("Content-disposition", "attachment; filename="+new String(type.getBytes("gbk"),"iso8859-1")+".xls");// 设定输出文件头   
		      response.setContentType("application/msexcel");// 定义输出类型 
		      wbook = Workbook.createWorkbook(os); // 建立excel文件   
		      String tmptitle = "撤销合同信息表"; // 标题   
		      WritableSheet wsheet = wbook.createSheet(tmptitle, 0); // sheet名称  
		      //设置excel标题   
		      WritableFont wfont = new WritableFont(WritableFont.ARIAL, 12,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,Colour.BLACK);   
		      WritableCellFormat wcfFC = new WritableCellFormat(wfont); 
		      wcfFC.setAlignment(jxl.format.Alignment.CENTRE);
		      wsheet.setColumnView(0,20);//设置列宽
		      wsheet.setColumnView(1,15);
		      wsheet.setColumnView(2,15);
		      wsheet.setColumnView(3,15);
		      //开始生成主体内容    
		      //开始生成主体内容    
		      wsheet.addCell(new Label(0, 0, "合同编号",wcfFC)); 
		      wsheet.addCell(new Label(1, 0, "客户名称",wcfFC)); 
		      wsheet.addCell(new Label(2, 0, "合同金额(元)",wcfFC));
		      wsheet.addCell(new Label(3, 0, "业务种类",wcfFC));
		      WritableCellFormat format = new WritableCellFormat(); 
		      format.setAlignment(jxl.format.Alignment.CENTRE);
		      for(int j=0;j<list.size();j++){
		    	BsnsCntrct bsnscntrctRow= list.get(j);
		    	wsheet.addCell(new Label(0, j+1,bsnscntrctRow.getCntrctno(),format));  
		        wsheet.addCell(new Label(1, j+1,bsnscntrctRow.getClntnm(),format));  
		        wsheet.addCell(new Label(2, j+1,bsnscntrctRow.getCntrctamnt().toString(),format)); 
		        wsheet.addCell(new Label(3, j+1,bsnscntrctRow.getKndno(),format)); 
		       }
		       //主体内容生成结束           
		       wbook.write(); // 写入文件   
		       }catch(Exception ex) { 
		           ex.printStackTrace(); 
		       }finally{
		        	try {
						wbook.close();
						os.close(); // 关闭流
					} catch (WriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
		         }
		      }
	/*****************************************/  
	
}

