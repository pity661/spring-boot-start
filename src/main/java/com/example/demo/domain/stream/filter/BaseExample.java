package com.example.demo.domain.stream.filter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StopWatch;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-11-25 14:48
 */
public class BaseExample {

  public static List<Double> list = new ArrayList<>();

  public static List<Double> randomArgs() {
    while (list.size() < 10000) {
      list.add(Math.random());
    }
    return list;
  }

  /** 单线程处理 */
  public static void count() {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    long count = randomArgs().stream().filter(n -> n < 0.5).count();
    stopWatch.stop();
    System.out.println(
        String.format("count:{%s},time:{%s}", count, stopWatch.getTotalTimeMillis()));
  }

  /** 多线程处理 */
  public static void parallelCount() {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    long count = randomArgs().parallelStream().filter(n -> n < 0.5).count();
    stopWatch.stop();
    System.out.println(
        String.format("parallelCount:{%s},time:{%s}", count, stopWatch.getTotalTimeMillis()));
  }

  public static void main(String[] args) {
    //
    count();
    parallelCount();
  }
}
