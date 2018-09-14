package com.alexzfx.leetCode.array;

/**
 * Author : Alex
 * Date : 2018/9/14 19:44
 * Description : 283. 移动零
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for (int i = index; i < len; i++) {
            nums[i] = 0;
        }
    }
}
