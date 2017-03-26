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

public class ClntEeCapFampart implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "法人代表家族企业成员";
	public static final String ALIAS_ID = "ID";
	public static final String ALIAS_CLNTNO = "客户号";
	public static final String ALIAS_LEAGNM = "家族成员姓名";
	public static final String ALIAS_CERTTYPE = "证件类型";
	public static final String ALIAS_CERTNO = "证件号码";
	public static final String ALIAS_FAMRELA = "家族关系";
	public static final String ALIAS_COMPNM = "家族成员所在企业名称";
	public static final String ALIAS_ENTLNNO = "所在企业贷款卡编码";
	
	//date formats
	
	public ClntEeCapFampart(){
	}

	public ClntEeCapFampart(
		java.lang.Integer id
	){
		this.id = id;
	}

	
	//columns START
	/**ID==>db_column: ID*/
	private java.lang.Integer id;
	/**客户号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**家族成员姓名==>db_column: LEAGNM*/
	private java.lang.String leagnm;
	/**证件类型==>db_column: CERTTYPE*/
	private java.lang.String certtype;
	/**证件号码==>db_column: CERTNO*/
	private java.lang.String certno;
	/**家族关系==>db_column: FAMRELA*/
	private java.lang.String famrela;
	/**家族成员所在企业名称==>db_column: COMPNM*/
	private java.lang.String compnm;
	/**所在企业贷款卡编码==>db_column: ENTLNNO*/
	private java.lang.String entlnno;
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
	public void setLeagnm(java.lang.String value) {
		this.leagnm = value;
	}
	
	public java.lang.String getLeagnm() {
		return this.leagnm;
	}
	public void setCerttype(java.lang.String value) {
		this.certtype = value;
	}
	
	public java.lang.String getCerttype() {
		return this.certtype;
	}
	public void setCertno(java.lang.String value) {
		this.certno = value;
	}
	
	public java.lang.String getCertno() {
		return this.certno;
	}
	public void setFamrela(java.lang.String value) {
		this.famrela = value;
	}
	
	public java.lang.String getFamrela() {
		return this.famrela;
	}
	public void setCompnm(java.lang.String value) {
		this.compnm = value;
	}
	
	public java.lang.String getCompnm() {
		return this.compnm;
	}
	public void setEntlnno(java.lang.String value) {
		this.entlnno = value;
	}
	
	public java.lang.String getEntlnno() {
		return this.entlnno;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Clntno",getClntno())
			.append("Leagnm",getLeagnm())
			.append("Certtype",getCerttype())
			.append("Certno",getCertno())
			.append("Famrela",getFamrela())
			.append("Compnm",getCompnm())
			.append("Entlnno",getEntlnno())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ClntEeCapFampart == false) return false;
		if(this == obj) return true;
		ClntEeCapFampart other = (ClntEeCapFampart)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

