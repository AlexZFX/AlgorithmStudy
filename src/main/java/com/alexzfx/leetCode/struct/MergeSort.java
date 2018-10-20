package com.alexzfx.leetCode.struct;

/**
 * Author : Alex
 * Date : 2018/10/20 9:46
 * Description :
 */
public class MergeSort {

    public static void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private static void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        if (nums[mid] >= nums[mid + 1]) {
            merge(nums, l, mid, r);
        }
    }

    private static void merge(int[] nums, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        System.arraycopy(nums, l, temp, 0, r - l + 1);
        int loff = l, roff = mid + 1;
        for (int i = l; i <= r; i++) {
            if (loff > mid) {
                nums[i] = temp[roff - l];
                ++roff;
            } else if (roff > r) {
                nums[i] = temp[loff - l];
                ++loff;
            } else if (temp[loff - l] > temp[roff - l]) {
                nums[i] = temp[roff - l];
                ++roff;
            } else {
                nums[i] = temp[loff - l];
                ++loff;
            }
        }
    }

}
