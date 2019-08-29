package com.yuanshijia.javalearn.javaspi;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author yuan
 * @date 2019/5/22
 * @description
 */
@SPI // META-INF.dubbo.internal 的spi 需要加@SPI注解，java的不用
public interface Robot {
    void sayHello();
}