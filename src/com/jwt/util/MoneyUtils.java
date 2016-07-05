package com.jwt.util;

import java.text.NumberFormat;
import java.util.Locale;

public class MoneyUtils {

  /**
   * 格式化人民币
   * @param moneyCount 货币金额
   * @param digit 货币有效小数
   * @return
   */
  public static String chinaFormat(Double moneyCount,Integer digit){
      return moneyFormat(Locale.CHINA,moneyCount,digit);

  }
  /**
   * 格式化美元
   * @param moneyCount 货币金额
   * @param digit 货币有效小数
   * @return
   */
  public static String USFormat(Double moneyCount,Integer digit){
      return moneyFormat(Locale.US,moneyCount,digit);
  }

  /**
   * 格式化英镑
   * @param moneyCount 货币金额
   * @param digit 货币有效小数
   * @return
   */
  public static String UKFormat(Double moneyCount,Integer digit){
      return moneyFormat(Locale.UK,moneyCount,digit);
  }

  /**
   * 货币格式化
   * @param locale 货币类型
   * @param moneyCount 货币金额
   * @param digit 货币有效小数
   * @return
   */
  public static String moneyFormat(Locale locale,Double moneyCount,Integer digit){
      if(digit == null){
          //默认金额到分
          digit = 2;
      }
      NumberFormat percentFormat = NumberFormat.getCurrencyInstance(locale);
      String result = percentFormat.format(moneyCount);
      return result;
  }

}

