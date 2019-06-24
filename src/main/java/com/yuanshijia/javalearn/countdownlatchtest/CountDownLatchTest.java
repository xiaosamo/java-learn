package com.yuanshijia.javalearn.countdownlatchtest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ysj
 * @date 2019-06-21
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        CountDownLatch latch = new CountDownLatch(3);


        Worker w1 = new Worker(latch,"张三");
        Worker w2 = new Worker(latch,"李四");
        Worker w3 = new Worker(latch,"王二");

        Boss boss = new Boss(latch);

        executor.execute(w1);
        executor.execute(w2);
        executor.execute(w3);
        executor.execute(boss);

        executor.shutdown();
    }
}
