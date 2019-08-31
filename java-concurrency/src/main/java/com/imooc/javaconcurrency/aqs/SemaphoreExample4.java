package com.imooc.javaconcurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author yuan
 * @date 2019/8/3
 * @description
 * 尝试获取许可，并设置时间5s
 *
 */
@Slf4j
public class SemaphoreExample4 {

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
                    if (semaphore.tryAcquire(5000, TimeUnit.MILLISECONDS)) {
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
