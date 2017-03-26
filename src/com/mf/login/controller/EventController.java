package com.mf.login.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mf.bsnsmng.entity.BsnsApplydtl;
import com.mf.bsnsmng.service.BsnsApplydtlService;
import com.mf.cntrtmng.entity.BsnsCntrct;
import com.mf.cntrtmng.service.BsnsCntrctService;
import com.mf.common.pub.PubConstants;
import com.mf.flowmng.entity.FlowApprler;
import com.mf.flowmng.service.FlowApprlerService;
import com.mf.login.service.EventService;
import com.mf.org.entity.Operator;
import com.mf.util.PageView;

@Controller
@RequestMapping(value="/mf/eventlogin")
public class EventController {
	
	@Autowired
	private EventService eventService;
	@Autowired
	private FlowApprlerService flowApprlerService;
	@Autowired
	private BsnsApplydtlService bsnsApplydtlService;
	@Autowired
	private BsnsCntrctService bsnsCntrctService;

	/**
	 * 取得：待办事项、已办事项、办结事项的列表
	 */
	@RequestMapping(value="/getEvents.html")
	public String getEvents(Model model, HttpServletRequest request, HttpServletResponse response){
		Operator user = (Operator)request.getSession().getAttribute("operator");
		// 1. 查看管理员类型：1：业务管理级别； 2：系统管理级别； 9：开发维护（只有1需要待办事项吧？）
		// 2. 是否接收过 移交的客户
		// 3. 查询贷款申请：
		// 	 2.1 审批权限：flow_apprler
		//   2.2 查询：申请中的需要审批的合同
		// 4. 查询：是否有需要签署的合同
		// 5. 查询：自己结束的合同
		if(user.getOptype().equals("1")){//业务级别管理员
			int isHaveSP = eventService.getFlowApprler(user.getEmplyno());//是否有审批权限
			if(isHaveSP > 0){//具有审批权限的业务员
				//查询：是否有需要审批的合同
				BsnsApplydtl bsnsApplydtl = new BsnsApplydtl();
				FlowApprler flowApprler = flowApprlerService.getById(user.getEmplyno());
				if(flowApprler != null){
				    String flowsteps =  flowApprler.getAppsteps();//审批步骤
				    if(flowsteps.indexOf("@")>0){
			           flowsteps = flowsteps.replace("@", ",");
				    }
				    bsnsApplydtl.setApprvprcss(flowsteps);
				    bsnsApplydtl.setApprvstt(PubConstants.Apprvstt_init);//设置为0.查找待审批的；
				    PageView pageView = new PageView(1);
				    pageView = bsnsApplydtlService.query(pageView, bsnsApplydtl);
				    List<BsnsApplydtl> list_BsnsApplydtl = pageView.getRecords();
				    if(list_BsnsApplydtl.size()>0){//存在需要审批的申请，需要提醒
				    	model.addAttribute("BsnsApplydtl_approve", list_BsnsApplydtl);
				    }
			    }
			}
			//普通业务员流程
			BsnsApplydtl bsnsApplydtl_1 = new BsnsApplydtl();
			bsnsApplydtl_1.setRegopno(user.getEmplyno());
			//1. 查找是否有需要处理的申请的贷款申请（状态为驳回重审或者否决的）
			PageView pageView_1 = new PageView(1);
			pageView_1 = bsnsApplydtlService.queryUndone(pageView_1, bsnsApplydtl_1);
		    List<BsnsApplydtl> list_BsnsApplydtl_1 = pageView_1.getRecords();
		    if(list_BsnsApplydtl_1.size() > 0){
		    	model.addAttribute("BsnsApplydtl_undone",list_BsnsApplydtl_1);
		    }
		    
			//2. 查找是否有已经审批成功的，未签署的合同（新合同）
		    BsnsCntrct bsnscntrct = new BsnsCntrct();
		    bsnscntrct.setMngopno(user.getEmplyno());//管护人
		    bsnscntrct.setCntrctstt(PubConstants.CNTRCTSTT_NEW);//新合同
		    PageView pageView_2 = new PageView(1);
		    pageView_2 = bsnsCntrctService.querySignNew(pageView_2, bsnscntrct);
		    List<BsnsCntrct> list_BsnsCntrct_new = pageView_2.getRecords();
		    if(list_BsnsCntrct_new.size()>0){
		    	model.addAttribute("list_BsnsCntrct_signNew",list_BsnsCntrct_new);
		    }
		    
			//3. 查询：已经完结的合同
		    BsnsCntrct bsnscntrct_3 = new BsnsCntrct();
		    bsnscntrct_3.setMngopno(user.getEmplyno());//管护人
		    bsnscntrct_3.setCntrctedflg(PubConstants.CNTRCTEDFLG_YES);//合同结束
		    PageView pageView_3 = new PageView(1);
		    pageView_3 = bsnsCntrctService.queryCntrctEnd(pageView_3, bsnscntrct_3);
		    List<BsnsCntrct> list_BsnsCntrct_end = pageView_3.getRecords();
		    if(list_BsnsCntrct_end.size()>0){
		    	model.addAttribute("list_BsnsCntrct_end",list_BsnsCntrct_end);
		    }
			
			return "/mf/sys/open_yewu";
			
		}else
			return "/mf/sys/open";
	}
	
}
