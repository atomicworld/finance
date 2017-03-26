/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2016
 */

package com.mf.businessInfo.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.mf.base.BaseEntity;

/**
 * @author wangyw
 * @2016-01-06
 * @version 1.0
 * @param <T>
 */

public class Checkinfo extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Checkinfo";
	public static final String ALIAS_BANKBILLID = "bankbillid";
	public static final String ALIAS_RPTYEAR = "rptyear";
	public static final String ALIAS_RPTMONTH = "rptmonth";
	public static final String ALIAS_RPTDAY = "rptday";
	public static final String ALIAS_SUMMERY = "summery";
	public static final String ALIAS_BLANCHOUT = "blanchout";
	public static final String ALIAS_BLANCHIN = "blanchin";
	public static final String ALIAS_LEFTAMOUNT = "leftamount";
	public static final String ALIAS_LEFTDATETIME = "leftdatetime";
	public static final String ALIAS_ORGCODE = "orgcode";
	public static final String ALIAS_CREATEBY = "createby";
	public static final String ALIAS_CREATEDATE = "createdate";
	public static final String ALIAS_UPDATEBY = "updateby";
	public static final String ALIAS_UPDATEDATE = "updatedate";
	public static final String ALIAS_OUTCNT = "outcnt";
	public static final String ALIAS_INCNT = "incnt";
	public static final String ALIAS_RPTDATE = "rptdate";
	public static final String ALIAS_BANKNAME = "bankname";
	public static final String ALIAS_BANKACC = "bankacc";
	public static final String ALIAS_RPTSTATUS = "rptstatus";
	public static final String ALIAS_RPTBATCH = "rptbatch";
	
	//date formats
	public static final String FORMAT_LEFTDATETIME = DATE_FORMAT;
	public static final String FORMAT_CREATEDATE = DATE_FORMAT;
	public static final String FORMAT_UPDATEDATE = DATE_FORMAT;
	
	public Checkinfo(){
	}

	public Checkinfo(
		java.lang.String bankbillid
	){
		this.bankbillid = bankbillid;
	}

	
	//columns START
	/**bankbillid==>db_column: BANKBILLID*/
	private java.lang.String bankbillid;
	/**rptyear==>db_column: '对账单年份' RPTYEAR*/
	private java.lang.Integer rptyear;
	/**rptmonth==>db_column: RPTMONTH*/
	private java.lang.Integer rptmonth;
	/**rptday==>db_column:  '对账单日期';RPTDAY*/
	private java.lang.Integer rptday;
	/**summery==>db_column:'摘要 SUMMERY*/
	private java.lang.String summery;
	/**blanchout==>db_column: '支出金额'; BLANCHOUT*/
	private String blanchout;
	/**blanchin==>db_column:  '收入金额' BLANCHIN*/
	private String blanchin;
	/**leftamount==>db_column: LEFTAMOUNT*/
	private String leftamount;
	private String leftdatetimeBegin;
	private String leftdatetimeEnd;
	private String leftdatetime;
	
	public String getLeftdatetimeBegin() {
		return this.leftdatetimeBegin;
	}
	
	public void setLeftdatetimeBegin(String value) {
		this.leftdatetimeBegin = value;
	}	
	
	public String getLeftdatetimeEnd() {
		return this.leftdatetimeEnd;
	}
	
	public void setLeftdatetimeEnd(String value) {
		this.leftdatetimeEnd = value;
	}
	
	/**orgcode==>db_column: ORGCODE*/
	private java.lang.String orgcode;
	/**createby==>db_column: CREATEBY*/
	private java.lang.String createby;
	private String createdateBegin;
	private String createdateEnd;
	private String createdate;
	
	public String getCreatedateBegin() {
		return this.createdateBegin;
	}
	
	public void setCreatedateBegin(String value) {
		this.createdateBegin = value;
	}	
	
	public String getCreatedateEnd() {
		return this.createdateEnd;
	}
	
	public void setCreatedateEnd(String value) {
		this.createdateEnd = value;
	}
	
	/**updateby==>db_column: UPDATEBY*/
	private java.lang.String updateby;
	private String updatedateBegin;
	private String updatedateEnd;
	private String updatedate;
	
	public String getUpdatedateBegin() {
		return this.updatedateBegin;
	}
	
	public void setUpdatedateBegin(String value) {
		this.updatedateBegin = value;
	}	
	
	public String getUpdatedateEnd() {
		return this.updatedateEnd;
	}
	
	public void setUpdatedateEnd(String value) {
		this.updatedateEnd = value;
	}
	
	/**outcnt==>db_column: '本月共支出笔数'OUTCNT*/
	private java.lang.Integer outcnt;
	/**incnt==>db_column: '本月共收入笔数';INCNT*/
	private java.lang.Integer incnt;
	/**rptdate==>db_column: RPTDATE*/
	private java.lang.Integer rptdate;
	/**bankname==>db_column: '银行名称'; BANKNAME*/
	private java.lang.String bankname;
	/**bankacc==>db_column: '银行账号';BANKACC*/
	private java.lang.String bankacc;
	/**rptstatus==>db_column: RPTSTATUS*/
	private java.lang.Integer rptstatus;
	/**rptbatch==>db_column: RPTBATCH*/
	private java.lang.String rptbatch;
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

	public void setBankbillid(java.lang.String value) {
		this.bankbillid = value;
	}
	
	public java.lang.String getBankbillid() {
		return this.bankbillid;
	}
	public void setRptyear(java.lang.Integer value) {
		this.rptyear = value;
	}
	
	public java.lang.Integer getRptyear() {
		return this.rptyear;
	}
	public void setRptmonth(java.lang.Integer value) {
		this.rptmonth = value;
	}
	
	public java.lang.Integer getRptmonth() {
		return this.rptmonth;
	}
	public void setRptday(java.lang.Integer value) {
		this.rptday = value;
	}
	
	public java.lang.Integer getRptday() {
		return this.rptday;
	}
	public void setSummery(java.lang.String value) {
		this.summery = value;
	}
	
	public java.lang.String getSummery() {
		return this.summery;
	}
	public void setBlanchout(String value) {
		this.blanchout = value;
	}
	
	public String getBlanchout() {
		return this.blanchout;
	}
	public void setBlanchin(String value) {
		this.blanchin = value;
	}
	
	public String getBlanchin() {
		return this.blanchin;
	}
	public void setLeftamount(String value) {
		this.leftamount = value;
	}
	
	public String getLeftamount() {
		return this.leftamount;
	}
	public void setLeftdatetime(String value) {
		this.leftdatetime = value;
	}
	
	public String getLeftdatetime() {
		return this.leftdatetime;
	}
	public void setOrgcode(java.lang.String value) {
		this.orgcode = value;
	}
	
	public java.lang.String getOrgcode() {
		return this.orgcode;
	}
	public void setCreateby(java.lang.String value) {
		this.createby = value;
	}
	
	public java.lang.String getCreateby() {
		return this.createby;
	}
	public void setCreatedate(String value) {
		this.createdate = value;
	}
	
	public String getCreatedate() {
		return this.createdate;
	}
	public void setUpdateby(java.lang.String value) {
		this.updateby = value;
	}
	
	public java.lang.String getUpdateby() {
		return this.updateby;
	}
	public void setUpdatedate(String value) {
		this.updatedate = value;
	}
	
	public String getUpdatedate() {
		return this.updatedate;
	}
	public void setOutcnt(java.lang.Integer value) {
		this.outcnt = value;
	}
	
	public java.lang.Integer getOutcnt() {
		return this.outcnt;
	}
	public void setIncnt(java.lang.Integer value) {
		this.incnt = value;
	}
	
	public java.lang.Integer getIncnt() {
		return this.incnt;
	}
	public void setRptdate(java.lang.Integer value) {
		this.rptdate = value;
	}
	
	public java.lang.Integer getRptdate() {
		return this.rptdate;
	}
	public void setBankname(java.lang.String value) {
		this.bankname = value;
	}
	
	public java.lang.String getBankname() {
		return this.bankname;
	}
	public void setBankacc(java.lang.String value) {
		this.bankacc = value;
	}
	
	public java.lang.String getBankacc() {
		return this.bankacc;
	}
	public void setRptstatus(java.lang.Integer value) {
		this.rptstatus = value;
	}
	
	public java.lang.Integer getRptstatus() {
		return this.rptstatus;
	}
	public void setRptbatch(java.lang.String value) {
		this.rptbatch = value;
	}
	
	public java.lang.String getRptbatch() {
		return this.rptbatch;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Bankbillid",getBankbillid())
			.append("Rptyear",getRptyear())
			.append("Rptmonth",getRptmonth())
			.append("Rptday",getRptday())
			.append("Summery",getSummery())
			.append("Blanchout",getBlanchout())
			.append("Blanchin",getBlanchin())
			.append("Leftamount",getLeftamount())
			.append("Leftdatetime",getLeftdatetime())
			.append("Orgcode",getOrgcode())
			.append("Createby",getCreateby())
			.append("Createdate",getCreatedate())
			.append("Updateby",getUpdateby())
			.append("Updatedate",getUpdatedate())
			.append("Outcnt",getOutcnt())
			.append("Incnt",getIncnt())
			.append("Rptdate",getRptdate())
			.append("Bankname",getBankname())
			.append("Bankacc",getBankacc())
			.append("Rptstatus",getRptstatus())
			.append("Rptbatch",getRptbatch())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getBankbillid())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Checkinfo == false) return false;
		if(this == obj) return true;
		Checkinfo other = (Checkinfo)obj;
		return new EqualsBuilder()
			.append(getBankbillid(),other.getBankbillid())
			.isEquals();
	}
}

