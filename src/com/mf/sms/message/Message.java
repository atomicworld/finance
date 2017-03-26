package com.mf.sms.message;

/**
 * 报文消息实体
 * 
 * 作为报文消息统一接口，包含报文长度报文头与报文体和报文体字节数组
 * 
 * @author joesun.jiang
 * 
 */
public class Message {

	// 报文体字节数组
	private byte[] bodyBytes;
	// 报文体
	private ObjectEncoder body;
	// 报文长度
	private int length;

	public Message(int length, byte[] bodyBytes) {
		this.length = length;
		this.bodyBytes = bodyBytes;
	}


	public byte[] getBodyBytes() {
		return bodyBytes;
	}

	public ObjectEncoder getBody() {
		return body;
	}

	public void setBody(ObjectEncoder body) {
		this.body = body;
	}

	public byte[] toBytes() {
		byte[] bytes = new byte[length];
		if(length != 0)
		{
			// 编入报文内容
			System.arraycopy(bodyBytes, 0, bytes, 0, length);
		}
		return bytes;
	}

}
