package com.mf.util;


import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 加密工具类
 *
 * 2013-10-21 下午4:21:35
 */
public final class ConvertUtil {
	private static Logger log = LoggerFactory.getLogger(ConvertUtil.class);

	private ConvertUtil() {
	}

	// MD5加密（32位大写）
	public static String getMd5(String para) {
		return DigestUtils.md5Hex(para).toUpperCase();
	}
}
