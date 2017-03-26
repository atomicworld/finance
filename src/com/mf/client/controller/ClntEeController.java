/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */


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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.client.entity.ClntClient;
import com.mf.client.entity.ClntEe;
import com.mf.client.service.ClntClientService;
import com.mf.client.service.ClntEeService;
import com.mf.common.pub.PubConstants;
import com.mf.pubparam.entity.Cities;
import com.mf.pubparam.entity.Industry;
import com.mf.pubparam.service.CitiesService;
import com.mf.pubparam.service.IndustryService;
import com.mf.util.Common;
import com.mf.util.FormatDateUtil;
import com.mf.util.PageView;
import com.mf.util.WebTool;
/**
 * @author xujiuhua
 * @2014-12-24
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/client/clntee/")
public class ClntEeController {
	
	@Autowired
	private ClntEeService clntEeService;
	@Autowired
	private ClntClientService clntClientService;
	@Autowired
	private CitiesService citiesService;
	@Autowired
	private IndustryService industryService;
	
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		return "/mf/clientmng/clntee/add";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param clntee
	 * @return
	 */
	@RequestMapping(value="save")
	public String add(Model model,ClntEe clntee,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";
		try {
			ClntEe ce = clntEeService.getById(clntee.getClntno());
			
			//add by hw，前台取出来的ce的induclass是一个字符数组型的数据，跟数据库对不上！
			if(!Common.isEmpty(clntee.getInduclass()) ){
				String[] str = clntee.getInduclass().split(",");
				String induclass_t = "";
				for(int i=0;i<str.length;i++){
					if( str[i].length()>induclass_t.length() )//获取最大的那个串
						induclass_t = str[i];
				}
				clntee.setInduclass(induclass_t);
			}
			
			if(null == ce){
				clntEeService.add(clntee);
			}else{
				clntee.setLastmoddate(FormatDateUtil.getFormatDate("yyyy-MM-dd"));
				clntEeService.modify(clntee);
			}
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	/**
	 * 保存新增--for 即时编辑
	 * @param model
	 * @param clntee
	 * @return
	 */
	@RequestMapping(value="addnull")
	public String addnull(Model model,HttpServletResponse response,HttpServletRequest request){
		String result="";
		try {
			ClntEe clntee = new ClntEe();
			clntEeService.addAll(clntee);
			result="{\"id\":" + clntee.getClntno() + ",\"message\":\"新增成功！\"}";
		} catch (Exception e) {
			result="{\"id\":\"0\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	/**
	 * 分页查询跳转
	 * @param model
	 * @param clntee
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="query")
	public String query(Model model,ClntEe clntee,String pageNow, String pageSize){
		return "/mf/clientmng/clntee/list_list";
	}
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param clntee
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,ClntEe clntee,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = clntEeService.query(pageView, clntee);
		List<ClntEe> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param clnteeId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			clntEeService.delete(ids);
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
	 * @param clnteeId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String clnteeId,int typeKey){
		ClntEe clntee = clntEeService.getById(clnteeId);
		model.addAttribute("clntee", clntee);
		if(typeKey == 1){
			return "/mf/clientmng/clntee/edit";
		}else if(typeKey == 2){
			return "/mf/clientmng/clntee/view";
		}else{
			return "/mf/clientmng/clntee/view_1";
		}
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param clntee
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateClntEe(Model model,ClntEe clntee,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";;
		try {			
			clntEeService.modify(clntee);
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
				clntEeService.delete(id);
			}
			result = "{\"status\":1,\"message\":\"删除成功！\"}";
		} catch (Exception e) {
			result="{\"status\":0,\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	@RequestMapping(value="childPage")
	public String childPage(Model model, String clntno, String pageType, HttpServletRequest request){
		ClntEe clntEe = clntEeService.getById(clntno);
		model.addAttribute("clntee", clntEe);
		ClntClient clntClient = clntClientService.getById(clntno);
		model.addAttribute("clntClient", clntClient);
		if(null == clntEe){
			pageType = PubConstants.PAGE_TYPE_EDIT;
		}else{
			pageType = PubConstants.PAGE_TYPE_VIEW;
		}
		request.setAttribute("pageType", pageType);
		return "/mf/clientmng/clntinfo/clntee/listlabel";
	}
	@RequestMapping(value = "getByClntno")
	public String getByClntno(Model model, String clntno, String pageType, HttpServletRequest request, String clntLeftMenu){
		ClntEe clntEe = clntEeService.getById(clntno);
		model.addAttribute("clntee", clntEe);
		ClntClient clntClient = clntClientService.getById(clntno);
		model.addAttribute("clntClient", clntClient);
		if(PubConstants.CLNT_LEFT_MENU_REL.equals(clntLeftMenu)){
			return "/mf/clientmng/clntrel/clntee/listlabel";
		}else if(PubConstants.CLNT_LEFT_MENU_EVENT.equals(clntLeftMenu)){
			return "/mf/clientmng/clntevent/clntee/listlabel";
		}else{
			model.addAttribute("flag", request.getParameter("flag"));
			
			if(PubConstants.PAGE_TYPE_EDIT.equals(pageType)){
				return "/mf/clientmng/clntinfo/clntee/edit";
			}else if(PubConstants.PAGE_TYPE_VIEW.equals(pageType)){
				model.addAttribute("view", request.getParameter("view"));
				return "/mf/clientmng/clntinfo/clntee/view";
			}else {
				return "/mf/clientmng/clntinfo/clntee/view";
			}
		}
	}
	@RequestMapping(value = "printClienttWord")
	public String printClienttWord(HttpServletResponse response,HttpServletRequest request,String clntno) {
				  String  result="{\"msg\":\"failed\"}";
		          String path = request.getRealPath("/")+"Document"+File.separator+"upload"+File.separator;  
		          String fileName="";
		          clntno=clntno.trim();
		          ClntEe clntee = clntEeService.FindByid(clntno);
		  		  ClntClient clntClient = clntClientService.getById(clntno);
		  		  Cities cities=citiesService.getById(clntee.getClntarea());
		  		 Industry industry= industryService.findByCode(clntee.getInduclass());
		  		 String clntnameonce="";//客户曾用名
		  		 if(clntee.getClntnameonce()!=null){
		  			clntnameonce=clntee.getClntnameonce();
		  		 }
		  		String clntnameeng="";//客户英文名
		  		 if(clntee.getClntnameeng()!=null){
		  			clntnameeng=clntee.getClntnameeng();
		  		 }
		  		String lncardno="";//贷款卡编码
		  		 if(clntee.getLncardno()!=null){
		  			lncardno=clntee.getLncardno();
		  		 }
		  		String deptcode="";//机构代码
		  		 if(clntee.getDeptcode()!=null){
		  			deptcode=clntee.getDeptcode();
		  		 }
		  		String finacode="";//金融机构代码
		  		 if(clntee.getFinacode()!=null){
		  			finacode=clntee.getFinacode();
		  		 }
		  		String bussdate="";//业务发生日期
		  		 if(clntee.getBussdate()!=null){
		  			bussdate=clntee.getBussdate();
		  		 }
		  		String zip="";//邮政编码
		  		 if(clntee.getZip()!=null){
		  			zip=clntee.getZip();
		  		 }
		  		int empnum=0;//从业人数
		  		 if(clntee.getEmpnum()!=null){
		  			empnum=clntee.getEmpnum();
		  		 }
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
		                     		"<span style=\"font-family: 黑体;font-size: 28px;width: 75%\">对公客户信息<br /></span>" +
		                     		"<table style=\"width: 750px;\">"+
		                     		"<tr>"+
		                     		"<td  style=\"text-align: right;width:23%\">客户编号:</td>"+
		                     		"<td  style=\"text-align: left;width:32%\" >"+clntClient.getClntid()+"</td>"+
		                     		"<td  style=\"text-align: right;width:23%\">客户名称：</td>"+
		                     		"<td  style=\"text-align: left;width:22%\">"+clntClient.getClntname()+"</td>"+
		                     		"</tr>"+
		                     		"<tr>"+
		                     		"<td  style=\"text-align: right;\">客户曾用名:</td>"+
		                     		"<td  style=\"text-align: left;\" >"+clntnameonce+"</td>"+
		                     		"<td  style=\"text-align: right;\">客户英文名：</td>"+
		                     		"<td  style=\"text-align: left;\">"+clntnameeng+"</td>"+
		                     		"</tr>"+
		                     		"<tr>"+
		                     		"<td  style=\"text-align: right;\">客户类别:</td>"+
		                     		"<td  style=\"text-align: left;\" >"+clntee.getClntcategory()+"</td>"+
		                     		"<td  style=\"text-align: right;\">贷款卡编码：</td>"+
		                     		"<td  style=\"text-align: left;\">"+lncardno+"</td>"+
		                     		"</tr>"+
		                     		"<tr>"+
		                     		"<td  style=\"text-align: right;\">机构代码:</td>"+
		                     		"<td  style=\"text-align: left;\" >"+deptcode+"</td>"+
		                     		"<td  style=\"text-align: right;\">金融机构代码：</td>"+
		                     		"<td  style=\"text-align: left;\">"+finacode+"</td>"+
		                     		"</tr>"+
		                     		"<tr>"+
		                     		"<td  style=\"text-align: right;\">业务发生日期:</td>"+
		                     		"<td  style=\"text-align: left;\" >"+bussdate+"</td>"+
		                     		"<td  style=\"text-align: right;\">企业国别：</td>"+
		                     		"<td  style=\"text-align: left;\">"+clntee.getBnation()+"</td>"+
		                     		"</tr>"+
		                     		"<tr>"+
		                     		"<td  style=\"text-align: right;\">企业性质:</td>"+
		                     		"<td  style=\"text-align: left;\" >"+clntee.getBprop()+"</td>"+
		                     		"<td  style=\"text-align: right;\">企业规模：</td>"+
		                     		"<td  style=\"text-align: left;\">"+clntee.getBcharac()+"</td>"+
		                     		"</tr>"+
		                     		"<tr>"+
		                     		"<td  style=\"text-align: right;\">企业所属地区:</td>"+
		                     		"<td  style=\"text-align: left;\" colspan=\"3\">"+cities.getName()+"</td>"+
		                     		"</tr>"+
		                     		"<tr>"+
		                     		"<td  style=\"text-align: right;\">邮政编码:</td>"+
		                     		"<td  style=\"text-align: left;\" >"+zip+"</td>"+
		                     		"</tr>"+
		                     		"<tr>"+
		                     		"<td  style=\"text-align: right;\">行业分类:</td>"+
		                     		"<td  style=\"text-align: left;\" colspan=\"3\">"+industry.getIndustryName()+"</td>"+
		                     		"</tr>"+
		                     		"<tr>"+
		                     		"<td  style=\"text-align: right;\">成立时间:</td>"+
		                     		"<td  style=\"text-align: left;\" >"+clntee.getEstablish()+"</td>"+
		                     		"<td  style=\"text-align: right;\">从业人数：</td>"+
		                     		"<td  style=\"text-align: left;\">"+empnum+"</td>"+
		                     		"</tr>"+
		                     		"<tr>"+
		                     		"<td  style=\"text-align: right;\">集团客户标志:</td>"+
		                     		"<td  style=\"text-align: left;\" >"+clntee.getGrpcustfg()+"</td>"+
		                     		"<td  style=\"text-align: right;\">进出口权标志：</td>"+
		                     		"<td  style=\"text-align: left;\">"+clntee.getFortdrtfg()+"</td>"+
		                     		"</tr>"+
		                     		"<tr>"+
		                     		"<td  style=\"text-align: right;\">上市公司标志:</td>"+
		                     		"<td  style=\"text-align: left;\" >"+clntee.getMktcorfg()+"</td>"+
		                     		"<td  style=\"text-align: right;\">客户模式：</td>"+
		                     		"<td  style=\"text-align: left;\">"+clntee.getGrademodel()+"</td>"+
		                     		"</tr>"+
		                     		"<tr>"+
		                     		"<td  style=\"text-align: right;\">集团客户标志:</td>"+
		                     		"<td  style=\"text-align: left;\" >"+clntee.getGrpcustfg()+"</td>"+
		                     		"<td  style=\"text-align: right;\">进出口权标志：</td>"+
		                     		"<td  style=\"text-align: left;\">"+clntee.getFortdrtfg()+"</td>"+
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

