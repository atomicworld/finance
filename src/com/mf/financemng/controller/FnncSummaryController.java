package com.mf.financemng.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.common.pub.PubConstants;
import com.mf.common.util.WaterIdGener;
import com.mf.financemng.entity.FnncAccntitem;
import com.mf.financemng.entity.FnncChckprfbs;
import com.mf.financemng.entity.FnncChckprfdtl;
import com.mf.financemng.entity.FnncCrryovraccnt;
import com.mf.financemng.entity.FnncLedger;
import com.mf.financemng.entity.FnncPrfbs;
import com.mf.financemng.entity.FnncPrfdtl;
import com.mf.financemng.entity.FnncPrfdtlList;
import com.mf.financemng.service.FnncChckprfbsService;
import com.mf.financemng.service.FnncChckprfdtlService;
import com.mf.financemng.service.FnncCrryovraccntService;
import com.mf.financemng.service.FnncLedgerService;
import com.mf.financemng.service.FnncPrfbsService;
import com.mf.org.entity.Operator;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;

@Controller
@RequestMapping(value="/mf/financemng/summary/")
public class FnncSummaryController {
	@Autowired
	private FnncLedgerService fnncledgerservice;
	@Autowired
	private FnncCrryovraccntService fnncCrryovraccntService;
	@Autowired
	private FnncChckprfdtlService fnncChckprfdtlService;
	@Autowired
	private FnncChckprfbsService fnncChckprfbsService;
	
