package com.imooc.javaconcurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yuan
 * @date 2019/8/3
 * @description
 * 多线程执行任务，等待所有任务执行完返回
 */
@Slf4j
public class CountDownLatchExample1 {

    private static final int threadCount = 200;
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            int finalI = i;
            executorService.execute(()->{
                try {
                    test(finalI);
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
        Thread.sleep(100);
        log.info("{}", threadCount);
        Thread.sleep(100);
    }
}
