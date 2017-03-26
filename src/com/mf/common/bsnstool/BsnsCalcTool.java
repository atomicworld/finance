package com.mf.common.bsnstool;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ibm.icu.text.SimpleDateFormat;
import com.mf.cntrtmng.entity.BsnsBill;
import com.mf.cntrtmng.entity.BsnsCntrct;
import com.mf.cntrtmng.entity.BsnsLnmain;
import com.mf.cntrtmng.entity.BsnsRepayplan;
import com.mf.common.pub.PubConstants;
import com.mf.common.util.StringUtil;
import com.mf.common.util.WaterIdGener;
import com.mf.util.FormatDateUtil;


public class BsnsCalcTool {
	private static final MathTool mathtool = new MathTool();
	
	/* CreatNewPlan 
	 * 计算新的还款计划
	 * */
	public List<BsnsRepayplan> CreatNewPlan(BsnsLnmain loan, BsnsBill bsnsBill,BsnsCntrct bsnsCntrct, String hkr) {
		List<BsnsRepayplan> list = null;
		try {
			//获取还款方式
			String repayMethod = bsnsCntrct.getRpmntway();
//			//保存时，其他利率都换算成年率了，所以这里只去年率
			String yrate = String.valueOf(bsnsCntrct.getBsnsrt().divide(new BigDecimal(100), 4,BigDecimal.ROUND_UP));
			//计息方式
			String intrstmd = bsnsCntrct.getIntrstmd();
			String gdhkr = hkr;
			if(null == gdhkr){
				gdhkr = loan.getIntstsdate().substring(6, 8);//实际发放贷款日期
			}else{
				if(Integer.parseInt(gdhkr)<10){
					gdhkr = "0"+gdhkr;
				}
			}
//			System.out.println("-----------------------还款方式-------------------"+repayMethod);
//			System.out.println("-----------------------年利率---------------------"+yrate);
//			System.out.println("-----------------------计息方式-------------------"+intrstmd);
//			System.out.println("-----------------------还款日---------------------"+gdhkr);
			if (PubConstants.REPAY_METHOD_DEBX.equals(repayMethod)){// 等额本息
				list = getdebx(bsnsBill, yrate, intrstmd, gdhkr);
			}else if (PubConstants.REPAY_METHOD_DEBJ.equals(repayMethod)){ // 等额本金
				list = getdebj(bsnsBill, yrate, intrstmd, gdhkr);
			}else if ((PubConstants.REPAY_METHOD_MONTHLY.equals(repayMethod))){// 按月结息到期还本
				String value="0";
				list = getBymoty(bsnsBill,yrate,gdhkr,intrstmd,value);
			}else if ((PubConstants.REPAY_METHOD_QUARTERLY.equals(repayMethod))){ // 按季结息到期还本
				String value="1";
				list = getBymoty(bsnsBill,yrate,gdhkr,intrstmd,value);
			}else if(PubConstants.REPAY_METHOD_LSBQ.equals(repayMethod)){ // 利随本清
				list = getxsbq(bsnsBill, yrate, intrstmd, gdhkr);
			}else{
				throw new Exception("非法的还款方式!");
	        }
		}catch (Exception e) {
			e.printStackTrace();
		}
	 
		return list;
	}

