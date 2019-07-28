package com.yuanshijia.javalearn.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuan
 * @date 2019/7/27
 * @description
 * BFS
 */
public class 朋友圈_并查集 {

    public int findCircleNum(int[][] M) {
        int m = M.length;
        int[] pre = new int[m];
        for (int i = 0; i < m; i++) {
            //先各自为组，组名也为自己的序号
            pre[i] = i;
        }

        //一开始有多少人就有多少个朋友圈，当每出现一对朋友时就减1，最后就是总的朋友圈数量了
        int count = m;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i != j && M[i][j] == 1) {
                    int x1 = find(i, pre);
                    int x2 = find(j, pre);
                    if (x1 != x2) {
                        //如果不属于同个朋友圈的话就把i归为j的组
                        pre[x1] = x2;
                        count--;
                    }
                }
            }
        }

        System.out.println();
        return count;
    }

    private int find(int x, int[] pre) {
        return pre[x] == x ? x : find(pre[x], pre);
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}
        };
        朋友圈_并查集 obj = new 朋友圈_并查集();
        System.out.println(obj.findCircleNum(a));


    }


}
