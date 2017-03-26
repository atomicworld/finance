package com.mf.sys.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.mf.base.BaseEntity;
import com.mf.sys.entity.*;
import com.mf.util.*;

/**
 * @author hw
 * @2015-08-20
 */

public class CompanyChange extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "CompanyChange";
	public static final String ALIAS_CHANGENO = "主键";
	public static final String ALIAS_CONPANYNO = "公司编号";
	public static final String ALIAS_DISPATCHNO = "发文号";
	public static final String ALIAS_FILENM = "文件名";
	public static final String ALIAS_CHANGEDT = "变更日期";
	public static final String ALIAS_CHANGEPRO = "变更项目";
	public static final String ALIAS_BEFORECHANGE = "变更前";
	public static final String ALIAS_AFTERCHANGE = "变更后";
	
	//date formats
	
	public CompanyChange(){
	}

	public CompanyChange(
		java.lang.String changeno
	){
		this.changeno = changeno;
	}

	
	//columns START
	/**主键==>db_column: changeno*/
	private java.lang.String changeno;
	/**公司编号==>db_column: companyno*/
	private java.lang.String companyno;
	/**发文号==>db_column: dispatchno*/
	private java.lang.String dispatchno;
	/**文件名==>db_column: filenm*/
	private java.lang.String filenm;
	/**变更日期==>db_column: changedt*/
	private java.lang.String changedt;
	/**变更项目==>db_column: changepro*/
	private java.lang.String changepro;
	/**变更前==>db_column: beforechange*/
	private java.lang.String beforechange;
	/**变更后==>db_column: afterchange*/
	private java.lang.String afterchange;
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

	public void setChangeno(java.lang.String value) {
		this.changeno = value;
	}
	
	public java.lang.String getChangeno() {
		return this.changeno;
	}
	public void setCompanyno(java.lang.String value) {
		this.companyno = value;
	}
	
	public java.lang.String getCompanyno() {
		return this.companyno;
	}
	public void setDispatchno(java.lang.String value) {
		this.dispatchno = value;
	}
	
	public java.lang.String getDispatchno() {
		return this.dispatchno;
	}
	public void setFilenm(java.lang.String value) {
		this.filenm = value;
	}
	
	public java.lang.String getFilenm() {
		return this.filenm;
	}
	public void setChangedt(java.lang.String value) {
		this.changedt = value;
	}
	
	public java.lang.String getChangedt() {
		return this.changedt;
	}
	public void setChangepro(java.lang.String value) {
		this.changepro = value;
	}
	
	public java.lang.String getChangepro() {
		return this.changepro;
	}
	public void setBeforechange(java.lang.String value) {
		this.beforechange = value;
	}
	
	public java.lang.String getBeforechange() {
		return this.beforechange;
	}
	public void setAfterchange(java.lang.String value) {
		this.afterchange = value;
	}
	
	public java.lang.String getAfterchange() {
		return this.afterchange;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Changeno",getChangeno())
			.append("Conpanyno",getCompanyno())
			.append("Dispatchno",getDispatchno())
			.append("Filenm",getFilenm())
			.append("Changedt",getChangedt())
			.append("Changepro",getChangepro())
			.append("Beforechange",getBeforechange())
			.append("Afterchange",getAfterchange())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getChangeno())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof CompanyChange == false) return false;
		if(this == obj) return true;
		CompanyChange other = (CompanyChange)obj;
		return new EqualsBuilder()
			.append(getChangeno(),other.getChangeno())
			.isEquals();
	}
}

