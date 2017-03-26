/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.mf.base.BaseEntity;

/**
 * @author wangyw
 * @2015-04-15
 * @version 1.0
 * @param <T>
 */

public class FnncDealtyp extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "交易类型";
	public static final String ALIAS_RCRDID = "记录号";
	public static final String ALIAS_DEALTYPE = "交易类型编号";
	public static final String ALIAS_DEALNAME = "交易名称";
	public static final String ALIAS_REMARK = "备注";
	
	//date formats
	
	public FnncDealtyp(){
	}

	public FnncDealtyp(
		java.lang.Integer rcrdid
	){
		this.rcrdid = rcrdid;
	}

	
	//columns START
	/**记录号==>db_column: RCRDID*/
	private java.lang.Integer rcrdid;
	/**交易类型编号==>db_column: DEALTYPE*/
	private java.lang.String dealtype;
	/**交易名称==>db_column: DEALNAME*/
	private java.lang.String dealname;
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

	public void setRcrdid(java.lang.Integer value) {
		this.rcrdid = value;
	}
	
	public java.lang.Integer getRcrdid() {
		return this.rcrdid;
	}
	public void setDealtype(java.lang.String value) {
		this.dealtype = value;
	}
	
	public java.lang.String getDealtype() {
		return this.dealtype;
	}
	public void setDealname(java.lang.String value) {
		this.dealname = value;
	}
	
	public java.lang.String getDealname() {
		return this.dealname;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Rcrdid",getRcrdid())
			.append("Dealtype",getDealtype())
			.append("Dealname",getDealname())
			.append("Remark",getRemark())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getRcrdid())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof FnncDealtyp == false) return false;
		if(this == obj) return true;
		FnncDealtyp other = (FnncDealtyp)obj;
		return new EqualsBuilder()
			.append(getRcrdid(),other.getRcrdid())
			.isEquals();
	}
}

