package com.mf.aftrmng.controller;

import java.text.SimpleDateFormat;
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

import com.mf.aftrmng.entity.AfterWarnparm;
import com.mf.aftrmng.service.AfterWarnparmService;
import com.mf.bsnsmng.entity.BsnsApply;
import com.mf.bsnsmng.entity.BsnsDiya;
import com.mf.bsnsmng.entity.BsnsZhiya;
import com.mf.bsnsmng.entity.Client;
import com.mf.bsnsmng.service.BsnsApplyService;
import com.mf.bsnsmng.service.BsnsDiyaService;
import com.mf.bsnsmng.service.BsnsZyService;
import com.mf.bsnsmng.service.ClientService;
import com.mf.client.entity.ClntClient;
import com.mf.client.service.ClntClientService;
import com.mf.cntrtmng.entity.BsnsBill;
import com.mf.cntrtmng.entity.BsnsCntrct;
import com.mf.cntrtmng.entity.BsnsRepayplan;
import com.mf.cntrtmng.service.BsnsBillService;
import com.mf.cntrtmng.service.BsnsCntrctService;
import com.mf.cntrtmng.service.BsnsRepayplanService;
import com.mf.sms.client.MessageClient;
import com.mf.sys.entity.CompanyInfo;
import com.mf.util.Common;
import com.mf.util.PageView;
/**
 * @author yangchao
 * @2015-01-27
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/aftrmng/loanwarn/")
public class LoanWarnController {
	
	@Autowired
	private BsnsBillService bsnsBillService;
	@Autowired
	private BsnsCntrctService bsnsCntrctService;
	@Autowired
	private BsnsApplyService bsnsApplyService; 
	@Autowired
	private ClntClientService clntClientService;
	@Autowired
	private AfterWarnparmService afterWarnparmService;
	@Autowired
	private BsnsDiyaService bsnsDiyaService; 
	@Autowired
	private ClientService clientService;
	@Autowired
	private BsnsZyService bsnsZyService;
	@Autowired
	private BsnsRepayplanService bsnsRepayplanService;
	
	/**
	 * @param model
	 * @param request
	 * @return
	 * 查询贷款到期预警列表
	 */
	@RequestMapping(value="loanTimeList")
    public String loanTimeList(Model model,HttpServletRequest request){
    	return "/mf/aftrmng/duewarn/loanTimeList";  
    }
	/**
	 * post方式分页查询
	 * @param model
	 * @param bsnsbill
	 * @return map
	 * 贷款到期预警
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,BsnsBill bsnsbill,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		Map<String, Object> param=new HashMap<String, Object>();
		AfterWarnparm warnparm=new AfterWarnparm();
		warnparm.setWarnnm("贷款到期预警");
		warnparm=afterWarnparmService.findByWarnnm(warnparm);//获取预警时间参数
		param.put("flag", warnparm.getWarnday());
		param.put("clntnm", bsnsbill.getClntnm());
		pageView = bsnsBillService.queryWarn(pageView, param);
		List<BsnsBill> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * @param dueno
	 * @param model
	 * @param request
	 * @return
	 * 查看贷款到期预警详细信息
	 */
	@RequestMapping(value="loanTimeInfo")
	public String loanTimeInfo(String dueno, Model model,  HttpServletRequest request){
		BsnsBill bsnsbill = bsnsBillService.findByDueno(dueno);
		model.addAttribute("bsnsbill", bsnsbill);
		return "/mf/aftrmng/duewarn/infoList";
	}
	
	/**
	 * @param applyNo
	 * @param model
	 * @param request
	 * @return 申请详细信息
	 */
	@RequestMapping(value="applyInfo")
	public String applyInfo(String applyNo, Model model,  HttpServletRequest request){
		BsnsApply bsnsapply = bsnsApplyService.getById(applyNo);
		model.addAttribute("bsnsapply", bsnsapply);
		model.addAttribute("applyNo", bsnsapply.getApplyno());
		
		Client client=clientService.getById(bsnsapply.getClntno());
		model.addAttribute("clntType",client.getClntType());//客户类型
		//质押信息
		BsnsZhiya bsnsZhiya = bsnsZyService.getById(applyNo);
		if(bsnsZhiya != null){
			model.addAttribute("bsnsZhiya", bsnsZhiya);
		}
		//抵押信息
		BsnsDiya bsnsDiya = bsnsDiyaService.getById(applyNo);
		if(bsnsDiya != null){
			model.addAttribute("bsnsDiya", bsnsDiya);
		}
		//保证信息
		
		return "/mf/aftrmng/duewarn/applayInfo";
	}
	
	
	/**
	 * @param cntrctno
	 * @param model
	 * @param request
	 * @return
	 * 合同详细信息
	 */
	@RequestMapping(value="agreementInfo")
	public String agreementInfo(String cntrctno, Model model,  HttpServletRequest request){
		BsnsCntrct bsnscntrct = bsnsCntrctService.getById(cntrctno);
		//判断是否填写了抵押信息，如果没有就不显示按钮
		BsnsDiya bsnsDiya = bsnsDiyaService.getByCntrctno(cntrctno);
		boolean flag = false;
		if (bsnsDiya != null) {
			flag = true;
		}
		//判断是否填写了质押信息，如果没有就不显示按钮
		BsnsZhiya bsnsZhiya = bsnsZyService.getByCntrctno(cntrctno);
		boolean flag1 =false;
		if (bsnsZhiya != null) {
			flag1 = true;
		}
		model.addAttribute("flag1",flag1);
		model.addAttribute("flag",flag);
		model.addAttribute("bsnscntrct", bsnscntrct);
		return "/mf/aftrmng/duewarn/agreementInfo";
	}
	
	/**  20150727  借据打印失效，修改 hw  开始 */
	/**
	 * @param dueno
	 * @param model
	 * 借据详细信息
	 */
	@RequestMapping(value="printDueno")
	public String printDueno(String dueno, Model model,  HttpServletRequest request){
		BsnsBill bsnsbill = bsnsBillService.findByDueno(dueno);
		BsnsCntrct bsnscntrct = bsnsCntrctService.getById(bsnsbill.getCntrctno());
		ClntClient client=clntClientService.getById(bsnscntrct.getClntno());
		model.addAttribute("clntType",client.getClnttype());
		model.addAttribute("bsnscntrct", bsnscntrct);
		model.addAttribute("bsnsbill", bsnsbill);
		return "/mf/aftrmng/duewarn/billInfo";
	}
	/**  20150727  借据打印失效，修改 hw  結束*/

	/**  20150727  计划还款详细信息，新增开始 
	 * @param dueno
	 * @param model
	 * 计划还款详细信息
	 */
	@RequestMapping(value="printSrlno")
	public String printSrlno(String srlno, Model model,  HttpServletRequest request){
		BsnsRepayplan bsnsRepayplan = bsnsRepayplanService.getById(srlno);
		ClntClient client=clntClientService.getById(bsnsRepayplan.getClntno());
		model.addAttribute("clntType",client.getClnttype());
		model.addAttribute("bsnsRepayplan",bsnsRepayplan);
		return "/mf/aftrmng/loanOver/repayplanList";
	}
	/** 新增结束*/
	
	/**
	 * @param dueno
	 * @param model
	 * @param request
	 * @return
	 * wyy
	 * 借据详细信息
	 */
	@RequestMapping(value="bsnsbill")
	public String bsnsbill(String cntrctno, Model model,  HttpServletRequest request){
		BsnsBill bsnsbill = bsnsBillService.findByCntrctno(cntrctno);
		BsnsCntrct bsnscntrct = bsnsCntrctService.getById(bsnsbill.getCntrctno());
		ClntClient client=clntClientService.getById(bsnscntrct.getClntno());
		model.addAttribute("clntType",client.getClnttype());
		model.addAttribute("bsnscntrct", bsnscntrct);
		model.addAttribute("bsnsbill", bsnsbill);
		return "/mf/aftrmng/duewarn/billInfo";
	}
	
	/**
	 * @param model
	 * @param request
	 * @return
	 * 贷款逾期催收预警
	 */
	@RequestMapping(value="loanOverList")
    public String loanOverList(Model model,HttpServletRequest request){
    	return "/mf/aftrmng/loanOver/loanOverList";  
    }
	/**
	 * post方式分页查询
	 * @param model
	 * @param bsnsbill
	 * @return map
	 * 贷款逾期预警
	 */
	@RequestMapping(value="loanOverlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> loanOverlist(Model model,BsnsBill bsnsbill,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		Map<String, Object> param=new HashMap<String, Object>();
		AfterWarnparm warnparm=new AfterWarnparm();
		warnparm.setWarnnm("贷款逾期催收预警");
		warnparm=afterWarnparmService.findByWarnnm(warnparm);//获取预警时间参数
		param.put("flag", warnparm.getWarnday());
		param.put("clntnm", bsnsbill.getClntnm());
		pageView = bsnsBillService.queryOverWarn(pageView, param);
		List<BsnsBill> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	@RequestMapping(value="rtrnOverList")
    public String rtrnOverList(HttpServletRequest request){
    	return "/mf/aftrmng/rtrnOver/rtrnOverList";  
    }
	/**
	 * post方式分页查询
	 * @param model
	 * @param bsnsbill
	 * @return map
	 * 还款到期预警
	 */
	@RequestMapping(value="rtrnOverListShow",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> rtrnOverListShow(Model model,BsnsBill bsnsbill,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		Map<String, Object> param=new HashMap<String, Object>();
		AfterWarnparm warnparm=new AfterWarnparm();
//		warnparm.setWarnnm("还款到期预警");
		warnparm.setWarnnm("还款逾期催收预警");
		warnparm=afterWarnparmService.findByWarnnm(warnparm);//获取预警时间参数
		param.put("flag", warnparm.getWarnday());
		param.put("clntnm", bsnsbill.getClntnm());
		pageView = bsnsBillService.queryRtrnOverWarn(pageView, param);
		List<BsnsBill> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	/**
	 * @param model
	 * @param request
	 * @return
	 * wyy
	 * 页面跳转到还款到期列表
	 */
	@RequestMapping(value="rtrnTimeList")
    public String rtrnTimeList(Model model,HttpServletRequest request){
    	return "/mf/aftrmng/rtrnTime/rtrnTimeList";  
    }
	/**
	 * post方式分页查询
	 * @param model
	 * @param bsnsbill
	 * @return map
	 * 还款逾期催收预警
	 */
	@RequestMapping(value="rtrnTimeListShow",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> rtrnTimeListShow(Model model,BsnsBill bsnsbill,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		Map<String, Object> param=new HashMap<String, Object>();
		AfterWarnparm warnparm=new AfterWarnparm();
//		warnparm.setWarnnm("还款逾期催收预警");
		warnparm.setWarnnm("还款到期预警");
		warnparm=afterWarnparmService.findByWarnnm(warnparm);//获取预警时间参数
		param.put("flag", warnparm.getWarnday());
		param.put("clntnm", bsnsbill.getClntnm());
		pageView = bsnsBillService.queryRtrnTimeWarn(pageView, param);
		List<BsnsBill> list=pageView.getRecords();
		
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}

}