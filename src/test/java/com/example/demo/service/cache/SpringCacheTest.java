package com.example.demo.service.cache;

import static org.junit.Assert.*;

import com.example.demo.BaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class SpringCacheTest extends BaseTest {
  private Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired private SpringCache springCache;

  @Test
  public void simpleParamsTest() {
    logger.info(springCache.fetchNotNullResult("key3"));

    logger.info(springCache.fetchNullResult("key2"));

    logger.info(springCache.fetchNotNullResult("key1", "key2"));

    logger.info(springCache.fetchNotNullResultWithoutKeyStrategy("key3", "key6"));
  }

  @Test
  public void objectKeyTest() {
    SpringCache.Key key = new SpringCache().new Key();
    key.setKey1("key1");
    key.setKey2("key2");
    // 需要重写toString方法
    logger.info(springCache.fetchNotNullResult(key));
  }

  @Test
  public void objectResultTest() {
    Result result = springCache.fetchResultWithObject("wenky");
    logger.info(result.toString());
  }
}
