package com.alexzfx.leetCode.array;

/**
 * Author : Alex
 * Date : 2018/9/29 13:49
 * Description : 80. 删除排序数组中的重复项 II
 */
public class RemoveDuplicates2 {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int index = 0;
        boolean twice = false;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[index] && !twice) {
                nums[++index] = nums[i];
                twice = true;
            } else if (nums[index] != nums[i]) {
                nums[++index] = nums[i];
                twice = false;
            }
        }
        return ++index;
    }
}
