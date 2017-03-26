/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.bsnsmng.entity;

import java.math.BigDecimal;




/**
 * @author shengd
 * @2014-12-23
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class BsnsApply {
	private static final long serialVersionUID = 5454155825314635342L;
	
	

	
	//columns START
	/**客户姓名==>db_column: CLNTNM*/
	private java.lang.String clntnm;
	/**企业法人==>db_column: ENTLGLNM*/
	private java.lang.String entlglnm;
	/**业务种类编号==>db_column: KNDNO*/
	private java.lang.String kndno;
	/**期限种类==>db_column: TERMTYP*/
	private java.lang.String termtyp;
	/**发生类型==>db_column: BSNSTYP*/
	private java.lang.String bsnstyp;
	/**币种==>db_column: CURRNCY*/
	private java.lang.String currncy;
	/**申请金额==>db_column: APPLYAMNT*/
	private BigDecimal applyamnt;
	/**期限年==>db_column: TRMYR*/
	private Integer trmyr;
	/**期限月==>db_column: TRMMNTH*/
	private Integer trmmnth;
	/**期限日==>db_column: TRMDAY*/
	private Integer trmday;
	/**基准利率类型==>db_column: BSRTYP*/
	private java.lang.String bsrtyp;
	/**基准利率==>db_column: BASERT*/
	private BigDecimal basert;
	/**申请利率浮动百分比==>db_column: RTFLTPRCNT*/
	private BigDecimal rtfltprcnt;
	/**申请利率==>db_column: APPLYRT*/
	private BigDecimal applyrt;
	/**贷款用途编号==>db_column: USENO*/
	private java.lang.String useno;
	/**计息方式==>db_column: INTRSTMD*/
	private java.lang.String intrstmd;
	/**还款方式==>db_column: RPMNTWAY*/
	private java.lang.String rpmntway;
	/**主担保方式==>db_column: GRTWAY*/
	private java.lang.String grtway;
	/**具体担保类型==>db_column: GRTWAYDTL*/
	private java.lang.String grtwaydtl;
	/**审批状态位==>db_column: APPRVLSTT*/
	private java.lang.String apprvlstt;
	/**申请贷款总额==>db_column: BSNSBALTTL*/
	private BigDecimal bsnsbalttl;
	/**本公司贷款==>db_column: THSBAL*/
	private BigDecimal thsbal;
	/**其他公司贷款==>db_column: OTHRBAL*/
	private BigDecimal othrbal;
	/**为他人担保贷款额度==>db_column: GRTFOROTHR*/
	private BigDecimal grtforothr;
	/**客户经理名称==>db_column: BSNSOPNM*/
	private java.lang.String bsnsopnm;
	/**管户机构编号==>db_column: MNGDPTNO*/
	private java.lang.String mngdptno;
	/**客户经理号==>db_column: BSNSOPNO*/
	private java.lang.String bsnsopno;
	/**登记单位==>db_column: REGDPTNO*/
	private java.lang.String regdptno;
	/**登记人编号==>db_column: REGOPNO*/
	private java.lang.String regopno;
	/**登记日期==>db_column: REGDATE*/
	private java.lang.String regdate;
	/**备注==>db_column: REMARK*/
	private java.lang.String remark;
	/**投向分类==>db_column: TOINDSTRY*/
	private java.lang.String toindstry;
	/**用途说明==>db_column: USEDES*/
	private java.lang.String usedes;
	/**合同类型==>db_column: PCTYP*/
	private java.lang.String pctyp;
	/**抵押高额合同编号==>db_column: HIGHPCTNO*/
	private java.lang.String highpctno;
	/**是否使用高额担保合同==>db_column: ISHIGH*/
	private java.lang.String ishigh;
	/**基准利率编号==>db_column: BSRTNO*/
	private java.lang.String bsrtno;
	/**逾期利率浮动百分比==>db_column: OVRFLTPRCNT*/
	private java.lang.String ovrfltprcnt;
	/**罚息利率浮动百分比==>db_column: FNFLTPRCNT*/
	private java.lang.String fnfltprcnt;
	/**复利利率浮动百分比==>db_column: CMPDFLTPRCNT*/
	private java.lang.String cmpdfltprcnt;
	/**利率类型==>db_column: RTYP*/
	private java.lang.String rtyp;
	/**银行账号==>db_column: BNKNO*/
	private java.lang.String bnkno;
	/**开户银行名称==>db_column: BNKNM*/
	private java.lang.String bnknm;
	/**固定利息提前收取==>db_column: ISFXINSTPRE*/
	private java.lang.String isfxinstpre;
	/**固定利息金额==>db_column: FXINSTAMNT*/
	private java.lang.String fxinstamnt;
	/**咨询费==>db_column: CNSLTAMNT*/
	private java.lang.String cnsltamnt;
	/**保留字段==>db_column: RESERVED*/
	private java.lang.String reserved;
	/**applyno==>db_column: APPLYNO*/
	private java.lang.String applyno;
	/**clntno==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**贷款对象规模==>db_column: CustScale*/
	private java.lang.Integer custScale;
	/**争议解决方式==>db_column: SolutionWay*/
	private java.lang.Integer solutionWay;
	/**贷款对象==>db_column: LoanerType*/
	private java.lang.Integer loanerType;
	/**贷款用途==>db_column: LoanUsage*/
	private java.lang.Integer loanUsage;
	/**投放区域==>db_column: LoanArea*/
	private java.lang.Integer loanArea;
	/**是否同城化==>db_column: IsTCH*/
	private java.lang.Integer isTch;
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

	public void setClntnm(java.lang.String value) {
		this.clntnm = value;
	}
	
	public java.lang.String getClntnm() {
		return this.clntnm;
	}
	public void setEntlglnm(java.lang.String value) {
		this.entlglnm = value;
	}
	
	public java.lang.String getEntlglnm() {
		return this.entlglnm;
	}
	public void setKndno(java.lang.String value) {
		this.kndno = value;
	}
	
	public java.lang.String getKndno() {
		return this.kndno;
	}
	public void setTermtyp(java.lang.String value) {
		this.termtyp = value;
	}
	
	public java.lang.String getTermtyp() {
		return this.termtyp;
	}
	public void setBsnstyp(java.lang.String value) {
		this.bsnstyp = value;
	}
	
	public java.lang.String getBsnstyp() {
		return this.bsnstyp;
	}
	public void setCurrncy(java.lang.String value) {
		this.currncy = value;
	}
	
	public java.lang.String getCurrncy() {
		return this.currncy;
	}
	public void setApplyamnt(BigDecimal value) {
		this.applyamnt = value;
	}
	
	public BigDecimal getApplyamnt() {
		return this.applyamnt;
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
	public void setBsrtyp(java.lang.String value) {
		this.bsrtyp = value;
	}
	
	public java.lang.String getBsrtyp() {
		return this.bsrtyp;
	}
	public void setBasert(BigDecimal value) {
		this.basert = value;
	}
	
	public BigDecimal getBasert() {
		return this.basert;
	}
	public void setRtfltprcnt(BigDecimal value) {
		this.rtfltprcnt = value;
	}
	
	public BigDecimal getRtfltprcnt() {
		return this.rtfltprcnt;
	}
	public void setApplyrt(BigDecimal value) {
		this.applyrt = value;
	}
	
	public BigDecimal getApplyrt() {
		return this.applyrt;
	}
	public void setUseno(java.lang.String value) {
		this.useno = value;
	}
	
	public java.lang.String getUseno() {
		return this.useno;
	}
	public void setIntrstmd(java.lang.String value) {
		this.intrstmd = value;
	}
	
	public java.lang.String getIntrstmd() {
		return this.intrstmd;
	}
	public void setRpmntway(java.lang.String value) {
		this.rpmntway = value;
	}
	
	public java.lang.String getRpmntway() {
		return this.rpmntway;
	}
	public void setGrtway(java.lang.String value) {
		this.grtway = value;
	}
	
	public java.lang.String getGrtway() {
		return this.grtway;
	}
	public void setGrtwaydtl(java.lang.String value) {
		this.grtwaydtl = value;
	}
	
	public java.lang.String getGrtwaydtl() {
		return this.grtwaydtl;
	}
	public void setApprvlstt(java.lang.String value) {
		this.apprvlstt = value;
	}
	
	public java.lang.String getApprvlstt() {
		return this.apprvlstt;
	}
	public void setBsnsbalttl(BigDecimal value) {
		this.bsnsbalttl = value;
	}
	
	public BigDecimal getBsnsbalttl() {
		return this.bsnsbalttl;
	}
	public void setThsbal(BigDecimal value) {
		this.thsbal = value;
	}
	
	public BigDecimal getThsbal() {
		return this.thsbal;
	}
	public void setOthrbal(BigDecimal value) {
		this.othrbal = value;
	}
	
	public BigDecimal getOthrbal() {
		return this.othrbal;
	}
	public void setGrtforothr(BigDecimal value) {
		this.grtforothr = value;
	}
	
	public BigDecimal getGrtforothr() {
		return this.grtforothr;
	}
	public void setBsnsopnm(java.lang.String value) {
		this.bsnsopnm = value;
	}
	
	public java.lang.String getBsnsopnm() {
		return this.bsnsopnm;
	}
	public void setMngdptno(java.lang.String value) {
		this.mngdptno = value;
	}
	
	public java.lang.String getMngdptno() {
		return this.mngdptno;
	}
	public void setBsnsopno(java.lang.String value) {
		this.bsnsopno = value;
	}
	
	public java.lang.String getBsnsopno() {
		return this.bsnsopno;
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
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}
	public void setToindstry(java.lang.String value) {
		this.toindstry = value;
	}
	
	public java.lang.String getToindstry() {
		return this.toindstry;
	}
	public void setUsedes(java.lang.String value) {
		this.usedes = value;
	}
	
	public java.lang.String getUsedes() {
		return this.usedes;
	}
	public void setPctyp(java.lang.String value) {
		this.pctyp = value;
	}
	
	public java.lang.String getPctyp() {
		return this.pctyp;
	}
	public void setHighpctno(java.lang.String value) {
		this.highpctno = value;
	}
	
	public java.lang.String getHighpctno() {
		return this.highpctno;
	}
	public void setIshigh(java.lang.String value) {
		this.ishigh = value;
	}
	
	public java.lang.String getIshigh() {
		return this.ishigh;
	}
	public void setBsrtno(java.lang.String value) {
		this.bsrtno = value;
	}
	
	public java.lang.String getBsrtno() {
		return this.bsrtno;
	}
	public void setOvrfltprcnt(java.lang.String value) {
		this.ovrfltprcnt = value;
	}
	
	public java.lang.String getOvrfltprcnt() {
		return this.ovrfltprcnt;
	}
	public void setFnfltprcnt(java.lang.String value) {
		this.fnfltprcnt = value;
	}
	
	public java.lang.String getFnfltprcnt() {
		return this.fnfltprcnt;
	}
	public void setCmpdfltprcnt(java.lang.String value) {
		this.cmpdfltprcnt = value;
	}
	
	public java.lang.String getCmpdfltprcnt() {
		return this.cmpdfltprcnt;
	}
	public void setRtyp(java.lang.String value) {
		this.rtyp = value;
	}
	
	public java.lang.String getRtyp() {
		return this.rtyp;
	}
	public void setBnkno(java.lang.String value) {
		this.bnkno = value;
	}
	
	public java.lang.String getBnkno() {
		return this.bnkno;
	}
	public void setBnknm(java.lang.String value) {
		this.bnknm = value;
	}
	
	public java.lang.String getBnknm() {
		return this.bnknm;
	}
	public void setIsfxinstpre(java.lang.String value) {
		this.isfxinstpre = value;
	}
	
	public java.lang.String getIsfxinstpre() {
		return this.isfxinstpre;
	}
	public void setFxinstamnt(java.lang.String value) {
		this.fxinstamnt = value;
	}
	
	public java.lang.String getFxinstamnt() {
		return this.fxinstamnt;
	}
	public void setCnsltamnt(java.lang.String value) {
		this.cnsltamnt = value;
	}
	
	public java.lang.String getCnsltamnt() {
		return this.cnsltamnt;
	}
	public void setReserved(java.lang.String value) {
		this.reserved = value;
	}
	
	public java.lang.String getReserved() {
		return this.reserved;
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

	public java.lang.Integer getCustScale() {
		return custScale;
	}

	public void setCustScale(java.lang.Integer custScale) {
		this.custScale = custScale;
	}

	public java.lang.Integer getSolutionWay() {
		return solutionWay;
	}

	public void setSolutionWay(java.lang.Integer solutionWay) {
		this.solutionWay = solutionWay;
	}

	public java.lang.Integer getLoanerType() {
		return loanerType;
	}

	public void setLoanerType(java.lang.Integer loanerType) {
		this.loanerType = loanerType;
	}

	public java.lang.Integer getLoanUsage() {
		return loanUsage;
	}

	public void setLoanUsage(java.lang.Integer loanUsage) {
		this.loanUsage = loanUsage;
	}

	public java.lang.Integer getLoanArea() {
		return loanArea;
	}

	public void setLoanArea(java.lang.Integer loanArea) {
		this.loanArea = loanArea;
	}

	public java.lang.Integer getIsTch() {
		return isTch;
	}

	public void setIsTch(java.lang.Integer isTch) {
		this.isTch = isTch;
	}

	
	
}

