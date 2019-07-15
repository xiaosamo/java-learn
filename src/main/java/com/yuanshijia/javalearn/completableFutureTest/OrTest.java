package com.yuanshijia.javalearn.completableFutureTest;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * @author yuanshijia
 * @date 2019-07-15
 * @description
 */
public class OrTest {
    public static void main(String[] args) {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            sleep(new Random().nextInt(5));
            return "first";
        });
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            sleep(new Random().nextInt(5));
            return "second";
        });
        CompletableFuture<String> f3 = f1.applyToEither(f2, s -> s);
        System.out.println(f3.join());

    }

    private static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
