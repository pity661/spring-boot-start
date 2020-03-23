package com.example.demo.domain.serializable.single;

import java.io.*;

/**
 * @program: demo
 * @description:
 * @author: wenky
 * @email: huwenqi@panda-fintech.com
 * @create: 2020-02-18 17:53
 */
public class SingleSerial {
  public static void main(String[] args) throws Exception {
    String fileName = "/Users/huwenqi/Desktop/single-person.out";
    File file = new File(fileName);
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
    objectOutputStream.writeObject(SinglePerson.getInstance());
    objectOutputStream.close();

    ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
    Object person = objectInputStream.readObject();
    objectInputStream.close();
    System.out.println(person);

    System.out.println(SinglePerson.getInstance() == person);
  }
}
