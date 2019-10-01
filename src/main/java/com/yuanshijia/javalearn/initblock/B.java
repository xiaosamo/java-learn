package com.yuanshijia.javalearn.initblock;

/**
 * @author yuan
 * @date 2019/10/1
 * @description
 */
public class B {
    private Object data;

    private static int staticData;

    public B(Object data) {
        this.data = data;
    }

    {
        System.out.println("初始化块，data=" + data);
    }

    static {
        System.out.println("初始化块，staticData=" + staticData);

    }

    public static void main(String[] args) {
        B b = new B(new Object());
    }
}
