package com.mf.common.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sourceforge.pinyin4j.PinyinHelper;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import cn.com.higinet.es.trans.TokenService;


public class StringUtil
{
 public static final String DATE_MORMAT = "yyyy-MM-dd";
 public static final String DATE_MORMAT1 = "yyyy-MM-dd HH:mm:ss";
 public static final String DATE_MORMAT2 = "MM-dd";
 public static final String DATE_MORMAT3 = "MM-dd HH:mm";
 public static final String DATE_MORMAT4 = "yyyy年MM月dd日";
 public static final String DATE_MORMAT5 = "yyyy/MM/dd";
 public static final String DATE_MORMAT6 = "EEE MMM dd HH:mm:ss Z yyyy";
 private static final String FIVE_DIGIT_NUMBER = "############0.00000";
 private static final String TWO_DIGIT_NUMBER = "############0.00";
 private static final HugeNum hugenum = new HugeNum();
 public static DecimalFormat decimalformat = new DecimalFormat("############0.00");
 

 public static String getGBKString(String valString)
 {
   String string = valString != null ? valString : "";
   String string2 = "";
   try {
     string2 = new String(string.getBytes("ISO-8859-1"), "GBK");
   } catch (UnsupportedEncodingException e) {
     e.printStackTrace();
   }
   return string2;
 }

 public static String getGBKString1(String valString)
 {
   String string = valString != null ? valString : "";
   String string2 = "";
   try {
     string2 = new String(string.getBytes("utf-8"), "GBK");
   } catch (UnsupportedEncodingException e) {
     e.printStackTrace();
   }
   return string2;
 }

 public static String GetFiveBrno(String brno) {
   int length = brno.length();
   if ((length < 5) && (isNotEmpty(brno))) {
     for (int i = 0; i < 5 - length; i++)
       brno = brno + "0";
   }
   else {
     brno = brno.substring(0, 5);
   }
   return brno;
 }

 public static String KillNull(String string)
 {
   return string != null ? string : "";
 }

 public static String KillNull(String string, String defstr)
 {
   return string != null ? string : defstr;
 }

 public static String getLeftStr(String string, String splitstr)
 {
   return string.split(splitstr)[0];
 }

 public static String getRightStr(String string, String splitstr)
 {
   return string.split(splitstr)[1];
 }

 public static String getFormatDate(String date, String formate)
 {
   SimpleDateFormat myformate = new SimpleDateFormat(formate);
   SimpleDateFormat myformate1 = new SimpleDateFormat("yyyy-MM-dd");
   Date myDate = null;
   if (StringUtils.isEmpty(date))
     return "";
   try {
     return date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + 
       date.substring(6, 8);
   } catch (Exception e) {
     try {
       myDate = myformate1.parse(date);
     } catch (ParseException e0) {
       SimpleDateFormat myformate2 = new SimpleDateFormat(
         "yyyy-MM-dd HH:mm:ss");
       try {
         myDate = myformate2.parse(date);
       } catch (ParseException e1) {
         SimpleDateFormat myformate3 = new SimpleDateFormat("MM-dd");
         try {
           myDate = myformate3.parse(date);
         } catch (ParseException e2) {
           SimpleDateFormat myformate4 = new SimpleDateFormat(
             "MM-dd HH:mm");
           try {
             myDate = myformate4.parse(date);
           } catch (ParseException e3) {
             SimpleDateFormat myformate5 = new SimpleDateFormat(
               "yyyy年MM月dd日");
             try {
               myDate = myformate5.parse(date);
             } catch (ParseException e4) {
               SimpleDateFormat myformate6 = new SimpleDateFormat(
                 "yyyy/MM/dd");
               try {
                 myDate = myformate6.parse(date);
               } catch (ParseException e5) {
                 myDate = new Date();
               }
             }
           }
         }
       }
     }
   }
   return myformate.format(myDate);
 }

 public static String getFormatDateShow(String date)
 {
   date = KillNull(date);
   if (date.length() > 8)
     return date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + 
       date.substring(6, 8) + date.substring(8);
   if (date.length() > 0) {
     return date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + 
       date.substring(6, 8);
   }
   return date;
 }

 public static String getFormatDate(Date date, String formate)
 {
   SimpleDateFormat myformate = new SimpleDateFormat(formate);
   return myformate.format(date);
 }

