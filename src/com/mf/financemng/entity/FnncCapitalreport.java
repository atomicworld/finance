package com.mf.financemng.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.mf.base.BaseEntity;

/**
 * @author chenenze
 * @2015-02-11
 * @version 1.0
 * @param <T>
 */

public class FnncCapitalreport extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "验资报告表";
	public static final String ALIAS_SHARHOLDNO = "股东编号";
	public static final String ALIAS_SHARHOLDNM = "股东姓名";
	public static final String ALIAS_DOCNO = "报告编号";
	public static final String ALIAS_DOCNM = "报告名称";
	public static final String ALIAS_DOCTP = "报告类型";
	public static final String ALIAS_DOCDT = "报告日期";
	public static final String ALIAS_REGISTCAPIT = "注册资金";
	public static final String ALIAS_REGISTCAPITOTA = "注册资金总计";
	public static final String ALIAS_REPRATE = "注册资金占总注册资金比例";
	public static final String ALIAS_REPRATETOTA = "注册资金占总注册资金比总计";
	public static final String ALIAS_EARPAIDCAPIT = "前期实收资金";
	public static final String ALIAS_EARPAIDCAPITOTA = "前期实收资金总计";
	public static final String ALIAS_EARPRATE = "前期实收资金占总注册资金比例";
	public static final String ALIAS_EARPRATETOTA = "前期实收资金占总注册资金比例总计";
	public static final String ALIAS_GROWPAIDCAPIT = "新增实收资金";
	public static final String ALIAS_GROWPAIDCAPITOTA = "新增实收资金总计";
	public static final String ALIAS_GROWPRATE = "新增实收资金占总注册资金比例";
	public static final String ALIAS_GROWPRATETOTA = "新增实收资金占总注册资金比例总计";
	public static final String ALIAS_CURRPAIDCAPIT = "当前实收资金";
	public static final String ALIAS_CURRPAIDCAPITOTA = "当前实收资金总计";
	public static final String ALIAS_CURRPRATE = "当前实收资金占总注册资金比例";
	public static final String ALIAS_CURRPRATETOTA = "当前实收资金占总注册资金比例总计";
	public static final String ALIAS_SCDATE = "登记日期";
	public static final String ALIAS_LASTMODDATE = "更新日期";
	public static final String ALIAS_REGOPNO = "登记人编号";
	public static final String ALIAS_DEPNO = "部门编号";
	public static final String ALIAS_REMARK = "备注";
	
	//date formats
	
	public FnncCapitalreport(){
	}

	public FnncCapitalreport(
		java.lang.String docno
	){
		this.docno = docno;
	}

	
	//columns START
	/**股东编号==>db_column: sharholdno*/
	private java.lang.String sharholdno;
	/**股东姓名==>db_column: sharholdnm*/
	private java.lang.String sharholdnm;
	/**报告编号==>db_column: docno*/
	private java.lang.String  docno;
	/**报告名称==>db_column: docnm*/
	private java.lang.String docnm;
	/**报告类型==>db_column: doctp*/
	private java.lang.String doctp;
	/**报告日期==>db_column: docdt*/
	private java.lang.String docdt;
	/**注册资金==>db_column: registcapit*/
	private java.lang.String registcapit;
	/**注册资金总计==>db_column: registcapitota*/
	private java.lang.String registcapitota;
	/**注册资金占总注册资金比例==>db_column: reprate*/
	private java.lang.String reprate;
	/**注册资金占总注册资金比总计==>db_column: repratetota*/
	private java.lang.String repratetota;
	/**前期实收资金==>db_column: earpaidcapit*/
	private java.lang.String earpaidcapit;
	/**前期实收资金总计==>db_column: earpaidcapitota*/
	private java.lang.String earpaidcapitota;
	/**前期实收资金占总注册资金比例==>db_column: earprate*/
	private java.lang.String earprate;
	/**前期实收资金占总注册资金比例总计==>db_column: earpratetota*/
	private java.lang.String earpratetota;
	/**新增实收资金==>db_column: growpaidcapit*/
	private java.lang.String growpaidcapit;
	/**新增实收资金总计==>db_column: growpaidcapitota*/
	private java.lang.String growpaidcapitota;
	/**新增实收资金占总注册资金比例==>db_column: growprate*/
	private java.lang.String growprate;
	/**新增实收资金占总注册资金比例总计==>db_column: growpratetota*/
	private java.lang.String growpratetota;
	/**当前实收资金==>db_column: currpaidcapit*/
	private java.lang.String currpaidcapit;
	/**当前实收资金总计==>db_column: currpaidcapitota*/
	private java.lang.String currpaidcapitota;
	/**当前实收资金占总注册资金比例==>db_column: currprate*/
	private java.lang.String currprate;
	/**当前实收资金占总注册资金比例总计==>db_column: currpratetota*/
	private java.lang.String currpratetota;
	/**登记日期==>db_column: scdate*/
	private java.lang.String scdate;
	/**更新日期==>db_column: lastmoddate*/
	private java.lang.String lastmoddate;
	/**登记人编号==>db_column: regopno*/
	private java.lang.String regopno;
	/**部门编号==>db_column: depno*/
	private java.lang.String depno;
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

	public void setSharholdno(java.lang.String value) {
		this.sharholdno = value;
	}
	
	public java.lang.String getSharholdno() {
		return this.sharholdno;
	}
	public void setSharholdnm(java.lang.String value) {
		this.sharholdnm = value;
	}
	
	public java.lang.String getSharholdnm() {
		return this.sharholdnm;
	}
	public void setDocno(java.lang.String  value) {
		this.docno = value;
	}
	
	public java.lang.String  getDocno() {
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
	public void setRegistcapit(java.lang.String value) {
		this.registcapit = value;
	}
	
	public java.lang.String getRegistcapit() {
		return this.registcapit;
	}
	public void setRegistcapitota(java.lang.String value) {
		this.registcapitota = value;
	}
	
	public java.lang.String getRegistcapitota() {
		return this.registcapitota;
	}
	public void setReprate(java.lang.String value) {
		this.reprate = value;
	}
	
	public java.lang.String getReprate() {
		return this.reprate;
	}
	public void setRepratetota(java.lang.String value) {
		this.repratetota = value;
	}
	
	public java.lang.String getRepratetota() {
		return this.repratetota;
	}
	public void setEarpaidcapit(java.lang.String value) {
		this.earpaidcapit = value;
	}
	
	public java.lang.String getEarpaidcapit() {
		return this.earpaidcapit;
	}
	public void setEarpaidcapitota(java.lang.String value) {
		this.earpaidcapitota = value;
	}
	
	public java.lang.String getEarpaidcapitota() {
		return this.earpaidcapitota;
	}
	public void setEarprate(java.lang.String value) {
		this.earprate = value;
	}
	
	public java.lang.String getEarprate() {
		return this.earprate;
	}
	public void setEarpratetota(java.lang.String value) {
		this.earpratetota = value;
	}
	
	public java.lang.String getEarpratetota() {
		return this.earpratetota;
	}
	public void setGrowpaidcapit(java.lang.String value) {
		this.growpaidcapit = value;
	}
	
	public java.lang.String getGrowpaidcapit() {
		return this.growpaidcapit;
	}
	public void setGrowpaidcapitota(java.lang.String value) {
		this.growpaidcapitota = value;
	}
	
	public java.lang.String getGrowpaidcapitota() {
		return this.growpaidcapitota;
	}
	public void setGrowprate(java.lang.String value) {
		this.growprate = value;
	}
	
	public java.lang.String getGrowprate() {
		return this.growprate;
	}
	public void setGrowpratetota(java.lang.String value) {
		this.growpratetota = value;
	}
	
	public java.lang.String getGrowpratetota() {
		return this.growpratetota;
	}
	public void setCurrpaidcapit(java.lang.String value) {
		this.currpaidcapit = value;
	}
	
	public java.lang.String getCurrpaidcapit() {
		return this.currpaidcapit;
	}
	public void setCurrpaidcapitota(java.lang.String value) {
		this.currpaidcapitota = value;
	}
	
	public java.lang.String getCurrpaidcapitota() {
		return this.currpaidcapitota;
	}
	public void setCurrprate(java.lang.String value) {
		this.currprate = value;
	}
	
	public java.lang.String getCurrprate() {
		return this.currprate;
	}
	public void setCurrpratetota(java.lang.String value) {
		this.currpratetota = value;
	}
	
	public java.lang.String getCurrpratetota() {
		return this.currpratetota;
	}
	public void setScdate(java.lang.String value) {
		this.scdate = value;
	}
	
	public java.lang.String getScdate() {
		return this.scdate;
	}
	public void setLastmoddate(java.lang.String value) {
		this.lastmoddate = value;
	}
	
	public java.lang.String getLastmoddate() {
		return this.lastmoddate;
	}
	public void setRegopno(java.lang.String value) {
		this.regopno = value;
	}
	
	public java.lang.String getRegopno() {
		return this.regopno;
	}
	public void setDepno(java.lang.String value) {
		this.depno = value;
	}
	
	public java.lang.String getDepno() {
		return this.depno;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Sharholdno",getSharholdno())
			.append("Sharholdnm",getSharholdnm())
			.append("Docno",getDocno())
			.append("Docnm",getDocnm())
			.append("Doctp",getDoctp())
			.append("Docdt",getDocdt())
			.append("Registcapit",getRegistcapit())
			.append("Registcapitota",getRegistcapitota())
			.append("Reprate",getReprate())
			.append("Repratetota",getRepratetota())
			.append("Earpaidcapit",getEarpaidcapit())
			.append("Earpaidcapitota",getEarpaidcapitota())
			.append("Earprate",getEarprate())
			.append("Earpratetota",getEarpratetota())
			.append("Growpaidcapit",getGrowpaidcapit())
			.append("Growpaidcapitota",getGrowpaidcapitota())
			.append("Growprate",getGrowprate())
			.append("Growpratetota",getGrowpratetota())
			.append("Currpaidcapit",getCurrpaidcapit())
			.append("Currpaidcapitota",getCurrpaidcapitota())
			.append("Currprate",getCurrprate())
			.append("Currpratetota",getCurrpratetota())
			.append("Scdate",getScdate())
			.append("Lastmoddate",getLastmoddate())
			.append("Regopno",getRegopno())
			.append("Depno",getDepno())
			.append("Remark",getRemark())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getDocno())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof FnncCapitalreport == false) return false;
		if(this == obj) return true;
		FnncCapitalreport other = (FnncCapitalreport)obj;
		return new EqualsBuilder()
			.append(getDocno(),other.getDocno())
			.isEquals();
	}
}

