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
import com.mf.sys.entity.*;

/**
 * @author yangchao
 * @2014-12-24
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class SysMenu implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "SysMenu";
	public static final String ALIAS_MNNO = "菜单编号";
	public static final String ALIAS_MNNM = "菜单名称";
	public static final String ALIAS_MNURL = "菜单对应URL";
	public static final String ALIAS_ISUSED = "是否启用";
	public static final String ALIAS_MNLVL = "菜单级别";
	
	//date formats
	
	public SysMenu(){
	}

	public SysMenu(
		java.lang.String mnno
	){
		this.mnno = mnno;
	}

	
	//columns START
	/**菜单编号==>db_column: MNNO*/
	private java.lang.String mnno;
	/**菜单名称==>db_column: MNNM*/
	private java.lang.String mnnm;
	/**菜单对应URL==>db_column: MNURL*/
	private java.lang.String mnurl;
	/**是否启用==>db_column: ISUSED*/
	private java.lang.String isused;
	/**菜单级别==>db_column: MNLVL*/
	private java.lang.String mnlvl;
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

	public void setMnno(java.lang.String value) {
		this.mnno = value;
	}
	
	public java.lang.String getMnno() {
		return this.mnno;
	}
	public void setMnnm(java.lang.String value) {
		this.mnnm = value;
	}
	
	public java.lang.String getMnnm() {
		return this.mnnm;
	}
	public void setMnurl(java.lang.String value) {
		this.mnurl = value;
	}
	
	public java.lang.String getMnurl() {
		return this.mnurl;
	}
	public void setIsused(java.lang.String value) {
		this.isused = value;
	}
	
	public java.lang.String getIsused() {
		return this.isused;
	}
	public void setMnlvl(java.lang.String value) {
		this.mnlvl = value;
	}
	
	public java.lang.String getMnlvl() {
		return this.mnlvl;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Mnno",getMnno())
			.append("Mnnm",getMnnm())
			.append("Mnurl",getMnurl())
			.append("Isused",getIsused())
			.append("Mnlvl",getMnlvl())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getMnno())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SysMenu == false) return false;
		if(this == obj) return true;
		SysMenu other = (SysMenu)obj;
		return new EqualsBuilder()
			.append(getMnno(),other.getMnno())
			.isEquals();
	}
}

