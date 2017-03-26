/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.entity;

import java.math.BigDecimal;


/**
 * @author xujiuhua
 * @2014-12-18
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class ClntPersonEvaluate implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "基础评估";
	public static final String ALIAS_CLNTNO = "客户号";
	public static final String ALIAS_AGESCR = "年龄得分";
	public static final String ALIAS_SEXSCR = "性别得分";
	public static final String ALIAS_MARRIAGESCR = "婚姻状况得分";
	public static final String ALIAS_HEALTHSCR = "健康状况得分";
	public static final String ALIAS_EDULEVELSCR = "文化程度得分";
	public static final String ALIAS_HOUSEHOLDSCR = "户口性质得分";
	public static final String ALIAS_DUTYSCR = "行政职务得分";
	public static final String ALIAS_FAMILYNUMSCR = "家庭人口得分";
	public static final String ALIAS_OCCTYPESCR = "单位性质得分";
	public static final String ALIAS_CASTESCR = "职称得分";
	public static final String ALIAS_WORKTIMESSCR = "工作年限得分";
	public static final String ALIAS_BELONGEMPSCR = "是否本公司员工得分";
	public static final String ALIAS_MONTYLYINCOMESCR = "月收入得分";
	public static final String ALIAS_BUSINESSCONTACT = "业务往来得分";
	public static final String ALIAS_TOTALSCR = "总分";
	
	//date formats
	
	public ClntPersonEvaluate(){
	}

	public ClntPersonEvaluate(
		java.lang.String clntno
	){
		this.clntno = clntno;
	}

	
	//columns START
	/**客户号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**年龄得分==>db_column: AGESCR*/
	private BigDecimal agescr;
	/**性别得分==>db_column: SEXSCR*/
	private BigDecimal sexscr;
	/**婚姻状况得分==>db_column: MARRIAGESCR*/
	private BigDecimal marriagescr;
	/**健康状况得分==>db_column: HEALTHSCR*/
	private BigDecimal healthscr;
	/**文化程度得分==>db_column: EDULEVELSCR*/
	private BigDecimal edulevelscr;
	/**户口性质得分==>db_column: HOUSEHOLDSCR*/
	private BigDecimal householdscr;
	/**行政职务得分==>db_column: DUTYSCR*/
	private BigDecimal dutyscr;
	/**家庭人口得分==>db_column: FAMILYNUMSCR*/
	private BigDecimal familynumscr;
	/**单位性质得分==>db_column: OCCTYPESCR*/
	private BigDecimal occtypescr;
	/**职称得分==>db_column: CASTESCR*/
	private BigDecimal castescr;
	/**工作年限得分==>db_column: WORKTIMESSCR*/
	private BigDecimal worktimesscr;
	/**是否本公司员工得分==>db_column: BEBigDecimalEMPSCR*/
	private BigDecimal beBigDecimalempscr;
	/**月收入得分==>db_column: MONTYLYINCOMESCR*/
	private BigDecimal montylyincomescr;
	/**业务往来得分==>db_column: BUSINESSCONTACT*/
	private BigDecimal businesscontact;
	/**总分==>db_column: TOTALSCR*/
	private BigDecimal totalscr;
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

	public BigDecimal getAgescr() {
		return agescr;
	}

	public void setAgescr(BigDecimal agescr) {
		this.agescr = agescr;
	}

	public BigDecimal getSexscr() {
		return sexscr;
	}

	public void setSexscr(BigDecimal sexscr) {
		this.sexscr = sexscr;
	}

	public BigDecimal getMarriagescr() {
		return marriagescr;
	}

	public void setMarriagescr(BigDecimal marriagescr) {
		this.marriagescr = marriagescr;
	}

	public BigDecimal getHealthscr() {
		return healthscr;
	}

	public void setHealthscr(BigDecimal healthscr) {
		this.healthscr = healthscr;
	}

	public BigDecimal getEdulevelscr() {
		return edulevelscr;
	}

	public void setEdulevelscr(BigDecimal edulevelscr) {
		this.edulevelscr = edulevelscr;
	}

	public BigDecimal getHouseholdscr() {
		return householdscr;
	}

	public void setHouseholdscr(BigDecimal householdscr) {
		this.householdscr = householdscr;
	}

	public BigDecimal getDutyscr() {
		return dutyscr;
	}

	public void setDutyscr(BigDecimal dutyscr) {
		this.dutyscr = dutyscr;
	}

	public BigDecimal getFamilynumscr() {
		return familynumscr;
	}

	public void setFamilynumscr(BigDecimal familynumscr) {
		this.familynumscr = familynumscr;
	}

	public BigDecimal getOcctypescr() {
		return occtypescr;
	}

	public void setOcctypescr(BigDecimal occtypescr) {
		this.occtypescr = occtypescr;
	}

	public BigDecimal getCastescr() {
		return castescr;
	}

	public void setCastescr(BigDecimal castescr) {
		this.castescr = castescr;
	}

	public BigDecimal getWorktimesscr() {
		return worktimesscr;
	}

	public void setWorktimesscr(BigDecimal worktimesscr) {
		this.worktimesscr = worktimesscr;
	}

	public BigDecimal getBeBigDecimalempscr() {
		return beBigDecimalempscr;
	}

	public void setBeBigDecimalempscr(BigDecimal beBigDecimalempscr) {
		this.beBigDecimalempscr = beBigDecimalempscr;
	}

	public BigDecimal getMontylyincomescr() {
		return montylyincomescr;
	}

	public void setMontylyincomescr(BigDecimal montylyincomescr) {
		this.montylyincomescr = montylyincomescr;
	}

	public BigDecimal getBusinesscontact() {
		return businesscontact;
	}

	public void setBusinesscontact(BigDecimal businesscontact) {
		this.businesscontact = businesscontact;
	}

	public BigDecimal getTotalscr() {
		return totalscr;
	}

	public void setTotalscr(BigDecimal totalscr) {
		this.totalscr = totalscr;
	}
}

