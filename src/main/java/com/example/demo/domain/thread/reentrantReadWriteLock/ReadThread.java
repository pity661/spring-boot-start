package com.example.demo.domain.thread.reentrantReadWriteLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-09-25 13:49
 */
public class ReadThread extends Thread {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Override
  public void run() {
    while (true) {
      ReadWrite.readLock.lock();
      try {
        ReadWrite.readCount++;
        logger.info("同时有" + ReadWrite.readCount + "个线程同时读内容：" + ReadWrite.message);
        String temp = new String(ReadWrite.message);
        Thread.sleep(2000);
        logger.info(String.valueOf(ReadWrite.message.equals(temp)));
        ReadWrite.readCount--;
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        ReadWrite.readLock.unlock();
      }
    }
  }
}
