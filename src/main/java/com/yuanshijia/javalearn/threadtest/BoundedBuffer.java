package com.yuanshijia.javalearn.threadtest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ysj
 * @date 2019-06-25
 */
public class BoundedBuffer {

    private static final Lock lock = new ReentrantLock();
    private static Condition full = lock.newCondition();
    private static Condition empty = lock.newCondition();

    private static final int N = 5;
    private static final Object[] buffer = new Object[N];

    private static int count = 0;

    public static void put() {
        lock.lock();

        while (count == buffer.length) {
            
        }
    }




}
