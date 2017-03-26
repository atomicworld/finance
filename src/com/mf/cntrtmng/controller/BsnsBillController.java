/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.cntrtmng.controller;

import java.math.BigDecimal;
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

import com.mf.bsnsmng.entity.Loanuse;
import com.mf.bsnsmng.service.LoanuseService;
import com.mf.client.entity.ClntClient;
import com.mf.client.entity.ClntEe;
import com.mf.client.entity.ClntEeCapPeople;
import com.mf.client.entity.ClntEeReg;
import com.mf.client.entity.ClntPerson;
import com.mf.client.service.ClntClientService;
import com.mf.client.service.ClntEeCapPeopleService;
import com.mf.client.service.ClntEeRegService;
import com.mf.client.service.ClntEeService;
import com.mf.client.service.ClntPersonService;
import com.mf.cntrtmng.entity.BsnsBill;
import com.mf.cntrtmng.entity.BsnsCntrct;
import com.mf.cntrtmng.service.BsnsBillService;
import com.mf.cntrtmng.service.BsnsCntrctService;
import com.mf.common.pub.PubConstants;
import com.mf.common.util.NOSUtil;
import com.mf.common.util.ReplaceNumber;
import com.mf.common.util.StringUtil;
import com.mf.common.util.WaterIdGener;
import com.mf.financemng.entity.FnncAccntitem;
import com.mf.financemng.service.FnncAccntitemService;
import com.mf.sys.entity.CompanyInfo;
import com.mf.sys.service.impl.CompanyInfoServiceImpl;
import com.mf.util.Common;
import com.mf.util.FormatDateUtil;
import com.mf.util.PageView;
import com.mf.util.WebTool;

