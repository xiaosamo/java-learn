package com.yuanshijia.javalearn.juc.produceerconsumerproblem;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.Semaphore;


/**
 * 生产者消费者问题，使用Semaphore实现
 *
 * @author ysj
 */
public class SemaphoreImpl {

    /**
     * 缓冲区容量大小
     */
    private static final int capacity = 10;

    /**
     * 初始化缓冲区已满到数量为0
     */
    private static Semaphore full = new Semaphore(0);
    /**
     * 初始化缓冲区空的数量为10
     */
    private static Semaphore empty = new Semaphore(capacity);
    /**
     * 每次最多只有一个线程可以读写
     */
    private static Semaphore mutex = new Semaphore(1);

    /**
     * 当前缓冲区已用的数量
     */
    private static AtomicInteger curCount = new AtomicInteger(0);


    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            // 启动生产者
            new Thread(new Producer()).start();

            // 启动消费者
            new Thread(new Consumer()).start();
        }
    }


    /**
     * 生产者
     */
    static class Producer implements Runnable{

        @Override
        public void run() {
            while (true) {
                try {
                    // 只有缓冲区有空位置，生产者才能生产，缓冲区空的数量-1
                    empty.acquire();
                    // 获取读写锁
                    mutex.acquire();
                    curCount.incrementAndGet();
                    System.out.println("生产者: " +Thread.currentThread().getName() + ", 生产了一个，当前缓冲区容量：" + curCount.get());
                    Thread.sleep(1000);
                    // 释放读写锁
                    mutex.release();
                    // 生产者生产了一个，缓冲区满的数量+1
                    full.release();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 消费者
     */
    static class Consumer implements Runnable{

        @Override
        public void run() {
            while (true) {
                try {
                    // 只有缓冲区有内容消费者才能消费，缓冲区满的数量-1
                    full.acquire();
                    // 等待读写锁
                    mutex.acquire();
                    curCount.decrementAndGet();
                    System.out.println("消费者: " +Thread.currentThread().getName() + ", 消费了一个，当前缓冲区容量：" + curCount.get());

                    Thread.sleep(1000);
                    // 释放读写锁
                    mutex.release();
                    // 消费者消费了一个，缓冲区空的数量+1
                    empty.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
        }
    }
}
