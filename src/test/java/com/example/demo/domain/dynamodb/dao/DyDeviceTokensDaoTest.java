package com.example.demo.domain.dynamodb.dao;

import com.example.demo.BaseTest;
import com.example.demo.domain.dynamodb.domain.DeviceTokens;
import org.junit.Test;

public class DyDeviceTokensDaoTest extends BaseTest {

  @Test
  public void saveTest() {
    DeviceTokens deviceTokens = new DeviceTokens();
    deviceTokens.setDevicePlatform("android");
    deviceTokens.setIdfa("abc");
    deviceTokens.setDeviceInfo("{adwwqwq}");
    deviceTokens.setCreatedAt("126");
    deviceTokens.setDeviceId("1212121");
    deviceTokens.setDeviceToken("ssss2");
    deviceTokens.setUserId("ababab");
    DyDeviceTokensDao.getInstance().saveOrUpdate(deviceTokens);
  }

  @Test
  public void queryTest1() {
    DeviceTokens deviceTokens = DyDeviceTokensDao.getInstance().findByDeviceToken("ssss");
    System.out.println(deviceTokens.toString());
  }

  @Test
  public void queryTest2() {
    DeviceTokens deviceTokens = DyDeviceTokensDao.getInstance().findByUserId("ababab");
    System.out.println(deviceTokens.toString());
  }

  @Test
  public void queryTest3() {
    DeviceTokens deviceTokens = DyDeviceTokensDao.getInstance().findByDeviceId("1212121");
    System.out.println(deviceTokens.toString());
  }
}