/**
 * @author xujiuhua
 * @2015-01-13
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value = "/mf/cntrtmng/bsnsbill/")
public class BsnsBillController {

	@Autowired
	private BsnsBillService bsnsBillService;
	@Autowired
	private BsnsCntrctService bsnsCntrctService;
	@Autowired
	private ClntClientService clntClientService;
	@Autowired
	private LoanuseService loanuseService;
	@Autowired
	CompanyInfoServiceImpl  companyInfoService;
	@Autowired
	private ClntPersonService clntPersonService;
	@Autowired
	private ClntEeService clntEeService;
	@Autowired
	private ClntEeRegService clntEeRegService;
	@Autowired
	private ClntEeCapPeopleService clntEeCapPeopleService;
	@Autowired
	private FnncAccntitemService fnncAccntitemService;
	
	private static final String JSP_PATH = "/mf/cntrtmng/bsnsbill/";

	/**
	 * 跳到新增页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "addUI")
	public String addUI(Model model) {
		return JSP_PATH + "add";
	}

	/**
	 * 保存新增
	 * 
	 * @param model
	 * @param bsnsbill
	 * @return
	 */
	@RequestMapping(value = "add")
	public String add(Model model, BsnsBill bsnsbill,	HttpServletResponse response, HttpServletRequest request) {
		String result = "{\"msg\":\"suc\"}";
		try {
			BsnsCntrct bsnscntrct = bsnsCntrctService.getById(bsnsbill.getCntrctno());
			String cntrctstt=request.getParameter("cntrctstt");//合同状态
			if(PubConstants.CNTRCTSTT_HISTORY.equals(cntrctstt)){//补录合同生成借据 合同状态设置为91
				bsnscntrct.setCntrctstt(PubConstants.CNTRCTSTT_HISTORY_BILL);
				bsnsCntrctService.update(bsnscntrct);//更新借据 补录表的状态
			}
			String id = "cz" + WaterIdGener.getWaterId();
			bsnsbill.setDueno(id);// 借据主键
			bsnsbill.setClntno(bsnscntrct.getClntno());// 客户编号
			bsnsbill.setClntnm(bsnscntrct.getClntnm());// 客户名
			bsnsbill.setMtrtydate(bsnscntrct.getCntrctedate());// 结束日期
			bsnsbill.setLnamnt(bsnscntrct.getCntrctamnt());// 贷款金额
			bsnsbill.setDlflg("0");//标记为未生成还款计划
			bsnsBillService.add(bsnsbill);
			
			
		} catch (Exception e) {
			result = "{\"msg\":\"fail\",\"message\":\""
					+ WebTool.getErrorMsg(e.getMessage()) + "\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}

	/**
	 * 保存新增--for 即时编辑
	 * 
	 * @param model
	 * @param bsnsbill
	 * @return
	 */
	@RequestMapping(value = "addnull")
	public String addnull(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		String result = "";
		try {
			BsnsBill bsnsbill = new BsnsBill();
			bsnsBillService.addAll(bsnsbill);
			result = "{\"id\":" + bsnsbill.getClntno()
					+ ",\"message\":\"新增成功！\"}";
		} catch (Exception e) {
			result = "{\"id\":\"0\",\"message\":\""
					+ WebTool.getErrorMsg(e.getMessage()) + "\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}

	/**
	 * 分页查询跳转
	 * 
	 * @param model
	 * @param bsnsbill
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "query")
	public String query(Model model, BsnsBill bsnsbill, String pageNow,
			String pageSize) {
		return JSP_PATH + "list_list";
	}

	/**
	 * @param model
	 * @param request
	 * @return 合同信息
	 */
	@RequestMapping(value = "receiptList")
	public String rceiptList(Model model, HttpServletRequest request) {
		return JSP_PATH + "receipt";
	}

	/**
	 * @param model
	 * @param request
	 * @return 合同列表
	 */
	@RequestMapping(value = "receiptLoanList")
	public String receiptLoanList(Model model, HttpServletRequest request) {
		return JSP_PATH + "receiptList";
	}

	@RequestMapping(value = "bill")
	public String bill(Model model, HttpServletRequest request) {
		String cntrctno = request.getParameter("cntrctno");
		model.addAttribute("cntrctno", cntrctno);
		return JSP_PATH + "bill/list";
	}

	/**
	 * @param model
	 * @param request
	 * @return wyw 合同借据查询
	 */
	@RequestMapping(value = "listInfo")
	public String listInfo(Model model, HttpServletRequest request) {
		String cntrctno = request.getParameter("cntrctno");
		model.addAttribute("cntrctno", cntrctno);
		return JSP_PATH + "bill/listInfo";
	}

	/**
	 * post方式分页查询
	 * 
	 * @param model
	 * @param bsnsbill
	 * @return map
	 */
	@RequestMapping(value = "showlist", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> showlist(Model model, BsnsBill bsnsbill,	HttpServletRequest request) {
		PageView pageView = null;
		String pageNow = request.getParameter("pager.pageNo");
		String pageSize = request.getParameter("pager.pageSize");
		if (Common.isEmpty(pageNow)) {
			pageView = new PageView(1);
		} else {
			pageView = new PageView(Integer.parseInt(pageSize),	Integer.parseInt(pageNow));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		pageView = bsnsBillService.query(pageView, bsnsbill);
		List<BsnsBill> list = pageView.getRecords();
		map.put("rows", list);
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}

	/**
	 * 查询相应合同下已放款的借据
	 * 
	 * @param model
	 * @param bsnsbill
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "showBillouted", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> showBillouted(Model model, BsnsBill bsnsbill, HttpServletRequest request) {
		PageView pageView = null;
		String pageNow = request.getParameter("pager.pageNo");
		String pageSize = request.getParameter("pager.pageSize");
		if (Common.isEmpty(pageNow)) {
			pageView = new PageView(1);
		} else {
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		bsnsbill.setDlflg(PubConstants.DLFLG_HKJH_YES);
		pageView = bsnsBillService.queryBillouted(pageView, bsnsbill);
		List<BsnsBill> list = pageView.getRecords();
		map.put("rows", list);
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}

	/**
	 * 根据id删除
	 * 
	 * @param model
	 * @param bsnsbillId
	 * @return
	 */
	@RequestMapping(value = "deleteById", method = RequestMethod.POST)
	public String deleteById(Model model, String dueno,HttpServletResponse response) {
		String result = null;
		try {
			
			bsnsBillService.delete(dueno);
			result = "{\"status\":1,\"message\":\"删除成功！\"}";
		} catch (Exception e) {
			result = "{\"status\":0,\"message\":\""	+ WebTool.getErrorMsg(e.getMessage()) + "\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}

	/**
	 * 查询&修改单条记录
	 * 
	 * @param model
	 * @param bsnsbillId
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "getById")
	public String getById(Model model, String bsnsbillId, int typeKey) {
		BsnsBill bsnsbill = bsnsBillService.getById(bsnsbillId);
		model.addAttribute("bsnsbill", bsnsbill);
		if (typeKey == 1) {
			return JSP_PATH + "edit";
		} else if (typeKey == 2) {
			return JSP_PATH + "view";
		} else {
			return JSP_PATH + "view_1";
		}
	}

	/**
	 * 更新修改的信息
	 * 
	 * @param model
	 * @param bsnsbill
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateBsnsBill(Model model, BsnsBill bsnsbill,
			HttpServletResponse response) {
		String result = "{\"msg\":\"suc\"}";
		;
		try {
			bsnsBillService.modify(bsnsbill);
		} catch (Exception e) {
			result = "{\"msg\":\"fail\",\"message\":\""
					+ WebTool.getErrorMsg(e.getMessage()) + "\"}";
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
	public String deleteAll(String[] ids, Model model,HttpServletResponse response) {
		String result = null;
		try {
			for (String id : ids) {
				bsnsBillService.delete(id);
			}
			result = "{\"status\":1,\"message\":\"删除成功！\"}";
		} catch (Exception e) {
			result = "{\"status\":0,\"message\":\""
					+ WebTool.getErrorMsg(e.getMessage()) + "\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}

	/**
	 * @param dueno
	 * @param model
	 * @param request
	 * @return 更加主键查询借据
	 * wyw
	 */
	@RequestMapping(value = "findByDueno")
	public String findByDueno(String dueno, Model model,
			HttpServletRequest request) {
		BsnsBill bsnsbill = bsnsBillService.findByDueno(dueno);
		model.addAttribute("bsnsbill", bsnsbill);
		request.setAttribute("dueno", dueno);
		return JSP_PATH + "billplan_info";
	}

	/**
	 * @param dueno
	 * @param model
	 * @param request
	 * @return 查看借据信息
	 * wyw
	 */
	@RequestMapping(value = "billView")
	public String billView(String dueno, Model model, HttpServletRequest request) {
		BsnsBill bsnsbill = bsnsBillService.findByDueno(dueno);
		model.addAttribute("bsnsbill", bsnsbill);
		BsnsCntrct bsnscntrct = bsnsCntrctService.getById(bsnsbill.getCntrctno());
		model.addAttribute("bsnscntrct", bsnscntrct);
		return JSP_PATH + "bill/billView";
	}

	/**
	 * @param model
	 * @param request
	 * @return 跳转到添加页面
	 * wyw
	 */
	@RequestMapping(value = "billAdd")
	public String billView(Model model, HttpServletRequest request) {
		String cntrctno = request.getParameter("cntrctno");
		BsnsCntrct bsnscntrct = bsnsCntrctService.getById(cntrctno);
		model.addAttribute("bsnscntrct", bsnscntrct);
		return JSP_PATH + "bill/billAdd";
	}

	/**
	 * @param model
	 * @param request
	 * @return
	 * 借据修改页面
	 * wyw
	 */
	@RequestMapping(value = "billEdit")
	public String billEdit(Model model, HttpServletRequest request) {
		String dueno = request.getParameter("dueno");
		BsnsBill bsnsbill = bsnsBillService.findByDueno(dueno);
		model.addAttribute("bsnsbill", bsnsbill);
		String cntrctno = bsnsbill.getCntrctno();
		BsnsCntrct bsnscntrct = bsnsCntrctService.getById(cntrctno);
		String total = bsnsBillService.getTotal(cntrctno);
		if (total == null) {
			total = "0";
		}
		BigDecimal b1 = new BigDecimal(total);
		BigDecimal b2 = bsnscntrct.getCntrctamnt().subtract(b1);
		b2 = b2.add(bsnsbill.getDueamnt());// 剩余资金加上借据资金
		bsnscntrct.setCntrctamnt(b2);// 设置可发放资金
		
		model.addAttribute("bsnscntrct", bsnscntrct);
		return JSP_PATH + "bill/billEdit";
	}

	/**
	 * @param model
	 * @param bsnsbill
	 * @param request
	 * @return
	 * wyw
	 * 获取借据信息
	 */
	@RequestMapping(value = "listInfoAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> listInfoAll(Model model, BsnsBill bsnsbill,
			HttpServletRequest request) {
		PageView pageView = null;
		String pageNow = request.getParameter("pager.pageNo");
		String pageSize = request.getParameter("pager.pageSize");
		if (Common.isEmpty(pageNow)) {
			pageView = new PageView(1);
		} else {
			pageView = new PageView(Integer.parseInt(pageSize),
					Integer.parseInt(pageNow));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		pageView = bsnsBillService.query(pageView, bsnsbill);
		List<BsnsBill> list = pageView.getRecords();
		map.put("rows", list);
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 查询补录合同借据列表
	 * @author xjh
	 * @param model
	 * @param bsnsbill
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "queryBLBill", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> queryBLBill(Model model, BsnsBill bsnsbill,
			HttpServletRequest request) {
		PageView pageView = null;
		String pageNow = request.getParameter("pager.pageNo");
		String pageSize = request.getParameter("pager.pageSize");
		if (Common.isEmpty(pageNow)) {
			pageView = new PageView(1);
		} else {
			pageView = new PageView(Integer.parseInt(pageSize),	Integer.parseInt(pageNow));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		pageView = bsnsBillService.queryBLBill(pageView, bsnsbill);
		List<BsnsBill> list = pageView.getRecords();
		map.put("rows", list);
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	

	/**
	 * @param model
	 * @param request
	 * @return 生成还款计划 借据list
	 * wyw
	 */
	@RequestMapping(value = "listInfoAlls")
	public String listInfoAlls(Model model, HttpServletRequest request) {
		return "/mf/cntrtmng/bsnsrepayplan/billList/listInfo";
	}
	/**
	 * @param model
	 * @param request
	 * @return 
	 * 生成还款补录 借据list跳转页面
	 * wyw
	 */
	@RequestMapping(value = "afterplanadd")
	public String afterplanadd(Model model, HttpServletRequest request) {
		return "/mf/cntrtmng/bsnsrepayplan/afterplanadd/afterplanList";

	}
	/**
	 * @param model
	 * @param request
	 * @return 选项卡指定地址
	 * wyw
	 */
	@RequestMapping(value = "afterplanList")
	public String afterplanList(Model model, HttpServletRequest request) {
		return "/mf/cntrtmng/bsnsrepayplan/afterplanadd/list";
	}
	
	
	/**
	* @author wangyaowei
	* @date 2015-3-25下午6:04:50
	* @Title: printBill
	* @Description: TODO(打印借据)
	* @param model
	* @param request
	* @return
	* @return String    返回类型
	* @throws
	*/
	@RequestMapping(value = "printBill")
	public String printBill(Model model,BsnsBill bsnsbill, HttpServletRequest request) {
		String filename=request.getParameter("filename");
		String deuno=bsnsbill.getDueno();//借据编号
		BsnsBill bsns=bsnsBillService.findByDueno(deuno);
		ClntClient client=new ClntClient();
		client.setClntid(Integer.parseInt(bsns.getClntno()));
		List<ClntClient> clntclient=clntClientService.queryType(client);
		ClntClient clnt=clntclient.get(0);//客户信息
		BsnsCntrct bsnscntrct=bsnsCntrctService.findByCntrctno(bsns.getCntrctno());//合同信息
		Loanuse loanuse=loanuseService.getById(bsnscntrct.getUseno().toString());//用途
		StringBuffer params=new StringBuffer();
		String occrdate=FormatDateUtil.prase(bsns.getOccrdate());//发生日期
		String outdate=FormatDateUtil.prase(bsns.getOutdate());//借款日期
		String mtrtydate=FormatDateUtil.prase(bsns.getMtrtydate());//到期日期
		String money=NOSUtil.change(bsns.getDueamnt().doubleValue());
		params.append(ReplaceNumber.prase(bsns.getDueamnt().doubleValue(),9));//数字金额
		params.append("dueno,"+bsns.getDueno());//借据编号
		params.append(";occrdate,"+occrdate);//发生日期
		params.append(";dueamnt,"+money);//借据金额
		params.append(";clntnm,"+bsns.getClntnm());//客户名称
		params.append(";cntrctno,"+bsns.getCntrctno());//合同编号
		params.append(";outdate,"+outdate);//借款日期
		params.append(";mtrtydate,"+mtrtydate);//到期日期
		params.append(";certtype,"+clnt.getCerttype());//证件类型
		params.append(";certno,"+clnt.getCertno());//证件号
		BigDecimal month=new BigDecimal(120);
		params.append(";applyrt,"+bsnscntrct.getApplyrt().divide(month,2,BigDecimal.ROUND_HALF_UP));//月利率
		params.append(";useno,"+loanuse.getUsenm());//贷款用途
		model.addAttribute("params", params.toString());
		model.addAttribute("filename", filename);
		return "/mf/temp/word";
	}
	
	/** 
	 * @author made_in_heaven@foxmail.com
	 * @Description: TODO(打印合同) 
	 * @param @param model
	 * @param @param bsnscntrct
	 * @param @param request
	 * @param @return 设定文件 
	 * @date 2015-5-19
	 */ 
	@RequestMapping(value = "printCntrct")
	public String printCntrct(Model model,BsnsCntrct bsnscntrct, HttpServletRequest request) {
		String filename=request.getParameter("filename");
		bsnscntrct=bsnsCntrctService.getByPrintInfo(bsnscntrct.getCntrctno());//合同信息
		CompanyInfo companyInfo= new CompanyInfo();
		companyInfo=companyInfoService.getCompanyInfo(companyInfo);
		String cmpnm="__________________";
		if(companyInfo.getCmpnm()!=null){
			cmpnm=companyInfo.getCmpnm();
		}
		/*String rpmntway=bsnscntrct.getRpmntway();
		if("1".equals(rpmntway)){
			rpmntway="一";
		}else if("2".equals(rpmntway)){
			rpmntway="二";
		}else if("3".equals(rpmntway)){
			rpmntway="三";
		}else if("4".equals(rpmntway)){
			rpmntway="四";
		}else if("5".equals(rpmntway)){
			rpmntway="五";
		}*/
		ClntClient client=clntClientService.getById(bsnscntrct.getClntno());
		 String type=client.getClnttype();
		 String faren=" ";//法人
		 String regadd=" ";//法定地址
		 String phone=" ";//联系电话
		String zip=" ";//邮编
		String address=" ";//通讯地址
		String bank=" ";//开户银行
		String number=" ";//账号
		if("1".equals(type)){//对公
			ClntEe ee=	clntEeService.getById(client.getClntid().toString());
			if(ee != null){
				number=ee.getLncardno();//贷款卡号
				bank=ee.getBankcode();
			}
		}else{
			ClntPerson person=clntPersonService.findByClntno(client.getClntid().toString());
			number=person.getCardid();//贷款卡号
			bank=person.getBankcode();
			
		}
		if(StringUtil.isEmpty(bank)) {
			number="";
			bank ="";
		} else {
			System.out.println("=======bank==========="+bank);
			FnncAccntitem item=fnncAccntitemService.getById(bank);
			if (item!=null) {
				bank=item.getAccntnm();
			}
		}
		 if("1".equals(type)){//对公
			 ClntEe ee=clntEeService.getById(client.getClntid().toString());
			 if(ee == null){
				 ee = new ClntEe();
			 }
			 zip=StringUtil.isEmpty(ee.getZip())?" ":ee.getZip();
			 ClntEeReg reg=clntEeRegService.getById(client.getClntid().toString());
			 if(reg == null){
				 reg = new ClntEeReg();
			 }
			 address=StringUtil.isEmpty(reg.getAddress())?" ":reg.getAddress();
			 regadd=StringUtil.isEmpty(reg.getRegadd())?" ":reg.getRegadd();
			 if(reg.getPhone1()!=null&&reg.getPhone1()!=""){
				 phone=reg.getPhone1();
			 }else if(reg.getPhone2()!=null&&reg.getPhone2()!=""){
				 phone=reg.getPhone2();
			 }else if(reg.getPhone3()!=null&&reg.getPhone3()!=""){
				 phone=reg.getPhone3();
			 }else{
				 phone=reg.getLinkmantel();
			 }
			 phone=StringUtil.isEmpty(phone)?" ":phone;
			 ClntEeCapPeople cappeople=new ClntEeCapPeople();
			 cappeople.setClntno(client.getClntid().toString());
			 cappeople.setHmclass("1");
			 List<ClntEeCapPeople> cap=clntEeCapPeopleService.queryAll(cappeople);
			 if(cap.size()>0){
				 faren=cap.get(0).getHmnm();
			 }
		 }else{//个人
			 ClntPerson person=	 clntPersonService.getByClntno(client.getClntid().toString());
			 address=StringUtil.isEmpty(person.getAddress())?" ":person.getAddress();
			 zip=StringUtil.isEmpty(person.getZip())?" ":person.getZip();
			 phone= person.getHometel()!=null?person.getHometel():person.getMobiletel();
			 phone=StringUtil.isEmpty(phone)?" ":phone;
		 }
		//借
		
		
		
		
		
		//贷
		String faren2="   ";//法人
		faren2 = StringUtil.isEmpty(companyInfo.getCmpfaren())?"":companyInfo.getCmpfaren();//小贷法人
		String regadd2=StringUtil.isEmpty(companyInfo.getCmpaddr())?" ":companyInfo.getCmpaddr();//法定地址
		String call=companyInfo.getTelphone();//联系方式
		String zip2=StringUtil.isEmpty(companyInfo.getZipcode())?" ":companyInfo.getZipcode();//邮编
		String address2=companyInfo.getCmpaddr();//通讯地址
		
		
		String money=NOSUtil.change(bsnscntrct.getCntrctamnt().doubleValue());
		StringBuffer params=new StringBuffer();
		
		params.append("clntnm,"+bsnscntrct.getClntnm());//客户名称
		params.append(";cntrctno,"+bsnscntrct.getCntrctno());//合同编号
		params.append(";cmpnm,"+cmpnm);//贷款公司
		
		params.append(";syyyy,"+bsnscntrct.getCntrctsdate().substring(0,4));//开始年
		params.append(";smm,"+bsnscntrct.getCntrctsdate().substring(4,6));//开始月
		params.append(";sdd,"+bsnscntrct.getCntrctsdate().substring(6,8));//开始日
		
		params.append(";eyyyy,"+bsnscntrct.getCntrctedate().substring(0,4));//结束年
		params.append(";emm,"+bsnscntrct.getCntrctedate().substring(4,6));//结束月
		params.append(";edd,"+bsnscntrct.getCntrctedate().substring(6,8));//结束日
		
		//params.append(";trmmnth,"+bsnscntrct.getTrmmnth());//期限月
		//params.append(";trmday,"+bsnscntrct.getTrmday());//期限日
		//params.append(";rpmntway,"+rpmntway);//计息方式
		
		//params.append(";cmpnm2,"+cmpnm);//贷款公司
		params.append(";certno,"+client.getCertno());//证件号
		params.append(";applyrt,"+bsnscntrct.getApplyrt());//利率
		
		params.append(";useno,"+bsnscntrct.getUseno());//用途
		params.append(";cntrctamnt,"+money);//金额
		params.append(";faren,"+faren);//
		
		params.append(";regadd,"+regadd);//
		params.append(";phone,"+phone);//
		params.append(";zip,"+zip);//
		
		params.append(";address,"+address);//
		params.append(";bank,"+bank);//
		params.append(";number,"+number);//
		
		params.append(";faren2,"+faren2);//
		params.append(";call,"+call);//
		params.append(";regadd2,"+regadd2);//
		
		params.append(";zip2,"+zip2);//
		params.append(";address2,"+address2);//
		
		
		
		model.addAttribute("params", params.toString());
		model.addAttribute("filename", filename);
		return "/mf/temp/word";
	}
	
	
}
