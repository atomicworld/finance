package com.mf.sms.message;

/**
 * 字节数组解码器
 * 
 * 将字节数组转化为报文实体对象
 * 
 * @author zhangkun
 *
 */
public interface ByteDecoder {

	public ObjectEncoder decode(byte[] bytes);

}
