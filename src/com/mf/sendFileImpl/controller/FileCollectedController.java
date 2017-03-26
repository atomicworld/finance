package com.mf.sendFileImpl.controller;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mf.businessInfo.entity.Fileupdown;
import com.mf.businessInfo.service.FileupdownService;
import com.mf.client.entity.ClntBlacklist;
import com.mf.client.entity.ClntClient;
import com.mf.client.entity.ClntEe;
import com.mf.client.entity.ClntPerson;
import com.mf.client.service.ClntBlacklistService;
import com.mf.client.service.ClntClientService;
import com.mf.client.service.ClntEeService;
import com.mf.client.service.ClntPersonService;
import com.mf.common.pub.PubConstants;
import com.mf.common.util.StringUtil;
import com.mf.sendFileImpl.entity.BlackList;
import com.mf.sendFileImpl.entity.BsnsApplyData;
import com.mf.sendFileImpl.entity.MyFile;
import com.mf.sendFileImpl.service.BsnsApplyDataService;
import com.mf.sendFileImpl.util.ClassDeal;
import com.mf.util.Common;

@Controller
@RequestMapping(value="/mf/compress/")
public class FileCollectedController {
	
	String t_date = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
	
	@Autowired
	private ClntBlacklistService clntBlacklistService;
	@Autowired
	private ClntClientService clntClientService;
	@Autowired
	private ClntPersonService clntPersonService;
	@Autowired 
	private ClntEeService clntEeService;
	@Autowired
	private BsnsApplyDataService bsnsApplyDataService;
	@Autowired
	private FileupdownService fileupdownService;
	
	@RequestMapping(value="list.html")
	public String list(){		
		return "/mf/sys/ImplFile/applylist";
	}
	
