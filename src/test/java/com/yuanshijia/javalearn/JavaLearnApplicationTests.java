package com.yuanshijia.javalearn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.concurrent.atomic.LongAdder;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class JavaLearnApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println(3436 / 100.00);
        double d = 3436 / 100.00;
//        System.out.println(new BigDecimal(3436/100.00).setScale(2).doubleValue());
        System.out.println(new BigDecimal(String.valueOf(3436/100.00)).setScale(2).doubleValue());
//        LongAdder longAdder
    }

}
