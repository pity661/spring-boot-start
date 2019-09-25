package com.example.demo.domain.thread.threadLocal.weakReference;

import java.lang.ref.WeakReference;

/**
 * @program: demo
 * @description: gc时，弱引用对象apple对象会被回收
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-09-24 16:30
 */
public class Salad extends WeakReference<Apple> {
  public Salad(Apple apple) {
    super(apple);
  }
}
