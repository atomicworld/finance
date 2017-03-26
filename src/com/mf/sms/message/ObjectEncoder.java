package com.mf.sms.message;

/**
 * 对象编码器
 * 
 * 将报文实体对象转化为字节数组
 * 
 * @author zhangkun
 *
 */
public interface ObjectEncoder {

	public byte[] toBytes();
	
}
