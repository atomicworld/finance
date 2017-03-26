package com.mf.client.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.base.AutoCompleteEntity;
import com.mf.client.entity.ClntClient;
import com.mf.client.entity.ClntPerson;
import com.mf.client.service.ClntClientService;
import com.mf.client.service.ClntEeService;
import com.mf.client.service.ClntPersonService;
import com.mf.common.pub.PubConstants;
import com.mf.org.entity.Operator;
import com.mf.util.Common;
import com.mf.util.FormatDateUtil;
import com.mf.util.PageView;
import com.mf.util.WebTool;
@Controller
@RequestMapping(value = "/mf/client/clntclient/")
public class ClntClientController {
	
	
	@Autowired
	private ClntClientService clntClientService;
	@Autowired
	private ClntPersonService clntPersonService;
	@Autowired
	private ClntEeService clntEeService;
	
	// 个人客户 begin
	
	/**
	 * 跳转到list展示页面
	 * @return
	 */
	@RequestMapping(value="list")
	public String list(String clntType, String clntLeftMenu){
		// 客户基本信息
		if(PubConstants.CLNT_LEFT_MENU_BASEINFO.equals(clntLeftMenu)){
			return getInfoPageUrl(clntType);
			// 客户经济信息
		}else if(PubConstants.CLNT_LEFT_MENU_ECO.equals(clntLeftMenu)){
			return getEcoPageUrl(clntType);
			// 等级评估
		}else if(PubConstants.CLNT_LEFT_MENU_DGREVAL.equals(clntLeftMenu)){
			return getDgrevalPageUrl(clntType);
			// 关联关系
		}else if(PubConstants.CLNT_LEFT_MENU_REL.equals(clntLeftMenu)){
			return getRelationPageUrl(clntType);
			// 重大事件
		}else if(PubConstants.CLNT_LEFT_MENU_EVENT.equals(clntLeftMenu)){
			return getEventPageUrl(clntType);
		}else{
			return null;
		}
	}
	
	private String getEventPageUrl(String clntType) {
		if((PubConstants.CLNT_TYPE_EE).equals(clntType)){
			return "/mf/clientmng/clntevent/clntee/list";
		}else if((PubConstants.CLNT_TYPE_PERSON).equals(clntType)){
			return null;
		}else{
			return null;
		}
	}

	private String getRelationPageUrl(String clntType) {
		if((PubConstants.CLNT_TYPE_EE).equals(clntType)){
			return "/mf/clientmng/clntrel/clntee/list";
		}else if((PubConstants.CLNT_TYPE_PERSON).equals(clntType)){
			return "/mf/clientmng/clntrel/clntperson/list";
		}else{
			return null;
		}
	}

	private String getInfoPageUrl(String clntType){
		if((PubConstants.CLNT_TYPE_EE).equals(clntType)){
			return "/mf/clientmng/clntinfo/clntee/list";
		}else if((PubConstants.CLNT_TYPE_PERSON).equals(clntType)){
			return "/mf/clientmng/clntinfo/clntperson/list";
		}else{
			return null;
		}
	}
	
	/**
	 * 通过客户类型获得，客户经济信息url
	 * @param clntType
	 * @return
	 */
	private String getEcoPageUrl(String clntType){
		if((PubConstants.CLNT_TYPE_EE).equals(clntType)){
			return null;
		}else if((PubConstants.CLNT_TYPE_PERSON).equals(clntType)){
			return "/mf/clientmng/clnteco/clntperson/list";
		}else{
			return null;
		}
	}
	
	/**
	 * 通过客户类型获得，等级评估url
	 * @param clntType
	 * @return
	 */
	private String getDgrevalPageUrl(String clntType){
		if((PubConstants.CLNT_TYPE_EE).equals(clntType)){
			return "/mf/clientmng/clntdgreval/clntee/list";
		}else if((PubConstants.CLNT_TYPE_PERSON).equals(clntType)){
			return "/mf/clientmng/clntdgreval/clntperson/list";
		}else{
			return null;
		}
	}
	
