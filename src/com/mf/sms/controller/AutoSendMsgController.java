package com.mf.sms.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mf.aftrmng.entity.AfterWarnparm;
import com.mf.aftrmng.entity.BsnsRepayplanAll;
import com.mf.aftrmng.service.AfterWarnparmService;
import com.mf.client.entity.ClntClient;
import com.mf.client.entity.ClntPerson;
import com.mf.client.service.ClntClientService;
import com.mf.client.service.ClntPersonService;
import com.mf.cntrtmng.entity.BsnsBill;
import com.mf.common.pub.PubConstants;
import com.mf.common.util.StringUtil;
import com.mf.sms.parseMessage;
import com.mf.sms.sendMessage;
import com.mf.sms.client.MessageClient;
import com.mf.sms.entity.Message;
import com.mf.sms.entity.MessageModel;
import com.mf.sms.message.entity.SmsRequest;
import com.mf.sms.message.entity.SmsResponse;
import com.mf.sms.service.AutoMessageService;
import com.mf.sms.service.MessageModelService;
import com.mf.sms.service.MessageService;


@Controller
@RequestMapping(value="/mf/sms/autosendmsg/")
public class AutoSendMsgController {
	
	@Autowired
	private MessageClient msgClient;
	@Autowired
	private MessageModelService messageModelService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private AfterWarnparmService afterWarnparmService;
	@Autowired
	private AutoMessageService autoMessageService;
	@Autowired
	private ClntPersonService clntPersonService;
	@Autowired
	private ClntClientService clntClientService;
	
	
	public void work(){
		this.LoanTimeSend();
		this.RtrnTimeSend();
	}
	
	
	//合同到期短信提醒
	public void LoanTimeSend(){
		String t_date = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
		String t_time = StringUtil.getFormatDate(new Date(), "HHmmss");
		
		MessageModel messageModel = messageModelService.getById("1007");//短信模板  
		AfterWarnparm warnparm=new AfterWarnparm();// 查询需要发送的信息
		warnparm.setWarnnm("贷款到期预警");
		warnparm = afterWarnparmService.findByWarnnm(warnparm);//获取预警时间参数
		List<BsnsBill> list = autoMessageService.queryLoanTime(warnparm.getWarnday());
		Iterator<BsnsBill> it_1 = list.iterator();
		while(it_1.hasNext()){
			BsnsBill bsnsBill = it_1.next(); 
			
			//短信编号
			StringBuffer serialNo = new StringBuffer();
			String serialTmp = SerialNum(messageService.getSerialNO(t_date));		
			serialNo.append(t_date.substring(2)).append(serialTmp);
			
			serialNo.append(t_date.substring(2)).append(serialTmp);
			ClntClient client = clntClientService.getById(bsnsBill.getClntno());
			ClntPerson person = clntPersonService.findByClntno(bsnsBill.getClntno());
			
			//替换内容,获取替换短信内容的变量
			String msg_context = messageModel.getContent();	//取到短信内容
			Map<String, String> context = new HashMap<String, String>();
	    	context.put("clntnm", bsnsBill.getClntnm());
	    	context.put("cntrctno", bsnsBill.getCntrctno());
	    	context.put("money",bsnsBill.getLnamnt().toString());
	    	context.put("date",bsnsBill.getMtrtydate());
	    	String render = parseMessage.render(msg_context, context );
	        String t_msgcontext= render.substring(0, render.length()-2);
	        
	        Message message = new Message();
	        if(messageModel.getIsused().equals("1")){
		        try {
		        	SmsRequest req = new SmsRequest();
					req.setORG_ID(PubConstants.SMS_ORG_ID);//短信服务端号
					req.setSMS_NO(serialNo.toString());	//短信编号（编号长度不能超过10位）
	
					req.setSMS_TYPE(PubConstants.SMS_DOWNTYPE);//短信类型
					req.setTEL(person.getMobiletel());	//收件人电话号码
					req.setCONTENT(t_msgcontext);//短信内容
					req.setREQUEST_TIME(StringUtil.getFormatDate(new Date(), "yyyyMMddHHmmss"));//发送时间
					req.setSEND_TIME("");
					req.setRESERVED("");
					req.setRESP_DETAIL("");
					sendMessage sendMsg = new sendMessage();
					SmsResponse smsResp = sendMsg.sendSms(msgClient, req);
					
					message.setNo(serialNo.toString());	//短信流水号作为主键
					message.setCntrctno(bsnsBill.getCntrctno());//合同编号
					//还款计划编号 为空
					message.setMstype(req.getSMS_TYPE());//短信类型
					message.setRecipientname(person.getClntname());//收件人姓名
					message.setRecipienttel(req.getTEL());//收件人电话
					message.setRecipientcertno(client.getCertno());//收件人证件号码
					message.setRecipienttype(client.getClnttype());//客户类型
					message.setModelno(messageModel.getTypeid());//短信模板编号
					message.setSdate(t_date);//发送日期
					message.setStime(t_time);//发送时间
					
					if(smsResp.getRESP_FLAG().equals(PubConstants.SMS_SUCCESS)) {
						message.setState(PubConstants.SMS_SUCCESS);
						messageService.add(message);
					} else {
						message.setState(PubConstants.SMS_FAILED);
						//记录失败原因
						messageService.add(message);
					}
				}catch(Exception e) {
					System.out.println("Error Message : " + e.toString());			
				}
	        }else{
	        	System.out.println("自动发送短信功能未打开！");
	        }
		}
	}
		
