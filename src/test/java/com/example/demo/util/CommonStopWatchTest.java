package com.example.demo.util;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-09-12 11:19
 */
public class CommonStopWatchTest {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Test
  public void baseTest() throws InterruptedException {
    StopWatch stopWatch = StopWatch.createStarted();
    Thread.sleep(1000);
    stopWatch.stop();
    logger.info(String.valueOf(stopWatch.getTime()));
  }
}
