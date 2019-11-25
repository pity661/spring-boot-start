package com.example.demo.domain.dynamodb;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.NameMap;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-10-29 16:38
 */
public class LoadData {
  public static void main(String[] args) {
    //      AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withCredentials(new
    // InstanceProfileCredentialsProvider(false)).build();
    AmazonDynamoDBClient client = new AmazonDynamoDBClient().withEndpoint("http://localhost:8000");
    DynamoDB dynamoDB = new DynamoDB(client);
    Table table = dynamoDB.getTable("book");

    Item item = new Item().withPrimaryKey("title", "wenky").withString("price", "3.21");
    PutItemOutcome putItemOutcome = table.putItem(item);

    Map<String, Object> valueMap = new HashMap<>();
    valueMap.put(":xxx", "wenky");
    QuerySpec querySpec =
        new QuerySpec()
            .withKeyConditionExpression("#title = :xxx")
            .withNameMap(new NameMap().with("#title", "title"))
            .withValueMap(valueMap);

    ItemCollection<QueryOutcome> items = table.query(querySpec);
    if (items.iterator().hasNext()) {

      System.out.println("查询成功");
    } else {
      System.out.println("查询失败");
    }
  }
}
