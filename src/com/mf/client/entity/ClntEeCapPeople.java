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

public class ClntEeCapPeople implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "高级管理情况";
	public static final String ALIAS_ID = "ID";
	public static final String ALIAS_CLNTNO = "客户号";
	public static final String ALIAS_HMNM = "高管人员姓名";
	public static final String ALIAS_CERTTP = "证件类型";
	public static final String ALIAS_CERTNO = "证件号码";
	public static final String ALIAS_HMCLASS = "高管人员类别";
	public static final String ALIAS_GENDER = "性别";
	public static final String ALIAS_BIRTHDT = "高管人员出生日期";
	public static final String ALIAS_HMLEVEL = "高管人员最高学历";
	public static final String ALIAS_RESUME = "高管人员工作简历";
	
	//date formats
	
	public ClntEeCapPeople(){
	}

	public ClntEeCapPeople(
		java.lang.Integer id
	){
		this.id = id;
	}

	
	//columns START
	/**ID==>db_column: ID*/
	private java.lang.Integer id;
	/**客户号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**高管人员姓名==>db_column: HMNM*/
	private java.lang.String hmnm;
	/**证件类型==>db_column: CERTTP*/
	private java.lang.String certtp;
	/**证件号码==>db_column: CERTNO*/
	private java.lang.String certno;
	/**高管人员类别==>db_column: HMCLASS*/
	private java.lang.String hmclass;
	/**性别==>db_column: GENDER*/
	private java.lang.String gender;
	/**高管人员出生日期==>db_column: BIRTHDT*/
	private java.lang.String birthdt;
	/**高管人员最高学历==>db_column: HMLEVEL*/
	private java.lang.String hmlevel;
	/**高管人员工作简历==>db_column: RESUME*/
	private java.lang.String resume;
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
	public void setHmnm(java.lang.String value) {
		this.hmnm = value;
	}
	
	public java.lang.String getHmnm() {
		return this.hmnm;
	}
	public void setCerttp(java.lang.String value) {
		this.certtp = value;
	}
	
	public java.lang.String getCerttp() {
		return this.certtp;
	}
	public void setCertno(java.lang.String value) {
		this.certno = value;
	}
	
	public java.lang.String getCertno() {
		return this.certno;
	}
	public void setHmclass(java.lang.String value) {
		this.hmclass = value;
	}
	
	public java.lang.String getHmclass() {
		return this.hmclass;
	}
	public void setGender(java.lang.String value) {
		this.gender = value;
	}
	
	public java.lang.String getGender() {
		return this.gender;
	}
	public void setBirthdt(java.lang.String value) {
		this.birthdt = value;
	}
	
	public java.lang.String getBirthdt() {
		return this.birthdt;
	}
	public void setHmlevel(java.lang.String value) {
		this.hmlevel = value;
	}
	
	public java.lang.String getHmlevel() {
		return this.hmlevel;
	}
	public void setResume(java.lang.String value) {
		this.resume = value;
	}
	
	public java.lang.String getResume() {
		return this.resume;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Clntno",getClntno())
			.append("Hmnm",getHmnm())
			.append("Certtp",getCerttp())
			.append("Certno",getCertno())
			.append("Hmclass",getHmclass())
			.append("Gender",getGender())
			.append("Birthdt",getBirthdt())
			.append("Hmlevel",getHmlevel())
			.append("Resume",getResume())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ClntEeCapPeople == false) return false;
		if(this == obj) return true;
		ClntEeCapPeople other = (ClntEeCapPeople)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

