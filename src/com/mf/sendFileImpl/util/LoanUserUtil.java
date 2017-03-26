package com.mf.sendFileImpl.util;

import java.util.HashMap;
import java.util.Map;

public class LoanUserUtil {
	/***
	 * 获取与监管系统匹配的投放行业code
	 * @param useno
	 * @return
	 */
	public static int getLoanTradeCode(String useno){
		int length = useno.length();
		String subuseno = null;
		if (length==1) {
			subuseno= useno;
		}else if(!useno.equals("F58")){
			subuseno = useno.substring(0,1);
		}else if(useno.equals("F58")){
			subuseno="F58";
		}
		
		int result = 0;
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("A", 290001);
		map.put("B", 290009);
		map.put("C", 290002);
		map.put("D", 290002);
		map.put("E", 290003);
		map.put("F", 290006);
		map.put("G", 290009);
		map.put("H", 290005);
		map.put("I", 290008);
		map.put("J", 290005);
		map.put("K", 290004);
		map.put("L", 290008);
		map.put("M", 290009);
		map.put("N", 290001);
		map.put("O", 290009);
		map.put("P", 290009);
		map.put("Q", 290009);
		map.put("R", 290009);
		map.put("S", 290005);
		map.put("T", 290005);
		map.put("U", 290005);
		map.put("V", 290003);
		map.put("W", 290001);
		map.put("X", 290001);
		map.put("Y", 290002);
		map.put("Z", 290003);
		map.put("F58", 290007);
		for (String key : map.keySet()) {
			if (subuseno.equals(key)) {
				result =  map.get(key);
			}
		}
		return result;
	} 
}
