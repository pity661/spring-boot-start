package com.example.demo.domain.stream.peek;

import java.util.stream.Stream;

/**
 * @program: demo
 * @description: void类型，传入执行不会影响原流
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-11-25 15:43
 */
public class BaseExample {

  /**
   * iterate 第一个参数是原是值，第二个参数是方法(将上次执行产生的结果再次计算得到下一个结果)
   *
   * <p>peek让流中的对象分别执行对应方法，返回void不会影响原流
   */
  public static void peek() {
    Object[] powers =
        Stream.iterate(1.0, p -> p * 2)
            .peek(p -> System.out.print("Fetching" + p + " "))
            .limit(20)
            .toArray();
    System.out.println();
    System.out.println(powers.length);
  }

  public static void main(String[] args) {
    //
    peek();
  }
}
