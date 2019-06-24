package com.yuanshijia.javalearn.threadtest;

/**
 * 通过调用一个线程的 interrupt() 来中断该线程，如果该线程处于阻塞、限期等待或者无限期等待状态，那么就会抛 出 InterruptedException，从而提前结束该线程。但是不能中断 I/O 阻塞和 synchronized 锁阻塞。
 * @author ysj
 * @date 2019-06-24
 */
public class InterruptExample {
    static class Worker extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + ": run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();
        // 抛出InterruptedException
        worker.interrupt();
    }
}
