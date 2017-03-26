/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.bsnsmng.entity;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.mf.base.BaseEntity;
import com.mf.util.*;

/**
 * @author wangzhi
 * @2015-07-08
 * @version 1.0
 * @param <T>
 */

public class BsnsDiya extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "BsnsDiya";
	public static final String ALIAS_CLNTNO = "客户编号";
	public static final String ALIAS_CLNTNM = "客户姓名";
	public static final String ALIAS_APPLYNO = "申请编号";
	public static final String ALIAS_RCRDID = "记录ID";
	public static final String ALIAS_CNTRCTNO = "合同编号";
	public static final String ALIAS_ZHIYACNTRCTNO = "抵押物合同编号";
	public static final String ALIAS_OWNERNO = "抵押物所有人号码";
	public static final String ALIAS_OWNERNM = "抵押物所有人姓名";
	public static final String ALIAS_DIYASHARE = "抵押物共有权人";
	public static final String ALIAS_DIYATYP = "抵押物分类";
	public static final String ALIAS_DIYANM = "抵押物名称";
	public static final String ALIAS_DIYALCTN = "抵押物地点";
	public static final String ALIAS_KEEPER = "保管人";
	public static final String ALIAS_KEEPDATE = "保管时间";
	public static final String ALIAS_DIYANO = "抵押编号";
	public static final String ALIAS_RGSTRNO = "抵押物所有权人贷款卡编码";
	public static final String ALIAS_PRVFILE = "抵押物相关证明文件";
	public static final String ALIAS_PWNNO = "抵押物证号";
	public static final String ALIAS_ORGNLVAL = "抵押物原值/购置价";
	public static final String ALIAS_ORGNLDATE = "建成/购置时间";
	public static final String ALIAS_AMNT = "面积/数量（平方米/个）";
	public static final String ALIAS_LMTYR = "抵押物使用年限";
	public static final String ALIAS_RMNYR = "剩余可使用年限";
	public static final String ALIAS_DPRCTNRT = "折旧率";
	public static final String ALIAS_REGORG = "抵押物登记机构";
	public static final String ALIAS_PREEVLVAL = "预评估价值";
	public static final String ALIAS_PREEVALDATE = "预评估日期";
	public static final String ALIAS_EVLMTHD = "评估方法";
	public static final String ALIAS_EVLVAL = "抵押物评估价值";
	public static final String ALIAS_EVALDATE = "抵押物评估时间";
	public static final String ALIAS_MRTGGRT = "抵押率";
	public static final String ALIAS_ASSRRT = "担保比例";
	public static final String ALIAS_NTRZTNORG = "公证机关";
	public static final String ALIAS_NTRZTNDATE = "公证日期";
	public static final String ALIAS_NTRZTNNO = "公证书编号";
	public static final String ALIAS_DIYAREGDATE = "抵押登记日期";
	public static final String ALIAS_DIYAEDATE = "抵押到期日期";
	public static final String ALIAS_POLNO = "抵押物保险单号";
	public static final String ALIAS_POLAMNT = "投保金额";
	public static final String ALIAS_DEPNO = "部门编号";
	public static final String ALIAS_REGOPNO = "登记人编号";
	public static final String ALIAS_REGDATE = "登记日期";
	public static final String ALIAS_UPDTDATE = "更新日期";
	public static final String ALIAS_REMARK = "备注";
	public static final String ALIAS_EVLORG = "抵押物评估机构";
	public static final String ALIAS_USETYP = "土地使用权类型";
	public static final String ALIAS_DSCP = "抵押物描述";
	public static final String ALIAS_OTHER = "是否补录他项权证";
	public static final String ALIAS_EXPRTFLG = "支出标识";
	public static final String ALIAS_DIYARENDZ = "抵押人的地址";
	public static final String ALIAS_DIYAFAREN = "抵押物的法人";
	
	//date formats
	
	public BsnsDiya(){
	}

	public BsnsDiya(
		java.lang.Integer rcrdid
	){
		this.rcrdid = rcrdid;
	}

	
	//columns START
	/**客户编号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**客户姓名==>db_column: CLNTNM*/
	private java.lang.String clntnm;
	/**申请编号==>db_column: APPLYNO*/
	private java.lang.String applyno;
	/**记录ID==>db_column: RCRDID*/
	private java.lang.Integer rcrdid;
	/**合同编号==>db_column: CNTRCTNO*/
	private java.lang.String cntrctno;
	/**抵押物合同编号==>db_column: ZHIYACNTRCTNO*/
	private java.lang.String zhiyacntrctno;
	/**抵押物所有人号码==>db_column: OWNERNO*/
	private java.lang.String ownerno;
	/**抵押物所有人姓名==>db_column: OWNERNM*/
	private java.lang.String ownernm;
	/**抵押物共有权人==>db_column: DIYASHARE*/
	private java.lang.String diyashare;
	/**抵押物分类==>db_column: DIYATYP*/
	private java.lang.String diyatyp;
	/**抵押物名称==>db_column: DIYANM*/
	private java.lang.String diyanm;
	/**抵押物地点==>db_column: DIYALCTN*/
	private java.lang.String diyalctn;
	/**保管人==>db_column: KEEPER*/
	private java.lang.String keeper;
	/**保管时间==>db_column: KEEPDATE*/
	private java.lang.String keepdate;
	/**抵押编号==>db_column: DIYANO*/
	private java.lang.String diyano;
	/**抵押物所有权人贷款卡编码==>db_column: RGSTRNO*/
	private java.lang.String rgstrno;
	/**抵押物相关证明文件==>db_column: PRVFILE*/
	private java.lang.String prvfile;
	/**抵押物证号==>db_column: PWNNO*/
	private java.lang.String pwnno;
	/**抵押物原值/购置价==>db_column: ORGNLVAL*/
	private BigDecimal orgnlval;
	/**建成/购置时间==>db_column: ORGNLDATE*/
	private java.lang.String orgnldate;
	/**面积/数量（平方米/个）==>db_column: AMNT*/
	private BigDecimal amnt;
	/**抵押物使用年限==>db_column: LMTYR*/
	private java.lang.String lmtyr;
	/**剩余可使用年限==>db_column: RMNYR*/
	private java.lang.String rmnyr;
	/**折旧率==>db_column: DPRCTNRT*/
	private BigDecimal dprctnrt;
	/**抵押物登记机构==>db_column: REGORG*/
	private java.lang.String regorg;
	/**预评估价值==>db_column: PREEVLVAL*/
	private BigDecimal preevlval;
	/**预评估日期==>db_column: PREEVALDATE*/
	private java.lang.String preevaldate;
	/**评估方法==>db_column: EVLMTHD*/
	private java.lang.String evlmthd;
	/**抵押物评估价值==>db_column: EVLVAL*/
	private BigDecimal evlval;
	/**抵押物评估时间==>db_column: EVALDATE*/
	private java.lang.String evaldate;
	/**抵押率==>db_column: MRTGGRT*/
	private BigDecimal mrtggrt;
	/**担保比例==>db_column: ASSRRT*/
	private BigDecimal assrrt;
	/**公证机关==>db_column: NTRZTNORG*/
	private java.lang.String ntrztnorg;
	/**公证日期==>db_column: NTRZTNDATE*/
	private java.lang.String ntrztndate;
	/**公证书编号==>db_column: NTRZTNNO*/
	private java.lang.String ntrztnno;
	/**抵押登记日期==>db_column: DIYAREGDATE*/
	private java.lang.String diyaregdate;
	/**抵押到期日期==>db_column: DIYAEDATE*/
	private java.lang.String diyaedate;
	/**抵押物保险单号==>db_column: POLNO*/
	private java.lang.String polno;
	/**投保金额==>db_column: POLAMNT*/
	private BigDecimal polamnt;
	/**部门编号==>db_column: DEPNO*/
	private java.lang.String depno;
	/**登记人编号==>db_column: REGOPNO*/
	private java.lang.String regopno;
	/**登记日期==>db_column: REGDATE*/
	private java.lang.String regdate;
	/**更新日期==>db_column: UPDTDATE*/
	private java.lang.String updtdate;
	/**备注==>db_column: REMARK*/
	private java.lang.String remark;
	/**抵押物评估机构==>db_column: EVLORG*/
	private java.lang.String evlorg;
	/**土地使用权类型==>db_column: USETYP*/
	private java.lang.String usetyp;
	/**抵押物描述==>db_column: DSCP*/
	private java.lang.String dscp;
	/**是否补录他项权证==>db_column: OTHER*/
	private java.lang.String other;
	/**支出标识==>db_column: EXPRTFLG*/
	private java.lang.String exprtflg;
	/**抵押人的地址==>db_column: DIYARENDZ*/
	private java.lang.String diyarendz;
	/**抵押物的法人==>db_column: DIYAFAREN*/
	private java.lang.String diyafaren;
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
	public void setApplyno(java.lang.String value) {
		this.applyno = value;
	}
	
	public java.lang.String getApplyno() {
		return this.applyno;
	}
	public void setRcrdid(java.lang.Integer value) {
		this.rcrdid = value;
	}
	
	public java.lang.Integer getRcrdid() {
		return this.rcrdid;
	}
	public void setCntrctno(java.lang.String value) {
		this.cntrctno = value;
	}
	
	public java.lang.String getCntrctno() {
		return this.cntrctno;
	}
	public void setZhiyacntrctno(java.lang.String value) {
		this.zhiyacntrctno = value;
	}
	
	public java.lang.String getZhiyacntrctno() {
		return this.zhiyacntrctno;
	}
	public void setOwnerno(java.lang.String value) {
		this.ownerno = value;
	}
	
	public java.lang.String getOwnerno() {
		return this.ownerno;
	}
	public void setOwnernm(java.lang.String value) {
		this.ownernm = value;
	}
	
	public java.lang.String getOwnernm() {
		return this.ownernm;
	}
	public void setDiyashare(java.lang.String value) {
		this.diyashare = value;
	}
	
	public java.lang.String getDiyashare() {
		return this.diyashare;
	}
	public void setDiyatyp(java.lang.String value) {
		this.diyatyp = value;
	}
	
	public java.lang.String getDiyatyp() {
		return this.diyatyp;
	}
	public void setDiyanm(java.lang.String value) {
		this.diyanm = value;
	}
	
	public java.lang.String getDiyanm() {
		return this.diyanm;
	}
	public void setDiyalctn(java.lang.String value) {
		this.diyalctn = value;
	}
	
	public java.lang.String getDiyalctn() {
		return this.diyalctn;
	}
	public void setKeeper(java.lang.String value) {
		this.keeper = value;
	}
	
	public java.lang.String getKeeper() {
		return this.keeper;
	}
	public void setKeepdate(java.lang.String value) {
		this.keepdate = value;
	}
	
	public java.lang.String getKeepdate() {
		return this.keepdate;
	}
	public void setDiyano(java.lang.String value) {
		this.diyano = value;
	}
	
	public java.lang.String getDiyano() {
		return this.diyano;
	}
	public void setRgstrno(java.lang.String value) {
		this.rgstrno = value;
	}
	
	public java.lang.String getRgstrno() {
		return this.rgstrno;
	}
	public void setPrvfile(java.lang.String value) {
		this.prvfile = value;
	}
	
	public java.lang.String getPrvfile() {
		return this.prvfile;
	}
	public void setPwnno(java.lang.String value) {
		this.pwnno = value;
	}
	
	public java.lang.String getPwnno() {
		return this.pwnno;
	}
	public void setOrgnlval(BigDecimal value) {
		this.orgnlval = value;
	}
	
	public BigDecimal getOrgnlval() {
		return this.orgnlval;
	}
	public void setOrgnldate(java.lang.String value) {
		this.orgnldate = value;
	}
	
	public java.lang.String getOrgnldate() {
		return this.orgnldate;
	}
	public void setAmnt(BigDecimal value) {
		this.amnt = value;
	}
	
	public BigDecimal getAmnt() {
		return this.amnt;
	}
	public void setLmtyr(java.lang.String value) {
		this.lmtyr = value;
	}
	
	public java.lang.String getLmtyr() {
		return this.lmtyr;
	}
	public void setRmnyr(java.lang.String value) {
		this.rmnyr = value;
	}
	
	public java.lang.String getRmnyr() {
		return this.rmnyr;
	}
	public void setDprctnrt(BigDecimal value) {
		this.dprctnrt = value;
	}
	
	public BigDecimal getDprctnrt() {
		return this.dprctnrt;
	}
	public void setRegorg(java.lang.String value) {
		this.regorg = value;
	}
	
	public java.lang.String getRegorg() {
		return this.regorg;
	}
	public void setPreevlval(BigDecimal value) {
		this.preevlval = value;
	}
	
	public BigDecimal getPreevlval() {
		return this.preevlval;
	}
	public void setPreevaldate(java.lang.String value) {
		this.preevaldate = value;
	}
	
	public java.lang.String getPreevaldate() {
		return this.preevaldate;
	}
	public void setEvlmthd(java.lang.String value) {
		this.evlmthd = value;
	}
	
	public java.lang.String getEvlmthd() {
		return this.evlmthd;
	}
	public void setEvlval(BigDecimal value) {
		this.evlval = value;
	}
	
	public BigDecimal getEvlval() {
		return this.evlval;
	}
	public void setEvaldate(java.lang.String value) {
		this.evaldate = value;
	}
	
	public java.lang.String getEvaldate() {
		return this.evaldate;
	}
	public void setMrtggrt(BigDecimal value) {
		this.mrtggrt = value;
	}
	
	public BigDecimal getMrtggrt() {
		return this.mrtggrt;
	}
	public void setAssrrt(BigDecimal value) {
		this.assrrt = value;
	}
	
	public BigDecimal getAssrrt() {
		return this.assrrt;
	}
	public void setNtrztnorg(java.lang.String value) {
		this.ntrztnorg = value;
	}
	
	public java.lang.String getNtrztnorg() {
		return this.ntrztnorg;
	}
	public void setNtrztndate(java.lang.String value) {
		this.ntrztndate = value;
	}
	
	public java.lang.String getNtrztndate() {
		return this.ntrztndate;
	}
	public void setNtrztnno(java.lang.String value) {
		this.ntrztnno = value;
	}
	
	public java.lang.String getNtrztnno() {
		return this.ntrztnno;
	}
	public void setDiyaregdate(java.lang.String value) {
		this.diyaregdate = value;
	}
	
	public java.lang.String getDiyaregdate() {
		return this.diyaregdate;
	}
	public void setDiyaedate(java.lang.String value) {
		this.diyaedate = value;
	}
	
	public java.lang.String getDiyaedate() {
		return this.diyaedate;
	}
	public void setPolno(java.lang.String value) {
		this.polno = value;
	}
	
	public java.lang.String getPolno() {
		return this.polno;
	}
	public void setPolamnt(BigDecimal value) {
		this.polamnt = value;
	}
	
	public BigDecimal getPolamnt() {
		return this.polamnt;
	}
	public void setDepno(java.lang.String value) {
		this.depno = value;
	}
	
	public java.lang.String getDepno() {
		return this.depno;
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
	public void setEvlorg(java.lang.String value) {
		this.evlorg = value;
	}
	
	public java.lang.String getEvlorg() {
		return this.evlorg;
	}
	public void setUsetyp(java.lang.String value) {
		this.usetyp = value;
	}
	
	public java.lang.String getUsetyp() {
		return this.usetyp;
	}
	public void setDscp(java.lang.String value) {
		this.dscp = value;
	}
	
	public java.lang.String getDscp() {
		return this.dscp;
	}
	public void setOther(java.lang.String value) {
		this.other = value;
	}
	
	public java.lang.String getOther() {
		return this.other;
	}
	public void setExprtflg(java.lang.String value) {
		this.exprtflg = value;
	}
	
	public java.lang.String getExprtflg() {
		return this.exprtflg;
	}
	public void setDiyarendz(java.lang.String value) {
		this.diyarendz = value;
	}
	
	public java.lang.String getDiyarendz() {
		return this.diyarendz;
	}
	public void setDiyafaren(java.lang.String value) {
		this.diyafaren = value;
	}
	
	public java.lang.String getDiyafaren() {
		return this.diyafaren;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Clntno",getClntno())
			.append("Clntnm",getClntnm())
			.append("Applyno",getApplyno())
			.append("Rcrdid",getRcrdid())
			.append("Cntrctno",getCntrctno())
			.append("Zhiyacntrctno",getZhiyacntrctno())
			.append("Ownerno",getOwnerno())
			.append("Ownernm",getOwnernm())
			.append("Diyashare",getDiyashare())
			.append("Diyatyp",getDiyatyp())
			.append("Diyanm",getDiyanm())
			.append("Diyalctn",getDiyalctn())
			.append("Keeper",getKeeper())
			.append("Keepdate",getKeepdate())
			.append("Diyano",getDiyano())
			.append("Rgstrno",getRgstrno())
			.append("Prvfile",getPrvfile())
			.append("Pwnno",getPwnno())
			.append("Orgnlval",getOrgnlval())
			.append("Orgnldate",getOrgnldate())
			.append("Amnt",getAmnt())
			.append("Lmtyr",getLmtyr())
			.append("Rmnyr",getRmnyr())
			.append("Dprctnrt",getDprctnrt())
			.append("Regorg",getRegorg())
			.append("Preevlval",getPreevlval())
			.append("Preevaldate",getPreevaldate())
			.append("Evlmthd",getEvlmthd())
			.append("Evlval",getEvlval())
			.append("Evaldate",getEvaldate())
			.append("Mrtggrt",getMrtggrt())
			.append("Assrrt",getAssrrt())
			.append("Ntrztnorg",getNtrztnorg())
			.append("Ntrztndate",getNtrztndate())
			.append("Ntrztnno",getNtrztnno())
			.append("Diyaregdate",getDiyaregdate())
			.append("Diyaedate",getDiyaedate())
			.append("Polno",getPolno())
			.append("Polamnt",getPolamnt())
			.append("Depno",getDepno())
			.append("Regopno",getRegopno())
			.append("Regdate",getRegdate())
			.append("Updtdate",getUpdtdate())
			.append("Remark",getRemark())
			.append("Evlorg",getEvlorg())
			.append("Usetyp",getUsetyp())
			.append("Dscp",getDscp())
			.append("Other",getOther())
			.append("Exprtflg",getExprtflg())
			.append("Diyarendz",getDiyarendz())
			.append("Diyafaren",getDiyafaren())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getRcrdid())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BsnsDiya == false) return false;
		if(this == obj) return true;
		BsnsDiya other = (BsnsDiya)obj;
		return new EqualsBuilder()
			.append(getRcrdid(),other.getRcrdid())
			.isEquals();
	}
}

