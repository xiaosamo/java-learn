package com.yuanshijia.javalearn;

/**
 * @author yuanshijia
 * @date 2019-07-12
 * @description
 */
public class Singleton {
    private Singleton(){
        System.out.println("init");
    }

    {
        System.out.println("内部{}执行");
    }

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance(){
        System.out.println("getinstance...");
        return SingletonHolder.INSTANCE;
    }


    public static void main(String[] args) {
        Singleton.getInstance();

    }
}
