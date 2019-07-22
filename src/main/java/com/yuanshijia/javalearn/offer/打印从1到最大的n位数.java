package com.yuanshijia.javalearn.offer;

import java.util.Arrays;

/**
 * @author yuanshijia
 * @date 2019-07-22
 * @description 使用回溯法得到所有的数
 */
public class 打印从1到最大的n位数 {
    public void print1ToMaxOfNDigits(int n) {
        char[] number = new char[n];
        print1ToMaxOfNDigits(number, 0);
    }

    private void print1ToMaxOfNDigits(char[] number, int index) {
        if (index == number.length) {
            System.out.println(Arrays.toString(number));
            return;
        }

        for (int i = 0; i < 10; i++) {
            number[index] = (char) (i + '0');
            print1ToMaxOfNDigits(number, index + 1);
        }
    }

    public static void main(String[] args) {
        new 打印从1到最大的n位数().print1ToMaxOfNDigits(3);
    }
}