	//还款到期短信提醒（按月）
	public void RtrnTimeSend(){
		String t_date = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
		String t_time = StringUtil.getFormatDate(new Date(), "HHmmss");

		//短信模板
		MessageModel messageModel = messageModelService.getById("1008");//
		
		//查询需要发送的信息
		AfterWarnparm warnparm=new AfterWarnparm();
		warnparm.setWarnnm("还款到期预警");
		warnparm = afterWarnparmService.findByWarnnm(warnparm);//获取预警时间参数
		List<BsnsRepayplanAll> list = autoMessageService.queryRtrnTime(warnparm.getWarnday());
		Iterator<BsnsRepayplanAll> it1 = list.iterator();
		while(it1.hasNext()){
			BsnsRepayplanAll bsnsRepayplanAll = it1.next(); 
			
			//短信编号
			StringBuffer serialNo = new StringBuffer();
			String serialTmp = SerialNum(messageService.getSerialNO(t_date));		
			serialNo.append(t_date.substring(2)).append(serialTmp);
			
			ClntClient client = clntClientService.getById(bsnsRepayplanAll.getClntno());
			ClntPerson person = clntPersonService.findByClntno(bsnsRepayplanAll.getClntno());
			
			//替换内容,获取替换短信内容的变量
			String msg_context = messageModel.getContent();	//取到短信内容
			Map<String, String> context = new HashMap<String, String>();
	    	context.put("clntnm", bsnsRepayplanAll.getClntnm());
	    	context.put("cntrctno", bsnsRepayplanAll.getCntrctno());
	    	context.put("money",bsnsRepayplanAll.getCurrepayamnt().toString());
	    	context.put("date",bsnsRepayplanAll.getCycleedt());
	    	String render = parseMessage.render(msg_context, context );
	        String t_msgcontext= render.substring(0, render.length()-2);
	    	
	        Message message = new Message();
	        if(messageModel.getIsused().equals("1")){
		        try {
		        	SmsRequest req = new SmsRequest();
					req.setORG_ID(PubConstants.SMS_ORG_ID);//短信服务端号
					req.setSMS_NO(serialNo.toString());	//短信编号（编号长度不能超过10位）
	
					req.setSMS_TYPE(PubConstants.SMS_DOWNTYPE);//短信类型
					req.setTEL(person.getMobiletel());	//收件人电话号码
					req.setCONTENT(t_msgcontext);//短信内容
					req.setREQUEST_TIME(StringUtil.getFormatDate(new Date(), "yyyyMMddHHmmss"));//发送时间
					req.setSEND_TIME("");
					req.setRESERVED("");
					req.setRESP_DETAIL("");
					sendMessage sendMsg = new sendMessage();
					SmsResponse smsResp = sendMsg.sendSms(msgClient, req);
					
					message.setNo(serialNo.toString());	//短信流水号作为主键
					message.setCntrctno(bsnsRepayplanAll.getCntrctno());//合同编号
					message.setSrlno(bsnsRepayplanAll.getSrlno());//还款计划编号
					message.setMstype(req.getSMS_TYPE());//短信类型
					message.setRecipientname(person.getClntname());//收件人姓名
					message.setRecipienttel(req.getTEL());//收件人电话
					message.setRecipientcertno(client.getCertno());//收件人证件号码
					message.setRecipienttype(client.getClnttype());//客户类型
					message.setModelno(messageModel.getTypeid());//短信模板编号
					message.setSdate(t_date);//发送日期
					message.setStime(t_time);//发送时间
					
					if(smsResp.getRESP_FLAG().equals(PubConstants.SMS_SUCCESS)) {
						message.setState(PubConstants.SMS_SUCCESS);
						messageService.add(message);
					} else {
						message.setState(PubConstants.SMS_FAILED);
						//记录失败原因
						messageService.add(message);
					}
				}catch(Exception e) {
					System.out.println("Error Message : " + e.toString());			
				}
	        }else{
	        	System.out.println("自动发送短信功能未打开！");
	        }
		}
	}
		
	//------------- 生成流水号
	private String SerialNum(int num){
		num = num +1;
		if(num <10) {
			return "000" + num;
		} else if(num <100) {
			return "00" + num;
		} else if(num <1000) {
			return "0" + num;
		} else if(num <10000) {
			return String.valueOf(num) ;
		} else  {
			return "999999";
		}
	}
	
	
}
