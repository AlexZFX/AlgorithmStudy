package com.alexzfx.leetCode.dp;

/**
 * Author : Alex
 * Date : 2018/10/7 9:48
 * Description : 918. 环形子数组的最大和
 */
public class MaxSubarraySumCircular {

    public static void main(String[] args) {
        MaxSubarraySumCircular maxSubarraySumCircular = new MaxSubarraySumCircular();
        System.out.println(maxSubarraySumCircular.maxSubarraySumCircular(new int[]{-2, -3, -1}));
    }

    public int maxSubarraySumCircular(int[] A) {
        int len = A.length;
        if (len < 1) {
            return 0;
        }
        //如果不经过环，则直接求最大，否则求 （sum - 最小子数组和）
        int tempMax = A[0], max = A[0], sum = A[0], tempMin = A[0], min = A[0], max2;
        for (int i = 1; i < len; i++) {
            sum += A[i];
            //求最大子数组和
            if (tempMax > 0) {
                tempMax += A[i];
            } else {
                tempMax = A[i];
            }
            max = Math.max(tempMax, max);
            //求最小子数组和
            if (tempMin > 0) {
                tempMin = A[i];
            } else {
                tempMin += A[i];
            }
            min = Math.min(tempMin, min);
        }
        max2 = sum - min;
        //说明全部都是负数，要选取其中最大的
        if (min == sum) {
            max2 = Integer.MIN_VALUE;
            for (int aA : A) {
                max2 = Math.max(max, aA);
            }
        }
        return Math.max(max, max2);
    }
}
