package com.yuanshijia.javalearn.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * @author yuan
 * @date 2019/10/2
 * @description
 * 使用代理对象对二分查找进行跟踪
 */
public class ProxyTest {
    public static void main(String[] args) {
        Object[] elements = new Object[100];
        for (int i = 0; i < elements.length; i++) {
            Integer val = i + 1;
            InvocationHandler handler = new TraceHandler(val);
            /**
             * 使用Proxy创建代理对象，参数：
             * 1.类加载器，null表示默认的加载器
             * 2.Class对象数组，每个元素都是需要实现的接口
             * 3.调用处理器
             */
            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
            elements[i] = proxy;
        }

        Integer key = new Random().nextInt(elements.length) + 1;

        int result = Arrays.binarySearch(elements, key);
        if (result >= 0) {
            System.out.println(elements[result]);
        }
    }
}

class TraceHandler implements InvocationHandler{

    private Object target;

    public TraceHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print(target);
        System.out.print("." + method.getName() + "(");
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length - 1) {
                    System.out.print(",");
                }
            }
        }
        System.out.println(")");
        return method.invoke(target, args);
    }
}
