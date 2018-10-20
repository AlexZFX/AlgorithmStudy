package com.alexzfx.leetCode.struct;

import static com.alexzfx.leetCode.struct.SortHelper.swap;

/**
 * Author : Alex
 * Date : 2018/10/20 9:15
 * Description :
 */
public class HeapSort {
    public static void heapSort(int[] nums) {
        int len = nums.length;
        for (int i = (len - 1) / 2; i >= 0; i--) {
            shiftDown(nums, len - 1, i);
        }
        for (int i = len - 1; i > 0; i--) {
            swap(nums, 0, i);
            shiftDown(nums, i - 1, 0);
        }
    }

    /**
     * @param nums
     * @param n    待排序的数组末 index
     * @param k    需要shiftdown的位置
     */
    private static void shiftDown(int[] nums, int n, int k) {
        while (2 * k + 1 <= n) {
            int j = 2 * k + 1;
            if (j + 1 <= n && nums[j + 1] > nums[j]) {
                ++j;
            }
            if (nums[k] >= nums[j]) {
                break;
            }
            swap(nums, k, j);
            k = j;
        }
    }
}
