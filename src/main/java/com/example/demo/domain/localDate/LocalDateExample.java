package com.example.demo.domain.localDate;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-10-28 13:44
 */
public class LocalDateExample {
  public static void main(String[] args) {
    // 获取当前 年月日
    LocalDate localDate = LocalDate.now();
    LocalDate localDate1 = LocalDate.of(2019, 10, 28);

    // 两个时间间隔
    Period period = Period.between(localDate, localDate1);
    // 这里的时间间隔实际只是当前月的差值
    int days = period.getDays();

    String s1 = localDate1.format(DateTimeFormatter.BASIC_ISO_DATE);
    String s2 = localDate1.format(DateTimeFormatter.ISO_LOCAL_DATE);
    // 自定义格式化
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    localDate1.format(dateTimeFormatter);

    // 解析时间
    LocalDate localDate2 = LocalDate.parse("2019-10-28", DateTimeFormatter.ISO_LOCAL_DATE);
    LocalDate localDate3 = LocalDate.parse("20191028", DateTimeFormatter.BASIC_ISO_DATE);

    // 获取年、月、日、星期信息
    int year = localDate.getYear();
    int year1 = localDate.get(ChronoField.YEAR);

    Month month = localDate.getMonth();
    int month1 = localDate.get(ChronoField.MONTH_OF_YEAR);

    int day = localDate.getDayOfMonth();
    int day1 = localDate.get(ChronoField.DAY_OF_MONTH);

    DayOfWeek dayOfWeek = localDate.getDayOfWeek();
    int dayOfWeek1 = localDate.get(ChronoField.DAY_OF_WEEK);

    System.out.println(
        String.format(
            "year:{%s},year1:{%s},month:{%s},month1:{%s},day:{%s},dya1:{%s},dayOfWeek:{%s},dayOfWee1:{%s}",
            year, year1, month.getValue(), month1, day, day1, dayOfWeek.getValue(), dayOfWeek1));
  }
}
