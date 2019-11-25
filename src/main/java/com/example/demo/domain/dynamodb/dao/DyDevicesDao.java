package com.example.demo.domain.dynamodb.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.example.demo.domain.dynamodb.domain.Devices;
import com.example.demo.domain.dynamodb.manager.DynamoDBManager;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-10-30 20:21
 */
public class DyDevicesDao implements DevicesDao {
  private static final DynamoDBMapper mapper = DynamoDBManager.mapper();

  private static volatile DyDevicesDao instance;

  private DyDevicesDao() {}

  public static DyDevicesDao getInstance() {
    if (instance == null) {
      synchronized (DyDevicesDao.class) {
        if (instance == null) {
          instance = new DyDevicesDao();
        }
      }
    }
    return instance;
  }

  @Override
  public void saveOrUpdate(Devices devices) {
    mapper.save(devices);
  }

  @Override
  public Devices findByDeviceId(String deviceId) {
    return mapper.load(Devices.class, deviceId);
  }
}
