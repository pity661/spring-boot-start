package com.example.demo.domain.dynamodb.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-10-31 11:31
 */
@DynamoDBTable(tableName = "device_tokens-dev")
public class DeviceTokens {
  public static final String USER_ID_INDEX = "index-user_id-created_at";
  public static final String DEVICE_ID_INDEX = "index-device_id-created_at";

  @DynamoDBHashKey(attributeName = "device_token")
  private String deviceToken;

  @DynamoDBIndexRangeKey(
      attributeName = "created_at",
      globalSecondaryIndexNames = {USER_ID_INDEX, DEVICE_ID_INDEX})
  private String createdAt;

  @DynamoDBIndexHashKey(attributeName = "user_id", globalSecondaryIndexName = USER_ID_INDEX)
  private String userId;

  @DynamoDBIndexHashKey(attributeName = "device_id", globalSecondaryIndexName = DEVICE_ID_INDEX)
  private String deviceId;

  @DynamoDBAttribute(attributeName = "device_info")
  private String deviceInfo;

  @DynamoDBAttribute(attributeName = "idfa")
  private String idfa;

  @DynamoDBAttribute(attributeName = "device_platform")
  private String devicePlatform;

  public String getDeviceInfo() {
    return deviceInfo;
  }

  public void setDeviceInfo(String deviceInfo) {
    this.deviceInfo = deviceInfo;
  }

  public String getIdfa() {
    return idfa;
  }

  public void setIdfa(String idfa) {
    this.idfa = idfa;
  }

  public String getDevicePlatform() {
    return devicePlatform;
  }

  public void setDevicePlatform(String devicePlatform) {
    this.devicePlatform = devicePlatform;
  }

  public String getDeviceToken() {
    return deviceToken;
  }

  public void setDeviceToken(String deviceToken) {
    this.deviceToken = deviceToken;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }

  @Override
  public String toString() {
    return "DeviceTokens{"
        + "deviceToken='"
        + deviceToken
        + '\''
        + ", createdAt='"
        + createdAt
        + '\''
        + ", userId='"
        + userId
        + '\''
        + ", deviceId='"
        + deviceId
        + '\''
        + '}';
  }
}
