package com.jwt.test;

import java.util.Date;

import com.jwt.util.DateUtils;

public class Test3 {

  public static void main(String[] args) throws Exception {
    System.out.println(DateUtils.format(new Date(), "yyyy-dd-mm"));
    System.out.println(DateUtils.getAge(new Date()));
    System.out.println(DateUtils.getWeek(new Date()));
    System.out.println(DateUtils.getDay(new Date()));
    System.out.println(DateUtils.getIntervalDays(new Date(), DateUtils.getPrefixDate(new Date(), 20)));
    System.out.println(DateUtils.getHour(new Date()));
    System.out.println(DateUtils.getPrefixDate(new Date(), 20));
    System.out.println(DateUtils.toDate("20160203", "yyyyddmm"));

  }

}
