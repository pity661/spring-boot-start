package com.example.demo.domain.stream.flatMap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-11-25 15:23
 */
public class BaseExample {

  public static List<Double> initList() {
    List<Double> list = new ArrayList<>();
    while (list.size() < 5) {
      list.add(Math.random());
    }
    return list;
  }

  public static Stream<String> split(Double number) {
    return Stream.of(number.toString().split("\\."));
  }

  public static void flatMap() {
    Stream<String> result = initList().stream().flatMap(n -> split(n));
    result.forEach(System.out::print);
  }

  public static void main(String[] args) {
    //
    flatMap();
  }
}
