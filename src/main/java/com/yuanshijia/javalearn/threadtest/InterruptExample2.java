package com.yuanshijia.javalearn.threadtest;

/**
 * @author ysj
 * @date 2019-06-24
 */
public class InterruptExample2 {
    static class Worker extends Thread{
        @Override
        public void run() {
            while (!interrupted()) {
                System.out.println(Thread.currentThread().getName() + ": run...");
            }
            System.out.println("Thread end");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        worker.start();
        worker.interrupt();
    }
}
