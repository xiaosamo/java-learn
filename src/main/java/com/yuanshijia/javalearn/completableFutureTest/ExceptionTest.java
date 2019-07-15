package com.yuanshijia.javalearn.completableFutureTest;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

/**
 * @author yuanshijia
 * @date 2019-07-15
 * @description
 */
public class ExceptionTest {
    public static void main(String[] args) {
        // CompletableFuture<Integer> f = CompletableFuture.supplyAsync(() -> (3 + 1)).thenApply(r -> r * r);
        // System.out.println(f.join()); // result 16
        CompletableFuture<Integer> f = CompletableFuture.supplyAsync(() -> 1 / 0)
                .thenApply(r -> r * r)
                .exceptionally(e -> {
                    //类似于 try{}catch{}中的 catch{}
                    return -1;  // 有异常返回-1
                }).handle((integer, throwable) -> {
                    return integer; // -1
                });

        System.out.println(f.join());

    }
}
