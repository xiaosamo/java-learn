package com.yuanshijia.javalearn.guavacachetest;

/**
 * @author yuanshijia
 * @date 2019-07-30
 * @description
 */
public class Man {
    //身份证号
    private String id;
    //姓名
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Man{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}