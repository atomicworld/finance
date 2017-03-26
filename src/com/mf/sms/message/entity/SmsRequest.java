package com.mf.sms.message.entity;

import com.mf.sms.message.ObjectEncoder;
import com.mf.sms.message.utils.MessageUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.xml.XmlFriendlyReplacer;
import com.thoughtworks.xstream.io.xml.XppDriver;

@XStreamAlias("SMS")
public class SmsRequest implements ObjectEncoder
{

	public static XStream xStream = new XStream(new XppDriver(new XmlFriendlyReplacer("__", "_")));
	
	private String ORG_ID;
	private String SMS_NO;
	private String SMS_TYPE;
	private String TEL;
	private String CONTENT;
	private String REQUEST_TIME;
	private String SEND_TIME;
	private String RESERVED;
	private String RESP_FLAG = "";
	private String RESP_DETAIL;
	
	@Override
	public byte[] toBytes()
	{
		return MessageUtil.encode(xStream, this);
	}

	public String getORG_ID()
	{
		return ORG_ID;
	}

	public void setORG_ID(String oRG_ID)
	{
		ORG_ID = oRG_ID;
	}

	public String getSMS_NO()
	{
		return SMS_NO;
	}

	public void setSMS_NO(String sMS_NO)
	{
		SMS_NO = sMS_NO;
	}

	public String getSMS_TYPE()
	{
		return SMS_TYPE;
	}

	public void setSMS_TYPE(String sMS_TYPE)
	{
		SMS_TYPE = sMS_TYPE;
	}

	public String getTEL()
	{
		return TEL;
	}

	public void setTEL(String tEL)
	{
		TEL = tEL;
	}

	public String getCONTENT()
	{
		return CONTENT;
	}

	public void setCONTENT(String cONTENT)
	{
		CONTENT = cONTENT;
	}

	public String getREQUEST_TIME()
	{
		return REQUEST_TIME;
	}

	public void setREQUEST_TIME(String rEQUEST_TIME)
	{
		REQUEST_TIME = rEQUEST_TIME;
	}

	public String getSEND_TIME()
	{
		return SEND_TIME;
	}

	public void setSEND_TIME(String sEND_TIME)
	{
		SEND_TIME = sEND_TIME;
	}

	public String getRESERVED()
	{
		return RESERVED;
	}

	public void setRESERVED(String rESERVED)
	{
		RESERVED = rESERVED;
	}

	public String getRESP_FLAG()
	{
		return RESP_FLAG;
	}

	public void setRESP_FLAG(String rESP_FLAG)
	{
		RESP_FLAG = rESP_FLAG;
	}

	public String getRESP_DETAIL()
	{
		return RESP_DETAIL;
	}

	public void setRESP_DETAIL(String rESP_DETAIL)
	{
		RESP_DETAIL = rESP_DETAIL;
	}

}
