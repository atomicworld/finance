package com.mf.sms.client;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户端短连接句柄
 * 
 * @author zhangkun
 *
 */
public class ShortTermClientIoHandler extends IoHandlerAdapter {
	
	private Logger logger = LoggerFactory.getLogger(ShortTermClientIoHandler.class);

	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		// 在session中保存响应报文并关闭连接
		session.setAttribute("result", message);
		session.close(false);
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) {
		// 获得异常后关闭连接
		logger.error(cause.getMessage(), cause);
		session.close(false);
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status)
			throws Exception {
		logger.info("释放闲置连接");
		session.close(false);
	}

}
