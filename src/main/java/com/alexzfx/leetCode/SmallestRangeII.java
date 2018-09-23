package com.alexzfx.leetCode;

import java.util.Arrays;

/**
 * Author : Alex
 * Date : 2018/9/23 9:42
 * Description : 910. 最小差值 II
 * TODO 未完全理解
 */
public class SmallestRangeII {

    public static void main(String[] args) {
        SmallestRangeII smallestRangeII = new SmallestRangeII();
        System.out.println(smallestRangeII.smallestRangeII(new int[]{1, 3, 6}, 3));
    }

    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int min = A[0], len = A.length, max = A[len - 1], res = max - min;
        max -= K;
        min += K;
        for (int i = 0; i + 1 < len; i++) {
            //当前值 +k 和 最大值 -k 取大，最小值+k 和 当前值的下一个 -k 比较
            res = Math.min(res, Math.max(max, A[i] + K) - Math.min(min, A[i + 1] - K));
        }
        return res;
    }
}
