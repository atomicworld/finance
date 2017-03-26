/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.flowmng.entity;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


/**
 * @author yangchao
 * @2015-01-18
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class FlowApprlcmmnts {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "FlowApprlcmmnts";
	public static final String ALIAS_APPLYNO = "申请编号";
	public static final String ALIAS_SRLNO = "流水号";
	public static final String ALIAS_CMMNTYPENO = "审批意见类型编号";
	public static final String ALIAS_APPREDAMNT = "审批金额";
	public static final String ALIAS_APPREDRT = "审批利率";
	public static final String ALIAS_CMMNTDES = "审批说明内容";
	public static final String ALIAS_CURSTEP = "当前审批步骤";
	public static final String ALIAS_NEXTSTEP = "下一审批步骤";
	public static final String ALIAS_APPRSTT = "审批状态";
	public static final String ALIAS_APPRERNO = "审批人员编号";
	public static final String ALIAS_APPRERNM = "审批人员姓名";
	public static final String ALIAS_APPRERDPTNO = "审批人部门编号";
	public static final String ALIAS_APPRDT = "审批日期";
	public static final String ALIAS_APPRTM = "审批时间";
	public static final String ALIAS_RTRNFLG = "发回重新申请累计次数";
	
	//date formats
	
	public FlowApprlcmmnts(){
	}

	public FlowApprlcmmnts(
		java.lang.String applyno,
		java.lang.String srlno
	){
		this.applyno = applyno;
		this.srlno = srlno;
	}

	
	//columns START
	/**申请编号==>db_column: APPLYNO*/
	private java.lang.String applyno;
	/**流水号==>db_column: SRLNO*/
	private java.lang.String srlno;
	/**审批意见类型编号==>db_column: CMMNTYPENO*/
	private java.lang.String cmmntypeno;
	/**审批金额==>db_column: APPREDAMNT*/
	private BigDecimal appredamnt;
	/**审批利率==>db_column: APPREDRT*/
	private BigDecimal appredrt;
	/**审批说明内容==>db_column: CMMNTDES*/
	private java.lang.String cmmntdes;
	/**当前审批步骤==>db_column: CURSTEP*/
	private java.lang.String curstep;
	/**下一审批步骤==>db_column: NEXTSTEP*/
	private java.lang.String nextstep;
	/**审批状态==>db_column: APPRSTT*/
	private java.lang.String apprstt;
	/**审批人员编号==>db_column: APPRERNO*/
	private java.lang.String apprerno;
	/**审批人员姓名==>db_column: APPRERNM*/
	private java.lang.String apprernm;
	/**审批人部门编号==>db_column: APPRERDPTNO*/
	private java.lang.String apprerdptno;
	/**审批日期==>db_column: APPRDT*/
	private java.lang.String apprdt;
	/**审批时间==>db_column: APPRTM*/
	private java.lang.String apprtm;
	/**发回重新申请累计次数==>db_column: RTRNFLG*/
	private java.lang.String rtrnflg;
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

	public void setApplyno(java.lang.String value) {
		this.applyno = value;
	}
	
	public java.lang.String getApplyno() {
		return this.applyno;
	}
	public void setSrlno(java.lang.String value) {
		this.srlno = value;
	}
	
	public java.lang.String getSrlno() {
		return this.srlno;
	}
	public void setCmmntypeno(java.lang.String value) {
		this.cmmntypeno = value;
	}
	
	public java.lang.String getCmmntypeno() {
		return this.cmmntypeno;
	}
	public void setAppredamnt(BigDecimal value) {
		this.appredamnt = value;
	}
	
	public BigDecimal getAppredamnt() {
		return this.appredamnt;
	}
	public void setAppredrt(BigDecimal value) {
		this.appredrt = value;
	}
	
	public BigDecimal getAppredrt() {
		return this.appredrt;
	}
	public void setCmmntdes(java.lang.String value) {
		this.cmmntdes = value;
	}
	
	public java.lang.String getCmmntdes() {
		return this.cmmntdes;
	}
	public void setCurstep(java.lang.String value) {
		this.curstep = value;
	}
	
	public java.lang.String getCurstep() {
		return this.curstep;
	}
	public void setNextstep(java.lang.String value) {
		this.nextstep = value;
	}
	
	public java.lang.String getNextstep() {
		return this.nextstep;
	}
	public void setApprstt(java.lang.String value) {
		this.apprstt = value;
	}
	
	public java.lang.String getApprstt() {
		return this.apprstt;
	}
	public void setApprerno(java.lang.String value) {
		this.apprerno = value;
	}
	
	public java.lang.String getApprerno() {
		return this.apprerno;
	}
	public void setApprernm(java.lang.String value) {
		this.apprernm = value;
	}
	
	public java.lang.String getApprernm() {
		return this.apprernm;
	}
	public void setApprerdptno(java.lang.String value) {
		this.apprerdptno = value;
	}
	
	public java.lang.String getApprerdptno() {
		return this.apprerdptno;
	}
	public void setApprdt(java.lang.String value) {
		this.apprdt = value;
	}
	
	public java.lang.String getApprdt() {
		return this.apprdt;
	}
	public void setApprtm(java.lang.String value) {
		this.apprtm = value;
	}
	
	public java.lang.String getApprtm() {
		return this.apprtm;
	}
	public void setRtrnflg(java.lang.String value) {
		this.rtrnflg = value;
	}
	
	public java.lang.String getRtrnflg() {
		return this.rtrnflg;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Applyno",getApplyno())
			.append("Srlno",getSrlno())
			.append("Cmmntypeno",getCmmntypeno())
			.append("Appredamnt",getAppredamnt())
			.append("Appredrt",getAppredrt())
			.append("Cmmntdes",getCmmntdes())
			.append("Curstep",getCurstep())
			.append("Nextstep",getNextstep())
			.append("Apprstt",getApprstt())
			.append("Apprerno",getApprerno())
			.append("Apprernm",getApprernm())
			.append("Apprerdptno",getApprerdptno())
			.append("Apprdt",getApprdt())
			.append("Apprtm",getApprtm())
			.append("Rtrnflg",getRtrnflg())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getApplyno())
			.append(getSrlno())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof FlowApprlcmmnts == false) return false;
		if(this == obj) return true;
		FlowApprlcmmnts other = (FlowApprlcmmnts)obj;
		return new EqualsBuilder()
			.append(getApplyno(),other.getApplyno())
			.append(getSrlno(),other.getSrlno())
			.isEquals();
	}
}

