/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.entity;

import java.math.BigDecimal;


/**
 * @author xujiuhua
 * @2014-12-25
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class ClntEeReg implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "注册信息";
	public static final String ALIAS_CLNTNO = "客户号";
	public static final String ALIAS_RERETP = "登记注册类型";
	public static final String ALIAS_RERECODE = "营业执照号";
	public static final String ALIAS_REREDT = "注册有效期起始日";
	public static final String ALIAS_LICRETDT = "注册有效期结束日";
	public static final String ALIAS_CURTP = "注册币种";
	public static final String ALIAS_REGAMT = "注册资本";
	public static final String ALIAS_REGADD = "注册地址";
	public static final String ALIAS_ORGBARCODE = "组织结构代码";
	public static final String ALIAS_RUNRANGE = "经营范围";
	public static final String ALIAS_PROSITU = "主营业务";
	public static final String ALIAS_ADDRESS = "通讯地址";
	public static final String ALIAS_PHONE1 = "电话号码1";
	public static final String ALIAS_PHONE2 = "电话号码2";
	public static final String ALIAS_PHONE3 = "电话号码3";
	public static final String ALIAS_FAX = "传真号码";
	public static final String ALIAS_WEBADD = "网址";
	public static final String ALIAS_EMAIL = "邮箱地址";
	public static final String ALIAS_LINKMAN = "联系人";
	public static final String ALIAS_LINKMANTEL = "联系人手机号码";
	public static final String ALIAS_LOCTAXNO = "地税登记证号";
	public static final String ALIAS_GENTAXNO = "国税登记证号";
	public static final String ALIAS_FINRELA = "财务部联系方式";
	public static final String ALIAS_SHARENO = "股票代码";
	public static final String ALIAS_MARKPLACE = "上市地";
	public static final String ALIAS_FIELDAREA = "经营场地面积";
	public static final String ALIAS_MANAFDPROP = "经营场地所有权";
	
	//date formats
	
	public ClntEeReg(){
	}

	public ClntEeReg(
		java.lang.String clntno
	){
		this.clntno = clntno;
	}

	
	//columns START
	/**客户号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**登记注册类型==>db_column: RERETP*/
	private java.lang.String reretp;
	/**营业执照号==>db_column: RERECODE*/
	private java.lang.String rerecode;
	/**注册有效期起始日==>db_column: REREDT*/
	private java.lang.String reredt;
	/**注册有效期结束日==>db_column: LICRETDT*/
	private java.lang.String licretdt;
	/**注册币种==>db_column: CURTP*/
	private java.lang.String curtp;
	/**注册资本==>db_column: REGAMT*/
	private BigDecimal regamt;
	/**注册地址==>db_column: REGADD*/
	private java.lang.String regadd;
	/**组织结构代码==>db_column: ORGBARCODE*/
	private java.lang.String orgbarcode;
	/**经营范围==>db_column: RUNRANGE*/
	private java.lang.String runrange;
	/**主营业务==>db_column: PROSITU*/
	private java.lang.String prositu;
	/**通讯地址==>db_column: ADDRESS*/
	private java.lang.String address;
	/**电话号码1==>db_column: PHONE1*/
	private java.lang.String phone1;
	/**电话号码2==>db_column: PHONE2*/
	private java.lang.String phone2;
	/**电话号码3==>db_column: PHONE3*/
	private java.lang.String phone3;
	/**传真号码==>db_column: FAX*/
	private java.lang.String fax;
	/**网址==>db_column: WEBADD*/
	private java.lang.String webadd;
	/**邮箱地址==>db_column: EMAIL*/
	private java.lang.String email;
	/**联系人==>db_column: LINKMAN*/
	private java.lang.String linkman;
	/**联系人手机号码==>db_column: LINKMANTEL*/
	private java.lang.String linkmantel;
	/**地税登记证号==>db_column: LOCTAXNO*/
	private java.lang.String loctaxno;
	/**国税登记证号==>db_column: GENTAXNO*/
	private java.lang.String gentaxno;
	/**财务部联系方式==>db_column: FINRELA*/
	private java.lang.String finrela;
	/**股票代码==>db_column: SHARENO*/
	private java.lang.String shareno;
	/**上市地==>db_column: MARKPLACE*/
	private java.lang.String markplace;
	/**经营场地面积==>db_column: FIELDAREA*/
	private BigDecimal fieldarea;
	/**经营场地所有权==>db_column: MANAFDPROP*/
	private java.lang.String manafdprop;
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

	
	public java.lang.String getClntno() {
		return clntno;
	}
	
	public void setClntno(java.lang.String clntno) {
		this.clntno = clntno;
	}
	
	public void setReretp(java.lang.String value) {
		this.reretp = value;
	}
	

	public java.lang.String getReretp() {
		return this.reretp;
	}
	public void setRerecode(java.lang.String value) {
		this.rerecode = value;
	}
	
	public java.lang.String getRerecode() {
		return this.rerecode;
	}
	public void setReredt(java.lang.String value) {
		this.reredt = value;
	}
	
	public java.lang.String getReredt() {
		return this.reredt;
	}
	public void setLicretdt(java.lang.String value) {
		this.licretdt = value;
	}
	
	public java.lang.String getLicretdt() {
		return this.licretdt;
	}
	public void setCurtp(java.lang.String value) {
		this.curtp = value;
	}
	
	public java.lang.String getCurtp() {
		return this.curtp;
	}
	public void setRegamt(BigDecimal value) {
		this.regamt = value;
	}
	
	public BigDecimal getRegamt() {
		return this.regamt;
	}
	public void setRegadd(java.lang.String value) {
		this.regadd = value;
	}
	
	public java.lang.String getRegadd() {
		return this.regadd;
	}
	public void setOrgbarcode(java.lang.String value) {
		this.orgbarcode = value;
	}
	
	public java.lang.String getOrgbarcode() {
		return this.orgbarcode;
	}
	public void setRunrange(java.lang.String value) {
		this.runrange = value;
	}
	
	public java.lang.String getRunrange() {
		return this.runrange;
	}
	public void setPrositu(java.lang.String value) {
		this.prositu = value;
	}
	
	public java.lang.String getPrositu() {
		return this.prositu;
	}
	public void setAddress(java.lang.String value) {
		this.address = value;
	}
	
	public java.lang.String getAddress() {
		return this.address;
	}
	public void setPhone1(java.lang.String value) {
		this.phone1 = value;
	}
	
	public java.lang.String getPhone1() {
		return this.phone1;
	}
	public void setPhone2(java.lang.String value) {
		this.phone2 = value;
	}
	
	public java.lang.String getPhone2() {
		return this.phone2;
	}
	public void setPhone3(java.lang.String value) {
		this.phone3 = value;
	}
	
	public java.lang.String getPhone3() {
		return this.phone3;
	}
	public void setFax(java.lang.String value) {
		this.fax = value;
	}
	
	public java.lang.String getFax() {
		return this.fax;
	}
	public void setWebadd(java.lang.String value) {
		this.webadd = value;
	}
	
	public java.lang.String getWebadd() {
		return this.webadd;
	}
	public void setEmail(java.lang.String value) {
		this.email = value;
	}
	
	public java.lang.String getEmail() {
		return this.email;
	}
	public void setLinkman(java.lang.String value) {
		this.linkman = value;
	}
	
	public java.lang.String getLinkman() {
		return this.linkman;
	}
	public void setLinkmantel(java.lang.String value) {
		this.linkmantel = value;
	}
	
	public java.lang.String getLinkmantel() {
		return this.linkmantel;
	}
	public void setLoctaxno(java.lang.String value) {
		this.loctaxno = value;
	}
	
	public java.lang.String getLoctaxno() {
		return this.loctaxno;
	}
	public void setGentaxno(java.lang.String value) {
		this.gentaxno = value;
	}
	
	public java.lang.String getGentaxno() {
		return this.gentaxno;
	}
	public void setFinrela(java.lang.String value) {
		this.finrela = value;
	}
	
	public java.lang.String getFinrela() {
		return this.finrela;
	}
	public void setShareno(java.lang.String value) {
		this.shareno = value;
	}
	
	public java.lang.String getShareno() {
		return this.shareno;
	}
	public void setMarkplace(java.lang.String value) {
		this.markplace = value;
	}
	
	public java.lang.String getMarkplace() {
		return this.markplace;
	}
	public void setFieldarea(BigDecimal value) {
		this.fieldarea = value;
	}
	
	public BigDecimal getFieldarea() {
		return this.fieldarea;
	}
	public void setManafdprop(java.lang.String value) {
		this.manafdprop = value;
	}
	
	public java.lang.String getManafdprop() {
		return this.manafdprop;
	}
}

