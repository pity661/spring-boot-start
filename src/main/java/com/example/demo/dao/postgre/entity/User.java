package com.example.demo.dao.postgre.entity;

import com.example.demo.dao.BaseModel;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-09-05 14:51
 */
@Entity
@Table(name = "user", schema = "public")
public class User extends BaseModel {
  private Integer age;
  private String name;
  private String phone;

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
