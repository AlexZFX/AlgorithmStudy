package com.alexzfx.leetCode.dp;

/**
 * Author : Alex
 * Date : 2018/9/27 10:16
 * Description : 115. 不同的子序列
 */
public class NumDistinct {

    public static void main(String[] args) {
        NumDistinct numDistinct = new NumDistinct();
        System.out.println(numDistinct.numDistinct("rabbbit", "rabbit"));
    }

    public int numDistinct(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        //dp[i][j]表示到s的i处和t的j处包含方案数
        int[][] dp = new int[len1 + 1][len2 + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2 && j <= i; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len1][len2];
    }


//    // dfs tle
//    public int numDistinct(String s, String t) {
//        return dfs(s, t, 0, 0);
//    }
//
//    private int dfs(String s, String t, int sp, int tp) {
//        if (tp >= t.length()) {
//            return 1;
//        }
//        int res = 0;
//        for (int i = sp; i < s.length(); i++) {
//            if (s.charAt(i) == t.charAt(tp)) {
//                res += dfs(s, t, i + 1, tp + 1);
//            }
//        }
//        return res;
//    }
}
