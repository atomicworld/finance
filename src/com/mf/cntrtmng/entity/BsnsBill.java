/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.cntrtmng.entity;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.mf.base.BaseEntity;

/**
 * @author xujiuhua
 * @2015-01-13
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class BsnsBill extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "借据信息表";
	public static final String ALIAS_DUENO = "借据编号";
	public static final String ALIAS_OUTNO = "放款编号";
	public static final String ALIAS_CNTRCTNO = "合同编号";
	public static final String ALIAS_APPLYNO = "业务申请编号";
	public static final String ALIAS_OCCRDATE = "发生日期";
	public static final String ALIAS_CLNTNO = "客户编号";
	public static final String ALIAS_CLNTNM = "客户姓名";
	public static final String ALIAS_DUEAMNT = "借据金额";
	public static final String ALIAS_OUTDATE = "放款日期";
	public static final String ALIAS_MTRTYDATE = "到期日期";
	public static final String ALIAS_RLEDATE = "实际完结日期";
	public static final String ALIAS_EXTNO = "展期编号";
	public static final String ALIAS_DLFLG = "处理标志";
	public static final String ALIAS_LNAMNT = "贷款金额";
	public static final String ALIAS_OTHRAMNT = "其他金额";
	public static final String ALIAS_REGDATE = "操作日期";
	public static final String ALIAS_UPDTDATE = "更新日期";
	public static final String ALIAS_CLSSFLG = "五级分类标志";
	public static final String ALIAS_OUTFLG = "放款标志标志";
	public static final String ALIAS_RECFLG = "还款标志标志";
	
	//date formats
	
	public BsnsBill(){
	}

	public BsnsBill(
		java.lang.String dueno
	){
		this.dueno = dueno;
	}

	
	//columns START
	/**借据编号==>db_column: DUENO*/
	private java.lang.String dueno;
	/**放款编号==>db_column: OUTNO*/
	private java.lang.String outno;
	/**合同编号==>db_column: CNTRCTNO*/
	private java.lang.String cntrctno;
	/**业务申请编号==>db_column: APPLYNO*/
	private java.lang.String applyno;
	/**发生日期==>db_column: OCCRDATE*/
	private java.lang.String occrdate;
	/**客户编号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**客户姓名==>db_column: CLNTNM*/
	private java.lang.String clntnm;
	/**借据金额==>db_column: DUEAMNT*/
	private BigDecimal dueamnt;
	/**放款日期==>db_column: OUTDATE*/
	private java.lang.String outdate;
	/**到期日期==>db_column: MTRTYDATE*/
	private java.lang.String mtrtydate;
	/**实际完结日期==>db_column: RLEDATE*/
	private java.lang.String rledate;
	/**展期编号==>db_column: EXTNO*/
	private java.lang.String extno;
	/**处理标志==>db_column: DLFLG*/
	private java.lang.String dlflg;
	/**贷款金额==>db_column: LNAMNT*/
	private BigDecimal lnamnt;
	/**其他金额==>db_column: OTHRAMNT*/
	private BigDecimal othramnt;
	/**操作日期==>db_column: REGDATE*/
	private java.lang.String regdate;
	/**更新日期==>db_column: UPDTDATE*/
	private java.lang.String updtdate;
	/**五级分类标志==>db_column: CLSSFLG*/
	private java.lang.String clssflg;
	/**放款标志标志==>db_column: CLSSFLG*/
	private java.lang.String outflg;
	/**还款标志标志==>db_column: CLSSFLG*/
	private java.lang.String recflg;
	/**最近日期==>db_column: SDATE*/
	private java.lang.String sdate;
	
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

	public void setDueno(java.lang.String value) {
		this.dueno = value;
	}
	
	public java.lang.String getDueno() {
		return this.dueno;
	}
	public void setOutno(java.lang.String value) {
		this.outno = value;
	}
	
	public java.lang.String getOutno() {
		return this.outno;
	}
	public void setCntrctno(java.lang.String value) {
		this.cntrctno = value;
	}
	
	public java.lang.String getCntrctno() {
		return this.cntrctno;
	}
	public void setApplyno(java.lang.String value) {
		this.applyno = value;
	}
	
	public java.lang.String getApplyno() {
		return this.applyno;
	}
	public void setOccrdate(java.lang.String value) {
		this.occrdate = value;
	}
	
	public java.lang.String getOccrdate() {
		return this.occrdate;
	}
	public void setClntno(java.lang.String value) {
		this.clntno = value;
	}
	
	public java.lang.String getClntno() {
		return this.clntno;
	}
	public void setClntnm(java.lang.String value) {
		this.clntnm = value;
	}
	
	public java.lang.String getClntnm() {
		return this.clntnm;
	}
	
	public void setOutdate(java.lang.String value) {
		this.outdate = value;
	}
	
	public java.lang.String getOutdate() {
		return this.outdate;
	}
	public void setMtrtydate(java.lang.String value) {
		this.mtrtydate = value;
	}
	
	public java.lang.String getMtrtydate() {
		return this.mtrtydate;
	}
	public void setRledate(java.lang.String value) {
		this.rledate = value;
	}
	
	public java.lang.String getRledate() {
		return this.rledate;
	}
	public void setExtno(java.lang.String value) {
		this.extno = value;
	}
	
	public java.lang.String getExtno() {
		return this.extno;
	}
	public void setDlflg(java.lang.String value) {
		this.dlflg = value;
	}
	
	public java.lang.String getDlflg() {
		return this.dlflg;
	}
	
	
	public void setRegdate(java.lang.String value) {
		this.regdate = value;
	}
	
	public java.lang.String getRegdate() {
		return this.regdate;
	}
	public void setUpdtdate(java.lang.String value) {
		this.updtdate = value;
	}
	
	public java.lang.String getUpdtdate() {
		return this.updtdate;
	}
	public void setClssflg(java.lang.String value) {
		this.clssflg = value;
	}
	
	public java.lang.String getClssflg() {
		return this.clssflg;
	}
	public java.lang.String getSdate() {
		return sdate;
	}

	public void setSdate(java.lang.String sdate) {
		this.sdate = sdate;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Dueno",getDueno())
			.append("Outno",getOutno())
			.append("Cntrctno",getCntrctno())
			.append("Applyno",getApplyno())
			.append("Occrdate",getOccrdate())
			.append("Clntno",getClntno())
			.append("Clntnm",getClntnm())
			.append("Dueamnt",getDueamnt())
			.append("Outdate",getOutdate())
			.append("Mtrtydate",getMtrtydate())
			.append("Rledate",getRledate())
			.append("Extno",getExtno())
			.append("Dlflg",getDlflg())
			.append("Lnamnt",getLnamnt())
			.append("Othramnt",getOthramnt())
			.append("Regdate",getRegdate())
			.append("Updtdate",getUpdtdate())
			.append("Clssflg",getClssflg())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getDueno())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BsnsBill == false) return false;
		if(this == obj) return true;
		BsnsBill other = (BsnsBill)obj;
		return new EqualsBuilder()
			.append(getDueno(),other.getDueno())
			.isEquals();
	}

	public BigDecimal getDueamnt() {
		return dueamnt;
	}

	public void setDueamnt(BigDecimal dueamnt) {
		this.dueamnt = dueamnt;
	}

	public BigDecimal getLnamnt() {
		return lnamnt;
	}

	public void setLnamnt(BigDecimal lnamnt) {
		this.lnamnt = lnamnt;
	}

	public BigDecimal getOthramnt() {
		return othramnt;
	}

	public void setOthramnt(BigDecimal othramnt) {
		this.othramnt = othramnt;
	}

	public void setOutflg(java.lang.String outflg) {
		this.outflg = outflg;
	}

	public java.lang.String getOutflg() {
		return outflg;
	}

	public void setRecflg(java.lang.String recflg) {
		this.recflg = recflg;
	}

	public java.lang.String getRecflg() {
		return recflg;
	}
}

