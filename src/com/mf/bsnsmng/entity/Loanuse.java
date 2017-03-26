/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.bsnsmng.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


/**
 * @author shenguangdong
 * @2015-01-13
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class Loanuse {
	
	
	//alias
	public static final String TABLE_ALIAS = "Loanuse";
	public static final String ALIAS_USENO = "用途编号";
	public static final String ALIAS_USENM = "用途名称";
	public static final String ALIAS_USEDES = "用途说明";
	public static final String ALIAS_ISUSED = "是否启用";
	public static final String ALIAS_FRSTFTHR = "一级父节点";
	public static final String ALIAS_SCNDFTHR = "二级父节点";
	public static final String ALIAS_THRDFTHR = "三级父节点";
	public static final String ALIAS_LVL = "层次";
	public static final String ALIAS_ISBTTM = "是否最底层节点";
	public static final String ALIAS_RESERVED = "保留字段";
	

	
	//columns START
	/**用途编号==>db_column: USENO*/
	private java.lang.String useno;
	/**用途名称==>db_column: USENM*/
	private java.lang.String usenm;
	/**用途说明==>db_column: USEDES*/
	private java.lang.String usedes;
	/**是否启用==>db_column: ISUSED*/
	private java.lang.String isused;
	/**一级父节点==>db_column: FRSTFTHR*/
	private java.lang.String frstfthr;
	/**二级父节点==>db_column: SCNDFTHR*/
	private java.lang.String scndfthr;
	/**三级父节点==>db_column: THRDFTHR*/
	private java.lang.String thrdfthr;
	/**层次==>db_column: LVL*/
	private java.lang.String lvl;
	/**是否最底层节点==>db_column: ISBTTM*/
	private java.lang.String isbttm;
	/**保留字段==>db_column: RESERVED*/
	private java.lang.String reserved;
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

	public void setUseno(java.lang.String value) {
		this.useno = value;
	}
	
	public java.lang.String getUseno() {
		return this.useno;
	}
	public void setUsenm(java.lang.String value) {
		this.usenm = value;
	}
	
	public java.lang.String getUsenm() {
		return this.usenm;
	}
	public void setUsedes(java.lang.String value) {
		this.usedes = value;
	}
	
	public java.lang.String getUsedes() {
		return this.usedes;
	}
	public void setIsused(java.lang.String value) {
		this.isused = value;
	}
	
	public java.lang.String getIsused() {
		return this.isused;
	}
	public void setFrstfthr(java.lang.String value) {
		this.frstfthr = value;
	}
	
	public java.lang.String getFrstfthr() {
		return this.frstfthr;
	}
	public void setScndfthr(java.lang.String value) {
		this.scndfthr = value;
	}
	
	public java.lang.String getScndfthr() {
		return this.scndfthr;
	}
	public void setThrdfthr(java.lang.String value) {
		this.thrdfthr = value;
	}
	
	public java.lang.String getThrdfthr() {
		return this.thrdfthr;
	}
	public void setLvl(java.lang.String value) {
		this.lvl = value;
	}
	
	public java.lang.String getLvl() {
		return this.lvl;
	}
	public void setIsbttm(java.lang.String value) {
		this.isbttm = value;
	}
	
	public java.lang.String getIsbttm() {
		return this.isbttm;
	}
	public void setReserved(java.lang.String value) {
		this.reserved = value;
	}
	
	public java.lang.String getReserved() {
		return this.reserved;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Useno",getUseno())
			.append("Usenm",getUsenm())
			.append("Usedes",getUsedes())
			.append("Isused",getIsused())
			.append("Frstfthr",getFrstfthr())
			.append("Scndfthr",getScndfthr())
			.append("Thrdfthr",getThrdfthr())
			.append("Lvl",getLvl())
			.append("Isbttm",getIsbttm())
			.append("Reserved",getReserved())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Loanuse == false) return false;
		if(this == obj) return true;
		Loanuse other = (Loanuse)obj;
		return new EqualsBuilder()
			.isEquals();
	}
}

