package com.mf.sms.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.client.entity.ClntClient;
import com.mf.client.entity.ClntPerson;
import com.mf.client.service.ClntClientService;
import com.mf.client.service.ClntPersonService;
import com.mf.cntrtmng.entity.BsnsCntrct;
import com.mf.cntrtmng.entity.BsnsRepayplan;
import com.mf.cntrtmng.service.BsnsCntrctService;
import com.mf.cntrtmng.service.BsnsRepayplanService;
import com.mf.common.pub.PubConstants;
import com.mf.common.util.StringUtil;
import com.mf.org.entity.Operator;
import com.mf.sms.sendMessage;
import com.mf.sms.client.MessageClient;
import com.mf.sms.entity.Message;
import com.mf.sms.entity.MessageModel;
import com.mf.sms.message.entity.SmsRequest;
import com.mf.sms.message.entity.SmsResponse;
import com.mf.sms.service.MessageModelService;
import com.mf.sms.service.MessageService;

import com.mf.sms.parseMessage;

@Controller
@RequestMapping(value="/mf/sms/message/")
public class MessageSendController {
	
	@Autowired
	private MessageClient msgClient;
	@Autowired
	private ClntClientService clntClientService;
	@Autowired
	private ClntPersonService clntPersonService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private MessageModelService messageModelService;
	@Autowired
	private BsnsCntrctService bsnsCntrctService;
	@Autowired
	private BsnsRepayplanService bsnsRepayplanService;
	
	
	
	/**
	 * @param clntno:客户编号
	 * @param model
	 * @param request
	 * @return
	 * fankb
	 * 调用短信接口，发送催收短信
	 */
	@RequestMapping(value="sendmsg")
    @ResponseBody
	public void sendmsg(Model model,HttpServletRequest request,HttpServletResponse resp) throws Exception{
		//根据页面传来的信息，确定短信模板
		
		String clntno = request.getParameter("clntno");
		String modelNo = request.getParameter("modelNo");
		String cntrctno = request.getParameter("cntrctno");
		String srlno = request.getParameter("srlno");
		
		BsnsCntrct bsnsCntrct = bsnsCntrctService.getByApplyno(cntrctno);
		BsnsRepayplan bsnsRepayplan = bsnsRepayplanService.getById(srlno);
		
		String retMsg = new String();
		Message message = new Message();
		ClntPerson personTmp = new ClntPerson();
		
		String t_date = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
		String t_time = StringUtil.getFormatDate(new Date(), "HHmmss");

		Operator operator = (Operator)request.getSession().getAttribute("operator");
		//从短信模板表中获取短信内容
		MessageModel messageModel = messageModelService.getById(modelNo);  
		if(messageModel == null || StringUtil.isEmpty(messageModel.getContent())) {
			retMsg = "未能正确设置短信模板内容，请确认模板表内数据正确设置";
		}

		ClntClient client = clntClientService.getById(clntno);

		//短信编号
		StringBuffer serialNo = new StringBuffer();
		String serialTmp = SerialNum(messageService.getSerialNO(t_date));		
		serialNo.append(t_date.substring(2)).append(serialTmp);
		
		//替换内容,获取替换短信内容的变量	clntnm、money、date、cntrno
		String clntnm = client.getClntname();
		String msg_context = messageModel.getContent();				//取到短信内容
		
        Map<String, String> context = new HashMap<String, String>();
    	context.put("clntnm", clntnm);
    	context.put("cntrctno", cntrctno);
    	
        if(bsnsRepayplan != null){//
            context.put("money", bsnsRepayplan.getCurrepayamnt().toString());//需归还本金金额
            context.put("t_money", bsnsRepayplan.getRepayinstamnt().toString());//需归还利息金额
            context.put("date", bsnsRepayplan.getCycleedt());//还款周期结束日期
        }else if(bsnsCntrct != null){
        	context.put("money", bsnsCntrct.getCntrctamnt().toString());//合同总金额
        	context.put("date", bsnsCntrct.getCntrctedate());//合同结束日期
        }else{
        	retMsg = "找不到该客户的指定记录";
        }
        String render = parseMessage.render(msg_context, context );
        String t_msgcontext= render.substring(0, render.length()-2);
		
		String clnttype = client.getClnttype();
		//个人客户有手机号码，企业客户暂时没有手机号
		if(clnttype.equalsIgnoreCase(PubConstants.CLNT_TYPE_PERSON)){ 
			personTmp = clntPersonService.findByClntno(clntno);
		}
		System.out.println(t_msgcontext);
		try {
			if(messageModel.getIsused().equals("1")){
				if(personTmp !=null && StringUtil.isEmpty( personTmp.getMobiletel()) == false){
					SmsRequest req = new SmsRequest();
					req.setORG_ID(PubConstants.SMS_ORG_ID);//短信服务端号
					req.setSMS_NO(serialNo.toString());	//短信编号（编号长度不能超过10位）
	
					req.setSMS_TYPE(PubConstants.SMS_DOWNTYPE);//短信类型
					req.setTEL(personTmp.getMobiletel());	//收件人电话号码
//					req.setTEL("15221694247");	//收件人电话号码
					req.setCONTENT(t_msgcontext);//短信内容
//					req.setCONTENT("您好，您申请的15769.76元10002015052200001号贷款合同，将于20150628逾期");//短信内容
//					req.setCONTENT("您好，您申请了10000元!!");//短信内容
					req.setREQUEST_TIME(StringUtil.getFormatDate(new Date(), "yyyyMMddHHmmss"));//发送时间
					req.setSEND_TIME("");
					req.setRESERVED("");
					req.setRESP_DETAIL("");
					sendMessage sendMsg = new sendMessage();
					SmsResponse smsResp = sendMsg.sendSms(msgClient, req);
					
	
					message.setNo(serialNo.toString());	//短信流水号作为主键
					message.setCntrctno(cntrctno);//合同编号
					message.setSrlno(srlno);//还款计划编号
					message.setMstype(req.getSMS_TYPE());//短信类型
					message.setRecipientname(client.getClntname());//收件人姓名
					message.setRecipienttel(req.getTEL());//收件人电话
					message.setRecipientcertno(client.getCertno());//收件人证件号码
					message.setRecipienttype(client.getClnttype());//客户类型
					message.setModelno(messageModel.getTypeid());//短信模板编号
					message.setSendername(operator.getOpnm());// 发件人姓名
					message.setSenderid(operator.getEmplyno());// 发件人id号
					message.setSdate(t_date);//发送日期
					message.setStime(t_time);//发送时间
					
					if(smsResp.getRESP_FLAG().equals(PubConstants.SMS_SUCCESS)) {
						retMsg= new String("Congratulations, the message send successfully!");
						message.setState(PubConstants.SMS_SUCCESS);
						messageService.add(message);
					} else {
						retMsg=smsResp.getRESP_DETAIL();
						message.setState(PubConstants.SMS_FAILED);
						//记录失败原因
						message.setRemark(retMsg);	
						messageService.add(message);
					}
				}else{
					retMsg = "The client don't fill in phone number.";
//					retMsg = "客户不存在或者未留电话号码！";
				}
			}else{
				retMsg="The Message Service is not opened. ";
//				retMsg="短信功能未启用";
			}
			
		}catch(Exception e) {
			System.out.println("Error Message : " + e.toString());			
			retMsg= "Sorry,The short message sent failure!";
		}
		resp.getWriter().write(retMsg);
	}
	
	//---------------------------------------------
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
