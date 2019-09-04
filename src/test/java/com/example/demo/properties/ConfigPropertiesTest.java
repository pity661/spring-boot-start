package com.example.demo.properties;

import static org.junit.Assert.*;

import com.example.demo.BaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ConfigPropertiesTest extends BaseTest {
  private Logger logger = LoggerFactory.getLogger(this.getClass());
  // xxx config-3
  @Autowired private ConfigProperties configProperties;

  @Test
  public void test() {
    logger.info(configProperties.getName());
    logger.info(configProperties.getRealName());
    logger.info(configProperties.getNicknameGroup());
    logger.info(configProperties.toString());
  }
}
