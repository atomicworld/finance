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

/**
 * @author wangyw
 * @2015-04-15
 * @version 1.0
 * @param <T>
 */

public class FnncDealitem extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "FnncDealitem";
	public static final String ALIAS_RCRDID = "rcrdid";
	public static final String ALIAS_DEALTYPE = "处理类型";
	public static final String ALIAS_REMARK = "remark";
	public static final String ALIAS_DLFLG = "借贷方向（1借2贷）";
	public static final String ALIAS_ACCNTNO = "科目号";
	public static final String ALIAS_ACCNTNAME = "科目名称";
	public static final String ALIAS_ACCNTTYPE="科目类型";
	
	//date formats
	
	public FnncDealitem(){
	}

	public FnncDealitem(
		java.lang.String rcrdid
	){
		this.rcrdid = rcrdid;
	}

	
	//columns START
	/**rcrdid==>db_column: RCRDID*/
	private java.lang.String rcrdid;
	/**处理类型==>db_column: DEALTYPE*/
	private java.lang.String dealtype;
	/**remark==>db_column: remark*/
	private java.lang.String remark;
	/**借贷方向（1借2贷）==>db_column: dlflg*/
	private java.lang.String dlflg;
	/**科目号==>db_column: accntno*/
	private java.lang.String accntno;
	/**科目名称==>db_column: accntname*/
	private java.lang.String accntname;
	/**科目类型==>db_column: accnttype*/
	private java.lang.String accnttype;
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

	public void setRcrdid(java.lang.String value) {
		this.rcrdid = value;
	}
	
	public java.lang.String getRcrdid() {
		return this.rcrdid;
	}
	public void setDealtype(java.lang.String value) {
		this.dealtype = value;
	}
	
	public java.lang.String getDealtype() {
		return this.dealtype;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}
	public void setDlflg(java.lang.String value) {
		this.dlflg = value;
	}
	
	public java.lang.String getDlflg() {
		return this.dlflg;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Rcrdid",getRcrdid())
			.append("Dealtype",getDealtype())
			.append("Remark",getRemark())
			.append("Dlflg",getDlflg())
			.append("Acctno",getAccntno())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getRcrdid())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof FnncDealitem == false) return false;
		if(this == obj) return true;
		FnncDealitem other = (FnncDealitem)obj;
		return new EqualsBuilder()
			.append(getRcrdid(),other.getRcrdid())
			.isEquals();
	}

	public void setAccntno(java.lang.String accntno) {
		this.accntno = accntno;
	}

	public java.lang.String getAccntno() {
		return accntno;
	}

	public void setAccntname(java.lang.String accntname) {
		this.accntname = accntname;
	}

	public java.lang.String getAccntname() {
		return accntname;
	}

	public void setAccnttype(java.lang.String accnttype) {
		this.accnttype = accnttype;
	}

	public java.lang.String getAccnttype() {
		return accnttype;
	}
}

