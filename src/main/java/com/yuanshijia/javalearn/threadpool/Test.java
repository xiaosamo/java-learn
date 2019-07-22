package com.yuanshijia.javalearn.threadpool;

import java.util.concurrent.*;

/**
 * @author yuanshijia
 * @date 2019-07-18
 * @description
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3,
                10,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                new ThreadPoolExecutor.AbortPolicy());

        /**
         * 需要注意选择BlockingQueue
         * new LinkedBlockingQueue<>()初始化大小为Integer.MAX_VALUE
         * 由于达不到阻塞队列的容量，所以只有3个core线程
         * 这可能导致队列数量过大而导致OOM!
         */
        for (int i = 0; i < 20; i++) {
            int finalI = i;
            threadPool.submit(() -> {
                System.out.printf("i=%d,threadName=%s,activeCount = %d \n", finalI,
                        Thread.currentThread().getName(), threadPool.getActiveCount());
            });
        }
        Thread.sleep(12000);
        System.out.printf("threadName=%s,activeCount = %d \n", Thread.currentThread().getName(), threadPool.getActiveCount());
    }
}
