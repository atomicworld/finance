package com.mf.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mf.common.pub.PubConstants;
import com.mf.sys.entity.CompanyInfo;
import com.mf.sys.entity.SysMappingtool;
import com.mf.sys.service.SysMappingtoolService;
import com.mf.util.Common;

@Service("mappingtoolService")
public class MappingtoolServiceImpl {

	@Autowired
	public CompanyInfoServiceImpl companyInfoService;
	@Autowired
	public SysMappingtoolService sysMappingtoolService;
	
	public String getSerialnumber(String date,String prekey){
		String waterID = "";
		CompanyInfo companyInfo = new CompanyInfo();
		companyInfo = companyInfoService.getCompanyInfo(companyInfo);
		String org=PubConstants.Org;//默认的机构号
		if(companyInfo!=null)
			org = companyInfo.getOrgcode();
		
		SysMappingtool sysMappingtool = new SysMappingtool();
		sysMappingtool.setDate(date);
		sysMappingtool.setPreKey(prekey);
		
		String num = sysMappingtoolService.getSerialnumber(sysMappingtool);
		synchronized(waterID) {
			//更新表数据
			num = Common.isEmpty(num)? "1" : String.valueOf(Integer.parseInt(num)+1);			
			sysMappingtool.setValue(num);
			sysMappingtoolService.modifySerialnumber(sysMappingtool);
			//生成key返回串
			waterID = org+date+ FormatNum(num,4);//公司机构号+年月日+流水
		}
		return waterID;
	}
	
	private String FormatNum(String num,int iLen){
		if(num.length()>iLen)//当Num大于4位的时候，从新循环
			num="1";
		for(int i= num.length(); i < iLen; i++) {
			num = "0" + num;
		}
		return num;
	}
	
}
