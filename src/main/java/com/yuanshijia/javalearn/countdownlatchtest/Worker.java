package com.yuanshijia.javalearn.countdownlatchtest;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 工人
 * @author ysj
 * @date 2019-06-21
 */
public class Worker implements Runnable{
    private final CountDownLatch downLatch;
    private String name;

    public Worker(CountDownLatch downLatch, String name) {
        this.downLatch = downLatch;
        this.name = name;
    }


    @Override
    public void run() {
        doWork();
        try{
            Thread.sleep(new Random().nextInt(7000));
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(this.name + "活干完了！");
        this.downLatch.countDown();
    }

    private void doWork() {
        System.out.println(this.name + "正在干活!");
    }
}
