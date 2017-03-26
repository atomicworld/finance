package com.mf.common.bsnstool;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.mf.common.util.*;

public class MathTool {
	public double Add(String num, String num1){
	     num = StringUtil.KillNull(num, "0.00");
	     num1 = StringUtil.KillNull(num1, "0.00");
	     BigDecimal bigDecimal = new BigDecimal(num);
	     BigDecimal bigDecimal1 = new BigDecimal(num1);
	     return Double.parseDouble(bigDecimal.add(bigDecimal1).toString());
	}
	 
	public String Add(String[] s){
	     String temp = "0.00";
	     for (String str : s) {
	       str = StringUtil.KillNull(str, "0.00");
	       temp = String.valueOf(Add(temp, str));
	     }
	     return temp;
	}
	 
	public double Subtract(String num, String num1){
	     num = StringUtil.KillNull(num, "0.00");
	     num1 = StringUtil.KillNull(num1, "0.00");
	 
	     BigDecimal bigDecimal = new BigDecimal(num);
	     BigDecimal bigDecimal1 = new BigDecimal(num1);
	 
	     return Double.parseDouble(bigDecimal.subtract(bigDecimal1).toString());
	}
	 
	public double Multiply(String num, String num1){
	     if (("".equals(num)) || (num == null)) {
	       num = "0.00";
	     }
	     if (("".equals(num1)) || (num1 == null)) {
	       num1 = "0.00";
	     }
	     BigDecimal bigDecimal = new BigDecimal(num);
	     BigDecimal bigDecimal1 = new BigDecimal(num1);
	     return Double.parseDouble(bigDecimal.multiply(bigDecimal1).toString());
	   }
	 
	   public double Divide(String num, String num1)
	   {
	     if (("".equals(num)) || (num == null)) {
	       num = "0.00";
	     }
	     if (("".equals(num1)) || (num1 == null)) {
	       num1 = "1.00";
	     }
	     BigDecimal bigDecimal = new BigDecimal(num);
	     BigDecimal bigDecimal1 = new BigDecimal(num1);
	     return bigDecimal.divide(bigDecimal1, 2, 4).doubleValue();
	   }
	 
	   public double Divide(String num, String num1, int digits)
	   {
	     if (("".equals(num)) || (num == null)) {
	       num = "0.00";
	     }
	     if (("".equals(num1)) || (num1 == null)) {
	       num1 = "1.00";
	     }
	     BigDecimal bigDecimal = new BigDecimal(num);
	     BigDecimal bigDecimal1 = new BigDecimal(num1);
	     return bigDecimal.divide(bigDecimal1, digits, 4).doubleValue();
	   }
	 
	   public double Divide(String num, String num1, int digits, boolean flag)
	   {
	     if (("".equals(num)) || (num == null)) {
	       num = "0.00";
	     }
	     if (("".equals(num1)) || (num1 == null)) {
	       num1 = "1.00";
	     }
	     BigDecimal bigDecimal = new BigDecimal(num);
	     BigDecimal bigDecimal1 = new BigDecimal(num1);
	     if (flag) {
	       return bigDecimal.divide(bigDecimal1, digits, 4).doubleValue();
	     }
	     return bigDecimal.divide(bigDecimal1, digits, 3).doubleValue();
	   }
	 
	   public double Divide(String num, String num1, boolean falg)
	   {
	     if (("".equals(num)) || (num == null)) {
	       num = "0.00";
	     }
	     if (("".equals(num1)) || (num1 == null)) {
	       num1 = "1.00";
	     }
	     BigDecimal bigDecimal = new BigDecimal(num);
	     BigDecimal bigDecimal1 = new BigDecimal(num1);
	     if (falg) {
	       return bigDecimal.divide(bigDecimal1, 2, 4).doubleValue();
	     }
	     return bigDecimal.divide(bigDecimal1, 2, 3).doubleValue();
	   }
	 
	//四舍五入
    public static double Round(double src){
    	BigDecimal decimal = BigDecimal.valueOf(src);
    	decimal = decimal.setScale(2, RoundingMode.HALF_UP);
        return decimal.doubleValue();
    }
}
