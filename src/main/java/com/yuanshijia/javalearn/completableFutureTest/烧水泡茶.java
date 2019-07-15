package com.yuanshijia.javalearn.completableFutureTest;

import java.util.concurrent.CompletableFuture;

/**
 * @author yuanshijia
 * @date 2019-07-15
 * @description
 */
public class 烧水泡茶 {
    // 任务 1：洗水壶 -> 烧开水
    static CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
        System.out.println("T1：洗水壶...");
        sleep(2);
        System.out.println("T1：烧开水...");
        sleep(5);
    });


    // 任务 2：洗茶壶 -> 洗茶杯 -> 拿茶叶
    static CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
        System.out.println("T2: 洗茶壶...");
        sleep(1);

        System.out.println("T2: 洗茶杯...");
        sleep(2);

        System.out.println("T2: 拿茶叶...");
        sleep(1);

        return "龙井";
    });


    // 任务 3：任务 1 和任务 2 完成后执行：泡茶
    static CompletableFuture<String> f3 = f1.thenCombine(f2, (__, tf) -> {
        // 任务 3 要等待任务 1 和任务 2 都完成后才能开始
        System.out.println("T3：拿到茶叶：" + tf);
        System.out.println("T3：泡茶");
        return "上茶：" + tf;
    });


    private static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        System.out.println("测试代码...");
        System.out.println(f3.join());
    }
}
