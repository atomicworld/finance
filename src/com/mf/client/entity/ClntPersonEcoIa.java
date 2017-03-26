/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.entity;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author xujiuhua
 * @2014-12-29
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class ClntPersonEcoIa implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "无形资产";
	public static final String ALIAS_ID = "ID";
	public static final String ALIAS_CLNTNO = "客户号";
	public static final String ALIAS_IANAME = "资产名称";
	public static final String ALIAS_IATYPE = "资产类型";
	public static final String ALIAS_IADES = "资产简述";
	public static final String ALIAS_IACERTNO = "证书编号";
	public static final String ALIAS_EVALVALUE = "评估价值";
	public static final String ALIAS_AUTHORG = "认证机构";
	public static final String ALIAS_AUTHDATE = "认证日期";
	public static final String ALIAS_STATDATE = "统计日期";
	public static final String ALIAS_REMARK = "备注";
	
	//date formats
	
	public ClntPersonEcoIa(){
	}

	public ClntPersonEcoIa(
		java.lang.Integer id
	){
		this.id = id;
	}

	
	//columns START
	/**ID==>db_column: ID*/
	private java.lang.Integer id;
	/**客户号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**资产名称==>db_column: IANAME*/
	private java.lang.String ianame;
	/**资产类型==>db_column: IATYPE*/
	private java.lang.String iatype;
	/**资产简述==>db_column: IADES*/
	private java.lang.String iades;
	/**证书编号==>db_column: IACERTNO*/
	private java.lang.String iacertno;
	/**评估价值==>db_column: EVALVALUE*/
	private BigDecimal evalvalue;
	/**认证机构==>db_column: AUTHORG*/
	private java.lang.String authorg;
	/**认证日期==>db_column: AUTHDATE*/
	private java.lang.String authdate;
	/**统计日期==>db_column: STATDATE*/
	private java.lang.String statdate;
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
	public void setIaname(java.lang.String value) {
		this.ianame = value;
	}
	
	public java.lang.String getIaname() {
		return this.ianame;
	}
	public void setIatype(java.lang.String value) {
		this.iatype = value;
	}
	
	public java.lang.String getIatype() {
		return this.iatype;
	}
	public void setIades(java.lang.String value) {
		this.iades = value;
	}
	
	public java.lang.String getIades() {
		return this.iades;
	}
	public void setIacertno(java.lang.String value) {
		this.iacertno = value;
	}
	
	public java.lang.String getIacertno() {
		return this.iacertno;
	}
	
	public BigDecimal getEvalvalue() {
		return evalvalue;
	}

	public void setEvalvalue(BigDecimal evalvalue) {
		this.evalvalue = evalvalue;
	}

	public void setAuthorg(java.lang.String value) {
		this.authorg = value;
	}
	
	public java.lang.String getAuthorg() {
		return this.authorg;
	}
	public void setAuthdate(java.lang.String value) {
		this.authdate = value;
	}
	
	public java.lang.String getAuthdate() {
		return this.authdate;
	}
	public void setStatdate(java.lang.String value) {
		this.statdate = value;
	}
	
	public java.lang.String getStatdate() {
		return this.statdate;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Clntno",getClntno())
			.append("Ianame",getIaname())
			.append("Iatype",getIatype())
			.append("Iades",getIades())
			.append("Iacertno",getIacertno())
			.append("Evalvalue",getEvalvalue())
			.append("Authorg",getAuthorg())
			.append("Authdate",getAuthdate())
			.append("Statdate",getStatdate())
			.append("Remark",getRemark())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ClntPersonEcoIa == false) return false;
		if(this == obj) return true;
		ClntPersonEcoIa other = (ClntPersonEcoIa)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

