package com.yuanshijia.javalearn.proxy;

/**
 * @author yuan
 * @date 2019/10/2
 * @description
 * 静态代理
 */
public class UserStaticProxy implements UserService{

    @Override
    public void add() {
        System.out.println("操作前，记录一下...");
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(1000);
            System.out.println("添加了一个用户");
            System.out.println("操作完成，执行时间：" + (System.currentTimeMillis() - start) + "ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        System.out.println("操作前，记录一下...");
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(2000);
            System.out.println("删除了一个用户");
            System.out.println("操作完成，执行时间：" + (System.currentTimeMillis() - start) + "ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
