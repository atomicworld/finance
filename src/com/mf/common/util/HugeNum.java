package com.mf.common.util;

import com.mf.common.util.StringUtil;

import java.io.PrintStream;
import java.math.BigDecimal;

public class HugeNum {
  public double Add(String num, String num1)
  {
    num = StringUtil.KillNull(num, "0.00");
    num1 = StringUtil.KillNull(num1, "0.00");
    BigDecimal bigDecimal = new BigDecimal(num);
    BigDecimal bigDecimal1 = new BigDecimal(num1);
    return Double.parseDouble(bigDecimal.add(bigDecimal1).toString());
  }

  public String Add(String[] s)
  {
    String temp = "0.00";
    for (String str : s) {
      str = StringUtil.KillNull(str, "0.00");
      temp = String.valueOf(Add(temp, str));
    }
    return temp;
  }

  public double Subtract(String num, String num1)
  {
    num = StringUtil.KillNull(num, "0.00");
    num1 = StringUtil.KillNull(num1, "0.00");

    BigDecimal bigDecimal = new BigDecimal(num);
    BigDecimal bigDecimal1 = new BigDecimal(num1);

    return Double.parseDouble(bigDecimal.subtract(bigDecimal1).toString());
  }

  public double Multiply(String num, String num1)
  {
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

  public Double getZeroDoubleIfNull(Double input)
  {
    if (input == null) {
      return Double.valueOf(0.0D);
    }
    return input;
  }

  public int isGreat(String num1, String num2)
  {
    String temp = String.valueOf(Subtract(num1, num2));
    if (temp.startsWith("-"))
      return Integer.valueOf(-1).intValue();
    if ("0.00".equals(temp)) {
      return Integer.valueOf(0).intValue();
    }
    return Integer.valueOf(1).intValue();
  }

  public String[] getContraAndRema(String number1, String number2)
  {
    String[] sy = new String[2];

    String tempnumber1 = String.valueOf(Divide(number1, "1", 0, false));

    sy[0] = String.valueOf(Divide(tempnumber1, number2, 0, false));
    String tempnumber2 = String.valueOf(Multiply(sy[0], number2));
    sy[1] = String.valueOf(Subtract(number1, tempnumber2));
    return sy;
  }

  public int compareToNumeral(String num1, String num2)
  {
    int result = -2;
    result = StringUtil.isMore(num1, num2);
    return result;
  }

  public Double Divide(String num1, String num2, int digits, String type)
  {
    Double value = Double.valueOf(0.0D);
    if (("".equals(num1)) || (num1 == null)) {
      num1 = "0.00";
    }
    if (("".equals(num2)) || (num2 == null)) {
      num2 = "1.00";
    }
    BigDecimal bigDecimal = new BigDecimal(num1);
    BigDecimal bigDecimal1 = new BigDecimal(num2);
    if ("1".equals(type))
      value = Double.valueOf(bigDecimal.divide(bigDecimal1, digits, 4).doubleValue());
    else if ("2".equals(type))
      value = Double.valueOf(bigDecimal.divide(bigDecimal1, digits, 1).doubleValue());
    else if ("3".equals(type)) {
      value = Double.valueOf(bigDecimal.divide(bigDecimal1, digits, 0).doubleValue());
    }
    return value;
  }
  public static void main(String[] arg0) {
    HugeNum hugeNum = new HugeNum();

    System.out.println(hugeNum.Divide("100.34", "1", 0, false));

    BigDecimal bigDecimal = new BigDecimal("23.3541");
    BigDecimal bigDecimal1 = new BigDecimal("1");
    double value = bigDecimal.divide(bigDecimal1, 3, 0).doubleValue();
    System.out.println(value);
  }
}
