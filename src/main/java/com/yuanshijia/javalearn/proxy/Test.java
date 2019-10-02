package com.yuanshijia.javalearn.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author yuan
 * @date 2019/10/2
 * @description
 */
public class Test {
    public static void main(String[] args) {
        UserProxy proxy = new UserProxy();
        UserService userService = (UserService) proxy.bind(new UserServiceImpl());

        userService.add();

        userService.delete();
    }
}
// 代理类需要实现InvocationHandler接口
class UserProxy implements InvocationHandler{

    private Object target;     // 目标对象

    public Object bind(Object target) {
        this.target = target;
        /**
         * 使用Proxy创建代理对象，参数：
         * 1.类加载器，null表示默认的加载器
         * 2.Class对象数组，每个元素都是需要实现的接口
         * 3.调用处理器
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("操作前，记录一下...");
        long start = System.currentTimeMillis();
        Object result = method.invoke(target, args);
        System.out.println("操作完成，执行时间：" + (System.currentTimeMillis() - start) + "ms");
        return result;
    }
}
