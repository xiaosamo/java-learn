package com.yuanshijia.javalearn.dubbospi;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.yuanshijia.javalearn.javaspi.Robot;

/**
 * 源码分析
 * http://dubbo.apache.org/zh-cn/docs/source_code_guide/dubbo-spi.html
 */
public class DubboSPITest {

    /**
     * 与 Java SPI 实现类配置不同，Dubbo SPI 是通过键值对的方式进行配置，这样我们可以按需加载指定的实现类。
     * 另外，在测试 Dubbo SPI 时，需要在 Robot 接口上标注 @SPI 注解
     * @param args
     */
    public static void main(String[] args) {
        ExtensionLoader<Robot> extensionLoader =
                ExtensionLoader.getExtensionLoader(Robot.class);
        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.sayHello();
        Robot bumblebee = extensionLoader.getExtension("bumblebee");
        bumblebee.sayHello();
    }
}