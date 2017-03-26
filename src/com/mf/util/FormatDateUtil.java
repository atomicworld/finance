package com.mf.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class FormatDateUtil {

	/**
	 * 
	 * @param format:需要转换成的格式
	 * @return
	 */
	public static String getFormatDate(String format){
		Date date = new Date();
		SimpleDateFormat sf=new SimpleDateFormat(format);
		return sf.format(date);
	}
	
	

	/**
	 * 修改月份
	 */
	@SuppressWarnings("deprecation")
	public static String changeDateAsMonth(String date, int imonth) {
		GregorianCalendar calendar = new GregorianCalendar();
		if (date.length() == 8) {
			calendar.set(Integer.parseInt(date.substring(0, 4)), Integer
					.parseInt(date.substring(4, 6)) - 1, Integer.parseInt(date
					.substring(6, 8)));
		} else if (date.length() == 10) {
			calendar.set(Integer.parseInt(date.substring(0, 4)), Integer
					.parseInt(date.substring(5, 7)) - 1, Integer.parseInt(date
					.substring(8, 10)));
		}
		calendar.add(GregorianCalendar.MONTH, imonth);
		String sDate[] = calendar.getTime().toLocaleString().split(" ");
		return sDate[0];
	}

	/**
	 * 日期比较
	 * 
	 */
	public static int compareDate(String aDate, String bDate) {

		String[] strDate;
		GregorianCalendar aCal = new GregorianCalendar();
		GregorianCalendar bCal = new GregorianCalendar();
		if (aDate.indexOf("/") != -1) {
			strDate = aDate.split("/");
			aCal.set(Integer.parseInt(strDate[0].trim()), Integer
					.parseInt(strDate[1].trim()) - 1, Integer
					.parseInt(strDate[2].trim()));
		} else if (aDate.indexOf("-") != -1) {
			strDate = aDate.split("-");
			aCal.set(Integer.parseInt(strDate[0].trim()), Integer
					.parseInt(strDate[1].trim()) - 1, Integer
					.parseInt(strDate[2].trim()));
		} else if (aDate.length() == 8) {
			aCal.set(Integer.parseInt(aDate.substring(0, 4)), Integer
					.parseInt(aDate.substring(4, 6)) - 1, Integer
					.parseInt(aDate.substring(6, 8)));
		} else if (aDate.length() == 10) {
			aCal.set(Integer.parseInt(aDate.substring(0, 4)), Integer
					.parseInt(aDate.substring(5, 7)) - 1, Integer
					.parseInt(aDate.substring(8, 10)));
		}

		if (bDate.indexOf("/") != -1) {
			strDate = bDate.split("/");
			bCal.set(Integer.parseInt(strDate[0].trim()), Integer
					.parseInt(strDate[1].trim()) - 1, Integer
					.parseInt(strDate[2].trim()));
		} else if (bDate.indexOf("-") != -1) {
			strDate = bDate.split("-");
			bCal.set(Integer.parseInt(strDate[0].trim()), Integer
					.parseInt(strDate[1].trim()) - 1, Integer
					.parseInt(strDate[2].trim()));
		} else if (bDate.length() == 8) {
			bCal.set(Integer.parseInt(bDate.substring(0, 4)), Integer
					.parseInt(bDate.substring(4, 6)) - 1, Integer
					.parseInt(bDate.substring(6, 8)));
		} else if (bDate.length() == 10) {
			bCal.set(Integer.parseInt(bDate.substring(0, 4)), Integer
					.parseInt(bDate.substring(5, 7)) - 1, Integer
					.parseInt(bDate.substring(8, 10)));
		}

		return aCal.compareTo(bCal);
	}

	/**
	 * 闰年判断
	 * @param year
	 * @return
	 */
	public static boolean isLeapYear(String year) {
		try {
			int intyear = Integer.parseInt(year);
			if (intyear % 400 == 0 || (intyear % 4 == 0 && intyear % 100 != 0)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 计算年龄
	 * @param birthday
	 * @return
	 */
	public static String getAge(String birthday) {
		SimpleDateFormat fm = new SimpleDateFormat("yyyyMMdd");
		String strNowDate = fm.format(new java.util.Date());
		String age = new String();
		age = String.valueOf((Integer.parseInt(strNowDate) - Integer
				.parseInt(birthday)) / 10000);
		return age;
	}

	/**
	 * 取当前日期
	 * @param format
	 * @throws Exception
	 * @return String
	 */
	public static String getDate(String format) throws Exception {
		SimpleDateFormat fm = new SimpleDateFormat(format);
		return fm.format(new java.util.Date());
	}

	/**
	 * 日期转成字符
	 * dtDate：待转换的日期
	 * strFormat：待转换日期要转成字符串的格式	 * 
	 */
	public synchronized static String dateToStr(Date dtDate,String strFormat) {
		if(dtDate != null) {
			SimpleDateFormat dateFm = new SimpleDateFormat(strFormat); 
			String strDate = dateFm.format(dtDate);
			return strDate;
		} else {
			return "";
		}
	}
	/**
	 * 字符转成日期
	 * strDate:要转换成日期的数据。例如：20120808102015
	 * strFormat :要转换日期数据的格式。例如上面的格式：yyyyMMddHHmmss
	 */
	public synchronized static Date strToDate(String strDate,String strFormat) {
		Date date = null;
		try {
			SimpleDateFormat dateFm = new SimpleDateFormat(strFormat); 
			date = dateFm.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	/**
	 * 格式化日期字符串
	 * strDate ： 原始字符串
	 * strFormat： 待转换的字符串格式
	 */
	public synchronized static String formatDateStr(String strDate ,String marker) {
		StringBuffer sb= new StringBuffer();
		if(strDate.length() == 8) {
			sb.append(strDate.substring(0,4)).append(marker); 
			sb.append(strDate.substring(4,6)).append(marker);
			sb.append(strDate.substring(6,8));			
		}else if(strDate.length() == 14) {
			sb.append(strDate.substring(0,4)).append(marker); 
			sb.append(strDate.substring(4,6)).append(marker);
			sb.append(strDate.substring(6,8)).append(" ");		
			sb.append(strDate.substring(8,10)).append(":");		
			sb.append(strDate.substring(10,12)).append(":");		
			sb.append(strDate.substring(12,14));		
		} else{
			return "";
		}
		return sb.toString();
	}


	/**
	 * 取得指定年月的天数
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getMonthDay(String year, String month) {
		int iRet = 0;
		switch (Integer.parseInt(month)) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			iRet = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			iRet = 30;
			break;
		case 2:
			iRet = isLeapYear(year) == true ? 28 : 29;
			break;

		}
		return iRet;
	}

	
	public static long getDaysBtwDate(String fromDate, String toDate,String dateFormat) {
		
		long lnToDate=0,lnFromDate=0;
		try {
			SimpleDateFormat df = new SimpleDateFormat(dateFormat);
			lnToDate= df.parse(toDate).getTime();
			lnFromDate = df.parse(fromDate).getTime();
		}catch(Exception e) {
			return -1;
		}
		return (lnToDate-lnFromDate) / (1000 * 60 * 60 * 24);

	}
	/**
	 * 取得指定日期的星期值
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static String weekDay(String year, String month, String day) {
		String strWeekday = "";
		try {
			GregorianCalendar cal = new GregorianCalendar();
			cal.setLenient(false);
			cal.clear();
			cal.set(Integer.parseInt(year), Integer.parseInt(month) - 1,
					Integer.parseInt(day));
			strWeekday = String
					.valueOf(cal.get(java.util.Calendar.DAY_OF_WEEK) - 1);
		} catch (IllegalArgumentException e) {
			strWeekday = "";
		}
		return strWeekday;
	}
	/** 
	 * 得到几天前的时间 
	 *  
	 * @param d 
	 * @param day 
	 * @return 
	 */  
	public  static Date changeDateAsDays(Date d, int day) {  
	    Calendar now = Calendar.getInstance();  
	    now.setTime(d);  
	    now.set(Calendar.DATE, now.get(Calendar.DATE) + day);  
	    return now.getTime();  
	} 
	
	 public static String prase(String strDate) {
			String yyyy=strDate.substring(0,4);
			String mm=strDate.substring(4,6);
			String dd=strDate.substring(6,8);
			strDate=yyyy+"年"+mm+"月"+dd+"日";
		 return strDate;
	  }
	
}
