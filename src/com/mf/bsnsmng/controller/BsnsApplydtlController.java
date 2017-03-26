package com.mf.bsnsmng.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mf.bsnsmng.entity.BsnsApply;
import com.mf.bsnsmng.entity.BsnsApplydtl;
import com.mf.bsnsmng.entity.BsnsDiya;
import com.mf.bsnsmng.entity.BsnsGrnt;
import com.mf.bsnsmng.entity.BsnsZhiya;
import com.mf.bsnsmng.service.BsnsApplyService;    
import com.mf.bsnsmng.service.BsnsApplydtlService;
import com.mf.bsnsmng.service.BsnsDiyaService;
import com.mf.bsnsmng.service.BsnsGrntService;
import com.mf.bsnsmng.service.BsnsZyService;
import com.mf.common.pub.PubConstants;
import com.mf.flowmng.entity.FlowApprlBase;
import com.mf.util.WebTool;

@Controller
@RequestMapping(value="/mf/bsnsApplydtl")
public class BsnsApplydtlController {
	@Autowired
	private BsnsApplydtlService bsnsApplydtlService;
	@Autowired
	private BsnsApplyService bsnsApplyService;
	@Autowired
	private com.mf.flowmng.service.FlowApprlBaseService   flowApprlBaseService;
	@Autowired
	private BsnsZyService bsnsZyService;
	@Autowired 
	private BsnsDiyaService bsnsDiyaService;
	@Autowired
	private BsnsGrntService bsnsGrntService;
	/**
	 * 提交贷款申请
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
       
	@RequestMapping(value="applySave")
	 public String apply(Model model,BsnsApplydtl  bsnsApplydtl,HttpServletRequest request,HttpServletResponse response){
		
		String result ="{\"status\":true,\"message\":\"已经提交给上级领导！\"}";
			//申请贷款的客户ID
		   String id = request.getParameter("clntId");
		   //  BsnsApply bsnsapply = null;
		   /**
		    * 根据客户号获取申请的基本信息（有且只用一条）
		    *   1、如果有申请信息存在，直接保存到申请详情表里
		    *   2、如果没有的话，提醒“请添加贷款申请信息”
		    *   3、如果申请的时候填写的贷款方式为抵押必须让他填抵押信息、
		    *   
		    */
		   List<BsnsApply> list = bsnsApplyService.queryAll(id);
		  
