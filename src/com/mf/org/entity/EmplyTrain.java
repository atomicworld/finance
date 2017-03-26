package com.mf.org.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.mf.base.BaseEntity;
import com.mf.org.entity.*;
import com.mf.util.*;

/**
 * @author hw
 * @2015-08-24
 */

public class EmplyTrain extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "EmplyTrain";
	public static final String ALIAS_ID = "主键";
	public static final String ALIAS_TRAINNO = "trainno";
	public static final String ALIAS_EMPLYNO = "emplyno";
	public static final String ALIAS_SCORE = "score";
	public static final String ALIAS_RESULT = "result";
	public static final String ALIAS_REMARK = "remark";
	
	//date formats
	
	public EmplyTrain(){
	}

	public EmplyTrain(java.lang.String id){
		this.id = id;
	}

	
	//columns START
	/**主键==>db_column: id*/
	private java.lang.String id;
	/**trainno==>db_column: trainno*/
	private java.lang.String trainno;
	/**emplyno==>db_column: emplyno*/
	private java.lang.String emplyno;
	/**score==>db_column: score*/
	private java.lang.String score;
	/**result==>db_column: result*/
	private java.lang.String result;
	/**remark==>db_column: remark*/
	private java.lang.String remark;
	/**emplynm==>db_column: emplynm*/
	private java.lang.String emplynm;
	/**idnum==>db_column: idnum*/
	private java.lang.String idnum;
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

	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	public java.lang.String getId() {
		return this.id;
	}
	public void setTrainno(java.lang.String value) {
		this.trainno = value;
	}
	
	public java.lang.String getTrainno() {
		return this.trainno;
	}
	public void setEmplyno(java.lang.String value) {
		this.emplyno = value;
	}
	
	public java.lang.String getEmplyno() {
		return this.emplyno;
	}
	public void setScore(java.lang.String value) {
		this.score = value;
	}
	
	public java.lang.String getScore() {
		return this.score;
	}
	public void setResult(java.lang.String value) {
		this.result = value;
	}
	
	public java.lang.String getResult() {
		return this.result;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}
	

	public java.lang.String getEmplynm() {
		return emplynm;
	}

	public void setEmplynm(java.lang.String emplynm) {
		this.emplynm = emplynm;
	}

	public java.lang.String getIdnum() {
		return idnum;
	}

	public void setIdnum(java.lang.String idnum) {
		this.idnum = idnum;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Trainno",getTrainno())
			.append("Emplyno",getEmplyno())
			.append("Score",getScore())
			.append("Result",getResult())
			.append("Remark",getRemark())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof EmplyTrain == false) return false;
		if(this == obj) return true;
		EmplyTrain other = (EmplyTrain)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

