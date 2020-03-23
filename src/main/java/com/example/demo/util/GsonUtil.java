package com.example.demo.util;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-09-04 18:49
 */
public class GsonUtil {
  public static final Gson GSON =
      new GsonBuilder()
          .setDateFormat("yyyy-MM-dd HH:mm:ss")
          .setPrettyPrinting() // 格式化缩进
          .disableHtmlEscaping()
          .serializeNulls()
          .create();

  public static final Gson GSON_CAMEL =
      new GsonBuilder()
          .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
          .setDateFormat("yyyy-MM-dd HH:mm:ss")
          .disableHtmlEscaping()
          .serializeNulls()
          .create();

  // object -> class 类似 BeanUtils.copyProperties(source,target);
  public static <T> T objectTransForm(Object object, Class<T> t) {
    return str2Class(toGsonString(object), t);
  }

  // object -> JsonObject
  public static JsonObject object2JsonObject(Object object) {
    return objectTransForm(object, JsonObject.class);
  }

  // JsonObject -> class
  public static <T> T jsonObject2Class(JsonObject json, Class<T> t) throws JsonSyntaxException {
    return GSON.fromJson(json, t);
  }

  // 字符串转类
  public static <T> T str2Class(String jsonStr, Class<T> t) {
    return GSON.fromJson(jsonStr, t);
  }

  // 数组转包装类
  public static <T> T str2Class(String jsonStr, TypeToken<T> t) {
    return GSON.fromJson(jsonStr, t.getType());
  }

  // 加上注解指定参数名
  public static String toGsonString(Object obj) {
    return GSON.toJson(obj, obj.getClass());
  }
  // 驼峰自动转化为下划线
  public static String toCamelString(Object obj) {
    return GSON_CAMEL.toJson(obj, obj.getClass());
  }

  public static String fetchTargetValue(JsonObject jsonObject) {
    String value = null;
    for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
      if (entry.getKey().startsWith("r_")) {
        return String.valueOf(entry.getValue());
      }
      if (entry.getValue().isJsonObject()) {
        value = fetchTargetValue((JsonObject) entry.getValue());
      }
      if (StringUtils.isNotBlank(value)) {
        return value;
      }
    }
    return null;
  }

  public static void main(String[] args) {
    String str =
        "{\"DroB\":\"ZFdzdVdlQjJrZjRMS3BHaGhXaEdPRkZiSVIwc2xoakhKOE9Zc2Z2ZlZpQ2xMdmVQb1JMMm8ybnVGazRMOHdwdm5MV2lMZzVkVmVHdnF3dDlLOTZvc0ttWUlv\",\"ESmb\":\"cEsyY1haSzJlSGNVc1luUE9vZ2JmOWpCUHhud3NKdDlzNEpsZGoxUU1RQmgxVFBtTXBjSmtwNnl6WXhaOGp2cmhqU2wxcWVpaQ==\",\"Kqk\":{\"y60RpKIl\":\"YW01SDA4cjdLWjdHTXJYNXEz\",\"3wSJ\":\"SGNoM05ETTdUVGN6\",\"FNrq9TQ\":\"WVJXRHE2MjRuN092S3hDMEJVd0ZZR2ZkYlZIdmFVUDducWw0\",\"UQQFr5l\":\"RUxrQ2VxcWE5VmpWY0NWMldQNUlZaTR3YndQVklBS3lrNGt0QzlMN3BDYnM5dUlEMTg4aHJhQ05ac2xl\",\"m7t\":\"OFBCNVBqMVcyM0xobXBlOWdXWFhHN1VUclk5ZHBtOHBJQlBoaG04Z0RlTm1NbEh0VTVsaW16eGVh\"},\"59PN3MggsG\":\"cmlza2U1d2VZY01lRkxOaGtpYllRc1hQSlVackRPTTZYcWpXcWZ2bjdy\",\"RXrG\":\"eDNBeDhwZDlENHB4SlhZUEJIR29zNkRnd2ZFdkFqTGpjbXZ6YnY=\",\"PdmC\":{\"TyoX\":\"WWF4YXFVdlpuVVNIRzA=\",\"r_qpaCJYjL\":\"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\"}}";
    System.out.println(fetchTargetValue((JsonObject) JsonParser.parseString(str)));
  }
}
