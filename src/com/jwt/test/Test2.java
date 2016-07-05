package com.jwt.test;

import java.util.Locale;

import com.jwt.util.MoneyUtils;

public class Test2 {
  public static void main(String[] args) {
    System.out.println( MoneyUtils.chinaFormat(1999.989, 2));
    System.out.println( MoneyUtils.moneyFormat(Locale.CHINA, 1999.15, 2));
    System.out.println( MoneyUtils.USFormat(199.89, 2));
  }

}
