/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.flowmng.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;



public class FlowApprlBase {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "FlowApprlBase";
	public static final String ALIAS_FLOWNO = "审批流程编号";
	public static final String ALIAS_APPRLTYP = "审批类型";
	public static final String ALIAS_FLOWNM = "审批流程名称";
	public static final String ALIAS_BSNSPRDTNO = "涵盖业务产品种类";
	public static final String ALIAS_BSNSMINMNTH = "业务最小期限月";
	public static final String ALIAS_BSNSMAXMNTH = "业务最大期限月";
	public static final String ALIAS_ASSRTYP = "担保类型";
	public static final String ALIAS_MINAMNT = "MINAMNT";
	public static final String ALIAS_MAXAMNT = "MAXAMNT";
	public static final String ALIAS_CSTMRTYP = "客户类型";
	public static final String ALIAS_MNGDPTNO = "开办部门";
	public static final String ALIAS_CRTDATE = "创建日期";
	public static final String ALIAS_UPDTDATE = "更新日期";
	public static final String ALIAS_FLOWSTEPS = "流程步骤";
	public static final String ALIAS_BSNSTYP = "业务形式";
	public static final String ALIAS_BSNSMINDAY = "业务最小期限日";
	public static final String ALIAS_BSNSMAXDAY = "业务最大期限日";
	
	//date formats
	
	public FlowApprlBase(){
	}

	public FlowApprlBase(
		java.lang.String flowno
	){
		this.flowno = flowno;
	}

	
	//columns START
	/**审批流程编号==>db_column: FLOWNO*/
	private java.lang.String flowno;
	/**审批类型==>db_column: APPRLTYP*/
	private java.lang.String apprltyp;
	/**审批流程名称==>db_column: FLOWNM*/
	private java.lang.String flownm;
	/**涵盖业务产品种类==>db_column: BSNSPRDTNO*/
	private java.lang.String bsnsprdtno;
	/**业务最小期限月==>db_column: BSNSMINMNTH*/
	private java.lang.String bsnsminmnth;
	/**业务最大期限月==>db_column: BSNSMAXMNTH*/
	private java.lang.String bsnsmaxmnth;
	/**担保类型==>db_column: ASSRTYP*/
	private java.lang.String assrtyp;
	/**MINAMNT==>db_column: MINAMNT*/
	private Long minamnt;
	/**MAXAMNT==>db_column: MAXAMNT*/
	private Long maxamnt;
	/**客户类型==>db_column: CSTMRTYP*/
	private java.lang.String cstmrtyp;
	/**开办部门==>db_column: MNGDPTNO*/
	private java.lang.String mngdptno;
	/**创建日期==>db_column: CRTDATE*/
	private java.lang.String crtdate;
	/**更新日期==>db_column: UPDTDATE*/
	private java.lang.String updtdate;
	/**流程步骤==>db_column: FLOWSTEPS*/
	private java.lang.String flowsteps;
	/**业务形式==>db_column: BSNSTYP*/
	private java.lang.String bsnstyp;
	/**业务最小期限日==>db_column: BSNSMINDAY*/
	private java.lang.String bsnsminday;
	/**业务最大期限日==>db_column: BSNSMAXDAY*/
	private java.lang.String bsnsmaxday;
	private String flowdsgninf;
	
	private Integer num; //是否已使用
	//columns END
	
	//系统框架字段 start
	
	public String getFlowdsgninf() {
		return flowdsgninf;
	}

