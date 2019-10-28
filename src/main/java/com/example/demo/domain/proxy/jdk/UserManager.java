package com.example.demo.domain.proxy.jdk;

/**
 * @program: demo
 * @description: 接口定义，真实处理类和代理类的共同接口
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-10-24 12:03
 */
public interface UserManager {
  void addUser(String id, String password);
}
