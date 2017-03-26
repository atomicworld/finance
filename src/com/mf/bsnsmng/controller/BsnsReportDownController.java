package com.mf.bsnsmng.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.bsnsmng.entity.BsnsApply;
import com.mf.bsnsmng.entity.BsnsDiya;
import com.mf.bsnsmng.entity.BsnsZhiya;
import com.mf.bsnsmng.entity.Client;
import com.mf.bsnsmng.entity.ReportsmodelDown;
import com.mf.bsnsmng.service.BsnsApplyService;
import com.mf.bsnsmng.service.BsnsDiyaService;
import com.mf.bsnsmng.service.BsnsZyService;
import com.mf.bsnsmng.service.ClientService;
import com.mf.bsnsmng.service.ReportsmodelDownService;
import com.mf.client.entity.ClntPerson;
import com.mf.client.entity.ClntPersonFamily;
import com.mf.client.service.ClntPersonFamilyService;
import com.mf.client.service.ClntPersonService;
import com.mf.cntrtmng.entity.BsnsCntrct;
import com.mf.cntrtmng.service.BsnsCntrctService;
import com.mf.common.util.NOSUtil;
import com.mf.common.util.WaterIdGener;
import com.mf.sys.entity.CompanyInfo;
import com.mf.sys.entity.SysDictionary;
import com.mf.sys.service.SysDictionaryService;
import com.mf.sys.service.impl.CompanyInfoServiceImpl;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;


@Controller
@RequestMapping(value="/mf/bsnsreportdown/")
public class BsnsReportDownController {
	
