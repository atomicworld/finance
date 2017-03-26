/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.entity;


/**
 * @author xujiuhua
 * @2014-12-24
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class ClntEe implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "对公(企业)客户";
	public static final String ALIAS_CLNTNO = "客户号";
	public static final String ALIAS_CLNTNAMEONCE = "客户曾用名";
	public static final String ALIAS_CLNTNAMEENG = "客户英文名";
	public static final String ALIAS_CLNTCATEGORY = "客户类别";
	public static final String ALIAS_LNCARDNO = "贷款卡编码";
	public static final String ALIAS_DEPTCODE = "机构代码";
	public static final String ALIAS_FINACODE = "金融机构代码";
	public static final String ALIAS_BUSSDATE = "业务发生日期";
	public static final String ALIAS_BNATION = "企业国别";
	public static final String ALIAS_BPROP = "企业性质1";
	public static final String ALIAS_BPROP2 = "企业性质2";
	public static final String ALIAS_BCHARAC = "企业规模";
	public static final String ALIAS_CLNTAREA = "企业所属地区";
	public static final String ALIAS_ZIP = "邮政编码";
	public static final String ALIAS_INDUCLASS = "行业分类";
	public static final String ALIAS_ESTABLISH = "成立时间";
	public static final String ALIAS_EMPNUM = "从业人数";
	public static final String ALIAS_GRPCUSTFG = "集团客户标志";
	public static final String ALIAS_FORTDRTFG = "进出口权标志";
	public static final String ALIAS_MKTCORFG = "上市公司标志";
	public static final String ALIAS_LASTMODDATE = "更新日期";
	public static final String ALIAS_GRADEMODEL = "评分模式";
	public static final String ALIAS_STAT = "状态标识";
	public static final String ALIAS_CHANGEDATE = "状态变化时间";
	public static final String ALIAS_MSGNO = "报文编号";
	public static final String ALIAS_BATCHNO = "批次号";
	public static final String ALIAS_VALITYFLAG = "有效标识";
	
	//date formats
	
	public ClntEe(){
	}

	public ClntEe(
		java.lang.String clntno
	){
		this.clntno = clntno;
	}

	
	//columns START
	/**客户号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**客户曾用名==>db_column: CLNTNAMEONCE*/
	private java.lang.String clntnameonce;
	/**客户英文名==>db_column: CLNTNAMEENG*/
	private java.lang.String clntnameeng;
	/**客户类别==>db_column: CLNTCATEGORY*/
	private java.lang.String clntcategory;
	/**贷款卡编码==>db_column: LNCARDNO*/
	private java.lang.String lncardno;
	/**机构代码==>db_column: DEPTCODE*/
	private java.lang.String deptcode;
	/**金融机构代码==>db_column: FINACODE*/
	private java.lang.String finacode;
	/**业务发生日期==>db_column: BUSSDATE*/
	private java.lang.String bussdate;
	/**企业国别==>db_column: BNATION*/
	private java.lang.String bnation;
	/**企业性质1==>db_column: BPROP*/
	private java.lang.String bprop;
	/**企业性质2==>db_column: BPROP2*/
	private java.lang.String bprop2;
	/**企业规模==>db_column: BCHARAC*/
	private java.lang.String bcharac;
	/**企业所属地区==>db_column: CLNTAREA*/
	private java.lang.String clntarea;
	/**邮政编码==>db_column: ZIP*/
	private java.lang.String zip;
	/**行业分类==>db_column: INDUCLASS*/
	private java.lang.String induclass;
	/**成立时间==>db_column: ESTABLISH*/
	private java.lang.String establish;
	/**从业人数==>db_column: EMPNUM*/
	private java.lang.Integer empnum;
	/**集团客户标志==>db_column: GRPCUSTFG*/
	private java.lang.String grpcustfg;
	/**进出口权标志==>db_column: FORTDRTFG*/
	private java.lang.String fortdrtfg;
	/**上市公司标志==>db_column: MKTCORFG*/
	private java.lang.String mktcorfg;
	/**更新日期==>db_column: LASTMODDATE*/
	private java.lang.String lastmoddate;
	/**评分模式==>db_column: GRADEMODEL*/
	private java.lang.String grademodel;
	/**状态标识==>db_column: STAT*/
	private java.lang.String stat;
	/**状态变化时间==>db_column: CHANGEDATE*/
	private java.lang.String changedate;
	/**报文编号==>db_column: MSGNO*/
	private java.lang.Integer msgno;
	/**批次号==>db_column: BATCHNO*/
	private java.lang.Integer batchno;
	/**有效标识==>db_column: VALITYFLAG*/
	private java.lang.String valityflag;
	/**所属银行==>db_column: bankcode*/
	private java.lang.String bankcode;
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
	public void setClntnameonce(java.lang.String value) {
		this.clntnameonce = value;
	}
	
	public java.lang.String getClntnameonce() {
		return this.clntnameonce;
	}
	public void setClntnameeng(java.lang.String value) {
		this.clntnameeng = value;
	}
	
	public java.lang.String getClntnameeng() {
		return this.clntnameeng;
	}
	public void setClntcategory(java.lang.String value) {
		this.clntcategory = value;
	}
	
	public java.lang.String getClntcategory() {
		return this.clntcategory;
	}
	public void setLncardno(java.lang.String value) {
		this.lncardno = value;
	}
	
	public java.lang.String getLncardno() {
		return this.lncardno;
	}
	public void setDeptcode(java.lang.String value) {
		this.deptcode = value;
	}
	
	public java.lang.String getDeptcode() {
		return this.deptcode;
	}
	public void setFinacode(java.lang.String value) {
		this.finacode = value;
	}
	
	public java.lang.String getFinacode() {
		return this.finacode;
	}
	public void setBussdate(java.lang.String value) {
		this.bussdate = value;
	}
	
	public java.lang.String getBussdate() {
		return this.bussdate;
	}
	public void setBnation(java.lang.String value) {
		this.bnation = value;
	}
	
	public java.lang.String getBnation() {
		return this.bnation;
	}
	public void setBprop(java.lang.String value) {
		this.bprop = value;
	}
	
	public java.lang.String getBprop() {
		return this.bprop;
	}
	public void setBprop2(java.lang.String value) {
		this.bprop2 = value;
	}
	
	public java.lang.String getBprop2() {
		return this.bprop2;
	}
	public void setBcharac(java.lang.String value) {
		this.bcharac = value;
	}
	
	public java.lang.String getBcharac() {
		return this.bcharac;
	}
	public void setClntarea(java.lang.String value) {
		this.clntarea = value;
	}
	
	public java.lang.String getClntarea() {
		return this.clntarea;
	}
	public void setZip(java.lang.String value) {
		this.zip = value;
	}
	
	public java.lang.String getZip() {
		return this.zip;
	}
	public void setInduclass(java.lang.String value) {
		this.induclass = value;
	}
	
	public java.lang.String getInduclass() {
		return this.induclass;
	}
	public void setEstablish(java.lang.String value) {
		this.establish = value;
	}
	
	public java.lang.String getEstablish() {
		return this.establish;
	}
	public void setEmpnum(java.lang.Integer value) {
		this.empnum = value;
	}
	
	public java.lang.Integer getEmpnum() {
		return this.empnum;
	}
	public void setGrpcustfg(java.lang.String value) {
		this.grpcustfg = value;
	}
	
	public java.lang.String getGrpcustfg() {
		return this.grpcustfg;
	}
	public void setFortdrtfg(java.lang.String value) {
		this.fortdrtfg = value;
	}
	
	public java.lang.String getFortdrtfg() {
		return this.fortdrtfg;
	}
	public void setMktcorfg(java.lang.String value) {
		this.mktcorfg = value;
	}
	
	public java.lang.String getMktcorfg() {
		return this.mktcorfg;
	}
	public void setLastmoddate(java.lang.String value) {
		this.lastmoddate = value;
	}
	
	public java.lang.String getLastmoddate() {
		return this.lastmoddate;
	}
	public void setGrademodel(java.lang.String value) {
		this.grademodel = value;
	}
	
	public java.lang.String getGrademodel() {
		return this.grademodel;
	}
	public void setStat(java.lang.String value) {
		this.stat = value;
	}
	
	public java.lang.String getStat() {
		return this.stat;
	}
	public void setChangedate(java.lang.String value) {
		this.changedate = value;
	}
	
	public java.lang.String getChangedate() {
		return this.changedate;
	}
	public void setMsgno(java.lang.Integer value) {
		this.msgno = value;
	}
	
	public java.lang.Integer getMsgno() {
		return this.msgno;
	}
	public void setBatchno(java.lang.Integer value) {
		this.batchno = value;
	}
	
	public java.lang.Integer getBatchno() {
		return this.batchno;
	}
	public void setValityflag(java.lang.String value) {
		this.valityflag = value;
	}
	
	public java.lang.String getValityflag() {
		return this.valityflag;
	}

	public void setBankcode(java.lang.String bankcode) {
		this.bankcode = bankcode;
	}

	public java.lang.String getBankcode() {
		return bankcode;
	}
}

