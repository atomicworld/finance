package com.mf.common.pub;

public class PubConstants {
	// xjh-start
	//页面处理类型 查看、编辑 - xjh
	public static final String PAGE_TYPE_VIEW = "VIEW";
	public static final String PAGE_TYPE_EDIT = "EDIT";
	
	// 客户类型 个人客户、对公客户
	public static final String CLNT_TYPE_EE = "1"; // 对公客户
	public static final String CLNT_TYPE_PERSON = "2"; // 个人客户
	
	// 客户id号起始值
	public static final int CLNTID_PERSON_BEGIN = 20000001; // 个人客户
	public static final int CLNTID_EE_BEGIN = 10000001; // 对公客户
	
	// 客户信息左侧菜单，如基本资料、经济情况、等级评估等
	public static final String CLNT_LEFT_MENU_BASEINFO = "CLNTBASEINFO";
	/** 客户经济情况 */
	public static final String CLNT_LEFT_MENU_ECO = "CLNTECO";
	/** 等级评估 */
	public static final String CLNT_LEFT_MENU_DGREVAL = "CLNTDGREVAL";
	/** 关联关系 */
	public static final String CLNT_LEFT_MENU_REL = "CLNTREL";
	/** 重大事件 */
	public static final String CLNT_LEFT_MENU_EVENT = "CLNTEVENT";
	// xjh-end
	
	public static final int LOGIN_SUCCESS = 3000000;
	public static final int LOGIN_NOTEXIST = 0;
	public static final int LOGIN_DYNMPWDERR = 3001502;
	public static final int LOGIN_NOTINPOS = 1;
	public static final int LOGIN_NOTINUSE = 2;
	public static final int LOGIN_STTCPWDERR = 3;
	public static final int LOGIN_MULTIUSER = 4;
	public static final int LOGIN_UNKNOWN = -1;
	
	public static final String OPTYPE_PUBOP = "0";
	public static final String OPTYPE_SUPERADMIN = "2";
	public static final String OPTYPE_DEVELOPER = "9";
	
	/*BSNS_CNTRCT表的CNTRCTSTT 字段*/
	public static final String CNTRCTSTT_NEW = "1";     	// 新审批完成合同 待签订
	public static final String CNTRCTSTT_SIGNED = "2";  	// 已完成合同签订 待放款申请
	public static final String CNTRCTSTT_OUTING = "3";  	// 合同正在放款申请中
	public static final String CNTRCTSTT_OUTAPPRED = "4";   // 合同申请放款结束，无金额可申请 
	public static final String CNTRCTSTT_OUTED = "5";   	// 合同实际放款结束，无金额可放
	public static final String CNTRCTSTT_END = "6";   	// 合同完成结束
	public static final String CNTRCTSTT_HISTORY = "9"; 	// 历史补录合同
	public static final String CNTRCTSTT_HISTORY_BILL = "91";// 历史补录合同 已生成借据
	
	//add by hw
	public static final String CNTRCTSTT_REVOKE = "99";// 已撤销合同
	
	public static final String Apprvstt_init = "0";		//新增加的合同详细信息，未进入审批
	public static final String Apprvstt_in = "1";		//已进入审批，可能审批为结束，未提交
	public static final String Apprvstt_noRecive = "2";	//未批复
	public static final String Apprvstt_done = "9";		//审批通过
	public static final String Apprvstt_Undone = "97";	//否决
	public static final String Apprvstt_ReDo = "98";	//发回，补充材料重审
	
	//
	/*BSNS_CNTRCT表的OUTFLG 字段*/
	/** 放款标志-未放款 */
	public static final String OUTFLG_NO = "0"; 
	/** 放款标志-已放款 */
	public static final String OUTFLG_YES = "1";
	
	/*BSNS_CNTRCT表的CNTRCTEDFLG 字段*/
	/** 合同结束标志-未结束 */
	public static final String CNTRCTEDFLG_NO = "0"; 
	/** 合同结束标志-已结束 */
	public static final String CNTRCTEDFLG_YES = "1";
	
	public static final String FNSHFLG_NO = "0"; // FNSHFLG字段
	public static final String FNSHFLG_YES = "1";
	
	/*BSNS_LNMAIN表的ISFIXREPAY 字段*/
	/** 是否固定还款日-否 */
	public static final String FIXREPAY_NO = "0";
	/** 是否固定还款日-是 */
	public static final String FIXREPAY_YES = "1";
	
	/*BSNS_LNOUT表的OUTSTT字段 贷款发放状态*/
	public static final String OUTSTT_REPAYPLAN = "1"; // 贷款发放确认完成，可制定还款计划
	public static final String OUTSTT_OUTING = "2";  //放款申请提交完成,BSNS_LNOUT表新增一条记录,OUTSTT初始置为2
	public static final String OUTSTT_OUTED = "3"; // 贷款发放完成
	