	// 按月结息或者按季度结息方式创建还款计划
	// private ArrayList<BsnsRepayplan> creatPlan_MORQ(String outdate, String
	// pactno, String dueno, String htbegin, String htend, String amt,
	// Connection conn, String tel, String brno, String rate, String flag,
	// PactManageObj pactManageObj){
	private ArrayList<BsnsRepayplan> creatPlan_MORQ(BsnsLnmain loan,
			BsnsCntrct bsnsCntrct) {
		ArrayList<BsnsRepayplan> list = new ArrayList<BsnsRepayplan>();
		try {
			BsnsRepayplan plan = null;
			int YEAR_DAYS = PubConstants.ACCOUNT_YEAR_DAYS;

			String repayWay = bsnsCntrct.getRpmntway(); // bsns_cntrct-还款方式
			String htbegin = loan.getIntstsdate(); // bsns_lnmain-实际放款日期
			String htend = loan.getIntstedate(); // bsns_lnmain-预计结束日期
			BigDecimal rate = bsnsCntrct.getBsnsrt(); // bsns_cntrct-执行利率

			BigDecimal amount = loan.getLnblnc(); // 该笔业务本金金额
			BigDecimal currepayamnt = null; // 需归还本金金额
			BigDecimal repayinstamnt = null; // 需归还利息金额

			String termdate = htbegin; // 当前还款期的起始日期
			String returndate = htbegin; // 还款日期
			double interest = 0.0D;
			boolean isLastDay = false;
			int days = DateTool.getDaysOfMonth(termdate); // 计算当前还款周期起始日期所在月的天数
			if (days == Integer.valueOf(termdate.substring(6, 8)).intValue()) {
				isLastDay = true;
			}
			if (PubConstants.REPAY_METHOD_MONTHLY.equals(repayWay)) {// 此处按月结息
				int terms = DateTool.getMonth(htbegin, htend); // 计算计划期数
				// double rate_month = Div(rate.doubleValue(), 1200.0D); //计算月利率

				for (int i = 1; i <= terms; i++) {
					plan = new BsnsRepayplan();
					plan.setTbrepaypttl(amount); // 待还款本金总额
					plan.setRepaystt("0"); // 计划状态
					plan.setRepaytermno(String.valueOf(i));// ①还款期数
					plan.setCyclesdt(termdate); // ②还款周期开始日期
					plan.setTbrepaybal(amount);

					if (i == terms) {// 当前是最后一期
						plan.setCycleedt(htend); // 将最终结束日期设置为本期结束日期
						plan.setActualrepaydt(htend); // 本期最晚还款日期
						currepayamnt = amount;
						plan.setCurrepayamnt(currepayamnt); // ⑤本期计划归还本金金额
						plan.setRepayedprinsum(amount);// 本期计划累计归还本金金额
						// 计算本期开始日期到最终结息日期之间的天数
						int sumDays = DateTool.getBetweenDays(termdate, htend);
						// 按照自然天数计息
						// 计算利息=本金*年利率*天数/360
						interest = Div(
								Mult(Mult(amount.doubleValue(),
										rate.doubleValue()), sumDays),
								YEAR_DAYS);
						interest = MathTool.Round(interest / 100);
						repayinstamnt = BigDecimal.valueOf(interest);
						plan.setRepayinstamnt(repayinstamnt);
					} else {
						// 计算下一期的开始日期
						termdate = DateTool.getMonth_next(termdate, termdate,
								isLastDay);
						returndate = termdate;
						plan.setActualrepaydt(returndate);
						plan.setCycleedt(termdate); // ③还款周期结束日期
						currepayamnt = BigDecimal.ZERO;
						plan.setCurrepayamnt(currepayamnt); // ⑤需归还本金金额
						plan.setRepayedprinsum(BigDecimal.ZERO);
						// 计算本次还款周期中的天数
						int sumDays = DateTool.getBetweenDays(
								plan.getCyclesdt(), termdate);
						// 按照自然天数计息
						interest = Div(
								Mult(Mult(amount.doubleValue(),
										rate.doubleValue()), sumDays),
								YEAR_DAYS);
						interest = MathTool.Round(interest / 100);
						repayinstamnt = BigDecimal.valueOf(interest);
						plan.setRepayinstamnt(repayinstamnt); // ④应还利息
					}
					list.add(plan);
				}
			} else if (PubConstants.REPAY_METHOD_QUARTERLY.equals(repayWay)) {// 此处按季结息
				// likun 修改一次偿还 按季结息
				int times_term = DateTool.getMonth(htbegin, htend);
				int times = times_term / 3;
				if (times_term % 3 != 0) {
					times++;
				}
				double rate_month = Div(rate.doubleValue(), 1200.0D);

				for (int i = 1; i <= times; i++) {
					plan = new BsnsRepayplan();
					interest = 0.0D;
					plan.setTbrepaypttl(amount); // 待还款本金总额
					plan.setRepaystt("0"); // 计划状态
					plan.setRepaytermno(String.valueOf(i));// 还款期数
					plan.setCyclesdt(termdate);
					plan.setTbrepaybal(amount); // 待还款本金余额

					int j = 0;
					if (i == times) {// 最后一期 - start
						int monthCount = DateTool.getMonth(termdate, htend);
						while (j < monthCount) {
							termdate = DateTool.getMonth_next(termdate,
									termdate, isLastDay);
							/* 按整月计算利息=本金*月利率 */
							interest = Add(interest,
									Mult(amount.doubleValue(), rate_month));
							j++;
						}
						/* 正月算完后,计算剩余的天数 */
						int sumDays = DateTool.getBetweenDays(termdate, htend);
						if (StringUtil.isBigerZero(String.valueOf(sumDays))) {
							interest = Add(
									interest,
									Div(Mult(
											Mult(amount.doubleValue(),
													rate.doubleValue()),
											sumDays), YEAR_DAYS));
						}
						interest = MathTool.Round(interest);
						plan.setRepayinstamnt(BigDecimal.valueOf(interest));
						plan.setCycleedt(htend); // 将最终结束日期设置为本期结束日期
						plan.setActualrepaydt(htend); // 本期最晚还款日期
						plan.setCurrepayamnt(amount); // 本期计划归还本金金额
						plan.setRepayedprinsum(amount);// 本期计划累计归还本金金额
						// 最后一期 - end
					} else {// 非最后一期 - start
						do {
							termdate = DateTool.getMonth_next(termdate,
									termdate, isLastDay);
							/* 按整月计算利息=本金*月利率 */
							interest = Add(interest,
									Mult(amount.doubleValue(), rate_month));
							j++;
						} while (j < 3);

						interest = MathTool.Round(interest);
						plan.setRepayinstamnt(BigDecimal.valueOf(interest)); // 需归还利息金额
						plan.setCycleedt(termdate);
						plan.setActualrepaydt(termdate); // 实际还款日期
						plan.setCurrepayamnt(BigDecimal.ZERO); // 需归还本金金额
						plan.setRepayedprinsum(BigDecimal.ZERO); // 累计归还本金金额
						
					}
					list.add(plan);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/*private ArrayList<BsnsRepayplan> creatPlan_DEBX(String outdate, String pactno, String dueno, String htbegin, String htend, String amt, Connection conn, String tel, String brno, String rate, String flag)
	   {
	     ArrayList list = new ArrayList();
	     try {
	       if ((StringUtil.isEmpty(outdate)) || (StringUtil.isEmpty(pactno)) || (StringUtil.isEmpty(dueno)) || (StringUtil.isEmpty(rate)) || 
	         (StringUtil.isEmpty(tel)) || (StringUtil.isEmpty(brno)) || (conn == null)) {
	         throw new Exception("等额本息还款计划生成参数传值错误!");
	       }
	       if ((StringUtil.isEmpty(htbegin)) || (StringUtil.isEmpty(htend)) || (htend.length() != 8) || (htbegin.length() != 8) || 
	         (outdate.length() != 8)) {
	         throw new Exception("等额本息还款计划生成参数传值错误!");
	       }
	       ITzglDao tzglDao = TzglFactory.getTzglDao();
	       BsnsRepayplan obj = new BsnsRepayplan();
	       PactManageObj pactManageObj = (PactManageObj)map.get("pactManageObj_" + pactno);
	       if (pactManageObj == null) {
	         pactManageObj = tzglDao.getPactManageObj(pactno, "", conn);
	         map.put("pactManageObj_" + pactno, pactManageObj);
	       }
	       obj.setCifname(pactManageObj.getCifname());
	       obj.setCifno(pactManageObj.getCifno());
	       obj.setIntreturn(pactManageObj.getIntreturn());
	       obj.setPactamt(amt);
	       obj.setPactno(pactno);
	       obj.setDueno(dueno);
	       if ((StringUtil.isEmpty(obj.getCifname())) || (StringUtil.isEmpty(obj.getCifno())) || (StringUtil.isEmpty(obj.getDueno()))) {
	         throw new Exception("等额本息还款计划生成参数传值错误!");
	       }
	       if ((StringUtil.isEmpty(obj.getIntreturn())) || (StringUtil.isEmpty(obj.getPactamt())) || (StringUtil.isEmpty(obj.getPactno()))) {
	         throw new Exception("等额本息还款计划生成参数传值错误!");
	       }
	 
	       htbegin = outdate;
	 
	       int terms = getMonth(outdate, htend);
	       double rate_month = Div(amt(rate), 1200.0D);
	       double rate_year = Div(amt(rate), 100.0D);
	       String returndate = outdate;
	       String termdate = htbegin;
	       double money = 0.0D;
	       String stadDay = "";
	       String systemDate = this.iGlobal.getTbsdy();
	 
	       boolean isLastDay = false;
	       int days = DateUtil.getDaysOfMonth(termdate);
	       if (days == Integer.valueOf(termdate.substring(6, 8)).intValue()) {
	         isLastDay = true;
	       }
	       for (int i = 1; i <= terms; i++)
	       {
	         stadDay = termdate;
	 
	         obj.setOpndate(termdate);
	 
	         termdate = getMonth_next(termdate, htbegin, isLastDay);
	         double lixi = 0.0D;
	         if (i == terms) {
	           int sumDays = getBetweenDays(stadDay, htend);
	 
	           int intMonth = DateUtil.getMonth(stadDay);
	           if (((intMonth == 2) && (sumDays >= 28)) || ((intMonth != 2) && (sumDays >= 30))) {
	             lixi = Mult(amt(amt), rate_month);
	           } else {
	             int BASE_DAYS_360 = getParmCtrl("8006");
	 
	             lixi = Div(Mult(Mult(amt(amt), Double.valueOf(rate_year).doubleValue()), sumDays), BASE_DAYS_360);
	           }
	         } else {
	           lixi = Mult(amt(amt), rate_month);
	         }
	 
	         lixi = Mult(lixi, Math.pow(1.0D + rate_month, terms) - Math.pow(1.0D + rate_month, i - 1));
	         lixi = Div(lixi, Math.pow(1.0D + rate_month, terms) - 1.0D);
	         lixi = parseAmtFormat(lixi);
	 
	         double benjin = Mult(amt(amt), rate_month);
	         benjin = Mult(benjin, Math.pow(1.0D + rate_month, i - 1));
	         benjin = Div(benjin, Math.pow(1.0D + rate_month, terms) - 1.0D);
	         benjin = parseAmtFormat(benjin);
	 
	         obj.setSerialno(GetWaterId.getPK("JH"));
	 
	         obj.setExt2("1");
	 
	         obj.setOutflag("0");
	 
	         obj.setReturnsum(String.valueOf(benjin));
	         obj.setTermnum(String.valueOf(i));
	 
	         if (i == terms) {
	           obj.setEnddate(htend);
	           obj.setReturndate(htend);
	         } else {
	           returndate = getMonth_next(returndate, outdate, isLastDay);
	           obj.setReturndate(returndate);
	           obj.setEnddate(returndate);
	         }
	 
	         obj.setTxdate(systemDate);
	         obj.setRateincome(String.valueOf(lixi));
	         if (i == 1)
	           obj.setPactbal(amt);
	         else {
	           obj.setPactbal(String.valueOf(Subs(amt(obj.getPactbal()), money)));
	         }
	         money = benjin;
	         obj.setMultireturnsum(String.valueOf(Add(amt(obj.getMultireturnsum()), benjin)));
	 
	         obj.setType("0");
	         obj.setTxdate(systemDate);
	         obj.setLastmoddate(systemDate);
	 
	         flag = StringUtil.KillNull(flag, "1");
	 
	         if ("1".equals(flag)) {
	           this.hkczIntBo.insertPlan(obj, conn, tel, brno);
	         }
	         PlanObj obj_term = new PlanObj();
	         obj_term.setCifname(obj.getCifname());
	         obj_term.setCifno(obj.getCifno());
	         obj_term.setDueno(obj.getDueno());
	         obj_term.setEnddate(obj.getEnddate());
	         obj_term.setExt2(obj.getExt2());
	         obj_term.setIntreturn(obj.getIntreturn());
	         obj_term.setMultireturnsum(obj.getMultireturnsum());
	         obj_term.setOpndate(obj.getOpndate());
	         obj_term.setOutflag(obj.getOutflag());
	         obj_term.setPactno(obj.getPactno());
	         obj_term.setPactamt(obj.getPactamt());
	         obj_term.setPactbal(obj.getPactbal());
	         obj_term.setRateincome(obj.getRateincome());
	         obj_term.setReturndate(obj.getEnddate());
	         obj_term.setReturnrate(rate);
	         obj_term.setReturnsum(obj.getReturnsum());
	         obj_term.setSerialno(obj.getSerialno());
	         obj_term.setTermnum(obj.getTermnum());
	         obj_term.setTxdate(obj.getTxdate());
	         list.add(obj_term);
	       }
	     } catch (Exception e) {
	       e.printStackTrace();
	       new PublicDAOExHandler().handle(e);
	     }
	 
	     return list;
	   }
	
	private ArrayList<BsnsRepayplan> creatPlan_DEBJ(String outdate, String pactno, String dueno, String htbegin, String htend, String amt, Connection conn, String tel, String brno, String rate, String flag)
	   {
	     ArrayList list = new ArrayList();
	     try {
	       if ((StringUtil.isEmpty(outdate)) || (StringUtil.isEmpty(pactno)) || (StringUtil.isEmpty(rate)) || (StringUtil.isEmpty(tel)) || 
	         (StringUtil.isEmpty(brno)) || (StringUtil.isEmpty(dueno)) || (conn == null)) {
	         throw new Exception("等额本金还款计划生成参数传值错误!");
	       }
	       if ((StringUtil.isEmpty(htbegin)) || (StringUtil.isEmpty(htend)) || (htend.length() != 8) || (htbegin.length() != 8) || 
	         (outdate.length() != 8)) {
	         throw new Exception("等额本金还款计划生成参数传值错误!");
	       }
	       ITzglDao tzglDao = TzglFactory.getTzglDao();
	       BsnsRepayplan obj = new BsnsRepayplan();
	       PactManageObj pactManageObj = (PactManageObj)map.get("pactManageObj_" + pactno);
	       if (pactManageObj == null) {
	         pactManageObj = tzglDao.getPactManageObj(pactno, "", conn);
	         map.put("pactManageObj_" + pactno, pactManageObj);
	       }
	       obj.setCifname(pactManageObj.getCifname());
	       obj.setCifno(pactManageObj.getCifno());
	       obj.setIntreturn(pactManageObj.getIntreturn());
	       obj.setPactamt(amt);
	       obj.setPactno(pactno);
	       obj.setDueno(dueno);
	       if (StringUtil.isEmpty(rate)) {
	         throw new Exception("等额本金还款计划生成参数传值错误!");
	       }
	       if ((StringUtil.isEmpty(obj.getCifname())) || (StringUtil.isEmpty(obj.getCifno())) || (StringUtil.isEmpty(obj.getDueno()))) {
	         throw new Exception("等额本金还款计划生成参数传值错误!");
	       }
	       if ((StringUtil.isEmpty(obj.getIntreturn())) || (StringUtil.isEmpty(obj.getPactamt())) || (StringUtil.isEmpty(obj.getPactno()))) {
	         throw new Exception("等额本金还款计划生成参数传值错误!");
	       }
	 
	       htbegin = outdate;
	 
	       int terms = getMonth(outdate, htend);
	       double rate_month = Div(amt(rate), 1200.0D);
	       double rate_year = Div(amt(rate), 100.0D);
	       String returndate = outdate;
	       String termdate = htbegin;
	       double money = 0.0D;
	 
	       double money_bal = amt(amt);
	       double money_tem = money_bal;
	       double benjin = parseAmtFormat(Div(amt(amt), terms));
	       String stadDay = "";
	       String systemDate = this.iGlobal.getTbsdy();
	 
	       boolean isLastDay = false;
	       int days = DateUtil.getDaysOfMonth(termdate);
	       if (days == Integer.valueOf(termdate.substring(6, 8)).intValue()) {
	         isLastDay = true;
	       }
	       for (int i = 1; i <= terms; i++)
	       {
	         stadDay = termdate;
	 
	         obj.setOpndate(termdate);
	 
	         termdate = getMonth_next(termdate, htbegin, isLastDay);
	         double lixi = 0.0D;
	         if (i == terms) {
	           int sumDays = getBetweenDays(stadDay, htend);
	 
	           int intMonth = DateUtil.getMonth(stadDay);
	 
	           if (((intMonth == 2) && (sumDays >= 28)) || ((intMonth != 2) && (sumDays >= 30))) {
	             lixi = parseAmtFormat(Mult(money_bal, rate_month));
	           } else {
	             int BASE_DAYS_360 = getParmCtrl("8006");
	 
	             lixi = parseAmtFormat(Div(Mult(Mult(money_bal, Double.valueOf(rate_year).doubleValue()), sumDays), BASE_DAYS_360));
	           }
	         } else {
	           lixi = parseAmtFormat(Mult(money_bal, rate_month));
	         }
	 
	         money_bal = Subs(money_bal, benjin);
	         obj.setSerialno(GetWaterId.getPK("JH"));
	         obj.setExt2("1");
	         obj.setOutflag("0");
	 
	         obj.setTermnum(String.valueOf(i));
	         obj.setTxdate(systemDate);
	         obj.setRateincome(String.valueOf(lixi));
	 
	         if (i == terms) {
	           obj.setEnddate(htend);
	           obj.setReturndate(htend);
	           obj.setReturnsum(String.valueOf(Subs(money_tem, money)));
	           obj.setMultireturnsum(String.valueOf(Add(amt(obj.getMultireturnsum()), amt(obj.getReturnsum()))));
	         } else {
	           returndate = getMonth_next(returndate, outdate, isLastDay);
	           obj.setReturndate(returndate);
	           obj.setEnddate(termdate);
	           obj.setReturnsum(String.valueOf(benjin));
	           obj.setMultireturnsum(String.valueOf(Add(amt(obj.getMultireturnsum()), benjin)));
	         }
	 
	         money_tem = Subs(money_tem, money);
	         obj.setPactbal(String.valueOf(money_tem));
	         money = benjin;
	 
	         obj.setTxdate(systemDate);
	         obj.setLastmoddate(systemDate);
	         obj.setType("0");
	 
	         flag = StringUtil.KillNull(flag, "1");
	         if ("1".equals(flag)) {
	           this.hkczIntBo.insertPlan(obj, conn, tel, brno);
	         }
	 
	         BsnsRepayplan obj_term = new BsnsRepayplan();
	         obj_term.setCifname(obj.getCifname());
	         obj_term.setCifno(obj.getCifno());
	         obj_term.setDueno(obj.getDueno());
	         obj_term.setEnddate(obj.getEnddate());
	         obj_term.setExt2(obj.getExt2());
	         obj_term.setIntreturn(obj.getIntreturn());
	         obj_term.setMultireturnsum(obj.getMultireturnsum());
	         obj_term.setOpndate(obj.getOpndate());
	         obj_term.setOutflag(obj.getOutflag());
	         obj_term.setPactno(obj.getPactno());
	         obj_term.setPactamt(obj.getPactamt());
	         obj_term.setPactbal(obj.getPactbal());
	         obj_term.setRateincome(obj.getRateincome());
	         obj_term.setReturndate(obj.getEnddate());
	         obj_term.setReturnrate(rate);
	         obj_term.setReturnsum(obj.getReturnsum());
	         obj_term.setSerialno(obj.getSerialno());
	         obj_term.setTermnum(obj.getTermnum());
	         obj_term.setTxdate(obj.getTxdate());
	         list.add(obj_term);
	       }
	     } catch (Exception e) {
	       e.printStackTrace();
	       new PublicDAOExHandler().handle(e);
	     }
	 
	     return list;
	   }*/
	
	public static double Div(double left, double right){
		return mathtool.Divide(String.valueOf(left), String.valueOf(right), 20);
	}
	 
	public static double Mult(double left, double right){
		return mathtool.Multiply(String.valueOf(left), String.valueOf(right));
	}
	 
	public static double Subs(double left, double right){
		return mathtool.Subtract(String.valueOf(left), String.valueOf(right));
	}
	 
	public static double Add(double left, double right){
		return mathtool.Add(String.valueOf(left), String.valueOf(right));
	}
	
	//add by shengd  等额本金  、等额本息、利随本清  start
	/**
	 * 等额本金
	 * @param BsnsBill：借据
	 * @param yrate ：年利率
	 * @param intrstmd:计息方式(年利率、月利率、日利率）
	 * @param gdhkr：固定还款日
	 * @return
	 */
	public static List<BsnsRepayplan> getdebj(BsnsBill bsnsBill,String yrate,String intrstmd,String gdhkr){
		
		List<BsnsRepayplan> bsnsRepayplanlist = new ArrayList<BsnsRepayplan>();
		BigDecimal yrate_1 = new BigDecimal(yrate);//年利率    
		BigDecimal len = new BigDecimal(12);//一年12个月
		BigDecimal mrate_1 = yrate_1.divide(len,6,BigDecimal.ROUND_UP);//月利率
		BigDecimal len1= new BigDecimal(360);//一年360天
		BigDecimal drate_1 = yrate_1.divide(len1,6,BigDecimal.ROUND_UP);//天利率
		String startTime = bsnsBill.getOutdate();//放款日期
		String endTime = bsnsBill.getMtrtydate();//结束日期
		BigDecimal amt = bsnsBill.getDueamnt() ;//借据金额
		int items = 0;
		try {
			items=DateTool.getMonth(startTime, endTime);//需要还款期数
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		BigDecimal planamnt = new BigDecimal(items);//计划本金金额累
		BigDecimal planamnt = new BigDecimal(0);//计划本金金额累
		
		BigDecimal items_1 = new BigDecimal(items);
		//等额本金月还款本金=本金 / 期数
		BigDecimal currepayamnt = amt.divide(items_1, 2,BigDecimal.ROUND_UP);//本金
		if(items>1){
			for(int i=0;i<items;i++){			
				if(i==0){
					//String dstartTime = startTime.substring(6, 8);//放款日期的天数
					//int dayFister = 0;//第一次还款天数
					String actualrepaydt=null;//实际还款日期
					/**
					 * 1、先算第一个月的还款钱数
					 * 2、再算中间月份的还款钱数
					 * 3、最后算最后一个月的还款钱数
					 */
					 if(Integer.parseInt(startTime.substring(4,6))==12){
						 actualrepaydt =String.valueOf(Integer.parseInt(startTime.substring(0, 4))+1)+"01"+startTime.substring(6, 8);
					 }else{						 
						 int a =Integer.parseInt(startTime.substring(4, 6));//合同放款日期的月份
						 if(a>=9){
							 actualrepaydt = startTime.substring(0, 4)+ String.valueOf(a+1)+startTime.substring(6, 8);
						 }else{
							 actualrepaydt = startTime.substring(0, 4)+"0"+String.valueOf(a+1)+startTime.substring(6, 8);
						 }
					 }
					 
					//利息（月利率*本金）
					 BigDecimal    repayinstamnt =amt.multiply(mrate_1).divide(new BigDecimal(1),2,BigDecimal.ROUND_UP);//利息
					 planamnt=planamnt.add(currepayamnt);
					 BsnsRepayplan bsnsRepayplan = getBsnsRepayplan(bsnsBill, actualrepaydt, repayinstamnt, currepayamnt, intrstmd);
					 bsnsRepayplanlist.add(bsnsRepayplan);
				}
				
			    if(i>0&&i<items-1){
			    	//待还款本金余额
			    	BigDecimal  tbrepaybal = amt.subtract(currepayamnt.multiply(new BigDecimal(i))).divide(new BigDecimal(1),2,BigDecimal.ROUND_UP);//剩余余额
			    	//当月需归还的利息
			    	BigDecimal    repayinstamnt =tbrepaybal.multiply(mrate_1).divide(new BigDecimal(1),2,BigDecimal.ROUND_UP);//利息
				 
			    	String actualrepaydt="";//实际还款日期
				  
			    	if(Integer.parseInt(bsnsRepayplanlist.get(i-1).getActualrepaydt().substring(4,6))==12){
			    		actualrepaydt =String.valueOf(Integer.parseInt(bsnsRepayplanlist.get(i-1).getActualrepaydt().substring(0,4))+1)+"01"+bsnsRepayplanlist.get(i-1).getActualrepaydt().substring(6, 8);
			    	}else{
			    		int a =Integer.parseInt(bsnsRepayplanlist.get(i-1).getActualrepaydt().substring(4,6));//合同放款日期的月份
			    		if(a>=9){
			    			actualrepaydt = bsnsRepayplanlist.get(i-1).getActualrepaydt().substring(0, 4)+ String.valueOf(a+1)+bsnsRepayplanlist.get(i-1).getActualrepaydt().substring(6, 8);
			    		}else{
			    			actualrepaydt = bsnsRepayplanlist.get(i-1).getActualrepaydt().substring(0, 4)+"0"+String.valueOf(a+1)+bsnsRepayplanlist.get(i-1).getActualrepaydt().substring(6, 8);
			    		}
			    	}				  
			    	BsnsRepayplan bsnsRepayplan = getBsnsRepayplan1(bsnsBill, actualrepaydt, repayinstamnt, i, tbrepaybal, currepayamnt, intrstmd, bsnsRepayplanlist);
			    	bsnsRepayplanlist.add(bsnsRepayplan);
				  //累计已归还的本金金额，计入下一个月的累计中
				  planamnt=planamnt.add(currepayamnt);
				}
			    //最后一期
			    if(i==items-1){
			    	
			    	//获取最后一个月的天数
			    	 long dayEnd = FormatDateUtil.getDaysBtwDate( bsnsRepayplanlist.get(i-1).getCycleedt(),endTime,"yyyyMMdd");

					  BigDecimal repayinstamnt = (currepayamnt.multiply(drate_1)).multiply(new BigDecimal(dayEnd)).divide(new BigDecimal(1),2,BigDecimal.ROUND_UP);//利息
					  //zc修改
					  currepayamnt = amt.subtract(planamnt);//最后一次本金= 借据总额-其它本金累计和
					  planamnt=planamnt.add(currepayamnt);
					  BsnsRepayplan bsnsRepayplan = getBsnsRepayplan2(bsnsBill, repayinstamnt, i, currepayamnt, intrstmd, bsnsRepayplanlist);
					  bsnsRepayplanlist.add(bsnsRepayplan);
				}
			}
		}else{
			bsnsRepayplanlist= getList(bsnsBill,yrate,intrstmd,gdhkr);
			
		}
		    return bsnsRepayplanlist;
	}

public static BsnsRepayplan  getBsnsRepayplan(BsnsBill bsnsBill ,String actualrepaydt,BigDecimal repayinstamnt, BigDecimal currepayamnt,String intrstmd){
	  BsnsRepayplan bsnsRepayplan = new BsnsRepayplan();
	  bsnsRepayplan.setSrlno(WaterIdGener.genPKWithPrefix("JH"));
	  bsnsRepayplan.setClntno(bsnsBill.getClntno());
	  bsnsRepayplan.setClntnm(bsnsBill.getClntnm());
	  bsnsRepayplan.setCntrctno(bsnsBill.getCntrctno());
	  //待还款本金金额
	  bsnsRepayplan.setTbrepaypttl(currepayamnt);
	  //待还款本金余额=借据金额
	  bsnsRepayplan.setTbrepaybal(bsnsBill.getDueamnt().divide(new BigDecimal(1), 2,BigDecimal.ROUND_UP));
	  bsnsRepayplan.setCurrepayamnt(new BigDecimal(0));
	  bsnsRepayplan.setRepayedprinsum(new BigDecimal(0));
	  bsnsRepayplan.setCyclesdt(bsnsBill.getOutdate());
	  bsnsRepayplan.setCycleedt(actualrepaydt);
	  bsnsRepayplan.setDueno(bsnsBill.getDueno());
	  bsnsRepayplan.setActualrepaydt(actualrepaydt);
	  bsnsRepayplan.setRepayinstamnt(repayinstamnt);
	  bsnsRepayplan.setIntrstmd(intrstmd);
	  bsnsRepayplan.setRepaystt("0");
	  bsnsRepayplan.setRepaytermno("1");
	  //设置新建时间以及更新时间
	  bsnsRepayplan.setCreatedate(StringUtil.getFormatDate(new Date(), "yyyyMMdd"));
	  bsnsRepayplan.setUpdatedate(StringUtil.getFormatDate(new Date(), "yyyyMMdd"));
	  
	  return bsnsRepayplan;
	
}

public static BsnsRepayplan  getBsnsRepayplan1(BsnsBill bsnsBill ,String actualrepaydt,BigDecimal repayinstamnt,int i,  BigDecimal tbrepaybal, BigDecimal currepayamnt,String intrstmd,List<BsnsRepayplan> bsnsRepayplanlist ){
	  BsnsRepayplan bsnsRepayplan = new BsnsRepayplan();
	  bsnsRepayplan.setSrlno(WaterIdGener.genPKWithPrefix("JH"));
	  bsnsRepayplan.setClntno(bsnsBill.getClntno());
	  bsnsRepayplan.setClntnm(bsnsBill.getClntnm());
	  bsnsRepayplan.setCntrctno(bsnsBill.getCntrctno());
	  bsnsRepayplan.setTbrepaypttl(currepayamnt);
	  bsnsRepayplan.setTbrepaybal(tbrepaybal);
	  bsnsRepayplan.setCurrepayamnt(new BigDecimal(0));
	  //本金余额=月还款*已还期数（除本期）
	  bsnsRepayplan.setRepayedprinsum(new BigDecimal(0));
//	  bsnsRepayplan.setDptno(operator.getDptno());
//	  bsnsRepayplan.setOpno(operator.getEmplyno());
	  bsnsRepayplan.setCyclesdt(bsnsRepayplanlist.get(i-1).getCycleedt());
	  bsnsRepayplan.setCycleedt(actualrepaydt);
	  bsnsRepayplan.setDueno(bsnsBill.getDueno());
	  bsnsRepayplan.setActualrepaydt(actualrepaydt);
	  bsnsRepayplan.setRepayinstamnt(repayinstamnt);
	  bsnsRepayplan.setIntrstmd(intrstmd);
	  bsnsRepayplan.setRepaystt("0");
	  bsnsRepayplan.setRepaytermno(String.valueOf(i+1));
	  //设置新建时间以及更新时间
	  bsnsRepayplan.setCreatedate(StringUtil.getFormatDate(new Date(), "yyyyMMdd"));
	  bsnsRepayplan.setUpdatedate(StringUtil.getFormatDate(new Date(), "yyyyMMdd"));
	  
	  return bsnsRepayplan;
	
}

//生成还款计划时，累计归还本金金额（REPAYEDPRINSUM）设为0【fankb modified on 2015-09-16】
public static BsnsRepayplan  getBsnsRepayplan2(BsnsBill bsnsBill ,BigDecimal repayinstamnt,int i,  BigDecimal currepayamnt,String intrstmd,List<BsnsRepayplan> bsnsRepayplanlist ){
	 BsnsRepayplan bsnsRepayplan = new BsnsRepayplan();
	  bsnsRepayplan.setSrlno(WaterIdGener.genPKWithPrefix("JH"));
	  bsnsRepayplan.setClntno(bsnsBill.getClntno());
	  bsnsRepayplan.setClntnm(bsnsBill.getClntnm());
	  bsnsRepayplan.setCntrctno(bsnsBill.getCntrctno());
	  bsnsRepayplan.setTbrepaypttl(currepayamnt);
	  bsnsRepayplan.setTbrepaybal(currepayamnt);
	  bsnsRepayplan.setCurrepayamnt(new BigDecimal(0));
	  bsnsRepayplan.setRepayedprinsum(new BigDecimal(0));
//	  bsnsRepayplan.setDptno(operator.getDptno());
//	  bsnsRepayplan.setOpno(operator.getEmplyno());
	  bsnsRepayplan.setCyclesdt(bsnsRepayplanlist.get(i-1).getCycleedt());
	  bsnsRepayplan.setCycleedt(bsnsBill.getMtrtydate());
	  bsnsRepayplan.setDueno(bsnsBill.getDueno());
	  bsnsRepayplan.setActualrepaydt(bsnsBill.getMtrtydate());
	  bsnsRepayplan.setRepayinstamnt(repayinstamnt);
	  bsnsRepayplan.setIntrstmd(intrstmd);
	  bsnsRepayplan.setRepaystt("0");
	  bsnsRepayplan.setRepaytermno(String.valueOf(i+1));
	  //设置新建时间以及更新时间
	  bsnsRepayplan.setCreatedate(StringUtil.getFormatDate(new Date(), "yyyyMMdd"));
	  bsnsRepayplan.setUpdatedate(StringUtil.getFormatDate(new Date(), "yyyyMMdd"));
	  
	  return bsnsRepayplan;
	
}
	
	  /**
	   * 等额本息法(每月月供额=〔贷款本金×月利率×(1＋月利率)＾还款月数〕÷〔(1＋月利率)＾还款月数-1〕
	   */
	  public static List<BsnsRepayplan> getdebx(BsnsBill bsnsBill,String yrate,String intrstmd,String gdhkr){
		    List<BsnsRepayplan> bsnsRepayplanlist = new ArrayList<BsnsRepayplan>();
		    BigDecimal yrate_1 = new BigDecimal(yrate);//年利率
			BigDecimal len = new BigDecimal(12);//一年12个月
			BigDecimal mrate_1 = yrate_1.divide(len,6,BigDecimal.ROUND_UP);//月利率
			BigDecimal len1= new BigDecimal(360);//一年360天
			BigDecimal drate_1 = yrate_1.divide(len1,6,BigDecimal.ROUND_UP);//天利率
			String startTime = bsnsBill.getOutdate();//放款日期
			String endTime = bsnsBill.getMtrtydate();//结束日期
			int items = 0;
			try {
				items=DateTool.getMonth(startTime, endTime);//需要还款期数
				if(items ==0) {
					return null;
				}
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			BigDecimal palnamt = new BigDecimal(0) ;//期数本金总额
		    BigDecimal amt = bsnsBill.getDueamnt() ;//借据金额
		    //每月归还的总金[每月月供额=〔贷款本金×月利率×(1＋月利率)＾还款月数〕÷〔(1＋月利率)＾还款月数-1〕
		    BigDecimal currepayamntTotel = amt.multiply(mrate_1)
	                .multiply((new BigDecimal(1).add(mrate_1)).pow(items)).divide((new BigDecimal(1).add(mrate_1)).pow(items).subtract(new BigDecimal(1)), 2,BigDecimal.ROUND_UP);
		    
		    if(items>1){
				for(int i=0;i<items;i++){
					if(i==0){
						String actualrepaydt=null;//实际还款日期
						/**
						 * 1、先算第一个月的还款钱数
						 * 2、再算中间月份的还款钱数
						 * 3、最后算最后一个月的还款钱数
						 */
						if(Integer.parseInt(startTime.substring(4,6))==12){
							actualrepaydt =String.valueOf(Integer.parseInt(startTime.substring(0, 4))+1)+"01"+startTime.substring(6, 8);
						}else{
							int a =Integer.parseInt(startTime.substring(4, 6));//合同放款日期的月份
							if(a>=9){
								actualrepaydt = startTime.substring(0, 4)+ String.valueOf(a+1)+startTime.substring(6, 8);
							}else{
								actualrepaydt = startTime.substring(0, 4)+"0"+String.valueOf(a+1)+startTime.substring(6, 8);
							}
						}
						//第一个月的利息
						BigDecimal repayinstamnt= amt.multiply(mrate_1).divide(new BigDecimal(1), 2, BigDecimal.ROUND_UP);
						//第一个月的本金
						BigDecimal currepayamnt = currepayamntTotel.subtract(repayinstamnt).divide(new BigDecimal(1), 2,BigDecimal.ROUND_UP);
						//累计本金
						palnamt=palnamt.add(currepayamnt);
						BsnsRepayplan bsnsRepayplan = getBsnsRepayplan(bsnsBill, actualrepaydt, repayinstamnt, currepayamnt, intrstmd);
						bsnsRepayplanlist.add(bsnsRepayplan);
					}
					
					if(i>0&&i<items-1){
						String actualrepaydt="";//实际还款日期
						if(Integer.parseInt(bsnsRepayplanlist.get(i-1).getActualrepaydt().substring(4,6))==12){
							actualrepaydt =String.valueOf(Integer.parseInt(bsnsRepayplanlist.get(i-1).getActualrepaydt().substring(0,4))+1)+"01"+bsnsRepayplanlist.get(i-1).getActualrepaydt().substring(6, 8);
						}else{
							 int a =Integer.parseInt(bsnsRepayplanlist.get(i-1).getActualrepaydt().substring(4,6));//合同放款日期的月份
							 if(a>=9){
								 actualrepaydt = bsnsRepayplanlist.get(i-1).getActualrepaydt().substring(0, 4)+ String.valueOf(a+1)+bsnsRepayplanlist.get(i-1).getActualrepaydt().substring(6, 8);
							 }else{
								 actualrepaydt = bsnsRepayplanlist.get(i-1).getActualrepaydt().substring(0, 4)+"0"+String.valueOf(a+1)+bsnsRepayplanlist.get(i-1).getActualrepaydt().substring(6, 8);
							 }
						}
						//第i个月的利息
						BigDecimal repayinstamnt= (bsnsRepayplanlist.get(i-1).getTbrepaybal().subtract(bsnsRepayplanlist.get(i-1).getTbrepaypttl())).multiply(mrate_1).divide(new BigDecimal(1), 2,BigDecimal.ROUND_UP);
						//第i个月的本金
						BigDecimal currepayamnt = currepayamntTotel.subtract(repayinstamnt).divide(new BigDecimal(1), 2,BigDecimal.ROUND_UP);
						//累计本金
						palnamt=palnamt.add(currepayamnt);
						BigDecimal tbrepaybal =  bsnsRepayplanlist.get(i-1).getTbrepaybal().subtract(currepayamnt).divide(new BigDecimal(1), 2,BigDecimal.ROUND_UP);//剩余余额
						BsnsRepayplan bsnsRepayplan =getBsnsRepayplan1(bsnsBill, actualrepaydt, repayinstamnt, i, tbrepaybal, currepayamnt, intrstmd, bsnsRepayplanlist);
						bsnsRepayplanlist.add(bsnsRepayplan);
					 }
										
					 if(i==items-1){							
						 //获取最后一个月的天数
//						 long dayEnd = FormatDateUtil.getDaysBtwDate( bsnsRepayplanlist.get(i-1).getCycleedt(),endTime,"yyyyMMdd");//					    	 
//						 BigDecimal repayinstamnt= (bsnsRepayplanlist.get(items-2).getTbrepaybal().subtract(bsnsRepayplanlist.get(items-2).getTbrepaypttl())).multiply(new BigDecimal(dayEnd)).multiply(drate_1).divide(new BigDecimal(1), 2,BigDecimal.ROUND_UP);//最后一个月的利息
						
						 BigDecimal currepayamnt=amt.subtract(palnamt);//最后一次本金= 借据总额-其它本金累计和
						 //最后一个月的利息=每月应还金额-本金金额(等额本息就是每个月还的金额一样多)
						 BigDecimal repayinstamnt= currepayamntTotel.subtract(currepayamnt);
						 palnamt=palnamt.add(currepayamnt);//累计本金
						 BsnsRepayplan bsnsRepayplan = getBsnsRepayplan2(bsnsBill, repayinstamnt, i, currepayamnt, intrstmd, bsnsRepayplanlist);
						 bsnsRepayplanlist.add(bsnsRepayplan);
					 }
				}
		    }else{
				bsnsRepayplanlist= getList(bsnsBill,yrate,intrstmd,gdhkr);
			}
		      return bsnsRepayplanlist;
	  }
	      
	   /**
	    * 息随本清
	    */
	      public List<BsnsRepayplan>  getxsbq(BsnsBill bsnsBill,String yrate,String intrstmd,String gdhkr){
	    	     List<BsnsRepayplan>  bsnsRepayplanList = new ArrayList<BsnsRepayplan>();
	    		 BigDecimal drate = (new BigDecimal(yrate)).divide(new BigDecimal(360),4,BigDecimal.ROUND_UP);//天利率
	    	      BigDecimal toteldate =new BigDecimal(getDay(bsnsBill.getOutdate(), bsnsBill.getMtrtydate()));
	    	      BigDecimal  repayinstamnt =bsnsBill.getDueamnt().multiply(drate).multiply(toteldate);//利息    
	    	      BsnsRepayplan bsnsRepayplan = new BsnsRepayplan();
				  bsnsRepayplan.setSrlno(WaterIdGener.genPKWithPrefix("JH"));
				  bsnsRepayplan.setClntno(bsnsBill.getClntno());
				  bsnsRepayplan.setClntnm(bsnsBill.getClntnm());
				  bsnsRepayplan.setCntrctno(bsnsBill.getCntrctno());
				  bsnsRepayplan.setTbrepaypttl(bsnsBill.getDueamnt());
				  bsnsRepayplan.setTbrepaybal(bsnsBill.getDueamnt());				  
				  bsnsRepayplan.setCurrepayamnt(new BigDecimal(0));				  
				  bsnsRepayplan.setRepayedprinsum(new BigDecimal(0));
//				  bsnsRepayplan.setDptno(operator.getDptno());
//				  bsnsRepayplan.setOpno(operator.getEmplyno());
				  bsnsRepayplan.setCyclesdt(bsnsBill.getOutdate());
				  bsnsRepayplan.setCycleedt(bsnsBill.getMtrtydate());
				  bsnsRepayplan.setDueno(bsnsBill.getDueno());
				  bsnsRepayplan.setActualrepaydt(bsnsBill.getMtrtydate());
				  bsnsRepayplan.setRepayinstamnt(repayinstamnt);   
				  bsnsRepayplan.setIntrstmd(intrstmd);
				  bsnsRepayplan.setRepaystt("0");
				  bsnsRepayplan.setRepaytermno("1");
				  //设置新建时间以及更新时间
				  bsnsRepayplan.setCreatedate(StringUtil.getFormatDate(new Date(), "yyyyMMdd"));
				  bsnsRepayplan.setUpdatedate(StringUtil.getFormatDate(new Date(), "yyyyMMdd"));
				  bsnsRepayplanList.add(bsnsRepayplan);
	    	    return bsnsRepayplanList;
	       }
	      /**
	       * 针对只有一期的贷款
	       * add by shengd
	       */
	      
	      public static List<BsnsRepayplan> getList(BsnsBill bsnsBill,String yrate,String intrstmd,String gdhkr){
	    	  String startTime = bsnsBill.getOutdate();//放款日期
	  		  String endTime = bsnsBill.getMtrtydate();//结束日期
	    	  BigDecimal yrate_1 = new BigDecimal(yrate);//年利率  
	    	  BigDecimal len1= new BigDecimal(360);//一年360天
	    	  BigDecimal drate_1 = yrate_1.divide(len1,6,BigDecimal.ROUND_UP);//天利率
	    	  List<BsnsRepayplan> bsnsRepayplanlist = new ArrayList<BsnsRepayplan>();
	    	  BigDecimal amt = bsnsBill.getDueamnt() ;//借据金额
	    	  BigDecimal items_1 = new BigDecimal(1);
	    	  BigDecimal currepayamnt = amt.divide(items_1, 2,BigDecimal.ROUND_UP);//本金
	    	  String dstartTime = startTime.substring(6, 8);//放款日期的天数
	    	  String dendTime = endTime.substring(6, 8);//放款日期的天数
				
	    	  //获取最后一个月的天数
	    	  long dayEnd = FormatDateUtil.getDaysBtwDate( startTime,endTime,"yyyyMMdd");		    	 
	    	  //利息
	    	  BigDecimal repayinstamnt = (currepayamnt.multiply(drate_1)).multiply(new BigDecimal(dayEnd)).divide(new BigDecimal(1),2,BigDecimal.ROUND_UP);
			 
	    	  BsnsRepayplan bsnsRepayplan = new BsnsRepayplan();
			  bsnsRepayplan.setSrlno(WaterIdGener.genPKWithPrefix("JH"));
			  bsnsRepayplan.setClntno(bsnsBill.getClntno());
			  bsnsRepayplan.setClntnm(bsnsBill.getClntnm());
			  bsnsRepayplan.setCntrctno(bsnsBill.getCntrctno());
			  bsnsRepayplan.setTbrepaypttl(currepayamnt);
			  bsnsRepayplan.setTbrepaybal(currepayamnt);
			  bsnsRepayplan.setCurrepayamnt(new BigDecimal(0));
			  //新修改
			  bsnsRepayplan.setRepayedprinsum(new BigDecimal(0));
//			  bsnsRepayplan.setDptno(operator.getDptno());
//			  bsnsRepayplan.setOpno(operator.getEmplyno());
			  bsnsRepayplan.setCyclesdt(startTime);
			  bsnsRepayplan.setCycleedt(endTime);
			  bsnsRepayplan.setDueno(bsnsBill.getDueno());
			  bsnsRepayplan.setActualrepaydt(endTime);
			  bsnsRepayplan.setRepayinstamnt(repayinstamnt);
			  bsnsRepayplan.setIntrstmd(intrstmd);
			  bsnsRepayplan.setRepaystt("0");
			  bsnsRepayplan.setRepaytermno("1");
			  //设置新建时间以及更新时间
			  bsnsRepayplan.setCreatedate(StringUtil.getFormatDate(new Date(), "yyyyMMdd"));
			  bsnsRepayplan.setUpdatedate(StringUtil.getFormatDate(new Date(), "yyyyMMdd"));
			  bsnsRepayplanlist.add(bsnsRepayplan);
			  return bsnsRepayplanlist;
	      }
	  	//add by shengd  等额本金  、等额本息、利随本清  end
	      
	    /**
	    * @Title: getBymoty
	    * @Description: TODO(带有固定还款日的按月结息 和按季度结息)
	    * @param bsnsBill 
	    * @param yrate
	    * @param gdhkr
	    * @param intrstmd
	    * @param value 0代表按月结息 1代表按季度结息
	    * @return    设定文件
	    * @date 2015-4-22
	    */
	    public static List<BsnsRepayplan> getBymoty(BsnsBill bsnsBill,String yrate,String gdhkr,String intrstmd,String value){
	    	System.out.println("=======按月结息 和按季度结息===");
	  		System.out.println("bsnsBill================"+bsnsBill.toString());
	  		System.out.println("yrate================"+yrate);
	  		System.out.println("intrstmd================"+intrstmd);
	  		System.out.println("gdhkr================"+gdhkr);
	  		System.out.println("value================"+value);
	  		List<BsnsRepayplan> bsnsRepayplanList = new ArrayList<BsnsRepayplan>();
	  		String startTime = bsnsBill.getOutdate();//合同开始日期
	  		String endTime = bsnsBill.getMtrtydate();//结束日期
	  		int items = 0;
	  		BigDecimal yrate_1 = new BigDecimal(yrate);//年利率  
	  		BigDecimal len1= new BigDecimal(360);//一年360天
	  		BigDecimal drate_1 = yrate_1.divide(len1,6,BigDecimal.ROUND_UP);//天利率
	  		try {
	  	    	int  items_1=DateTool.getMonth(startTime, endTime);//需要还款期数
	  	    	System.out.println("=======once=========="+items_1);
	  	    	System.out.println(endTime.substring(6, 8)+"================="+Integer.parseInt(gdhkr));
	  	    	//按月结息
	  			if("0".equals(value)){	  		
	  				items=items_1;
	  			}else{
	  				//按季结息
	  			    items = items_1 / 3;
					if (items_1 % 3 != 0) {
						items =items+1;
					}
	  			}
	  		} catch (Exception e) {	  			
	  			e.printStackTrace();
	  		}
	  		System.out.println("=====还款期数=========="+items);
	  	    for(int i=0;i<items;i++){
	  		   if(i==0){
	  			 String actualrepaydt="";
	  			   if("0".equals(value)){
	  				 actualrepaydt = getActualRepaydt(startTime,gdhkr,value);//实际还款日期
	  			   }else{
	  				   if(Integer.parseInt(startTime.substring(6, 8))==Integer.parseInt(gdhkr)){
	  					 actualrepaydt=getJdMothTime(startTime);
	  				   }else{
	  					 actualrepaydt = getJdTime(startTime, gdhkr);
	  				   }
	  			   }
	  			 
		    	  long day = getDay(startTime, actualrepaydt);//天数
		          BigDecimal  repayinstamnt = bsnsBill.getDueamnt().multiply(drate_1).multiply(new BigDecimal(day)).divide(new BigDecimal(1),2,BigDecimal.ROUND_HALF_EVEN);//利息
	  		      BigDecimal currepayamnt=new BigDecimal(0);//本金
	  		      BsnsRepayplan bsnsRepayplan = getBsnsRepayplan(bsnsBill, actualrepaydt, repayinstamnt, currepayamnt, intrstmd);
	  		      if(i==items-1){
	  		    	  //待归还本金金额
	  		    	  bsnsRepayplan.setTbrepaypttl(bsnsBill.getDueamnt());	  		    	
	  			   }
	  		      bsnsRepayplanList.add(bsnsRepayplan);
	  		      continue;
	  		   } else if(i>0&&i<items-1){
	  			   String actualrepaydt = "";
	  			   if("0".equals(value)){
	  				  actualrepaydt = getActualRepaydt(bsnsRepayplanList.get(i-1).getCycleedt(),gdhkr,value);//实际还款日期
	  			   }else{
	  				 actualrepaydt=getJdMothTime(bsnsRepayplanList.get(i-1).getCycleedt());
	  			   }
	  			  
	  			   long day = getDay(bsnsRepayplanList.get(i-1).getCycleedt(), actualrepaydt);//天数
	  			   BigDecimal  repayinstamnt = bsnsBill.getDueamnt().multiply(drate_1).multiply(new BigDecimal(day)).divide(new BigDecimal(1),2,BigDecimal.ROUND_HALF_EVEN);//利息
	  			   BigDecimal currepayamnt=new BigDecimal(0);//本金
	  			   BsnsRepayplan bsnsRepayplan =getBsnsRepayplan1(bsnsBill, actualrepaydt, repayinstamnt, i,  bsnsBill.getDueamnt(), currepayamnt, intrstmd, bsnsRepayplanList);
	  			   bsnsRepayplanList.add(bsnsRepayplan);
	  		   } else {  //(i==items-1){
	  			 
	  			  String actualrepaydt = endTime;//实际还款日期
	  			  long day = getDay(bsnsRepayplanList.get(i-1).getCycleedt(), actualrepaydt);//天数
		          BigDecimal  repayinstamnt = bsnsBill.getDueamnt().multiply(drate_1).multiply(new BigDecimal(day)).divide(new BigDecimal(1),2,BigDecimal.ROUND_HALF_EVEN);//利息
	  		      BigDecimal currepayamnt=bsnsBill.getDueamnt();//本金
	  		      BsnsRepayplan bsnsRepayplan =getBsnsRepayplan2(bsnsBill, repayinstamnt, i, currepayamnt, intrstmd, bsnsRepayplanList);
	  		      bsnsRepayplanList.add(bsnsRepayplan); 
	  		   }
	  	    }
	  	    return bsnsRepayplanList;
	 }
	    	
	      /**
	       * 查询实际还款日期
	       */	      
	      public  static String getActualRepaydt(String startTime ,String gdhkr,String value){
	    	 // System.out.println("-----------------"+gdhkr);
	    	  System.out.println(startTime+"<<<<<<<<<<<<<<<<");
	    	  String actualrepaydt = "";//实际还款日期
	    	  if("0".equals(value)){ 
	    		  if(Integer.parseInt(startTime.substring(4, 6))==12){
	    			  if(Integer.parseInt(gdhkr)>Integer.parseInt(startTime.substring(6,8))){
	    				  actualrepaydt = startTime.substring(0, 4)+startTime.substring(4, 6)+gdhkr;
	    			  }else{	  	    	
	    				  actualrepaydt =String.valueOf(Integer.parseInt(startTime.substring(0, 4))+1)+"01"+gdhkr;
	    			  }
	    		  }else{
	    			  if(Integer.parseInt(gdhkr)>Integer.parseInt(startTime.substring(6,8))){	  	    	
	    				  actualrepaydt = startTime.substring(0, 4)+startTime.substring(4, 6)+gdhkr;
	    			  }else{	  	    	
	    				  if(Integer.parseInt(startTime.substring(4,6))<9){
	    					  actualrepaydt =startTime.substring(0,4) + "0"+String.valueOf(Integer.parseInt(startTime.substring(4,6))+1)+gdhkr;	   
	    				  }else{
	    					  actualrepaydt =startTime.substring(0,4)+String.valueOf(Integer.parseInt(startTime.substring(4,6))+1)+gdhkr;
	    				  }	  	    		   
	    			  }
	    		  }
	    	  }	    	  
	           return actualrepaydt;    	  
	      }
	      /**
	       * 按季度结息第一期的结束日期算法
	       */
	      public static String getJdTime(String startTime,String gdhkr){
	    	  String endTime = "";
	    	  if(Integer.parseInt(startTime.substring(4, 6))%3==0){
	    		    if(Integer.parseInt(startTime.substring(6, 8))<Integer.parseInt(gdhkr)){
	    		    	endTime = startTime.substring(0, 6)+gdhkr;
	    		    }else{
	    		    	 try {
							Date start = new  SimpleDateFormat("yyyyMMdd").parse(startTime);
							Calendar c = Calendar.getInstance();
							c.setTime(start);
							c.add(Calendar.MONTH, 3);
							endTime = new SimpleDateFormat("yyyyMMdd").format(c.getTime());
							endTime = endTime.substring(0, 6)+gdhkr;
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
	    		    }
	    	  }else{
	    		  if(Integer.parseInt(startTime.substring(4, 6))==4||Integer.parseInt(startTime.substring(4, 6))==5){
	    			     endTime = startTime.substring(0, 4)+"06"+gdhkr;
	    		  }
	    		  if(Integer.parseInt(startTime.substring(4, 6))==7||Integer.parseInt(startTime.substring(4, 6))==8){
	    			     endTime = startTime.substring(0, 4)+"09"+gdhkr;
	    		  }
	    		  if(Integer.parseInt(startTime.substring(4, 6))==10||Integer.parseInt(startTime.substring(4, 6))==11){
	    			     endTime = startTime.substring(0, 4)+"12"+gdhkr;
	    		  }
	    	  }
	    
	    	  
	    	  return endTime;
	      }
	      
		  /**
    	   * 按季中间月份时间
    	   */
    	  public static String getJdMothTime(String startTime){
    		  System.out.println(startTime);
    		  String endTime= null;
    		  try {
					Date start = new  SimpleDateFormat("yyyyMMdd").parse(startTime);
					Calendar c = Calendar.getInstance();
					c.setTime(start);
					c.add(Calendar.MONTH, 3);
					endTime = new SimpleDateFormat("yyyyMMdd").format(c.getTime());
					System.out.println("endTime="+endTime);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
    		  return endTime;
    	  }
	      /**
	       * 根据日期算天数
	       * @param args
	       */
	      public  static long getDay(String startTime,String endTime){
	    	    Date c=null;
	    		Date d = null;
				try {
					c = new SimpleDateFormat("yyyyMMdd").parse(startTime);
					d = new SimpleDateFormat("yyyyMMdd").parse(endTime);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return ((d.getTime()-c.getTime())/1000/60/60/24);
	      }
	      
	     /**
	      * 还款计划校验 
	      */
	     
}
