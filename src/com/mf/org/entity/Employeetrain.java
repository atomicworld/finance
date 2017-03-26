package com.mf.org.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.mf.base.BaseEntity;

/**
 * @author hw
 * @2015-08-21
 */

public class Employeetrain extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Employeetrain";
	public static final String ALIAS_TRAINNO = "人员培训编号";
	public static final String ALIAS_STARTDT = "培训开始日期";
	public static final String ALIAS_ENDDT = "培训结束日期";
	public static final String ALIAS_HOURS = "学时（小时）";
	public static final String ALIAS_NUMOFPEOPLE = "人数";
	public static final String ALIAS_PROJECT = "培训项目";
	public static final String ALIAS_SPONSOR = "项目主办单位";
	public static final String ALIAS_CONTENT = "培训内容";
	public static final String ALIAS_TRAINPLACE = "培训地点";
	public static final String ALIAS_TRAINER = "培训老师";
	
	//date formats
	
	public Employeetrain(){
	}

	public Employeetrain(
		java.lang.String trainno
	){
		this.trainno = trainno;
	}

	
	//columns START
	/**人员培训编号==>db_column: trainno*/
	private java.lang.String trainno;
	/**培训开始日期==>db_column: startdt*/
	private java.lang.String startdt;
	/**培训结束日期==>db_column: enddt*/
	private java.lang.String enddt;
	/**学时（小时）==>db_column: hours*/
	private java.lang.String hours;
	/**人数==>db_column: numofpeople*/
	private java.lang.String numofpeople;
	/**培训项目==>db_column: project*/
	private java.lang.String project;
	/**项目主办单位==>db_column: sponsor*/
	private java.lang.String sponsor;
	/**培训内容==>db_column: content*/
	private java.lang.String content;
	/**培训地点==>db_column: trainplace*/
	private java.lang.String trainplace;
	/**培训老师==>db_column: trainer*/
	private java.lang.String trainer;
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

	public void setTrainno(java.lang.String value) {
		this.trainno = value;
	}
	
	public java.lang.String getTrainno() {
		return this.trainno;
	}
	public void setStartdt(java.lang.String value) {
		this.startdt = value;
	}
	
	public java.lang.String getStartdt() {
		return this.startdt;
	}
	public void setEnddt(java.lang.String value) {
		this.enddt = value;
	}
	
	public java.lang.String getEnddt() {
		return this.enddt;
	}
	public void setHours(java.lang.String value) {
		this.hours = value;
	}
	
	public java.lang.String getHours() {
		return this.hours;
	}
	public void setNumofpeople(java.lang.String value) {
		this.numofpeople = value;
	}
	
	public java.lang.String getNumofpeople() {
		return this.numofpeople;
	}
	public void setProject(java.lang.String value) {
		this.project = value;
	}
	
	public java.lang.String getProject() {
		return this.project;
	}
	public void setSponsor(java.lang.String value) {
		this.sponsor = value;
	}
	
	public java.lang.String getSponsor() {
		return this.sponsor;
	}
	public void setContent(java.lang.String value) {
		this.content = value;
	}
	
	public java.lang.String getContent() {
		return this.content;
	}
	public void setTrainplace(java.lang.String value) {
		this.trainplace = value;
	}
	
	public java.lang.String getTrainplace() {
		return this.trainplace;
	}
	public void setTrainer(java.lang.String value) {
		this.trainer = value;
	}
	
	public java.lang.String getTrainer() {
		return this.trainer;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Trainno",getTrainno())
			.append("Startdt",getStartdt())
			.append("Enddt",getEnddt())
			.append("Hours",getHours())
			.append("Numofpeople",getNumofpeople())
			.append("Project",getProject())
			.append("Sponsor",getSponsor())
			.append("Content",getContent())
			.append("Trainplace",getTrainplace())
			.append("Trainer",getTrainer())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getTrainno())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Employeetrain == false) return false;
		if(this == obj) return true;
		Employeetrain other = (Employeetrain)obj;
		return new EqualsBuilder()
			.append(getTrainno(),other.getTrainno())
			.isEquals();
	}
}

