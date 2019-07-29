package com.yuanshijia.javalearn.blockingqueue.delayqueue;

import java.util.concurrent.TimeUnit;

/**
 * @author yuanshijia
 * @date 2019-07-29
 * @description
 * 延时接口
 */
public interface Delayed extends Comparable<Delayed> {

    /**
     * 返回剩余的延迟时间
     * @param unit 时间单位
     * @return 剩余的时间; 零值或负值表示早已过期
     */
    long getDelay(TimeUnit unit);
}
