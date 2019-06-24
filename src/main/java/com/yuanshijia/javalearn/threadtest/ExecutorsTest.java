package com.yuanshijia.javalearn.threadtest;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ysj
 * @date 2019-06-24
 */
public class ExecutorsTest {
    static class SyncExample {
        public void start() {
            for (int i = 0; i < 10; i++) {
                System.out.print(i+ " ");
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        SyncExample example = new SyncExample();
        executorService.execute(() -> example.start());
        executorService.execute(() -> example.start());
    }
}
