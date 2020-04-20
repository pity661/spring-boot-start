package com.example.demo.propertiy;

import com.example.demo.BaseTest;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class DemoPropertiesTest extends BaseTest {
  private Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired private DemoProperties demoProperties;

  @Value("#{${demo.prop.map_value}}")
  private Map<String, String> properties;

  @Value("#{${demo.datasource.postgresql.properties}}")
  private Map<String, String> properties1;

  @Test
  public void test() {
    logger.info(properties.toString());
    logger.info(properties1.toString());
  }

  @Test
  public void propTest() {
    Assert.assertNotNull(demoProperties.getName());
    Assert.assertEquals(demoProperties.getRealName(), "huwenqi");
  }
}
