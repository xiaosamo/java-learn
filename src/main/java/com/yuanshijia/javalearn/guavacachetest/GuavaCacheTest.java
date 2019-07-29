package com.yuanshijia.javalearn.guavacachetest;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.checkerframework.checker.units.qual.C;

import java.util.concurrent.Callable;

/**
 * @author yuan
 * @date 2019/7/29
 * @description
 */
public class GuavaCacheTest {
    public static void main(String[] args) {
        Cache<String, Integer> cache = CacheBuilder.newBuilder().build();


        cache.put("aaa", 1);
        cache.put("bbb", 2);
        cache.put("ccc", 3);


    }
}
