package com.yuanshijia.javalearn.juc;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author yuan
 * @date 2019/6/22
 * @description
 */
public class CyclicBarrierTest {

    private static final int N = 3;

    public static final CyclicBarrier cyclicBarrier = new CyclicBarrier(N);

    public static void main(String[] args) {
        for (int i = 0; i < N+1; i++) {
            new Thread(new Worker()).start();
        }
    }

    static class Worker implements Runnable{

        @Override
        public void run() {
            try {
                System.out.println("线程：" + Thread.currentThread().getName() + "开始执行...");
                cyclicBarrier.await();
                Thread.sleep(new Random().nextInt(7000));
                System.out.println("线程：" + Thread.currentThread().getName() + "执行完成。");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
