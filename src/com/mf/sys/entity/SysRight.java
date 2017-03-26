/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.sys.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.mf.base.BaseEntity;
import com.mf.sys.entity.*; 
import com.mf.util.*;

/**
 * @author yangchao
 * @2014-12-24
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class SysRight extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "SysRight";
	public static final String ALIAS_RGHTNO = "权限编号";
	public static final String ALIAS_RGHTNM = "权限名称";
	public static final String ALIAS_ISUSED = "是否生效";
	public static final String ALIAS_MNNO = "对应菜单编号";
	
	//date formats
	
	public SysRight(){
		super();
	}

	public SysRight(java.lang.String rghtno){
		super();
		this.rghtno = rghtno;
	}

	
	//columns START
	/**权限编号==>db_column: RGHTNO*/
	private java.lang.String rghtno;
	/**权限名称==>db_column: RGHTNM*/
	private java.lang.String rghtnm;
	/**是否生效==>db_column: ISUSED*/
	private java.lang.String isused;
	/**对应菜单编号==>db_column: MNNO*/
	private java.lang.String mnno;
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

	public void setRghtno(java.lang.String value) {
		this.rghtno = value;
	}
	
	public java.lang.String getRghtno() {
		return this.rghtno;
	}
	public void setRghtnm(java.lang.String value) {
		this.rghtnm = value;
	}
	
	public java.lang.String getRghtnm() {
		return this.rghtnm;
	}
	public void setIsused(java.lang.String value) {
		this.isused = value;
	}
	
	public java.lang.String getIsused() {
		return this.isused;
	}
	public void setMnno(java.lang.String value) {
		this.mnno = value;
	}
	
	public java.lang.String getMnno() {
		return this.mnno;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Rghtno",getRghtno())
			.append("Rghtnm",getRghtnm())
			.append("Isused",getIsused())
			.append("Mnno",getMnno())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getRghtno())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SysRight == false) return false;
		if(this == obj) return true;
		SysRight other = (SysRight)obj;
		return new EqualsBuilder()
			.append(getRghtno(),other.getRghtno())
			.isEquals();
	}
}

