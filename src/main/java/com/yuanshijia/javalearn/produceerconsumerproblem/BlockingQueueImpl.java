package com.yuanshijia.javalearn.produceerconsumerproblem;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ForkJoinPool;

/**
 * 使用 BlockingQueue 实现生产者消费者问题
 *
 * @author ysj
 * @date 2019-06-25
 */
public class BlockingQueueImpl {

    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
    private static Random random = new Random();


    public static void main(String[] args) {
        // 1个生产者、2个消费者
        new Producer().start();

        new Consumer().start();
        new Consumer().start();
    }

    static class Producer extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    String product = random.nextInt(100) + "";
                    queue.put(product);
                    System.out.println("[生产者" + Thread.currentThread().getName() + "]：生产产品：" + product);

                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer extends Thread{
        @Override
        public void run() {
            try {
                while (true) {
                    String product = queue.take(); // 从队列获取产品
                    System.out.println("[消费者" + Thread.currentThread().getName() + "]：消费产品：" + product);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