	/*还款方式*/
	public static final String REPAY_METHOD_DEBX = "270006";      // 等额本息
	public static final String REPAY_METHOD_DEBJ = "270007";      // 等额本金
	public static final String REPAY_METHOD_LSBQ = "270001";      // 利随本清
	public static final String REPAY_METHOD_MONTHLY = "270003";   // 按月结息到期还本
	public static final String REPAY_METHOD_QUARTERLY = "270009"; // 按季结息到期还本
	public static final String REPAY_METHOD_CUSTMPLAN = "6"; // 按计划
	public static final String REPAY_METHOD_NOPLAN = "7";    // 无计划
	
	/*计息方式*/
	public static final String INTEREST_MODE_FIXED = "1";         // 固定利率
	public static final String INTEREST_MODE_MONTHFLOAT = "2";    // 按月浮动
	
	/*一年按360天计算*/
	public static final int ACCOUNT_YEAR_DAYS = 360;
	
	/*凭证状态*/
	public static final String PRFBS_STT_NEW = "1"; // 凭证已录入-待提交
	public static final String PRFBS_STT_SUBMIT = "2"; // 凭证已提交-待复核
	public static final String PRFBS_STT_CHECK_YES = "3"; // 凭证已复核
	public static final String PRFBS_STT_CHECK_NO = "4"; // 凭证驳回，历史凭证
	public static final String PRFBS_STT_DEL = "5"; // 凭证冲销
	public static final String PRFBS_STT_finshDel = "6"; // 凭证已冲销
	
	/*记账标识*/
	public static final String CHCKPRFBS_ACCNTFLG_YES = "Y"; // 未记账
	public static final String CHCKPRFBS_ACCNTFLG_NO = "N"; // 已记账
	/*借贷识*/
	public static final String CHCKPRFBS_ACCNTFLG_J = "1"; // 借
	public static final String CHCKPRFBS_ACCNTFLG_D = "2"; // 贷
	/*结转标识*/
	public static final String CHCKPRFBS_ACCNTFLG_STT = "4"; // 结转结果
	public static final String PRFBS_STT_RESULT = "R"; // 结转结果
	
	public static final String JZ_J = "J"; //已汇总待结转
	public static final String JZ_Y = "Y"; //已结转
	public static final String JZ_N = "N"; //未汇总
	
	/** 科目余额方向：借方 */
	public static final String ACCNTDRCT_J = "1";
	/** 科目余额方向：贷方 */
	public static final String ACCNTDRCT_D = "2";
	
	/* BSNS_BILL表DLFLG（借据是否生成还款计划） */
	/** 借据是否生成还款计划-否 */
	public static final String DLFLG_HKJH_NO = "0"; // 未生成
	/** 借据是否生成还款计划-是 */
	public static final String DLFLG_HKJH_YES = "1"; // 已生成
	/** 还款计划完成标示*/
	public static final String HKBJ_FINANCEFLG_ZERO = "0"; // 未还款
	public static final String HKBJ_FINANCEFLG_ONE = "1"; // 已还款
	public static final String HKBJ_FINANCEFLG_TWO = "2"; // 欠款
	public static final String HKBJ_FINANCEFLG_THREE = "3"; // 部分还款
	/** 自动生成凭证科目类型*/
	public static final String ACCNTTYPE_0 = "0"; // 贷款本金
	public static final String ACCNTTYPE_1 = "1"; // 现金
	public static final String ACCNTTYPE_2 = "2"; // 银行
	public static final String ACCNTTYPE_3 = "3"; // 还款本金
	public static final String ACCNTTYPE_4 = "4"; // 还款利息
	/**借据放款标志 借据还款标志*/
	public static final String FK_OUTFLG = "1"; // 放款标志
	public static final String HK_RECFLG = "1"; // 还款标志
	
/*********** Huangwen Start *********/
	/** 00表示下行短信  01表示上行短信 */
	public static final String SMS_DOWNTYPE = "00"; // 短信发送下行标志
	public static final String SMS_UPTYPE = "01"; 	// 短信发送上行标志
	
	/** 短信发送返回码   00-成功  01-失败  */
	public static final String SMS_SUCCESS = "00";
	public static final String SMS_FAILED = "01";
	
	/** 短信服务端号 */
	public static final String SMS_ORG_ID = "000000000005";
	
	/** 短信模板编号  id  */

	public static final String SMS_DKYQ = "1001";	//贷款逾期提醒
	public static final String SMS_DKDQ = "1002";	//贷款到期提醒  
	public static final String SMS_HKDQ = "1003";	//到期还款提醒
	public static final String SMS_HKYQCS = "1004";	//逾期还款提醒
	public static final String SMS_SHTGTZ = "1005";	//审核通过通知
	public static final String SMS_FKTZ = "1006";	//放款通知
	

	public static final String BWGSBBH = "A00";	//征信查询系统版本号
	
	//公司上级机构号，金融办给的：例如：A001
	//Org编码，金融办给小贷公司的
	public static final String Org = "0000001";
	
/********** Huangwen End	*********/
	
	public static final String shareType = "360001";  //股东类别：个人
	//提前还款流水号
	/*public static final String G_Pre_PAYMENT_NO = "PrePaymented";  //股东类别：个人 */
	
	public static String SuperAdmin = "FromMonitorUser";
}
