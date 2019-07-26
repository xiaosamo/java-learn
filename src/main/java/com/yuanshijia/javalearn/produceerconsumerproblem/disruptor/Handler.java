package com.yuanshijia.javalearn.produceerconsumerproblem.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * @author yuanshijia
 * @date 2019-07-26
 * @description
 */
public class Handler implements EventHandler<Data> {

    @Override
    public void onEvent(Data event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("【消费者】：get=" + event.toString());
    }
}
