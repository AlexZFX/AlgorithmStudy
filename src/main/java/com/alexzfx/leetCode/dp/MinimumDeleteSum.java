package com.alexzfx.leetCode.dp;

/**
 * Author : Alex
 * Date : 2018/9/21 12:04
 * Description : 712. 两个字符串的最小ASCII删除和
 * <p>
 * 给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和
 */
public class MinimumDeleteSum {

    public static void main(String[] args) {
        MinimumDeleteSum minimumDeleteSum = new MinimumDeleteSum();
        System.out.println(minimumDeleteSum.minimumDeleteSum("delete", "leet"));
    }

    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        // dp[i][j]表示 s1前i位和s2前j位删除事相等的最小ascii码值
        int[][] dp = new int[len1 + 1][len2 + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = dp[i - 1][0] + chars1[i - 1];
        }
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = dp[0][j - 1] + chars2[j - 1];
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1] + chars2[j - 1], dp[i - 1][j] + chars1[i - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
