package com.example.demo.domain.thread.reentrantReadWriteLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-09-25 13:45
 */
public class ReentrantReadWriteLockTest {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 同一时间，可由多个线程同时获取读锁，只能一个线程获取写锁
   *
   * @throws InterruptedException
   */
  @Test
  public void mainTest() throws InterruptedException {
    ReadThread readThread = new ReadThread();
    WriteThread writeThread = new WriteThread();
    for (int i = 0; i < 3; i++) {
      new Thread(readThread).start();
      new Thread(writeThread).start();
    }
    Thread.sleep(20000);
  }

  /**
   * 当有线程成功获取读锁时，其他线程能获取读锁但是不能获取写锁
   *
   * @throws InterruptedException
   */
  @Test
  public void writeTest() throws InterruptedException {
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    // 读锁可多个线程同时获取
    ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    // 只能单线程操作，如果有线程正在使用读锁会被阻塞
    ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    ExecutorService service = Executors.newCachedThreadPool();
    Thread readSleepThread =
        new Thread(
            () -> {
              logger.info("尝试获取休眠读锁");
              readLock.lock();
              try {
                logger.info("获取休眠读锁成功");
                Thread.sleep(2000);
              } catch (InterruptedException e) {
                e.printStackTrace();
              } finally {
                logger.info("释放休眠读锁");
                readLock.unlock();
              }
            });

    Thread readThread =
        new Thread(
            () -> {
              logger.info("尝试获取读锁");
              readLock.lock();
              try {
                logger.info("获取读锁成功");
              } finally {
                logger.info("释放读锁");
                readLock.unlock();
              }
            });

    Thread writeThread =
        new Thread(
            () -> {
              logger.info("尝试获取写锁");
              writeLock.lock();
              try {
                logger.info("获取写锁成功");
              } finally {
                logger.info("释放写锁");
                writeLock.unlock();
              }
            });

    service.execute(readSleepThread);
    Thread.sleep(1000);
    service.execute(readThread);
    service.execute(writeThread);

    Thread.sleep(5000);
  }
}
