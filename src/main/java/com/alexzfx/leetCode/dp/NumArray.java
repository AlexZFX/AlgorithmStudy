package com.alexzfx.leetCode.dp;

/**
 * Author : Alex
 * Date : 2018/8/30 20:38
 * Description : 303. 区域和检索 - 数组不可变
 * <p>
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 * <p>
 * a[i,j] = sum[0-j] - sum[0-(i-1)];
 */
public class NumArray {

    private int[] nums;

    public NumArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return nums[j];
        }
        return nums[j] - nums[i - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
    }

}
