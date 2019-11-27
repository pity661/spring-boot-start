package com.example.demo.domain.stream.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-11-25 15:33
 */
public class BaseExample {

  public static List<Double> initList() {
    List<Double> list = new ArrayList<>();
    while (list.size() < 5) {
      list.add(Math.random());
    }
    return list;
  }

  public static void sort() {
    Comparator comparator = Comparator.comparing(Double::doubleValue).reversed();
    initList().stream().sorted(comparator).forEach(System.out::println);
  }

  public static void main(String[] args) {
    //
    sort();
  }
}
