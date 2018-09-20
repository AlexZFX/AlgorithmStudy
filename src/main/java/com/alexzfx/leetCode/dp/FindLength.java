package com.alexzfx.leetCode.dp;

/**
 * Author : Alex
 * Date : 2018/9/20 11:14
 * Description : 718. 最长重复子数组
 * <p>
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 */
public class FindLength {

    public static void main(String[] args) {
        FindLength findLength = new FindLength();
        int[] A = new int[]{0, 1, 1, 1, 1};
        int[] B = new int[]{1, 0, 1, 0, 1};
        System.out.println(findLength.findLength(A, B));
    }

    public int findLength(int[] A, int[] B) {
        int Alen = A.length, Blen = B.length;
        // dp[i][j] 表示直到A[i] B[j] 公共数组长度最长的连续子数组的长度
        // 只有连续的才算，不连续的直接抛弃，保留最大的长度
        int[][] dp = new int[Alen + 1][Blen + 1];
        int max = 0;
        for (int i = 1; i <= Alen; i++) {
            for (int j = 1; j <= Blen; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                max = max > dp[i][j] ? max : dp[i][j];
            }
        }
        return max;
    }

//    //这个能求出不要求连续的最长公共子序列
//    public int findLength(int[] A, int[] B) {
//        int Alen = A.length, Blen = B.length;
//        // dp[i][j] 表示直到A[i] B[j] 公共数组长度最长的子数组的长度
//        int[][] dp = new int[Alen + 1][Blen + 1];
//        for (int i = 1; i <= Alen; i++) {
//            for (int j = 1; j <= Blen; j++) {
//                if (A[i - 1] == B[j - 1]) {
//                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                } else {
//                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
//                }
//            }
//        }
//        return dp[Alen][Blen];
//    }

}
