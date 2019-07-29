package com.yuanshijia.javalearn.blockingqueue.delayqueue;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * @author yuanshijia
 * @date 2019-07-29
 * @description
 * AbstractQueue这个类提供了一些Queue操作的骨架实现。 当你需要实现一个元素不能为null的队列时，就可以继承这个类。
 * 动态类型必须是实现了Delayed接口的，因为只有实现了Delayed接口的任务才能获取到定时的剩余时间，才能判断什么时候把到期的任务弹出。
 * 为了让我们的队列是一个阻塞队列，我们需要实现接口BlockingQueue
 *
 *
 * BlockingQueue即阻塞队列，从阻塞这个词可以看出，在某些情况下对阻塞队列的访问可能会造成阻塞。被阻塞的情况主要有如下两种：
 * 1. 当队列满了的时候进行入队列操作
 * 2. 当队列空了的时候进行出队列操作
 */
public class MyDelayQueue<E extends Delayed> extends AbstractQueue<E>
        implements BlockingQueue<E> {


    /**
     * 使用PriorityQueue来装载任务
     * 有些时候需要在队列中基于优先级处理对象
     */
    private final PriorityQueue<E> q = new PriorityQueue<>();

    /**
     * PriorityQueue是线程不安全的
     * 需要使用重入锁
     */
    private final transient ReentrantLock lock = new ReentrantLock();

    /**
     * 用来表示当前，等待头节点的这个线程
     * 用于线程的等待以及唤醒的触发，稍后会详细介绍Leader-Follower模式
     */
    private Thread leader = null;

    /**
     * Condition的基本动作就是负责唤醒和挂起线程
     */
    private final Condition available = lock.newCondition();
    


    @Override
    public int size() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return q.size();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean add(E e) {
        return offer(e);
    }

    @Override
    public boolean offer(E e) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            // 调用priorityBlockingqueue进行添加
            q.offer(e);
            // 判断e是不是队头元素。
            if (q.peek() == e) {
                // 如果是,刚放进去，肯定没人等，所以leader设为null
                leader = null;
                available.signal();
            }
            // 否则直接加入即可
            return true;
        }finally {
            lock.unlock();
        }
    }

    @Override
    public void put(E e) throws InterruptedException {
        
    }

    @Override
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public E take() throws InterruptedException {
        //每个方法都持有一个lock
        final ReentrantLock lock = this.lock;
        // //可以中断的加锁，如果当前线程被中断，那么抛出异常无法获取锁
        lock.lockInterruptibly();
        try {
            // 自旋，只有拿到了，才返回
            for (;;) {
                //去获取优先队列中index为0的对象（在优先队列中是通过数组实现）
                E first = q.peek();
                if (first == null) {
                    //如果没有拿到，那么就让该线程等待
                    System.out.println("awating");
                    //该线程一直等待，直到被signal唤醒或interrupted
                    available.await();
                } else {
                    //如果第一个元素拿到了
                    /**
                     * 那么就去获取到第一个元素所设置的延迟时间。
                     * 我们队列中的每个元素都是实现了Delayed接口的，所以是可以拿到元素自定义的getDelay的延迟时间的
                     */
                    long delay = first.getDelay(NANOSECONDS);

                    /**
                     * 如果延迟为小于等于0，那么就意味着这个任务到点了，要被执行了，于是就弹出该任务（元素）。
                     */
                    if (delay < 0) {
                        //弹出该元素，然后返回（得到，然后从队列中删除掉），本次take执行完成。
                        return q.poll();
                    }

                    /**
                     * 如果delay大于0，说明该任务还没到时间点
                     */
                    //那么就把这个first给置为null
                    first = null;

                    /**
                     * 以下是有关leader的逻辑，以下的逻辑借鉴了Leader-Follower模式。
                     *
                     * 基本逻辑是：
                     *
                     * 1、如果已经有leader了，那么就让当前线程挂起。
                     * 2、如果还没有leader，那么就把当前线程选为leader。
                     * 3、然后让当前线程等待delay等长时间。
                     */
                    if (leader != null) {
                        // leader不为null，那么就继续等待吧，因为有别的线程leader在等待了
                        available.await();
                    } else {
                        // 说明没人等，就我先来我先说我在等待，把当前线程设为leader。
                        Thread thisThread = Thread.currentThread();
                        leader = thisThread;
                        try {
                            // 把当前线程放入available队列里面等待。
                            available.awaitNanos(delay);
                        }finally {
                            if (leader == thisThread) {
                                // 最后拿到了，将leader置null
                                leader = null;
                            }
                        }
                    }
                }
            }
        }finally {
            // return之前，走这一步，signal一个
            if (leader == null && q.peek() != null) {
                // 如果现在没有leader，并且队列中已经有任务了
                // 检测leader，如果leader为null，则signal唤醒一个。
                System.out.println("激活线程");
                available.signal();
            }
            lock.unlock();
        }
    }




    @Override
    public E poll() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            E first = q.peek();
            // 如果第一个元素为空，或者还没过期，返回null
            if (first == null || first.getDelay(NANOSECONDS) > 0) {
                return null;
            }
            return q.poll();
        }finally {
            lock.unlock();
        }
    }

    @Override
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public int remainingCapacity() {
        // 无界队列
        return Integer.MAX_VALUE;
    }

    @Override
    public int drainTo(Collection<? super E> c) {
        return 0;
    }

    @Override
    public int drainTo(Collection<? super E> c, int maxElements) {
        return 0;
    }


    @Override
    public E peek() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return q.peek();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void clear() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            q.clear();
        }finally {
            lock.unlock();
        }
    }

    void removeEQ(Object o) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            for (Iterator<E> it = q.iterator(); it.hasNext(); ) {
                if (o == it.next()) {
                    it.remove();
                    break;
                }
            }
        }finally {
            lock.unlock();
        }

    }


    @Override
    public Object[] toArray(){
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return q.toArray();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr(toArray());
    }

    private class Itr implements Iterator<E> {
        final Object[] array; // Array of all elements
        int cursor;           // index of next element to return
        int lastRet;          // index of last element, or -1 if no such

        Itr(Object[] array) {
            lastRet = -1;
            this.array = array;
        }

        @Override
        public boolean hasNext() {
            return cursor < array.length;
        }

        @Override
        public E next() {
            if (cursor >= array.length) {
                throw new NoSuchElementException();
            }
            return (E) array[lastRet = cursor++];
        }

        @Override
        public void remove() {
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            removeEQ(array[lastRet]);
            lastRet = -1;
        }
    }

}
