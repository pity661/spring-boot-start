package com.example.demo.domain.basic.collection;

import java.util.*;
import java.util.stream.Stream;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-11-13 13:47
 */
public class Sort {
  public static void sort() {
    String[] array = {"one", "two", "three", "four", "five"};
    // 按照字典顺序排序
    Arrays.sort(array);
    System.out.println("第一次排序");
    Stream.of(array).forEach(str -> System.out.print(str));
    System.out.println("");
    // 按照字符串长度排序，反转倒序
    Arrays.sort(array, Comparator.comparing(String::length).reversed());
    System.out.println("第二次排序");
    Stream.of(array).forEach(str -> System.out.print(str));
  }

  public static void main(String[] args) {
    //
    sort();
  }
}
