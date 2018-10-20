package com.alexzfx.leetCode.struct;

import static com.alexzfx.leetCode.struct.SortHelper.swap;

/**
 * Author : Alex
 * Date : 2018/10/19 19:59
 * Description :
 */
public class QuickSort2 {

    public static void quickSort2(int[] nums) {
        quickSort2(nums, 0, nums.length - 1);
    }

    private static void quickSort2(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int midNum = nums[l];
        int lt = l, rt = r; // [l-lt] 小于  (lt - i) 等于 [rt-r] 大于
        int i = lt + 1;
        while (i <= rt) {
            if (nums[i] < midNum) {
                swap(nums, lt + 1, i);
                ++lt;
                ++i;
            } else if (nums[i] > midNum) {
                swap(nums, i, rt);
                --rt;
            } else {
                ++i;
            }
        }
        swap(nums, l, lt);

        quickSort2(nums, l, lt - 1);
        quickSort2(nums, rt + 1, r);
    }


}
