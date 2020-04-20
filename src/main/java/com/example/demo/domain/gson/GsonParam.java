package com.example.demo.domain.gson;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-09-04 18:54
 */
public class GsonParam {
  private String name;
  //    @SerializedName("real_name")
  private String realName;

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
    return "GsonParam{" + "name='" + name + '\'' + ", realName='" + realName + '\'' + '}';
  }
}
