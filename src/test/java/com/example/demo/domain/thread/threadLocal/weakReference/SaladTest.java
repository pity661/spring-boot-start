package com.example.demo.domain.thread.threadLocal.weakReference;

import static org.junit.Assert.*;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SaladTest {
  private static Logger logger = LoggerFactory.getLogger(SaladTest.class);

  @Test
  public void mainTest() throws InterruptedException {

    Salad salad = new Salad(new Apple("红富士"));
    logger.info("Apple: " + salad.get());
    System.gc();
    // 休眠一下，在运行的时候加上虚拟机参数-XX:+PrintGCDetails，输出gc信息，确定gc发生了。
    Thread.sleep(500);
    if (null == salad.get()) {
      logger.info("clear Apple。");
    }
  }

  @Test
  public void referenceQueueTest() throws InterruptedException {
    // 指定弱引用对象存入指定队列被回收
    ReferenceQueue<Apple> referenceQueue = new ReferenceQueue<>();
    WeakReference<Apple> greenApple = new WeakReference<>(new Apple("青苹果"), referenceQueue);
    WeakReference<Apple> redApple = new WeakReference<>(new Apple("红苹果"), referenceQueue);
    logger.info("gc前");
    Reference<? extends Apple> reference;
    while ((reference = referenceQueue.poll()) != null) {
      logger.info(reference.toString());
    }
    logger.info(greenApple.toString());
    logger.info(redApple.toString());
    logger.info(greenApple.get().toString());
    logger.info(redApple.get().toString());

    logger.info("gc");
    System.gc();
    Thread.sleep(500);
    logger.info("gc后");

    logger.info(String.valueOf(greenApple.get()));
    logger.info(String.valueOf(redApple.get()));
    while ((reference = referenceQueue.poll()) != null) {
      logger.info(reference.toString());
    }
  }

  @Test
  public void weakHashMapTest() throws InterruptedException {
    // 1
    WeakHashMap<Apple, String> map = new WeakHashMap<>();
    Apple key = new Apple("key");
    // 2
    //      WeakHashMap<String ,String> map = new WeakHashMap<>();
    //      String key = "key";
    String value = "value";
    map.put(key, value);
    logger.info("gc前");
    logger.info(String.valueOf(map.size()));
    // 将key指向的对象设为null，消除强引用
    key = null;
    System.gc();
    Thread.sleep(500);
    logger.info("gc后");
    logger.info(String.valueOf(map.size()));
  }
}