	/**
	 * 提供list展示界面的数据
	 * @param model
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "query")
	@ResponseBody
	public Map<String, Object> showList(Model model, ClntClient clntClient, 
			HttpServletRequest request) {
		PageView pageView = null;
		String pageNow = request.getParameter("pager.pageNo");
		String pageSize = request.getParameter("pager.pageSize");
		if (Common.isEmpty(pageNow))
			pageView = new PageView(1);
		else {
			pageView = new PageView(Integer.parseInt(pageSize),
					Integer.parseInt(pageNow));
		}
		Map map = new HashMap();
		Operator operator = (Operator)request.getSession().getAttribute("operator");
		clntClient.setUserid(operator.getEmplyno());
		pageView =clntClientService.query(pageView, clntClient);
		List list = pageView.getRecords();
		map.put("rows", list);
		map.put("pager.pageNo", Integer.valueOf(pageView.getPageNow()));
		map.put("pager.totalRows", Long.valueOf(pageView.getRowCount()));
		return map;
	}
	
	@RequestMapping(value = "addUI")
	public String addUI(String clntType, HttpServletRequest request, Model model){
		Operator operator = (Operator)request.getSession().getAttribute("operator");
		model.addAttribute("operator", operator);
		if(PubConstants.CLNT_TYPE_EE.equals(clntType)){
			return "/mf/clientmng/clntinfo/clntee/add";
		}else if(PubConstants.CLNT_TYPE_PERSON.equals(clntType)){
			return "/mf/clientmng/clntinfo/clntperson/add";
		}else{
			return null;
		}
	}
	
	@RequestMapping(value="add")
	@ResponseBody
	public String add(Model model, ClntClient clntClient, HttpServletResponse response, HttpServletRequest request){
		String result = "{\"msg\":\"suc\"}";
		ClntPerson clntPerson = null;
		int clntId = getClntId(clntClient);
		// 一个证件号码 对应唯一一个客户
		ClntClient cc = clntClientService.findByCertno(clntClient.getCertno());
		// clntId == 0从数据库未能找到数据，网络连接异常，数据库数据异常等等
		if(null != cc){
			result = "{\"msg\":\"hadCertno\"}";
		}else{
			try {
				clntClient.setScdate(FormatDateUtil.getFormatDate("yyyy-MM-dd"));
				clntClient.setClntid(clntId);
				// 保存完成后，通过证件号码获取刚新增的客户信息
				// 保存“个人”客户信息，对公客户不用执行此步
				if(null != clntClient && clntClient.getClntid() != null){
					if("2".equals(clntClient.getClnttype())){
						clntPerson = new ClntPerson();
						clntPerson.setClntno(String.valueOf(clntClient.getClntid()));
						clntPerson.setDeptcode("数据发生机构代码");
						String gender = request.getParameter("gender");
						String birthday = request.getParameter("birthday");
						clntPerson.setGender(gender);
						clntPerson.setBirthday(birthday);
					}
				}
				// 保存客户基本信息
				clntClientService.add(clntClient, clntPerson);
			} catch (Exception e) {
				result = "{\"msg\":\"fail\"}";
			}
		}
		WebTool.writeJson(result, response);
		return null;
	}

	private int getClntId(ClntClient clntClient) {
		List<ClntClient> clntClienList = clntClientService.findByClntType(clntClient.getClnttype());
		// 如果数据库没有数据，起始，个人clntid=20000001 对公10000001
		if(null == clntClienList || clntClienList.size() == 0){
			if(PubConstants.CLNT_TYPE_EE.equals(clntClient.getClnttype())){
				return PubConstants.CLNTID_EE_BEGIN;
			}else{
				return PubConstants.CLNTID_PERSON_BEGIN;
			}
		}else{
			// 获取最大id
			if(PubConstants.CLNT_TYPE_EE.equals(clntClient.getClnttype())){
				return findMaxId(PubConstants.CLNT_TYPE_EE) + 1;
			}else{
				return findMaxId(PubConstants.CLNT_TYPE_PERSON) + 1;
			}
		}
	}

	// 客户类型 找到最大id
	private int findMaxId(String clntType) {
		Integer maxId = clntClientService.findMaxIdByClntType(clntType);
		if(null == maxId){
			return 0;
		}else{
			return maxId;
		}
	}
	
	/**
	* @author wangyaowei
	* @date 2015-3-24上午12:06:11
	* @Title: exportExcel
	* @Description: TODO(excel数据导出)
	* @param response
	* @param clntclient
	* @param type
	* @return void    返回类型
	* @throws
	*/
	@RequestMapping(value = "exportExcel")
	public void exportExcel(HttpServletResponse response,HttpServletRequest request,ClntClient clntclient) {
		  //type 判断导出的数据类型是个人用户数据还是公共用户数据
		  
		  WritableWorkbook wbook=null;
		  OutputStream os =null;
		  try { 
			  
			  String username=request.getParameter("username");
			  if(username!=null){
				  String clntname=new String(username.getBytes("iso-8859-1"),"utf-8");
				  clntclient.setClntname(clntname);
			  }
			  List<ClntClient> list=clntClientService.queryType(clntclient);
			  String type="客户信息表";
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
		      wsheet.setColumnView(0,12);//设置列宽
		      wsheet.setColumnView(1,20);
		      wsheet.setColumnView(2,12);
		      wsheet.setColumnView(3,20);
		      wsheet.setColumnView(4,12);
		      wsheet.setColumnView(5,12);
		      wsheet.setColumnView(6,12);
		      //开始生成主体内容    
		      wsheet.addCell(new Label(0, 0, "客户号",wcfFC)); 
		      wsheet.addCell(new Label(1, 0, "客户名称",wcfFC)); 
		      wsheet.addCell(new Label(2, 0, "证件类型",wcfFC)); 
		      wsheet.addCell(new Label(3, 0, "证件号码",wcfFC));
		      wsheet.addCell(new Label(4, 0, "客户类型",wcfFC));
		      wsheet.addCell(new Label(5, 0, "登记人",wcfFC));
		      wsheet.addCell(new Label(6, 0, "登记日期",wcfFC));
		      WritableCellFormat format = new WritableCellFormat(); 
		      format.setAlignment(jxl.format.Alignment.CENTRE);
		      for(int j=0;j<list.size();j++){
		    	
		    	ClntClient DiaoDuMap= list.get(j);
		  		wsheet.addCell(new Label(0, j+1,DiaoDuMap.getClntid().toString(),format));  
		        wsheet.addCell(new Label(1, j+1,DiaoDuMap.getClntname(),format));  
		        wsheet.addCell(new Label(2, j+1,DiaoDuMap.getCerttype(),format)); 
		        wsheet.addCell(new Label(3, j+1,DiaoDuMap.getCertno(),format)); 
		        wsheet.addCell(new Label(4, j+1,DiaoDuMap.getClnttype(),format)); 
		        wsheet.addCell(new Label(5, j+1,DiaoDuMap.getUserid(),format)); 
		        wsheet.addCell(new Label(6, j+1,DiaoDuMap.getScdate(),format));
		      
		       }
		       //主体内容生成结束           
		       wbook.write(); // 写入文件   
		       }catch(Exception ex) { 
		           ex.printStackTrace(); 
		       }finally{
		        	try {
		        		if(wbook!=null){
		        			wbook.close();
							os.close(); // 关闭流
		        		}
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
	* @date 2015-3-29上午12:02:46
	* @Title: getClientItem
	* @Description: TODO(设置用户下拉查询)
	* @param model
	* @param clntClient
	* @param request
	* @return
	* @return Map<String,List<AutoCompleteEntity>>    返回类型
	* @throws
	*/
	@RequestMapping(value="getClientItem")
	@ResponseBody
	public Map<String, List<AutoCompleteEntity>> getClientItem(Model model, ClntClient clntClient, HttpServletRequest request){
		Map<String,List<AutoCompleteEntity>> map;
		//查询所有科目信息
		map = clntClientService.getAllItemForAutoCmp(clntClient);
		return map;
	}
	@RequestMapping(value="getAllClientItem")
	@ResponseBody
	public Map<String, List<AutoCompleteEntity>> getAllClientItem(Model model, ClntClient clntClient, HttpServletRequest request){
		Map<String,List<AutoCompleteEntity>> map;
		//查询所有科目信息
		map = clntClientService.getClientItemForAutoCmp(clntClient);
		return map;
	}
	
	
	/** 
	 * @author made_in_heaven@foxmail.com
	 * @Description: TODO(公共方法查看客户详细数资料)
	 * @param @param clntid
	 * @param @param model
	 * @param @return 设定文件 
	 * @date 2015-7-7
	 */ 
	@RequestMapping(value="clientInfo")
	public String clientInfo(String clntid,Model model, HttpServletRequest request){
		ClntClient   client = clntClientService.FindById(clntid);
		if("1".equals(client.getClnttype().trim())){//对公客户
			model.addAttribute("clntClient", client);
			return "/mf/util/clientinfo/companyList";
		}else{//个人客户
			model.addAttribute("clntPerson", client);
			return "/mf/util/clientinfo/personList";
		}
		
	}
}
