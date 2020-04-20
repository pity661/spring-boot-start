package com.example.demo.domain.thread.synchronize;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-09-18 11:03
 */
public class Customer4 implements Runnable {
    @Override
    public void run() {
        try {
            Method.sub();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
