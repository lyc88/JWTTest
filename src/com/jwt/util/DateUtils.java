package com.jwt.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class DateUtils {

  /**
   * 根据出生日期获取年龄
   * @param birthDay 出生日期
   * @return
   * @throws Exception
   */
  public static String getAge(Date birthDay) throws Exception {
      Calendar cal = Calendar.getInstance();

      if (cal.before(birthDay)) {
          throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
      }

      int yearNow = cal.get(Calendar.YEAR);
      int monthNow = cal.get(Calendar.MONTH) + 1;
      int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

      cal.setTime(birthDay);
      int yearBirth = cal.get(Calendar.YEAR);
      int monthBirth = cal.get(Calendar.MONTH);
      int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

      int age = yearNow - yearBirth;

      if (monthNow <= monthBirth) {
          if (monthNow == monthBirth) {
              // monthNow==monthBirth
              if (dayOfMonthNow < dayOfMonthBirth) {
                  age--;
              }
          } else {
              // monthNow>monthBirth
              age--;
          }
      }

      return age + "";
  }

  /**
   * 日期类型转换为字符串
   * @param date 日期
   * @param format 字符串格式
   * @return
   */
  public static String format(Date date,String format){
      if(date==null){
          return null;
      }
      if(StringUtils.isEmpty(format)){
          format = "yyyy-MM-dd";
      }
      return new SimpleDateFormat(format).format(date);
  }

  /**
   * 字符串转换日期类型
   * @param date
   * @param format
   * @return
   * @throws ParseException
   */
  public static Date toDate(String date,String format) throws ParseException{
      if(date==null){
          return null;
      }
      if(StringUtils.isEmpty(format)){
          format = "yyyy-MM-dd";
      }
      return new SimpleDateFormat(format).parse(date);
  }

  /**
   * 获取两个日期相差的天数
   * @param date 日期字符串
   * @param otherDate 另一个日期字符串
   * @return 相差天数
   */
  public static int getIntervalDays(Date date, Date otherDate) {
      long time = Math.abs(date.getTime() - otherDate.getTime());
      return (int)time/(24 * 60 * 60 * 1000);
  }

  /**
   * 获取日期对应的星期
   * @param date 日期
   * @return 星期
   */
  public static String getWeek(Date date) {
      String week = null;
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(date);
      int weekNumber = calendar.get(Calendar.DAY_OF_WEEK) - 1;
      switch (weekNumber) {
          case 0:
              week = "星期日";
              break;
          case 1:
              week = "星期一";
              break;
          case 2:
              week = "星期二";
              break;
          case 3:
              week = "星期三";
              break;
          case 4:
              week = "星期四";
              break;
          case 5:
              week = "星期五";
              break;
          case 6:
              week = "星期六";
              break;
      }
      return week;
  }

  /**
   * 获取相隔天的日期
   * @param date
   * @param count 正数代表取将来时间，负数为过去时间
   * @return
   */
  public static Date getPrefixDate(Date date,int count){
      Calendar cal = Calendar.getInstance();
      cal.setTime(date);
      cal.add(Calendar.DATE,count);   // int amount   代表天数
      return cal.getTime();
  }

  /**
   *  返回年份
   *  @param  date 日期
   *  @return  返回年份
   */
  public  static  int  getYear(Date  date)  {
      java.util.Calendar  c  =  java.util.Calendar.getInstance();
      c.setTime(date);
      return  c.get(java.util.Calendar.YEAR);
  }

  /**
   *  返回月份
   *  @param  date 日期
   *  @return  返回月份
   */
  public  static  int  getMonth(Date  date)  {
      java.util.Calendar  c  =  java.util.Calendar.getInstance();
      c.setTime(date);
      return  c.get(java.util.Calendar.MONTH)  +  1;
  }

  /**
   *  返回日份
   *  @param  date 日期
   *  @return  返回日份
   */
  public  static  int  getDay(Date  date)  {
      java.util.Calendar  c  =  java.util.Calendar.getInstance();
      c.setTime(date);
      return  c.get(java.util.Calendar.DAY_OF_MONTH);
  }

  /**
   *  返回小时
   *  @param  date 日期
   *  @return  返回小时
   */
  public  static  int  getHour(Date  date)  {
      java.util.Calendar  c  =  java.util.Calendar.getInstance();
      c.setTime(date);
      return  c.get(java.util.Calendar.HOUR_OF_DAY);
  }
  
  /**
   *  返回分钟
   *  @param  date 日期
   *  @return  返回分钟
   */
  public  static  int  getMinute(Date  date)  {
      java.util.Calendar  c  =  java.util.Calendar.getInstance();
      c.setTime(date);
      return  c.get(java.util.Calendar.MINUTE);
  }

  /**
   *  返回秒钟
   *  @param  date 日期
   *  @return  返回秒钟
   */
  public  static  int  getSecond(java.util.Date  date)  {
      java.util.Calendar  c  =  java.util.Calendar.getInstance();
      c.setTime(date);
      return  c.get(java.util.Calendar.SECOND);
  }

}

