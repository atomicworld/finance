/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.aftrmng.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.mf.base.BaseEntity;

/**
 * @author wangyw
 * @2015-04-20
 * @version 1.0
 * @param <T>
 */

public class AfterReadamnt extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "AfterReadamnt";
	public static final String ALIAS_RECDID = "recdid";
	public static final String ALIAS_TOTALAMNT = "总金额";
	public static final String ALIAS_AMNT = "损失准备金额";
	public static final String ALIAS_RATE = "利率";
	public static final String ALIAS_CRTDATE = "crtdate";
	
	//date formats
	
	public AfterReadamnt(){
	}

	public AfterReadamnt(
		java.lang.String recdid
	){
		this.recdid = recdid;
	}

	
	//columns START
	/**recdid==>db_column: recdid*/
	private java.lang.String recdid;
	/**总金额==>db_column: totalamnt*/
	private java.lang.Long totalamnt;
	/**损失准备金额==>db_column: amnt*/
	private java.lang.Long amnt;
	/**利率==>db_column: rate*/
	private java.lang.String rate;
	/**crtdate==>db_column: crtdate*/
	private java.lang.String crtdate;
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

	public void setRecdid(java.lang.String value) {
		this.recdid = value;
	}
	
	public java.lang.String getRecdid() {
		return this.recdid;
	}
	public void setTotalamnt(java.lang.Long value) {
		this.totalamnt = value;
	}
	
	public java.lang.Long getTotalamnt() {
		return this.totalamnt;
	}
	public void setAmnt(java.lang.Long value) {
		this.amnt = value;
	}
	
	public java.lang.Long getAmnt() {
		return this.amnt;
	}
	public void setRate(java.lang.String value) {
		this.rate = value;
	}
	
	public java.lang.String getRate() {
		return this.rate;
	}
	public void setCrtdate(java.lang.String value) {
		this.crtdate = value;
	}
	
	public java.lang.String getCrtdate() {
		return this.crtdate;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Recdid",getRecdid())
			.append("Totalamnt",getTotalamnt())
			.append("Amnt",getAmnt())
			.append("Rate",getRate())
			.append("Crtdate",getCrtdate())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getRecdid())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AfterReadamnt == false) return false;
		if(this == obj) return true;
		AfterReadamnt other = (AfterReadamnt)obj;
		return new EqualsBuilder()
			.append(getRecdid(),other.getRecdid())
			.isEquals();
	}
}

