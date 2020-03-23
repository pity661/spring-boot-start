package com.example.demo.domain.serializable.single;

import com.example.demo.domain.serializable.Gender;
import java.io.Serializable;

/**
 * @program: demo
 * @description:
 * @author: wenky
 * @email: huwenqi@panda-fintech.com
 * @create: 2020-02-18 17:50
 */
public class SinglePerson implements Serializable {

  public SinglePerson(String name, Integer age, Gender gender) {
    System.out.println("arg constructor");
    this.name = name;
    this.age = age;
    this.gender = gender;
  }

  public static SinglePerson getInstance() {
    return Instance.person;
  }

  /**
   * 加上这个就会使反序列化生成的对象与单例对象相等
   *
   * @return
   */
  private Object readResolve() {
    return Instance.person;
  }

  public SinglePerson() {
    System.out.println("none arg constructor");
  }

  private static class Instance {
    private static final SinglePerson person = new SinglePerson("wenky", 24, Gender.MALE);
  }

  private String name;
  private Integer age;
  private Gender gender;

  @Override
  public String toString() {
    return "SinglePerson{" + "name='" + name + '\'' + ", age=" + age + ", gender=" + gender + '}';
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }
}