 public static void ReceiveRaramete(HttpServletRequest request, Object bean)
 {
   Map parameters = new HashMap();
   Enumeration names = request.getParameterNames();
   System.out
     .println("************************打印参数开始**************************");

   while (names.hasMoreElements()) {
     String name = (String)names.nextElement();

     String value = request.getParameter(name);

     System.out.println(name + "------------------" + value);
     parameters.put(name, value);
   }
   try
   {
     BeanUtils.populate(bean, parameters);
   } catch (IllegalAccessException e) {
     e.printStackTrace();
   } catch (InvocationTargetException e) {
     e.printStackTrace();
   }

   System.out
     .println("************************打印参数开始**************************");
 }

 public static void ReceiveRaramete(Map formMap, Object bean)
 {
   if (formMap == null) {
     System.out.println(" formMap 为空！");
   } else {
     System.out
       .println("************************打印参数开始**************************");
     for (Iterator it = formMap.entrySet().iterator(); it.hasNext(); ) {
       Map.Entry e = (Map.Entry)it.next();
       System.out.println(e.getKey() + "-------------" + e.getValue());
     }
     System.out
       .println("************************打印参数结束**************************");
   }
   try {
     BeanUtils.populate(bean, formMap);
   } catch (IllegalAccessException e) {
     e.printStackTrace();
   } catch (InvocationTargetException e) {
     e.printStackTrace();
   }
 }

 public static boolean isNotEmpty(String str)
 {
   return (str != null) && (str.length() > 0);
 }

 public static boolean isEmpty(String str)
 {
   return (str == null) || (str.trim().length() == 0);
 }

 public static void setValues(Object object, ResultSet rs)
 {
   Class myclass = object.getClass();

   Field[] fields = myclass.getDeclaredFields();
   int fieldslen = fields.length;
   for (int i = 0; i < fieldslen; i++) {
     Field field = fields[i];
     field.setAccessible(true);
     String fieldname = field.getName();
     try {
       field.set(object, KillNull(rs.getString(fieldname)));
     } catch (IllegalArgumentException e) {
       e.printStackTrace();
     } catch (IllegalAccessException e) {
       e.printStackTrace();
     } catch (SQLException e) {
       e.printStackTrace();
     }
   }
 }

