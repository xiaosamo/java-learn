package com.yuanshijia.javalearn.completableFutureTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author yuanshijia
 * @date 2019-07-15
 * @description
 */
public class VoidTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "，正在执行一个没有返回值的异步任务...");
            sleep(2);
        });
        future.get();
    }

    private static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