	@RequestMapping(value="summary")
	public String summary(Model model){
		PageView pageView = null;
		String pageNow="1";
		String pageSize="10";
		pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		FnncCrryovraccnt fnnccrryovraccnt=new FnncCrryovraccnt();
		 boolean ishave = fnncCrryovraccntService.queryLen(pageView, fnnccrryovraccnt);
		 model.addAttribute("ishave", ishave);
		return "/mf/financemng/cwjz/summary/summary";
	}
	@RequestMapping(value="recoverPage")
	public String recoverPage(Model model){
		return "/mf/financemng/cwjz/recover/recover";
	}
	
	
	/**
	* @author wangyaowei
	* @date 2015-3-11上午12:01:42
	* @Title: gather
	* @Description: TODO(汇总操作)
	* @param model
	* @param fnncprfdtllist
	* @param response
	* @param request
	* @return
	* @return String    返回类型
	* @throws
	*/
	@RequestMapping(value="gather")
	public String gather(Model model,FnncPrfdtlList fnncprfdtllist,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"汇总成功!\",\"status\":\"1\"}";
		try {
			
			/**1  判断是否已经执行过汇总 复核状态为J*/
			int stt=fnncledgerservice.getCount(PubConstants.JZ_J);
			if(stt>0){
				 result="{\"msg\":\"已存在汇总数据,请进行结转!\",\"status\":\"1\"}";
				 WebTool.writeJson(result, response);
				 return null;
			}
			
			// 2判断是否已经执行过总账初始化，即总账表中是否有数据，若有初始化则继续，若未初始化则提示未进行总账初始化；
			int allC=fnncledgerservice.getAllCount();
			if(allC<1){
				 result="{\"msg\":\"总账表中无数据,请先执行过总账初始化!\",\"status\":\"1\"}";
				 WebTool.writeJson(result, response);
				 return null;
			}
			//要汇总的月份
			String month=fnncledgerservice.getMaxMonth(PubConstants.JZ_N);
			if(month==null||month=="null"){
				 result="{\"msg\":\"汇总数据为空,请检查是否录入复合凭证!\",\"status\":\"1\"}";
				 WebTool.writeJson(result, response);
				 return null;
			}
			
			/**判断结转月份是否已经结转 如果已结转请提示恢复数据再结转*/
			String ledgerdate=month.substring(0, 6);
			int ishave=fnncledgerservice.isHave(ledgerdate);
			if(ishave>0){
				 result="{\"msg\":\"此月份数据已汇总,请先进行数据恢复。再汇总!\",\"status\":\"1\"}";
				 WebTool.writeJson(result, response);
				 return null;
			}
			//更新汇总日期
			fnncledgerservice.updateLedgerDate(month);
			// 3执行数据备份；
			fnncledgerservice.updateLedger("2");//原始数据
			fnncledgerservice.copyFnncLedger();
			
			
			/**	查找总账表中没有的科目将没有的科目信息插入fnnc_ledger表，所有金额都为0； */
			List<FnncAccntitem> titem=fnncledgerservice.getInstr();
			if(titem.size()>0){
				BigDecimal val=new BigDecimal(0);
				for(int i=0;i<titem.size();i++){
					FnncLedger ledger=new FnncLedger();
					ledger.setAccntno(titem.get(i).getAccntno());
					ledger.setDbqAmt(val);
					ledger.setDqcBal(val);
					ledger.setDqmBal(val);
					ledger.setDysumAmt(val);
					ledger.setJbqAmt(val);
					ledger.setJqcBal(val);
					ledger.setJqmBal(val);
					ledger.setJysumAmt(val);
					ledger.setLedgerdate(month);
					ledger.setFlag("2");
					ledger.setAccntdrct(titem.get(i).getAccntdrct());
					fnncledgerservice.add(ledger);
				}
			}
			
			//（1）	从总账表（fnnc_ledger）中获得当前日期，select min(tx_date)，若为空则终止；
			//（2）	更新总账表每条数据状态位为0；（取消）
			//（5）	执行以前月末未汇总数据checkAndExce
			//（6）	执行当期数据汇总
			// a)	checkWeek判断进行何种期初处理（取消）
			// b)	do_qs_exec进行期初处理（取消）

			/**执行汇总*/
			List<FnncPrfdtlList> accnt=fnncledgerservice.getAccntList(fnncprfdtllist);
			for(int i=0;i<accnt.size();i++){
				FnncLedger acct=null;
				if("1".equals(accnt.get(i).getJdflg())){//1 借 2贷 
					acct=fnncledgerservice.getByAccntno(accnt.get(i).getAccntno());
					acct.setJbqAmt(accnt.get(i).getAmnt());
					fnncledgerservice.updateByAccntno(acct);
				}else{
					acct=fnncledgerservice.getByAccntno(accnt.get(i).getAccntno());
					acct.setDbqAmt(accnt.get(i).getAmnt());
					fnncledgerservice.updateByAccntno(acct);
				}
			}
			
			
			/**若余额方向与发生额方向相同，则累加，否则做减**/
			List<FnncPrfdtlList> newaccnt = deleteRepeat(accnt); //zc修改    去掉重复的科目
			for(int i=0;i<newaccnt.size();i++){
				FnncLedger acct=fnncledgerservice.getByAccntno(newaccnt.get(i).getAccntno());
				String drct=acct.getAccntdrct();
				/**判断余额方向  累计期末金额
				 * 1 jqm_bal=jqm_bal+jbq_amt-dbq_amt;
				 * 2 dqm_bal=dqm_bal+dbq_amt-jbq_amt;
				 */
				if("1".equals(drct)){
					BigDecimal jqm=acct.getJqmBal().add(acct.getJbqAmt().subtract(acct.getDbqAmt()));
					acct.setJqmBal(jqm);
				}else{
					BigDecimal dqm=acct.getDqmBal().add(acct.getDbqAmt().subtract(acct.getJbqAmt()));
					acct.setDqmBal(dqm);
				}
				/** 
				 *累加本年累计金额
				 *jysum_amt=jysum_amt+jbq_amt;
				 *dysum_amt=dysum_amt+dbq_amt;
				 */
				acct.setJysumAmt(acct.getJysumAmt().add(acct.getJbqAmt()));
				acct.setDysumAmt(acct.getDysumAmt().add(acct.getDbqAmt()));
				fnncledgerservice.updateByAccntno(acct);
			}
			
			//备份汇总数据
				fnncledgerservice.updateLedger("1");
				fnncledgerservice.copyFnncLedger();
			
			/** 执行完成汇总操作 更新汇总数据状态 */
				fnncledgerservice.updateAccntflg(PubConstants.JZ_J);
				
				
		} catch (Exception e) {
			result="{\"msg\":\"汇总失败\",\"status\":\"2\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	public List<FnncPrfdtlList> deleteRepeat(List<FnncPrfdtlList> accnt){
		Map m = new HashMap();
		List<FnncPrfdtlList> newaccnt = new ArrayList<FnncPrfdtlList>();
		for(FnncPrfdtlList acc :  accnt){
			String accntno = acc.getAccntno();
			if(!m.containsKey(accntno)){  
	            m.put(accntno, accntno);  
	            newaccnt.add(acc);  
	        }  
		}
		return newaccnt;
	}
	
	/**
	* @author wangyaowei
	* @date 2015-3-11下午10:52:28
	* @Title: showlist
	* @Description: TODO(查看要结转的数据)
	* @param model
	* @param fnnccrryovraccnt
	* @param request
	* @return
	* @return Map<String,Object>    返回类型
	* @throws
	*/
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,FnncCrryovraccnt fnnccrryovraccnt,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = fnncCrryovraccntService.queryJZ(pageView, fnnccrryovraccnt);
		List<FnncPrfdtl> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		model.addAttribute("listSize", pageView.getRowCount());
		return map;
	}
	
	
	/**
	* @author wangyaowei
	* @date 2015-3-10下午11:48:56
	* @Title: crryOvr
	* @Description: TODO(执行结转操作)
	* @param model
	* @param response
	* @param request
	* @return
	* @return String    返回类型
	* @throws
	*/
	@RequestMapping(value="crryOvr")
	public String crryOvr(Model model,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"结转成功!\",\"status\":\"1\"}";
		try {
			//SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			//判断当前期是否已结转
			int stt=fnncledgerservice.getCount("J");
			if(stt>0){//汇总是否执行
				//执行结转
				List<FnncLedger> sumcrryovr=fnncledgerservice.crryOvr();
				//汇总到指定结转科目号
				String jzkm=fnncledgerservice.getJzkm();
				FnncLedger fnncledger=fnncledgerservice.getByAccntno(jzkm);//数据库获取编号
				//0 收入类  1 支出类
				BigDecimal dbqamt=(sumcrryovr.get(0).getDbqAmt()).subtract(sumcrryovr.get(0).getJbqAmt());
				BigDecimal jbqamt=(sumcrryovr.get(1).getJbqAmt()).subtract(sumcrryovr.get(1).getDbqAmt());
				fnncledger.setDbqAmt(dbqamt);
				fnncledger.setJbqAmt(jbqamt);
				fnncledger.setJysumAmt(fnncledger.getJysumAmt().add(jbqamt));
				fnncledger.setDysumAmt(fnncledger.getDysumAmt().add(dbqamt));
				fnncledger.setDqmBal(fnncledger.getDqmBal().add(dbqamt.subtract(jbqamt)));
				//保存结转数据
				fnncledgerservice.updateByAccntno(fnncledger);
				
				//插入复核详细表
				Operator operator = (Operator)request.getSession().getAttribute("operator");
				String opno=operator.getEmplyno();//操作员编号
				String dptno=operator.getDptno();//部门编号
				String accntxx=WaterIdGener.getWaterId();//流水号
				FnncChckprfbs fnncchckprfbs=new FnncChckprfbs();
				fnncchckprfbs.setPrftrcno(accntxx+opno);//流水号
				fnncchckprfbs.setOpno(opno);//操作员
				fnncchckprfbs.setPrfcrtdt(fnncledger.getLedgerdate());//发生日期
				fnncchckprfbs.setRemark("本期收入总额");//摘要
				fnncchckprfbs.setAccntflg(PubConstants.PRFBS_STT_RESULT);//默认登记状态
				fnncchckprfbs.setChckprftyp("YS");
				fnncchckprfbs.setChcktrcno("YS"+accntxx);//凭证编号
				//4103 结转总额
				FnncLedger total=fnncledgerservice.getByAccntno(jzkm);
				FnncChckprfdtl chckprfdtl=new FnncChckprfdtl();
				String sqnno1=WaterIdGener.getWaterId();//流水号
				chckprfdtl.setChcktrcno("YS"+accntxx);
				chckprfdtl.setSqnno(sqnno1);
				chckprfdtl.setDptno(dptno);
				chckprfdtl.setOpno(opno);
				chckprfdtl.setCurrncy("CNY");
				chckprfdtl.setChckprftyp("YS");
				chckprfdtl.setAccntno(total.getAccntno());//科目号
				boolean stu=(total.getJbqAmt().subtract(total.getDbqAmt())).longValue()>=0L;
				if(stu){//类型
					chckprfdtl.setJdflg("1");//借
				}else{
					chckprfdtl.setJdflg("2");//贷
				}
				chckprfdtl.setPrfcrtdt(total.getLedgerdate());//日期
				chckprfdtl.setAmnt((total.getDbqAmt().subtract(total.getJbqAmt())).abs());//金额
				chckprfdtl.setStt(PubConstants.CHCKPRFBS_ACCNTFLG_STT);//状态
				fnncChckprfdtlService.add(chckprfdtl);
				//生成结转明细表
				fnncChckprfbsService.add(fnncchckprfbs);//保存
				List<FnncLedger> infoList=fnncledgerservice.getInfo();
				for(int i=0;i<infoList.size();i++){
					String sqnno=WaterIdGener.getWaterId();//流水号
					if(infoList.get(i).getJbqAmt().intValue()!=0){
						FnncChckprfdtl instr=new FnncChckprfdtl();
						instr.setChcktrcno("YS"+accntxx);
						instr.setSqnno(sqnno);
						instr.setDptno(dptno);
						instr.setOpno(opno);
						instr.setCurrncy("CNY");
						instr.setChckprftyp("YS");
						instr.setAccntno(infoList.get(i).getAccntno());
						instr.setAmnt(infoList.get(i).getJbqAmt());
						instr.setPrfcrtdt(infoList.get(i).getLedgerdate());
						instr.setJdflg("2");
						instr.setStt(PubConstants.CHCKPRFBS_ACCNTFLG_STT);
						fnncChckprfdtlService.add(instr);
					}
					if(infoList.get(i).getDbqAmt().intValue()!=0){
						FnncChckprfdtl instr=new FnncChckprfdtl();
						instr.setChcktrcno("YS"+accntxx);
						instr.setSqnno(sqnno);
						instr.setDptno(dptno);
						instr.setOpno(opno);
						instr.setCurrncy("CNY");
						instr.setChckprftyp("YS");
						instr.setAccntno(infoList.get(i).getAccntno());
						instr.setPrfcrtdt(infoList.get(i).getLedgerdate());
						instr.setAmnt(infoList.get(i).getDbqAmt());
						instr.setJdflg("1");
						instr.setStt(PubConstants.CHCKPRFBS_ACCNTFLG_STT);
						fnncChckprfdtlService.add(instr);
					}
					

				}
				//置零收入类数据
				fnncledgerservice.updateSixPrfix("6");
				//保证收支平衡
				fnncledgerservice.updatejy();
				fnncledgerservice.updatejd();
				//设置备份状态
				fnncledgerservice.updateLedger("0");
				//执行数据备份；
				fnncledgerservice.copyFnncLedger();
				//更新复核表的记录状态
				fnncledgerservice.changeAccntflg("Y");
				//本月发生额置零
				fnncledgerservice.updateBqAmt();
				
			}else{
				result="{\"msg\":\"无汇总数据,请执行汇总!\",\"status\":\"1\"}";
			}
			
		} catch (Exception e) {
			result="{\"msg\":\"结转失败\",\"status\":\"2\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	
	/**
	* @author wangyaowei
	* @date 2015-3-11上午12:19:04
	* @Title: recover
	* @Description: TODO(实现数据恢复操作)
	* @throws
	*/
	@RequestMapping(value="recover")
	public String recover(Model model,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"执行成功,已恢复汇总前状态!\",\"status\":\"1\"}";
		try {
			//判断是当前汇总状态
			int nums=fnncledgerservice.getCount(PubConstants.JZ_J);
			if(nums>0){//已汇总未结转
				//获取最近一次汇总的月份时间
				String month=fnncledgerservice.getMaxMonth(PubConstants.JZ_J);
				//删除汇总表
				fnncledgerservice.del();
				//恢复汇总表
				fnncledgerservice.recoverFnncLedger();
				//删除备份表
				fnncledgerservice.delefnncledgerlog(PubConstants.JZ_J);
				//恢复复核表
				fnncledgerservice.recoverFnncChckprfbs(month.substring(0,6));
				result="{\"msg\":\"执行成功,汇总数据已恢复!\",\"status\":\"1\"}";
			}else{
				if(nums==0){//已汇总已结转
					int  stt=fnncledgerservice.getLogCount();
					if(stt>0){
						//判断当前恢复的是汇总表还是总账表
							//获取最近一次汇总的月份时间
							String month=fnncledgerservice.getMaxMonth("Y");
							//删除汇总表
							fnncledgerservice.del();
							//恢复汇总表
							fnncledgerservice.recoverFnncLedger();
							//删除备份表
							fnncledgerservice.delefnncledgerlog("Y");
							//删除汇总明细表
							fnncledgerservice.deleteLedgerInfo(PubConstants.CHCKPRFBS_ACCNTFLG_STT);
							//恢复复核详情表
							fnncledgerservice.recoverFnncChckprfbs(month.substring(0,6));
							//恢复复合表
							fnncledgerservice.recoverFnncChckprfdtl(month.substring(0,6));
						}else{
							result="{\"msg\":\"无数据需要恢复，请执行结转!\",\"status\":\"1\"}";
						}
				}
			}
			
		} catch (Exception e) {
			result="{\"msg\":\"恢复失败\",\"status\":\"2\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
}
