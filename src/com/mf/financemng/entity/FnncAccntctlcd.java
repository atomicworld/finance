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


/**
 * @author shenguangdong
 * @2015-02-10
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class FnncAccntctlcd {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "科目控制码";
	public static final String ALIAS_ACCNTNO = "科目编号";
	public static final String ALIAS_ACCNTCTLCD = "科目控制码";
	
	//date formats
	
	public FnncAccntctlcd(){
	}

	public FnncAccntctlcd(
		java.lang.String accntno
	){
		this.accntno = accntno;
	}

	
	//columns START
	/**科目编号==>db_column: ACCNTNO*/
	private java.lang.String accntno;
	/**科目控制码==>db_column: ACCNTCTLCD*/
	private java.lang.String accntctlcd;
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

	public void setAccntno(java.lang.String value) {
		this.accntno = value;
	}
	
	public java.lang.String getAccntno() {
		return this.accntno;
	}
	public void setAccntctlcd(java.lang.String value) {
		this.accntctlcd = value;
	}
	
	public java.lang.String getAccntctlcd() {
		return this.accntctlcd;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Accntno",getAccntno())
			.append("Accntctlcd",getAccntctlcd())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getAccntno())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof FnncAccntctlcd == false) return false;
		if(this == obj) return true;
		FnncAccntctlcd other = (FnncAccntctlcd)obj;
		return new EqualsBuilder()
			.append(getAccntno(),other.getAccntno())
			.isEquals();
	}
}

