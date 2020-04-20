package com.example.demo.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-09-12 10:59
 */
public class SpringStopWatchTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void baseTest() throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Thread.sleep(1000);
        stopWatch.stop();
        logger.info(String.valueOf(stopWatch.getTotalTimeMillis()));
        logger.info(String.valueOf(stopWatch.getTotalTimeSeconds()));
    }
}
