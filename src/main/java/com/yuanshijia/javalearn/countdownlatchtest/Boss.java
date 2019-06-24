package com.yuanshijia.javalearn.countdownlatchtest;

/**
 * @author ysj
 * @date 2019-06-21
 */

import java.util.concurrent.CountDownLatch;

public class Boss implements Runnable {

    private final CountDownLatch downLatch;

    public Boss(CountDownLatch downLatch){
        this.downLatch = downLatch;
    }

    public void run() {
        System.out.println("老板正在等所有的工人干完活......");
        try {
            downLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("工人活都干完了，老板开始检查了！");
    }

}