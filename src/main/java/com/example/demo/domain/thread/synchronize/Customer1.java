package com.example.demo.domain.thread.synchronize;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-09-18 10:45
 */
public class Customer1 implements Runnable {

  Method method;

  public Customer1(Method method) {
    this.method = method;
  }

  private Customer1() {}

  @Override
  public void run() {
    try {
      this.method.add();
      this.method.add();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
