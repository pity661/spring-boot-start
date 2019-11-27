package com.example.demo.domain.stream.map;

import java.util.stream.Stream;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-11-25 15:19
 */
public class BaseExample {
  public static void toLower() {
    String[] strs = new String[] {"A", "B", "C"};
    Stream.of(strs).map(String::toLowerCase).forEach(System.out::println);
  }

  public static void main(String[] args) {
    //
    toLower();
  }
}
