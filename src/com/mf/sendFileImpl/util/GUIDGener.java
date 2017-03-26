package com.mf.sendFileImpl.util;

import java.util.UUID;

public class GUIDGener{
	public static String getUUID(){
		// 创建 GUID 对象
		UUID uuid = UUID.randomUUID();
		// 得到对象产生的ID
		String str = uuid.toString();
		// 转换为大写
		str = str.toUpperCase();
		// 替换 -
		return str;
	}
}






