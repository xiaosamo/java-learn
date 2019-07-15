package com.yuanshijia.javalearn.completableFutureTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author yuanshijia
 * @date 2019-07-15
 * @description
 */
public class SerialTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 串行
        CompletableFuture<String> completableFuture =
                CompletableFuture.supplyAsync(() -> "First work...")
                        .thenApply(s -> s + "\nSecond...")
                        .thenApply(String::toLowerCase);
        System.out.println(completableFuture.get());
    }
}
