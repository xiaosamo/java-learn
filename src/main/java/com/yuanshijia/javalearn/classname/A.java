package com.yuanshijia.javalearn.classname;

/**
 * @author yuan
 * @date 2019/10/2
 * @description
 */
public class A {

    {
        System.out.println("A");

    }

    private class B{
        {
            System.out.println("B");
        }
    }


    static class D {
        public D(){
            System.out.println("new D");
        }
        {
            System.out.println("D");
        }

        static {
            System.out.println("DD");
        }
    }

    public static void main(String[] args) {
        new A();

    }
}
class C{
    {
        System.out.println("C");
    }
}