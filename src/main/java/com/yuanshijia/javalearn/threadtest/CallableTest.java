package com.yuanshijia.javalearn.threadtest;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author ysj
 * @date 2019-06-24
 */
public class CallableTest {
    static class Worker implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(3000);
            return Thread.currentThread().getName() +": ok";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();
        System.out.println("main start");

        FutureTask<String> futureTask = new FutureTask<>(new Worker());
        Thread thread = new Thread(futureTask);
        thread.start();


        // get()会阻塞线程，直到执行完毕
        System.out.println(futureTask.get());
        System.out.printf("main end， runtime %d ms",System.currentTimeMillis()- start);

    }
}
