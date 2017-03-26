package com.mf.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import com.mf.common.util.Constant;

public class QueryClient {

	public static void main(String[] args) {
		try {

			//－－－－－请添加测试所用的token－－－－－
			String ph = sendQueryUrl("42060219911113252X","张聪");
			System.out.println("http接口返回数据\n"+ ph);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String sendQueryUrl(String number,String name) throws Exception {

		String token = Constant.token;
		String id_check_url = Constant.id_check_url + token;
		String json = checkJson(token,number,name);

		/***
		 * 参数一: 你要访问的HTTP接口 参数二: 需要传递的JSON数据
		 */

		String ph = postHttp(id_check_url,json);
		return ph;

	}
	
		public static String checkJson(String token,String number,String name) throws Exception {

			String params = "{" + "\"access_token\"" + ":"
					+ "\""+token+"\"" + "," + "\"query\"" + ":"
					+ "[{" + "\"sub_client\"" + ":" + "\"\"" + ","
					+ "\"location\"" + ":" + "\"\"" + "," + "\"id_number\""
					+ ":" + "\""+number+"\"" + "," + "\"name\"" + ":"
					+ "\""+name+"\"" + "," + "\"type\"" + ":" + "\"\"" + ","
					+ "\"mobile\"" + ":" + "\"\"" + "}]" + "}";

			return params;

		}

		public static String scoreJson(String token,String number) throws Exception {

			String params = "{" + "\"access_token\"" + ":" + "\""+token+"\""
					+ "," + "\"mobiles\"" + ":" + "[" + "\""+number+"\"" + "]" + "}";

			return params;
		}

		public static String queryJson(String token,String number,String name,String mobile) throws Exception {

			String parms = "{" + "\"access_token\"" + ":" + "\""+token+"\"" + ","
					+ "\"query\"" + ":" + "[{" + "\"sub_client\"" + ":"
					+ "\"\"" + "," + "\"location\"" + ":" + "\"\"" + ","
					+ "\"id_number\"" + ":" + "\""+number+"\"" + "," + "\"name\""
					+ ":" + "\""+name+"\"" + "," + "\"type\"" + ":" + "\"\"" + ","
					+ "\"mobile\"" + ":" + "\""+mobile+"\"" + "}]" + "}";

			return parms;

		}


		public static String postHttp(String url, String json) {

			PostMethod postMethod = null;
			GetMethod getMethod = null;

			try {

				// 返回的数据
				String responseMsg = "";

				HttpClient httpClient = new HttpClient();

				// 设置字符编码
				httpClient.getParams().setContentCharset("UTF-8");
				
				// 构造PostMethod的实例
				postMethod = new PostMethod(url);

				// 参数值加入postMethod
				postMethod.setRequestBody(json);

				// 执行postMethod,调用http接口
				httpClient.executeMethod(postMethod);// 200 ok

				// 读取内容
				responseMsg = postMethod.getResponseBodyAsString().trim();

				// 返回数据
				return responseMsg;
			} catch (Exception e) {
				throw new RuntimeException(e);
			} finally {
				// 释放连接
				if (postMethod != null) {
					postMethod.releaseConnection();
				}

				if (getMethod != null) {
					getMethod.releaseConnection();
				}

			}
		}

}
