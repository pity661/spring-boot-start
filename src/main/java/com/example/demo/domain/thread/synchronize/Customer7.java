package com.example.demo.domain.thread.synchronize;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-09-18 13:53
 */
public class Customer7 implements Runnable {

    Method method;

    public Customer7(Method method) {
        this.method = method;
    }

    private Customer7() {
    }

    @Override
    public void run() {
        try {
            this.method.reEnter();
            this.method.reEnter();
            this.method.add();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
