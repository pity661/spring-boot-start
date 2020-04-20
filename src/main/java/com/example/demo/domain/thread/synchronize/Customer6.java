package com.example.demo.domain.thread.synchronize;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-09-18 12:45
 */
public class Customer6 implements Runnable {
  Method method;

  public Customer6(Method method) {
    this.method = method;
  }

  private Customer6() {}

  @Override
  public void run() {
    try {
      Method.sub();
      this.method.add();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
