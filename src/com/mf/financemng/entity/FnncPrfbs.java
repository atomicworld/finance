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
 * @2015-01-29
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class FnncPrfbs extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "原始凭证基础表";
	public static final String ALIAS_PRFTRCNO = "凭证流水号";
	public static final String ALIAS_TXDT = "凭证发生日期";
	public static final String ALIAS_CHECKDT = "凭证复核日期";
	public static final String ALIAS_OPNO = "操作员编号";
	public static final String ALIAS_PRFTYP = "凭证类型";
	public static final String ALIAS_PRFNO = "凭证编号";
	public static final String ALIAS_DPTNO = "dptno";
	public static final String ALIAS_STT = "凭证状态";
	public static final String ALIAS_REGDT = "登记日期";
	public static final String ALIAS_REMARK = "摘要";
	
	
	//date formats
	
	public FnncPrfbs(){
	}

	public FnncPrfbs(
		java.lang.String prftrcno
	){
		this.prftrcno = prftrcno;
	}

	
	//columns START
	/**凭证流水号==>db_column: PRFTRCNO*/
	private java.lang.String prftrcno;
	/**凭证发生日期==>db_column: TXDT*/
	private java.lang.String txdt;
	/**凭证复核日期==>db_column: CHECKDT*/
	private java.lang.String checkdt;
	/**操作员编号==>db_column: OPNO*/
	private java.lang.String opno;
	/**凭证类型==>db_column: PRFTYP*/
	private java.lang.String prftyp;
	/**凭证编号==>db_column: PRFNO*/
	private java.lang.String prfno;
	/**dptno==>db_column: DPTNO*/
	private java.lang.String dptno;
	/**凭证状态==>db_column: STT*/
	private java.lang.String stt;
	/**凭证状态==>db_column: STT*/
	private java.lang.String regdt;
	/**凭证状态==>db_column: STT*/
	private java.lang.String remark;
	
	//columns END
	
	//系统框架字段 start
	
	public java.lang.String getRegdt() {
		return regdt;
	}

	public void setRegdt(java.lang.String regdt) {
		this.regdt = regdt;
	}

	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}


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
	public void setTxdt(java.lang.String value) {
		this.txdt = value;
	}
	
	public java.lang.String getTxdt() {
		return this.txdt;
	}
	public void setCheckdt(java.lang.String value) {
		this.checkdt = value;
	}
	
	public java.lang.String getCheckdt() {
		return this.checkdt;
	}
	public void setOpno(java.lang.String value) {
		this.opno = value;
	}
	
	public java.lang.String getOpno() {
		return this.opno;
	}
	public void setPrftyp(java.lang.String value) {
		this.prftyp = value;
	}
	
	public java.lang.String getPrftyp() {
		return this.prftyp;
	}
	public void setPrfno(java.lang.String value) {
		this.prfno = value;
	}
	
	public java.lang.String getPrfno() {
		return this.prfno;
	}
	public void setDptno(java.lang.String value) {
		this.dptno = value;
	}
	
	public java.lang.String getDptno() {
		return this.dptno;
	}
	public void setStt(java.lang.String value) {
		this.stt = value;
	}
	
	public java.lang.String getStt() {
		return this.stt;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Prftrcno",getPrftrcno())
			.append("Txdt",getTxdt())
			.append("Checkdt",getCheckdt())
			.append("Opno",getOpno())
			.append("Prftyp",getPrftyp())
			.append("Prfno",getPrfno())
			.append("Dptno",getDptno())
			.append("Stt",getStt())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getPrftrcno())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof FnncPrfbs == false) return false;
		if(this == obj) return true;
		FnncPrfbs other = (FnncPrfbs)obj;
		return new EqualsBuilder()
			.append(getPrftrcno(),other.getPrftrcno())
			.isEquals();
	}
}

