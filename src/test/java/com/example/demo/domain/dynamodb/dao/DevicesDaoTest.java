package com.example.demo.domain.dynamodb.dao;

import com.example.demo.BaseTest;
import com.example.demo.domain.dynamodb.domain.Devices;
import org.junit.Test;

public class DevicesDaoTest extends BaseTest {

  @Test
  public void saveTest() {
    Devices devices = new Devices();
    devices.setCreatedAt("123");
    devices.setDeviceId("1112");
    devices.setUserId("asd");
    DyDevicesDao.getInstance().saveOrUpdate(devices);
  }

  @Test
  public void queryTest() {
    Devices devices = DyDevicesDao.getInstance().findByDeviceId("111");
    System.out.println(devices.toString());
  }
}
