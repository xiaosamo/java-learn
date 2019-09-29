package com.yuanshijia.javalearn.hashmaptest;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author yuan
 * @date 2019/9/22
 * @description
 */
public class Test {

    final static HashMap<String, String> map = new HashMap<>();
    public static void main(String[] args) {

        double d = 1.00_1___1;



        System.out.println(d);

        BigDecimal a = new BigDecimal("2.0");
        BigDecimal b = new BigDecimal("1.1");

        System.out.println(a.subtract(b).toString());

        System.out.println(2.0 - 1.1);

//        for (int i = 0; i < 1000; i++) {
//            new Thread(() -> {
//                map.put(UUID.randomUUID().toString(), "");
//            }).start();
//        }
    }

}
