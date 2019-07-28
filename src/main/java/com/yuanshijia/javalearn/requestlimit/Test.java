package com.yuanshijia.javalearn.requestlimit;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author yuan
 * @date 2019/5/28
 * @description
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        TokenBucket tokenBucket = new TokenBucket(100, 1);
        for (int i = 0; i < 200; i++) {
            if (i == 10 || i == 180) {
                Thread.sleep(500);
            }
            System.out.println("第" + i + "次请求结果=" + tokenBucket.getToken());
        }


    }
}
