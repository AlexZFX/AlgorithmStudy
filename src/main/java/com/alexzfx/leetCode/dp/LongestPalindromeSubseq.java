package com.alexzfx.leetCode.dp;

/**
 * Author : Alex
 * Date : 2018/9/20 14:00
 * Description : 516. 最长回文子序列
 * <p>
 * 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
 * bbbab 返回 4 为 bbbb
 */
public class LongestPalindromeSubseq {

    public static void main(String[] args) {
        LongestPalindromeSubseq longestPalindromeSubseq = new LongestPalindromeSubseq();
        System.out.println(longestPalindromeSubseq.longestPalindromeSubseq("cbbd"));
    }

    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                //如果两数相等，则只和其中间的dp值有关
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    //不相等则根据内移一位的数据调整，取最大值。
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
