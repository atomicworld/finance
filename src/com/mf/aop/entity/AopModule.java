/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.aop.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.mf.base.BaseEntity;

/**
 * @author wangzhi
 * @2015-09-23
 * @version 1.0
 * @param <T>
 */

public class AopModule extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "AopModule";
	public static final String ALIAS_ID = "主键id";
	public static final String ALIAS_GRADE = "方法等级1查询 2修改增加 3删除 4其他";
	public static final String ALIAS_MODULE_NAME = "模块的名称";
	public static final String ALIAS_METHOD_NAME = "方法名称";
	public static final String ALIAS_METHOD_PA_NAME = "方法参数名称";
	public static final String ALIAS_FUNCTION_DESCRIP = "功能描述";
	public static final String ALIAS_REMARK = "备注";
	public static final String ALIAS_PARAMNUMBER = "参数个数";
	
	//date formats
	
	public AopModule(){
	}

	public AopModule(
		java.lang.Integer id
	){
		this.id = id;
	}

	
	//columns START
	/**主键id==>db_column: id*/
	private java.lang.Integer id;
	/**方法等级1查询 2修改增加 3删除 4异常==>db_column: grade*/
	private java.lang.Integer grade;
	/**模块的名称==>db_column: moduleName*/
	private java.lang.String moduleName;
	/**方法名称==>db_column: methodName*/
	private java.lang.String methodName;
	/**方法参数名称==>db_column: methodPaName*/
	private java.lang.String methodPaName;
	/**功能描述==>db_column: FunctionDescrip*/
	private java.lang.String functionDescrip;
	/**备注==>db_column: remark*/
	private java.lang.String remark;
	/**参数个数==>db_column: paramnumber*/
	private java.lang.Integer paramnumber;
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

	public void setId(java.lang.Integer value) {
		this.id = value;
	}
	
	public java.lang.Integer getId() {
		return this.id;
	}
	public void setGrade(java.lang.Integer value) {
		this.grade = value;
	}
	
	public java.lang.Integer getGrade() {
		return this.grade;
	}
	public void setModuleName(java.lang.String value) {
		this.moduleName = value;
	}
	
	public java.lang.String getModuleName() {
		return this.moduleName;
	}
	public void setMethodName(java.lang.String value) {
		this.methodName = value;
	}
	
	public java.lang.String getMethodName() {
		return this.methodName;
	}
	public void setMethodPaName(java.lang.String value) {
		this.methodPaName = value;
	}
	
	public java.lang.String getMethodPaName() {
		return this.methodPaName;
	}
	public void setFunctionDescrip(java.lang.String value) {
		this.functionDescrip = value;
	}
	
	public java.lang.String getFunctionDescrip() {
		return this.functionDescrip;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}
	public void setParamnumber(java.lang.Integer value) {
		this.paramnumber = value;
	}
	
	public java.lang.Integer getParamnumber() {
		return this.paramnumber;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Grade",getGrade())
			.append("ModuleName",getModuleName())
			.append("MethodName",getMethodName())
			.append("MethodPaName",getMethodPaName())
			.append("FunctionDescrip",getFunctionDescrip())
			.append("Remark",getRemark())
			.append("Paramnumber",getParamnumber())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AopModule == false) return false;
		if(this == obj) return true;
		AopModule other = (AopModule)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

