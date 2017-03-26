package com.mf.financemng.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.mf.base.BaseEntity;

/**
 * @author chenenze
 * @2015-02-14
 * @version 1.0
 * @param <T>
 */

public class FnncCapitalreportmain extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "验资报告主表";
	public static final String ALIAS_DOCNO = "报告编号";
	public static final String ALIAS_DOCNM = "报告名称";
	public static final String ALIAS_DOCTP = "报告类型";
	public static final String ALIAS_DOCDT = "报告日期";
	public static final String ALIAS_REGISTCAPITOTA = "注册资金总计";
	public static final String ALIAS_CURRPAIDCAPITOTA = "当前实收资金总计";
	public static final String ALIAS_CURRPRATETOTA = "当前实收资金占总注册资金比例总计";
	public static final String ALIAS_REMARK = "备注";
	
	//date formats
	
	public FnncCapitalreportmain(){
	}

	public FnncCapitalreportmain(
		java.lang.String docno
	){
		this.docno = docno;
	}

	
	//columns START
	/**报告编号==>db_column: DOCNO*/
	private java.lang.String docno;
	/**报告名称==>db_column: DOCNM*/
	private java.lang.String docnm;
	/**报告类型==>db_column: DOCTP*/
	private java.lang.String doctp;
	/**报告日期==>db_column: DOCDT*/
	private java.lang.String docdt;
	/**注册资金总计==>db_column: REGISTCAPITOTA*/
	private java.lang.String registcapitota;
	/**当前实收资金总计==>db_column: CURRPAIDCAPITOTA*/
	private java.lang.String currpaidcapitota;
	/**当前实收资金占总注册资金比例总计==>db_column: CURRPRATETOTA*/
	private java.lang.String currpratetota;
	/**备注==>db_column: remark*/
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

	public void setDocno(java.lang.String value) {
		this.docno = value;
	}
	
	public java.lang.String getDocno() {
		return this.docno;
	}
	public void setDocnm(java.lang.String value) {
		this.docnm = value;
	}
	
	public java.lang.String getDocnm() {
		return this.docnm;
	}
	public void setDoctp(java.lang.String value) {
		this.doctp = value;
	}
	
	public java.lang.String getDoctp() {
		return this.doctp;
	}
	public void setDocdt(java.lang.String value) {
		this.docdt = value;
	}
	
	public java.lang.String getDocdt() {
		return this.docdt;
	}
	public void setRegistcapitota(java.lang.String value) {
		this.registcapitota = value;
	}
	
	public java.lang.String getRegistcapitota() {
		return this.registcapitota;
	}
	public void setCurrpaidcapitota(java.lang.String value) {
		this.currpaidcapitota = value;
	}
	
	public java.lang.String getCurrpaidcapitota() {
		return this.currpaidcapitota;
	}
	public void setCurrpratetota(java.lang.String value) {
		this.currpratetota = value;
	}
	
	public java.lang.String getCurrpratetota() {
		return this.currpratetota;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Docno",getDocno())
			.append("Docnm",getDocnm())
			.append("Doctp",getDoctp())
			.append("Docdt",getDocdt())
			.append("Registcapitota",getRegistcapitota())
			.append("Currpaidcapitota",getCurrpaidcapitota())
			.append("Currpratetota",getCurrpratetota())
			.append("Remark",getRemark())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getDocno())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof FnncCapitalreportmain == false) return false;
		if(this == obj) return true;
		FnncCapitalreportmain other = (FnncCapitalreportmain)obj;
		return new EqualsBuilder()
			.append(getDocno(),other.getDocno())
			.isEquals();
	}
}

