package com.yuanshijia.javalearn.datetest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author yuanshijia
 * @date 2019-07-26
 * @description
 */
public class DateTimeFormatterTest {
    public static void main(String[] args) {
//        DateTimeFormatter dateTimeFormatter = LocalDate.now();
        AtomicLong atomicLong = new AtomicLong(0);
        LongAdder longAdder = new LongAdder();

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                longAdder.increment();
            }).start();
        }



//        atomicLong.incrementAndGet();
//        System.out.println(atomicLong.get());

        System.out.println(longAdder.longValue());

    }
}
