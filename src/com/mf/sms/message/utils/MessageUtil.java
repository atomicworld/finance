package com.mf.sms.message.utils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.XStream;

/**
 * 实体报文工具类
 * 
 * @author joesun.jiang
 * 
 */
public class MessageUtil {

	private static Logger logger = LoggerFactory.getLogger(MessageUtil.class);

	// XML报文体编码
	public static final String BODY_ENCODING = "UTF-8";

	// XML报文体声明
	public static final String BODY_HEADER = "<?xml version=\"1.0\" encoding=\""
				+ BODY_ENCODING + "\" ?>\n";
	
	/**
	 * 
	 * 将对象根据属性编码为XML字符串数组
	 * 
	 * @param xStream
	 *            编码用的xstream对象
	 * @param object
	 *            要被编码的对象
	 * 
	 * @return 编码完成的字节数组
	 */
	public static byte[] encode(XStream xStream, Object object) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			// 构造制定编码的writer
			Writer writer = new OutputStreamWriter(outputStream,
					BODY_ENCODING);
			// 写入XML报文体声明
			writer.write(BODY_HEADER);
			xStream.processAnnotations(object.getClass());
			// 写入XML报文
			xStream.toXML(object, writer);
			return outputStream.toByteArray();
		} catch (UnsupportedEncodingException e) {
			logger.error("不支持的编码格式[" + BODY_ENCODING + "]", e);
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static byte[] encode(XStream xStream, Object object, String charset)
	{
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			// 构造制定编码的writer
			Writer writer = new OutputStreamWriter(outputStream,
					charset);
			// 写入XML报文体声明
			writer.write(getBODY_HEADER(charset));
			// 写入XML报文
			xStream.toXML(object, writer);
			return outputStream.toByteArray();
		} catch (UnsupportedEncodingException e) {
			logger.error("不支持的编码格式[" + charset + "]", e);
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static String getBODY_HEADER(String charset)
	{
		return "<?xml version=\"1.0\" encoding=\""
				+ charset + "\" ?>\n";
	}
}
