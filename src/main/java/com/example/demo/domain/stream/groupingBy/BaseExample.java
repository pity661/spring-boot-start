package com.example.demo.domain.stream.groupingBy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.util.StopWatch;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-11-25 17:22
 */
public class BaseExample {

  private static List<Double> list = null;

  public static List<Double> initStream() {
    if (list == null) {
      list = Stream.generate(Math::random).limit(20).collect(Collectors.toList());
    }
    return list;
  }

  public static void groupingByConcurrent() {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    Map<String, TreeSet<Double>> map =
        initStream()
            .parallelStream()
            .collect(
                Collectors.groupingByConcurrent(
                    s -> s.toString().split("\\.")[1].substring(0, 1),
                    Collectors.toCollection(TreeSet::new)));
    stopWatch.stop();
    System.out.println("groupingByConcurrent:" + stopWatch.getTotalTimeMillis());
    map.entrySet().stream()
        .forEach(
            entry ->
                System.out.println(
                    String.format(
                        "key:{%s},value:{%s}",
                        entry.getKey(),
                        entry.getValue().stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(",")))));
  }

  public static void groupingBy() {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    Map<String, TreeSet<Double>> map =
        initStream().stream()
            .collect(
                Collectors.groupingBy(
                    s -> s.toString().split("\\.")[1].substring(0, 1),
                    Collectors.toCollection(TreeSet::new)));
    stopWatch.stop();
    System.out.println("groupingBy:" + stopWatch.getTotalTimeMillis());
    map.entrySet().stream()
        .forEach(
            entry ->
                System.out.println(
                    String.format(
                        "key:{%s},value:{%s}",
                        entry.getKey(),
                        entry.getValue().stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(",")))));
  }

  public static void groupingByMax() {
    Map<String, Optional<Double>> map =
        initStream().stream()
            .collect(
                Collectors.groupingBy(
                    s -> s.toString().split("\\.")[1].substring(0, 1),
                    Collectors.maxBy(Comparator.comparing(Double::doubleValue))));
    map.entrySet().stream()
        .forEach(
            entry ->
                System.out.println(
                    String.format(
                        "key:{%s},value:{%s}", entry.getKey(), entry.getValue().orElse(null))));
  }

  public static void main(String[] args) {
    //
    groupingByConcurrent();
    groupingBy();
    groupingByMax();
  }
}
