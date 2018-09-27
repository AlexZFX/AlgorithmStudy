package com.alexzfx.leetCode.dp;

/**
 * Author : Alex
 * Date : 2018/9/27 13:27
 * Description : 392. 判断子序列
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                ++i;
                ++j;
            } else {
                ++j;
            }
        }
        return i == s.length();
    }
}
