package com.example.demo.domain.serializable.simple;

import com.example.demo.domain.serializable.Gender;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @program: demo
 * @description:
 * @author: wenky
 * @email: huwenqi@panda-fintech.com
 * @create: 2020-02-18 17:27
 */
public class Person implements Serializable {
  /** 该属性可有可无，但是反序列化时类的该属性被修改与序列化时不同则会导致反序列化失败 */
  private static final long serialVersionUID = -1587482476850089528L;

  private String name;
  private transient Integer age; // 使用默认序列化机制会忽略该字段
  private Gender gender;

  private void writeObject(ObjectOutputStream out) throws IOException {
    out.defaultWriteObject();
    out.writeInt(age);
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    age = in.readInt();
  }

  public Person() {
    System.out.println("none arg constructor");
  }

  public Person(String name, Integer age, Gender gender) {
    System.out.println("arg constructor");
    this.name = name;
    this.age = age;
    this.gender = gender;
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

  @Override
  public String toString() {
    return "Person{" + "name='" + name + '\'' + ", age=" + age + ", gender=" + gender + '}';
  }
}