	public void setFlowdsgninf(String flowdsgninf) {
		this.flowdsgninf = flowdsgninf;
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

	public void setFlowno(java.lang.String value) {
		this.flowno = value;
	}
	
	public java.lang.String getFlowno() {
		return this.flowno;
	}
	public void setApprltyp(java.lang.String value) {
		this.apprltyp = value;
	}
	
	public java.lang.String getApprltyp() {
		return this.apprltyp;
	}
	public void setFlownm(java.lang.String value) {
		this.flownm = value;
	}
	
	public java.lang.String getFlownm() {
		return this.flownm;
	}
	public void setBsnsprdtno(java.lang.String value) {
		this.bsnsprdtno = value;
	}
	
	public java.lang.String getBsnsprdtno() {
		return this.bsnsprdtno;
	}
	public void setBsnsminmnth(java.lang.String value) {
		this.bsnsminmnth = value;
	}
	
	public java.lang.String getBsnsminmnth() {
		return this.bsnsminmnth;
	}
	public void setBsnsmaxmnth(java.lang.String value) {
		this.bsnsmaxmnth = value;
	}
	
	public java.lang.String getBsnsmaxmnth() {
		return this.bsnsmaxmnth;
	}
	public void setAssrtyp(java.lang.String value) {
		this.assrtyp = value;
	}
	
	public java.lang.String getAssrtyp() {
		return this.assrtyp;
	}
	public void setMinamnt(Long value) {
		this.minamnt = value;
	}
	
	public Long getMinamnt() {
		return this.minamnt;
	}
	public void setMaxamnt(Long value) {
		this.maxamnt = value;
	}
	
	public Long getMaxamnt() {
		return this.maxamnt;
	}
	public void setCstmrtyp(java.lang.String value) {
		this.cstmrtyp = value;
	}
	
	public java.lang.String getCstmrtyp() {
		return this.cstmrtyp;
	}
	public void setMngdptno(java.lang.String value) {
		this.mngdptno = value;
	}
	
	public java.lang.String getMngdptno() {
		return this.mngdptno;
	}
	public void setCrtdate(java.lang.String value) {
		this.crtdate = value;
	}
	
	public java.lang.String getCrtdate() {
		return this.crtdate;
	}
	public void setUpdtdate(java.lang.String value) {
		this.updtdate = value;
	}
	
	public java.lang.String getUpdtdate() {
		return this.updtdate;
	}
	public void setFlowsteps(java.lang.String value) {
		this.flowsteps = value;
	}
	
	public java.lang.String getFlowsteps() {
		return this.flowsteps;
	}
	public void setBsnstyp(java.lang.String value) {
		this.bsnstyp = value;
	}
	
	public java.lang.String getBsnstyp() {
		return this.bsnstyp;
	}
	public void setBsnsminday(java.lang.String value) {
		this.bsnsminday = value;
	}
	
	public java.lang.String getBsnsminday() {
		return this.bsnsminday;
	}
	public void setBsnsmaxday(java.lang.String value) {
		this.bsnsmaxday = value;
	}
	
	public java.lang.String getBsnsmaxday() {
		return this.bsnsmaxday;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Flowno",getFlowno())
			.append("Apprltyp",getApprltyp())
			.append("Flownm",getFlownm())
			.append("Bsnsprdtno",getBsnsprdtno())
			.append("Bsnsminmnth",getBsnsminmnth())
			.append("Bsnsmaxmnth",getBsnsmaxmnth())
			.append("Assrtyp",getAssrtyp())
			.append("Minamnt",getMinamnt())
			.append("Maxamnt",getMaxamnt())
			.append("Cstmrtyp",getCstmrtyp())
			.append("Mngdptno",getMngdptno())
			.append("Crtdate",getCrtdate())
			.append("Updtdate",getUpdtdate())
			.append("Flowsteps",getFlowsteps())
			.append("Bsnstyp",getBsnstyp())
			.append("Bsnsminday",getBsnsminday())
			.append("Bsnsmaxday",getBsnsmaxday())
			.append("FLOWDSGNINF",getFlowdsgninf())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getFlowno())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof FlowApprlBase == false) return false;
		if(this == obj) return true;
		FlowApprlBase other = (FlowApprlBase)obj;
		return new EqualsBuilder()
			.append(getFlowno(),other.getFlowno())
			.isEquals();
	}
}

