package com.example.demo.util;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

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
}
