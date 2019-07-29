package com.yuanshijia.javalearn.blockingqueue.delayqueue;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author yuanshijia
 * @date 2019-07-29
 * @description
 * 队列中要执行的任务
 * 实现Delayed接口
 */
public class Task<T extends Runnable> implements Delayed {

    /**
     * 到期时间
     */
    private final long time;


    /**
     * 问题对象
     */
    private final T task;

    private static final AtomicLong atomic = new AtomicLong(0);

    private final long n;
    public Task(long timeout, T t) {
        this.time = System.nanoTime() + timeout;
        this.task = t;
        this.n = atomic.getAndIncrement();
    }


    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.time - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    /**
     * 实现此方法的目的是，该任务最终会被装载入DelayQueue里的优先队列（PriorityQueue）中，而优先队列
     * 之所以叫优先队列，就是通过此方法来比对同等条件下哪些任务被优先弹出。
     * @param other
     * @return
     */

    @Override
    public int compareTo(Delayed other) {
        if (other == this) {
            // compare zero ONLY if same object
            return 0;
        }
        if (other instanceof Task) {
            Task x = (Task) other;
            long diff = time - x.time;
            if (diff < 0) {
                return -1;
            } else if (diff > 0) {
                return 1;
            } else if (n < x.n) {
                return -1;
            } else {
                return 1;
            }

        }
        long d = (getDelay(TimeUnit.NANOSECONDS) - other.getDelay(TimeUnit.NANOSECONDS));
        return (d == 0) ? 0 : ((d < 0) ? -1 : 1);
    }

    @Override
    public int hashCode() {
        return task.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Task) {
            return obj.hashCode() == hashCode();
        }
        return false;
    }

    public T getTask() {
        return task;
    }
}
