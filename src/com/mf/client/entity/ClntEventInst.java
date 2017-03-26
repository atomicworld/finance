/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.client.entity;

import java.math.BigDecimal;

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

public class ClntEventInst implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "重大事件-欠息情况";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_CLNTNO = "客户号";
	public static final String ALIAS_CNTRCTNO = "合同号";
	public static final String ALIAS_CNTRCTAMNT = "贷款本金";
	public static final String ALIAS_DEINST = "欠息利息";
	public static final String ALIAS_PAYINST = "应付利息";
	public static final String ALIAS_MONRT = "月利率";
	public static final String ALIAS_BEGDATE = "起息日";
	public static final String ALIAS_ENDDATE = "结息日";
	public static final String ALIAS_SCDATE = "登记日期";
	public static final String ALIAS_LASTMODDATE = "更新日期";
	public static final String ALIAS_USERID = "登记人ID";
	public static final String ALIAS_REMARK = "备注";
	
	//date formats
	
	public ClntEventInst(){
	}

	public ClntEventInst(
		java.lang.Integer id
	){
		this.id = id;
	}

	
	//columns START
	/**id==>db_column: ID*/
	private java.lang.Integer id;
	/**客户号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**合同号==>db_column: CNTRCTNO*/
	private java.lang.String cntrctno;
	/**贷款本金==>db_column: CNTRCTAMNT*/
	private BigDecimal cntrctamnt;
	/**欠息利息==>db_column: DEINST*/
	private BigDecimal deinst;
	/**应付利息==>db_column: PAYINST*/
	private BigDecimal payinst;
	/**月利率==>db_column: MONRT*/
	private BigDecimal monrt;
	/**起息日==>db_column: BEGDATE*/
	private java.lang.String begdate;
	/**结息日==>db_column: ENDDATE*/
	private java.lang.String enddate;
	/**登记日期==>db_column: SCDATE*/
	private java.lang.String scdate;
	/**更新日期==>db_column: LASTMODDATE*/
	private java.lang.String lastmoddate;
	/**登记人ID==>db_column: USERID*/
	private java.lang.String userid;
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
	public void setCntrctno(java.lang.String value) {
		this.cntrctno = value;
	}
	
	public java.lang.String getCntrctno() {
		return this.cntrctno;
	}
	
	public BigDecimal getCntrctamnt() {
		return cntrctamnt;
	}

	public void setCntrctamnt(BigDecimal cntrctamnt) {
		this.cntrctamnt = cntrctamnt;
	}

	public BigDecimal getDeinst() {
		return deinst;
	}

	public void setDeinst(BigDecimal deinst) {
		this.deinst = deinst;
	}

	public BigDecimal getPayinst() {
		return payinst;
	}

	public void setPayinst(BigDecimal payinst) {
		this.payinst = payinst;
	}

	public BigDecimal getMonrt() {
		return monrt;
	}

	public void setMonrt(BigDecimal monrt) {
		this.monrt = monrt;
	}

	public void setBegdate(java.lang.String value) {
		this.begdate = value;
	}
	
	public java.lang.String getBegdate() {
		return this.begdate;
	}
	public void setEnddate(java.lang.String value) {
		this.enddate = value;
	}
	
	public java.lang.String getEnddate() {
		return this.enddate;
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

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Clntno",getClntno())
			.append("Cntrctno",getCntrctno())
			.append("Cntrctamnt",getCntrctamnt())
			.append("Deinst",getDeinst())
			.append("Payinst",getPayinst())
			.append("Monrt",getMonrt())
			.append("Begdate",getBegdate())
			.append("Enddate",getEnddate())
			.append("Scdate",getScdate())
			.append("Lastmoddate",getLastmoddate())
			.append("Userid",getUserid())
			.append("Remark",getRemark())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ClntEventInst == false) return false;
		if(this == obj) return true;
		ClntEventInst other = (ClntEventInst)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

