/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.aop.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

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

public class AopSysLog extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "AopSysLog";
	public static final String ALIAS_CODE = "主键";
	public static final String ALIAS_OPNM = "操作员姓名";
	public static final String ALIAS_OPTIME = "操作时间";
	public static final String ALIAS_OPRESULT = "执行的结果";
	public static final String ALIAS_METHOD_NAME = "方法名称";
	public static final String ALIAS_REMARK = "备注";
	public static final String ALIAS_METHOD_PARAM_NM = "方法参数个数";
	public static final String ALIAS_STATUS = "方法执行的结果状态1正常 2异常";
	public static final String ALIAS_METHOD_PARAM_VALUE = "方法参数值";
	public static final String ALIAS_GRADE = "方法等级";
	public static final String ALIAS_METHOD_PA_NAME = "方法参数名称";
	public static final String ALIAS_MODULE_NAME = "模块名称";
	public static final String ALIAS_FUNCTION_DESCRIP = "功能描述";
	
	//date formats
	
	public AopSysLog(){
	}

	public AopSysLog(
		java.lang.String code
	){
		this.code = code;
	}

	
	//columns START
	/**主键==>db_column: code*/
	private java.lang.String code;
	/**操作员姓名==>db_column: opnm*/
	private java.lang.String opnm;
	/**操作时间==>db_column: optime*/
	private String optime;
	/**执行的结果==>db_column: opresult*/
	private java.lang.String opresult;
	/**方法名称==>db_column: methodName*/
	private java.lang.String methodName;
	/**备注==>db_column: remark*/
	private java.lang.String remark;
	/**方法参数个数==>db_column: methodParamNm*/
	private java.lang.Integer methodParamNm;
	/**方法执行的结果状态1正常 2异常==>db_column: status*/
	private java.lang.Integer status;
	/**方法参数值==>db_column: methodParamValue*/
	private java.lang.String methodParamValue;
	/**方法等级==>db_column: grade*/
	private java.lang.Integer grade;
	/**方法参数名称==>db_column: methodPaName*/
	private java.lang.String methodPaName;
	/**模块名称==>db_column: moduleName*/
	private java.lang.String moduleName;
	/**功能描述==>db_column: functionDescrip*/
	private java.lang.String functionDescrip;
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

	public void setCode(java.lang.String value) {
		this.code = value;
	}
	
	public java.lang.String getCode() {
		return this.code;
	}
	public void setOpnm(java.lang.String value) {
		this.opnm = value;
	}
	
	public java.lang.String getOpnm() {
		return this.opnm;
	}
	public void setOptime(String optime) {
		this.optime = optime;
	}
	
	public String getOptime() {
		return this.optime;
	}
	public void setOpresult(java.lang.String value) {
		this.opresult = value;
	}
	
	public java.lang.String getOpresult() {
		return this.opresult;
	}
	public void setMethodName(java.lang.String value) {
		this.methodName = value;
	}
	
	public java.lang.String getMethodName() {
		return this.methodName;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}
	public void setMethodParamNm(java.lang.Integer value) {
		this.methodParamNm = value;
	}
	
	public java.lang.Integer getMethodParamNm() {
		return this.methodParamNm;
	}
	public void setStatus(java.lang.Integer value) {
		this.status = value;
	}
	
	public java.lang.Integer getStatus() {
		return this.status;
	}
	public void setMethodParamValue(java.lang.String value) {
		this.methodParamValue = value;
	}
	
	public java.lang.String getMethodParamValue() {
		return this.methodParamValue;
	}
	public void setGrade(java.lang.Integer value) {
		this.grade = value;
	}
	
	public java.lang.Integer getGrade() {
		return this.grade;
	}
	public void setMethodPaName(java.lang.String value) {
		this.methodPaName = value;
	}
	
	public java.lang.String getMethodPaName() {
		return this.methodPaName;
	}
	public void setModuleName(java.lang.String value) {
		this.moduleName = value;
	}
	
	public java.lang.String getModuleName() {
		return this.moduleName;
	}
	public void setFunctionDescrip(java.lang.String value) {
		this.functionDescrip = value;
	}
	
	public java.lang.String getFunctionDescrip() {
		return this.functionDescrip;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Code",getCode())
			.append("Opnm",getOpnm())
			.append("Optime",getOptime())
			.append("Opresult",getOpresult())
			.append("MethodName",getMethodName())
			.append("Remark",getRemark())
			.append("MethodParamNm",getMethodParamNm())
			.append("Status",getStatus())
			.append("MethodParamValue",getMethodParamValue())
			.append("Grade",getGrade())
			.append("MethodPaName",getMethodPaName())
			.append("ModuleName",getModuleName())
			.append("FunctionDescrip",getFunctionDescrip())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCode())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AopSysLog == false) return false;
		if(this == obj) return true;
		AopSysLog other = (AopSysLog)obj;
		return new EqualsBuilder()
			.append(getCode(),other.getCode())
			.isEquals();
	}
}

