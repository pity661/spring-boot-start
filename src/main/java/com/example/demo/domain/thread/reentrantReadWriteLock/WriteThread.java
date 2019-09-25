package com.example.demo.domain.thread.reentrantReadWriteLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: demo
 * @description: 可重入读锁，单线程写锁
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-09-25 13:54
 */
public class WriteThread extends Thread {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Override
  public void run() {
    while (true) {
      ReadWrite.writeLock.lock();
      try {
        ReadWrite.writeCount++;
        ReadWrite.message += "a";
        logger.info("同时有" + ReadWrite.writeCount + "个线程写内容：" + ReadWrite.message);
        Thread.sleep(1000);
        ReadWrite.writeCount--;
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        ReadWrite.writeLock.unlock();
      }
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
