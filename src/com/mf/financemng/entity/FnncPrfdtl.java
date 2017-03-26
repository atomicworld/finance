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
 * @author yangchao
 * @2015-02-11
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class FnncPrfdtl extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "原始凭证详情表";
	public static final String ALIAS_PRFTRCNO = "凭证流水号";
	public static final String ALIAS_SQNNO = "顺序号";
	public static final String ALIAS_ACCNTNO = "科目编号";
	public static final String ALIAS_UPACCNTNO = "所属科目编号";
	public static final String ALIAS_JDFLG = "借贷标识";
	public static final String ALIAS_AMNT = "发生金额";
	public static final String ALIAS_REMARK = "摘要";
	
	//date formats
	
	public FnncPrfdtl(){
	}

	public FnncPrfdtl(
		java.lang.String sqnno
	){
		this.sqnno = sqnno;
	}

	
	//columns START
	/**凭证流水号==>db_column: PRFTRCNO*/
	private java.lang.String prftrcno;
	/**主键id==>db_column: SQNNO*/
	private java.lang.String sqnno;
	/**科目编号==>db_column: ACCNTNO*/
	private java.lang.String accntno;
	/**所属科目编号==>db_column: UPACCNTNO*/
	private java.lang.String upaccntno;
	/**借贷标识==>db_column: JDFLG*/
	private java.lang.String jdflg;
	/**发生金额==>db_column: AMNT*/
	private BigDecimal amnt;
	/**摘要==>db_column: REMARK*/
	private java.lang.String remark;
	/**顺序号==>db_column: REMARK*/
	private java.lang.String sqsort;
	
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

	public void setPrftrcno(java.lang.String value) {
		this.prftrcno = value;
	}
	
	public java.lang.String getPrftrcno() {
		return this.prftrcno;
	}
	public void setSqnno(java.lang.String value) {
		this.sqnno = value;
	}
	
	public java.lang.String getSqnno() {
		return this.sqnno;
	}
	public void setAccntno(java.lang.String value) {
		this.accntno = value;
	}
	
	public java.lang.String getAccntno() {
		return this.accntno;
	}
	public void setUpaccntno(java.lang.String value) {
		this.upaccntno = value;
	}
	
	public java.lang.String getUpaccntno() {
		return this.upaccntno;
	}
	public void setJdflg(java.lang.String value) {
		this.jdflg = value;
	}
	
	public java.lang.String getJdflg() {
		return this.jdflg;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Prftrcno",getPrftrcno())
			.append("Sqnno",getSqnno())
			.append("Accntno",getAccntno())
			.append("Upaccntno",getUpaccntno())
			.append("Jdflg",getJdflg())
			.append("Amnt",getAmnt())
			.append("Remark",getRemark())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getPrftrcno())
			.append(getSqnno())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof FnncPrfdtl == false) return false;
		if(this == obj) return true;
		FnncPrfdtl other = (FnncPrfdtl)obj;
		return new EqualsBuilder()
			.append(getPrftrcno(),other.getPrftrcno())
			.append(getSqnno(),other.getSqnno())
			.isEquals();
	}

	public BigDecimal getAmnt() {
		return amnt;
	}

	public void setAmnt(BigDecimal amnt) {
		this.amnt = amnt;
	}

	public java.lang.String getSqsort() {
		return sqsort;
	}

	public void setSqsort(java.lang.String sqsort) {
		this.sqsort = sqsort;
	}
}

