package com.example.demo.domain.dynamodb.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-10-30 20:16
 */
@DynamoDBTable(tableName = "devices-dev")
public class Devices {
  @DynamoDBHashKey(attributeName = "device_id")
  private String deviceId;

  @DynamoDBAttribute(attributeName = "user_id")
  private String userId;

  @DynamoDBAttribute(attributeName = "created_at")
  private String createdAt;

  public String getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public String toString() {
    return "Devices{"
        + "deviceId='"
        + deviceId
        + '\''
        + ", userId='"
        + userId
        + '\''
        + ", createdAt='"
        + createdAt
        + '\''
        + '}';
  }
}
