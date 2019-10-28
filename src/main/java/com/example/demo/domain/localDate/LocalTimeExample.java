package com.example.demo.domain.localDate;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-10-28 13:53
 */
public class LocalTimeExample {
  public static void main(String[] args) {
    // 获取当前 时分秒
    LocalTime localTime = LocalTime.now();
    LocalTime localTime1 = LocalTime.of(13, 54, 1);

    int hour = localTime.getHour();
    int hour1 = localTime.get(ChronoField.HOUR_OF_DAY);

    int minute = localTime.getMinute();
    int minute1 = localTime.get(ChronoField.MINUTE_OF_DAY);
    int minute2 = localTime.get(ChronoField.MINUTE_OF_HOUR);

    int second = localTime.getSecond();
    int second1 = localTime.get(ChronoField.SECOND_OF_MINUTE);

    System.out.println(
        String.format(
            "hour:{%s},hour1:{%s},minute:{%s},minute1:{%s},minute2:{%s},second:{%s},second1:{%s}",
            hour, hour1, minute, minute1, minute2, second, second1));
  }
}
