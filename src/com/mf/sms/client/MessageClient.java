package com.mf.sms.client;

import java.net.InetSocketAddress;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mf.sms.message.Message;
import com.mf.sms.message.MessageDecoder;
import com.mf.sms.message.MessageEncoder;
import com.mf.sms.message.entity.SmsRequest;
import com.mf.sms.message.entity.SmsResponse;


/**
 * 报文服务客户端
 * 
 * 需要用服务器名、服务器端口、报文头解码器、IO处理句柄进行构造， 句柄中需要设置result属性存放响应报文。
 * 
 * @author joesun.jiang
 * 
 */
@Service
public class MessageClient {

	private Logger logger = LoggerFactory.getLogger(getClass());

	// 服务器名
	@Value("#{env['smsPlatformIp']}")
	private String host;
	// 服务器端口
	@Value("#{env['smsPlatformPort']}")
	private String port;
	// 连接句柄
	private IoHandler ioHandler;

	private NioSocketConnector connector;

//	public MessageClient(String host, int port, IoHandler ioHandler) {
//		this.host = host;
//		this.port = port;
//		this.ioHandler = ioHandler;
//		connector = new NioSocketConnector();
//		DefaultIoFilterChainBuilder chain = connector.getFilterChain();
//		if (logger.isDebugEnabled()) {
//			LoggingFilter loggingFilter = new LoggingFilter(MessageClient.class);
//			chain.addLast("logger", loggingFilter);
//		}
//		chain.addLast("codec", new ProtocolCodecFilter(new MessageEncoder(),
//				new MessageDecoder()));
//		connector.setHandler(ioHandler);
//		//设置IDLE时间
//		connector.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
//		connector.setConnectTimeoutMillis(30000);
//	}
	public MessageClient() {
		this.ioHandler = new ShortTermClientIoHandler();
		connector = new NioSocketConnector();
		DefaultIoFilterChainBuilder chain = connector.getFilterChain();
		if (logger.isDebugEnabled()) {
			LoggingFilter loggingFilter = new LoggingFilter(MessageClient.class);
			chain.addLast("logger", loggingFilter);
		}
		chain.addLast("codec", new ProtocolCodecFilter(new MessageEncoder(),
				new MessageDecoder()));
		connector.setHandler(ioHandler);
		//设置IDLE时间
		connector.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
		connector.setConnectTimeoutMillis(30000);
	}

	/**
	 * 发送报文并接收服务器端的响应
	 * 
	 * @param message
	 *            要发送的报文
	 * @return 服务器端的响应报文
	 */
	public Message write(Message message) {
		// 如果连接资源已释放、则重新构造
		if (connector.isDisposed()) {
			connector = new NioSocketConnector();
			DefaultIoFilterChainBuilder chain = connector.getFilterChain();
			if (logger.isDebugEnabled()) {
				LoggingFilter loggingFilter = new LoggingFilter(
						MessageClient.class);
				chain.addLast("logger", loggingFilter);
			}
			chain.addLast("codec", new ProtocolCodecFilter(
					new MessageEncoder(), new MessageDecoder()));
			connector.setHandler(ioHandler);
			//设置IDLE时间
			connector.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
			connector.setConnectTimeoutMillis(30000);
		}
		// 连接服务器
		ConnectFuture future = connector.connect(new InetSocketAddress(host,
				Integer.parseInt(port)));
		// 等待连接成功
		future.awaitUninterruptibly();
		// 连接失败处理
		if (!future.isConnected()) {
			logger.error("服务器连接失败", future.getException());
			connector.dispose(true);
			throw new RuntimeException(future.getException());
		}
		// 发送报文，在连接关闭之间阻塞线程
		IoSession session = future.getSession();
		session.write(message);
		session.getCloseFuture().awaitUninterruptibly();
		// 返回响应报文
		return (Message) session.getAttribute("result");
	}

	public void dispose() {
		// 释放客户端资源
		connector.dispose(true);
	}
	

}
