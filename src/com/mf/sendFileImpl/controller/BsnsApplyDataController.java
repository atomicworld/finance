/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */


package com.mf.sendFileImpl.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.businessInfo.entity.Fileupdown;
import com.mf.businessInfo.service.FileupdownService;
import com.mf.common.pub.PubConstants;
import com.mf.common.util.StringUtil;
import com.mf.sendFileImpl.entity.BsnsApplyData;
import com.mf.sendFileImpl.service.BsnsApplyDataService;
import com.mf.sendFileImpl.util.ClassDeal;
import com.mf.sendFileImpl.util.CompressZIP;
import com.mf.util.Common;
import com.mf.util.WebTool;
/**
 * @author wangzhi
 * @2015-09-08
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/bsnsapplydata/")
public class BsnsApplyDataController {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	@Autowired
	private BsnsApplyDataService bsnsApplyDataService;
	@Autowired
	private FileupdownService fileupdownService;
	
	@RequestMapping(value="list.html")
	public String list(){		
		return "/mf/sys/ImplFile/applylist";
	}
	
	@RequestMapping(value="createXML")
	@ResponseBody
	public String createXML(HttpServletResponse response,HttpServletRequest request){
		String result = "{\"msg\":\"suc\"}";
		try {
			List<BsnsApplyData> list = bsnsApplyDataService.query1();
			//根据接口文件Flag的状态来判断，文件是否已经被生成了
			if(list.size()>0){
				List<BsnsApplyData> list2 = new ArrayList<BsnsApplyData>();
				//设置文件名，和文件夹名字
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
				String t_date = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
				String filename = "BUST_"+ PubConstants.Org +"_"+t_date+".xml"; 
				String zipFile = request.getSession().getServletContext().getRealPath("/upload")+"\\"+ PubConstants.Org +"_"+t_date+".zip";
				System.out.println("生成路径是：========"+zipFile);
				//生成文件
				String str = ClassDeal.getBsnsApplyData(list2);
				CompressZIP.packXML(str, filename, zipFile);
				Fileupdown fd = new Fileupdown();
				String filename1 =PubConstants.Org +"_"+t_date+".zip";
				fd.setFilename(filename1);
				fd.setUpday(Common.fromDateY());
				String filetype = filename1.substring(filename1.lastIndexOf(".")+1,filename1.length());
				fd.setFiletype(filetype);
				
				fileupdownService.add(fd);
			}
			result="{\"msg\":\"suc\"}";
		} catch (Exception e) {
			result = "{\"msg\":\"fail\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		 return null;
	}
	
}

