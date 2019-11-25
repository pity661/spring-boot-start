package com.example.demo.domain.dynamodb.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.example.demo.domain.dynamodb.domain.DeviceTokens;
import com.example.demo.domain.dynamodb.manager.DynamoDBManager;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-10-31 11:36
 */
public class DyDeviceTokensDao implements DeviceTokensDao {
  private static final DynamoDBMapper mapper = DynamoDBManager.mapper();

  private static volatile DyDeviceTokensDao instance;

  private DyDeviceTokensDao() {}

  public static DyDeviceTokensDao getInstance() {
    if (instance == null) {
      synchronized (DyDeviceTokensDao.class) {
        if (instance == null) {
          instance = new DyDeviceTokensDao();
        }
      }
    }
    return instance;
  }

  @Override
  public void saveOrUpdate(DeviceTokens deviceTokens) {
    mapper.save(deviceTokens);
  }

  @Override
  public DeviceTokens findByDeviceToken(String deviceToken) {
    return mapper.load(DeviceTokens.class, deviceToken);
  }

  @Override
  public DeviceTokens findByUserId(String userId) {
    Map<String, AttributeValue> map = new HashMap<>();
    map.put(":v1", new AttributeValue().withS(userId));
    DynamoDBQueryExpression<DeviceTokens> query =
        new DynamoDBQueryExpression<DeviceTokens>()
            .withIndexName(DeviceTokens.USER_ID_INDEX)
            .withConsistentRead(false)
            .withScanIndexForward(true)
            .withKeyConditionExpression("user_id = :v1")
            .withExpressionAttributeValues(map)
            .withLimit(1);
    PaginatedQueryList<DeviceTokens> deviceTokens = mapper.query(DeviceTokens.class, query);
    return deviceTokens.isEmpty() ? null : deviceTokens.get(0);
  }

  @Override
  public DeviceTokens findByDeviceId(String deviceId) {
    Map<String, AttributeValue> map = new HashMap<>();
    map.put(":v1", new AttributeValue().withS(deviceId));
    DynamoDBQueryExpression<DeviceTokens> query =
        new DynamoDBQueryExpression<DeviceTokens>()
            .withIndexName(DeviceTokens.DEVICE_ID_INDEX)
            .withConsistentRead(false)
            .withScanIndexForward(true)
            .withKeyConditionExpression("device_id = :v1")
            .withExpressionAttributeValues(map)
            .withLimit(1);
    PaginatedQueryList<DeviceTokens> deviceTokens = mapper.query(DeviceTokens.class, query);
    return deviceTokens.isEmpty() ? null : deviceTokens.get(0);
  }
}
