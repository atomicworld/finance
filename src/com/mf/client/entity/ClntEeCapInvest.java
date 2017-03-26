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
 * @2014-12-26
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class ClntEeCapInvest implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "出资资本";
	public static final String ALIAS_ID = "ID";
	public static final String ALIAS_CLNTNO = "客户号";
	public static final String ALIAS_INVESTER = "出资方";
	public static final String ALIAS_INVLNNO = "出资方贷款卡编码";
	public static final String ALIAS_ORGNO = "组织机构代码";
	public static final String ALIAS_RERECODE = "登记注册号";
	public static final String ALIAS_CERTTYPE = "证件类型";
	public static final String ALIAS_CERTNO = "证件号码";
	public static final String ALIAS_CURTP = "币种";
	public static final String ALIAS_INVAMT = "出资金额";
	
	//date formats
	
	public ClntEeCapInvest(){
	}

	public ClntEeCapInvest(
		java.lang.Integer id
	){
		this.id = id;
	}

	
	//columns START
	/**ID==>db_column: ID*/
	private java.lang.Integer id;
	/**客户号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**出资方==>db_column: INVESTER*/
	private java.lang.String invester;
	/**出资方贷款卡编码==>db_column: INVLNNO*/
	private java.lang.String invlnno;
	/**组织机构代码==>db_column: ORGNO*/
	private java.lang.String orgno;
	/**登记注册号==>db_column: RERECODE*/
	private java.lang.String rerecode;
	/**证件类型==>db_column: CERTTYPE*/
	private java.lang.String certtype;
	/**证件号码==>db_column: CERTNO*/
	private java.lang.String certno;
	/**币种==>db_column: CURTP*/
	private java.lang.String curtp;
	/**出资金额==>db_column: INVAMT*/
	private BigDecimal invamt;
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
	public void setInvester(java.lang.String value) {
		this.invester = value;
	}
	
	public java.lang.String getInvester() {
		return this.invester;
	}
	public void setInvlnno(java.lang.String value) {
		this.invlnno = value;
	}
	
	public java.lang.String getInvlnno() {
		return this.invlnno;
	}
	public void setOrgno(java.lang.String value) {
		this.orgno = value;
	}
	
	public java.lang.String getOrgno() {
		return this.orgno;
	}
	public void setRerecode(java.lang.String value) {
		this.rerecode = value;
	}
	
	public java.lang.String getRerecode() {
		return this.rerecode;
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
	public void setCurtp(java.lang.String value) {
		this.curtp = value;
	}
	
	public java.lang.String getCurtp() {
		return this.curtp;
	}
	

	public BigDecimal getInvamt() {
		return invamt;
	}

	public void setInvamt(BigDecimal invamt) {
		this.invamt = invamt;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Clntno",getClntno())
			.append("Invester",getInvester())
			.append("Invlnno",getInvlnno())
			.append("Orgno",getOrgno())
			.append("Rerecode",getRerecode())
			.append("Certtype",getCerttype())
			.append("Certno",getCertno())
			.append("Curtp",getCurtp())
			.append("Invamt",getInvamt())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ClntEeCapInvest == false) return false;
		if(this == obj) return true;
		ClntEeCapInvest other = (ClntEeCapInvest)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

