package com.yuanshijia.javalearn.classname;

import java.lang.reflect.Method;

/**
 * @author yuan
 * @date 2019/10/1
 * @description
 */
public class ReflectionTest {
    public static void main(String[] args) {
        Class<Student> clazz = Student.class;
        // 获取所有的公有方法，包括超类的
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println(m.getName());
        }

        System.out.println();
        // 获取声明的方法，包括public、private
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println(m.getName());
        }
    }
}
