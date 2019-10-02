package com.yuanshijia.javalearn.proxy;

/**
 * @author yuan
 * @date 2019/10/2
 * @description
 */
public class StaticTest {
    public static void main(String[] args) {
        UserService userService = new UserStaticProxy();
        userService.add();
        userService.delete();

    }
}
