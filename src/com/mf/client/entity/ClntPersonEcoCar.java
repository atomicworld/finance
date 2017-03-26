/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.entity;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author xujiuhua
 * @2014-12-29
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class ClntPersonEcoCar implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "车辆资产";
	public static final String ALIAS_ID = "ID";
	public static final String ALIAS_CLNTNO = "客户号";
	public static final String ALIAS_CARTYPE = "车辆种类";
	public static final String ALIAS_CARCARD = "车辆牌号";
	public static final String ALIAS_CARBRAND = "车辆品牌";
	public static final String ALIAS_CARMODEL = "型号";
	public static final String ALIAS_CARFRAMENO = "车架号";
	public static final String ALIAS_ENGINENO = "发动机号";
	public static final String ALIAS_RUNSUM = "车辆行驶公里数";
	public static final String ALIAS_BUYFLAG = "购买情况";
	public static final String ALIAS_BUYAMT = "购买金额";
	public static final String ALIAS_BUYDATE = "购买日期";
	public static final String ALIAS_DEBTAMT = "贷款或欠款金额";
	public static final String ALIAS_USEFLAG = "使用状态";
	public static final String ALIAS_REMARK = "备注";
	
	//date formats
	
	public ClntPersonEcoCar(){
	}

	public ClntPersonEcoCar(
		java.lang.Integer id
	){
		this.id = id;
	}

	
	//columns START
	/**ID==>db_column: ID*/
	private java.lang.Integer id;
	/**客户号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**车辆种类==>db_column: CARTYPE*/
	private java.lang.String cartype;
	/**车辆牌号==>db_column: CARCARD*/
	private java.lang.String carcard;
	/**车辆品牌==>db_column: CARBRAND*/
	private java.lang.String carbrand;
	/**型号==>db_column: CARMODEL*/
	private java.lang.String carmodel;
	/**车架号==>db_column: CARFRAMENO*/
	private java.lang.String carframeno;
	/**发动机号==>db_column: ENGINENO*/
	private java.lang.String engineno;
	/**车辆行驶公里数==>db_column: RUNSUM*/
	private BigDecimal runsum;
	/**购买情况==>db_column: BUYFLAG*/
	private java.lang.String buyflag;
	/**购买金额==>db_column: BUYAMT*/
	private BigDecimal buyamt;
	/**购买日期==>db_column: BUYDATE*/
	private java.lang.String buydate;
	/**贷款或欠款金额==>db_column: DEBTAMT*/
	private BigDecimal debtamt;
	/**使用状态==>db_column: USEFLAG*/
	private java.lang.String useflag;
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

	public void setId(java.lang.Integer value) {
		this.id = value;
	}
	
	public java.lang.Integer getId() {
		return this.id;
	}
	public void setClntno(java.lang.String value) {
		this.clntno = value;
	}
	
	public java.lang.String getClntno() {
		return this.clntno;
	}
	public void setCartype(java.lang.String value) {
		this.cartype = value;
	}
	
	public java.lang.String getCartype() {
		return this.cartype;
	}
	public void setCarcard(java.lang.String value) {
		this.carcard = value;
	}
	
	public java.lang.String getCarcard() {
		return this.carcard;
	}
	public void setCarbrand(java.lang.String value) {
		this.carbrand = value;
	}
	
	public java.lang.String getCarbrand() {
		return this.carbrand;
	}
	public void setCarmodel(java.lang.String value) {
		this.carmodel = value;
	}
	
	public java.lang.String getCarmodel() {
		return this.carmodel;
	}
	public void setCarframeno(java.lang.String value) {
		this.carframeno = value;
	}
	
	public java.lang.String getCarframeno() {
		return this.carframeno;
	}
	public void setEngineno(java.lang.String value) {
		this.engineno = value;
	}
	
	public java.lang.String getEngineno() {
		return this.engineno;
	}
	
	public void setBuyflag(java.lang.String value) {
		this.buyflag = value;
	}
	
	public java.lang.String getBuyflag() {
		return this.buyflag;
	}
	
	public void setBuydate(java.lang.String value) {
		this.buydate = value;
	}
	
	public java.lang.String getBuydate() {
		return this.buydate;
	}
	
	public BigDecimal getRunsum() {
		return runsum;
	}

	public void setRunsum(BigDecimal runsum) {
		this.runsum = runsum;
	}

	public BigDecimal getBuyamt() {
		return buyamt;
	}

	public void setBuyamt(BigDecimal buyamt) {
		this.buyamt = buyamt;
	}

	public BigDecimal getDebtamt() {
		return debtamt;
	}

	public void setDebtamt(BigDecimal debtamt) {
		this.debtamt = debtamt;
	}

	public void setUseflag(java.lang.String value) {
		this.useflag = value;
	}
	
	public java.lang.String getUseflag() {
		return this.useflag;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Clntno",getClntno())
			.append("Cartype",getCartype())
			.append("Carcard",getCarcard())
			.append("Carbrand",getCarbrand())
			.append("Carmodel",getCarmodel())
			.append("Carframeno",getCarframeno())
			.append("Engineno",getEngineno())
			.append("Runsum",getRunsum())
			.append("Buyflag",getBuyflag())
			.append("Buyamt",getBuyamt())
			.append("Buydate",getBuydate())
			.append("Debtamt",getDebtamt())
			.append("Useflag",getUseflag())
			.append("Remark",getRemark())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ClntPersonEcoCar == false) return false;
		if(this == obj) return true;
		ClntPersonEcoCar other = (ClntPersonEcoCar)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

