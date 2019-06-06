package com.yuanshijia.javalearn.requestlimit;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author yuan
 * @date 2019/5/29
 * @description
 */
public interface Inter {
     void fun1();

    default void fun2() {
        System.out.println("hel");
    }

    public static void main(String[] args) {
        new CopyOnWriteArrayList<>();
        System.out.println("ok");
    }
}
