/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.entity;

import java.math.BigDecimal;

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

public class FnncChckprfdtl extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "复核凭证详情表";
	public static final String ALIAS_PRFCRTDT = "原始凭证生成日期";
	public static final String ALIAS_CHCKTRCNO = "复核流水号";
	public static final String ALIAS_SQNNO = "顺序号";
	public static final String ALIAS_DPTNO = "部门编号";
	public static final String ALIAS_CURRNCY = "币种";
	public static final String ALIAS_ACCNTNO = "科目编号";
	public static final String ALIAS_JDFLG = "借贷标识";
	public static final String ALIAS_CHCKPRFTYP = "凭证类型";
	public static final String ALIAS_AMNT = "发生金额";
	public static final String ALIAS_OPNO = "操作员编号";
	public static final String ALIAS_STT = "状态";
	
	//date formats
	
	public FnncChckprfdtl(){
	}


	
	//columns START
	/**原始凭证生成日期==>db_column: PRFCRTDT*/
	private java.lang.String prfcrtdt;
	/**复核流水号==>db_column: CHCKTRCNO*/
	private java.lang.String chcktrcno;
	/**顺序号==>db_column: SQNNO*/
	private java.lang.String sqnno;
	/**部门编号==>db_column: DPTNO*/
	private java.lang.String dptno;
	/**币种==>db_column: CURRNCY*/
	private java.lang.String currncy;
	/**科目编号==>db_column: ACCNTNO*/
	private java.lang.String accntno;
	/**借贷标识==>db_column: JDFLG*/
	private java.lang.String jdflg;
	/**凭证类型==>db_column: CHCKPRFTYP*/
	private java.lang.String chckprftyp;
	/**发生金额==>db_column: AMNT*/
	private BigDecimal amnt;
	/**操作员编号==>db_column: OPNO*/
	private java.lang.String opno;
	/**状态==>db_column: STT*/
	private java.lang.String stt;
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

	public void setPrfcrtdt(java.lang.String value) {
		this.prfcrtdt = value;
	}
	
	public java.lang.String getPrfcrtdt() {
		return this.prfcrtdt;
	}
	public void setChcktrcno(java.lang.String value) {
		this.chcktrcno = value;
	}
	
	public java.lang.String getChcktrcno() {
		return this.chcktrcno;
	}
	public void setSqnno(java.lang.String value) {
		this.sqnno = value;
	}
	
	public java.lang.String getSqnno() {
		return this.sqnno;
	}
	public void setDptno(java.lang.String value) {
		this.dptno = value;
	}
	
	public java.lang.String getDptno() {
		return this.dptno;
	}
	public void setCurrncy(java.lang.String value) {
		this.currncy = value;
	}
	
	public java.lang.String getCurrncy() {
		return this.currncy;
	}
	
	public java.lang.String getAccntno() {
		return accntno;
	}

	public void setAccntno(java.lang.String accntno) {
		this.accntno = accntno;
	}

	public void setJdflg(java.lang.String value) {
		this.jdflg = value;
	}
	
	public java.lang.String getJdflg() {
		return this.jdflg;
	}
	public void setChckprftyp(java.lang.String value) {
		this.chckprftyp = value;
	}
	
	public java.lang.String getChckprftyp() {
		return this.chckprftyp;
	}
	public void setAmnt(BigDecimal value) {
		this.amnt = value;
	}
	
	public BigDecimal getAmnt() {
		return this.amnt;
	}
	public void setOpno(java.lang.String value) {
		this.opno = value;
	}
	
	public java.lang.String getOpno() {
		return this.opno;
	}
	public void setStt(java.lang.String value) {
		this.stt = value;
	}
	
	public java.lang.String getStt() {
		return this.stt;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Prfcrtdt",getPrfcrtdt())
			.append("Chcktrcno",getChcktrcno())
			.append("Sqnno",getSqnno())
			.append("Dptno",getDptno())
			.append("Currncy",getCurrncy())
			.append("Accntctlno",getAccntno())
			.append("Jdflg",getJdflg())
			.append("Chckprftyp",getChckprftyp())
			.append("Amnt",getAmnt())
			.append("Opno",getOpno())
			.append("Stt",getStt())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof FnncChckprfdtl == false) return false;
		if(this == obj) return true;
		FnncChckprfdtl other = (FnncChckprfdtl)obj;
		return new EqualsBuilder()
			.isEquals();
	}
}

