package com.alexzfx.leetCode.others;

/**
 * Author : Alex
 * Date : 2018/9/19 17:31
 * Description : 409. 最长回文串
 * <p>
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * <p>
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int[] num = new int['z' - 'A' + 1];
        int res = 0, len = chars.length;
        for (int i = 0; i < len; i++) {
            if (num[chars[i] - 'A'] == 1) {
                num[chars[i] - 'A'] = 0;
                res += 2;
            } else {
                num[chars[i] - 'A'] = 1;
            }
        }
        if (res == len) {
            return res;
        } else {
            return ++res;
        }
    }
}
