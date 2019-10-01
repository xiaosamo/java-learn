package com.yuanshijia.javalearn.classname;

/**
 * @author yuan
 * @date 2019/10/1
 * @description
 */
public class Student {
    private String name;

    public Student(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    private void make(){
        this.name = "小明";
    }
}


