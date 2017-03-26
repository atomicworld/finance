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
 * @2015-01-04
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class ClntRel implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "客户关联关系";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_CLNTNO = "客户号";
	public static final String ALIAS_RELCLNTNO = "关联客户号";
	public static final String ALIAS_RELATION = "关联关系";
	public static final String ALIAS_SCDATE = "登记日期";
	public static final String ALIAS_REMARK = "备注";
	
	//date formats
	
	public ClntRel(){
	}

	public ClntRel(
		java.lang.Integer id
	){
		this.id = id;
	}

	
	//columns START
	/**id==>db_column: ID*/
	private java.lang.Integer id;
	/**客户号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**关联客户号==>db_column: RELCLNTNO*/
	private java.lang.String relclntno;
	/**关联关系==>db_column: RELATION*/
	private java.lang.String relation;
	/**登记日期==>db_column: SCDATE*/
	private java.lang.String scdate;
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
	public void setRelclntno(java.lang.String value) {
		this.relclntno = value;
	}
	
	public java.lang.String getRelclntno() {
		return this.relclntno;
	}
	public void setRelation(java.lang.String value) {
		this.relation = value;
	}
	
	public java.lang.String getRelation() {
		return this.relation;
	}
	public void setScdate(java.lang.String value) {
		this.scdate = value;
	}
	
	public java.lang.String getScdate() {
		return this.scdate;
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
			.append("Relclntno",getRelclntno())
			.append("Relation",getRelation())
			.append("Scdate",getScdate())
			.append("Remark",getRemark())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ClntRel == false) return false;
		if(this == obj) return true;
		ClntRel other = (ClntRel)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

