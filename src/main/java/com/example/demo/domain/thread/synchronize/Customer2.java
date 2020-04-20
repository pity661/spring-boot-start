package com.example.demo.domain.thread.synchronize;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-09-18 10:52
 */
public class Customer2 implements Runnable {
    Method method;

    public Customer2(Method method) {
        this.method = method;
    }

    private Customer2() {
    }

    @Override
    public void run() {
        try {
            this.method.multi();
            this.method.multi();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
