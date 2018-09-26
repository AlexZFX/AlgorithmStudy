package com.alexzfx.leetCode.array;

/**
 * Author : Alex
 * Date : 2018/9/25 21:12
 * Description : 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int l = 0, r = len - 1, lr = -1, rr = -1;
        int mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] == target) {
                lr = mid;
                rr = mid;
                while (lr > 0 && nums[lr - 1] == nums[mid]) {
                    --lr;
                }
                while (rr < len - 1 && nums[rr + 1] == nums[mid]) {
                    ++rr;
                }
                break;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return new int[]{lr, rr};
    }
}
