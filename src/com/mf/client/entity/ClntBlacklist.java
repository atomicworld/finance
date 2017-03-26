/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.client.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author xujiuhua
 * @2015-01-05
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class ClntBlacklist implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "黑名单客户管理";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_CLNTNO = "客户号";
	public static final String ALIAS_BLDEGREE = "黑名单等级";
	public static final String ALIAS_APPRUSERID = "批准人";
	public static final String ALIAS_BLREASON = "划入黑名单原因";
	public static final String ALIAS_VALIDFLAG = "生效状态";
	public static final String ALIAS_SCDATE = "登记日期";
	public static final String ALIAS_LASTMODDATE = "更新日期";
	public static final String ALIAS_USERID = "登记人ID";
	public static final String ALIAS_REMARK = "备注";
	
	public static final String ALIAS_TRADE = "客户所属行业";
	public static final String ALIAS_LOANTRADE = "投放行业";
	public static final String ALIAS_LOANAREA = "投放区域";
	public static final String ALIAS_INVALIDDATE = "有效终止日期";
	public static final String ALIAS_VALIDDATE = "有效起始日期";
	public static final String ALIAS_SUBMITMARK = "是否提交标志";
	
	
	//date formats
	
	public ClntBlacklist(){
	}

	public ClntBlacklist(
		java.lang.Integer id
	){
		this.id = id;
	}

	
	//columns START
	/**id==>db_column: ID*/
	private java.lang.Integer id;
	/**客户号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**黑名单等级==>db_column: BLDEGREE*/
	private java.lang.String bldegree;
	/**批准人==>db_column: APPRUSERID*/
	private java.lang.String appruserid;
	/**划入黑名单原因==>db_column: BLREASON*/
	private java.lang.String blreason;
	/**生效状态==>db_column: VALIDFLAG*/
	private java.lang.String validflag;
	/**登记日期==>db_column: SCDATE*/
	private java.lang.String scdate;
	/**更新日期==>db_column: LASTMODDATE*/
	private java.lang.String lastmoddate;
	/**登记人ID==>db_column: USERID*/
	private java.lang.String userid;
	/**备注==>db_column: REMARK*/
	private java.lang.String remark;
	
	/**客户所属行业==>db_column: TRADE*/
	private java.lang.String trade;
	/**投放行业==>db_column: LOANTRADE*/
	private java.lang.String loantrade;
	/**投放区域==>db_column: LOANAREA*/
	private java.lang.String loanarea;
	/**有效终止日期==>db_column: INVALIDDATE*/
	private java.lang.String invaliddate;
	/**有效起始日期==>db_column: VALIDDATE*/
	private java.lang.String validdate;
	/**是否提交标志==>db_column: SUBMITMARK*/
	private java.lang.String submitmark;
	
	
	//columns END
	
	// add by xjh for List展示 20150322 start 
	private String opnm; // 员工姓名
	private String dptno; // 员工所属部门编号
	private String dptname; // 员工所属部门名称
	private String clntname; //客户名称
	
	public String getOpnm() {
		return opnm;
	}
	
	public void setOpnm(String opnm) {
		this.opnm = opnm;
	}
	
	public String getDptno() {
		return dptno;
	}
	
	public void setDptno(String dptno) {
		this.dptno = dptno;
	}
	
	public String getDptname() {
		return dptname;
	}
	
	public void setDptname(String dptname) {
		this.dptname = dptname;
	}
	
	public String getClntname() {
		return clntname;
	}
	
	public void setClntname(String clntname) {
		this.clntname = clntname;
	}
	
	// add by xjh for List展示 20150322 end
	
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
	public void setBldegree(java.lang.String value) {
		this.bldegree = value;
	}
	
	public java.lang.String getBldegree() {
		return this.bldegree;
	}
	public void setAppruserid(java.lang.String value) {
		this.appruserid = value;
	}
	
	public java.lang.String getAppruserid() {
		return this.appruserid;
	}
	public void setBlreason(java.lang.String value) {
		this.blreason = value;
	}
	
	public java.lang.String getBlreason() {
		return this.blreason;
	}
	public void setValidflag(java.lang.String value) {
		this.validflag = value;
	}
	
	public java.lang.String getValidflag() {
		return this.validflag;
	}
	public void setScdate(java.lang.String value) {
		this.scdate = value;
	}
	
	public java.lang.String getScdate() {
		return this.scdate;
	}
	public void setLastmoddate(java.lang.String value) {
		this.lastmoddate = value;
	}
	
	public java.lang.String getLastmoddate() {
		return this.lastmoddate;
	}
	public void setUserid(java.lang.String value) {
		this.userid = value;
	}
	
	public java.lang.String getUserid() {
		return this.userid;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}

	public java.lang.String getTrade() {
		return trade;
	}

	public void setTrade(java.lang.String trade) {
		this.trade = trade;
	}

	public java.lang.String getLoantrade() {
		return loantrade;
	}

	public void setLoantrade(java.lang.String loantrade) {
		this.loantrade = loantrade;
	}

	public java.lang.String getLoanarea() {
		return loanarea;
	}

	public void setLoanarea(java.lang.String loanarea) {
		this.loanarea = loanarea;
	}

	public java.lang.String getInvaliddate() {
		return invaliddate;
	}

	public void setInvaliddate(java.lang.String invaliddate) {
		this.invaliddate = invaliddate;
	}

	public java.lang.String getValiddate() {
		return validdate;
	}

	public void setValiddate(java.lang.String validdate) {
		this.validdate = validdate;
	}
	
	public java.lang.String getSubmitmark() {
		return submitmark;
	}

	public void setSubmitmark(java.lang.String submitmark) {
		this.submitmark = submitmark;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Clntno",getClntno())
			.append("Bldegree",getBldegree())
			.append("Appruserid",getAppruserid())
			.append("Blreason",getBlreason())
			.append("Validflag",getValidflag())
			.append("Scdate",getScdate())
			.append("Lastmoddate",getLastmoddate())
			.append("Userid",getUserid())
			.append("Remark",getRemark())
			.append("LoanArea",getLoanarea())
			.append("LoanTrade",getLoantrade())
			.append("InvalidDate",getInvaliddate())
			.append("ValidDate",getValiddate())
			.append("Trade",getTrade())
			.append("SubmitMark",getSubmitmark())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ClntBlacklist == false) return false;
		if(this == obj) return true;
		ClntBlacklist other = (ClntBlacklist)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

