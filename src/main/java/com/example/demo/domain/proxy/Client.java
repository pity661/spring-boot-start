package com.example.demo.domain.proxy;

import com.example.demo.domain.proxy.cglib.CGLibProxy;
import com.example.demo.domain.proxy.jdk.JDKProxy;
import com.example.demo.domain.proxy.jdk.UserManager;
import com.example.demo.domain.proxy.jdk.UserManagerImpl;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-10-24 12:16
 */
public class Client {
  public static void main(String[] args) {
    System.out.println("==== CGLibProxy ====");
    CGLibProxy cgLibProxy = new CGLibProxy();
    UserManager userManager = (UserManager) cgLibProxy.proxy(new UserManagerImpl());
    userManager.addUser("wenky", "wenky001");

    System.out.println("==== JDKProxy ====");
    JDKProxy jdkProxy = new JDKProxy();
    UserManager jdkUserManager = (UserManager) jdkProxy.proxy(new UserManagerImpl());
    jdkUserManager.addUser("wenky", "wenky001");
  }
}
