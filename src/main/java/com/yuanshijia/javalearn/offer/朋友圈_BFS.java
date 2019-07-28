package com.yuanshijia.javalearn.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuan
 * @date 2019/7/27
 * @description
 * BFS
 */
public class 朋友圈_BFS {

    public int findCircleNum(int[][] M) {
        int m = M.length;
        int sum = 0;
        boolean[] vis = new boolean[m];

        for (int i = 0; i < m; i++) {
            if (!vis[i]) {
                // 找出当前好友i的朋友圈
                bfs(M, vis, i);
                ++sum;
            }
        }
        return sum;
    }

    private void bfs(int[][] M, boolean[] vis, int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        vis[i] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int j = 0; j < M.length; j++) {
                if (!vis[j] && M[node][j] == 1) {
                    queue.offer(j);
                    vis[j] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}
        };
        朋友圈_BFS obj = new 朋友圈_BFS();
        System.out.println(obj.findCircleNum(a));


    }


}
