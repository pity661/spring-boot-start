package com.example.demo.domain.thread.synchronize;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-09-18 10:25
 */
public class Method {
  private static Logger logger = LoggerFactory.getLogger(Method.class);

  public synchronized void add() throws InterruptedException {
    logger.info(Thread.currentThread().getName() + " add start");
    Thread.sleep(2000);
    logger.info(Thread.currentThread().getName() + " add end");
  }

  public static synchronized void sub() throws InterruptedException {
    logger.info(Thread.currentThread().getName() + " sub start");
    Thread.sleep(2000);
    logger.info(Thread.currentThread().getName() + " sub end");
  }

  public void multi() throws InterruptedException {
    // 同步类的实例对象
    synchronized (this) {
      logger.info(Thread.currentThread().getName() + " multi start");
      Thread.sleep(2000);
      logger.info(Thread.currentThread().getName() + " multi end");
    }
  }

  public static void div() throws InterruptedException {
    // 同步类对象
    synchronized (Method.class) {
      logger.info(Thread.currentThread().getName() + " div start");
      Thread.sleep(2000);
      logger.info(Thread.currentThread().getName() + " div end");
    }
  }

  public synchronized void reEnter() throws InterruptedException {
    logger.info(Thread.currentThread().getName() + " reEnter start");
    Thread.yield();
    logger.info(Thread.currentThread().getName() + " reEnter end");
  }
}
