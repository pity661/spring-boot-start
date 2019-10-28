package com.example.demo.domain.localDate;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-10-28 14:45
 */
public class DateParam {
  // 传入处理
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  // xxx 1
  // 返回结果处理
  @JsonSerialize(using = LocalDateTimeConverter.class)
  private LocalDateTime localDateTime;

  public LocalDateTime getLocalDateTime() {
    return localDateTime;
  }

  public void setLocalDateTime(LocalDateTime localDateTime) {
    this.localDateTime = localDateTime;
  }

  @Override
  public String toString() {
    return "DateParam{" + "localDateTime=" + localDateTime + '}';
  }

  public static void main(String[] args) {
    //
    DateParam dateParam = new DateParam();
    dateParam.localDateTime = LocalDateTime.now();
    System.out.println(dateParam.toString());
  }
}
