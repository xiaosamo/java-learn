package com.yuanshijia.javalearn;

import java.util.stream.Stream;

/**
 * @author yuanshijia
 * @date 2019-07-15
 * @description
 */
public class HashCodeTest {

    public HashCodeTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private int age;
    private String name;

    @Override
    public int hashCode() {
        Object[] array = Stream.of(age, name).toArray();
        int result = 1;
        for (Object o : array) {
            result = 31 * result + (o == null ? 0 : o.hashCode());
        }
        return result;
    }

    public static void main(String[] args) {
        HashCodeTest test = new HashCodeTest("like", 21);
        System.out.println(test.hashCode());
        System.out.println(new HashCodeTest("like", 22).hashCode());

        Object[] array = Stream.of(12, "abc").toArray();
        for (Object o : array) {
            System.out.println(o);
        }

    }
}
