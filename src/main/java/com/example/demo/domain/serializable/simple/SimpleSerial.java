package com.example.demo.domain.serializable.simple;

import com.example.demo.domain.serializable.Gender;
import java.io.*;

/**
 * @program: demo
 * @description:
 * @author: wenky
 * @email: huwenqi@panda-fintech.com
 * @create: 2020-02-18 17:30
 */
public class SimpleSerial {
  public static void main(String[] args) throws Exception {
    String fileName = "/Users/huwenqi/Desktop/person.out";
    File file = new File(fileName);
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
    Person person = new Person("wenky", 22, Gender.MALE);
    objectOutputStream.writeObject(person);
    objectOutputStream.close();

    ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
    Object object = objectInputStream.readObject();
    objectInputStream.close();
    System.out.println(object);
    /** 打印结果 # arg constructor # Person{name='wenky', age=22, gender=MALE} */
  }
}
