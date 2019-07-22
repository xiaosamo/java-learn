package com.yuanshijia.javalearn.concurrentmap;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * @author yuanshijia
 * @date 2019-07-22
 * @description
 */
public class ConcurrentHashMapTest {
    /**
     * computeIfAbsent()和putIfAbsent()的区别
     * 1.第一个是性能上的区别，如果Key存在的话，computeIfAbsent因为传入的是一个函数，函数压根就不会执行，而putIfAbsent需要直接传值。所以如果要获得Value代价很大的话，computeIfAbsent性能会好
     * 2.第二个是使用上的区别，computeIfAbsent返回是的是操作后的值，如果之前值不存在的话就返回计算后的值，如果本来就存在那么就返回本来存在的值，putIfAbsent返回的是之前的值，如果原来值不存在那么会得到null
     */
    private static void test(){
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        System.out.println("Start");

        System.out.printf("putIfAbsent:%s\n", concurrentHashMap.putIfAbsent("test1", getValue()));
        System.out.printf("computeIfAbsent:%s\n", concurrentHashMap.computeIfAbsent("test1", k -> getValue()));

        System.out.printf("putIfAbsent again:%s\n", concurrentHashMap.putIfAbsent("test2", getValue()));
        System.out.printf("computeIfAbsent again:%s\n", concurrentHashMap.computeIfAbsent("test2", k -> getValue()));

    }

    private static String getValue() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
//        test();
        funcTest("yuan");
    }

    public static void funcTest(String name) {
        Function<String, String> function = a -> a + name;
        System.out.println(function.apply("hello "));
    }
}
