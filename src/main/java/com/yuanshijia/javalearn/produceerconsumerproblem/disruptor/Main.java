package com.yuanshijia.javalearn.produceerconsumerproblem.disruptor;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SequenceBarrier;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author yuanshijia
 * @date 2019-07-26
 * @description
 */
public class Main {
    private static void test() {
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        // 1.创建disruptor
        Disruptor<Data> disruptor = new Disruptor<>(Data::new,
                1024 * 1024,
                threadFactory,
                ProducerType.MULTI,
                new YieldingWaitStrategy());


        // 2.添加消费者的监听(构建disruptor与消费者的关系)
        disruptor.handleEventsWith(new Handler());

        // 3.启动，并获取实际存储数据的容器 -> RingBuffer
        RingBuffer<Data> ringBuffer = disruptor.start();

        DataPush dataPush = new DataPush(disruptor);

        // 执行生产者
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(dataPush);
        executorService.execute(dataPush);
    }

    public static void main(String[] args) {
        test();
    }
}
