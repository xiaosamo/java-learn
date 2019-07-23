package com.yuanshijia.javalearn.offer;

import java.util.ArrayList;

/**
 * @author yuanshijia
 * @date 2019-07-23
 * @description
 */
public class 顺时针打印矩阵 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();

        int r1 = 0, r2 = matrix.length - 1, c1 = 0, c2 = matrix[0].length - 1;
        if (c1 == c2) {
            // 只有一列
            for (int i = r1; i <= r2; i++) {
                result.add(matrix[i][0]);
            }
            return result;
        }
        if (r1 == r2) {
            // 只有一行
            for (int i = c1; i <= c2; i++) {
                result.add(matrix[0][i]);
            }
            return result;
        }
        while (r1 <= r2 && c1 <= c2) {
            // 右
            for (int i = c1; i <= c2; i++) {
                result.add(matrix[r1][i]);
            }
            ++r1;
            if (r1 > r2) {
                break;
            }
            // 下
            for (int i = r1; i <= r2; i++) {
                result.add(matrix[i][c2]);
            }
            --c2;
            if (c1 > c2) {
                break;
            }
            // 左
            for (int i = c2; i >= c1; i--) {
                result.add(matrix[r2][i]);
            }
            --r2;
            if (r1 > r2) {
                break;
            }
            // 上
            for (int i = r2; i >= r1; i--) {
                result.add(matrix[i][c1]);
            }
            ++c1;
            if (c1 > c2) {
                break;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int sum = 1;
        int[][] matrix = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = sum++;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        int[][] matrix2 = {
                {1},
                {2},
                {3},
                {4},
                {5}
        };
        int[][] m = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};


//        ArrayList<Integer> list = new 顺时针打印矩阵().printMatrix(matrix);
        ArrayList<Integer> list = new 顺时针打印矩阵().printMatrix(m);
        list.forEach(i -> System.out.print(i + " "));


    }
}
