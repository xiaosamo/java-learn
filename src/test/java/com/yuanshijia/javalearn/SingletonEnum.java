package com.yuanshijia.javalearn;

/**
 * @author yuanshijia
 * @date 2019-07-12
 * @description
 */
public enum SingletonEnum {
    INSTANCE;


    private String objName;

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public static void main(String[] args) {
        SingletonEnum firstSingleton = SingletonEnum.INSTANCE;
        firstSingleton.setObjName("firstName");
        System.out.println(firstSingleton.getObjName());


        SingletonEnum secondSingleton = SingletonEnum.INSTANCE;
        secondSingleton.setObjName("secondName");

        System.out.println(firstSingleton.getObjName());
        System.out.println(secondSingleton.getObjName());

        // 反射获取实例测试
        SingletonEnum[] enumConstants = SingletonEnum.class.getEnumConstants();
        for (SingletonEnum singletonEnum : enumConstants) {
            System.out.println(singletonEnum.getObjName());
        }

    }
}
