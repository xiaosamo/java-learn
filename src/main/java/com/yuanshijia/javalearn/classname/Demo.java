package com.yuanshijia.javalearn.classname;

/**
 * @author yuan
 * @date 2019/10/1
 * @description
 */
public class Demo {

    public static void main(String[] args) throws ClassNotFoundException {


        Student st = new Student();
        // 第一种
        Class<? extends Student> aClass = st.getClass();
        System.out.println(aClass.getName());

        // 第二种
        Class<?> student = Class.forName("com.yuanshijia.javalearn.classname.Demo$Student");
        System.out.println(student.getName());

        // 第三种
        Class<Student> clzz = Student.class;
        System.out.println(clzz.getName());

    }

    static class Student{
        private String name;
    }
}
