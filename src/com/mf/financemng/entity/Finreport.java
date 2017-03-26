/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2016
 */

package com.mf.financemng.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.mf.base.BaseEntity;
import com.mf.util.*;

/**
 * @author wangyw
 * @2016-01-07
 * @version 1.0
 * @param <T>
 */

public class Finreport extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Finreport";
	public static final String ALIAS_RPTID = "行记录的GUID值";
	public static final String ALIAS_ORGCODE = "组织机构代码.参照公司基本信息表.组织机构代码";
	public static final String ALIAS_RPTTYPE = "报表类别.A 资产负债类  C 损益类 F 补充信息 D现金流量表 E股东权益变动";
	public static final String ALIAS_RPTMONTH = "报表月份.报表月份YYYY-MM";
	public static final String ALIAS_CURRENCY = "币种";
	public static final String ALIAS_ISBALANCE = "报表是否平衡.报表是否平衡 0为否，1为是";
	public static final String ALIAS_RPTNOTE = "报表信息描述";
	public static final String ALIAS_DELETEFLAG = "删除状态.0未删除(默认) 、1已删除";
	public static final String ALIAS_RPTSTATUS = "上报状态.0 已上报 1 待上报";
	public static final String ALIAS_RPTBATCH = "上报批次";
	public static final String ALIAS_RPTDATE = "上报日期";
	public static final String ALIAS_PROCESSSTATUS = "processstatus";
	public static final String ALIAS_CREATEBY = "createby";
	public static final String ALIAS_CREATEDATE = "createdate";
	public static final String ALIAS_UPDATEBY = "updateby";
	public static final String ALIAS_UPDATEDATE = "updatedate";
	
	//date formats
	public static final String FORMAT_RPTDATE = DATE_FORMAT;
	public static final String FORMAT_CREATEDATE = DATE_FORMAT;
	public static final String FORMAT_UPDATEDATE = DATE_FORMAT;
	
	public Finreport(){
	}

	public Finreport(
		java.lang.String rptid
	){
		this.rptid = rptid;
	}

	
	//columns START
	/**行记录的GUID值==>db_column: RPTID*/
	private java.lang.String rptid;
	/**组织机构代码.参照公司基本信息表.组织机构代码==>db_column: ORGCODE*/
	private java.lang.String orgcode;
	/**报表类别.A 资产负债类  C 损益类 F 补充信息 D现金流量表 E股东权益变动==>db_column: RPTTYPE*/
	private java.lang.String rpttype;
	/**报表月份.报表月份YYYY-MM==>db_column: RPTMONTH*/
	private java.lang.Integer rptmonth;
	/**币种==>db_column: CURRENCY*/
	private java.lang.String currency;
	/**报表是否平衡.报表是否平衡 0为否，1为是==>db_column: ISBALANCE*/
	private java.lang.Integer isbalance;
	/**报表信息描述==>db_column: RPTNOTE*/
	private java.lang.String rptnote;
	/**删除状态.0未删除(默认) 、1已删除==>db_column: DELETEFLAG*/
	private java.lang.Integer deleteflag;
	/**上报状态.0 已上报 1 待上报==>db_column: RPTSTATUS*/
	private java.lang.Integer rptstatus;
	/**上报批次==>db_column: RPTBATCH*/
	private java.lang.String rptbatch;
	private java.util.Date rptdateBegin;
	private java.util.Date rptdateEnd;
	private java.util.Date rptdate;
	
	private java.lang.Integer auditstatus;
	
	
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
	/**createby==>db_column: CREATEBY*/
	private java.lang.String createby;
	private java.util.Date createdateBegin;
	private java.util.Date createdateEnd;
	private java.lang.String createdate;
	
	public java.util.Date getCreatedateBegin() {
		return this.createdateBegin;
	}
	
	public void setCreatedateBegin(java.util.Date value) {
		this.createdateBegin = value;
	}	
	
	public java.util.Date getCreatedateEnd() {
		return this.createdateEnd;
	}
	
	public void setCreatedateEnd(java.util.Date value) {
		this.createdateEnd = value;
	}
	
	/**updateby==>db_column: UPDATEBY*/
	private java.lang.String updateby;
	private java.util.Date updatedateBegin;
	private java.util.Date updatedateEnd;
	private java.lang.String updatedate;
	
	public java.util.Date getUpdatedateBegin() {
		return this.updatedateBegin;
	}
	
	public void setUpdatedateBegin(java.util.Date value) {
		this.updatedateBegin = value;
	}	
	
	public java.util.Date getUpdatedateEnd() {
		return this.updatedateEnd;
	}
	
	public void setUpdatedateEnd(java.util.Date value) {
		this.updatedateEnd = value;
	}
	
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

	public void setRptid(java.lang.String value) {
		this.rptid = value;
	}
	
	public java.lang.String getRptid() {
		return this.rptid;
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
	public void setRptmonth(java.lang.Integer value) {
		this.rptmonth = value;
	}
	
	public java.lang.Integer getRptmonth() {
		return this.rptmonth;
	}
	public void setCurrency(java.lang.String value) {
		this.currency = value;
	}
	
	public java.lang.String getCurrency() {
		return this.currency;
	}
	public void setIsbalance(java.lang.Integer value) {
		this.isbalance = value;
	}
	
	public java.lang.Integer getIsbalance() {
		return this.isbalance;
	}
	public void setRptnote(java.lang.String value) {
		this.rptnote = value;
	}
	
	public java.lang.String getRptnote() {
		return this.rptnote;
	}
	public void setDeleteflag(java.lang.Integer value) {
		this.deleteflag = value;
	}
	
	public java.lang.Integer getDeleteflag() {
		return this.deleteflag;
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
	public void setCreateby(java.lang.String value) {
		this.createby = value;
	}
	
	public java.lang.String getCreateby() {
		return this.createby;
	}
	public java.lang.String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(java.lang.String createdate) {
		this.createdate = createdate;
	}

	public void setUpdateby(java.lang.String value) {
		this.updateby = value;
	}
	
	public java.lang.String getUpdateby() {
		return this.updateby;
	}

	public java.lang.String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(java.lang.String updatedate) {
		this.updatedate = updatedate;
	}

	public java.lang.Integer getAuditstatus() {
		return auditstatus;
	}

	public void setAuditstatus(java.lang.Integer auditstatus) {
		this.auditstatus = auditstatus;
	}

	

	
}

