/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author xujiuhua
 * @2014-12-26
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class ClntEeCapGroup implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "集团公司";
	public static final String ALIAS_ID = "ID";
	public static final String ALIAS_CLNTNO = "客户号";
	public static final String ALIAS_SUPCOMPNM = "上级公司名称";
	public static final String ALIAS_UPLNCARDNO = "上级贷款卡编码";
	public static final String ALIAS_ORGNO = "组织机构代码";
	
	//date formats
	
	public ClntEeCapGroup(){
	}

	public ClntEeCapGroup(
		java.lang.Integer id
	){
		this.id = id;
	}

	
	//columns START
	/**ID==>db_column: ID*/
	private java.lang.Integer id;
	/**客户号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**上级公司名称==>db_column: SUPCOMPNM*/
	private java.lang.String supcompnm;
	/**上级贷款卡编码==>db_column: UPLNCARDNO*/
	private java.lang.String uplncardno;
	/**组织机构代码==>db_column: ORGNO*/
	private java.lang.String orgno;
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
	public void setSupcompnm(java.lang.String value) {
		this.supcompnm = value;
	}
	
	public java.lang.String getSupcompnm() {
		return this.supcompnm;
	}
	public void setUplncardno(java.lang.String value) {
		this.uplncardno = value;
	}
	
	public java.lang.String getUplncardno() {
		return this.uplncardno;
	}
	public void setOrgno(java.lang.String value) {
		this.orgno = value;
	}
	
	public java.lang.String getOrgno() {
		return this.orgno;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Clntno",getClntno())
			.append("Supcompnm",getSupcompnm())
			.append("Uplncardno",getUplncardno())
			.append("Orgno",getOrgno())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ClntEeCapGroup == false) return false;
		if(this == obj) return true;
		ClntEeCapGroup other = (ClntEeCapGroup)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

