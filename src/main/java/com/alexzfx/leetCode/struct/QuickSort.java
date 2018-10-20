package com.alexzfx.leetCode.struct;

import static com.alexzfx.leetCode.struct.SortHelper.swap;

/**
 * Author : Alex
 * Date : 2018/10/19 19:22
 * Description :
 */
public class QuickSort {

    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = partition(nums, l, r);
        quickSort(nums, l, mid - 1);
        quickSort(nums, mid + 1, r);
    }

    private static int partition(int[] nums, int l, int r) {
        if (l >= r) {
            return l;
        }
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && nums[i] < nums[l]) {
                ++i;
            }
            while (j >= l + 1 && nums[j] > nums[l]) {
                --j;
            }
            if (i > j) {
                break;
            }
            swap(nums, i, j);
            ++i;
            --j;
        }
        swap(nums, l, j);
        return j;
    }

}
