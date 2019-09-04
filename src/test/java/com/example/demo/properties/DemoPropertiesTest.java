package com.example.demo.properties;

import static org.junit.Assert.*;

import com.example.demo.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DemoPropertiesTest extends BaseTest {

  @Autowired private DemoProperties demoProperties;

  @Test
  public void propTest() {
    Assert.assertNotNull(demoProperties.getName());
    Assert.assertEquals(demoProperties.getRealName(), "huwenqi");
  }
}
