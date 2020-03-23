package com.example.demo.domain.thread.volatileTest;

/**
 * @program: demo
 * @description:
 * @author: wenky
 * @email: huwenqi@panda-fintech.com
 * @create: 2020-03-13 14:33
 */
public class VolatileTest {

  class CommonObj {
    private int num = 0;

    public void add() {
      num = num + 60;
    }
  }

  class VolatileObj {
    private volatile int num = 0;

    public void add() {
      num = num + 60;
    }
  }

  public void test1() {
    CommonObj commonObj = new CommonObj();
    new Thread(
            () -> {
              System.out.println(Thread.currentThread().getName() + " 开始运行");
              try {
                Thread.sleep(3000);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
              commonObj.add();
              System.out.println(Thread.currentThread().getName() + " " + commonObj.num);
            },
            "thread1")
        .start();
    while (commonObj.num == 0) {}
    System.out.println(Thread.currentThread().getName() + " over");
  }

  public void test2() {
    VolatileObj volatileObj = new VolatileObj();
    new Thread(
            () -> {
              System.out.println(Thread.currentThread().getName() + " 开始运行");
              try {
                Thread.sleep(3000);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
              volatileObj.add();
              System.out.println(Thread.currentThread().getName() + " " + volatileObj.num);
            },
            "thread2")
        .start();
    while (volatileObj.num == 0) {}
    System.out.println(Thread.currentThread().getName() + " over");
  }

  public static void main(String[] args) {
    //
    new VolatileTest().test1();
  }
}
