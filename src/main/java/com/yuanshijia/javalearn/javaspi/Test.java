package com.yuanshijia.javalearn.javaspi;

import java.util.ServiceLoader;

/**
 * @author yuan
 * @date 2019/5/22
 * @description
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            System.out.println("JAVA SPI");
            ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
            for (Robot robot : serviceLoader) {
                robot.sayHello();
            }
            System.out.println();
            Thread.sleep(500);
        }
    }
}
