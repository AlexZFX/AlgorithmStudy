package com.alexzfx.leetCode;

/**
 * Author : Alex
 * Date : 2018/9/16 10:19
 * Description : 907. 子数组的最小值之和
 * <p>
 * 给定一个整数数组 A，找到 min(B) 的总和，其中 B 的范围为 A 的每个（连续）子数组。
 * <p>
 * 由于答案可能很大，因此返回答案模 10^9 + 7。
 */
public class SumSubarrayMins {

    public int sumSubarrayMins(int[] A) {
        return (int) sumSubarrayMins(A, 0, A.length - 1);
    }

    public long sumSubarrayMins(int[] A, int l, int r) {
        if (l == r) {
            return A[l];
        } else if (l > r) {
            return 0;
        }
        int off = l;
        short min = Short.MAX_VALUE;
        long res = 0;
        for (int i = l; i <= r; i++) {
            if (A[i] < min) {
                min = (short) A[i];
                off = i;
            }
        }
        res += min * (off - l + 1) * (r - off + 1);
        res += sumSubarrayMins(A, l, off - 1) + sumSubarrayMins(A, off + 1, r);
        res %= 1000000007;
        return res;
    }

    // TLE
//    public int sumSubarrayMins(int[] A) {
//        int len = A.length;
//        //dp[i][j]表示从 i ~ j 这一段中的最小值
////        short[] dp = new short[len];
//        int min, j;
//        long res = 0L;
//        for (int i = 0; i < len; i++) {
//            min = A[i];
//            res += min;
//            j = i + 1;
//            while (j < len) {
//                if (min < A[j]) {
//                    res += min;
//                    ++j;
//                } else {
//                    res += A[j];
//                    min = A[j];
//                    ++j;
//                }
//            }
//            res %= 1000000007;
//        }
//        return (int) res;
//    }
}
