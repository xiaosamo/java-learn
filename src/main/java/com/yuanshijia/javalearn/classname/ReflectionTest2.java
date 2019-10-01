package com.yuanshijia.javalearn.classname;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author yuan
 * @date 2019/10/1
 * @description
 */
public class ReflectionTest2 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Student student = new Student("张三");
        Class<? extends Student> clazz = student.getClass();

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true); // 修改private需要添加权限
        name.set(student,"小花");

        System.out.println(student.getName());

    }
}
