/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.cntrtmng.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.mf.base.BaseEntity;
import com.mf.cntrtmng.entity.*;
import com.mf.common.util.*;

import java.math.BigDecimal;

public class BsnsCntrct extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "BsnsCntrct";
	public static final String ALIAS_DPTNO = "开办部门编号";
	public static final String ALIAS_CLNTNO = "客户编号";
	public static final String ALIAS_CLNTNM = "客户姓名";
	public static final String ALIAS_CNTRCTNO = "合同编号";
	public static final String ALIAS_APPLYNO = "业务申请编号";
	public static final String ALIAS_ISFIXREPAY = "是否固定还款日";
	public static final String ALIAS_KNDNO = "业务种类编号";
	public static final String ALIAS_BSNSTYP = "发生类型";
	public static final String ALIAS_CNTRCTAMNT = "合同金额";
	public static final String ALIAS_OUTAMNT = "已申请放款金额";
	public static final String ALIAS_RMNAMNT = "可申请放款金额";
	public static final String ALIAS_CURRNCY = "币种";
	public static final String ALIAS_CNTRCTSDATE = "合同开始日期";
	public static final String ALIAS_CNTRCTEDATE = "合同结束日期";
	public static final String ALIAS_BSRTYP = "基准利率类型";
	public static final String ALIAS_RTFLTPRCNT = "利率浮动百分比";
	public static final String ALIAS_BSNSRT = "执行利率";
	public static final String ALIAS_INTRSTMD = "计息方式";
	public static final String ALIAS_RPMNTWAY = "还款方式";
	public static final String ALIAS_EXTRT = "展期利率";
	public static final String ALIAS_FNRT = "罚息利率";
	public static final String ALIAS_TERMTYP = "期限种类";
	public static final String ALIAS_TRMYR = "期限年";
	public static final String ALIAS_TRMMNTH = "期限月";
	public static final String ALIAS_TRMDAY = "期限日";
	public static final String ALIAS_GRTWAY = "担保方式";
	public static final String ALIAS_GRTWAYDTL = "担保方式具体";
	public static final String ALIAS_USENO = "贷款用途编号";
	public static final String ALIAS_MNGDPTNO = "管户机构编号";
	public static final String ALIAS_MNGOPNO = "管户人编号";
	public static final String ALIAS_BSNSDPTNO = "操作员部门编号";
	public static final String ALIAS_BSNSOPNO = "操作员员工编号";
	public static final String ALIAS_LNAMNT = "贷款剩余金额";
	public static final String ALIAS_APPLYAMNT = "贷款申请金额";
	public static final String ALIAS_APPLYRT = "申请利率";
	public static final String ALIAS_APPLYDATE = "申请日期";
	public static final String ALIAS_CNTRCTSTT = "合同状态";
	public static final String ALIAS_FNSHFLG = "结束标志";
	public static final String ALIAS_SGNDATE = "合同签订日期";
	public static final String ALIAS_EXTFLG = "展期标志";
	public static final String ALIAS_CLNTACCNT = "客户开户账号";
	public static final String ALIAS_CLNTBNKNM = "客户开户行名称";
	public static final String ALIAS_REGDPTNO = "机构编号";
	public static final String ALIAS_REGOPNO = "操作员编号";
	public static final String ALIAS_REGDATE = "登记日期";
	public static final String ALIAS_UPDTDATE = "更新日期";
	public static final String ALIAS_REMARK = "备注";
	public static final String ALIAS_RLCNTRCTNO = "实际合同编号";
	public static final String ALIAS_OLDCNTRCTNO = "原合同编号";
	public static final String ALIAS_CNTRCTYP = "合同类型";
	public static final String ALIAS_RTNO = "利率编号";
	public static final String ALIAS_OVRFLTPRCNT = "逾期利率浮动百分比";
	public static final String ALIAS_FNFLTPRCNT = "罚息利率浮动百分比";
	public static final String ALIAS_CMPDFLTPRCN = "复利利率浮动百分比";
	public static final String ALIAS_EXTFLTPRCNT = "展期利率浮动百分比";
	public static final String ALIAS_CNSLTAMNT = "咨询费";
	public static final String ALIAS_CNSLTHSPY = "已支付咨询费";
	public static final String ALIAS_RPYINST = "提前支付利息";
	public static final String ALIAS_FXDATE = "固定利息日期";
	public static final String ALIAS_FXINST = "固定利息支付";
	public static final String ALIAS_FXINSTBLNC = "固定利息余额";
	public static final String ALIAS_FXINSTHSPY = "固定利息已支付";
	public static final String ALIAS_CNSLTBLNC = "咨询费余额";
	public static final String ALIAS_OUTFLG = "放款标志";
	public static final String ALIAS_RTYP = "利率类型";
	public static final String ALIAS_CNTRCTEDFLG = "合同结束标志";
	
	//date formats
	
	public BsnsCntrct(){
	}

	public BsnsCntrct(
		java.lang.String cntrctno
	){
		this.cntrctno = cntrctno;
	}

	
	//columns START
	/**开办部门编号==>db_column: DPTNO*/
	private java.lang.String dptno;
	/**客户编号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**客户姓名==>db_column: CLNTNM*/
	private java.lang.String clntnm;
	/**合同编号==>db_column: CNTRCTNO*/
	private java.lang.String cntrctno;
	/**业务申请编号==>db_column: APPLYNO*/
	private java.lang.String applyno;
	/**是否固定还款日==>db_column: ISFIXREPAY*/
	private java.lang.String isfixrepay;
	/**业务种类编号==>db_column: KNDNO*/
	private java.lang.String kndno;
	/**发生类型==>db_column: BSNSTYP*/
	private java.lang.String bsnstyp;
	/**合同金额==>db_column: CNTRCTAMNT*/
	private BigDecimal cntrctamnt;
	/**已申请放款金额==>db_column: OUTAMNT*/
	private BigDecimal outamnt;
	/**可申请放款金额==>db_column: RMNAMNT*/
	private BigDecimal rmnamnt;
	/**币种==>db_column: CURRNCY*/
	private java.lang.String currncy;
	/**合同开始日期==>db_column: CNTRCTSDATE*/
	private java.lang.String cntrctsdate;
	/**合同结束日期==>db_column: CNTRCTEDATE*/
	private java.lang.String cntrctedate;
	/**基准利率类型==>db_column: BSRTYP*/
	private java.lang.String bsrtyp;
	/**利率浮动百分比==>db_column: RTFLTPRCNT*/
	private BigDecimal rtfltprcnt;
	/**执行利率==>db_column: BSNSRT*/
	private BigDecimal bsnsrt;
	/**计息方式==>db_column: INTRSTMD*/
	private java.lang.String intrstmd;
	/**还款方式==>db_column: RPMNTWAY*/
	private java.lang.String rpmntway;
	/**展期利率==>db_column: EXTRT*/
	private BigDecimal extrt;
	/**罚息利率==>db_column: FNRT*/
	private BigDecimal fnrt;
	/**期限种类==>db_column: TERMTYP*/
	private java.lang.String termtyp;
	/**期限年==>db_column: TRMYR*/
	private Integer trmyr;
	/**期限月==>db_column: TRMMNTH*/
	private Integer trmmnth;
	/**期限日==>db_column: TRMDAY*/
	private Integer trmday;
	/**担保方式==>db_column: GRTWAY*/
	private java.lang.String grtway;
	/**担保方式具体==>db_column: GRTWAYDTL*/
	private java.lang.String grtwaydtl;
	/**贷款用途编号==>db_column: USENO*/
	private java.lang.String useno;
	/**管户机构编号==>db_column: MNGDPTNO*/
	private java.lang.String mngdptno;
	/**管户人编号==>db_column: MNGOPNO*/
	private java.lang.String mngopno;
	/**操作员部门编号==>db_column: BSNSDPTNO*/
	private java.lang.String bsnsdptno;
	/**操作员员工编号==>db_column: BSNSOPNO*/
	private java.lang.String bsnsopno;
	/**贷款剩余金额==>db_column: LNAMNT*/
	private BigDecimal lnamnt;
	/**贷款申请金额==>db_column: APPLYAMNT*/
	private BigDecimal applyamnt;
	/**申请利率==>db_column: APPLYRT*/
	private BigDecimal applyrt;
	/**申请日期==>db_column: APPLYDATE*/
	private java.lang.String applydate;
	/**合同状态==>db_column: CNTRCTSTT*/
	private java.lang.String cntrctstt;
	/**结束标志==>db_column: FNSHFLG*/
	private java.lang.String fnshflg;
	/**合同签订日期==>db_column: SGNDATE*/
	private java.lang.String sgndate;
	/**展期标志==>db_column: EXTFLG*/
	private java.lang.String extflg;
	/**客户开户账号==>db_column: CLNTACCNT*/
	private java.lang.String clntaccnt;
	/**客户开户行名称==>db_column: CLNTBNKNM*/
	private java.lang.String clntbnknm;
	/**机构编号==>db_column: REGDPTNO*/
	private java.lang.String regdptno;
	/**操作员编号==>db_column: REGOPNO*/
	private java.lang.String regopno;
	/**登记日期==>db_column: REGDATE*/
	private java.lang.String regdate;
	/**更新日期==>db_column: UPDTDATE*/
	private java.lang.String updtdate;
	/**备注==>db_column: REMARK*/
	private java.lang.String remark;
	/**实际合同编号==>db_column: RLCNTRCTNO*/
	private java.lang.String rlcntrctno;
	/**原合同编号==>db_column: OLDCNTRCTNO*/
	private java.lang.String oldcntrctno;
	/**合同类型==>db_column: CNTRCTYP*/
	private java.lang.String cntrctyp;
	/**利率编号==>db_column: RTNO*/
	private java.lang.String rtno;
	/**逾期利率浮动百分比==>db_column: OVRFLTPRCNT*/
	private BigDecimal ovrfltprcnt;
	/**罚息利率浮动百分比==>db_column: FNFLTPRCNT*/
	private BigDecimal fnfltprcnt;
	/**复利利率浮动百分比==>db_column: CMPDFLTPRCN*/
	private BigDecimal cmpdfltprcn;
	/**展期利率浮动百分比==>db_column: EXTFLTPRCNT*/
	private BigDecimal extfltprcnt;
	/**咨询费==>db_column: CNSLTAMNT*/
	private BigDecimal cnsltamnt;
	/**已支付咨询费==>db_column: CNSLTHSPY*/
	private BigDecimal cnslthspy;
	/**提前支付利息==>db_column: RPYINST*/
	private BigDecimal rpyinst;
	/**固定利息日期==>db_column: FXDATE*/
	private java.lang.String fxdate;
	/**固定利息支付==>db_column: FXINST*/
	private BigDecimal fxinst;
	/**固定利息余额==>db_column: FXINSTBLNC*/
	private BigDecimal fxinstblnc;
	/**固定利息已支付==>db_column: FXINSTHSPY*/
	private BigDecimal fxinsthspy;
	/**咨询费余额==>db_column: CNSLTBLNC*/
	private BigDecimal cnsltblnc;
	/**放款标志==>db_column: OUTFLG*/
	private java.lang.String outflg;
	/**利率类型==>db_column: RTYP*/
	private java.lang.String rtyp;
	/**合同结束标志==>db_column: CNTRCTEDFLG*/
	private java.lang.String cntrctedflg;
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

	public void setDptno(java.lang.String value) {
		this.dptno = value;
	}
	
	public java.lang.String getDptno() {
		return this.dptno;
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
	public void setApplyno(java.lang.String value) {
		this.applyno = value;
	}
	
	public java.lang.String getApplyno() {
		return this.applyno;
	}
	public void setIsfixrepay(java.lang.String value) {
		this.isfixrepay = value;
	}
	
	public java.lang.String getIsfixrepay() {
		return this.isfixrepay;
	}
	public void setKndno(java.lang.String value) {
		this.kndno = value;
	}
	
	public java.lang.String getKndno() {
		return this.kndno;
	}
	public void setBsnstyp(java.lang.String value) {
		this.bsnstyp = value;
	}
	
	public java.lang.String getBsnstyp() {
		return this.bsnstyp;
	}
	public void setCntrctamnt(BigDecimal value) {
		this.cntrctamnt = value;
	}
	
	public BigDecimal getCntrctamnt() {
		return this.cntrctamnt;
	}
	public void setOutamnt(BigDecimal value) {
		this.outamnt = value;
	}
	
	public BigDecimal getOutamnt() {
		return this.outamnt;
	}
	public void setRmnamnt(BigDecimal value) {
		this.rmnamnt = value;
	}
	
	public BigDecimal getRmnamnt() {
		return this.rmnamnt;
	}
	public void setCurrncy(java.lang.String value) {
		this.currncy = value;
	}
	
	public java.lang.String getCurrncy() {
		return this.currncy;
	}
	public void setCntrctsdate(java.lang.String value) {
		this.cntrctsdate = value;
	}
	
	public java.lang.String getCntrctsdate() {
		return this.cntrctsdate;
	}
	public void setCntrctedate(java.lang.String value) {
		this.cntrctedate = value;
	}
	
	public java.lang.String getCntrctedate() {
		return this.cntrctedate;
	}
	public void setBsrtyp(java.lang.String value) {
		this.bsrtyp = value;
	}
	
	public java.lang.String getBsrtyp() {
		return this.bsrtyp;
	}
	public void setRtfltprcnt(BigDecimal value) {
		this.rtfltprcnt = value;
	}
	
	public BigDecimal getRtfltprcnt() {
		return this.rtfltprcnt;
	}
	public void setBsnsrt(BigDecimal value) {
		this.bsnsrt = value;
	}
	
	public BigDecimal getBsnsrt() {
		return this.bsnsrt;
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
	public void setExtrt(BigDecimal value) {
		this.extrt = value;
	}
	
	public BigDecimal getExtrt() {
		return this.extrt;
	}
	public void setFnrt(BigDecimal value) {
		this.fnrt = value;
	}
	
	public BigDecimal getFnrt() {
		return this.fnrt;
	}
	public void setTermtyp(java.lang.String value) {
		this.termtyp = value;
	}
	
	public java.lang.String getTermtyp() {
		return this.termtyp;
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
	public void setUseno(java.lang.String value) {
		this.useno = value;
	}
	
	public java.lang.String getUseno() {
		return this.useno;
	}
	public void setMngdptno(java.lang.String value) {
		this.mngdptno = value;
	}
	
	public java.lang.String getMngdptno() {
		return this.mngdptno;
	}
	public void setMngopno(java.lang.String value) {
		this.mngopno = value;
	}
	
	public java.lang.String getMngopno() {
		return this.mngopno;
	}
	public void setBsnsdptno(java.lang.String value) {
		this.bsnsdptno = value;
	}
	
	public java.lang.String getBsnsdptno() {
		return this.bsnsdptno;
	}
	public void setBsnsopno(java.lang.String value) {
		this.bsnsopno = value;
	}
	
	public java.lang.String getBsnsopno() {
		return this.bsnsopno;
	}
	public void setLnamnt(BigDecimal value) {
		this.lnamnt = value;
	}
	
	public BigDecimal getLnamnt() {
		return this.lnamnt;
	}
	public void setApplyamnt(BigDecimal value) {
		this.applyamnt = value;
	}
	
	public BigDecimal getApplyamnt() {
		return this.applyamnt;
	}
	public void setApplyrt(BigDecimal value) {
		this.applyrt = value;
	}
	
	public BigDecimal getApplyrt() {
		return this.applyrt;
	}
	public void setApplydate(java.lang.String value) {
		this.applydate = value;
	}
	
	public java.lang.String getApplydate() {
		return this.applydate;
	}
	public void setCntrctstt(java.lang.String value) {
		this.cntrctstt = value;
	}
	
	public java.lang.String getCntrctstt() {
		return this.cntrctstt;
	}
	public void setFnshflg(java.lang.String value) {
		this.fnshflg = value;
	}
	
	public java.lang.String getFnshflg() {
		return this.fnshflg;
	}
	public void setSgndate(java.lang.String value) {
		this.sgndate = value;
	}
	
	public java.lang.String getSgndate() {
		return this.sgndate;
	}
	public void setExtflg(java.lang.String value) {
		this.extflg = value;
	}
	
	public java.lang.String getExtflg() {
		return this.extflg;
	}
	public void setClntaccnt(java.lang.String value) {
		this.clntaccnt = value;
	}
	
	public java.lang.String getClntaccnt() {
		return this.clntaccnt;
	}
	public void setClntbnknm(java.lang.String value) {
		this.clntbnknm = value;
	}
	
	public java.lang.String getClntbnknm() {
		return this.clntbnknm;
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
	public void setRlcntrctno(java.lang.String value) {
		this.rlcntrctno = value;
	}
	
	public java.lang.String getRlcntrctno() {
		return this.rlcntrctno;
	}
	public void setOldcntrctno(java.lang.String value) {
		this.oldcntrctno = value;
	}
	
	public java.lang.String getOldcntrctno() {
		return this.oldcntrctno;
	}
	public void setCntrctyp(java.lang.String value) {
		this.cntrctyp = value;
	}
	
	public java.lang.String getCntrctyp() {
		return this.cntrctyp;
	}
	public void setRtno(java.lang.String value) {
		this.rtno = value;
	}
	
	public java.lang.String getRtno() {
		return this.rtno;
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
	public void setCmpdfltprcn(BigDecimal value) {
		this.cmpdfltprcn = value;
	}
	
	public BigDecimal getCmpdfltprcn() {
		return this.cmpdfltprcn;
	}
	public void setExtfltprcnt(BigDecimal value) {
		this.extfltprcnt = value;
	}
	
	public BigDecimal getExtfltprcnt() {
		return this.extfltprcnt;
	}
	public void setCnsltamnt(BigDecimal value) {
		this.cnsltamnt = value;
	}
	
	public BigDecimal getCnsltamnt() {
		return this.cnsltamnt;
	}
	public void setCnslthspy(BigDecimal value) {
		this.cnslthspy = value;
	}
	
	public BigDecimal getCnslthspy() {
		return this.cnslthspy;
	}
	public void setRpyinst(BigDecimal value) {
		this.rpyinst = value;
	}
	
	public BigDecimal getRpyinst() {
		return this.rpyinst;
	}
	public void setFxdate(java.lang.String value) {
		this.fxdate = value;
	}
	
	public java.lang.String getFxdate() {
		return this.fxdate;
	}
	public void setFxinst(BigDecimal value) {
		this.fxinst = value;
	}
	
	public BigDecimal getFxinst() {
		return this.fxinst;
	}
	public void setFxinstblnc(BigDecimal value) {
		this.fxinstblnc = value;
	}
	
	public BigDecimal getFxinstblnc() {
		return this.fxinstblnc;
	}
	public void setFxinsthspy(BigDecimal value) {
		this.fxinsthspy = value;
	}
	
	public BigDecimal getFxinsthspy() {
		return this.fxinsthspy;
	}
	public void setCnsltblnc(BigDecimal value) {
		this.cnsltblnc = value;
	}
	
	public BigDecimal getCnsltblnc() {
		return this.cnsltblnc;
	}
	public void setOutflg(java.lang.String value) {
		this.outflg = value;
	}
	
	public java.lang.String getOutflg() {
		return this.outflg;
	}
	public void setRtyp(java.lang.String value) {
		this.rtyp = value;
	}
	
	public java.lang.String getRtyp() {
		return this.rtyp;
	}
	public void setCntrctedflg(java.lang.String value) {
		this.cntrctedflg = value;
	}
	
	public java.lang.String getCntrctedflg() {
		return this.cntrctedflg;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Dptno",getDptno())
			.append("Clntno",getClntno())
			.append("Clntnm",getClntnm())
			.append("Cntrctno",getCntrctno())
			.append("Applyno",getApplyno())
			.append("Isfixrepay",getIsfixrepay())
			.append("Kndno",getKndno())
			.append("Bsnstyp",getBsnstyp())
			.append("Cntrctamnt",getCntrctamnt())
			.append("Outamnt",getOutamnt())
			.append("Rmnamnt",getRmnamnt())
			.append("Currncy",getCurrncy())
			.append("Cntrctsdate",getCntrctsdate())
			.append("Cntrctedate",getCntrctedate())
			.append("Bsrtyp",getBsrtyp())
			.append("Rtfltprcnt",getRtfltprcnt())
			.append("Bsnsrt",getBsnsrt())
			.append("Intrstmd",getIntrstmd())
			.append("Rpmntway",getRpmntway())
			.append("Extrt",getExtrt())
			.append("Fnrt",getFnrt())
			.append("Termtyp",getTermtyp())
			.append("Trmyr",getTrmyr())
			.append("Trmmnth",getTrmmnth())
			.append("Trmday",getTrmday())
			.append("Grtway",getGrtway())
			.append("Grtwaydtl",getGrtwaydtl())
			.append("Useno",getUseno())
			.append("Mngdptno",getMngdptno())
			.append("Mngopno",getMngopno())
			.append("Bsnsdptno",getBsnsdptno())
			.append("Bsnsopno",getBsnsopno())
			.append("Lnamnt",getLnamnt())
			.append("Applyamnt",getApplyamnt())
			.append("Applyrt",getApplyrt())
			.append("Applydate",getApplydate())
			.append("Cntrctstt",getCntrctstt())
			.append("Fnshflg",getFnshflg())
			.append("Sgndate",getSgndate())
			.append("Extflg",getExtflg())
			.append("Clntaccnt",getClntaccnt())
			.append("Clntbnknm",getClntbnknm())
			.append("Regdptno",getRegdptno())
			.append("Regopno",getRegopno())
			.append("Regdate",getRegdate())
			.append("Updtdate",getUpdtdate())
			.append("Remark",getRemark())
			.append("Rlcntrctno",getRlcntrctno())
			.append("Oldcntrctno",getOldcntrctno())
			.append("Cntrctyp",getCntrctyp())
			.append("Rtno",getRtno())
			.append("Ovrfltprcnt",getOvrfltprcnt())
			.append("Fnfltprcnt",getFnfltprcnt())
			.append("Cmpdfltprcn",getCmpdfltprcn())
			.append("Extfltprcnt",getExtfltprcnt())
			.append("Cnsltamnt",getCnsltamnt())
			.append("Cnslthspy",getCnslthspy())
			.append("Rpyinst",getRpyinst())
			.append("Fxdate",getFxdate())
			.append("Fxinst",getFxinst())
			.append("Fxinstblnc",getFxinstblnc())
			.append("Fxinsthspy",getFxinsthspy())
			.append("Cnsltblnc",getCnsltblnc())
			.append("Outflg",getOutflg())
			.append("Rtyp",getRtyp())
			.append("Cntrctedflg",getCntrctedflg())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCntrctno())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BsnsCntrct == false) return false;
		if(this == obj) return true;
		BsnsCntrct other = (BsnsCntrct)obj;
		return new EqualsBuilder()
			.append(getCntrctno(),other.getCntrctno())
			.isEquals();
	}
}