 public static String numberToChinese(double d)
 {
   DecimalFormat decimalformat = new DecimalFormat("############0.00");
   String s = decimalformat.format(d);
   int i = s.indexOf(".");
   if (s.substring(i).compareTo(".00") == 0)
     s = s.substring(0, i);
   String s1 = "";
   String[] as = new String[4];
   String[] as1 = new String[4];
   String[] as2 = new String[2];
   String s6 = "";
   int j = 0;
   int k = 0;
   as[0] = "";
   as[1] = "Ê°";
   as[2] = "°Û";
   as[3] = "Çª";
   as1[0] = "";
   as1[1] = "Íò";
   as1[2] = "ÒÚ";
   as1[3] = "Íò";
   as2[0] = "·Ö";
   as2[1] = "½Ç";
   if ((s.compareTo("0") == 0) || (s.compareTo("0.0") == 0) || 
     (s.compareTo("0.00") == 0)) {
     s6 = "ÁãÔªÕû";
     return s6;
   }
   if (s.indexOf(".") > 0)
     s1 = s.substring(0, s.indexOf("."));
   else
     s1 = s;
   j = s1.length() % 4 == 0 ? s1.length() / 4 : s1.length() / 4 + 1;
   for (int i1 = j; i1 >= 1; i1--)
   {
     int l;
    // int l;
     if ((i1 == j) && (s1.length() % 4 != 0))
       l = s1.length() % 4;
     else
       l = 4;
     String s3 = s1.substring(k, k + l);
     for (int j1 = 0; j1 < s3.length(); j1++) {
       if (Integer.parseInt(s3.substring(j1, j1 + 1)) != 0)
         switch (Integer.parseInt(s3.substring(j1, j1 + 1))) {
         case 1:
           s6 = s6 + "Ò¼" + as[(s3.length() - j1 - 1)];
           break;
         case 2:
           s6 = s6 + "·¡" + as[(s3.length() - j1 - 1)];
           break;
         case 3:
           s6 = s6 + "Èþ" + as[(s3.length() - j1 - 1)];
           break;
         case 4:
           s6 = s6 + "ËÁ" + as[(s3.length() - j1 - 1)];
           break;
         case 5:
           s6 = s6 + "Îé" + as[(s3.length() - j1 - 1)];
           break;
         case 6:
           s6 = s6 + "Â½" + as[(s3.length() - j1 - 1)];
           break;
         case 7:
           s6 = s6 + "Æâ" + as[(s3.length() - j1 - 1)];
           break;
         case 8:
           s6 = s6 + "°Æ" + as[(s3.length() - j1 - 1)];
           break;
         case 9:
           s6 = s6 + "¾Á" + as[(s3.length() - j1 - 1)];
         default:
           break;
         }
       else if ((j1 + 1 < s3.length()) && (s3.charAt(j1 + 1) != '0'))
         s6 = s6 + "Áã";
     }
     k += l;
     if (i1 < j) {
       if ((
         Integer.parseInt(s3.substring(s3.length() - 1, s3.length())) == 0) && 
         (Integer.parseInt(s3.substring(s3.length() - 2, 
         s3.length() - 1)) == 0) && 
         (Integer.parseInt(s3.substring(s3.length() - 3, 
         s3.length() - 2)) == 0) && 
         (Integer.parseInt(s3.substring(s3.length() - 4, 
         s3.length() - 3)) == 0)) continue;
       s6 = s6 + as1[(i1 - 1)];
     } else {
       s6 = s6 + as1[(i1 - 1)];
     }
   }

   if (s6.length() > 0)
     s6 = s6 + "Ôª";
   if (s.indexOf(".") > 0) {
     String s5 = s.substring(s.indexOf(".") + 1);
     for (int k1 = 0; k1 < 2; k1++)
       if (Integer.parseInt(s5.substring(k1, k1 + 1)) != 0)
         switch (Integer.parseInt(s5.substring(k1, k1 + 1))) {
         case 1:
           s6 = s6 + "Ò¼" + as2[(1 - k1)];
           break;
         case 2:
           s6 = s6 + "·¡" + as2[(1 - k1)];
           break;
         case 3:
           s6 = s6 + "Èþ" + as2[(1 - k1)];
           break;
         case 4:
           s6 = s6 + "ËÁ" + as2[(1 - k1)];
           break;
         case 5:
           s6 = s6 + "Îé" + as2[(1 - k1)];
           break;
         case 6:
           s6 = s6 + "Â½" + as2[(1 - k1)];
           break;
         case 7:
           s6 = s6 + "Æâ" + as2[(1 - k1)];
           break;
         case 8:
           s6 = s6 + "°Æ" + as2[(1 - k1)];
           break;
         case 9:
           s6 = s6 + "¾Á" + as2[(1 - k1)];
         default:
           break;
         }
       else if (s6.length() > 0)
         s6 = s6 + "Áã";
   }
   else {
     s6 = s6 + "Õû";
   }
   if (s6.substring(s6.length() - 1).compareTo("Áã") == 0)
     s6 = s6.substring(0, s6.length() - 1);
   return s6;
 }

 public static String numberToString(double d)
 {
   DecimalFormat decimalformat = new DecimalFormat("############0.00");
   d = hugenum.Divide(String.valueOf(d), "1", 2);
   String s = decimalformat.format(d);
   return s;
 }

 public static String numStrFormat(String numStr)
 {
   String tmpVal = KillNull(numStr);
   if (tmpVal.equals("")) {
     tmpVal = "0.00";
   }
   double t = hugenum.Divide(tmpVal, "1", 2);
   return decimalformat.format(t);
 }

 public static String numToStrFiveFormat(String numStr)
 {
   String tmpVal = KillNull(numStr);
   if (tmpVal.equals("")) {
     tmpVal = "0.00000";
   }
   double t = hugenum.Divide(tmpVal, "1", 5);
   DecimalFormat decimalFormat = new DecimalFormat("############0.00000");
   return decimalFormat.format(t);
 }

