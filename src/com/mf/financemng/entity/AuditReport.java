/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
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
 * @2015-08-24
 * @version 1.0
 * @param <T>
 */

public class AuditReport extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
		public static final String TABLE_ALIAS = "AuditReport";
		public static final String ALIAS_REPORTID = "reportid";
		public static final String ALIAS_REPORTYEAR = "reportyear";
		public static final String ALIAS_REPORTTYPE = "reporttype";
		public static final String ALIAS_ORGCODE = "orgcode";
		public static final String ALIAS_ORGANIZATION = "organization";
		public static final String ALIAS_UPDATEDATE = "updatedate";
		public static final String ALIAS_PSTATUS = "pstatus";
		public static final String ALIAS_ZSTATUS = "zstatus";
		public static final String ALIAS_XSTATUS = "xstatus";
		public static final String ALIAS_DELETEFLAG = "deleteflag";
		
		//date formats
		public static final String FORMAT_UPDATEDATE = DATE_FORMAT;
		
		public AuditReport(){
		}

		public AuditReport(
			java.lang.String reportid
		){
			this.reportid = reportid;
		}

		
		//columns START
		/**reportid==>db_column: REPORTID*/
		private java.lang.String reportid;
		/**reportyear==>db_column: REPORTYEAR*/
		private java.lang.String reportyear;
		/**reporttype==>db_column: REPORTTYPE*/
		private java.lang.Integer reporttype;
		/**orgcode==>db_column: ORGCODE*/
		private java.lang.String orgcode;
		/**organization==>db_column: ORGANIZATION*/
		private java.lang.String organization;
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
		
		/**pstatus==>db_column: PSTATUS*/
		private java.lang.Integer pstatus;
		/**zstatus==>db_column: ZSTATUS*/
		private java.lang.Integer zstatus;
		/**xstatus==>db_column: XSTATUS*/
		private java.lang.Integer xstatus;
		
		private java.lang.Integer deleteflag;
		
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

		public void setReportid(java.lang.String value) {
			this.reportid = value;
		}
		
		public java.lang.String getReportid() {
			return this.reportid;
		}
		public void setReportyear(java.lang.String value) {
			this.reportyear = value;
		}
		
		public java.lang.String getReportyear() {
			return this.reportyear;
		}
		public void setReporttype(java.lang.Integer value) {
			this.reporttype = value;
		}
		
		public java.lang.Integer getReporttype() {
			return this.reporttype;
		}
		public void setOrgcode(java.lang.String value) {
			this.orgcode = value;
		}
		
		public java.lang.String getOrgcode() {
			return this.orgcode;
		}
		public void setOrganization(java.lang.String value) {
			this.organization = value;
		}
		
		public java.lang.String getOrganization() {
			return this.organization;
		}
		
		public java.lang.String getUpdatedate() {
			return updatedate;
		}

		public void setUpdatedate(java.lang.String updatedate) {
			this.updatedate = updatedate;
		}

		public void setPstatus(java.lang.Integer value) {
			this.pstatus = value;
		}
		
		public java.lang.Integer getPstatus() {
			return this.pstatus;
		}
		public void setZstatus(java.lang.Integer value) {
			this.zstatus = value;
		}
		
		public java.lang.Integer getZstatus() {
			return this.zstatus;
		}
		public void setXstatus(java.lang.Integer value) {
			this.xstatus = value;
		}
		
		public java.lang.Integer getXstatus() {
			return this.xstatus;
		}

		public java.lang.Integer getDeleteflag() {
			return deleteflag;
		}

		public void setDeleteflag(java.lang.Integer deleteflag) {
			this.deleteflag = deleteflag;
		}

	

	
}

