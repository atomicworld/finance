package com.mf.common.bsnstool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;


public class DateTool {
	private static Calendar calendar = new GregorianCalendar(TimeZone.getDefault());
	private static String datePattern = "yyyyMMdd";
	private static String timePattern = "HH:mm:ss";
	
	/*
	 * 计算两个日期之间间隔的月份数
	 * */
	public static int getMonth(String startDate, String endDate) throws Exception{
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
		Date startDate1 = f.parse(startDate);
		Calendar starCal = Calendar.getInstance();
		starCal.setTime(startDate1);
		int sYear = starCal.get(1);
		int sMonth = starCal.get(2);
		int sDay = starCal.get(5);
		 
		Date endDate1 = f.parse(endDate);
		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate1);
		int eYear = endCal.get(1);
		int eMonth = endCal.get(2);
		int eDay = endCal.get(5);
		 
		int monthday = (eYear - sYear) * 12 + (eMonth - sMonth);
		if (sDay < eDay) {
			monthday++;
		}
		return monthday;
	}
	
	public static int getMonth(String strDate) {
	     SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
	 
	     int intMonth = 0;
	     try {
	       Date startDate = f.parse(strDate);
	       Calendar starCal = Calendar.getInstance();
	       starCal.setTime(startDate);
	       intMonth = starCal.get(2) + 1;
	     } catch (ParseException e) {
	       e.printStackTrace();
	     }
	 
	     return intMonth;
	}
	
	//判断是否闰年
	public static boolean isLeapYear(String strdate){
		int y = Integer.parseInt(strdate.substring(0, 4));
		if (y <= 999) {
			return false;
		}
		return (y % 400 == 0) || ((y % 4 == 0) && (y % 100 != 0));
	}
	
	public static int getDaysOfMonth(String strdate){
		int m = Integer.parseInt(strdate.substring(4, 6));
	     switch (m) {
	     case 1:
	     case 3:
	     case 5:
	     case 7:
	     case 8:
	     case 10:
	     case 12:
	       return 31;
	     case 4:
	     case 6:
	     case 9:
	     case 11:
	       return 30;
	     case 2:
	       if (isLeapYear(strdate)) {
	         return 29;
	       }
	       return 28;
	     }	 
	     return 0;
	}
	
	public static String getDate(){
		SimpleDateFormat format = new SimpleDateFormat(datePattern);
		Date date = calendar.getTime();
		return format.format(date);
	}
	
	public static int getBetweenDays(String date_s, String date_b){
		int tem = 0;
		try {
	       long datanumber = 0L;
	       SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
	 
	       long l_begin = df.parse(date_s).getTime();
	       long l_end = df.parse(date_b).getTime();
	 
	       long temp = l_end - l_begin;
	       datanumber = temp / 86400000L;
	       if (datanumber <= 0L) {
	         datanumber = 0L;
	       }
	       tem = Integer.valueOf(String.valueOf(datanumber)).intValue();
	     } catch (ParseException e) {
	       e.printStackTrace();
	     }
	     return tem;
	   }
	
	private static String getDay_small(String date){
		try{
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			String date_ym = date.substring(0, 6);
			String date_day = date.substring(6);
	       String date_set_str = date_ym + "01";
	       Date date_setDate = format.parse(date_set_str);
	       calendar.setTime(date_setDate);
	       int day_int = calendar.getActualMaximum(5);
	       if (day_int < Integer.valueOf(date_day).intValue())
	         date = date_ym + String.format("%2d", new Object[] { Integer.valueOf(day_int) });
	     } catch (ParseException e) {
	       try {
	         throw new Exception("DateTool.getDay_small() error!");
	       } catch (Exception e1) {
	         e1.printStackTrace();
	         e.printStackTrace();
	       }
	     }
	     return date;
	   }
	
	public static String getMonth_next(String date, String date_day, boolean lastDay)throws Exception{
		if ((date.length() != 8) || (date_day.length() != 8)) {
			throw new Exception("日期参数传值错误!");
		}
		     long returnDate = Long.valueOf(date).longValue();
		     long returnDate_day = Long.valueOf(date_day).longValue();
		     if (returnDate % 10000L / 100L == 12L)
		       returnDate = (returnDate / 10000L + 1L) * 10000L + 100L + returnDate_day % 100L;
		     else {
		       returnDate = returnDate / 10000L * 10000L + (returnDate % 10000L / 100L + 1L) * 100L + returnDate_day % 100L;
		     }
		 
		     if (lastDay) {
		       boolean isLastDay = false;
		       int days = DateTool.getDaysOfMonth(date);
		       if (days == Integer.valueOf(date.substring(6, 8)).intValue()) {
		         isLastDay = true;
		       }
		       String tempReturnDate = String.valueOf(returnDate);
		       if (isLastDay) {
		         days = DateTool.getDaysOfMonth(tempReturnDate);
		         tempReturnDate = tempReturnDate.substring(0, 6) + String.valueOf(days);
		       }
		       returnDate = Long.valueOf(tempReturnDate).longValue();
		     }
		     return getDay_small(String.valueOf(returnDate));
		   }
}
