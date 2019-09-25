package com.example.demo.domain.thread.threadLocal.weakReference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-09-24 16:26
 */
public class Apple {
  private Logger logger = LoggerFactory.getLogger(Apple.class);

  private String name;

  public Apple(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /**
   * 示例被回收时执行的方法
   *
   * @throws Throwable
   */
  @Override
  protected void finalize() throws Throwable {
    super.finalize();
    logger.info("Apple: " + name + " finalize...");
  }

  @Override
  public String toString() {
    return "Apple{" + "name='" + name + '\'' + '}' + ", hashCode:" + this.hashCode();
  }
}
