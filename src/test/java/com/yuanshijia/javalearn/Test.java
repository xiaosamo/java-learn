package com.yuanshijia.javalearn;

/**
 * @author yuanshijia
 * @date 2019-07-18
 * @description
 */
public class Test {
    @org.junit.Test
    public void test(){
         // 获得可用的处理器个数
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

}
