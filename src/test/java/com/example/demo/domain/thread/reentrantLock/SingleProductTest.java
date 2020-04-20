package com.example.demo.domain.thread.reentrantLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class SingleProductTest {

    /**
     * 两个线程轮流工作，一个生产者一个消费者
     *
     * @throws InterruptedException
     */
    @Test
    public void baseTest() throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        SingleProduct singleProduct = new SingleProduct();
        SingleProduct.Produce produce = singleProduct.new Produce();
        SingleProduct.Customer customer = singleProduct.new Customer();
        service.execute(produce);
        service.execute(customer);
        Thread.sleep(3000);
    }
}
