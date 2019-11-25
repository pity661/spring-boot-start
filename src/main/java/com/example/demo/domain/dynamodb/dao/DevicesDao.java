package com.example.demo.domain.dynamodb.dao;

import com.example.demo.domain.dynamodb.domain.Devices;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-10-30 20:21
 */
public interface DevicesDao {

  void saveOrUpdate(Devices devices);

  Devices findByDeviceId(String deviceId);
}
