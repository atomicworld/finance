/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.cntrtmng.entity;

import java.math.BigDecimal;

import com.mf.base.BaseEntity;

/**
 * @author wangyw
 * @2015-08-12
 * @version 1.0
 * @param <T>
 */

public class BsnsExtend extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "BsnsExtend";
	public static final String ALIAS_EXTENDNO = "展期编号";
	public static final String ALIAS_BSNSNO = "借据编号";
	public static final String ALIAS_CNTRCTNO = "合同编号";
	public static final String ALIAS_RATE = "展期利率";
	public static final String ALIAS_NUM = "展期次数";
	public static final String ALIAS_TRMYR = "期限年";
	public static final String ALIAS_TRMMNTH = "期限月";
	public static final String ALIAS_TRMDAY = "期限日";
	
	
	//columns START
	/**展期编号==>db_column: EXTENDNO*/
	private java.lang.String extendno;
	/**借据编号==>db_column: BSNSNO*/
	private java.lang.String bsnsno;
	/**合同编号==>db_column: CNTRCTNO*/
	private java.lang.String cntrctno;
	/**展期利率==>db_column: RATE*/
	private BigDecimal rate;
	/**展期次数==>db_column: NUM*/
	private java.lang.String num;
	/**期限年==>db_column: TRMYR*/
	private Integer trmyr;
	/**期限月==>db_column: TRMMNTH*/
	private Integer trmmnth;
	/**期限日==>db_column: TRMDAY*/
	private Integer trmday;
	//columns END
	
	private BigDecimal whbj;
	private java.lang.String extendsdate;
	private java.lang.String extendedate;
	
	private java.lang.String applydate;
	//系统框架字段 start
	
	public java.lang.String getApplydate() {
		return applydate;
	}

	public void setApplydate(java.lang.String applydate) {
		this.applydate = applydate;
	}

	public BigDecimal getWhbj() {
		return whbj;
	}

	public void setWhbj(BigDecimal whbj) {
		this.whbj = whbj;
	}

	public java.lang.String getExtendsdate() {
		return extendsdate;
	}

	public void setExtendsdate(java.lang.String extendsdate) {
		this.extendsdate = extendsdate;
	}

	public java.lang.String getExtendedate() {
		return extendedate;
	}

	public void setExtendedate(java.lang.String extendedate) {
		this.extendedate = extendedate;
	}

	//系统框架字段 end

	public void setExtendno(java.lang.String value) {
		this.extendno = value;
	}
	
	public java.lang.String getExtendno() {
		return this.extendno;
	}
	public void setBsnsno(java.lang.String value) {
		this.bsnsno = value;
	}
	
	public java.lang.String getBsnsno() {
		return this.bsnsno;
	}
	public void setCntrctno(java.lang.String value) {
		this.cntrctno = value;
	}
	
	public java.lang.String getCntrctno() {
		return this.cntrctno;
	}
	
	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public void setNum(java.lang.String value) {
		this.num = value;
	}
	
	public java.lang.String getNum() {
		return this.num;
	}
	
	public void setTrmyr(Integer value) {
		this.trmyr = value;
	}
	
	public Integer getTrmyr() {
		return this.trmyr;
	}
	public void setTrmmnth(Integer value) {
		this.trmmnth = value;
	}
	
	public Integer getTrmmnth() {
		return this.trmmnth;
	}
	public void setTrmday(Integer value) {
		this.trmday = value;
	}
	
	public Integer getTrmday() {
		return this.trmday;
	}

}

