package com.yuanshijia.javalearn.jdkcache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author yuan
 * @date 2019/6/6
 * @description
 */
public class Cache2Test {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);
    private static final Future[] futures = new Future[10];
    private static final String key = "id";



    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //不设置过期时间
        System.out.println("***********不设置过期时间**********");
        Cache2.put(key, 123);
        System.out.println("key:" + key + ", value:" + Cache2.get(key));
        System.out.println("key:" + key + ", value:" + Cache2.remove(key));
        System.out.println("key:" + key + ", value:" + Cache2.get(key));

        //设置过期时间
        System.out.println("\n***********设置过期时间**********");
        Cache2.put(key, "123456", 1000);
        System.out.println("key:" + key + ", value:" + Cache2.get(key));
        Thread.sleep(2000);
        System.out.println("key:" + key + ", value:" + Cache2.get(key));

        /******************并发性能测试************/
        System.out.println("\n***********并发性能测试************");

        /********添加********/
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            futures[i] = executorService.submit(() -> {
                for (int j = 0; j < 100000; j++) {
                    Cache2.put(Thread.currentThread().getId() + key + j, j, 300000);
                }
            });
        }
        for (Future future : futures) {
            future.get();
        }
        System.out.printf("添加耗时：%dms\n", System.currentTimeMillis() - start);

        /********查询********/
        double averageTime = 0;
        for (int i = 0; i < 10; i++) {
            long s = System.currentTimeMillis();
            query();
            long e = System.currentTimeMillis();
            averageTime += e - s;
        }
        System.out.printf("十次平均查询耗时：%fms\n", averageTime / 10);


        System.out.println("当前缓存容量：" + Cache2.size());

    }

    private static void query() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            futures[i] = executorService.submit(() -> {
                for (int j = 0; j < 100000; j++) {
                    Cache2.get(Thread.currentThread().getId() + key + j);
                }
            });
        }
        //等待全部线程执行完成，打印执行时间
        for (Future future : futures) {
            future.get();
        }
        System.out.printf("查询耗时：%dms\n", System.currentTimeMillis() - start);
    }
}
