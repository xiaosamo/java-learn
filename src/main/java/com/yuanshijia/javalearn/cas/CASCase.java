package com.yuanshijia.javalearn.cas;

/**
 * @author yuan
 * @date 2019/9/15
 * @description
 */
public class CASCase {
    private volatile int value;

    private void add(){
        value++;
    }
}
