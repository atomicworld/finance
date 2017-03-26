package com.mf.common.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ReplaceNumber {
	 //角，分
	 static String[] point={"毛","份"};
	 //元，十，百，千，万，十，百，千，亿
	 										
	 static String[] zero={"园","拾","佰","仟","完","时","白","钱","一"};
	 public static String prase(double money,int len) {
		 String str=String.valueOf(money);
		 String[] mm=str.split("\\.");
		 String zs=mm[0];//整数
		 String xs=mm[1];//小数
		 char[] ws=zs.toCharArray();//位数
		 char[] xw=xs.toCharArray();//小数位数
		 Map<String,String> map=new HashMap<String,String>();
		 map.put("毛", "0");
		 map.put("份", "0");
		 for(int i=0;i<len;i++){
			 map.put(zero[i], "0");
		  }
		 int j=0;
		 for(int i=ws.length;i>0;i--){
			 map.put(zero[j],ws[i-1]+"");
			 j++;
		 }
		 int k=0;
		 for(int i=xw.length;i>0;i--){
			 map.put(point[k],xw[i-1]+"");
			 k++;
		 }
		StringBuffer params=new StringBuffer();
		 Iterator entries = map.entrySet().iterator();
		  while (entries.hasNext()) {    
			  Map.Entry entry = (Map.Entry) entries.next();
			  String key = (String)entry.getKey();
			  String value = (String)entry.getValue();
			  params.append(key+","+value+";");//借据编号
		 }
		 return params.toString();
	  }
	  
	  public static void main(String[] args){   
		  System.out.println(prase(10000.11,7));
		 
	}
}
