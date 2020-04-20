package com.example.demo.domain.thread.synchronize;

import static org.junit.Assert.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class MethodTest {
    /**
     * 实例方法测试： 1.不同实例同时执行同一个同步方法 2.同一个实例执行同一个同步方法
     *
     * @throws InterruptedException
     */
    @Test
    public void customer1Test() throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        Customer1 customer = new Customer1(new Method());
        Customer1 customer1 = new Customer1(new Method());
        service.execute(customer);
        service.execute(customer1);
        // 防止主线程先退出了
        Thread.sleep(5000);
        // 退出Executor
        service.shutdown();
    }

    /**
     * 实例方法测试，方法内同步代码块
     *
     * @throws InterruptedException
     */
    @Test
    public void customer2Test() throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        Customer2 customer = new Customer2(new Method());
        Customer2 customer2 = new Customer2(new Method());
        service.execute(customer);
        service.execute(customer2);
        Thread.sleep(5000);
        service.shutdown();
    }

    /**
     * 静态方法测试，同一时间只能有一个线程执行同步静态方法
     *
     * @throws InterruptedException
     */
    @Test
    public void customer3Test() throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        Customer3 customer = new Customer3();
        Customer3 customer3 = new Customer3();
        service.execute(customer);
        service.execute(customer3);
        Thread.sleep(5000);
        service.shutdown();
    }

    /**
     * 静态方法测试，静态方法内同步代码块
     *
     * @throws InterruptedException
     */
    @Test
    public void customer4Test() throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        Customer4 customer = new Customer4();
        Customer4 customer4 = new Customer4();
        service.execute(customer);
        service.execute(customer4);
        Thread.sleep(5000);
        service.shutdown();
    }

    /**
     * 静态方法代码块同步时，实例方法不能被调用
     *
     * @throws InterruptedException
     */
    @Test
    public void customer5Test() throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        Customer5 customer = new Customer5(new Method());
        service.execute(customer);
        Thread.sleep(5000);
        service.shutdown();
    }

    /**
     * 静态方法同步同静态方法内代码块同步，实例不能被调用
     *
     * @throws InterruptedException
     */
    @Test
    public void customer6Test() throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        Customer6 customer = new Customer6(new Method());
        service.execute(customer);
        Thread.sleep(5000);
        service.shutdown();
    }

    @Test
    public void customer7Test() throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        Customer7 customer = new Customer7(new Method());
        service.execute(customer);
        Thread.sleep(10000);
        service.shutdown();
    }
}
