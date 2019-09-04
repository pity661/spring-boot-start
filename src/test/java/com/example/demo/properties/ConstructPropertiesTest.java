package com.example.demo.properties;

import static org.junit.Assert.*;

import com.example.demo.BaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ConstructPropertiesTest extends BaseTest {
  private Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired private ConstructProperties constructProperties;

  @Test
  public void test() {
    logger.info(constructProperties.getName());
    logger.info(constructProperties.getRealName());
  }
}