	//打包ZIP方法
	@RequestMapping(value="createZIP")
	public void createZIP(HttpServletRequest request, HttpServletResponse response){
		try{
			List<MyFile> list = new ArrayList<MyFile>();
			MyFile myf_1 = getBlackList();
			MyFile myf_2 = getBsnsApplyDataList(); 
			if(myf_1 != null)//查看是否存在 黑名单 或者 交易的数据
				list.add(myf_1);
			if(myf_2 != null)
				list.add(myf_2);
			//获取文件夹和文件名
			String zipFile = request.getSession().getServletContext().getRealPath("/upload")+"\\"+ PubConstants.Org +"_"+t_date+".zip";
			String fileName = zipFile.substring(zipFile.lastIndexOf(File.separator)+1);//得到文件名
			//当文件夹不存在，新建
			if ( !(new File(fileName)).isDirectory() ) {
				new File(fileName).mkdir();
			}
			//存储为ZIP文件
			CheckedOutputStream check = new CheckedOutputStream (new FileOutputStream(zipFile), new Adler32());
			ZipOutputStream zipOut = new ZipOutputStream(check);	//声明ZipOutputStream，用来输出zip文件.
			DataOutputStream out = new DataOutputStream(zipOut);	//利用DataOutputStream对ZipOutputStream进行包装。
			for (MyFile test : list){
				ZipEntry entry = new ZipEntry( test.getFilename() );	//声明ZipEntry
				zipOut.putNextEntry(entry);								//将entry加入到zipOut中。
			    out.writeChars(test.getContent().toString());			//输出zip文件
			}
			out.close();
			String filename1 =PubConstants.Org +"_"+t_date+".zip";
			//文件保存到数据库
			Fileupdown fd = new Fileupdown();
			fd.setFilename(fileName);
			fd.setUpday(Common.fromDateY());
			String filetype = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
			fd.setFiletype(filetype);
			fileupdownService.add(fd);
			
			//获得请求文件名  
			//1.设置文件ContentType类型，这样设置，会自动判断下载文件类型  
			response.setContentType("application/x-download");
	        //2.设置文件头：最后一个参数是设置下载文件名(假如我们叫a.pdf)  
	        response.setHeader( "Content-Disposition", "attachment;filename=" + new String( filename1.getBytes("gb2312"), "ISO8859-1" )+ "" );  
	        //读取目标文件，通过response将目标文件写到客户端  
	        //获取目标文件的绝对路径  
	        String path = request.getSession().getServletContext().getRealPath("/")+"upload"+File.separator;
	        String fullFileName = path + filename1;  
	        //System.out.println(fullFileName);  
	        //读取文件  
	        InputStream in = new FileInputStream(fullFileName);  
	        OutputStream out1 = response.getOutputStream();  
	        //写文件  
	        int b;  
	        while((b=in.read())!= -1)  
	        {  
	            out1.write(b);  
	        }  
	          
	        in.close();  
	        out1.close(); 
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//交易流水的List
	public MyFile getBsnsApplyDataList(){
		//设置文件名，和文件夹名字
		List<BsnsApplyData> list2 = new ArrayList<BsnsApplyData>();
		List<BsnsApplyData> list = bsnsApplyDataService.query1();
		//根据接口文件Flag的状态来判断，文件是否已经被生成了
		if(list!=null && list.size()>0){
			for (int i = 0; i < list.size(); i++) {
				BsnsApplyData bsnsApplyData = list.get(i);
				BsnsApplyData bsnsApplyList = new  BsnsApplyData();
				bsnsApplyList.setConCode(bsnsApplyData.getConCode());
				bsnsApplyList.setConAmount(bsnsApplyData.getConAmount());
				bsnsApplyList.setConSignDate(bsnsApplyData.getConSignDate());
				bsnsApplyList.setConStartDate(bsnsApplyData.getConStartDate());
				bsnsApplyList.setConYearRate(bsnsApplyData.getYearRate());
				bsnsApplyList.setConDelayYearRate(bsnsApplyData.getConDelayYearRate());
				bsnsApplyList.setLoanCode(bsnsApplyData.getLoanCode());
				bsnsApplyList.setLoanClass(bsnsApplyData.getLoanClass());
				bsnsApplyList.setConType(bsnsApplyData.getConType());
				bsnsApplyList.setCustClass(bsnsApplyData.getCustClass());
				bsnsApplyList.setCustName(bsnsApplyData.getCustName());
				bsnsApplyList.setCustIdno(bsnsApplyData.getCustIdno());
				bsnsApplyList.setCustScale(bsnsApplyData.getCustScale());
				bsnsApplyList.setLoanDate(bsnsApplyData.getLoanDate());
				bsnsApplyList.setSendDate(bsnsApplyData.getSendDate());
				bsnsApplyList.setExpireDate(bsnsApplyData.getExpireDate());
				bsnsApplyList.setYearRate(bsnsApplyData.getYearRate());
				bsnsApplyList.setDelayMonRate(bsnsApplyData.getDelayMonRate());
				bsnsApplyList.setAmount(bsnsApplyData.getAmount());
				bsnsApplyList.setSolutionWay(bsnsApplyData.getSolutionWay());
				bsnsApplyList.setLoanerType(bsnsApplyData.getLoanerType());
				bsnsApplyList.setLoanUsage(bsnsApplyData.getLoanUsage());
				bsnsApplyList.setLoanTrade(bsnsApplyData.getLoanTrade());
				bsnsApplyList.setLoanArea(bsnsApplyData.getLoanArea());
				bsnsApplyList.setRepaymentWay(bsnsApplyData.getRepaymentWay());
				bsnsApplyList.setReturnMode(bsnsApplyData.getReturnMode());
				bsnsApplyList.setDanbaoMode(bsnsApplyData.getDanbaoMode());
				bsnsApplyList.setRateProp(bsnsApplyData.getRateProp());
				bsnsApplyList.setStatus(bsnsApplyData.getStatus());
				bsnsApplyList.setReturnDate(bsnsApplyData.getReturnDate());
				bsnsApplyList.setRbeginDate(bsnsApplyData.getRbeginDate());
				bsnsApplyList.setRendDate(bsnsApplyData.getRendDate());
				bsnsApplyList.setDelayFee(bsnsApplyData.getDelayFee());
				bsnsApplyList.setDelayInterest(bsnsApplyData.getDelayInterest());
				bsnsApplyList.setReturnInterest(bsnsApplyData.getReturnInterest());
				bsnsApplyList.setReturnAmt(bsnsApplyData.getReturnAmt());
				bsnsApplyList.setIsDelay(bsnsApplyData.getIsDelay());
				bsnsApplyList.setIsTch(bsnsApplyData.getIsTch());
				list2.add(bsnsApplyList);
			}
			//封装数据
			String content  = ClassDeal.getBsnsApplyData(list2);
			MyFile myFile_2 = new MyFile();
			myFile_2.setContent(content);
			myFile_2.setFilename("CLDR_"+ PubConstants.Org +"_"+t_date+".xml");
			return myFile_2;
		}
		return null;
	}
	
	//黑名单客户的List
	public MyFile getBlackList(){
		List<BlackList> list_bklist = new ArrayList<BlackList>();
		ClntBlacklist clntBlacklist = new ClntBlacklist();
		List<ClntBlacklist> list = clntBlacklistService.queryUnSubmit(clntBlacklist);//找到所有未提交的黑名单客户
		if(list!=null && list.size()>0){
			for(int i=0;i<list.size();i++){
				ClntBlacklist clntBlacklist_t = list.get(i);
				String clntno = clntBlacklist_t.getClntno();
				ClntClient clntClient_t = clntClientService.getById(clntno);
				ClntPerson clntPerson_t = new ClntPerson();
				ClntEe clntEe_t = new ClntEe();
				if(clntClient_t.getClnttype().equals("2")){//个人客户
					clntPerson_t = clntPersonService.findByClntno(clntno);
				}else if(clntClient_t.getClnttype().equals("1")){//集团客户
					clntEe_t = clntEeService.FindByid(clntno);
				}
				BlackList blackList = new BlackList();
				blackList.setCustName(clntClient_t.getClntname());//客户名称
				blackList.setCustDocNo(clntClient_t.getCertno());//客户证件号（1:个人为身份证号，护照，其它;2:企业为组织机构代码或营业执照）
				blackList.setCustDoc(clntClient_t.getCerttype());//客户证件类别
				blackList.setCustType(clntClient_t.getClnttype());//客户类别（个人、企业）);
				blackList.setReason(clntBlacklist_t.getBlreason());//加入原因
				if(clntClient_t.getClnttype().equals("2")){
					blackList.setArea(clntPerson_t.getClntarea());//投放区域
				}else if(clntClient_t.getClnttype().equals("1")){
					blackList.setArea(clntEe_t.getClntarea());//投放区域
				}
				blackList.setRemark(clntBlacklist_t.getRemark());//备注
				blackList.setStatus(clntBlacklist_t.getValidflag());//状态（0：有效;1：作废）
				
				blackList.setTrade(clntBlacklist_t.getTrade());//客户所属行业
				blackList.setLoantrade(clntBlacklist_t.getLoantrade());//投放行业
				blackList.setValidDate(clntBlacklist_t.getValiddate());//有效起始日期（登记时间、更新时间）
				blackList.setInvalidDate(clntBlacklist_t.getInvaliddate());//有效终止日期
				list_bklist.add(blackList);
			}
			//封装数据
			String content  = ClassDeal.getBustString(list_bklist);
			MyFile myFile_1 = new MyFile();
			myFile_1.setContent(content);
			myFile_1.setFilename("BCUST_"+ PubConstants.Org +"_"+t_date+".xml");
			return myFile_1;
		}
		return null;
	}
	
}
