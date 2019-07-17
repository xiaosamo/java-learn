package com.yuanshijia.javalearn.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yuanshijia
 * @date 2019-07-17
 * @description
 */
public class ArrayBlockingQueueTest {
    int n = 10000000;
    BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10000000);

    public void test() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(() -> {
            try {
                for (int i = 0; i < n; i++) {
                    queue.put(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                for (int i = 0; i < n; i++) {
                    queue.take();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }

    public static void main(String[] args) {
        ArrayBlockingQueueTest obj = new ArrayBlockingQueueTest();
        obj.test();
    }

}
