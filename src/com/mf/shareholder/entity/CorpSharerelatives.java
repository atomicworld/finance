/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.shareholder.entity;

import com.mf.base.BaseEntity;

/**
 * @author wangyw
 * @2015-08-24
 * @version 1.0
 * @param <T>
 */

public class CorpSharerelatives extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "CorpSharerelatives";
	public static final String ALIAS_SHARENO = "股东编号";
	public static final String ALIAS_RELATIVENO = "亲属编号";
	public static final String ALIAS_NAME = "姓名";
	public static final String ALIAS_IDCARD = "证件号";
	public static final String ALIAS_GENDER = "性别";
	public static final String ALIAS_RELATION = "关系";
	public static final String ALIAS_WORK_UNIT = "工作单位";
	public static final String ALIAS_WORK_INFO = "任职情况";
	
	//columns START
	/**股东编号==>db_column: shareno*/
	private java.lang.String shareno;
	/**亲属编号==>db_column: relativeno*/
	private java.lang.String relativeno;
	/**姓名==>db_column: Name*/
	private java.lang.String name;
	/**证件号==>db_column: IDCard*/
	private java.lang.String idcard;
	/**性别==>db_column: Gender*/
	private java.lang.String gender;
	/**关系==>db_column: Relation*/
	private java.lang.String relation;
	/**工作单位==>db_column: WorkUnit*/
	private java.lang.String workUnit;
	/**任职情况==>db_column: WorkInfo*/
	private java.lang.String workInfo;
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

	public void setShareno(java.lang.String value) {
		this.shareno = value;
	}
	
	public java.lang.String getShareno() {
		return this.shareno;
	}
	public void setRelativeno(java.lang.String value) {
		this.relativeno = value;
	}
	
	public java.lang.String getRelativeno() {
		return this.relativeno;
	}
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	public void setIdcard(java.lang.String value) {
		this.idcard = value;
	}
	
	public java.lang.String getIdcard() {
		return this.idcard;
	}
	public void setGender(java.lang.String value) {
		this.gender = value;
	}
	
	public java.lang.String getGender() {
		return this.gender;
	}
	public void setRelation(java.lang.String value) {
		this.relation = value;
	}
	
	public java.lang.String getRelation() {
		return this.relation;
	}
	public void setWorkUnit(java.lang.String value) {
		this.workUnit = value;
	}
	
	public java.lang.String getWorkUnit() {
		return this.workUnit;
	}
	public void setWorkInfo(java.lang.String value) {
		this.workInfo = value;
	}
	
	public java.lang.String getWorkInfo() {
		return this.workInfo;
	}

}

