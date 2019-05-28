package com.yuanshijia.javalearn.identityHashCode;

/**
 * @author yuan
 * @date 2019/5/28
 * @description
 */
public class Test {
    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";

        String c = new String("aaa");
        String d = new String("aaa");

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));

        System.out.println();

        System.out.println(c.hashCode());
        System.out.println(d.hashCode());

        System.out.println(System.identityHashCode(c));
        System.out.println(System.identityHashCode(d));

    }
}
