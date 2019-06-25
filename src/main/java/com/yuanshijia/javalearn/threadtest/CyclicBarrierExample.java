package com.yuanshijia.javalearn.threadtest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ysj
 * @date 2019-06-25
 */
public class CyclicBarrierExample {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        final int totalThread = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(totalThread);

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalThread; i++) {
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + ": before ...");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": after.");
            });

        }
        executorService.shutdown();
    }
}
