package com.example.demo.domain.proxy.cglib;

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-10-24 12:12
 */
public class CGLibProxy implements MethodInterceptor {
  private Object object;

  public Object proxy(Object object) {
    this.object = object;
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(object.getClass());
    enhancer.setCallback(this);
    Object proxy = enhancer.create();
    return proxy;
  }

  @Override
  public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy)
      throws Throwable {
    // 执行业务之前执行
    System.out.println("====cglib拦截器执行业务之前执行====");
    // 执行业务并返回结果
    Object result = method.invoke(object, objects);
    // 执行完业务后执行
    System.out.println("====cglib拦截器执行完业务后执行====");
    return result;
  }
}
