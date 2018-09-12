package com.alexzfx.leetCode.array;

/**
 * Author : Alex
 * Date : 2018/9/12 14:55
 * Description : 268. 缺失数字
 * <p>
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        long sum = (len * (len + 1)) >> 1;
        for (int num : nums) {
            sum -= num;
        }
        return (int) sum;
    }
}
