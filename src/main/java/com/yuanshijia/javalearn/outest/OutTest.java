package com.yuanshijia.javalearn.outest;

/**
 * @author yuanshijia
 * @date 2019-07-24
 * @description
 */
public class OutTest {
    public static void main(String[] args) {
        outer:
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i + j == 7) {
                    System.out.println("break: out, i=" + i + ", j=" + j);
                    break outer;
                }
                System.out.println("i=" + i + ", j=" + j);
            }
            System.out.println();
        }
    }
}
