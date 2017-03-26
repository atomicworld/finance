/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.flowmng.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


/**
 * @author shenguangdong
 * @2015-01-16
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class FlowApprler {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "FlowApprler";
	public static final String ALIAS_RCRDID = "记录id";
	public static final String ALIAS_OPNO = "操作员员工编号";
	public static final String ALIAS_APPRLTYP = "审批类型";
	public static final String ALIAS_APPSTEPS = "审批岗位";
	public static final String ALIAS_DPTNO = "部门编号";
	
	//date formats
	
	public FlowApprler(){
	}

	public FlowApprler(
		java.lang.Integer rcrdid
	){
		this.rcrdid = rcrdid;
	}

	
	//columns START
	/**记录id==>db_column: RCRDID*/
	private java.lang.Integer rcrdid;
	/**操作员员工编号==>db_column: OPNO*/
	private java.lang.String opno;
	/**审批类型==>db_column: APPRLTYP*/
	private java.lang.String apprltyp;
	/**审批岗位==>db_column: APPSTEPS*/
	private java.lang.String appsteps;
	/**部门编号==>db_column: DPTNO*/
	private java.lang.String dptno;
	
	/**操作员姓名==>db_column: EMPLYNM*/
	private java.lang.String emplynm;
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

	public void setRcrdid(java.lang.Integer value) {
		this.rcrdid = value;
	}
	
	public java.lang.Integer getRcrdid() {
		return this.rcrdid;
	}
	public void setOpno(java.lang.String value) {
		this.opno = value;
	}
	
	public java.lang.String getOpno() {
		return this.opno;
	}
	public void setApprltyp(java.lang.String value) {
		this.apprltyp = value;
	}
	
	public java.lang.String getApprltyp() {
		return this.apprltyp;
	}
	public void setAppsteps(java.lang.String value) {
		this.appsteps = value;
	}
	
	public java.lang.String getAppsteps() {
		return this.appsteps;
	}
	public void setDptno(java.lang.String value) {
		this.dptno = value;
	}
	
	public java.lang.String getDptno() {
		return this.dptno;
	}
	public java.lang.String getEmplynm() {
		return emplynm;
	}

	public void setEmplynm(java.lang.String emplynm) {
		this.emplynm = emplynm;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Rcrdid",getRcrdid())
			.append("Opno",getOpno())
			.append("Apprltyp",getApprltyp())
			.append("Appsteps",getAppsteps())
			.append("Dptno",getDptno())
			.append("Emplynm",getEmplynm())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getRcrdid())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof FlowApprler == false) return false;
		if(this == obj) return true;
		FlowApprler other = (FlowApprler)obj;
		return new EqualsBuilder()
			.append(getRcrdid(),other.getRcrdid())
			.isEquals();
	}
}

