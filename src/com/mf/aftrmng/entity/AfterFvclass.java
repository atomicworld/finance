package com.mf.aftrmng.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.mf.base.BaseEntity;

/**
 * @author chenenze
 * @2015-01-20
 * @version 1.0
 * @param <T>
 */

public class AfterFvclass extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "五级分类表";
	public static final String ALIAS_RCRDID = "记录号";
	public static final String ALIAS_CLNTNO = "客户编号";
	public static final String ALIAS_CLNTNM = "客户姓名";
	public static final String ALIAS_CNTRCTNO = "合同编号";
	public static final String ALIAS_DUENO = "借据编号";
	public static final String ALIAS_CLSSTYP = "执行分级类型";
	public static final String ALIAS_AUTORSLT = "自动分级结果";
	public static final String ALIAS_MANUALRSLT = "人工分级结果";
	public static final String ALIAS_MANUALDES = "人工分级原因描述";
	public static final String ALIAS_AUTODT = "自动分类日期";
	public static final String ALIAS_MANUALDT = "人工分类日期";
	public static final String ALIAS_SVNCLSSRSLT = "人工认定七级分类结果";
	public static final String ALIAS_TENCLSSRSLT = "人工认定十级分类结果";
	
	//date formats
	
	public AfterFvclass(){
	}

	public AfterFvclass(
		java.lang.Integer rcrdid
	){
		this.rcrdid = rcrdid;
	}

	
	//columns START
	/**记录号==>db_column: RCRDID*/
	private java.lang.Integer rcrdid;
	/**客户编号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**客户姓名==>db_column: CLNTNM*/
	private java.lang.String clntnm;
	/**合同编号==>db_column: CNTRCTNO*/
	private java.lang.String cntrctno;
	/**借据编号==>db_column: DUENO*/
	private java.lang.String dueno;
	/**执行分级类型==>db_column: CLSSTYP*/
	private java.lang.String clsstyp;
	/**自动分级结果==>db_column: AUTORSLT*/
	private java.lang.String autorslt;
	/**人工分级结果==>db_column: MANUALRSLT*/
	private java.lang.String manualrslt;
	/**人工分级原因描述==>db_column: MANUALDES*/
	private java.lang.String manualdes;
	/**自动分类日期==>db_column: AUTODT*/
	private java.lang.String autodt;
	/**人工分类日期==>db_column: MANUALDT*/
	private java.lang.String manualdt;
	/**人工认定七级分类结果==>db_column: SVNCLSSRSLT*/
	private java.lang.String svnclssrslt;
	/**人工认定十级分类结果==>db_column: TENCLSSRSLT*/
	private java.lang.String tenclssrslt;
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

	public void setRcrdid(java.lang.Integer value) {
		this.rcrdid = value;
	}
	
	public java.lang.Integer getRcrdid() {
		return this.rcrdid;
	}
	public void setClntno(java.lang.String value) {
		this.clntno = value;
	}
	
	public java.lang.String getClntno() {
		return this.clntno;
	}
	public void setClntnm(java.lang.String value) {
		this.clntnm = value;
	}
	
	public java.lang.String getClntnm() {
		return this.clntnm;
	}
	public void setCntrctno(java.lang.String value) {
		this.cntrctno = value;
	}
	
	public java.lang.String getCntrctno() {
		return this.cntrctno;
	}
	public void setDueno(java.lang.String value) {
		this.dueno = value;
	}
	
	public java.lang.String getDueno() {
		return this.dueno;
	}
	public void setClsstyp(java.lang.String value) {
		this.clsstyp = value;
	}
	
	public java.lang.String getClsstyp() {
		return this.clsstyp;
	}
	public void setAutorslt(java.lang.String value) {
		this.autorslt = value;
	}
	
	public java.lang.String getAutorslt() {
		return this.autorslt;
	}
	public void setManualrslt(java.lang.String value) {
		this.manualrslt = value;
	}
	
	public java.lang.String getManualrslt() {
		return this.manualrslt;
	}
	public void setManualdes(java.lang.String value) {
		this.manualdes = value;
	}
	
	public java.lang.String getManualdes() {
		return this.manualdes;
	}
	public void setAutodt(java.lang.String value) {
		this.autodt = value;
	}
	
	public java.lang.String getAutodt() {
		return this.autodt;
	}
	public void setManualdt(java.lang.String value) {
		this.manualdt = value;
	}
	
	public java.lang.String getManualdt() {
		return this.manualdt;
	}
	public void setSvnclssrslt(java.lang.String value) {
		this.svnclssrslt = value;
	}
	
	public java.lang.String getSvnclssrslt() {
		return this.svnclssrslt;
	}
	public void setTenclssrslt(java.lang.String value) {
		this.tenclssrslt = value;
	}
	
	public java.lang.String getTenclssrslt() {
		return this.tenclssrslt;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Rcrdid",getRcrdid())
			.append("Clntno",getClntno())
			.append("Clntnm",getClntnm())
			.append("Cntrctno",getCntrctno())
			.append("Dueno",getDueno())
			.append("Clsstyp",getClsstyp())
			.append("Autorslt",getAutorslt())
			.append("Manualrslt",getManualrslt())
			.append("Manualdes",getManualdes())
			.append("Autodt",getAutodt())
			.append("Manualdt",getManualdt())
			.append("Svnclssrslt",getSvnclssrslt())
			.append("Tenclssrslt",getTenclssrslt())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getRcrdid())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AfterFvclass == false) return false;
		if(this == obj) return true;
		AfterFvclass other = (AfterFvclass)obj;
		return new EqualsBuilder()
			.append(getRcrdid(),other.getRcrdid())
			.isEquals();
	}
}

