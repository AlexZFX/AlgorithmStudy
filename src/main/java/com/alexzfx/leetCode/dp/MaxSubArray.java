package com.alexzfx.leetCode.dp;

/**
 * Author : Alex
 * Date : 2018/7/29 18:59
 * Description : 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），
 * 返回其最大和。
 */
public class MaxSubArray {

    //动态规划解法
    public int maxSubArray(int[] nums) {
        int[] f = new int[nums.length];
        int max = Integer.MIN_VALUE;
        f[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            f[i] = Math.max(nums[i], nums[i] + f[i - 1]);
        }
        for (int i : f) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

//    //分治解法
//    public int maxSubArray(int[] nums) {
//        return maxSubArray(nums, 0, nums.length - 1);
//    }
//
//    private int maxSubArray(int[] nums, int left, int right) {
//        if (left == right) {
//            return nums[left];
//        }
//        int mid = (left + right) / 2;
//        int leftSum = maxSubArray(nums, left, mid);
//        int rightSum = maxSubArray(nums, mid + 1, right);
//        int leftBorderSum = 0, maxLeftBorderSum = Integer.MIN_VALUE;//定义左边界子序列的和
//        for (int i = mid; i >= left; i--) {
//            leftBorderSum += nums[i];
//            if (leftBorderSum > maxLeftBorderSum) {
//                maxLeftBorderSum = leftBorderSum;
//            }
//        }
//        int rightBorderSum = 0, maxRightBorderSum = Integer.MIN_VALUE;//定义右边界子序列的和
//        for (int i = mid + 1; i <= right; i++) {
//            rightBorderSum += nums[i];
//            if (rightBorderSum > maxRightBorderSum) {
//                maxRightBorderSum = rightBorderSum;
//            }
//        }
//        int midSum = maxLeftBorderSum + maxRightBorderSum;
//        if (midSum >= leftSum && midSum >= rightSum) {
//            return midSum;
//        }
//        return Math.max(leftSum, rightSum);
//    }
}
