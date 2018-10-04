package com.alexzfx.leetCode.dp;

/**
 * Author : Alex
 * Date : 2018/10/4 12:45
 * Description : 213. 打家劫舍 II
 */
public class Rob2 {

    public static void main(String[] args) {
        Rob2 rob2 = new Rob2();
        System.out.println(rob2.rob(new int[]{4, 1, 2, 7, 5, 3, 1}));
    }

    public int rob(int[] nums) {
        int len = nums.length, max = 0;
        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return nums[0];
        } else if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        //从第一位出发
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        max = dp[len - 2];
        dp[1] = nums[1];
        dp[2] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return Math.max(max, dp[len - 1]);
    }
}
