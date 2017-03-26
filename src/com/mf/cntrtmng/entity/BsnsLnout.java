package com.mf.cntrtmng.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.mf.base.BaseEntity;
import com.mf.cntrtmng.entity.*;
import com.mf.common.util.*;

import java.math.BigDecimal;

public class BsnsLnout extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "BSNS_LNOUT";
	public static final String ALIAS_OUTNO = "放款编号";
	public static final String ALIAS_CNTRCTNO = "合同编号";
	public static final String ALIAS_APPLYNO = "业务申请编号";
	public static final String ALIAS_CLNTNO = "客户编号";
	public static final String ALIAS_CLNTNM = "客户姓名";
	public static final String ALIAS_DPTNO = "开办部门编号";
	public static final String ALIAS_KNDNO = "业务种类编号";
	public static final String ALIAS_OUTDATE = "放款日期";
	public static final String ALIAS_CNTRCTEDATE = "合同结束日期";
	public static final String ALIAS_OUTAMNT = "放款金额";
	public static final String ALIAS_CURRNCY = "币种";
	public static final String ALIAS_LNRT = "贷款利率";
	public static final String ALIAS_BSNSRT = "执行利率";
	public static final String ALIAS_CNTRCTAMNT = "合同金额";
	public static final String ALIAS_SRLNO = "流水号";
	public static final String ALIAS_OVRFLTPRCNT = "逾期利率浮动";
	public static final String ALIAS_FNFLTPRCNT = "罚息利率浮动";
	public static final String ALIAS_OUTSTT = "放款申请状态";
	public static final String ALIAS_REGDPTNO = "登记部门编号";
	public static final String ALIAS_REGOPNO = "操作员编号";
	public static final String ALIAS_REGDATE = "登记日期";
	public static final String ALIAS_UPDTDATE = "更新日期";
	public static final String ALIAS_REMARK = "备注";
	
	//date formats
	
	public BsnsLnout(){
	}

	public BsnsLnout(java.lang.String outno){
		this.outno = outno;
	}

	
	//columns START
	/**放款编号==>db_column: OUTNO*/
	private java.lang.String outno;
	/**合同编号==>db_column: CNTRCTNO*/
	private java.lang.String cntrctno;
	/**业务申请编号==>db_column: APPLYNO*/
	private java.lang.String applyno;
	/**客户编号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**客户姓名==>db_column: CLNTNM*/
	private java.lang.String clntnm;
	/**开办部门编号==>db_column: DPTNO*/
	private java.lang.String dptno;
	/**业务种类编号==>db_column: KNDNO*/
	private java.lang.String kndno;
	/**放款日期==>db_column: OUTDATE*/
	private java.lang.String outdate;
	/**合同结束日期==>db_column: CNTRCTEDATE*/
	private java.lang.String cntrctedate;
	/**放款金额==>db_column: OUTAMNT*/
	private BigDecimal outamnt;
	/**币种==>db_column: CURRNCY*/
	private java.lang.String currncy;
	/**贷款利率==>db_column: LNRT*/
	private BigDecimal lnrt;
	/**执行利率==>db_column: BSNSRT*/
	private BigDecimal bsnsrt;
	/**合同金额==>db_column: CNTRCTAMNT*/
	private BigDecimal cntrctamnt;
	/**流水号==>db_column: SRLNO*/
	private java.lang.String srlno;
	/**逾期利率浮动==>db_column: OVRFLTPRCNT*/
	private BigDecimal ovrfltprcnt;
	/**罚息利率浮动==>db_column: FNFLTPRCNT*/
	private BigDecimal fnfltprcnt;
	/**放款申请状态==>db_column: OUTSTT*/
	private java.lang.String outstt;
	/**登记部门编号==>db_column: REGDPTNO*/
	private java.lang.String regdptno;
	/**操作员编号==>db_column: REGOPNO*/
	private java.lang.String regopno;
	/**登记日期==>db_column: REGDATE*/
	private java.lang.String regdate;
	/**更新日期==>db_column: UPDTDATE*/
	private java.lang.String updtdate;
	/**备注==>db_column: REMARK*/
	private java.lang.String remark;
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
	public void setDptno(java.lang.String value) {
		this.dptno = value;
	}
	
	public java.lang.String getDptno() {
		return this.dptno;
	}
	public void setKndno(java.lang.String value) {
		this.kndno = value;
	}
	
	public java.lang.String getKndno() {
		return this.kndno;
	}
	public void setOutdate(java.lang.String value) {
		this.outdate = value;
	}
	
	public java.lang.String getOutdate() {
		return this.outdate;
	}
	public void setCntrctedate(java.lang.String value) {
		this.cntrctedate = value;
	}
	
	public java.lang.String getCntrctedate() {
		return this.cntrctedate;
	}
	public void setOutamnt(BigDecimal value) {
		this.outamnt = value;
	}
	
	public BigDecimal getOutamnt() {
		return this.outamnt;
	}
	public void setCurrncy(java.lang.String value) {
		this.currncy = value;
	}
	
	public java.lang.String getCurrncy() {
		return this.currncy;
	}
	public void setLnrt(BigDecimal value) {
		this.lnrt = value;
	}
	
	public BigDecimal getLnrt() {
		return this.lnrt;
	}
	public void setBsnsrt(BigDecimal value) {
		this.bsnsrt = value;
	}
	
	public BigDecimal getBsnsrt() {
		return this.bsnsrt;
	}
	public void setCntrctamnt(BigDecimal value) {
		this.cntrctamnt = value;
	}
	
	public BigDecimal getCntrctamnt() {
		return this.cntrctamnt;
	}
	public void setSrlno(java.lang.String value) {
		this.srlno = value;
	}
	
	public java.lang.String getSrlno() {
		return this.srlno;
	}
	public void setOvrfltprcnt(BigDecimal value) {
		this.ovrfltprcnt = value;
	}
	
	public BigDecimal getOvrfltprcnt() {
		return this.ovrfltprcnt;
	}
	public void setFnfltprcnt(BigDecimal value) {
		this.fnfltprcnt = value;
	}
	
	public BigDecimal getFnfltprcnt() {
		return this.fnfltprcnt;
	}
	public void setOutstt(java.lang.String value) {
		this.outstt = value;
	}
	
	public java.lang.String getOutstt() {
		return this.outstt;
	}
	public void setRegdptno(java.lang.String value) {
		this.regdptno = value;
	}
	
	public java.lang.String getRegdptno() {
		return this.regdptno;
	}
	public void setRegopno(java.lang.String value) {
		this.regopno = value;
	}
	
	public java.lang.String getRegopno() {
		return this.regopno;
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
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Outno",getOutno())
			.append("Cntrctno",getCntrctno())
			.append("Applyno",getApplyno())
			.append("Clntno",getClntno())
			.append("Clntnm",getClntnm())
			.append("Dptno",getDptno())
			.append("Kndno",getKndno())
			.append("Outdate",getOutdate())
			.append("Cntrctedate",getCntrctedate())
			.append("Outamnt",getOutamnt())
			.append("Currncy",getCurrncy())
			.append("Lnrt",getLnrt())
			.append("Bsnsrt",getBsnsrt())
			.append("Cntrctamnt",getCntrctamnt())
			.append("Srlno",getSrlno())
			.append("Ovrfltprcnt",getOvrfltprcnt())
			.append("Fnfltprcnt",getFnfltprcnt())
			.append("Outstt",getOutstt())
			.append("Regdptno",getRegdptno())
			.append("Regopno",getRegopno())
			.append("Regdate",getRegdate())
			.append("Updtdate",getUpdtdate())
			.append("Remark",getRemark())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BsnsLnout == false) return false;
		if(this == obj) return true;
		BsnsLnout other = (BsnsLnout)obj;
		return new EqualsBuilder()
			.isEquals();
	}
}

