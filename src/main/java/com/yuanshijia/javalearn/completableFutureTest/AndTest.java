package com.yuanshijia.javalearn.completableFutureTest;

import java.util.concurrent.CompletableFuture;

/**
 * @author yuanshijia
 * @date 2019-07-15
 * @description
 */
public class AndTest {
    public static void main(String[] args) {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "abcd");
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "测试");
        CompletableFuture<String> f3 = f1.thenCombine(f2, (__, t) -> {
            // f1等待f2，f2最后返回
            System.out.println("拿到" + t);
            return "单元" + t;
        });
        System.out.println(f3.join());
    }
}
