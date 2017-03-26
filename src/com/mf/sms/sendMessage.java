package com.mf.sms;

import com.mf.sms.client.MessageClient;
import com.mf.sms.message.Message;
import com.mf.sms.message.entity.SmsRequest;
import com.mf.sms.message.entity.SmsResponse;

public class sendMessage {

	public SmsResponse sendSms(MessageClient smsClient,SmsRequest req)
	{
		byte[] bytes = req.toBytes();
		Message msg = new Message(bytes.length, bytes);
		Message resp = smsClient.write(msg);
		System.out.println("resp====>" +resp);
		if(resp != null)
			return (SmsResponse)SmsResponse.parseXml(resp.getBodyBytes());
		else
			return null;
	}
	
}
