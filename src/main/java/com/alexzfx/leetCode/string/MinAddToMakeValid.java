package com.alexzfx.leetCode.string;

/**
 * Author : Alex
 * Date : 2018/10/14 9:36
 * Description : 921. 使括号有效的最少添加
 */
public class MinAddToMakeValid {
    public int minAddToMakeValid(String S) {
        char[] chars = S.toCharArray();
        int l = 0, r = 0;
        for (char aChar : chars) {
            if (aChar == '(') {
                ++l;
            } else {
                if (l > 0) {
                    --l;
                } else {
                    ++r;
                }
            }
        }
        return l + r;
    }
}
