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
 * 一次性获取和释放多个许可
 * 只设置3个许可，并一次获取3个许可，释放3个许可
 */
@Slf4j
public class SemaphoreExample2 {

    private static final int threadCount = 20;
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3);

        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            int finalI = i;
            executorService.execute(()->{
                try {
                    semaphore.acquire(3); // 获取3许可
                    test(finalI);
                    semaphore.release(3); // 释放3许可
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
