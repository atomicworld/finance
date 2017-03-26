/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.shareholder.entity;

import com.mf.base.BaseEntity;

/**
 * @author wangyw
 * @2015-08-22
 * @version 1.0
 * @param <T>
 */

public class CorpSharedetail extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "CorpSharedetail";
	public static final String ALIAS_SHARENO = "股东编号";
	public static final String ALIAS_CORP_TYPE = "公司类型";
	public static final String ALIAS_OWNER_SHIP = "所有制性质";
	public static final String ALIAS_ESTABLISH_DATE = "公司成立日期";
	public static final String ALIAS_TRADE = "公司所属行业";
	public static final String ALIAS_REMARK = "备注";
	public static final String ALIAS_BUSI_ADDRESS = "营业地址";
	public static final String ALIAS_POSTAL = "营业地邮编";
	public static final String ALIAS_REG_CODE = "工商注册号";
	public static final String ALIAS_REG_INSTITUTE = "注册机关";
	public static final String ALIAS_REG_ADDRESS = "工商注册地址";
	public static final String ALIAS_REG_AMOUNT = "注册资本(万元)";
	public static final String ALIAS_REPRESENTER_NAME = "法定代表人";
	public static final String ALIAS_REPRESENTER_DOC = "法定代表人证件号";
	public static final String ALIAS_RUN_START_TIME = "经营期限起始日期";
	public static final String ALIAS_RUN_END_TIME = "经营期限终止日期";
	public static final String ALIAS_RUN_SCOPE = "经营范围";
	public static final String ALIAS_LINK_MAN = "联系人";
	public static final String ALIAS_TEL = "联系人电话";
	public static final String ALIAS_FAX = "传真";
	public static final String ALIAS_EMAIL = "E-mail";
	public static final String ALIAS_WEB_SITE = "公司网址";
	
	//columns START
	/**股东编号==>db_column: shareno*/
	private java.lang.String shareno;
	/**公司类型==>db_column: corpType*/
	private java.lang.String corpType;
	/**所有制性质==>db_column: ownerShip*/
	private java.lang.String ownerShip;
	/**公司成立日期==>db_column: establishDate*/
	private java.lang.String establishDate;
	/**公司所属行业==>db_column: trade*/
	private java.lang.String trade;
	/**备注==>db_column: remark*/
	private java.lang.String remark;
	/**营业地址==>db_column: BusiAddress*/
	private java.lang.String busiAddress;
	/**营业地邮编==>db_column: Postal*/
	private java.lang.String postal;
	/**工商注册号==>db_column: RegCode*/
	private java.lang.String regCode;
	/**注册机关==>db_column: RegInstitute*/
	private java.lang.String regInstitute;
	/**工商注册地址==>db_column: RegAddress*/
	private java.lang.String regAddress;
	/**注册资本(万元)==>db_column: RegAmount*/
	private Long regAmount;
	/**法定代表人==>db_column: RepresenterName*/
	private java.lang.String representerName;
	/**法定代表人证件号==>db_column: RepresenterDoc*/
	private java.lang.String representerDoc;
	/**经营期限起始日期==>db_column: RunStartTime*/
	private java.lang.String runStartTime;
	/**经营期限终止日期==>db_column: RunEndTime*/
	private java.lang.String runEndTime;
	/**经营范围==>db_column: RunScope*/
	private java.lang.String runScope;
	/**联系人==>db_column: LinkMan*/
	private java.lang.String linkMan;
	/**联系人电话==>db_column: Tel*/
	private java.lang.String tel;
	/**传真==>db_column: Fax*/
	private java.lang.String fax;
	/**E-mail==>db_column: Email*/
	private java.lang.String email;
	/**公司网址==>db_column: WebSite*/
	private java.lang.String webSite;
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

	public void setShareno(java.lang.String value) {
		this.shareno = value;
	}
	
	public java.lang.String getShareno() {
		return this.shareno;
	}
	public void setCorpType(java.lang.String value) {
		this.corpType = value;
	}
	
	public java.lang.String getCorpType() {
		return this.corpType;
	}
	public void setOwnerShip(java.lang.String value) {
		this.ownerShip = value;
	}
	
	public java.lang.String getOwnerShip() {
		return this.ownerShip;
	}
	public void setEstablishDate(java.lang.String value) {
		this.establishDate = value;
	}
	
	public java.lang.String getEstablishDate() {
		return this.establishDate;
	}
	public void setTrade(java.lang.String value) {
		this.trade = value;
	}
	
	public java.lang.String getTrade() {
		return this.trade;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}
	public void setBusiAddress(java.lang.String value) {
		this.busiAddress = value;
	}
	
	public java.lang.String getBusiAddress() {
		return this.busiAddress;
	}
	public void setPostal(java.lang.String value) {
		this.postal = value;
	}
	
	public java.lang.String getPostal() {
		return this.postal;
	}
	public void setRegCode(java.lang.String value) {
		this.regCode = value;
	}
	
	public java.lang.String getRegCode() {
		return this.regCode;
	}
	public void setRegInstitute(java.lang.String value) {
		this.regInstitute = value;
	}
	
	public java.lang.String getRegInstitute() {
		return this.regInstitute;
	}
	public void setRegAddress(java.lang.String value) {
		this.regAddress = value;
	}
	
	public java.lang.String getRegAddress() {
		return this.regAddress;
	}
	public void setRegAmount(Long value) {
		this.regAmount = value;
	}
	
	public Long getRegAmount() {
		return this.regAmount;
	}
	public void setRepresenterName(java.lang.String value) {
		this.representerName = value;
	}
	
	public java.lang.String getRepresenterName() {
		return this.representerName;
	}
	public void setRepresenterDoc(java.lang.String value) {
		this.representerDoc = value;
	}
	
	public java.lang.String getRepresenterDoc() {
		return this.representerDoc;
	}
	public void setRunStartTime(java.lang.String value) {
		this.runStartTime = value;
	}
	
	public java.lang.String getRunStartTime() {
		return this.runStartTime;
	}
	public void setRunEndTime(java.lang.String value) {
		this.runEndTime = value;
	}
	
	public java.lang.String getRunEndTime() {
		return this.runEndTime;
	}
	public void setRunScope(java.lang.String value) {
		this.runScope = value;
	}
	
	public java.lang.String getRunScope() {
		return this.runScope;
	}
	public void setLinkMan(java.lang.String value) {
		this.linkMan = value;
	}
	
	public java.lang.String getLinkMan() {
		return this.linkMan;
	}
	public void setTel(java.lang.String value) {
		this.tel = value;
	}
	
	public java.lang.String getTel() {
		return this.tel;
	}
	public void setFax(java.lang.String value) {
		this.fax = value;
	}
	
	public java.lang.String getFax() {
		return this.fax;
	}
	public void setEmail(java.lang.String value) {
		this.email = value;
	}
	
	public java.lang.String getEmail() {
		return this.email;
	}
	public void setWebSite(java.lang.String value) {
		this.webSite = value;
	}
	
	public java.lang.String getWebSite() {
		return this.webSite;
	}

}

