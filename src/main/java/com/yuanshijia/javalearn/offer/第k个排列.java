package com.yuanshijia.javalearn.offer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author yuanshijia
 * @date 2019-07-26
 * @description
 */
public class 第k个排列 {

    ArrayList<String> list;
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        list = new ArrayList<>();
        dfs(nums, 0);
        Collections.sort(list);
        return list.get(k - 1);
    }

    private void dfs(int[] nums, int index) {
        if (index == nums.length) {
            String s = "";
            for (int i : nums) {
                s += (i + "");
            }
            list.add(s);
//            System.out.println(Arrays.toString(nums));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            dfs(nums, index + 1);
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        第k个排列 obj = new 第k个排列();
//        System.out.println(obj.getPermutation(3, 3));
//        System.out.println(obj.getPermutation(4, 9));
        System.out.println(obj.getPermutation(3,5));

    }
}
