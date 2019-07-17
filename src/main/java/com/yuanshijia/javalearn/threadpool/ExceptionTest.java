package com.yuanshijia.javalearn.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author yuanshijia
 * @date 2019-07-17
 * @description
 */
public class ExceptionTest {
    static int n = 5;

    public static void exectionTest() {
        ExecutorService threadPool = Executors.newFixedThreadPool(n);
        for (int i = 0; i < n; i++) {
            Future<?> future = threadPool.submit(() -> {
                System.out.println("current thread name: " + Thread.currentThread().getName());
                Object object = null;
                System.out.print("result## " + object.toString());
            });
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                System.out.println("发生异常");
            }

        }
    }
    
    public static void main(String[] args) {

        fixedThreadPoolTest();
    }

    /**
     * 线程池特点：
     * 核心线程数和最大线程数大小一样
     * 没有所谓的非空闲时间，即keepAliveTime为0
     * 阻塞队列为无界队列LinkedBlockingQueue
     */
    public static void fixedThreadPoolTest(){
        ExecutorService threadPool = Executors.newFixedThreadPool(100);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            int finalI = i;
            threadPool.execute(() -> {
                try {
                    System.out.println("current thread name: " + Thread.currentThread().getName() + ", i=" + finalI);
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
