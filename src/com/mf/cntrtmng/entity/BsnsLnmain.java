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
 * @2015-01-21
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class BsnsLnmain extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "业务主信息表";
	public static final String ALIAS_BSNSNO = "业务编号（同借据号）";
	public static final String ALIAS_BSNSID = "自增编号";
	public static final String ALIAS_DEPNO = "开办部门";
	public static final String ALIAS_LNBLNC = "贷款余额";
	public static final String ALIAS_CRRNTAMNT = "发放金额";
	public static final String ALIAS_INTSTSDATE = "实际放款日期（计息起始日）";
	public static final String ALIAS_INTSTEDATE = "预计结束日期";
	public static final String ALIAS_UPDTDATE = "最近更新日期";
	public static final String ALIAS_ACCNTSTT = "账户状态";
	public static final String ALIAS_FVCLSSTT = "五级分类状态";
	public static final String ALIAS_CLNTNO = "客户编号";
	public static final String ALIAS_CLNTNM = "客户名称";
	public static final String ALIAS_CNTRCTNO = "合同编号";
	public static final String ALIAS_LNTMDY = "合同期间（天）";
	public static final String ALIAS_CURBLLDATE = "当前账单日期";
	public static final String ALIAS_NXTBLLDATE = "下一账单日期";
	public static final String ALIAS_BSNSFLG = "业务标识";
	public static final String ALIAS_ISFIXREPAY = "是否固定还款日";
	public static final String ALIAS_BNKNO = "银行账户";
	public static final String ALIAS_OUTYP = "放款类型";
	public static final String ALIAS_FIXDATE = "固定还款日";
	
	//date formats
	
	public BsnsLnmain(){
	}

	public BsnsLnmain(
		java.lang.Integer bsnsid
	){
		this.bsnsid = bsnsid;
	}

	
	//columns START
	/**业务编号（同借据号）==>db_column: BSNSNO*/
	private java.lang.String bsnsno;
	/**自增编号==>db_column: BSNSID*/
	private java.lang.Integer bsnsid;
	/**开办部门==>db_column: DEPNO*/
	private java.lang.String depno;
	/**贷款余额==>db_column: LNBLNC*/
	private BigDecimal lnblnc;
	/**发放金额==>db_column: CRRNTAMNT*/
	private BigDecimal crrntamnt;
	/**实际放款日期（计息起始日）==>db_column: INTSTSDATE*/
	private java.lang.String intstsdate;
	/**预计结束日期==>db_column: INTSTEDATE*/
	private java.lang.String intstedate;
	/**最近更新日期==>db_column: UPDTDATE*/
	private java.lang.String updtdate;
	/**账户状态==>db_column: ACCNTSTT*/
	private java.lang.String accntstt;
	/**五级分类状态==>db_column: FVCLSSTT*/
	private java.lang.String fvclsstt;
	/**客户编号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**客户名称==>db_column: CLNTNM*/
	private java.lang.String clntnm;
	/**合同编号==>db_column: CNTRCTNO*/
	private java.lang.String cntrctno;
	/**合同期间（天）==>db_column: LNTMDY*/
	private java.lang.String lntmdy;
	/**当前账单日期==>db_column: CURBLLDATE*/
	private java.lang.String curblldate;
	/**下一账单日期==>db_column: NXTBLLDATE*/
	private java.lang.String nxtblldate;
	/**业务标识==>db_column: BSNSFLG*/
	private java.lang.String bsnsflg;
	/**是否固定还款日==>db_column: ISFIXREPAY*/
	private java.lang.String isfixrepay;
	/**银行账户==>db_column: BNKNO*/
	private java.lang.String bnkno;
	/**放款类型==>db_column: OUTYP*/
	private java.lang.String outyp;
	/**固定还款日==>db_column: FIXDATE*/
	private java.lang.String fixdate;
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

	public void setBsnsno(java.lang.String value) {
		this.bsnsno = value;
	}
	
	public java.lang.String getBsnsno() {
		return this.bsnsno;
	}
	public void setBsnsid(java.lang.Integer value) {
		this.bsnsid = value;
	}
	
	public java.lang.Integer getBsnsid() {
		return this.bsnsid;
	}
	public void setDepno(java.lang.String value) {
		this.depno = value;
	}
	
	public java.lang.String getDepno() {
		return this.depno;
	}
	
	public BigDecimal getLnblnc() {
		return lnblnc;
	}

	public void setLnblnc(BigDecimal lnblnc) {
		this.lnblnc = lnblnc;
	}

	public BigDecimal getCrrntamnt() {
		return crrntamnt;
	}

	public void setCrrntamnt(BigDecimal crrntamnt) {
		this.crrntamnt = crrntamnt;
	}

	public void setIntstsdate(java.lang.String value) {
		this.intstsdate = value;
	}
	
	public java.lang.String getIntstsdate() {
		return this.intstsdate;
	}
	public void setIntstedate(java.lang.String value) {
		this.intstedate = value;
	}
	
	public java.lang.String getIntstedate() {
		return this.intstedate;
	}
	public void setUpdtdate(java.lang.String value) {
		this.updtdate = value;
	}
	
	public java.lang.String getUpdtdate() {
		return this.updtdate;
	}
	public void setAccntstt(java.lang.String value) {
		this.accntstt = value;
	}
	
	public java.lang.String getAccntstt() {
		return this.accntstt;
	}
	public void setFvclsstt(java.lang.String value) {
		this.fvclsstt = value;
	}
	
	public java.lang.String getFvclsstt() {
		return this.fvclsstt;
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
	public void setCntrctno(java.lang.String value) {
		this.cntrctno = value;
	}
	
	public java.lang.String getCntrctno() {
		return this.cntrctno;
	}
	public void setLntmdy(java.lang.String value) {
		this.lntmdy = value;
	}
	
	public java.lang.String getLntmdy() {
		return this.lntmdy;
	}
	public void setCurblldate(java.lang.String value) {
		this.curblldate = value;
	}
	
	public java.lang.String getCurblldate() {
		return this.curblldate;
	}
	public void setNxtblldate(java.lang.String value) {
		this.nxtblldate = value;
	}
	
	public java.lang.String getNxtblldate() {
		return this.nxtblldate;
	}
	public void setBsnsflg(java.lang.String value) {
		this.bsnsflg = value;
	}
	
	public java.lang.String getBsnsflg() {
		return this.bsnsflg;
	}
	public void setIsfixrepay(java.lang.String value) {
		this.isfixrepay = value;
	}
	
	public java.lang.String getIsfixrepay() {
		return this.isfixrepay;
	}
	public void setBnkno(java.lang.String value) {
		this.bnkno = value;
	}
	
	public java.lang.String getBnkno() {
		return this.bnkno;
	}
	public void setOutyp(java.lang.String value) {
		this.outyp = value;
	}
	
	public java.lang.String getOutyp() {
		return this.outyp;
	}
	public void setFixdate(java.lang.String value) {
		this.fixdate = value;
	}
	
	public java.lang.String getFixdate() {
		return this.fixdate;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Bsnsno",getBsnsno())
			.append("Bsnsid",getBsnsid())
			.append("Depno",getDepno())
			.append("Lnblnc",getLnblnc())
			.append("Crrntamnt",getCrrntamnt())
			.append("Intstsdate",getIntstsdate())
			.append("Intstedate",getIntstedate())
			.append("Updtdate",getUpdtdate())
			.append("Accntstt",getAccntstt())
			.append("Fvclsstt",getFvclsstt())
			.append("Clntno",getClntno())
			.append("Clntnm",getClntnm())
			.append("Cntrctno",getCntrctno())
			.append("Lntmdy",getLntmdy())
			.append("Curblldate",getCurblldate())
			.append("Nxtblldate",getNxtblldate())
			.append("Bsnsflg",getBsnsflg())
			.append("Isfixrepay",getIsfixrepay())
			.append("Bnkno",getBnkno())
			.append("Outyp",getOutyp())
			.append("Fixdate",getFixdate())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getBsnsid())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BsnsLnmain == false) return false;
		if(this == obj) return true;
		BsnsLnmain other = (BsnsLnmain)obj;
		return new EqualsBuilder()
			.append(getBsnsid(),other.getBsnsid())
			.isEquals();
	}
}

