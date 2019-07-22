package com.yuanshijia.javalearn.offer;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author yuanshijia
 * @date 2019-07-22
 * @description
 */
public class Test {
    public static void main(String[] args) {
        ConcurrentSkipListMap<String, String> map = new ConcurrentSkipListMap<>();

        map.put("a", "111");
        map.put("b", "222");
        map.put("c", "333");


        System.out.println(map.get("a"));
        System.out.println(map.get("b"));
        System.out.println(map.get("c"));
    }
}
