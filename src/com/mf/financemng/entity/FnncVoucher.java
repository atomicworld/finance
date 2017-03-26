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
 * @2015-03-03
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class FnncVoucher extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "FnncVoucher";
	public static final String ALIAS_PZNO = "pzno";
	public static final String ALIAS_CNTRCTNO = "cntrctno";
	public static final String ALIAS_DUENO = "dueno";
	public static final String ALIAS_TYPE = "记录类型 1 放款凭证 2 还款凭证";
	public static final String ALIAS_STATUS = "复核状态0 未复核 1 已复核";
	public static final String ALIAS_LOGID = "记录编号";
	
	//date formats
	
	public FnncVoucher(){
	}

	public FnncVoucher(
		java.lang.String pzno
	){
		this.pzno = pzno;
	}

	
	//columns START
	/**pzno==>db_column: pzno*/
	private java.lang.String pzno;
	/**cntrctno==>db_column: cntrctno*/
	private java.lang.String cntrctno;
	/**dueno==>db_column: dueno*/
	private java.lang.String dueno;
	/**记录类型 1 放款凭证 2 还款凭证==>db_column: type*/
	private java.lang.String type;
	/**复核状态0 未复核 1 已复核==>db_column: status*/
	private java.lang.String status;
	/**还款计划金额==>db_column: status*/
	private java.lang.String logid;//
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

	public void setPzno(java.lang.String value) {
		this.pzno = value;
	}
	
	public java.lang.String getPzno() {
		return this.pzno;
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
	public void setType(java.lang.String value) {
		this.type = value;
	}
	
	public java.lang.String getType() {
		return this.type;
	}
	public void setStatus(java.lang.String value) {
		this.status = value;
	}
	
	public java.lang.String getStatus() {
		return this.status;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Pzno",getPzno())
			.append("Cntrctno",getCntrctno())
			.append("Dueno",getDueno())
			.append("Type",getType())
			.append("Status",getStatus())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getPzno())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof FnncVoucher == false) return false;
		if(this == obj) return true;
		FnncVoucher other = (FnncVoucher)obj;
		return new EqualsBuilder()
			.append(getPzno(),other.getPzno())
			.isEquals();
	}

	public void setLogid(java.lang.String logid) {
		this.logid = logid;
	}

	public java.lang.String getLogid() {
		return logid;
	}
}

