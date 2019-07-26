package com.yuanshijia.javalearn.produceerconsumerproblem;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author yuanshijia
 * @date 2019-07-26
 * @description
 */
public class BlockingQueueTest {

    /**
     * 缓冲区大小
     */
    private static final int N = 10;

    private static final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(N);


    private void test(){

        for (int i = 0; i < N; i++) {
            new Thread(new Producer()).start();
            new Thread(new Consumer()).start();
        }

    }

    public static void main(String[] args) {
        BlockingQueueTest test = new BlockingQueueTest();
        test.test();
    }

    static class Producer implements Runnable{

        @Override
        public void run() {
            while (true) {
                // 生产者不断生产消息
                Integer integer = ThreadLocalRandom.current().nextInt(100);
                try {
                    queue.put(integer);
                    System.out.println("【生产者】: " + Thread.currentThread().getName() + ", 生产一个产品：" + integer + "，当前缓冲区容量：" + queue.size());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    static class Consumer implements Runnable{

        @Override
        public void run() {
            while (true) {
                // 消费者不断消费数据
                try {
                    Integer integer = queue.take();
                    System.out.println("【消费者】: " + Thread.currentThread().getName() + ", 消费一个产品：" + integer + "，当前缓冲区容量："  + queue.size());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
