
package com.mf.acctmoduel.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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

import com.mf.acctmoduel.entity.AdvancePayMoney;
import com.mf.aftrmng.entity.AfterFvclass;
import com.mf.aftrmng.service.AfterFvclassService;
import com.mf.bsnsmng.entity.BsnsApply;
import com.mf.bsnsmng.service.BsnsApplyService;
import com.mf.bsnsmng.service.LoanuseService;
import com.mf.client.entity.ClntClient;
import com.mf.client.entity.ClntEe;
import com.mf.client.entity.ClntPerson;
import com.mf.client.service.ClntClientService;
import com.mf.client.service.ClntEeService;
import com.mf.client.service.ClntPersonService;
import com.mf.cntrtmng.entity.BsnsBill;
import com.mf.cntrtmng.entity.BsnsCntrct;
import com.mf.cntrtmng.entity.BsnsLnmain;
import com.mf.cntrtmng.entity.BsnsRepaylog;
import com.mf.cntrtmng.entity.BsnsRepaylogList;
import com.mf.cntrtmng.entity.BsnsRepayplan;
import com.mf.cntrtmng.service.BsnsBillService;
import com.mf.cntrtmng.service.BsnsCntrctService;
import com.mf.cntrtmng.service.BsnsLnmainService;
import com.mf.cntrtmng.service.BsnsRepaylogService;
import com.mf.cntrtmng.service.BsnsRepayplanService;
import com.mf.common.pub.PubConstants;
import com.mf.common.util.NOSUtil;
import com.mf.common.util.ReplaceNumber;
import com.mf.common.util.WaterIdGener;
import com.mf.org.entity.Dept;
import com.mf.org.entity.Operator;
import com.mf.org.service.DeptService;
import com.mf.sendFileImpl.entity.BsnsApplyData;
import com.mf.sendFileImpl.service.BsnsApplyDataService;
import com.mf.sendFileImpl.util.LoanUserUtil;
import com.mf.sys.entity.SysDictionary;
import com.mf.sys.service.SysDictionaryService;
import com.mf.sys.service.impl.CompanyInfoServiceImpl;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;

/**      
* 类名称：RepayManagerController   
* 类描述：还款管理
* 创建人：wangyaowei  
* 创建时间：2015-2-3 上午12:37:08   
* 修改人：wangyaowei  
* 修改时间：2015-2-3 上午12:37:08   
*/
@Controller
@RequestMapping(value="/mf/acctmoduel/repaymanager")
public class RepayManagerController {
	
	@Autowired
	private BsnsRepayplanService bsnsRepayplanService;
	@Autowired
	private BsnsBillService bsnsBillService;
	@Autowired
	private BsnsCntrctService bsnsCntrctService;
	@Autowired
	private BsnsRepaylogService bsnsRepaylogService;
	@Autowired
	private SysDictionaryService sysDictionaryService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private BsnsLnmainService bsnsLnmainService;
	@Autowired
	private ClntClientService clntClientService;
	@Autowired
	CompanyInfoServiceImpl  companyInfoService;
	@Autowired
	private ClntEeService clntEeService;
	@Autowired
	private ClntPersonService clntPersonService;
	@Autowired
	private BsnsApplyService bsnsApplyService;
	@Autowired
	private LoanuseService loanuseService;
	@Autowired
	private BsnsApplyDataService bsnsApplyDataService;
	@Autowired
	private AfterFvclassService afterFvclassService;
	/**
	* @author wangyaowei
	* @date 2015-2-3上午1:30:29
	* @Title: index
	* @Description: 正常还款首页list
	* @param model
	* @param request
	* @return String    返回类型
	*/
	@RequestMapping(value="index")
    public String index(Model model,HttpServletRequest request){
    	return "/mf/acctmoduel/normal/index";  
    }
	
	
	/**
	* @author wangyaowei
	* @date 2015-2-5下午6:12:43
	* @Title: indexforward
	* @Description: TODO(提前还款首页)
	* @param model
	* @param request
	*/
	@RequestMapping(value="indexforward")
    public String indexforward(Model model,HttpServletRequest request){
		return "/mf/acctmoduel/forward/index";  
    }
	
