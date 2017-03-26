/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.entity;

import java.math.BigDecimal;


/**
 * @author xujiuhua
 * @2014-12-16
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class ClntPersonResume implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "个人履历";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_CLNTNO = "客户号";
	public static final String ALIAS_BEGINDATE = "开始日期";
	public static final String ALIAS_EDNDATE = "结束日期";
	public static final String ALIAS_COMPANY = "所在单位";
	public static final String ALIAS_DEPARTMENT = "所在部门";
	public static final String ALIAS_DUTY = "担任职务";
	public static final String ALIAS_OCCTYPE = "单位性质";
	public static final String ALIAS_OCCTEL = "单位电话";
	public static final String ALIAS_OCCZIP = "单位邮政编码";
	public static final String ALIAS_MONTYLYINCOME = "月收入";
	public static final String ALIAS_OCCADDRESS = "单位地址";
	public static final String ALIAS_REMARK = "备注";
	
	//date formats
	
	public ClntPersonResume(){
	}

	public ClntPersonResume(
		java.lang.Integer id
	){
		this.id = id;
	}

	
	//columns START
	/**id==>db_column: ID*/
	private java.lang.Integer id;
	/**客户号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**开始日期==>db_column: BEGINDATE*/
	private java.lang.String begindate;
	/**结束日期==>db_column: EDNDATE*/
	private java.lang.String edndate;
	/**所在单位==>db_column: COMPANY*/
	private java.lang.String company;
	/**所在部门==>db_column: DEPARTMENT*/
	private java.lang.String department;
	/**担任职务==>db_column: DUTY*/
	private java.lang.String duty;
	/**单位性质==>db_column: OCCTYPE*/
	private java.lang.String occtype;
	/**单位电话==>db_column: OCCTEL*/
	private java.lang.String occtel;
	/**单位邮政编码==>db_column: OCCZIP*/
	private java.lang.String occzip;
	/**月收入==>db_column: MONTYLYINCOME*/
	private BigDecimal montylyincome;
	/**单位地址==>db_column: OCCADDRESS*/
	private java.lang.String occaddress;
	/**备注==>db_column: REMARK*/
	private java.lang.String remark;
	//columns END
	
	//系统框架字段 start
	
	private java.lang.String sort;
	private java.lang.String direction;
	public java.lang.String getSort() {
		return sort;
	}
	
	public void setSort(java.lang.String sort) {
		this.sort = sort;
	}
	
	public java.lang.String getDirection() {
		return direction;
	}
	
	public void setDirection(java.lang.String direction) {
		this.direction = direction;
	}
	//系统框架字段 end

	public void setId(java.lang.Integer value) {
		this.id = value;
	}
	
	public java.lang.Integer getId() {
		return this.id;
	}
	public void setClntno(java.lang.String value) {
		this.clntno = value;
	}
	
	public java.lang.String getClntno() {
		return this.clntno;
	}
	public void setBegindate(java.lang.String value) {
		this.begindate = value;
	}
	
	public java.lang.String getBegindate() {
		return this.begindate;
	}
	public void setEdndate(java.lang.String value) {
		this.edndate = value;
	}
	
	public java.lang.String getEdndate() {
		return this.edndate;
	}
	public void setCompany(java.lang.String value) {
		this.company = value;
	}
	
	public java.lang.String getCompany() {
		return this.company;
	}
	public void setDepartment(java.lang.String value) {
		this.department = value;
	}
	
	public java.lang.String getDepartment() {
		return this.department;
	}
	public void setDuty(java.lang.String value) {
		this.duty = value;
	}
	
	public java.lang.String getDuty() {
		return this.duty;
	}
	public void setOcctype(java.lang.String value) {
		this.occtype = value;
	}
	
	public java.lang.String getOcctype() {
		return this.occtype;
	}
	public void setOcctel(java.lang.String value) {
		this.occtel = value;
	}
	
	public java.lang.String getOcctel() {
		return this.occtel;
	}
	public void setOcczip(java.lang.String value) {
		this.occzip = value;
	}
	
	public java.lang.String getOcczip() {
		return this.occzip;
	}
	
	public BigDecimal getMontylyincome() {
		return montylyincome;
	}

	public void setMontylyincome(BigDecimal montylyincome) {
		this.montylyincome = montylyincome;
	}

	public void setOccaddress(java.lang.String value) {
		this.occaddress = value;
	}
	
	public java.lang.String getOccaddress() {
		return this.occaddress;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}

}

