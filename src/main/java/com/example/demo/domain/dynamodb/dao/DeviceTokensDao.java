package com.example.demo.domain.dynamodb.dao;

import com.example.demo.domain.dynamodb.domain.DeviceTokens;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-10-31 11:35
 */
public interface DeviceTokensDao {

  void saveOrUpdate(DeviceTokens deviceTokens);

  DeviceTokens findByDeviceToken(String deviceToken);

  DeviceTokens findByUserId(String userId);

  DeviceTokens findByDeviceId(String deviceId);
}
