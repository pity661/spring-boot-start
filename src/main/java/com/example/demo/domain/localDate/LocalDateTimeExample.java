package com.example.demo.domain.localDate;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-10-28 13:58
 */
public class LocalDateTimeExample {
  public static void main(String[] args) {
    // 获取当前 年月日、时分秒
    LocalDateTime localDateTime = LocalDateTime.now();
    LocalDateTime localDateTime1 = LocalDateTime.of(2019, Month.OCTOBER, 20, 14, 00, 00);
    LocalDateTime localDateTime2 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
    LocalDateTime localDateTime3 = LocalDate.now().atTime(LocalTime.now());
    LocalDateTime localDateTime4 = LocalTime.now().atDate(LocalDate.now());

    LocalDate localDate = localDateTime.toLocalDate();
    LocalTime localTime = localDateTime.toLocalTime();

    Instant instant = Instant.now();
    // 秒数
    long currentSecond = instant.getEpochSecond();
    // 毫秒数
    long currentMilli = instant.toEpochMilli();

    // 增加、减少一段时间 方法返回一个新的对象
    localDateTime = localDateTime.plusDays(1);
    localDateTime = localDateTime.plus(1, ChronoUnit.DAYS);

    localDateTime = localDateTime.minusDays(1);
    localDateTime = localDateTime.minus(1, ChronoUnit.DAYS);

    // 修改年、月、日
    localDateTime = localDateTime.withYear(2020);
    localDateTime = localDateTime.with(ChronoField.YEAR, 2020);

    LocalDateTime localDateTimeNow = LocalDateTime.now();
    localDateTimeNow = localDateTimeNow.with(ChronoField.MONTH_OF_YEAR, 12);

    System.out.println(localDateTimeNow.format(DateTimeFormatter.BASIC_ISO_DATE));
  }
}
