/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2016
 */

package com.mf.financemng.entity;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.mf.base.BaseEntity;
import com.mf.util.*;

/**
 * @author wangyw
 * @2016-01-06
 * @version 1.0
 * @param <T>
 */

public class Profit extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Profit";
	public static final String ALIAS_PROFITID = "profitid";
	public static final String ALIAS_RPTID = "财务报表概要信息记录ID.参照财务报表概要信息表.记录ID";
	public static final String ALIAS_RPTMONTH = "报表月份.科目值对应的月份";
	public static final String ALIAS_ITEMCODE = "科目编号.科目编号,参照财务科目信息表中的科目编号";
	public static final String ALIAS_ORGCODE = "组织机构代码.组织机构代码(冗余)";
	public static final String ALIAS_RPTTYPE = "报表类别.报表类别(冗余)";
	public static final String ALIAS_ITEMVALUE = "科目值";
	public static final String ALIAS_RPTSTATUS = "上报状态.上报状态 0 已上报 1 待上报";
	public static final String ALIAS_RPTBATCH = "上报批次";
	public static final String ALIAS_RPTDATE = "上报日期";
	public static final String ALIAS_PROCESSSTATUS = "processstatus";
	public static final String ALIAS_DELETEFLAG = "deleteflag";
	public static final String ALIAS_VALIDATE = "validate";
	
	//date formats
	public static final String FORMAT_RPTDATE = DATE_FORMAT;
	
	public Profit(){
	}

	public Profit(
		java.lang.String profitid
	){
		this.profitid = profitid;
	}

	
	//columns START
	/**profitid==>db_column: PROFITID*/
	private java.lang.String profitid;
	/**财务报表概要信息记录ID.参照财务报表概要信息表.记录ID==>db_column: RPTID*/
	private java.lang.String rptid;
	/**报表月份.科目值对应的月份==>db_column: RPTMONTH*/
	private java.lang.Integer rptmonth;
	/**科目编号.科目编号,参照财务科目信息表中的科目编号==>db_column: ITEMCODE*/
	private java.lang.Integer itemcode;
	/**组织机构代码.组织机构代码(冗余)==>db_column: ORGCODE*/
	private java.lang.String orgcode;
	/**报表类别.报表类别(冗余)==>db_column: RPTTYPE*/
	private java.lang.String rpttype;
	/**科目值==>db_column: ITEMVALUE*/
	private BigDecimal itemvalue;
	/**上报状态.上报状态 0 已上报 1 待上报==>db_column: RPTSTATUS*/
	private java.lang.Integer rptstatus;
	/**上报批次==>db_column: RPTBATCH*/
	private java.lang.String rptbatch;
	private java.util.Date rptdateBegin;
	private java.util.Date rptdateEnd;
	private java.util.Date rptdate;
	
	private Integer rptmonthstart;
	
	public java.util.Date getRptdateBegin() {
		return this.rptdateBegin;
	}
	
	public void setRptdateBegin(java.util.Date value) {
		this.rptdateBegin = value;
	}	
	
	public java.util.Date getRptdateEnd() {
		return this.rptdateEnd;
	}
	
	public void setRptdateEnd(java.util.Date value) {
		this.rptdateEnd = value;
	}
	
	/**processstatus==>db_column: PROCESSSTATUS*/
	private java.lang.Integer processstatus;
	/**deleteflag==>db_column: DELETEFLAG*/
	private java.lang.Integer deleteflag;
	/**validate==>db_column: VALIDATE*/
	private Long validate;
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

	public void setProfitid(java.lang.String value) {
		this.profitid = value;
	}
	
	public java.lang.String getProfitid() {
		return this.profitid;
	}
	public void setRptid(java.lang.String value) {
		this.rptid = value;
	}
	
	public java.lang.String getRptid() {
		return this.rptid;
	}
	public void setRptmonth(java.lang.Integer value) {
		this.rptmonth = value;
	}
	
	public java.lang.Integer getRptmonth() {
		return this.rptmonth;
	}
	public void setItemcode(java.lang.Integer value) {
		this.itemcode = value;
	}
	
	public java.lang.Integer getItemcode() {
		return this.itemcode;
	}
	public void setOrgcode(java.lang.String value) {
		this.orgcode = value;
	}
	
	public java.lang.String getOrgcode() {
		return this.orgcode;
	}
	public void setRpttype(java.lang.String value) {
		this.rpttype = value;
	}
	
	public java.lang.String getRpttype() {
		return this.rpttype;
	}

	public BigDecimal getItemvalue() {
		return itemvalue;
	}

	public void setItemvalue(BigDecimal itemvalue) {
		this.itemvalue = itemvalue;
	}

	public void setRptstatus(java.lang.Integer value) {
		this.rptstatus = value;
	}
	
	public java.lang.Integer getRptstatus() {
		return this.rptstatus;
	}
	public void setRptbatch(java.lang.String value) {
		this.rptbatch = value;
	}
	
	public java.lang.String getRptbatch() {
		return this.rptbatch;
	}
	public void setRptdate(java.util.Date value) {
		this.rptdate = value;
	}
	
	public java.util.Date getRptdate() {
		return this.rptdate;
	}
	public void setProcessstatus(java.lang.Integer value) {
		this.processstatus = value;
	}
	
	public java.lang.Integer getProcessstatus() {
		return this.processstatus;
	}
	public void setDeleteflag(java.lang.Integer value) {
		this.deleteflag = value;
	}
	
	public java.lang.Integer getDeleteflag() {
		return this.deleteflag;
	}
	public void setValidate(Long value) {
		this.validate = value;
	}
	
	public Long getValidate() {
		return this.validate;
	}

	public Integer getRptmonthstart() {
		return rptmonthstart;
	}

	public void setRptmonthstart(Integer rptmonthstart) {
		this.rptmonthstart = rptmonthstart;
	}
}