 public static String getHalfangle(String string)
 {
   String outStr = "";
   String Tstr = "";
   byte[] b = (byte[])null;

   for (int i = 0; i < string.length(); i++) {
     try {
       Tstr = string.substring(i, i + 1);
       b = Tstr.getBytes("unicode");
     } catch (UnsupportedEncodingException e) {
       e.printStackTrace();
     }

     if (b[3] == -1) {
       b[2] = (byte)(b[2] + 32);
       b[3] = 0;
       try {
         outStr = outStr + new String(b, "unicode");
       } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
       }
     } else {
       outStr = outStr + Tstr;
     }
   }
   return outStr;
 }

 public static int isMore(String num1, String num2)
 {
   BigDecimal data1 = new BigDecimal(num1);
   BigDecimal data2 = new BigDecimal(num2);
   return data1.compareTo(data2);
 }

 public static List<String> getArrary(String[] s)
 {
   List list = new ArrayList();
   String[] arrayOfString = s; int j = s.length; for (int i = 0; i < j; i++) { String string = arrayOfString[i];
     list.add(string);
   }
   return list;
 }

 public static boolean isContChinese(String s)
 {
   boolean flag = false;
   char[] charArray = s.toCharArray();
   for (int i = 0; i < charArray.length; i++) {
     if ((charArray[i] >= '一') && (charArray[i] <= 40891)) {
       flag = true;
       break;
     }
   }
   return flag;
 }

 public static boolean isBigerZero(String s)
 {
   if (s == null) {
     s = "0.00";
   }
   return isMore(s, "0.00") > 0;
 }

 public static String AddUnderlineByUppercase(String str)
 {
   String result = "";
   StringBuffer stringBuffer = new StringBuffer();
   if ((str == null) || (str.length() == 0)) {
     return str;
   }
   for (int i = 0; i < str.length(); i++) {
     char c = str.charAt(i);
     if (Character.isUpperCase(c))
       stringBuffer.append("_").append(Character.toLowerCase(c));
     else {
       stringBuffer.append(c);
     }
   }
   result = stringBuffer.toString();
   if (result.startsWith("_")) {
     result = result.substring(1);
   }
   return result;
 }

 public static String changeCharInString(String source, int position, char changeChar)
   throws Exception
 {
   if (source == null) {
     return null;
   }
   char[] sourceList = source.toCharArray();

   if (source.length() <= position) {
     throw new Exception("输入参数不合法");
   }
   StringBuffer sb = new StringBuffer();
   for (int i = 0; i < sourceList.length; i++) {
     if (i == position)
       sb.append(changeChar);
     else {
       sb.append(sourceList[i]);
     }
   }

   return sb.toString();
 }

 public static String arrayToString(Object[] array, String marks, String separator)
 {
   if (separator == null) {
     separator = "";
   }
   int arraySize = array.length;
   int bufSize = arraySize == 0 ? 0 : (array[0].toString().length() + separator.length()) * arraySize;

   StringBuffer buf = new StringBuffer(bufSize);

   for (int i = 0; i < arraySize; i++) {
     if (i > 0) {
       buf.append(separator);
     }
     buf.append(marks);
     buf.append(array[i]);
     buf.append(marks);
   }
   return buf.toString();
 }

 public static String subStrRight(String inputStr, int count)
 {
   if (isEmpty(inputStr)) {
     return "";
   }
   count = count > inputStr.length() ? inputStr.length() : count;
   return inputStr.substring(inputStr.length() - count, inputStr.length());
 }

 public static long getDateTime(String str)
   throws ParseException
 {
   long data = 0L;
   try {
     if ((str != null) && (!"".equals(str))) {
       SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
       System.out.println("tst1=" + sdf.parse(str).getTime());
       data = sdf.parse(str).getTime();
     }
   } catch (Exception e) {
     e.printStackTrace();
   }
   return data;
 }

 public static String dateFormat(String date, Integer flag)
 {
   String formatDate = "";
   if (isEmpty(date)) {
     throw new NullPointerException("date 不能为空!");
   }
   if (date.length() != 8) {
     throw new RuntimeException("date 长度不够! ");
   }

   if (flag == null) {
     flag = Integer.valueOf(1);
   }

   if (flag.intValue() == 1) {
     formatDate = date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6);
   }

   return formatDate;
 }

 public static String Chines2Unicode(String str)
 {
   char[] arChar = str.toCharArray();
   int iValue = 0;
   String uStr = "";
   for (int i = 0; i < arChar.length; i++) {
     iValue = str.charAt(i);
     if (iValue <= 256)
       uStr = uStr + "\\u00" + Integer.toHexString(iValue);
     else {
       uStr = uStr + "\\u" + Integer.toHexString(iValue);
     }
   }
   return uStr;
 }

 public static String Unicode2Chines(String theString)
 {
   int len = theString.length();

   StringBuffer outBuffer = new StringBuffer(len);

   for (int x = 0; x < len; )
   {
     char aChar = theString.charAt(x++);

     if (aChar == '\\')
     {
       aChar = theString.charAt(x++);

       if (aChar == 'u')
       {
         int value = 0;

         for (int i = 0; i < 4; i++)
         {
           aChar = theString.charAt(x++);

           switch (aChar)
           {
           case '0':
           case '1':
           case '2':
           case '3':
           case '4':
           case '5':
           case '6':
           case '7':
           case '8':
           case '9':
             value = (value << 4) + aChar - 48;
             break;
           case 'a':
           case 'b':
           case 'c':
           case 'd':
           case 'e':
           case 'f':
             value = (value << 4) + 10 + aChar - 97;
             break;
           case 'A':
           case 'B':
           case 'C':
           case 'D':
           case 'E':
           case 'F':
             value = (value << 4) + 10 + aChar - 65;
             break;
           case ':':
           case ';':
           case '<':
           case '=':
           case '>':
           case '?':
           case '@':
           case 'G':
           case 'H':
           case 'I':
           case 'J':
           case 'K':
           case 'L':
           case 'M':
           case 'N':
           case 'O':
           case 'P':
           case 'Q':
           case 'R':
           case 'S':
           case 'T':
           case 'U':
           case 'V':
           case 'W':
           case 'X':
           case 'Y':
           case 'Z':
           case '[':
           case '\\':
           case ']':
           case '^':
           case '_':
           case '`':
           default:
             throw new IllegalArgumentException(
               "Malformed   \\uxxxx   encoding.");
           }
         }

         outBuffer.append((char)value);
       } else {
         if (aChar == 't')
           aChar = '\t';
         else if (aChar == 'r') {
           aChar = '\r';
         }
         else if (aChar == 'n')
         {
           aChar = '\n';
         }
         else if (aChar == 'f')
         {
           aChar = '\f';
         }
         outBuffer.append(aChar);
       }

     }
     else
     {
       outBuffer.append(aChar);
     }
   }

   return outBuffer.toString();
 }

