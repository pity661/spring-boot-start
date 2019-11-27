package com.example.demo.domain.stream.intStream;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-11-26 16:09
 */
public class BaseExample {

  //    public static void initIntStream() {
  //        IntStream intStream = Random.
  //    }

  public static IntStream range() {
    return IntStream.range(2, 5);
  }

  public static void iterate() {
    range().forEach(System.out::println);
  }

  public static void boxed() {
    Stream<Integer> stream = range().boxed();
  }

  public static void summaryStatistics() {
    IntSummaryStatistics summaryStatistics = range().summaryStatistics();
    System.out.println("average:" + summaryStatistics.getAverage());
    System.out.println("sum:" + summaryStatistics.getSum());
    System.out.println("max:" + summaryStatistics.getMax());
    System.out.println("min:" + summaryStatistics.getMin());
    System.out.println("count:" + summaryStatistics.getCount());
  }

  public static void main(String[] args) {
    //
    //      iterate();
    summaryStatistics();
  }
}
