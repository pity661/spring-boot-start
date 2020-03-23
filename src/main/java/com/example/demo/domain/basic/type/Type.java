package com.example.demo.domain.basic.type;

import com.example.demo.util.GsonUtil;
import java.util.Date;

/**
 * @program: demo
 * @description:
 * @author: wenky
 * @email: huwenqi@panda-fintech.com
 * @create: 2020-02-27 10:18
 */
public class Type {
  boolean b;
  int anInt;
  long aLong;
  char aChar;
  float aFloat;
  double aDouble;
  byte aByte;
  short aShort;
  private InnerClass innerClass;
  private Date date;
  private String string;

  public InnerClass getInnerClass() {
    return innerClass;
  }

  public void setInnerClass(InnerClass innerClass) {
    this.innerClass = innerClass;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public void setString(String string) {
    this.string = string;
  }

  public static void main(String[] args) {
    // 基本类型如果不初始化直接拿来用会有默认值
    Type type = new Type();
    InnerClass innerClass = new InnerClass();
    innerClass.setDate(new Date());
    type.setInnerClass(innerClass);
    type.setDate(new Date());
    type.setString("='");
    // GSON格式化对象中的对象时间格式
    System.out.println(GsonUtil.toGsonString(type));
  }
}
