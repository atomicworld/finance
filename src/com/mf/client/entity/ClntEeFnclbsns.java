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

public class ClntEeFnclbsns implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "金融业务信息";
	public static final String ALIAS_ID = "ID";
	public static final String ALIAS_CLNTNO = "客户号";
	public static final String ALIAS_BASEBANK = "基本账户开户行";
	public static final String ALIAS_BASEBANKNO = "基本账户开户行账号";
	public static final String ALIAS_BASEBANKAPP = "基本开户审批机关";
	public static final String ALIAS_COMBANK = "一般账户开户行";
	public static final String ALIAS_COMBANKNO = "一般账户开户行账号";
	public static final String ALIAS_ACCOPENPERNO = "开户许可证核准号";
	public static final String ALIAS_FOREXPERNO = "外汇许可证号码";
	public static final String ALIAS_BSNSRCONREL = "与本公司业务往来关系";
	
	//date formats
	
	public ClntEeFnclbsns(){
	}

	public ClntEeFnclbsns(
		java.lang.Integer id
	){
		this.id = id;
	}

	
	//columns START
	/**ID==>db_column: ID*/
	private java.lang.Integer id;
	/**客户号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**基本账户开户行==>db_column: BASEBANK*/
	private java.lang.String basebank;
	/**基本账户开户行账号==>db_column: BASEBANKNO*/
	private java.lang.String basebankno;
	/**基本开户审批机关==>db_column: BASEBANKAPP*/
	private java.lang.String basebankapp;
	/**一般账户开户行==>db_column: COMBANK*/
	private java.lang.String combank;
	/**一般账户开户行账号==>db_column: COMBANKNO*/
	private java.lang.String combankno;
	/**开户许可证核准号==>db_column: ACCOPENPERNO*/
	private java.lang.String accopenperno;
	/**外汇许可证号码==>db_column: FOREXPERNO*/
	private java.lang.String forexperno;
	/**与本公司业务往来关系==>db_column: BSNSRCONREL*/
	private java.lang.String bsnsrconrel;
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
	public void setBasebank(java.lang.String value) {
		this.basebank = value;
	}
	
	public java.lang.String getBasebank() {
		return this.basebank;
	}
	public void setBasebankno(java.lang.String value) {
		this.basebankno = value;
	}
	
	public java.lang.String getBasebankno() {
		return this.basebankno;
	}
	public void setBasebankapp(java.lang.String value) {
		this.basebankapp = value;
	}
	
	public java.lang.String getBasebankapp() {
		return this.basebankapp;
	}
	public void setCombank(java.lang.String value) {
		this.combank = value;
	}
	
	public java.lang.String getCombank() {
		return this.combank;
	}
	public void setCombankno(java.lang.String value) {
		this.combankno = value;
	}
	
	public java.lang.String getCombankno() {
		return this.combankno;
	}
	public void setAccopenperno(java.lang.String value) {
		this.accopenperno = value;
	}
	
	public java.lang.String getAccopenperno() {
		return this.accopenperno;
	}
	public void setForexperno(java.lang.String value) {
		this.forexperno = value;
	}
	
	public java.lang.String getForexperno() {
		return this.forexperno;
	}
	public void setBsnsrconrel(java.lang.String value) {
		this.bsnsrconrel = value;
	}
	
	public java.lang.String getBsnsrconrel() {
		return this.bsnsrconrel;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Clntno",getClntno())
			.append("Basebank",getBasebank())
			.append("Basebankno",getBasebankno())
			.append("Basebankapp",getBasebankapp())
			.append("Combank",getCombank())
			.append("Combankno",getCombankno())
			.append("Accopenperno",getAccopenperno())
			.append("Forexperno",getForexperno())
			.append("Bsnsrconrel",getBsnsrconrel())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ClntEeFnclbsns == false) return false;
		if(this == obj) return true;
		ClntEeFnclbsns other = (ClntEeFnclbsns)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