		   if(list==null||list.size()==0){
			   result ="{\"status\":false,\"message\":\"请填写贷款申请信息！\"}";
		   }else if(list!=null&&list.size()>0){
			   /*
			    * 获取保存的贷款申请的主担保方式
			    * 1、代表质押
			    * 2、代表抵押
			    * 3、代表保证
			    */
			    BsnsApply bsnsApply = list.get(0);
			    String  grtway = bsnsApply.getGrtway();
			    BsnsZhiya bsnsZhiya = bsnsZyService.getById(bsnsApply.getApplyno());
			    BsnsDiya bsnsDiya = bsnsDiyaService.getById(bsnsApply.getApplyno());
			    List<BsnsGrnt> grntlist =bsnsGrntService.getByApplyno(bsnsApply.getApplyno());
			    if("240003".equals(grtway)){
			    	if(bsnsZhiya==null){
			    	 result ="{\"status\":false,\"message\":\"请填写贷款质押信息！\"}";
			    	}else{
			    	  result=ApplyAave(list,bsnsApplydtl,request);
			    	}
			    }
			    if("240002".equals(grtway)){
			    	if(bsnsDiya==null){
			    	  result ="{\"status\":false,\"message\":\"请填写贷款抵押信息！\"}";
			    	}else{
			    		result=ApplyAave(list,bsnsApplydtl,request);
			    	}
			    }
			    if("240004".equals(grtway)){
			    	if(grntlist==null||grntlist.size()==0){
			    	 result ="{\"status\":false,\"message\":\"请填写贷款保证信息！\"}";
			    	}else{
			    		result=ApplyAave(list,bsnsApplydtl,request);
			    	}
			    }
                if("240001".equals(grtway)){
                	result=ApplyAave(list,bsnsApplydtl,request);
                }
			    
			   
			   
		   }
		   WebTool.writeJson(result, response);
		   return null;
	   }
	
	@RequestMapping(value="apply1")
	public String apply1(Model model,HttpServletRequest request){
		
		String clntId = request.getParameter("clntId");
		 List<FlowApprlBase> flowApprlBaseList = flowApprlBaseService.findAll(); 
		 model.addAttribute("clntId", clntId);
		 model.addAttribute("flowApprlBaseList", flowApprlBaseList);
		 return "/mf/bsnsmng/Application/apply";
	}
	
	public String ApplyAave(List<BsnsApply>  list ,BsnsApplydtl  bsnsApplydtl,HttpServletRequest request){
		   /**
		    * 通过流程编号获取流程信息
		    */
		 String result ="{\"status\":true,\"message\":\"已经提交给上级领导！\"}";
		 SimpleDateFormat  sf = new SimpleDateFormat("yyyy-MM-dd");
		 String flowno = request.getParameter("flowno");
		   FlowApprlBase flowApprlBase = flowApprlBaseService.getById(flowno);
		   String flowSteps = flowApprlBase.getFlowsteps();//流程步骤
		   String fristStep = flowSteps.substring(0, flowSteps.indexOf("@")); //当前步骤 
		   BsnsApply bsnsapply = list.get(0);
	       bsnsApplydtl.setApplyno(bsnsapply.getApplyno());//申请编号
		   bsnsApplydtl.setClntnm(bsnsapply.getClntnm());//客户姓名
		   bsnsApplydtl.setClntno(bsnsapply.getClntno());//客户编号
		   bsnsApplydtl.setSrlno("1");//流水号
		   bsnsApplydtl.setKndno(bsnsapply.getKndno());//业务种类编号 
		   int trmmnth = bsnsapply.getTrmmnth();
		   int trmday = bsnsapply.getTrmday();
		   int lntmdy = trmmnth*30+trmday;
		   bsnsApplydtl.setLntmdy(String.valueOf(lntmdy));//贷款期限   申请期限算
		   bsnsApplydtl.setGrtway(bsnsapply.getGrtway());//担保类型
		   bsnsApplydtl.setApplyamnt(bsnsapply.getApplyamnt());//贷款金额
		   bsnsApplydtl.setRegopno(bsnsapply.getBsnsopno());//登记人编号
		   bsnsApplydtl.setRegopnm(bsnsapply.getBsnsopnm());//登记人姓名  操作人
		   bsnsApplydtl.setDepno(bsnsapply.getBsnsopno());//部门编号   当前人部门
		   bsnsApplydtl.setSubdate(sf.format(new Date()));//申请提交日期
		   bsnsApplydtl.setCurstep(fristStep);//当前审批步骤
		   //zhangcong修改(0改成1)    1代表审批中
		   //bsnsApplydtl.setApprvstt("1");//当前审批状态
		   bsnsApplydtl.setApprvstt(PubConstants.Apprvstt_in);//当前审批状态
		   
		   bsnsApplydtl.setApprvtyp(flowApprlBase.getApprltyp());//审批类型
		   bsnsApplydtl.setApprvprcssno(flowno);//审批流程编号
		   bsnsApplydtl.setApprvprcss(flowApprlBase.getFlowsteps());//审批流程步骤
		   bsnsApplydtl.setRemark(bsnsapply.getRemark());//备注
  	   bsnsApplydtl.setTrmyr(bsnsapply.getTrmyr());//期限（年）
  	   bsnsApplydtl.setTrmmnth(bsnsapply.getTrmmnth());//期限（月）
  	      bsnsApplydtl.setTrmday(bsnsapply.getTrmday());//期限（日）
  	      //添加贷款申请之前查询贷款编号是否已经存在，避免重复提交。---add by wangzhi
  	      BsnsApplydtl bsnsApplydtl2 = bsnsApplydtlService.getByApplyno(bsnsapply.getApplyno());
		 if (bsnsApplydtl2 ==null) {
			 bsnsApplydtlService.add(bsnsApplydtl);
			  System.out.println("--------------------贷款申请保存成功--------------------------------");
			   //修改贷款申请基本信息表 APPRVLSTT （审批状态位)
			   BsnsApply bsnsApply1 = new BsnsApply();
			   bsnsApply1.setApplyno(bsnsapply.getApplyno());
			   bsnsApply1.setApprvlstt("1");
			   bsnsApplyService.modify(bsnsApply1);
			   System.out.println("----------修改申请基本信息表成功----------------");
			   return result;
		}
		 return result="{\"status\":false,\"message\":\"贷款申请已经提交，请不要重复提交！\"}";
	}
}
