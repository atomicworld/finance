/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.entity;


/**
 * @author liuchuanwu
 * @2014-12-10
 * @Email: liu.cw@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class ClntPersonJob implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	
	public ClntPersonJob(){
	}

	
	//columns START
	private int id;
	/**客户号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**职业==>db_column: OCCUPATION*/
	private java.lang.String occupation;
	/**是否本公司员工==>db_column: BELONGEMP*/
	private java.lang.String belongemp;
	/**是否本公司股东==>db_column: BELONGSHRHLDR*/
	private java.lang.String belongshrhldr;
	/**单位名称==>db_column: COMPANY*/
	private java.lang.String company;
	/**单位所属行业==>db_column: INDUSTRY*/
	private java.lang.String industry;
	/**单位性质==>db_column: OCCTYPE*/
	private java.lang.String occtype;
	/**单位电话==>db_column: OCCTEL*/
	private java.lang.String occtel;
	/**单位邮政编码==>db_column: OCCZIP*/
	private java.lang.String occzip;
	/**所在单位工作起始年份==>db_column: STARTYEAR*/
	private java.lang.String startyear;
	/**单位地址==>db_column: OCCADDRESS*/
	private java.lang.String occaddress;
	/**职务==>db_column: DUTY*/
	private java.lang.String duty;
	/**职称==>db_column: CASTE*/
	private java.lang.String caste;
	/**职务级别==>db_column: DUTYLEVEL*/
	private java.lang.String dutylevel;
	/**下岗失业人员优惠证号码==>db_column: LAYOFFSNO*/
	private java.lang.String layoffsno;
	/**工资账户开户银行==>db_column: WAGEBANK*/
	private java.lang.String wagebank;
	/**工资账号==>db_column: WAGENO*/
	private java.lang.String wageno;
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
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setClntno(java.lang.String value) {
		this.clntno = value;
	}
	

	public java.lang.String getClntno() {
		return this.clntno;
	}
	public void setOccupation(java.lang.String value) {
		this.occupation = value;
	}
	
	public java.lang.String getOccupation() {
		return this.occupation;
	}
	public void setBelongemp(java.lang.String value) {
		this.belongemp = value;
	}
	
	public java.lang.String getBelongemp() {
		return this.belongemp;
	}
	public void setBelongshrhldr(java.lang.String value) {
		this.belongshrhldr = value;
	}
	
	public java.lang.String getBelongshrhldr() {
		return this.belongshrhldr;
	}
	public void setCompany(java.lang.String value) {
		this.company = value;
	}
	
	public java.lang.String getCompany() {
		return this.company;
	}
	public void setIndustry(java.lang.String value) {
		this.industry = value;
	}
	
	public java.lang.String getIndustry() {
		return this.industry;
	}
	public void setOcctype(java.lang.String value) {
		this.occtype = value;
	}
	
	public java.lang.String getOcctype() {
		return this.occtype;
	}
	public void setOcctel(java.lang.String value) {
		this.occtel = value;
	}
	
	public java.lang.String getOcctel() {
		return this.occtel;
	}
	public void setOcczip(java.lang.String value) {
		this.occzip = value;
	}
	
	public java.lang.String getOcczip() {
		return this.occzip;
	}
	public void setStartyear(java.lang.String value) {
		this.startyear = value;
	}
	
	public java.lang.String getStartyear() {
		return this.startyear;
	}
	public void setOccaddress(java.lang.String value) {
		this.occaddress = value;
	}
	
	public java.lang.String getOccaddress() {
		return this.occaddress;
	}
	public void setDuty(java.lang.String value) {
		this.duty = value;
	}
	
	public java.lang.String getDuty() {
		return this.duty;
	}
	public void setCaste(java.lang.String value) {
		this.caste = value;
	}
	
	public java.lang.String getCaste() {
		return this.caste;
	}
	public void setDutylevel(java.lang.String value) {
		this.dutylevel = value;
	}
	
	public java.lang.String getDutylevel() {
		return this.dutylevel;
	}
	public void setLayoffsno(java.lang.String value) {
		this.layoffsno = value;
	}
	
	public java.lang.String getLayoffsno() {
		return this.layoffsno;
	}
	public void setWagebank(java.lang.String value) {
		this.wagebank = value;
	}
	
	public java.lang.String getWagebank() {
		return this.wagebank;
	}
	public void setWageno(java.lang.String value) {
		this.wageno = value;
	}
	
	public java.lang.String getWageno() {
		return this.wageno;
	}
}

