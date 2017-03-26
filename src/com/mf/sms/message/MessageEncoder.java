package com.mf.sms.message;

import org.apache.commons.lang.StringUtils;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 报文编码器
 * 
 * 从实体转化为字节数组
 * 
 * @author joesun.jiang
 * 
 */
public class MessageEncoder extends ProtocolEncoderAdapter {

	private static Logger logger = LoggerFactory
			.getLogger(MessageEncoder.class);

	public void encode(IoSession session, Object message,
			ProtocolEncoderOutput out) throws Exception {
		if(message instanceof Message)
		{
			Message msg = (Message) message;
			// 编码报文对象
			byte[] bytes = msg.toBytes();
			IoBuffer buf = IoBuffer.allocate(bytes.length, false);
			buf.setAutoExpand(true);
			// 写入报文长度
			String lenStr = StringUtils.leftPad(String.valueOf(bytes.length), 4, "0");
			logger.debug("报文长度="+lenStr);
			//buf.putInt(bytes.length);
			buf.put(lenStr.getBytes());
			// 写入报文内容
			buf.put(bytes);
			buf.flip();
			logger.debug("发送到对方的报文[" + new String(bytes, "UTF-8") + "]");
			out.write(buf);
		}
		else
		{
			byte[] bytes = "0".getBytes();
			IoBuffer buf = IoBuffer.allocate(bytes.length, false);
			buf.setAutoExpand(true);
			// 写入报文长度
			buf.putInt(bytes.length);
			// 写入报文内容
			buf.put(bytes);
			buf.flip();
			logger.debug("发送到对方的报文[" + new String(bytes, "UTF-8") + "]");
			out.write(buf);
		}
		
	}
}
