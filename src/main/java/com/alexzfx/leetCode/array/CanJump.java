package com.alexzfx.leetCode.array;

/**
 * Author : Alex
 * Date : 2018/9/29 11:14
 * Description : 55. 跳跃游戏
 * 贪心
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int max = nums[0], len = nums.length;
        for (int i = 1; i < len; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
            if (max >= len - 1) {
                return true;
            }
        }
        return true;
    }
}
