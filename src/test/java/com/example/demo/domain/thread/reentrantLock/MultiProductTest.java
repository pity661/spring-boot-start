package com.example.demo.domain.thread.reentrantLock;

import static org.junit.Assert.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class MultiProductTest {

    /**
     * 很多个线程同时参与工作
     */
    @Test
    public void baseTest() {
        ExecutorService service = Executors.newCachedThreadPool();
        MultiProduct product = new MultiProduct();
        while (true) {
            service.execute(product.new Produce());
            service.execute(product.new Produce());
            service.execute(product.new Customer());
        }
    }
}
