package com.alexzfx.leetCode.dp;

/**
 * Author : Alex
 * Date : 2018/9/22 11:38
 * Description : 279. 完全平方数
 * <p>
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 */
public class NumSquares {

    public static void main(String[] args) {
        NumSquares numSquares = new NumSquares();
        System.out.println(numSquares.numSquares(13));
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int temp = Integer.MAX_VALUE;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= Math.sqrt(i); j++) {
                temp = Math.min(temp, dp[i - j * j] + 1);
            }
            dp[i] = temp;
            temp = Integer.MAX_VALUE;
        }
        return dp[n];
    }
}
