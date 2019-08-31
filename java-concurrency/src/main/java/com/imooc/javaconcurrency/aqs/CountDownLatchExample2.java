package com.imooc.javaconcurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author yuan
 * @date 2019/8/3
 * @description
 * 多线程执行任务，给定等待时间，在规定时间内没有执行完就返回
 */
@Slf4j
public class CountDownLatchExample2 {

    private static final int threadCount = 200;
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            int finalI = i;
//            Thread.sleep(1); // 放到这里没用
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
        /**
         * 等待所有线程实现完，指定等待时间 10ms
         * 注意，这里统计的时间是execute执行的时间
         */
        countDownLatch.await(10, TimeUnit.MILLISECONDS);

        log.info("finish");

        /**
         * 关闭线程池
         * 如果线程池还有线程在运行，调用shutdown不会立即关闭线程，在运行的线程会执行完才释放
         */
        executorService.shutdown();

    }

    private static void test(int threadCount) throws InterruptedException {
        Thread.sleep(1);
        log.info("{}", threadCount);
    }
}
