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

public class FinanceRefundInfo extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
		public static final String TABLE_ALIAS = "Loanmoneyreturn";
		public static final String ALIAS_RETURNLOANMONEYID = "returnloanmoneyid";
		public static final String ALIAS_LOANMONEYID = "loanmoneyid";
		public static final String ALIAS_RETURNDATE = "returndate";
		public static final String ALIAS_RETURNAMOUNT = "returnamount";
		public static final String ALIAS_RETURNINTEREST = "returninterest";
		public static final String ALIAS_ORGCODE = "orgcode";
		
		//date formats
		public static final String FORMAT_RETURNDATE = DATE_FORMAT;
		

		
		//columns START
		/**returnloanmoneyid==>db_column: RETURNLOANMONEYID*/
		private java.lang.String returnloanmoneyid;
		/**loanmoneyid==>db_column: LOANMONEYID*/
		private java.lang.String loanmoneyid;
		private String returndateBegin;
		private String returndateEnd;
		private String returndate;
		
		public String getReturndateBegin() {
			return this.returndateBegin;
		}
		
		public void setReturndateBegin(String value) {
			this.returndateBegin = value;
		}	
		
		public String getReturndateEnd() {
			return this.returndateEnd;
		}
		
		public void setReturndateEnd(String value) {
			this.returndateEnd = value;
		}
		
		/**returnamount==>db_column: RETURNAMOUNT*/
		private String returnamount;
		/**returninterest==>db_column: RETURNINTEREST*/
		private String returninterest;
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

		public void setReturnloanmoneyid(java.lang.String value) {
			this.returnloanmoneyid = value;
		}
		
		public java.lang.String getReturnloanmoneyid() {
			return this.returnloanmoneyid;
		}
		public void setLoanmoneyid(java.lang.String value) {
			this.loanmoneyid = value;
		}
		
		public java.lang.String getLoanmoneyid() {
			return this.loanmoneyid;
		}
		public void setReturndate(String value) {
			this.returndate = value;
		}
		
		public String getReturndate() {
			return this.returndate;
		}
		public void setReturnamount(String value) {
			this.returnamount = value;
		}
		
		public String getReturnamount() {
			return this.returnamount;
		}
		public void setReturninterest(String value) {
			this.returninterest = value;
		}
		
		public String getReturninterest() {
			return this.returninterest;
		}
		public void setOrgcode(java.lang.String value) {
			this.orgcode = value;
		}
		
		public java.lang.String getOrgcode() {
			return this.orgcode;
		}

		public String toString() {
			return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("Returnloanmoneyid",getReturnloanmoneyid())
				.append("Loanmoneyid",getLoanmoneyid())
				.append("Returndate",getReturndate())
				.append("Returnamount",getReturnamount())
				.append("Returninterest",getReturninterest())
				.append("Orgcode",getOrgcode())
				.toString();
		}
		
		public int hashCode() {
			return new HashCodeBuilder()
				.append(getReturnloanmoneyid())
				.toHashCode();
		}
		
	}

