package com.example.demo.domain.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-10-24 12:06
 */
public class JDKProxy implements InvocationHandler {
  // 需要代理的目标对象
  private Object object;

  public Object proxy(Object object) {
    this.object = object;
    // 返回代理对象
    return Proxy.newProxyInstance(
        object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    // 执行业务之前执行
    System.out.println("====jdk拦截器执行业务之前执行====");
    // 执行业务并返回结果
    Object result = method.invoke(object, args);
    // 执行完业务后执行
    System.out.println("====jdk拦截器执行完业务后执行====");
    return result;
  }
}
