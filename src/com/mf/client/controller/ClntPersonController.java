package com.mf.client.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.client.entity.ClntClient;
import com.mf.client.entity.ClntPerson;
import com.mf.client.service.ClntClientService;
import com.mf.client.service.ClntPersonService;
import com.mf.common.pub.PubConstants;
import com.mf.pubparam.entity.Cities;
import com.mf.pubparam.service.CitiesService;
import com.mf.util.Common;
import com.mf.util.FormatDateUtil;
import com.mf.util.PageView;
import com.mf.util.WebTool;

@Controller
@RequestMapping(value = "/mf/client/clntperson/")
public class ClntPersonController {

	@Autowired
	private ClntPersonService clntPersonService;
	@Autowired
	private ClntClientService clntClientService;
	@Autowired
	private CitiesService citiesService;
	
	/**
	 * 跳转到list展示页面
	 * @return
	 */
	@RequestMapping(value="list")
	public String list(){
		return "/mf/clientmng/clntinfo/list";
	}
	
	/**
	 * 提供list展示界面的数据
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "query")
	@ResponseBody
	public Map<String, Object> showList(Model model, ClntPerson clntPerson, 
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
		pageView =clntPersonService.query(pageView, clntPerson);
		List list = pageView.getRecords();
		map.put("rows", list);
		map.put("pager.pageNo", Integer.valueOf(pageView.getPageNow()));
		map.put("pager.totalRows", Long.valueOf(pageView.getRowCount()));
		return map;
	}
	
	@RequestMapping(value = "addUI")
	public String addUI(){
		return "/mf/clientmng/clntinfo/add";
	}
	@RequestMapping(value = "childPage")
	public String childPage(Model model, String clntno, String pageType, HttpServletRequest request){
		ClntPerson clntPerson = clntPersonService.findByClntno(clntno);
		model.addAttribute("clntPerson",clntPerson);
		String lastmoddate = clntPerson.getLastmoddate();
		if(null != lastmoddate && lastmoddate != ""){
			pageType = PubConstants.PAGE_TYPE_VIEW;
		}else{
			pageType = PubConstants.PAGE_TYPE_EDIT;
		}
		request.setAttribute("pageType", pageType);
		return "/mf/clientmng/clntinfo/clntperson/listlabel";
	}
	
	@RequestMapping(value="getByClntno")
	public String getByClntno(Model model, String clntno, String pageType, HttpServletRequest request, String clntLeftMenu){
		ClntPerson clntPerson = clntPersonService.findByClntno(clntno);
		model.addAttribute("clntPerson",clntPerson);
		ClntClient clntClient = clntClientService.getById(clntno);
		model.addAttribute("clntClient", clntClient);
		// 经济情况信息
		if(PubConstants.CLNT_LEFT_MENU_ECO.equals(clntLeftMenu)){
			return "/mf/clientmng/clnteco/clntperson/listlabel";
		}else if(PubConstants.CLNT_LEFT_MENU_REL.equals(clntLeftMenu)){
			return "/mf/clientmng/clntrel/clntperson/listlabel";
		}else{
			model.addAttribute("flag", request.getParameter("flag"));

			// 客户基本信息
			if(PubConstants.PAGE_TYPE_EDIT.equals(pageType)){
				return "/mf/clientmng/clntinfo/clntperson/edit";
			}else if(PubConstants.PAGE_TYPE_VIEW.equals(pageType)){
				model.addAttribute("view", request.getParameter("view"));
				return "/mf/clientmng/clntinfo/clntperson/view";
			}else{
				return "/mf/clientmng/clntinfo/clntperson/view";
			}
		}
	}
	
	
	@RequestMapping(value="update")
	public String add(ClntPerson clntPerson, HttpServletResponse response){
		String result = "{\"msg\":\"suc\"}";
		String lastModeDate = FormatDateUtil.getFormatDate("yyyy-MM-dd");
		clntPerson.setLastmoddate(lastModeDate);
		clntPersonService.update(clntPerson);
		WebTool.writeJson(result, response);
		return null;
	}
	@RequestMapping(value = "printClienttWord")
	public String printClienttWord(HttpServletResponse response,HttpServletRequest request,String clntno) {
			  String  result="{\"msg\":\"failed\"}";
	          String path = request.getRealPath("/")+"Document"+File.separator+"upload"+File.separator;  
	          String fileName="";
	          clntno=clntno.trim();
	      	  ClntPerson clntPerson = clntPersonService.getByClntno(clntno);
	      	  ClntClient clntClient = clntClientService.FindById(clntno);
	      	  Cities cities=citiesService.getById(clntPerson.getClntarea());
	      	String zip=" ";
	      	if(clntPerson.getZip()!=null){
	      		zip=clntPerson.getZip();
	      	}
	      	String hometel=" ";
	      	if(clntPerson.getHometel()!=null){
	      		hometel=clntPerson.getHometel();
	      	}
	      	String othertel=" ";
	      	if(clntPerson.getOthertel()!=null){
	      		othertel=clntPerson.getOthertel();
	      	}
	      	String email="";
	      	if(clntPerson.getEmail()!=null){
	      		email=clntPerson.getEmail();
	      	}
	      	String remark=" ";
	      	if(clntPerson.getRemark()!=null){
	      		remark=clntPerson.getRemark();
	      	}
	      	
		     // add by hw
	      		String city="";
	      		if(cities!=null){
	      			city = cities.getName();
	      		}
	      	//
	          try {  
	              if (!"".equals(path)) {  
	                  // 检查目录是否存在  
	                  File fileDir = new File(path);  
	                  if (fileDir.exists()) {  
	                     // 生成临时文件名称  
	                     fileName = System.currentTimeMillis()+"_1.doc";  
	                     String content = "" +
	                     		"<html>" +
	                     		"<div style=\"text-align: center\">" +
	                     		"<span style=\"font-family: 黑体;font-size: 28px;width: 75%\">个人客户信息<br /></span>" +
	                     		"<table style=\"width: 750px;\" border=\"2\" cellpadding='0' cellspacing='0'>"+
	                     		"<tr>"+
	                     		"<td  style=\"text-align: right;width:23%\">客户编号:</td>"+
	                     		"<td  style=\"text-align: left;width:34%\" >"+clntClient.getClntid()+"</td>"+
	                     		"<td  style=\"text-align: right;width:23%\">客户名称：</td>"+
	                     		"<td  style=\"text-align: left;width:20%\">"+clntClient.getClntname()+"</td>"+
	                     		"</tr>"+
	                     		"<tr>"+
	                     		"<td  style=\"text-align: right;\">政治面貌:</td>"+
	                     		"<td  style=\"text-align: left;\" >"+clntPerson.getPolitics()+"</td>"+
	                     		"<td  style=\"text-align: right;\">民族：</td>"+
	                     		"<td  style=\"text-align: left;\">"+clntPerson.getNation()+"</td>"+
	                     		"</tr>"+
	                     		"<tr>"+
	                     		"<td  style=\"text-align: right;\">婚姻状况:</td>"+
	                     		"<td  style=\"text-align: left;\" >"+clntPerson.getMarriage()+"</td>"+
	                     		"<td  style=\"text-align: right;\">最高学历：</td>"+
	                     		"<td  style=\"text-align: left;\">"+clntPerson.getEdulevel()+"</td>"+
	                     		"</tr>"+
	                     		"<tr>"+
	                     		"<td  style=\"text-align: right;\">最高学位:</td>"+
	                     		"<td  style=\"text-align: left;\" >"+clntPerson.getEdudegree()+"</td>"+
	                     		"<td  style=\"text-align: right;\">个人健康状况：</td>"+
	                     		"<td  style=\"text-align: left;\">"+clntPerson.getHealth()+"</td>"+
	                     		"</tr>"+
	                     		"<tr>"+
	                     		"<td  style=\"text-align: right;\">户口性质:</td>"+
	                     		"<td  style=\"text-align: left;\" >"+clntPerson.getHousehold()+"</td>"+
	                     		"<td  style=\"text-align: right;\">居住状况：</td>"+
	                     		"<td  style=\"text-align: left;\">"+clntPerson.getRescondition()+"</td>"+
	                     		"</tr>"+
	                     		"<tr>"+
	                     		"<td  style=\"text-align: right;\">户口所属地区:</td>"+
	                     		"<td  style=\"text-align: left;\" colspan='3'>"+city+"</td>"+
	                     		"</tr>"+
	                     		"<tr>"+
	                     		"<td  style=\"text-align: right;\">通讯地址:</td>"+
	                     		"<td  style=\"text-align: left;\" colspan='3'>"+clntPerson.getAddress()+"</td>"+
	                     		"</tr>"+
	                     		"<tr>"+
	                     		"<td  style=\"text-align: right;\">邮政编码:</td>"+
	                     		"<td  style=\"text-align: left;\" >"+zip+"</td>"+
	                     		"<td  style=\"text-align: right;\">住址电话：</td>"+
	                     		"<td  style=\"text-align: left;\">"+hometel+"</td>"+
	                     		"</tr>"+
	                     		"<tr>"+
	                     		"<td  style=\"text-align: right;\">手机号:</td>"+
	                     		"<td  style=\"text-align: left;\" >"+clntPerson.getMobiletel()+"</td>"+
	                     		"<td  style=\"text-align: right;\">其它联系电话：</td>"+
	                     		"<td  style=\"text-align: left;\">"+othertel+"</td>"+
	                     		"</tr>"+
	                     		"<tr>"+
	                     		"<td  style=\"text-align: right;\">电子邮件:</td>"+
	                     		"<td  style=\"text-align: left;\" >"+email+"</td>"+
	                     		"<td  style=\"text-align: right;\">客户模式：</td>"+
	                     		"<td  style=\"text-align: left;\">"+clntPerson.getGrademodel()+"</td>"+
	                     		"</tr>"+
	                     		"<tr>"+
	                     		"<td  style=\"text-align: right;\">备注:</td>"+
	                     		"<td  style=\"text-align: left;\" colspan='3'>"+remark+"</td>"+
	                     		"</tr>"+
	                     		"<tr>"+
	                     		"<td  style=\"text-align: right;\">登记部门:</td>"+
	                     		"<td  style=\"text-align: left;\" >"+clntClient.getCertno()+"</td>"+
	                     		"<td  style=\"text-align: right;\">登记人：</td>"+
	                     		"<td  style=\"text-align: left;\">"+clntClient.getUserid() +"</td>"+
	                     		"</tr>"+
	                     		"</table>"+
	                     		"</div>" +
	                     		"</html>";  
	                      byte b[] = content.getBytes();  
	                     ByteArrayInputStream bais = new ByteArrayInputStream(b);  
	                      POIFSFileSystem poifs = new POIFSFileSystem();  
	                      DirectoryEntry directory = poifs.getRoot();  
	                      DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);  
	                      FileOutputStream ostream = new FileOutputStream(path+ fileName);  
	                      poifs.writeFilesystem(ostream);  
	                      bais.close();  
	                      ostream.close();
	                      result="{\"msg\":\"succ\",\"url\":\""+fileName+"\"}";
	                 }  
	             }  
	          } catch (IOException e) {  
	              e.printStackTrace();
	        } 
	         WebTool.writeJson(result, response);
	 		 return null;		          
	}
}
