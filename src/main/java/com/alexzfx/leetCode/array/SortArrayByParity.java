package com.alexzfx.leetCode.array;

/**
 * Author : Alex
 * Date : 2018/9/16 9:30
 * Description : 905. 按奇偶校验排序数组
 * <p>
 * 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
 * <p>
 * 你可以返回满足此条件的任何数组作为答案。
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int len = A.length;
        int l = 0, r = len - 1;
        while (l < r) {
            while (l < r && A[l] % 2 == 0) {
                ++l;
            }
            while (l < r && A[r] % 2 != 0) {
                --r;
            }
            swap(A, l, r);
            ++l;
            --r;
        }
        return A;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
