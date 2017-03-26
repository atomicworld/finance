package com.mf.sys.entity;

public class SysLog {

	private String optype;// 操作行为
	private String opobject;// 操作具体对象
	private String optable;// 操作具体对象的表名
	private String optime;// 操作执行的时间
	private String oporg;// 操作员所在机构
	private String opperson;// 操作员
	
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

	public String getOptype() {
		return optype;
	}

	public void setOptype(String optype) {
		this.optype = optype;
	}

	public String getOpobject() {
		return opobject;
	}

	public void setOpobject(String opobject) {
		this.opobject = opobject;
	}

	public String getOptable() {
		return optable;
	}

	public void setOptable(String optable) {
		this.optable = optable;
	}

	public String getOptime() {
		return optime;
	}

	public void setOptime(String optime) {
		this.optime = optime;
	}

	public String getOporg() {
		return oporg;
	}

	public void setOporg(String oporg) {
		this.oporg = oporg;
	}

	public String getOpperson() {
		return opperson;
	}

	public void setOpperson(String opperson) {
		this.opperson = opperson;
	}
}
