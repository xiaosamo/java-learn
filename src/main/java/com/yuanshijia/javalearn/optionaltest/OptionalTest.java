package com.yuanshijia.javalearn.optionaltest;

import java.util.Optional;

/**
 * @author yuanshijia
 * @date 2019-07-29
 * @description
 */
public class OptionalTest {
    public static void main(String[] args) {
//        Optional<Integer> integer = Optional.of(1);
//        Optional<Object> optional = Optional.ofNullable(null);
//        System.out.println(optional.get());


        //        Optional<String> optional = Optional.of("hello");
        Optional<String> optional = Optional.empty();

//        //面向对象的编程风格，不推荐使用
//        if(optional.isPresent()) {
//            System.out.println(optional.get());
//        }
        //推荐的Optional使用方式，函数式风格
        optional.ifPresent(System.out::println);
        System.out.println("---");
        System.out.println(optional.orElse("world")); //world
        System.out.println("---");
        System.out.println(optional.orElseGet(() -> "nihao")); //nihao
    }

}
