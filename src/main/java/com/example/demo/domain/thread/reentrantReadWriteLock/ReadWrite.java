package com.example.demo.domain.thread.reentrantReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-09-25 13:46
 */
public class ReadWrite {
  static int readCount = 0;
  static int writeCount = 0;
  static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
  static String message = "Hello World!";
  // 读锁可多个线程同时获取
  static ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
  // 只能单线程操作，如果有线程正在使用读锁会被阻塞
  static ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
}
