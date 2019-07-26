package com.yuanshijia.javalearn.locktest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yuanshijia
 * @date 2019-07-26
 * @description
 */
public class LockTest {
    public static void main(String[] args) {
        LockTest test = new LockTest();
        test.test();
    }

    private void test(){
        ReentrantLock lock = new ReentrantLock();
        try {
            // 如果lock前面的代码抛出异常，会跳过lock，执行finally的unlock
            // 没有加锁执行unlock会抛出IllegalMonitorStateException
            int a = 1 / 0;
            lock.lock();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