	/**
	* @author wangyaowei
	* @date 2015-2-5下午10:36:05
	* @Title: personrate
	* @Description: TODO(调整利率首页)
	*/
	@RequestMapping(value="personrate")
    public String personrate(Model model,HttpServletRequest request){
		return "/mf/acctmoduel/personrate/index";  
    }
	//提前还款信息
	@RequestMapping(value="forwardList")
	public String forwardList(Model model,HttpServletRequest request){
	    return "/mf/acctmoduel/forward/listInfo";  
//	    return "/mf/acctmoduel/forward/listInfo1";  
	}
	//还款信息
	@RequestMapping(value="repay1")
    public String repay1(Model model,HttpServletRequest request){
		try {
		request.setCharacterEncoding("GB2312");
		String name=request.getParameter("clntnm");
		if(name!=null){
			String clntnm=new String(name.getBytes("ISO-8859-1"),"utf-8");
			model.addAttribute("clntnm",clntnm);
		}
		if(request.getParameter("cyclesdt")!=null){
			String cyclesdt=new String(request.getParameter("cyclesdt").getBytes("ISO-8859-1"),"utf-8");
			model.addAttribute("cyclesdt",cyclesdt);
		}
		if(request.getParameter("cycleedt")!=null){
			String cycleedt=new String(request.getParameter("cycleedt").getBytes("ISO-8859-1"),"utf-8");
			model.addAttribute("cycleedt",cycleedt);
		}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "/mf/acctmoduel/normal/repay1";  
    }
	//已还款信息
	@RequestMapping(value="repay2")
    public String repay2(Model model,HttpServletRequest request){
	
		
		String clntnm;
		try {
			String name=request.getParameter("clntnm");//获取参数判断是否为空
			if(name!=null){
				 clntnm=new String(name.getBytes("ISO-8859-1"),"utf-8");
				 model.addAttribute("clntnm",clntnm);
			}
			if(request.getParameter("cyclesdt")!=null){
				String cyclesdt=new String(request.getParameter("cyclesdt").getBytes("ISO-8859-1"),"utf-8");
				model.addAttribute("cyclesdt",cyclesdt);
			}
			if(request.getParameter("cycleedt")!=null){
				String cycleedt=new String(request.getParameter("cycleedt").getBytes("ISO-8859-1"),"utf-8");
				model.addAttribute("cycleedt",cycleedt);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "/mf/acctmoduel/normal/repay2";  
    }
	//利率调整
	@RequestMapping(value="planlist")
    public String planlist(Model model,HttpServletRequest request){
    	return "/mf/acctmoduel/personrate/planlist";  
    }
	//利率调整详细信息
	@RequestMapping(value="rate")
    public String rate(Model model,HttpServletRequest request){
		String srlno=request.getParameter("srlno");
		model.addAttribute("srlno",srlno);
    	return "/mf/acctmoduel/personrate/main";  
    }
	//利率调整修改页面
	@RequestMapping(value="rateInfo")
    public String rateInfo(Model model,HttpServletRequest request){
		String srlno=request.getParameter("srlno");
		//还款计划
		BsnsRepayplan bsnsrepayplan=bsnsRepayplanService.getById(srlno);
		model.addAttribute("bsnsrepayplan",bsnsrepayplan);
		//合同信息
		BsnsCntrct bsnscntrct=bsnsCntrctService.getById(bsnsrepayplan.getCntrctno());//获取合同信息
		model.addAttribute("bsnscntrct",bsnscntrct);
		return "/mf/acctmoduel/personrate/child/repaymanager";  
    }
	
	
	/**
	* @author wangyaowei
	* @date 2015-2-8下午11:39:05
	* @Title: addRate
	* @Description: TODO(更新利率)
	* @return String    返回类型
	*/
	@RequestMapping(value="addRate")
	public String addRate(Model model,BsnsCntrct bsnscntrct,HttpServletResponse response,HttpServletRequest request){
		   String result="{\"msg\":\"suc\"}";
		   try {
			   SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			   bsnsCntrctService.update(bsnscntrct);
		   } catch (Exception e) {
			   result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			   e.printStackTrace();
		   }
		   WebTool.writeJson(result, response);
		   return null;
	}
	/**
	* @author wangyaowei
	* @date 2015-2-3下午5:01:21
	* @Title: showlist
	* @Description: TODO(列表展示还款计划信息)
	* @return Map<String,Object>    返回类型
	*/
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,String repaystt,String dueno,BsnsRepayplan bsnsrepayplan,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		try {
			if(dueno!= null ){	
				bsnsrepayplan.setDueno(dueno);
			}
			if(request.getParameter("clntnm")!= null ){			
				bsnsrepayplan.setClntnm(request.getParameter("clntnm"));
			}
			if(request.getParameter("cyclesdt")!=null){
				bsnsrepayplan.setCyclesdt(request.getParameter("cyclesdt"));
			}
			if(request.getParameter("cycleedt")!=null){				
				bsnsrepayplan.setCycleedt(request.getParameter("cycleedt"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> map=new HashMap<String, Object>(); 
		if("-1".equals(repaystt.trim())){
			//待还款记录
			pageView = bsnsRepayplanService.queryStatus(pageView, bsnsrepayplan);
		}else{
			//已还款信息
			pageView = bsnsRepayplanService.query(pageView, bsnsrepayplan);
		}
		List<BsnsRepayplan> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	* @Title: queryList
	* @Description: TODO(列表展示还款计划信息)
	* @return Map<String,Object>    返回类型
	*/
	@RequestMapping(value="queryList")
    @ResponseBody
	public Map<String, Object> queryList(Model model,String repaystt, String dueno,String cyclesdt,String cycleedt,BsnsRepayplan bsnsrepayplan,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		try {
			if(dueno!= null ){	
				bsnsrepayplan.setDueno(dueno);
			}
			if(cyclesdt!=null){
				bsnsrepayplan.setCyclesdt(cyclesdt);
			}
			if(cycleedt!=null){				
				bsnsrepayplan.setCycleedt(cycleedt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> map=new HashMap<String, Object>();
		if("-1".equals(repaystt.trim())){
			//待还款记录
			pageView = bsnsRepayplanService.query1(pageView, bsnsrepayplan);
		}else{
			//已还款信息
			pageView = bsnsRepayplanService.query2(pageView, bsnsrepayplan);
			/*try{
				//add by hw
				//查询已还款信息，根据 计划还款编号，找到对应的 每一期还款，求和：
				//1.然后根据借据找到所有的  计划还款编号
				List<BsnsRepayplan> list_t = bsnsRepayplanService.getByDueno(dueno);
				List<BsnsRepayplan> list = new ArrayList<BsnsRepayplan>();
				Iterator<BsnsRepayplan> iter = list_t.iterator();
				while(iter.hasNext()){
					//临时记录还款状态的list
					BsnsRepayplan bsnsRepayplan_tmp = iter.next();
					if(!Common.isEmpty(bsnsRepayplan_tmp.getActualrepaydt()) ){//只有还过款的才记录
						//获取 还款计划编号
			            String str = bsnsRepayplan_tmp.getSrlno();
			            //获取还款计划编号的还款日志(一对多)
			            //3.根据计划还款编号，找到对应的 还款 List 求和
			            List<BsnsRepaylog> list_repalog = bsnsRepaylogService.getBySrlno(str);
			            Iterator<BsnsRepaylog> iter_repalog = list_repalog.iterator();
			            BigDecimal yhbj = new BigDecimal(0);//已还本金
			            BigDecimal yhlx = new BigDecimal(0);//已还利息
			            BigDecimal yhall = new BigDecimal(0);//已还总额
			            String pay_date = "0";//最后还款日期
			            while(iter_repalog.hasNext()){
			            	BsnsRepaylog bsnsRepaylog_tmp = iter_repalog.next();
			            	yhbj = yhbj.add( bsnsRepaylog_tmp.getRcvprinamnt() );//实收本金金额
			            	yhlx = yhlx.add( bsnsRepaylog_tmp.getRcvinstamnt() );//实收利息金额
			            	yhall = yhall.add( bsnsRepaylog_tmp.getRcvamnt() );	//实收金额
			            	String tmp = bsnsRepaylog_tmp.getPaydt();//还款日期
			            	//取最大的日期
			            	if( Integer.valueOf(tmp) > Integer.valueOf(pay_date) ){
			            		pay_date = tmp;
			            	}
			            }
			            bsnsRepayplan_tmp.setCurrepayamnt(yhbj);//借用 “应还本金”字段
			            bsnsRepayplan_tmp.setRepayinstamnt(yhlx);//借用“应还利息”字段
			            bsnsRepayplan_tmp.setDueno(yhall.toString());//借用“应还总额”字段
			            bsnsRepayplan_tmp.setCycleedt(pay_date);//借用“最后还款日期”字段
			            list.add(bsnsRepayplan_tmp);
					}
		        } 
				map.put("rows", list); 
				map.put("pager.pageNo", pageView.getPageNow());
				map.put("pager.totalRows", pageView.getRowCount());
				return map;
			}catch(Exception e){
				e.printStackTrace();
			}*/
		}
		List<BsnsRepayplan> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	* @author wangyaowei
	* @date 2015-2-3下午5:30:30
	* @Title: childPage
	* @Description: 查看详细信息页面
	*/
	@RequestMapping(value="childPage")
    public String childPage(Model model,HttpServletRequest request){
			String srlno=request.getParameter("srlno");			
			BsnsRepayplan bsnsrepayplan=bsnsRepayplanService.getById(srlno);
			model.addAttribute("bsnsrepayplan",bsnsrepayplan);
			return "/mf/acctmoduel/normal/main";  
    }
	//还款管理页面
	@RequestMapping(value="repaymanager")
	public String repaymanager(Model model,HttpServletRequest request){
		String cntrctno="";
		//正常还款
		String srlno=request.getParameter("srlno");
		
		//根据还款计划，获取还款计划中应还本金及应还利息（add by fankb）
		//应还利息=还款计划利息 - 还款日志表中已还利息；本金因为计划表中有已还总额，所以不用再计算
		BsnsRepayplan bsnsrepayplan=bsnsRepayplanService.getBySrlNo(srlno);
		model.addAttribute("bsnsrepayplan",bsnsrepayplan);
		//借据信息
		BsnsBill bsnsbill=bsnsBillService.getById(bsnsrepayplan.getDueno());
		model.addAttribute("bsnsbill",bsnsbill);
		//已还款信息
		BsnsRepaylog bsnsrepaylog=new BsnsRepaylog();
		bsnsrepaylog.setSrlno(srlno);
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
		cntrctno=bsnsbill.getCntrctno();
		//合同信息,根据借据号查询对于的合同
		BsnsCntrct bsnscntrct=bsnsCntrctService.getById(cntrctno);//获取合同信息
		model.addAttribute("bsnscntrct",bsnscntrct);
		return "/mf/acctmoduel/normal/child/repaymanager";  
		
	}
	//合同信息
	@RequestMapping(value="agreementInfo")
    public String agreementInfo(Model model,HttpServletRequest request){
		String cntrctno=request.getParameter("cntrctno");
		BsnsCntrct bsnscntrct=bsnsCntrctService.getById(cntrctno);//获取合同信息
		model.addAttribute("bsnscntrct",bsnscntrct);
		return "/mf/acctmoduel/normal/child/agreementInfo";  
    }
	//还款历史
	@RequestMapping(value="repayhistory")
    public String repayhistory(Model model,HttpServletRequest request){
		String cntrectno="";
		String dueno="";
			String srlno=request.getParameter("srlno");
			//还款计划
			BsnsRepayplan bsnsrepayplan=bsnsRepayplanService.getById(srlno);
			model.addAttribute("bsnsrepayplan",bsnsrepayplan);
			//借据信息
			BsnsBill bsnsbill=bsnsBillService.getById(bsnsrepayplan.getDueno());
			cntrectno=bsnsbill.getCntrctno();
			model.addAttribute("bsnsbill",bsnsbill);
			dueno=bsnsrepayplan.getDueno();
		//合同信息
		BsnsCntrct bsnscntrct=bsnsCntrctService.getById(cntrectno);//获取合同信息
		model.addAttribute("bsnscntrct",bsnscntrct);
		//还款历史
		BsnsRepaylog bsnsrepaylog=new BsnsRepaylog();
		bsnsrepaylog.setBsnsno(dueno);
		List<BsnsRepaylog> repaylog=bsnsRepaylogService.queryAll(bsnsrepaylog);
		model.addAttribute("repaylog",repaylog);
		return "/mf/acctmoduel/normal/child/repayhistory";  
    }
	//还款计划
	@RequestMapping(value="repayplan")
    public String repayplan(Model model,HttpServletRequest request){
		String cntrectno="";
		String dueno="";
		BigDecimal qkbj=new BigDecimal(0.0);//欠款本金
		BigDecimal whbj=new BigDecimal(0.0);//未还本金
			String srlno=request.getParameter("srlno");
			//还款计划
			BsnsRepayplan bsnsrepayplan=bsnsRepayplanService.getById(srlno);
			model.addAttribute("bsnsrepayplan",bsnsrepayplan);
			//借据信息
			BsnsBill bsnsbill=bsnsBillService.getById(bsnsrepayplan.getDueno());
			cntrectno=bsnsbill.getCntrctno();
			dueno=bsnsbill.getDueno();
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
			whbj=bsnsbill.getDueamnt().subtract(bsnsrepaylog.getRcvprinamnt());
			model.addAttribute("bsnsrepaylog",bsnsrepaylog);
		
		//合同信息
		BsnsCntrct bsnscntrct=bsnsCntrctService.getById(cntrectno);//获取合同信息
		model.addAttribute("bsnscntrct",bsnscntrct);
		//还款计划
		List<SysDictionary> dic= sysDictionaryService.findSdBySdtCode("2019");
		 Map<String,String> map=new HashMap<String,String>();
		 for(int i=0;i<dic.size();i++){
			 map.put(dic.get(i).getSdvalue(), dic.get(i).getSdkey());
		 }
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		String nowdate=sdf.format(new Date());
		
		List<BsnsRepayplan> planlist=bsnsRepayplanService.getByDueno(dueno);
		for(int j=0;j<planlist.size();j++){
			planlist.get(j).setRepaystt(map.get(planlist.get(j).getRepaystt()));
		}
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
		model.addAttribute("qkbj",qkbj);
		model.addAttribute("whbj",whbj);
		model.addAttribute("planlist",planlist);
			return "/mf/acctmoduel/normal/child/repayplan";  
    }
	@RequestMapping(value="advancelist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> advancelist(Model model,BsnsBill bsnsBill,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		List<SysDictionary> dic=sysDictionaryService.findSdBySdtCode("2002");
		List<Dept> dept=deptService.queryAll();
		Map<String, String> deptmap=new HashMap<String, String>();
		Map<String, String> dicmap=new HashMap<String, String>();
		for(int i=0;i<dic.size();i++){
			dicmap.put(dic.get(i).getSdvalue(),dic.get(i).getSdkey());
		}
		for(int i=0;i<dept.size();i++){
			deptmap.put(dept.get(i).getDptno(),dept.get(i).getDptname());
		}
		
		Map<String, Object> map=new HashMap<String, Object>();
		pageView =bsnsBillService.queryAdvance(pageView, bsnsBill);
		List<AdvancePayMoney> list=pageView.getRecords();
		for(int i=0;i<list.size();i++){
			list.get(i).setBsnsdptno(deptmap.get(list.get(i).getBsnsdptno()));
			list.get(i).setIntrstmd(dicmap.get(list.get(i).getIntrstmd()));
		}
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	* @author wangyaowei
	* @date 2015-2-5上午12:41:16
	* @Title: add
	* @Description: TODO(保存还款信息,并且将还款信息保存到bsnsapplydata中去，方便生成xml文件)
	* @return String 返回类型
	*/
	@RequestMapping(value="add")
	public String add(Model model,BsnsRepaylog logs,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";
		try {
			BsnsLnmain bsnslnmain=bsnsLnmainService.findByBsnsno(logs.getBsnsno());
			double lnblnc=bsnslnmain.getLnblnc().doubleValue();//贷款余额
			double total=logs.getRcvprinamnt().doubleValue();//实还本金
			if(total>lnblnc){
				 result="{\"msg\":\"notice\",\"info\":\"还款本金大于应还本金！\"}";
				 WebTool.writeJson(result, response);
				 return null;
			}
			String logid=WaterIdGener.getWaterId();
			logs.setLogid(logid);//生成主键
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		    String repaystt=request.getParameter("repaystt");//还款状态
		    String srlno=logs.getSrlno();
		    logs.setFinanceflg(repaystt);//还款历史状态
		    
		    //add by hw start
		    String accnum = request.getParameter("accnum");
		    accnum = logs.getAccno() + "|" +accnum;
		    logs.setAccno(accnum);
		    //add by hw end
		    
		    Operator operator = (Operator)request.getSession().getAttribute("operator");
		    //更新【主业务信息表 bsns_lnmain、借据表bsns_bill、还款凭证表、合同表】
		    bsnsRepaylogService.add(logs,operator);
		   
		   // 还款计划表
			BsnsRepayplan bsnsrepayplan=bsnsRepayplanService.getById(srlno);
			bsnsrepayplan.setRepaystt(repaystt);//设置还款状态
			bsnsrepayplan.setActualrepaydt(logs.getPaydt());//更新还款日期
			//实际归还本金金额
			bsnsrepayplan.setCurrepayamnt(bsnsrepayplan.getCurrepayamnt().add(logs.getRcvprinamnt()));
			
			//==更新【累计归还本金金额】， 根据票据号和还款期数号
			double payedSum = bsnsRepayplanService.getMaxPayedSumAsDueNo(bsnsrepayplan.getDueno());			
			bsnsrepayplan.setRepayedprinsum(new BigDecimal(payedSum).add(logs.getRcvprinamnt()) );
			
			bsnsRepayplanService.modify(bsnsrepayplan);
			
			//-----生成提供给广西金融办监管系统用的接口数据 add by Wangzhi------
			BsnsCntrct bsnsCntrct = bsnsCntrctService.findByCntrctno(bsnslnmain.getCntrctno());	
			BsnsApplyData bsnsApplyData = new BsnsApplyData();
			BsnsApply bsnsApply = bsnsApplyService.getById(bsnsCntrct.getApplyno());
			AfterFvclass afterFvclass2 = afterFvclassService.getByCntrctno(bsnslnmain.getCntrctno());
			bsnsApplyData.setConCode(bsnslnmain.getCntrctno());//合同编号
			bsnsApplyData.setConAmount(bsnslnmain.getLnblnc());//贷款金额
			bsnsApplyData.setConSignDate(bsnsCntrct.getCntrctsdate());//合同签订日期
			bsnsApplyData.setConStartDate(bsnsCntrct.getCntrctsdate());//合同有效起始日期
			//根据利率类型判断月利率是多少
			if (bsnsCntrct.getBsrtyp().equals("1")) {
				System.out.println("进入利率类型为1中");
				  double d1 = bsnsCntrct.getApplyrt().doubleValue();
				  BigDecimal b1 = new BigDecimal(d1);
			      BigDecimal b2 = new BigDecimal(12);
			      BigDecimal b3 = new BigDecimal(b1.divide(b2,6,BigDecimal.ROUND_HALF_UP).doubleValue());
			      bsnsApplyData.setConYearRate(b3);//合同月利率
			      bsnsApplyData.setConDelayYearRate(b3);//逾期月利率
			      bsnsApplyData.setYearRate(b3);//贷款月利率
			      bsnsApplyData.setDelayMonRate(b3);//贷款逾期月利率
			}else if (bsnsCntrct.getBsrtyp().equals("2")) {
				bsnsApplyData.setConYearRate(bsnsCntrct.getApplyrt());//合同月利率
				bsnsApplyData.setConDelayYearRate(bsnsCntrct.getApplyrt());//逾期月利率
				bsnsApplyData.setYearRate(bsnsCntrct.getApplyrt());//贷款月利率
				bsnsApplyData.setDelayMonRate(bsnsCntrct.getApplyrt());//贷款逾期月利率
			}else if (bsnsCntrct.getBsrtyp().equals("3")) {
				BigDecimal b4 = bsnsCntrct.getApplyrt().multiply(new BigDecimal(30));
				bsnsApplyData.setConYearRate(b4);//合同月利率
				 bsnsApplyData.setConDelayYearRate(b4);//逾期月利率
				 bsnsApplyData.setYearRate(b4);//贷款月利率
				 bsnsApplyData.setDelayMonRate(b4);//贷款逾期月利率
			}
			bsnsApplyData.setConStatus(1);//合同状态1有效，2合同终止
			bsnsApplyData.setLoanCode(bsnsCntrct.getApplyno());//合同申请编号
			bsnsApplyData.setLoanClass(1);//贷款主体1主贷人，2次贷人，3担保人
			bsnsApplyData.setConType(1);//贷款类别1自营贷款，2委托贷款
			//根据客户类型判断是否个人或者企业
			ClntClient client = clntClientService.getById(bsnslnmain.getClntno());
			
			if (PubConstants.CLNT_TYPE_EE.equals(client.getClnttype())) {
				bsnsApplyData.setCustClass(2);//2企业
			}else if (PubConstants.CLNT_TYPE_PERSON.equals(client.getClnttype())) {
				bsnsApplyData.setCustClass(1);//1个人
			}
			bsnsApplyData.setCustName(client.getClntname());//借款人名称
			bsnsApplyData.setCustDocType(Integer.parseInt(client.getCerttype()));//证件类型
			bsnsApplyData.setCustIdno(client.getCertno());//证件号码
			bsnsApplyData.setCustScale(bsnsApply.getCustScale());//贷款对象规模
			bsnsApplyData.setLoanDate(bsnsCntrct.getCntrctsdate());
			BsnsBill bsnsBill = bsnsBillService.findByDueno(bsnsrepayplan.getDueno());
			bsnsApplyData.setSendDate(bsnsBill.getOutdate());//贷款发放日期
			bsnsApplyData.setEndDate(bsnsCntrct.getCntrctedate());//贷款结束时间
			bsnsApplyData.setExpireDate("");//贷款展期到期时间
			bsnsApplyData.setAmount(bsnsCntrct.getCntrctamnt());//贷款金额
			bsnsApplyData.setSolutionWay(bsnsApply.getSolutionWay());//争议解决方案
			bsnsApplyData.setLoanerType(bsnsApply.getLoanerType());//贷款对象
			bsnsApplyData.setLoanUsage(bsnsApply.getLoanUsage());//贷款用途
			//投向行业useno
			bsnsApplyData.setLoanTrade(LoanUserUtil.getLoanTradeCode(bsnsApply.getUseno()));
			bsnsApplyData.setLoanArea(bsnsApply.getLoanArea());//投向区域
			bsnsApplyData.setRepaymentWay(Integer.parseInt(logs.getPaymode()));//付款方式
			bsnsApplyData.setReturnMode(Integer.parseInt(bsnsApply.getRpmntway()));//计息方式
			bsnsApplyData.setDanbaoMode(Integer.parseInt(bsnsApply.getGrtway()));//担保方式
			bsnsApplyData.setRateProp(Integer.parseInt(bsnsApply.getIntrstmd()));//利率性质
			//委托这块不写默认为空，此功能暂时不使用	
			//五级分类这块，一个合同一个五级分类，从after_fvclass表取，根据合同关联。其他表中的五级分类值以后不再更新。
			bsnsApplyData.setStatus(Integer.parseInt(afterFvclass2.getClsstyp()));//贷款五级分类状态
			bsnsApplyData.setReturnDate(logs.getPaydt());//还款日期
			bsnsApplyData.setRbeginDate(bsnsCntrct.getCntrctsdate());//起息日期
			bsnsApplyData.setRendDate(bsnsCntrct.getCntrctedate());//止息日期
			bsnsApplyData.setDelayFee(logs.getFninstamnt());//收回逾期滞纳金
			bsnsApplyData.setDelayInterest(logs.getOverinstamnt());//收回逾期利息(元)
			bsnsApplyData.setReturnInterest(logs.getRcvinstamnt());//收回利息（元）
			bsnsApplyData.setReturnAmt(logs.getRcvprinamnt());//收回本金
			bsnsApplyData.setIsDelay(Integer.parseInt(bsnsrepayplan.getRepaystt()));//收回状态
			bsnsApplyData.setIsTch(bsnsApply.getIsTch());//是否同城化业务
			bsnsApplyData.setFlag(1);//设置为1代表没有生成xml文件
			bsnsApplyDataService.add(bsnsApplyData);
			//-----wangzhi end------
				
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	
	
	/** 
	 * @author made_in_heaven@foxmail.com
	 * @Description: TODO(打印还款凭证) 
	 * @param @param model
	 * @param @param bsnsbill
	 * @param @param request
	 * @param @return 设定文件 
	 * @date 2015-7-10
	 */ 
	@RequestMapping(value = "printPz")
	public String printPz(Model model,String srlno, HttpServletRequest request) {
		String filename=request.getParameter("filename");
		BsnsRepayplan plan=bsnsRepayplanService.getById(srlno);
		BsnsRepaylog bsnsRepaylog=new BsnsRepaylog();
		bsnsRepaylog.setSrlno(srlno);
		List<BsnsRepaylog> list=bsnsRepaylogService.queryAll(bsnsRepaylog);
		ClntClient client=clntClientService.getById(plan.getClntno());
		 String type=client.getClnttype();
		 
		String clntnm=plan.getClntnm();//名称
		String cntrctno=plan.getCntrctno();//合同号
		
		
		String dates=list.get(0).getPaydt();//还款日期
		String yyyy=dates.substring(0,4);//还款日期年
		String mm=dates.substring(4,6);//还款日期月
		String dd=dates.substring(6,8);//还款日期日
		
		String bankno="";//贷款账号
		if("1".equals(type)){//对公
			ClntEe ee=	clntEeService.getById(plan.getClntno());
			bankno=ee.getLncardno();//贷款卡号
		}else{
			ClntPerson person=clntPersonService.findByClntno(plan.getClntno());
			bankno=person.getCardid();//贷款卡号
		}
	     //
		//String payno="1";//付款账号
		//String bankname="1";//开户银行
		BigDecimal lixis=BigDecimal.ZERO;
		BigDecimal benjins=BigDecimal.ZERO;
		for(int i=0;i<list.size();i++){
			benjins=benjins.add(list.get(i).getRcvprinamnt());//本金
			lixis=lixis.add(list.get(i).getRcvinstamnt());//利息
		}
		String repayamnt=NOSUtil.change((lixis.add(benjins)).doubleValue());//大写金额
		String sxf="0";//偿还手续费
		String wyj="0";//偿还违约金
		String lixi=lixis.toString();//偿还利息
		String benjin=benjins.toString();//偿还本金
		
		String yssxf="0";//应收手续费
		String yswyj="0";//应收违约金
		
		String yhlixi=plan.getRepayinstamnt().toString();//应还利息
		String yhbenjin=plan.getCurrepayamnt().toString();//应还本金
		
		StringBuffer params=new StringBuffer();
		params.append(ReplaceNumber.prase((lixis.add(benjins)).doubleValue(),7));//数字金额
		params.append("clntnm,"+clntnm);
		params.append(";cntrctno,"+cntrctno);
		params.append(";repayamnt,"+repayamnt);
		
		params.append(";yyyy,"+yyyy);
		params.append(";mm,"+mm);
		params.append(";dd,"+dd);
		
		params.append(";bankno,"+bankno);
		//params.append(";payno,"+payno);
		//params.append(";bankname,"+bankname);
		
		params.append(";sxf,"+sxf);
		params.append(";wyj,"+wyj);
		params.append(";lixi,"+lixi);
		params.append(";benjin,"+benjin);
		
		params.append(";yssxf,"+yssxf);
		params.append(";yswyj,"+yswyj);
		params.append(";yhlixi,"+yhlixi);
		params.append(";yhbenjin,"+yhbenjin);
		
		System.out.println("======test========="+params.toString().trim());
		model.addAttribute("params", params.toString());
		model.addAttribute("filename", filename);
		return "/mf/temp/word";
	}
	@RequestMapping(value = "printHistory")
	public String printHistory(Model model,String logid, HttpServletRequest request) {
		String filename=request.getParameter("filename");
		BsnsRepaylog log=bsnsRepaylogService.getById(logid);
		BsnsRepayplan plan=bsnsRepayplanService.getById(log.getSrlno());
		ClntClient client=clntClientService.getById(plan.getClntno());
		 String type=client.getClnttype();
		 
		String clntnm=plan.getClntnm();//名称
		String cntrctno=plan.getCntrctno();//合同号
		
		String dates=log.getPaydt();//还款日期
		String yyyy=dates.substring(0,4);//还款日期年
		String mm=dates.substring(4,6);//还款日期月
		String dd=dates.substring(6,8);//还款日期日
		
		String bankno="";//贷款账号
		if("1".equals(type)){//对公
			ClntEe ee=	clntEeService.getById(plan.getClntno());
			if(ee !=null && ee.getLncardno() !=null){
				bankno=ee.getLncardno();//贷款卡号
			}
		}else{
			ClntPerson person=clntPersonService.findByClntno(plan.getClntno());
			if(person !=null && person.getCardid() !=null){
				bankno=person.getCardid();//贷款卡号
			}
		}
	     //
		//String payno="1";//付款账号
		//String bankname="1";//开户银行
		BigDecimal lixis=BigDecimal.ZERO;
		BigDecimal benjins=BigDecimal.ZERO;
		benjins=benjins.add(log.getRcvprinamnt());//本金
		lixis=lixis.add(log.getRcvinstamnt());//利息
		String repayamnt=NOSUtil.change((lixis.add(benjins)).doubleValue());//大写金额
		String sxf="0";//偿还手续费
		String wyj="0";//偿还违约金
		String lixi=lixis.toString();//偿还利息
		String benjin=benjins.toString();//偿还本金
		
		String yssxf="0";//应收手续费
		String yswyj="0";//应收违约金
		
		String yhlixi=plan.getRepayinstamnt().toString();//应还利息
		String yhbenjin=plan.getCurrepayamnt().toString();//应还本金
		
		StringBuffer params=new StringBuffer();
		params.append(ReplaceNumber.prase((lixis.add(benjins)).doubleValue(),7));//数字金额
		params.append("clntnm,"+clntnm);
		params.append(";cntrctno,"+cntrctno);
		params.append(";repayamnt,"+repayamnt);
		
		params.append(";yyyy,"+yyyy);
		params.append(";mm,"+mm);
		params.append(";dd,"+dd);
		
		params.append(";bankno,"+bankno);
		//params.append(";payno,"+payno);
		//params.append(";bankname,"+bankname);
		
		params.append(";sxf,"+sxf);
		params.append(";wyj,"+wyj);
		params.append(";lixi,"+lixi);
		params.append(";benjin,"+benjin);
		
		params.append(";yssxf,"+yssxf);
		params.append(";yswyj,"+yswyj);
		params.append(";yhlixi,"+yhlixi);
		params.append(";yhbenjin,"+yhbenjin);
		
		System.out.println("======test========="+params.toString().trim());
		model.addAttribute("params", params.toString());
		model.addAttribute("filename", filename);
		return "/mf/temp/word";
	}
	
	//还款计划
			@RequestMapping(value="repayplanextend")
		    public String repayplanextend(Model model,HttpServletRequest request){
				String cntrectno;
				String dueno = request.getParameter("bsnsno");
				BigDecimal qkbj=new BigDecimal(0.0);//欠款本金
				BigDecimal whbj=new BigDecimal(0.0);//未还本金
					//借据信息
					BsnsBill bsnsbill=bsnsBillService.getById(dueno);
					cntrectno=bsnsbill.getCntrctno();
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
					whbj=bsnsbill.getDueamnt().subtract(bsnsrepaylog.getRcvprinamnt());
					model.addAttribute("bsnsrepaylog",bsnsrepaylog);
				
				//合同信息
				BsnsCntrct bsnscntrct=bsnsCntrctService.getById(cntrectno);//获取合同信息
				model.addAttribute("bsnscntrct",bsnscntrct);
				//还款计划
				List<SysDictionary> dic= sysDictionaryService.findSdBySdtCode("2019");
				 Map<String,String> map=new HashMap<String,String>();
				 for(int i=0;i<dic.size();i++){
					 map.put(dic.get(i).getSdvalue(), dic.get(i).getSdkey());
				 }
				
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
				String nowdate=sdf.format(new Date());
				
				List<BsnsRepayplan> planlist=bsnsRepayplanService.getByDueno(dueno);
				for(int j=0;j<planlist.size();j++){
					planlist.get(j).setRepaystt(map.get(planlist.get(j).getRepaystt()));
				}
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
				model.addAttribute("qkbj",qkbj);
				model.addAttribute("whbj",whbj);
				model.addAttribute("planlist",planlist);
					return "/mf/acctmoduel/normal/child/repayplan";  
		    }
}

