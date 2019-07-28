package com.yuanshijia.javalearn.offer;

/**
 * @author yuanshijia
 * @date 2019-07-26
 * @description
 */
public class 岛屿的最大面积 {

    int[][] dx = {
            {0, 1},
            {0, -1},
            {-1, 0},
            {1, 0}
    };
    int m, n;
    public int maxAreaOfIsland(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        int maxSize = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    maxSize = Math.max(dfs(grid, i, j), maxSize);

                }
            }
        }
        return maxSize;

    }

    private int dfs(int[][] g, int x, int y) {
        int sum = 1;
        g[x][y] = -1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i][0];
            int ny = y + dx[i][1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && g[nx][ny] == 1) {
                sum += dfs(g, nx, ny);
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        int[][] a = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };

        岛屿的最大面积 obj = new 岛屿的最大面积();
        System.out.println(obj.maxAreaOfIsland(a));
    }
}
