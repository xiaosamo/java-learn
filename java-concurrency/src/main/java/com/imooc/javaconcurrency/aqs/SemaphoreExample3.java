package com.imooc.javaconcurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author yuan
 * @date 2019/8/3
 * @description
 * 尝试获取许可，如果不能就抛弃
 * 这个示例只有3个线程获取许可
 * 而当有3个线程获取许可后，没有许可了， 其他17个线程就不会执行了
 */
@Slf4j
public class SemaphoreExample3 {

    private static final int threadCount = 20;
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3);

        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            int finalI = i;
            executorService.execute(()->{
                try {
                    // 尝试获取一个许可，如果能获取，就执行，否则抛弃
                    if (semaphore.tryAcquire()) {
                        test(finalI);
                        semaphore.release(); // 释放一个许可
                    }
                } catch (InterruptedException e) {
                    log.error("exception", e);
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        // 等待所有线程实现完
        countDownLatch.await();
        log.info("finish");

        // 关闭线程池
        executorService.shutdown();

    }

    private static void test(int threadCount) throws InterruptedException {
        log.info("{}", threadCount);
        Thread.sleep(1000);
        System.out.println();

    }
}
