package com.mf.financemng.entity;

import java.math.BigDecimal;

import com.mf.base.BaseEntity;

public class FnncPrfdtlList extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	
	//date formats
	
	public FnncPrfdtlList(){
	}

	public FnncPrfdtlList(
		java.lang.String sqnno
	){
		this.sqnno = sqnno;
	}
	
	//columns START
		/**凭证流水号==>db_column: PRFTRCNO*/
		private java.lang.String prftrcno;
		/**顺序号==>db_column: SQNNO*/
		private java.lang.String sqnno;
		/**科目编号==>db_column: ACCNTNO*/
		private java.lang.String accntno;
		/**科目名称==>db_column: ACCNTNM*/
		private java.lang.String accntnm;
		/**所属科目名称==>db_column: UPACCNTNM*/
		private java.lang.String upaccntnm;
		/**所属科目编号==>db_column: UPACCNTNO*/
		private java.lang.String upaccntno;
		/**借贷标识==>db_column: JDFLG*/
		private java.lang.String jdflg;
		/**发生金额==>db_column: AMNT*/
		private BigDecimal amnt;
		/**摘要==>db_column: REMARK*/
		private java.lang.String remark;
		//columns END
		public java.lang.String getPrftrcno() {
			return prftrcno;
		}

		public void setPrftrcno(java.lang.String prftrcno) {
			this.prftrcno = prftrcno;
		}

		public java.lang.String getSqnno() {
			return sqnno;
		}

		public void setSqnno(java.lang.String sqnno) {
			this.sqnno = sqnno;
		}

		public java.lang.String getAccntno() {
			return accntno;
		}

		public void setAccntno(java.lang.String accntno) {
			this.accntno = accntno;
		}

		public java.lang.String getAccntnm() {
			return accntnm;
		}

		public void setAccntnm(java.lang.String accntnm) {
			this.accntnm = accntnm;
		}

		public java.lang.String getUpaccntnm() {
			return upaccntnm;
		}

		public void setUpaccntnm(java.lang.String upaccntnm) {
			this.upaccntnm = upaccntnm;
		}

		public java.lang.String getUpaccntno() {
			return upaccntno;
		}

		public void setUpaccntno(java.lang.String upaccntno) {
			this.upaccntno = upaccntno;
		}

		public java.lang.String getJdflg() {
			return jdflg;
		}

		public void setJdflg(java.lang.String jdflg) {
			this.jdflg = jdflg;
		}

		public BigDecimal getAmnt() {
			return amnt;
		}

		public void setAmnt(BigDecimal amnt) {
			this.amnt = amnt;
		}

		public java.lang.String getRemark() {
			return remark;
		}

		public void setRemark(java.lang.String remark) {
			this.remark = remark;
		}
}
