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
 * @2015-08-21
 * @version 1.0
 * @param <T>
 */

public class FinanceCashFlow extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
		public static final String TABLE_ALIAS = "Finreportcash";
		public static final String ALIAS_CASHID = "cashid";
		public static final String ALIAS_RPTID = "rptid";
		public static final String ALIAS_RPTMONTH = "rptmonth";
		public static final String ALIAS_ITEMCODE = "itemcode";
		public static final String ALIAS_RPTTYPE = "rpttype";
		public static final String ALIAS_ITEMVALUE = "itemvalue";
		public static final String ALIAS_RPTSTATUS = "rptstatus";
		public static final String ALIAS_RPTBATCH = "rptbatch";
		public static final String ALIAS_RPTDATE = "rptdate";
		public static final String ALIAS_PROCESSSTATUS = "processstatus";
		public static final String ALIAS_DELETEFLAG = "deleteflag";
		public static final String ALIAS_VALIDATE = "validate";
		public static final String ALIAS_ORGCODE = "orgcode";
		
		//date formats
		public static final String FORMAT_RPTDATE = DATE_FORMAT;
		
		//columns START
		/**cashid==>db_column: CASHID*/
		private java.lang.String cashid;
		/**rptid==>db_column: RPTID*/
		private java.lang.String rptid;
		/**rptmonth==>db_column: RPTMONTH*/
		private java.lang.Integer rptmonth;
		/**itemcode==>db_column: ITEMCODE*/
		private java.lang.Integer itemcode;
		/**rpttype==>db_column: RPTTYPE*/
		private java.lang.String rpttype;
		/**itemvalue==>db_column: ITEMVALUE*/
		private String itemvalue;
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
		/**deleteflag==>db_column: DELETEFLAG*/
		private java.lang.Integer deleteflag;
		/**validate==>db_column: VALIDATE*/
		private String validate;
		/**orgcode==>db_column: ORGCODE*/
		private java.lang.String orgcode;
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

		public void setCashid(java.lang.String value) {
			this.cashid = value;
		}
		
		public java.lang.String getCashid() {
			return this.cashid;
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
		public void setRpttype(java.lang.String value) {
			this.rpttype = value;
		}
		
		public java.lang.String getRpttype() {
			return this.rpttype;
		}
		public void setItemvalue(String value) {
			this.itemvalue = value;
		}
		
		public String getItemvalue() {
			return this.itemvalue;
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
		public void setDeleteflag(java.lang.Integer value) {
			this.deleteflag = value;
		}
		
		public java.lang.Integer getDeleteflag() {
			return this.deleteflag;
		}
		public void setValidate(String value) {
			this.validate = value;
		}
		
		public String getValidate() {
			return this.validate;
		}
		public void setOrgcode(java.lang.String value) {
			this.orgcode = value;
		}
		
		public java.lang.String getOrgcode() {
			return this.orgcode;
		}

		public String toString() {
			return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("Cashid",getCashid())
				.append("Rptid",getRptid())
				.append("Rptmonth",getRptmonth())
				.append("Itemcode",getItemcode())
				.append("Rpttype",getRpttype())
				.append("Itemvalue",getItemvalue())
				.append("Rptstatus",getRptstatus())
				.append("Rptbatch",getRptbatch())
				.append("Rptdate",getRptdate())
				.append("Processstatus",getProcessstatus())
				.append("Deleteflag",getDeleteflag())
				.append("Validate",getValidate())
				.append("Orgcode",getOrgcode())
				.toString();
		}
		
		public int hashCode() {
			return new HashCodeBuilder()
				.toHashCode();
		}
		
	}

