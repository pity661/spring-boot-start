package com.example.demo.domain.thread.synchronize;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-09-18 12:42
 */
public class Customer5 implements Runnable {

    Method method;

    public Customer5(Method method) {
        this.method = method;
    }

    private Customer5() {
    }

    @Override
    public void run() {
        try {
            Method.div();
            this.method.add();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
