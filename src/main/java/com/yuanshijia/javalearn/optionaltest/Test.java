package com.yuanshijia.javalearn.optionaltest;

import java.util.Optional;

/**
 * @author yuanshijia
 * @date 2019-07-30
 * @description
 */
public class Test {

    public static void main(String[] args) {
        User u1 = null;
        User u2 = new User("111", "yuan");

        System.out.println(print(u1));
        System.out.println(print(u2));

    }

    private static String print(User user) {
        return Optional.ofNullable(user).map(User::toString).orElse("");
    }
}
