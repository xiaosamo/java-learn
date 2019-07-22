package com.yuanshijia.javalearn.threadtest;

/**
 * @author yuanshijia
 * @date 2019-07-18
 * @description
 */
public class StackTraceTest {
    private static void thread(){
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        for (StackTraceElement e : elements) {
            System.out.println(e.getMethodName());

        }
    }
    public static void main(String[] args) {
        thread();
    }
}
