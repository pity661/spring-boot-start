package com.example.demo.domain.proxy.jdk;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-10-24 12:05
 */
public class UserManagerImpl implements UserManager {

  @Override
  public void addUser(String id, String password) {
    System.out.println("====调用了UserManagerImpl.addUser()方法====");
  }
}
