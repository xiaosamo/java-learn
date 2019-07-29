package com.yuanshijia.javalearn.blockingqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author yuanshijia
 * @date 2019-07-29
 * @description
 */
public class Consumer implements Delayed {
    @Override
    public long getDelay(TimeUnit unit) {
        
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}
