package com.yuanshijia.javalearn.javaspi;

import java.util.ServiceLoader;

/**
 * @author yuan
 * @date 2019/5/22
 * @description
 */
public class Test {
    public static void main(String[] args) {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }
}
