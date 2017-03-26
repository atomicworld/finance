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
import java.math.BigDecimal;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.sys.service.SysDictionaryService;
import com.mf.util.Common;
import com.mf.util.WebTool;
import com.mf.bsnsmng.entity.BsnsApply;
import com.mf.bsnsmng.entity.Client;
import com.mf.bsnsmng.service.BsnsDiyaService;
import com.mf.bsnsmng.service.BsnsZyService;
import com.mf.bsnsmng.service.ClientService;
import com.mf.businessParam.service.impl.BusinessKindServiceImpl;
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
@RequestMapping(value="/mf/cntrtmng/bsnsExtend")
public class BsnsExtendController {
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
	private BsnsBillService bsnsBillService;
	@Autowired
	private BsnsRepaylogService bsnsRepaylogService;
	@Autowired
	private BsnsRepayplanService bsnsRepayplanService;
	@Autowired
	private BsnsExtendService bsnsExtendService;
	@Autowired
	private BsnsLnmainService bsnsLnmainService;
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
	 * 跳转到贷款发放页面显示待贷款发放合同信息页面
	 * @return
	 */
	@RequestMapping(value="/extendmanager.html")
	public String extendmanager(Model model,HttpServletRequest request){
		String cntrctno="";
		//正常还款
			String dueno = request.getParameter("bsnsno");
			model.addAttribute("bsnsno",dueno);
			//借据信息
			BsnsBill bsnsbill=bsnsBillService.getById(dueno);
			model.addAttribute("bsnsbill",bsnsbill);
			//已还款信息
			BsnsRepaylog bsnsrepaylog=new BsnsRepaylog();
			bsnsrepaylog.setBsnsno(dueno);//借据号
			BigDecimal a=new BigDecimal(0.0);
			BigDecimal b=new BigDecimal(0.0);
			BigDecimal c=new BigDecimal(0.0);
			List<BsnsRepaylog> bsnsrepaylogList=bsnsRepaylogService.queryAll(bsnsrepaylog);
			for(int i=0;i<bsnsrepaylogList.size();i++){
				a=a.add(bsnsrepaylogList.get(i).getRcvprinamnt());//实收金额
				b=b.add(bsnsrepaylogList.get(i).getRcvinstamnt());//实收利息
				c=c.add(bsnsrepaylogList.get(i).getDiscountamnt());//优惠金额
			}

			bsnsrepaylog.setRcvprinamnt(a);
			bsnsrepaylog.setRcvinstamnt(b);
			bsnsrepaylog.setDiscountamnt(c);
			model.addAttribute("bsnsrepaylog",bsnsrepaylog);
			
			BigDecimal qkbj=new BigDecimal(0.0);//欠款本金
			BigDecimal whbj=new BigDecimal(0.0);//未还本金
			//计算欠款本金和未还本金
			List<BsnsRepaylogList>list= bsnsRepaylogService.getByDuenoCount(dueno);
			for(int i=0;i<list.size();i++){
				if(list.get(i)!=null)
				if(list.get(i).getCurrepayamnt()!=null&&list.get(i).getRcvprinamnt()!=null){
					qkbj=list.get(i).getCurrepayamnt().subtract(list.get(i).getRcvprinamnt());
				}else if(list.get(i).getCurrepayamnt()!=null){
					qkbj=list.get(i).getCurrepayamnt();
				}
			}
			whbj=bsnsbill.getDueamnt().subtract(bsnsrepaylog.getRcvprinamnt());
			model.addAttribute("qkbj",qkbj);
			model.addAttribute("whbj",whbj);
		
		
		//合同信息
		cntrctno=bsnsbill.getCntrctno();
		BsnsCntrct bsnscntrct=bsnsCntrctService.getById(cntrctno);//获取合同信息
		//展期信息
		String extno = bsnsbill.getExtno();  //最新一次展期
		if(!"".equals(extno) && extno != null){
			BsnsExtend bsnsExtend = bsnsExtendService.getById(extno);
			model.addAttribute("bsnsExtend",bsnsExtend);
		}
		model.addAttribute("bsnscntrct",bsnscntrct);
		return "/mf/cntrtmng/cntrctextend/extendmanager";
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
	 * 更新修改的信息
	 * @param model
	 * @param bsnsrepayplan
	 * @return
	 */
	@RequestMapping(value="extend",method=RequestMethod.POST)
	public String updateBsnsRepayplan(Model model,BsnsExtend bsnsExtend,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";
		try {
			bsnsExtendService.extend(bsnsExtend);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;		
		
	}
	
}

