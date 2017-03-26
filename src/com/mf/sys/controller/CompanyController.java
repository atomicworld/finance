package com.mf.sys.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.org.entity.Dept;
import com.mf.org.service.DeptService;
import com.mf.sys.entity.CompanyInfo;
import com.mf.sys.service.impl.CompanyInfoServiceImpl;

@Controller
@RequestMapping(value = "/mf/sys/company")
public class CompanyController {

	@Autowired
	CompanyInfoServiceImpl  companyInfoService;
	
	@Autowired
	DeptService deptService;
	
	
	@RequestMapping(value="/toEditCompany.html")
	public String list(HttpServletRequest request){
		//查询公司信息展示
		String isEdit=request.getParameter("isEdit");
		CompanyInfo companyInfo=new CompanyInfo();
		companyInfo=companyInfoService.getCompanyInfo(companyInfo);
		request.setAttribute("companyInfo", companyInfo);
		
        if("1".equals(isEdit)){
        	return "/mf/sys/company/company_edit";
		}else{
			return "/mf/sys/company/company_info";
		}
	}
	
	
	
	/**
	 * 更新公司信息
	 * @return
	 */
	@RequestMapping(value = "/updateCompanyInfo.html")
	@ResponseBody
	public Map<String,Object> updateCompanyInfo(CompanyInfo companyInfo){
		
		Map<String,Object> resltMap = new HashMap<String,Object>();
		try {
			//此处判断当前数据库中是否存在一条主键为1000的数据，如果存在 不操作 不存在 进行顶级部门初始化动作
			Dept dept=deptService.getDeptById("1000");
			if(dept==null){
				dept=new Dept();
				//dept.setDptno("1000");//插入语句自动生成
				dept.setUpdptno("1000");
				dept.setDptname("小额贷款公司");
				dept.setPostcd(companyInfo.getCmpno() == null
						|| "".equals(companyInfo.getCmpno()) ? "230000"
						: companyInfo.getCmpno());
				dept.setTel(companyInfo.getCmpnm());
				BigDecimal bgMax=new BigDecimal("999999999999");
				dept.setDptmax(bgMax);
				deptService.add(dept);
			}
			
			if(companyInfo.getOfficepriv() ==null || companyInfo.getOfficepriv().equals("")){
				companyInfo.setOfficepriv("0");
			}
			if(companyInfo.getFacadship() ==null || companyInfo.getFacadship().equals("")){
				companyInfo.setFacadship("0");
			}
			if(companyInfo.getComp_kind()== null || companyInfo.getComp_kind().equals("")){
				companyInfo.setComp_kind("0");
			}
			
			CompanyInfo companyHis=companyInfoService.getCompanyInfo(companyInfo);
			if(companyHis == null) {		
				companyInfo.setCmpno("D00001");
				companyInfo.setOrgcode("D00001");
				companyInfoService.add(companyInfo);
			} else {
				companyInfoService.update(companyInfo);
			}
			
			resltMap.put("resCode", 1);
			resltMap.put("resDesc", "更新成功！");
		} catch (Exception e) {
			e.printStackTrace();
			resltMap.put("resCode", 0);
			resltMap.put("resDesc", "异常:" + e.getMessage());
		}

		return resltMap;
	}
	
	

	
	

}
