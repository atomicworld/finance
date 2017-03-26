/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
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
 * @author wangzhi
 * @2015-08-14
 * @version 1.0
 * @param <T>
 */

public class FinanceCondition extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
		public static final String TABLE_ALIAS = "Loanmoney";
		public static final String ALIAS_LOANMONEYID = "loanmoneyid";
		public static final String ALIAS_ORGCODE = "orgcode";
		public static final String ALIAS_BANKNO = "bankno";
		public static final String ALIAS_LOANDATE = "loandate";
		public static final String ALIAS_BANKNAME = "bankname";
		public static final String ALIAS_YEARRATE = "yearrate";
		public static final String ALIAS_CREDITAMOUNT = "creditamount";
		public static final String ALIAS_SUMAMOUNT = "sumamount";
		public static final String ALIAS_SUMRETURN = "sumreturn";
		public static final String ALIAS_LOANBALANCE = "loanbalance";
		public static final String ALIAS_ASSUREWAY = "assureway";
		public static final String ALIAS_ASSUREWAYDES = "assurewaydes";
		public static final String ALIAS_LOANPERIOD = "loanperiod";
		public static final String ALIAS_EXPIREDATE = "expiredate";
		public static final String ALIAS_FINANCECOST = "financecost";
		public static final String ALIAS_REMARK = "remark";
		public static final String ALIAS_DELETEFLAG = "deleteflag";
		public static final String ALIAS_RPTSTATUS = "rptstatus";
		public static final String ALIAS_RPTBATCH = "rptbatch";
		public static final String ALIAS_RPTDATE = "rptdate";
		public static final String ALIAS_PROCESSSTATUS = "processstatus";
		public static final String ALIAS_CREATEBY = "createby";
		public static final String ALIAS_CREATEDATE = "createdate";
		public static final String ALIAS_UPDATEBY = "updateby";
		public static final String ALIAS_UPDATEDATE = "updatedate";
		
		//date formats
		public static final String FORMAT_LOANDATE = DATE_FORMAT;
		public static final String FORMAT_EXPIREDATE = DATE_FORMAT;
		public static final String FORMAT_RPTDATE = DATE_FORMAT;
		public static final String FORMAT_CREATEDATE = DATE_FORMAT;
		public static final String FORMAT_UPDATEDATE = DATE_FORMAT;
		

		
		//columns START
		/**loanmoneyid==>db_column: LOANMONEYID*/
		private java.lang.String loanmoneyid;
		/**orgcode==>db_column: ORGCODE*/
		private java.lang.String orgcode;
		/**bankno==>db_column: BANKNO*/
		private java.lang.String bankno;
		private String loandateBegin;
		private String loandateEnd;
		private String loandate;
		
		public String getLoandateBegin() {
			return this.loandateBegin;
		}
		
		public void setLoandateBegin(String value) {
			this.loandateBegin = value;
		}	
		
		public String getLoandateEnd() {
			return this.loandateEnd;
		}
		
		public void setLoandateEnd(String value) {
			this.loandateEnd = value;
		}
		
		/**bankname==>db_column: BANKNAME*/
		private java.lang.String bankname;
		/**yearrate==>db_column: YEARRATE*/
		private String yearrate;
		/**creditamount==>db_column: CREDITAMOUNT*/
		private String creditamount;
		/**sumamount==>db_column: SUMAMOUNT*/
		private String sumamount;
		/**sumreturn==>db_column: SUMRETURN*/
		private String sumreturn;
		/**loanbalance==>db_column: LOANBALANCE*/
		private String loanbalance;
		/**assureway==>db_column: ASSUREWAY*/
		private java.lang.String assureway;
		/**assurewaydes==>db_column: ASSUREWAYDES*/
		private java.lang.String assurewaydes;
		/**loanperiod==>db_column: LOANPERIOD*/
		private java.lang.String loanperiod;
		private String expiredateBegin;
		private String expiredateEnd;
		private String expiredate;
		
		public String getExpiredateBegin() {
			return this.expiredateBegin;
		}
		
		public void setExpiredateBegin(String value) {
			this.expiredateBegin = value;
		}	
		
		public String getExpiredateEnd() {
			return this.expiredateEnd;
		}
		
		public void setExpiredateEnd(String value) {
			this.expiredateEnd = value;
		}
		
		/**financecost==>db_column: FINANCECOST*/
		private String financecost;
		/**remark==>db_column: REMARK*/
		private java.lang.String remark;
		/**deleteflag==>db_column: DELETEFLAG*/
		private java.lang.Integer deleteflag;
		/**rptstatus==>db_column: RPTSTATUS*/
		private java.lang.Integer rptstatus;
		/**rptbatch==>db_column: RPTBATCH*/
		private java.lang.String rptbatch;
		private String channeltype;//
		private String rptdateEnd;
		private String rptdate;
		
		
		public String getChanneltype() {
			return channeltype;
		}

		public void setChanneltype(String channeltype) {
			this.channeltype = channeltype;
		}

		public String getRptdateEnd() {
			return this.rptdateEnd;
		}
		
		public void setRptdateEnd(String value) {
			this.rptdateEnd = value;
		}
		
		/**processstatus==>db_column: PROCESSSTATUS*/
		private java.lang.Integer processstatus;
		/**createby==>db_column: CREATEBY*/
		private java.lang.String createby;
		private String createdateBegin;
		private String createdateEnd;
		private String createdate;
		
		public String getCreatedateBegin() {
			return this.createdateBegin;
		}
		
		public void setCreatedateBegin(String value) {
			this.createdateBegin = value;
		}	
		
		public String getCreatedateEnd() {
			return this.createdateEnd;
		}
		
		public void setCreatedateEnd(String value) {
			this.createdateEnd = value;
		}
		
		/**updateby==>db_column: UPDATEBY*/
		private java.lang.String updateby;
		private String updatedateBegin;
		private String updatedateEnd;
		private String updatedate;
		
		public String getUpdatedateBegin() {
			return this.updatedateBegin;
		}
		
		public void setUpdatedateBegin(String value) {
			this.updatedateBegin = value;
		}	
		
		public String getUpdatedateEnd() {
			return this.updatedateEnd;
		}
		
		public void setUpdatedateEnd(String value) {
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

		public void setLoanmoneyid(java.lang.String value) {
			this.loanmoneyid = value;
		}
		
		public java.lang.String getLoanmoneyid() {
			return this.loanmoneyid;
		}
		public void setOrgcode(java.lang.String value) {
			this.orgcode = value;
		}
		
		public java.lang.String getOrgcode() {
			return this.orgcode;
		}
		public void setBankno(java.lang.String value) {
			this.bankno = value;
		}
		
		public java.lang.String getBankno() {
			return this.bankno;
		}
		public void setLoandate(String value) {
			this.loandate = value;
		}
		
		public String getLoandate() {
			return this.loandate;
		}
		public void setBankname(java.lang.String value) {
			this.bankname = value;
		}
		
		public java.lang.String getBankname() {
			return this.bankname;
		}
		public void setYearrate(String value) {
			this.yearrate = value;
		}
		
		public String getYearrate() {
			return this.yearrate;
		}
		public void setCreditamount(String value) {
			this.creditamount = value;
		}
		
		public String getCreditamount() {
			return this.creditamount;
		}
		public void setSumamount(String value) {
			this.sumamount = value;
		}
		
		public String getSumamount() {
			return this.sumamount;
		}
		public void setSumreturn(String value) {
			this.sumreturn = value;
		}
		
		public String getSumreturn() {
			return this.sumreturn;
		}
		public void setLoanbalance(String value) {
			this.loanbalance = value;
		}
		
		public String getLoanbalance() {
			return this.loanbalance;
		}
		public void setAssureway(java.lang.String value) {
			this.assureway = value;
		}
		
		public java.lang.String getAssureway() {
			return this.assureway;
		}
		public void setAssurewaydes(java.lang.String value) {
			this.assurewaydes = value;
		}
		
		public java.lang.String getAssurewaydes() {
			return this.assurewaydes;
		}
		public void setLoanperiod(java.lang.String value) {
			this.loanperiod = value;
		}
		
		public java.lang.String getLoanperiod() {
			return this.loanperiod;
		}
		public void setExpiredate(String value) {
			this.expiredate = value;
		}
		
		public String getExpiredate() {
			return this.expiredate;
		}
		public void setFinancecost(String value) {
			this.financecost = value;
		}
		
		public String getFinancecost() {
			return this.financecost;
		}
		public void setRemark(java.lang.String value) {
			this.remark = value;
		}
		
		public java.lang.String getRemark() {
			return this.remark;
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
		public void setRptdate(String value) {
			this.rptdate = value;
		}
		
		public String getRptdate() {
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
		public void setCreatedate(String value) {
			this.createdate = value;
		}
		
		public String getCreatedate() {
			return this.createdate;
		}
		public void setUpdateby(java.lang.String value) {
			this.updateby = value;
		}
		
		public java.lang.String getUpdateby() {
			return this.updateby;
		}
		public void setUpdatedate(String value) {
			this.updatedate = value;
		}
		
		public String getUpdatedate() {
			return this.updatedate;
		}

		public String toString() {
			return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("Loanmoneyid",getLoanmoneyid())
				.append("Orgcode",getOrgcode())
				.append("Bankno",getBankno())
				.append("Loandate",getLoandate())
				.append("Bankname",getBankname())
				.append("Yearrate",getYearrate())
				.append("Creditamount",getCreditamount())
				.append("Sumamount",getSumamount())
				.append("Sumreturn",getSumreturn())
				.append("Loanbalance",getLoanbalance())
				.append("Assureway",getAssureway())
				.append("Assurewaydes",getAssurewaydes())
				.append("Loanperiod",getLoanperiod())
				.append("Expiredate",getExpiredate())
				.append("Financecost",getFinancecost())
				.append("Remark",getRemark())
				.append("Deleteflag",getDeleteflag())
				.append("Rptstatus",getRptstatus())
				.append("Rptbatch",getRptbatch())
				.append("Rptdate",getRptdate())
				.append("Processstatus",getProcessstatus())
				.append("Createby",getCreateby())
				.append("Createdate",getCreatedate())
				.append("Updateby",getUpdateby())
				.append("Updatedate",getUpdatedate())
				.toString();
		}
		
		public int hashCode() {
			return new HashCodeBuilder()
				.append(getLoanmoneyid())
				.toHashCode();
		}
		
	}

