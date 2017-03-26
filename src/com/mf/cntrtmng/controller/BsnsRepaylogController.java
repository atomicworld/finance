/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */


package com.mf.cntrtmng.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.math.BigDecimal;
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
import org.springframework.web.bind.annotation.ResponseBody;

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
import com.mf.common.util.WaterIdGener;
import com.mf.org.entity.Operator;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;


/**   
*    
* 项目名称：microfinance   
* 类名称：BsnsRepaylogController   
* 类描述：还款日志
* 创建人：wyw   
* 创建时间：2015-1-30 下午10:52:00   
* 修改人：develop   
* 修改时间：2015-1-30 下午10:52:00   
* 修改备注：   
* @version    
*    
*/
@Controller
@RequestMapping(value="/mf/cntrtmng/bsnsrepayplanlog")
public class BsnsRepaylogController {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	@Autowired
	private BsnsRepayplanService bsnsRepayplanService;
	@Autowired
	private BsnsRepaylogService bsnsRepaylogService;
	@Autowired
	private BsnsBillService bsnsBillService;
	@Autowired
	private BsnsCntrctService bsnsCntrctService;
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
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		return "/background/bsnsrepaylog/add";
	}
	
	
	
	/**
	* @author wangyaowei
	* @date 2015-1-31上午12:20:41
	* @Title: add
	* @Description: TODO(保存还款日志表新增)
	* @param model
	* @param bsnsrepaylog
	* @param response
	* @param request
	* @return String    返回类型
	* @throws
	*/
	@RequestMapping(value="add")
	public String add(Model model,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\",\"info\":\"保存成功！\"}";
		try {
			String bsnsno=request.getParameter("bsnsno");//业务号
			String paymode=request.getParameter("paymode");//支付类型
			String[] rcvprinamnt=request.getParameterValues("rcvprinamnt");//本金
			String[] rcvinstamnt=request.getParameterValues("rcvinstamnt");//利息
			String[] paydt=request.getParameterValues("paydt");//状态
			String[] financeflg=request.getParameterValues("financeflg");//还款状态
			String[] srlno=request.getParameterValues("srlno");//还款计划编号=还款计划补录流水号
			BsnsRepaylog logs;
			int isS=-1;
			double total=0;//计算还款本金 是否大于应还本金
			for(int i=0;i<rcvprinamnt.length;i++){
				if(financeflg!=null)
				isS=Arrays.binarySearch(financeflg,String.valueOf(i));
				if(isS>=0){
					total+=Double.parseDouble(rcvprinamnt[i]);
				}
			}
			BsnsLnmain bsnslnmain=bsnsLnmainService.findByBsnsno(bsnsno);
			double lnblnc=bsnslnmain.getLnblnc().doubleValue();//贷款余额
			if(total>lnblnc){
				 result="{\"msg\":\"notice\",\"info\":\"还款本金大于应还本金！\"}";
				 WebTool.writeJson(result, response);
				 return null;
			}
			isS=-1;
			for(int i=0;i<rcvprinamnt.length;i++){
				logs=new BsnsRepaylog();
				logs.setLogid(WaterIdGener.getWaterId());
				BigDecimal a=new BigDecimal(rcvprinamnt[i]);
				BigDecimal b=new BigDecimal(rcvinstamnt[i]);
				logs.setBsnsno(bsnsno);
				logs.setPaymode(paymode);
				logs.setRcvprinamnt(a);
				logs.setRcvinstamnt(b);
				logs.setRcvamnt(a.add(b));
				logs.setPaydt(paydt[i]);
				logs.setSrlno(srlno[i]);
				if(financeflg!=null)
				isS=Arrays.binarySearch(financeflg,String.valueOf(i));
				if(isS>=0){
					logs.setFinanceflg(PubConstants.HKBJ_FINANCEFLG_ONE);//已还款
					BsnsRepayplan plan=bsnsRepayplanService.getById(srlno[i]);
					plan.setRepaystt(PubConstants.HKBJ_FINANCEFLG_ONE);//更新还款计划的状态
					bsnsRepayplanService.modify(plan);
				}
				Operator operator = (Operator)request.getSession().getAttribute("operator");
			    bsnsRepaylogService.add(logs,operator);
			}
		
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	

	
	/**
	 * post方式分页查询
	 * @param model
	 * @param bsnsrepaylog
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,BsnsRepaylog bsnsrepaylog,HttpServletRequest request){
		
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = bsnsRepaylogService.query(pageView, bsnsrepaylog);
		List<BsnsRepaylog> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param bsnsrepaylogId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			bsnsRepaylogService.delete(ids);
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
	 * @param bsnsrepaylogId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String bsnsrepaylogId,int typeKey){
		BsnsRepaylog bsnsrepaylog = bsnsRepaylogService.getById(bsnsrepaylogId);
		model.addAttribute("bsnsrepaylog", bsnsrepaylog);
		if(typeKey == 1){
			return "/background/bsnsrepaylog/edit";
		}else if(typeKey == 2){
			return "/background/bsnsrepaylog/view";
		}else{
			return "/background/bsnsrepaylog/view_1";
		}
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param bsnsrepaylog
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateBsnsRepaylog(Model model,HttpServletResponse response,HttpServletRequest request){		
		String result="{\"msg\":\"suc\",\"info\":\"保存成功！\"}";;
		try {
			String[] rcvprinamnt=request.getParameterValues("rcvprinamnt");//本金
			String[] rcvinstamnt=request.getParameterValues("rcvinstamnt");//利息
			String[] financeflg=request.getParameterValues("financeflg");
			String[] srlno=request.getParameterValues("srlno");//还款计划编号=还款计划补录流水号
			String bsnsno=request.getParameter("bsnsno");//借据号
			BsnsRepaylog logs;
			if(rcvprinamnt!=null){
				int isS=-1;
					double total=0;//计算还款本金 是否大于应还本金
					for(int i=0;i<rcvprinamnt.length;i++){
						if(financeflg!=null)
						isS=Arrays.binarySearch(financeflg,String.valueOf(i));
						if(isS>=0){
							total+=Double.parseDouble(rcvprinamnt[i]);
						}
					}
					BsnsLnmain bsnslnmain=bsnsLnmainService.findByBsnsno(bsnsno);
					double lnblnc=bsnslnmain.getLnblnc().doubleValue();//贷款余额
					if(total>lnblnc){
						 result="{\"msg\":\"notice\",\"info\":\"还款本金大于应还本金！\"}";
						 WebTool.writeJson(result, response);
						 return null;
					}
				isS=-1;
			for(int i=0;i<rcvprinamnt.length;i++){
				logs=new BsnsRepaylog();
				BigDecimal a=new BigDecimal(rcvprinamnt[i]);
				BigDecimal b=new BigDecimal(rcvinstamnt[i]);
				logs.setRcvprinamnt(a);
				logs.setRcvinstamnt(b);
				logs.setRcvamnt(a.add(b));
				logs.setSrlno(srlno[i]);
				if(financeflg!=null){
					isS=Arrays.binarySearch(financeflg,String.valueOf(i));
				}
				if(isS>=0){
					logs.setFinanceflg(PubConstants.HKBJ_FINANCEFLG_ONE); //已还款
					BsnsRepayplan plan=bsnsRepayplanService.getById(srlno[i]);
					plan.setRepaystt(PubConstants.HKBJ_FINANCEFLG_ONE);//更新还款计划的状态
					bsnsRepayplanService.modify(plan);
				}
				logs.setBsnsno(bsnsno);
				bsnsRepaylogService.update(logs);
				}
			}else{
				result="{\"msg\":\"fail\",\"message\":\"更新失败！查看数据是否为空\"}";
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
				bsnsRepaylogService.delete(id);
			}
			result = "{\"status\":1,\"message\":\"删除成功！\"}";
		} catch (Exception e) {
			result="{\"status\":0,\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	
	
	/**
	* @author wangyaowei
	* @date 2015-2-2下午5:49:26
	* @Title: isHavePlanLog
	* @Description: TODO(判断是否已存在  区分是新增 还是修改 )
	* @param model
	* @param dueno
	* @param request
	* @return String    返回类型
	*/
	@RequestMapping(value="isHavePlanLog")
	public String isHavePlanLog(Model model,String dueno,HttpServletRequest request){
		 int ish=bsnsRepaylogService.getCountPlan(dueno);
		 if(ish>0){
			 BsnsBill bsnsBill = bsnsBillService.findByDueno(dueno);
			 model.addAttribute("bsnsBill", bsnsBill);
			 BsnsCntrct bsnscntrct= bsnsCntrctService.getById(bsnsBill.getCntrctno());
			 model.addAttribute("bsnsCntrct", bsnscntrct);
			 List<BsnsRepaylogList> planlist = bsnsRepaylogService.getByDueno(dueno);
			 model.addAttribute("planlist", planlist);
			 return "/mf/cntrtmng/bsnsrepayplan/afterplanadd/showplanEdit";
		 }else{
			 return "redirect:/mf/cntrtmng/bsnsrepayplan/showplanAfterEdit.html?dueno="+dueno;
		 }
	}
	
	/**
	 * @author xujiuhua
	 * @date 2015年3月31日17:23:19
	 * @param model
	 * @param dueno
	 * @param request
	 * @return
	 */
	@RequestMapping(value="repayhistoryinfo")
	public String planInfo(Model model,String dueno, HttpServletRequest request){
		BsnsBill bsnsBill = bsnsBillService.findByDueno(dueno);
		model.addAttribute("bsnsbill", bsnsBill);
		BsnsCntrct bsnsCntrct = bsnsCntrctService.findByCntrctno(bsnsBill.getCntrctno());
		model.addAttribute("bsnscntrct", bsnsCntrct);
		BsnsRepaylog bsnsrepaylog=new BsnsRepaylog();
		bsnsrepaylog.setBsnsno(dueno);
		List<BsnsRepaylog> repaylog=bsnsRepaylogService.queryAll(bsnsrepaylog);
		model.addAttribute("repaylog",repaylog);
		return "/mf/cntrtmng/bsnsrepayplan/repayhistoryinfo";
	}
	
}

