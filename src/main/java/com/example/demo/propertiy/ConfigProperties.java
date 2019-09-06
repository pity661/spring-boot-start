package com.example.demo.propertiy;

import java.util.List;
import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-09-04 14:10
 */
// xxx config-1
@ConfigurationProperties(prefix = "demo.prop")
public class ConfigProperties {
  private String name;
  private String realName;
  private String nicknameGroup;
  private List<String> list;
  private Map<String, Integer> map;

  public Map<String, Integer> getMap() {
    return map;
  }

  public void setMap(Map<String, Integer> map) {
    this.map = map;
  }

  public List<String> getList() {
    return list;
  }

  public void setList(List<String> list) {
    this.list = list;
  }

  public String getNicknameGroup() {
    return nicknameGroup;
  }

  public void setNicknameGroup(String nicknameGroup) {
    this.nicknameGroup = nicknameGroup;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  @Override
  public String toString() {
    return "ConfigProperties{"
        + "name='"
        + name
        + '\''
        + ", realName='"
        + realName
        + '\''
        + ", nicknameGroup='"
        + nicknameGroup
        + '\''
        + '}';
  }
}
