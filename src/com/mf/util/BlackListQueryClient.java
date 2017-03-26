package com.mf.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import com.mf.common.util.Constant;

public class BlackListQueryClient {

	
	/**
	 * 
	 * Test method for nezha blacklist query with post method
	 * 
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpException
	 */
	public static String testBlacklistSearch(String name,String pid) throws UnsupportedEncodingException, IOException,
			HttpException {
		HttpClient c = new HttpClient();
		String url = Constant.search_url;

		c.getParams().setContentCharset("utf-8");
		c.getParams().setAuthenticationPreemptive(true);

		// 请在此填写用户名和密码
		String username = Constant.username;
		String password = Constant.password;
		Credentials defaultcreds = new UsernamePasswordCredentials(username, password);
		c.getState().setCredentials(AuthScope.ANY, defaultcreds);

		PostMethod postMethod = new PostMethod(url);

		// 可根据需要变更查询字段值
		String json = 
				"{\"name\":\""+name+"\"," 
				+ "\"pid\":\""+pid+"\","
				+ "\"m\":\"and\"}";

		RequestEntity r = new StringRequestEntity(json, "application/json", "utf-8");
		postMethod.setRequestEntity(r);
		c.executeMethod(postMethod);
		
		// 可在此获取返回结果json字符串进行处理
		String rs = postMethod.getResponseBodyAsString();
		System.out.println("=================="+rs);
		return rs;
	}
	
//	public static void main(String[] args) throws IOException {
//		testBlacklistSearch("张聪","42060219911113252X");
//	}

}
