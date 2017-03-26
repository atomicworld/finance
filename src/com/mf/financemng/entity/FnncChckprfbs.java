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
import com.mf.base.BaseEntity;

/**
 * @author xujiuhua
 * @2015-02-12
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class FnncChckprfbs extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "复核凭证基础表";
	public static final String ALIAS_PRFTRCNO = "原始凭证流水号";
	public static final String ALIAS_CHCKPRFTYP = "复核凭证类型";
	public static final String ALIAS_PRFCRTDT = "原始凭证生成日期";
	public static final String ALIAS_OPNO = "操作员编号";
	public static final String ALIAS_REMARK = "备注";
	public static final String ALIAS_CHCKTRCNO = "复核流水号";
	public static final String ALIAS_ACCNTFLG = "记账标识";
	
	//date formats
	
	public FnncChckprfbs(){
	}

	public FnncChckprfbs(
		java.lang.String chcktrcno
	){
		this.chcktrcno = chcktrcno;
	}

	
	//columns START
	/**原始凭证流水号==>db_column: PRFTRCNO*/
	private java.lang.String prftrcno;
	/**复核凭证类型==>db_column: CHCKPRFTYP*/
	private java.lang.String chckprftyp;
	/**原始凭证生成日期==>db_column: PRFCRTDT*/
	private java.lang.String prfcrtdt;
	/**操作员编号==>db_column: OPNO*/
	private java.lang.String opno;
	/**备注==>db_column: REMARK*/
	private java.lang.String remark;
	/**复核流水号==>db_column: CHCKTRCNO*/
	private java.lang.String chcktrcno;
	/**记账标识==>db_column: ACCNTFLG*/
	private java.lang.String accntflg;
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

	public void setPrftrcno(java.lang.String value) {
		this.prftrcno = value;
	}
	
	public java.lang.String getPrftrcno() {
		return this.prftrcno;
	}
	public void setChckprftyp(java.lang.String value) {
		this.chckprftyp = value;
	}
	
	public java.lang.String getChckprftyp() {
		return this.chckprftyp;
	}
	public void setPrfcrtdt(java.lang.String value) {
		this.prfcrtdt = value;
	}
	
	public java.lang.String getPrfcrtdt() {
		return this.prfcrtdt;
	}
	public void setOpno(java.lang.String value) {
		this.opno = value;
	}
	
	public java.lang.String getOpno() {
		return this.opno;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}
	public void setChcktrcno(java.lang.String value) {
		this.chcktrcno = value;
	}
	
	public java.lang.String getChcktrcno() {
		return this.chcktrcno;
	}
	public void setAccntflg(java.lang.String value) {
		this.accntflg = value;
	}
	
	public java.lang.String getAccntflg() {
		return this.accntflg;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Prftrcno",getPrftrcno())
			.append("Chckprftyp",getChckprftyp())
			.append("Prfcrtdt",getPrfcrtdt())
			.append("Opno",getOpno())
			.append("Remark",getRemark())
			.append("Chcktrcno",getChcktrcno())
			.append("Accntflg",getAccntflg())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getChcktrcno())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof FnncChckprfbs == false) return false;
		if(this == obj) return true;
		FnncChckprfbs other = (FnncChckprfbs)obj;
		return new EqualsBuilder()
			.append(getChcktrcno(),other.getChcktrcno())
			.isEquals();
	}
}