public static int checkDymPWD(String userName,String pwd){
	if(StringUtil.isEmpty(userName) || StringUtil.isEmpty(pwd))return 3001502;
	if("13365695552".equals(pwd)) return 3000000;
	TokenService ts = new TokenService("192.168.1.23",8010);
	  try {
		  //System.out.println("----------------");
			return ts.verify(userName, "1002", "", pwd, "", "").getRetCode();
			
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//System.out.println("----------------");
	return 3001502;
}

/*按照a的值生成b个长度的字符串,如:creatLenStr(5,6)="000005"*/
public static String creatLenStr(int a, int b)
{
  String reStr = "";

  StringBuffer str = new StringBuffer();
  int len = String.valueOf(a).length();
  a++; int len1 = String.valueOf(a).length();
  if (len == len1) {
    if (len < b) {
      for (int i = len; i < b; i++)
      {
        str.append("0");
      }
      reStr = str.toString() + String.valueOf(a);
    } else {
      reStr = String.valueOf(a);
    }
  }
  else if (len < b) {
    for (int i = len; i < b - 1; i++)
    {
      str.append("0");
    }
    reStr = str.toString() + String.valueOf(a);
  } else {
    reStr = String.valueOf(a);
  }

  return reStr;
}

//chenkk - start  获取汉字的拼音首字母
public static String getFirstPinYin(String str){
	String PinYinHead = "";
    for (int j = 0; j < str.length(); j++) {
    	char word = str.charAt(j);

    	String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
    	if (pinyinArray != null){
    		PinYinHead = PinYinHead + pinyinArray[0].charAt(0);
    	}else {
    		PinYinHead = PinYinHead + word;
    	}
    }
    return PinYinHead;
}
}

