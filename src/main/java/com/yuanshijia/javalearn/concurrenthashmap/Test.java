package com.yuanshijia.javalearn.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yuan
 * @date 2019/6/29
 * @description
 * V putIfAbsent(K key, V value）；
 *
 * 此方法解释：如果key对应的值value不存在就put,且返回null。如果key对应的值value已存在，则返回已存在的值，且value不能为null，否则会报空指针异常。
 */
public class Test {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

        String a = map.putIfAbsent("111", "aaa");
        System.out.println("aaa=" + a);


        String bbb = map.putIfAbsent("111", "bbb");
        System.out.println("bbb=" + bbb);


        System.out.println("bbb=" + bbb);


    }
}
