package com.yuanshijia.javalearn.threadpool;

/**
 * @author yuanshijia
 * @date 2019-07-15
 * @description
 */
public class ThreadTest {
    private static  int a;
    public static void add(){
        for (int i = 0; i < 1000; i++) {
            a++;
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                add();
            }).start();
        }
        System.out.println(a);
    }
}
