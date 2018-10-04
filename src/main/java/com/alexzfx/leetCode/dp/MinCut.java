package com.alexzfx.leetCode.dp;

import java.util.Arrays;

/**
 * Author : Alex
 * Date : 2018/10/3 13:54
 * Description : 132. 分割回文串 II
 */
public class MinCut {

    public static void main(String[] args) {
        MinCut minCut = new MinCut();
        System.out.println(minCut.minCut("aab"));
    }

    public int minCut(String s) {
        int len = s.length();
        if (len < 2) {
            return 0;
        }
        int[] res = new int[len];
        Arrays.fill(res, len - 1);
        char[] chars = s.toCharArray();
        // 从 i 开始向后扩展
        for (int i = 0; i < len; i++) {
            minHelper(chars, i, i, res);
            minHelper(chars, i, i + 1, res);
        }
        return res[len - 1];
    }

    private void minHelper(char[] chars, int l, int r, int[] res) {
        // 以l为中间，找到当前位置有的最大回文起始位置 l，则直到 r位置 ，res[r] = 下方公式。
        while (l >= 0 && r < chars.length && chars[l] == chars[r]) {
            res[r] = Math.min(res[r], (l - 1 >= 0 ? res[l - 1] : -1) + 1);
            --l;
            ++r;
        }
    }


//    //时间差点爆，辣鸡 O(n3)
//    public int minCut(String s) {
//        int len = s.length();
//        if (len == 0) {
//            return 0;
//        }
//        // dp[i]j[] 表示 ij之间是否为回文串
//        boolean[][] dp = new boolean[len][len];
//        //存储i-j之间的最小分隔次数
//        int[][] res = new int[len][len];
//        dp[0][0] = true;
//        for (int i = 1; i < len; i++) {
//            dp[i][i] = true;
//            res[i][i] = 0;
//            if (s.charAt(i) == s.charAt(i - 1)) {
//                dp[i - 1][i] = true;
//                res[i - 1][i] = 0;
//            } else {
//                res[i - 1][i] = 1;
//            }
//        }
//        for (int i = 2; i < len; i++) {
//            for (int j = 0; j < len - i; j++) {
//                dp[j][j + i] = dp[j + 1][j + i - 1] && s.charAt(j) == s.charAt(j + i);
//                res[j][j + i] = Integer.MAX_VALUE;
//                if (dp[j][j + i]) {
//                    res[j][j + i] = 0;
//                } else {
//                    for (int k = 0; k < i; k++) {
//                        res[j][j + i] = Math.min(res[j][j + i], res[j][j + k] + res[j + k + 1][j + i] + 1);
//                        if (res[j][j + i] == 1) {
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//        return res[0][len - 1];
//    }
}
