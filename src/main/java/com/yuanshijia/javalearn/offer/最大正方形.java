package com.yuanshijia.javalearn.offer;

/**
 * @author yuanshijia
 * @date 2019-08-01
 * @description
 */
public class 最大正方形 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = matrix[i][j] - '0';
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 1; k < Math.min(m, n); k++) {
                    int t = j - k;
                    if (t> 0) {
//                        dp[i][j] = dp[i-t][j-t] +
                    }
                }
                dp[i][j] = matrix[i][j] - '0';
            }
        }
        return 0;

    }

    public static void main(String[] args) {

    }
}
