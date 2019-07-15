package com.yuanshijia.javalearn.threadlocal;

/**
 * @author ysj
 * @date 2019-06-28
 */
public class ThreadLocalTest {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() ->{
            for (int i = 0; i < 100; i++) {
                threadLocal.set(i);
                System.out.println(Thread.currentThread().getName() + "===" + threadLocal.get());
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
            threadLocal.remove();
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "===" + threadLocal.get());
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
            threadLocal.remove();
        }).start();

    }

}
