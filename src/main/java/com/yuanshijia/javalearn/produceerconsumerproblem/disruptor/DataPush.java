package com.yuanshijia.javalearn.produceerconsumerproblem.disruptor;

import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.dsl.Disruptor;
import lombok.AllArgsConstructor;

import java.util.UUID;

/**
 * @author yuanshijia
 * @date 2019-07-26
 * @description
 */
@lombok.Data
@AllArgsConstructor
public class DataPush implements Runnable {

    private Disruptor<Data> disruptor;


    @Override
    public void run() {
        DataEventTranslator dataEventTranslator = new DataEventTranslator();
        while (true) {
            // 不断提交数据
            disruptor.publishEvent(dataEventTranslator);
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private static class DataEventTranslator implements EventTranslator<Data> {

        /**
         * translateTo
         * 推荐使用的投递数据的方式
         * 比ringBuffer更简单
         *
         * @param event 帮我们创建的对象，需要自己设置属性
         * @param sequence 对象具体的位置
         */
        @Override
        public void translateTo(Data event, long sequence) {
            this.generateData(event);
        }

        private void generateData(Data event) {
            event.setId(UUID.randomUUID().toString());
            System.out.println("【生产者】:" + "生产消息" + event);
        }
    }
}
