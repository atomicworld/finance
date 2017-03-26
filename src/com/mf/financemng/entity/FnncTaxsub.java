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


/**
 * @author wangyw
 * @2015-08-20
 * @version 1.0
 * @param <T>
 */

public class FnncTaxsub extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
		public static final String TABLE_ALIAS = "Paytax";
		public static final String ALIAS_PAYTAXID = "paytaxid";
		public static final String ALIAS_ORGCODE = "orgcode";
		public static final String ALIAS_BEGINMONTH = "beginmonth";
		public static final String ALIAS_ENDMONTH = "endmonth";
		public static final String ALIAS_TAXTYPE = "taxtype";
		public static final String ALIAS_SUBTAXTYPE = "subtaxtype";
		public static final String ALIAS_BLEAVEAMOUNT = "bleaveamount";
		public static final String ALIAS_EAMOUNT = "eamount";
		public static final String ALIAS_EALERADYAMOUNT = "ealeradyamount";
		public static final String ALIAS_ELEAVEAMOUNT = "eleaveamount";
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
		public static final String FORMAT_RPTDATE = DATE_FORMAT;
		public static final String FORMAT_CREATEDATE = DATE_FORMAT;
		public static final String FORMAT_UPDATEDATE = DATE_FORMAT;
		

		
		//columns START
		/**paytaxid==>db_column: PAYTAXID*/
		private java.lang.String paytaxid;
		/**orgcode==>db_column: ORGCODE*/
		private java.lang.String orgcode;
		/**beginmonth==>db_column: BEGINMONTH*/
		private java.lang.Integer beginmonth;
		/**endmonth==>db_column: ENDMONTH*/
		private java.lang.Integer endmonth;
		/**taxtype==>db_column: TAXTYPE*/
		private java.lang.Integer taxtype;
		/**subtaxtype==>db_column: SUBTAXTYPE*/
		private java.lang.Integer subtaxtype;
		/**bleaveamount==>db_column: BLEAVEAMOUNT*/
		private String bleaveamount;
		/**eamount==>db_column: EAMOUNT*/
		private String eamount;
		/**ealeradyamount==>db_column: EALERADYAMOUNT*/
		private String ealeradyamount;
		/**eleaveamount==>db_column: ELEAVEAMOUNT*/
		private String eleaveamount;
		/**remark==>db_column: REMARK*/
		private java.lang.String remark;
		/**deleteflag==>db_column: DELETEFLAG*/
		private java.lang.Integer deleteflag;
		/**rptstatus==>db_column: RPTSTATUS*/
		private java.lang.Integer rptstatus;
		/**rptbatch==>db_column: RPTBATCH*/
		private java.lang.String rptbatch;
		private String rptdateBegin;
		private String rptdateEnd;
		private String rptdate;
		
		public String getRptdateBegin() {
			return this.rptdateBegin;
		}
		
		public void setRptdateBegin(String value) {
			this.rptdateBegin = value;
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
		private String createdate;
		
		
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

		public void setPaytaxid(java.lang.String value) {
			this.paytaxid = value;
		}
		
		public java.lang.String getPaytaxid() {
			return this.paytaxid;
		}
		public void setOrgcode(java.lang.String value) {
			this.orgcode = value;
		}
		
		public java.lang.String getOrgcode() {
			return this.orgcode;
		}
		public void setBeginmonth(java.lang.Integer value) {
			this.beginmonth = value;
		}
		
		public java.lang.Integer getBeginmonth() {
			return this.beginmonth;
		}
		public void setEndmonth(java.lang.Integer value) {
			this.endmonth = value;
		}
		
		public java.lang.Integer getEndmonth() {
			return this.endmonth;
		}
		public void setTaxtype(java.lang.Integer value) {
			this.taxtype = value;
		}
		
		public java.lang.Integer getTaxtype() {
			return this.taxtype;
		}
		public void setSubtaxtype(java.lang.Integer value) {
			this.subtaxtype = value;
		}
		
		public java.lang.Integer getSubtaxtype() {
			return this.subtaxtype;
		}
		
		public String getBleaveamount() {
			return bleaveamount;
		}

		public void setBleaveamount(String bleaveamount) {
			this.bleaveamount = bleaveamount;
		}

		public String getEamount() {
			return eamount;
		}

		public void setEamount(String eamount) {
			this.eamount = eamount;
		}

		public String getEaleradyamount() {
			return ealeradyamount;
		}

		public void setEaleradyamount(String ealeradyamount) {
			this.ealeradyamount = ealeradyamount;
		}

		public String getEleaveamount() {
			return eleaveamount;
		}

		public void setEleaveamount(String eleaveamount) {
			this.eleaveamount = eleaveamount;
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
				.append("Paytaxid",getPaytaxid())
				.append("Orgcode",getOrgcode())
				.append("Beginmonth",getBeginmonth())
				.append("Endmonth",getEndmonth())
				.append("Taxtype",getTaxtype())
				.append("Subtaxtype",getSubtaxtype())
				.append("Bleaveamount",getBleaveamount())
				.append("Eamount",getEamount())
				.append("Ealeradyamount",getEaleradyamount())
				.append("Eleaveamount",getEleaveamount())
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
				.append(getPaytaxid())
				.toHashCode();
		}
		
	}

