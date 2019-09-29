package com.yuanshijia.javalearn.integertest;

import java.math.BigDecimal;

/**
 * @author yuanshijia
 * @date 2019-07-25
 * @description
 */
public class IntegerTest2 {

    public static void main(String[] args) {
        int i1 = 1;
        Integer i2 = 1; // 系统为我们执行了：Integer i = Integer.valueOf(100);

        Integer i3 = new Integer(1);
        Integer i4 = Integer.valueOf(1);

        System.out.println(i1 == i2);
        System.out.println(i1 == i3);
        System.out.println(i2 == i3);
        System.out.println(i2 == i4);


        System.out.println();
        String s1 = "";
        String s2 = String.valueOf("");
        String s3 = new String("");

        System.out.println(s1 == s2);
        System.out.println(s1==s3);
        System.out.println(s2==s3);


        System.out.println();
        int t1 = 129;
        Integer t2 = Integer.valueOf(129);
        System.out.println(t1== t2);

        Integer t3 = 100;
        Integer t4 = 100;
        System.out.println(t3 ==t4);
    }

}
