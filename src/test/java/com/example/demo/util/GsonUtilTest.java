package com.example.demo.util;

import static org.junit.Assert.*;

import com.example.demo.domain.gson.GsonParam;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GsonUtilTest {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Test
  public void toCamelStringTest() {
    GsonParam param = new GsonParam();
    param.setName("wenky");
    param.setRealName("huwenqi");
    logger.info(GsonUtil.toCamelString(param));
    logger.info(GsonUtil.toGsonString(param));
  }

  @Test
  public void str2ClassTest() {
    GsonParam param = new GsonParam();
    param.setName("wenky");
    param.setRealName("huwenqi");
    String jsonString = GsonUtil.toGsonString(param);
    logger.info(jsonString);

    param = GsonUtil.str2Class(jsonString, GsonParam.class);
    logger.info(param.toString());
  }

  @Test
  public void typeTokenTest() {
    List<GsonParam> paramList = new ArrayList<>();
    GsonParam param1 = new GsonParam();
    param1.setName("wenky1");
    param1.setRealName("huwenqi1");
    GsonParam param2 = new GsonParam();
    param2.setName("wenky2");
    param2.setRealName("huwenqi2");
    paramList.add(param1);
    paramList.add(param2);
    String jsonString = GsonUtil.toGsonString(paramList);
    logger.info(jsonString);

    TypeToken type = new TypeToken<List<GsonParam>>() {};
    paramList = (List<GsonParam>) GsonUtil.str2Class(jsonString, type);
    logger.info(paramList.stream().findFirst().toString());
  }
}
