package com.yuanshijia.javalearn.proxy;

/**
 * @author yuan
 * @date 2019/10/2
 * @description
 */
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        try {
            Thread.sleep(1000);
            System.out.println("添加了一个用户");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        try {
            Thread.sleep(2000);
            System.out.println("删除了一个用户");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
