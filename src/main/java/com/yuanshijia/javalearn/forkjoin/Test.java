package com.yuanshijia.javalearn.forkjoin;

import java.math.BigInteger;

/**
 * @author ysj
 * @date 2019-06-25
 */
public class Test {
    public static void main(String[] args) {
        BigInteger res = BigInteger.ZERO;

        int first = 1;
        int last = 100000000;
        long start = System.currentTimeMillis();

        for (int i = first; i <= last; i++) {
            res = res.add(BigInteger.valueOf(i));
        }

        long end = System.currentTimeMillis();
        System.out.println(res.toString());
        System.out.printf("耗时%dms\n", end - start);

    }
}
