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
 * @create: 2019-09-18 15:45
 */
public class SingleProduct {
  private static Logger logger = LoggerFactory.getLogger(Method.class);
  private ReentrantLock lock = new ReentrantLock();
  private Condition produce = lock.newCondition();
  private Condition customer = lock.newCondition();
  private Set<Integer> set = new HashSet<>();

  class Produce implements Runnable {
    @Override
    public void run() {
      int i = 0;
      while (true) {
        try {
          lock.tryLock(3, TimeUnit.SECONDS);
          if (set.size() < 10) {
            set.add(++i);
            logger.info(Thread.currentThread().getName() + " " + set.size());
            continue;
          }
          produce.awaitNanos(1000);
          customer.signal();
        } catch (Exception e) {
          e.printStackTrace();
        } finally {
          lock.unlock();
        }
      }
    }
  };

  class Customer extends Thread {
    @Override
    public void run() {
      while (true) {
        try {
          lock.tryLock(3, TimeUnit.SECONDS);
          if (set.size() > 0) {
            set.remove(set.stream().findFirst().get());
            logger.info(Thread.currentThread().getName() + " " + set.size());
            continue;
          }
          produce.awaitNanos(1000);
          produce.signal();
        } catch (Exception e) {
          e.printStackTrace();
        } finally {
          lock.unlock();
        }
      }
    }
  }
}
