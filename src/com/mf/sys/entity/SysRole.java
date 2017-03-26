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


public class SysRole extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "SysRole";
	public static final String ALIAS_RLID = "角色编号";
	public static final String ALIAS_RLNM = "角色名称";
	public static final String ALIAS_RLRIGHT = "权限标识";
	public static final String ALIAS_REMARK = "备注";
	public static final String ALIAS_RLLVL = "角色级别";
	
	//date formats
	
	public SysRole(){
	}

	public SysRole(
		java.lang.String rlid
	){
		this.rlid = rlid;
	}

	
	//columns START
	/**角色编号==>db_column: RLID*/
	private java.lang.String rlid;
	/**角色名称==>db_column: RLNM*/
	private java.lang.String rlnm;
	/**权限标识==>db_column: RLRIGHT*/
	private java.lang.String rlright;
	/**备注==>db_column: REMARK*/
	private java.lang.String remark;
	/**角色级别==>db_column: RLLVL*/
	private java.lang.String rllvl;
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

	public void setRlid(java.lang.String value) {
		this.rlid = value;
	}
	
	public java.lang.String getRlid() {
		return this.rlid;
	}
	public void setRlnm(java.lang.String value) {
		this.rlnm = value;
	}
	
	public java.lang.String getRlnm() {
		return this.rlnm;
	}
	public void setRlright(java.lang.String value) {
		this.rlright = value;
	}
	
	public java.lang.String getRlright() {
		return this.rlright;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}
	public void setRllvl(java.lang.String value) {
		this.rllvl = value;
	}
	
	public java.lang.String getRllvl() {
		return this.rllvl;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Rlid",getRlid())
			.append("Rlnm",getRlnm())
			.append("Rlright",getRlright())
			.append("Remark",getRemark())
			.append("Rllvl",getRllvl())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getRlid())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SysRole == false) return false;
		if(this == obj) return true;
		SysRole other = (SysRole)obj;
		return new EqualsBuilder()
			.append(getRlid(),other.getRlid())
			.isEquals();
	}
}

