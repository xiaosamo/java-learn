package com.yuanshijia.javalearn.initblock;

/**
 * @author yuan
 * @date 2019/10/1
 * @description
 */
public class A {
    public A(){
        System.out.println("构造器调用");
    }

    {
        System.out.println("初始化块");
    }

    static {
        System.out.println("静态代码");
    }

    public static void main(String[] args) {
        new A();
        new A();

    }
}
