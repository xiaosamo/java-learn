package com.yuanshijia.javalearn.offer;

/**
 * @author yuanshijia
 * @date 2019-07-26
 * @description
 */
public class 数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        // 找第k大的元素相当于找第len - k + 1小的元素
        k = nums.length - k + 1;
        int l = 0, r = nums.length - 1;
        int index = partition(nums, l, r);
        // 求第k小的数
        while (index != k - 1) {
            if (index > k - 1) {
                r = index - 1;
            } else {
                l = index + 1;
            }
            index = partition(nums, l, r);
        }
        return nums[index];
    }

    private int partition(int[] nums, int left, int right) {
        int base = nums[left];
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] >= base) {
                --j;
            }
            while (i < j && nums[i] <= base) {
                ++i;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, left, i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


    public static void main(String[] args) {
        数组中的第K个最大元素 obj = new 数组中的第K个最大元素();
        System.out.println(obj.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        
        System.out.println(obj.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
    
}