	@Autowired
	private ReportsmodelDownService reportsmodelDownService;
	 @Autowired
	  private ClientService clientService;  
	  @Autowired
	  private BsnsApplyService bsnsApplyService; 
	  @Autowired
	  private ClntPersonService clntPersonService;
	  @Autowired
	  private SysDictionaryService sysDictionaryService;
	  @Autowired
	  private ClntPersonFamilyService clntPersonFamilyService;
	  @Autowired
	  private BsnsZyService bsnsZyService;
	  @Autowired
	  private BsnsDiyaService bsnsDiyaService;
	  @Autowired
		private BsnsCntrctService bsnsCntrctService;
	  @Autowired
		CompanyInfoServiceImpl  companyInfoService;
		
	  
	  
	  
	@RequestMapping(value="list")
	public String list(Model model,HttpServletRequest request){
		String clntId = request.getParameter("clntId");
		String applyno=request.getParameter("applyNo");
		model.addAttribute("clntId", clntId);
		model.addAttribute("applyno",applyno);
		return "/mf/bsnsmng/downmodel/list";
	}
	/** 
	 * @author made_in_heaven@foxmail.com
	 * @Description: TODO(跳到修改页面) 
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return 设定文件 
	 * @date 2015-7-14
	 */ 
	@RequestMapping(value="edit")
	public String edit(Model model,String reportno,String applyno,HttpServletResponse response,HttpServletRequest request){
		ReportsmodelDown  report=reportsmodelDownService.getById(reportno);
		model.addAttribute("report", report);
		model.addAttribute("applyno",applyno);
		return "/mf/bsnsmng/downmodel/edit";
	}
	
	
	/** 
	 * @author made_in_heaven@foxmail.com
	 * @Description: TODO新增) 
	 * @param @param model
	 * @param @param bsnsreport
	 * @param @param response
	 * @param @param request
	 * @param @return 设定文件 
	 * @date 2015-7-14
	 */ 
	@RequestMapping(value="addfile")
	public String add(Model model,ReportsmodelDown reportsmodelDown,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";;
		try {
		      DiskFileItemFactory factory = new DiskFileItemFactory();  
		      // 当上传文件太大时，因为虚拟机能使用的内存是有限的，所以此时要通过临时文件来实现上传文件的保存  
		      // 此方法是设置是否使用临时文件的临界值（单位：字节）  
		      factory.setSizeThreshold(10000);  
		      ServletFileUpload upload = new ServletFileUpload(factory); 
		      upload.setHeaderEncoding("utf-8");
		      List<File> items;
		      Map<String,String> map = new HashMap<String, String>();
				items = upload.parseRequest(request);
				Iterator iter = items.iterator();  
				
			      while (iter.hasNext()) {  
			          FileItem item = (FileItem) iter.next(); 
			          if (item.isFormField()) {  
			              //如果是普通表单字段  
			              String name = item.getFieldName();
			              String value= item.getString("utf-8");
						  map.put(name, value);
			          } else {  
			                  String fileName = item.getName();  
			                  //reportsmodelDown.setReportname(fileName);//文件名称
							  String filedName1=UUID.randomUUID()+fileName.substring(fileName.lastIndexOf("."),fileName.length());
			                  FileOutputStream fos;
								String path=request.getRealPath("/")+"Document"+File.separator+filedName1;
								//String path1="/Document/"+fileName;
								fos = new FileOutputStream(path);
								map.put("url",filedName1);
								if(item.isInMemory()){
										fos.write(item.get());
										fos.close();
								}else{
								    InputStream is=item.getInputStream();
								   	byte[] buffer=new byte[1024];
								   	int len;
							    	while((len=is.read(buffer))>0){
								    	fos.write(buffer,0,len);
								    }	
								    is.close();
								    fos.close();
								}
			            }  
			          }  
			      reportsmodelDown.setDownpath(map.get("url"));
			      reportsmodelDown.setMemo(map.get("memo"));
			      reportsmodelDown.setReportno(map.get("reportno"));
			      reportsmodelDown.setReportname(map.get("reportname"));
			      reportsmodelDownService.modify(reportsmodelDown);
			} catch (Exception e) {
				result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
				e.printStackTrace();
			}
			 WebTool.writeHtml(result, response);
			 return null;
			
			
			
		
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="query")
	@ResponseBody
	public Map<String, Object> showList(Model model, ReportsmodelDown reportsmodelDown, HttpServletRequest request) {
		PageView pageView = null;
		String pageNow = request.getParameter("pager.pageNo");
		String pageSize = request.getParameter("pager.pageSize");
		if (Common.isEmpty(pageNow))
			pageView = new PageView(1);
		else {
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map map = new HashMap();
		pageView =reportsmodelDownService.query(pageView, reportsmodelDown);
		List list = pageView.getRecords();
		map.put("rows", list);
		map.put("pager.pageNo", Integer.valueOf(pageView.getPageNow()));
		map.put("pager.totalRows", Long.valueOf(pageView.getRowCount()));
		return map;
	}
	
	
	
	/** 
	 * @author made_in_heaven@foxmail.com
	 * @Description: TODO(金格控件下载) 
	 * @param @param model
	 * @param @param applyno
	 * @param @param request
	 * @param @return 设定文件 
	 * @date 2015-7-14
	 */ 
	@RequestMapping(value = "expressWorld")
	public String printBill(Model model,String applyno, HttpServletRequest request) {
		String filename=request.getParameter("filename");//模板文件
		String type=request.getParameter("type");//报告编号
		
		BsnsApply apply=bsnsApplyService.getById(applyno);
		Client client=clientService.getById(apply.getClntno());
		ClntPerson person=clntPersonService.getByClntno(apply.getClntno());
		System.out.println("------apply------"+apply);
		System.out.println("-----client--------"+client);
		System.out.println("-----person--------"+person);
		String clntnm=apply.getClntnm()==null?" ":apply.getClntnm();
		String certno=client.getCertNo()==null?" ":client.getCertNo();
		String useno=apply.getUsedes()==null?" ":apply.getUsedes();
		String cardid="";
		String address="";
		String phone="";
		String hometel="";
		if (person!=null) {
			cardid=person.getCardid()==null?" ":person.getCardid();
			address=person.getAddress()==null?" ":person.getAddress();
			phone=person.getMobiletel()==null?" ":person.getMobiletel();
			hometel=person.getHometel()==null?" ":person.getHometel();
		}
		StringBuffer params=new StringBuffer();
		if("1".equals(type)){//贷款业务申请表
		
		params.append("clntnm,"+clntnm);//客户名称
		params.append(";certno,"+certno);//证件号
		params.append(";cardid,"+cardid);//贷款卡号
		params.append(";useno,"+useno);//贷款用途描述
		params.append(";address,"+address);//地址
		params.append(";amnt,"+apply.getApplyamnt());//申请金额
		params.append(";phone,"+phone);//手机
		params.append(";hometel,"+hometel);//家庭电话
		} else if("2".equals(type)){
			String sex="";
			if(certno!=" "){
				String num=certno.substring(16,17);
				
				int nums=Integer.parseInt(num);
				if(nums%2==0){
					sex="女";
				}else{
					sex="男";
				}
			}
			String  health="";
			String yn = "";
			if (person!=null) {
				health=person.getHealth()==null?" ":person.getHealth();
				yn=person.getMarriage()==null?" ":person.getMarriage();
			}
		
			ClntPersonFamily clntPersonFamily=new ClntPersonFamily();
			clntPersonFamily.setClntno(client.getClntId());
			List<ClntPersonFamily> member=clntPersonFamilyService.queryAll(clntPersonFamily);
			//apply.getApplyno()==null?" ":person.getHometel()
			params.append("clntnm,"+clntnm);//客户名称
			params.append(";certno,"+certno);//证件号
			params.append(";address,"+address);//地址
			params.append(";member,"+member.size());//家庭成员
			params.append(";applyno,"+applyno);//申请号
			params.append(";sex,"+sex);//性别
			params.append(";yn,"+yn);//婚姻状况
			params.append(";health,"+health);//性别
			
		}else if("3".equals(type)){//待审会决议单
			System.out.println("======="+apply.getTermtyp());
			System.out.println("======="+apply.getGrtway());
			SysDictionary sys=new SysDictionary();
			sys.setCode("2003");
			sys.setSdvalue(apply.getTermtyp());
			String termtyp=sysDictionaryService.findSysDictionary(sys).getSdkey();
			sys.setCode("2007");
			sys.setSdvalue(apply.getGrtway());
			String grtway=sysDictionaryService.findSysDictionary(sys).getSdkey();
			String dbname=" ";
			if("240003".equals(apply.getGrtway())){//质押
				BsnsZhiya zy=bsnsZyService.getById(applyno);
				if(zy!=null){
					dbname=zy.getOwnernm();
				}
			}else if("240002".equals(apply.getGrtway())){//抵押
				BsnsDiya dy=bsnsDiyaService.getById(applyno);
				if(dy!=null){
					dbname=dy.getOwnernm();
				}
			}
			params.append("clntnm,"+clntnm);//客户名称
			params.append(";applyamnt,"+apply.getApplyamnt().doubleValue());//申请金额
			params.append(";termtyp,"+termtyp);//期限种类
			params.append(";username,"+apply.getBsnsopnm());//信贷经理
			params.append(";dbname,"+dbname);//担保人
			params.append(";grtwaydtl,"+grtway);//担保方式
			
		}else if("4".equals(type)){//贷款担保承诺书
			CompanyInfo companyInfo= new CompanyInfo();
			companyInfo=companyInfoService.getCompanyInfo(companyInfo);
			BsnsCntrct cntrct=bsnsCntrctService.getByApplyno(applyno);
			params.append("clntnm,"+clntnm);//客户名称
			params.append(";company,"+companyInfo.getCmpnm());//客户名称
			String amnt=" ";
			String yyyy=" ";
			String mm=" ";
			String dd=" ";
			String cntrctno=" ";
			if(cntrct!=null){
				 amnt=NOSUtil.change(cntrct.getCntrctamnt().doubleValue());
				 yyyy=cntrct.getSgndate().substring(0,4);
				 mm=cntrct.getSgndate().substring(4,6);
				 dd=cntrct.getSgndate().substring(6,8);
				 cntrctno=cntrct.getCntrctno();
			}
			params.append(";cntrctno,"+cntrctno);//客户名称
			params.append(";yyyy,"+yyyy);//客户名称
			params.append(";mm,"+mm);//客户名称
			params.append(";dd,"+dd);//客户名称
			params.append(";amnt,"+amnt);//客户名称
			params.append(";cntrctno2,"+cntrctno);//客户名称
			
		}else if("5".equals(type)){//共同还款承诺书
			CompanyInfo companyInfo= new CompanyInfo();
			companyInfo=companyInfoService.getCompanyInfo(companyInfo);
			BsnsCntrct cntrct=bsnsCntrctService.getByApplyno(applyno);
			params.append("clntnm,"+clntnm);//客户名称
			params.append(";company,"+companyInfo.getCmpnm());//客户名称
			String cntrctno=" ";
			String yyyy=" ";
			String mm=" ";
			String dd=" ";
			if(cntrct!=null){
				 yyyy=cntrct.getSgndate().substring(0,4);
				 mm=cntrct.getSgndate().substring(4,6);
				 dd=cntrct.getSgndate().substring(6,8);
				cntrctno=cntrct.getCntrctno();//客户名称
			}
			params.append(";cntrctno,"+cntrctno);//客户名称
			params.append(";yyyy,"+yyyy);//客户名称
			params.append(";mm,"+mm);//客户名称
			params.append(";dd,"+dd);//客户名称
		}
		System.out.println(params.toString());
		model.addAttribute("params", params.toString());
		model.addAttribute("filename", filename);
		System.out.println(params.toString());
		return "/mf/temp/word";
	}
	
	/** 
	 * @author made_in_heaven@foxmail.com
	 * @Description: TODO(下载) 
	 * @param @param filename
	 * @param @param request
	 * @param @param response 设定文件 
	 * @date 2015-7-14
	 */ 
	@RequestMapping(value="upload")
	public void upload(String filename, HttpServletRequest request, HttpServletResponse response){
		try {
			 String path = request.getSession().getServletContext().getRealPath("/");  
			  
		        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型  
		        response.setContentType("multipart/form-data");  
		        //2.设置文件头：最后一个参数是设置下载文件名(假如我们叫a.pdf)  
		        response.setHeader("Content-Disposition", "attachment;fileName="+filename);  
		        ServletOutputStream out;  
		        //通过文件路径获得File对象(假如此路径中有一个download.pdf文件)  
		        System.out.println("============="+path+filename);
		        File file = new File(path +filename );  
		  
		        try {  
		            FileInputStream inputStream = new FileInputStream(file);  
		            //3.通过response获取ServletOutputStream对象(out)  
		            out = response.getOutputStream();  
		            int b = 0;  
		            byte[] buffer = new byte[512];  
		            while (b != -1){  
		                b = inputStream.read(buffer);  
		                //4.写到输出流(out)中  
		                out.write(buffer,0,b);  
		            }  
		            inputStream.close();  
		            out.close();  
		            out.flush();  
		        } catch (IOException e) {  
		            e.printStackTrace();  
		        }  
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
