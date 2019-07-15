package com.yuanshijia.javalearn.completableFutureTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author yuanshijia
 * @date 2019-07-15
 * @description
 */
public class ReturnStringTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println(Thread.currentThread().getName() + " run...");
                    sleep(2);
                    return "success";
                });


        System.out.println(completableFuture.get());
    }


    private static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
