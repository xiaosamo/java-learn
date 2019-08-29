package com.yuanshijia.javalearn.jvm;

/**
 * @author yuanshijia
 * @date 2019-08-15
 * @description
 * 死锁例子
 */
public class DeadLockDemo {
    static class SyncAddRunable implements Runnable{

        int a,b;

        public SyncAddRunable(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)){
                synchronized (Integer.valueOf(b)) {
                    System.out.println(a + b);
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new SyncAddRunable(1, 2)).start();
            new Thread(new SyncAddRunable(2, 1)).start();
        }
    }
}
