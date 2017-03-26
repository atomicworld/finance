package com.mf.sms.message;



import org.apache.commons.codec.binary.Hex;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderAdapter;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 报文解码器
 * 
 * 从字节数组转化为实体
 * 
 * @author joesun.jiang
 * 
 */
public class MessageDecoder extends ProtocolDecoderAdapter {

	private static Logger logger = LoggerFactory
			.getLogger(MessageDecoder.class);

	@Override
	public void decode(IoSession session, IoBuffer in, ProtocolDecoderOutput out)
			throws Exception {
		if (logger.isDebugEnabled()) {
			int pos = in.position();
			logger.debug("接收到报文,对方IP为[" + session.getRemoteAddress() + "]");
			byte[] debugByte = new byte[10];
			char[] debugChar = new char[10];
			logger.debug("报文内容为：");
			while (in.limit() - in.position() > 10) {
				in.get(debugByte);
				for (int i = 0; i < debugByte.length; i++) {
					debugChar[i] = (char) debugByte[i];
				}
				logger.debug("["
						+ org.apache.commons.codec.binary.Hex.encodeHex(debugByte).toString().toUpperCase() + "\t"
						+ new String(debugChar) + "]");
			}
			debugByte = new byte[in.limit() - in.position()];
			debugChar = new char[debugByte.length];
			in.get(debugByte);
			for (int i = 0; i < debugByte.length; i++) {
				debugChar[i] = (char) debugByte[i];
			}
			logger.debug("[" + Hex.encodeHex(debugByte).toString() + "\t" + new String(debugChar) +"]");
			in.position(pos);
		}
		// 报文前4个字符大小 是报文的大小
		byte[] lenBytes = new byte[4];
		in.get(lenBytes);
		try {
			// 得到报文的长度
			int length = Integer.parseInt(new String(lenBytes));
			byte[] bytes = new byte[length];
			// 获得报文
			in.get(bytes);
			if (in.hasRemaining()) {
				bytes = new byte[in.limit()];
				in.rewind();
				in.get(bytes);
				logger.warn("报文长度超长，丢弃报文[" + Hex.encodeHex(bytes).toString() + "]");
				session.write(null);
				session.close(false);
				return;
			}
			// 解析报文
			Message message = new Message(length, bytes);
			out.write(message);
		} 
		catch (NumberFormatException nfe) {
			byte[] bytes = new byte[in.limit()];
			in.rewind();
			in.get(bytes);
			logger.warn("报文长度有误，丢弃报文[" + Hex.encodeHex(bytes).toString() + "]",
					nfe);
			session.write(null);
			session.close(false);
		}
		catch (Exception e) {
			byte[] bytes = new byte[in.limit()];
			in.rewind();
			in.get(bytes);
			logger.warn("报文格式有误，丢弃报文[" + Hex.encodeHex(bytes).toString() + "]",
					e);
			session.write(null);
			session.close(false);
		}
	}
}
