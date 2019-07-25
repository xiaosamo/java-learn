package com.yuanshijia.javalearn.integertest;

import java.math.BigDecimal;

/**
 * @author yuanshijia
 * @date 2019-07-25
 * @description
 */
public class IntegerTest {
    private void test() {
        Integer a = 111;
        Integer b = 222;
        Integer c = 222;
        Integer d = 111;

        // a和d的地址一样,b、c不一样
        System.out.println(b == c);  // false
        System.out.println(a == d);  // true
    }

    public static void main(String[] args) {
        IntegerTest test = new IntegerTest();

        test.test();

        BigDecimal a = new BigDecimal(0.1f);
        System.out.println(a.toString());

        BigDecimal b = new BigDecimal("0.1");
        System.out.println(b.toString());

        System.out.println(a.equals(b));

    }
}
