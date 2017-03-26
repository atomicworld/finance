package com.mf.sys.entity;

import java.io.Serializable;

public class SysDictionary implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8985904712818417580L;
	private int id;
	private String code;
	private String sdkey;
	private String sdvalue;
	private String remark;
	private String name;
	
	//chenze start
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	//chenze end
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SysDictionary() {
		super();
	}

	public SysDictionary(int id, String code, String sdkey, String sdvalue,
			String remark) {
		super();
		this.id = id;
		this.code = code;
		this.sdkey = sdkey;
		this.sdvalue = sdvalue;
		this.remark = remark;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSdkey() {
		return sdkey;
	}

	public void setSdkey(String sdkey) {
		this.sdkey = sdkey;
	}

	public String getSdvalue() {
		return sdvalue;
	}

	public void setSdvalue(String sdvalue) {
		this.sdvalue = sdvalue;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
