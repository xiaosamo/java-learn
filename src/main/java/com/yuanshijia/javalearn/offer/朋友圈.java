package com.yuanshijia.javalearn.offer;

/**
 * @author yuan
 * @date 2019/7/27
 * @description
 * DFS
 * 遍历所有人，对于每一个人，寻找他的好友，找到好友后再找这个好友的好友，这样深度优先遍历下去，设置一个visited记录是否已经遍历了这个人。 因为如果m个人最多m个朋友圈，设置后visited后，相同的朋友圈会检测到visited[i]!=0就会不算数
 */
public class 朋友圈 {

    public int findCircleNum(int[][] M) {
        int m = M.length;
        int sum = 0;
        boolean[] vis = new boolean[m];

        for (int i = 0; i < m; i++) {
            if (!vis[i]) {
                // 找出当前好友i的朋友圈
                dfs(M, vis, i);
                ++sum;
            }
        }
        return sum;
    }

    private void dfs(int[][] M, boolean[] vis, int i) {
        vis[i] = true;
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && !vis[j]) {
                // 继续去选择j的朋友圈
                dfs(M, vis, j);
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}
        };
        朋友圈 obj = new 朋友圈();
        System.out.println(obj.findCircleNum(a));


    }


}
