package com.example.demo.domain.thread.reentrantLock;

import com.example.demo.domain.thread.synchronize.Method;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-09-20 18:12
 */
public class MultiProduct {
  private static Logger logger = LoggerFactory.getLogger(Method.class);
  private ReentrantLock lock = new ReentrantLock();
  private Condition produce = lock.newCondition();
  private Condition customer = lock.newCondition();
  private Set<Integer> set = new HashSet<>();
  private int i = 0;

  class Produce implements Runnable {
    @Override
    public void run() {
      try {
        logger.info(Thread.currentThread().getName() + " 尝试拿锁");
        lock.tryLock(5, TimeUnit.SECONDS);
        logger.info(Thread.currentThread().getName() + " 拿到锁了");
        if (set.size() < 5) {
          set.add(++i);
          logger.info(Thread.currentThread().getName() + " " + set.size());
        }
        Thread.sleep(200);
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        lock.unlock();
      }
    }
  };

  class Customer extends Thread {
    @Override
    public void run() {
      try {
        logger.info(Thread.currentThread().getName() + " 尝试拿锁");
        lock.tryLock(5, TimeUnit.SECONDS);
        logger.info(Thread.currentThread().getName() + " 拿到锁了");
        if (set.size() > 0) {
          set.remove(set.stream().findFirst().get());
          logger.info(Thread.currentThread().getName() + " " + set.size());
        }
        Thread.sleep(200);
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        lock.unlock();
      }
    }
  }
}
