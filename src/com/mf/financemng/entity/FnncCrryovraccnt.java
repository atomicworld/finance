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
 * @author yangchao
 * @2015-03-09
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class FnncCrryovraccnt extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "结转科目信息表";
	public static final String ALIAS_CRRYOVRTYP = "结转类型";
	public static final String ALIAS_CRRYOVRID = "结转项标识";
	public static final String ALIAS_CRRYOVRACCNTNO = "结转项所属科目";
	public static final String ALIAS_ACCNTNM = "科目名称";
	public static final String ALIAS_SEQNO = "顺序号";
	public static final String ALIAS_DSCP = "说明";
	public static final String ALIAS_RCRDID = "记录号";
	
	//date formats
	
	public FnncCrryovraccnt(){
	}

	public FnncCrryovraccnt(
		java.lang.Integer rcrdid
	){
		this.rcrdid = rcrdid;
	}

	
	//columns START
	/**结转类型==>db_column: CRRYOVRTYP*/
	private java.lang.String crryovrtyp;
	/**结转项标识==>db_column: CRRYOVRID*/
	private java.lang.String crryovrid;
	/**结转项所属科目==>db_column: CRRYOVRACCNTNO*/
	private java.lang.String crryovraccntno;
	/**科目名称==>db_column: ACCNTNM*/
	private java.lang.String accntnm;
	/**顺序号==>db_column: SEQNO*/
	private java.lang.String seqno;
	/**说明==>db_column: DSCP*/
	private java.lang.String dscp;
	/**记录号==>db_column: RCRDID*/
	private java.lang.Integer rcrdid;
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

	public void setCrryovrtyp(java.lang.String value) {
		this.crryovrtyp = value;
	}
	
	public java.lang.String getCrryovrtyp() {
		return this.crryovrtyp;
	}
	public void setCrryovrid(java.lang.String value) {
		this.crryovrid = value;
	}
	
	public java.lang.String getCrryovrid() {
		return this.crryovrid;
	}
	public void setCrryovraccntno(java.lang.String value) {
		this.crryovraccntno = value;
	}
	
	public java.lang.String getCrryovraccntno() {
		return this.crryovraccntno;
	}
	public void setAccntnm(java.lang.String value) {
		this.accntnm = value;
	}
	
	public java.lang.String getAccntnm() {
		return this.accntnm;
	}
	public void setSeqno(java.lang.String value) {
		this.seqno = value;
	}
	
	public java.lang.String getSeqno() {
		return this.seqno;
	}
	public void setDscp(java.lang.String value) {
		this.dscp = value;
	}
	
	public java.lang.String getDscp() {
		return this.dscp;
	}
	public void setRcrdid(java.lang.Integer value) {
		this.rcrdid = value;
	}
	
	public java.lang.Integer getRcrdid() {
		return this.rcrdid;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Crryovrtyp",getCrryovrtyp())
			.append("Crryovrid",getCrryovrid())
			.append("Crryovraccntno",getCrryovraccntno())
			.append("Accntnm",getAccntnm())
			.append("Seqno",getSeqno())
			.append("Dscp",getDscp())
			.append("Rcrdid",getRcrdid())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getRcrdid())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof FnncCrryovraccnt == false) return false;
		if(this == obj) return true;
		FnncCrryovraccnt other = (FnncCrryovraccnt)obj;
		return new EqualsBuilder()
			.append(getRcrdid(),other.getRcrdid())
			.isEquals();
	}
}

