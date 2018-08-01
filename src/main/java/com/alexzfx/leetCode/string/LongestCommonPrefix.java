package com.alexzfx.leetCode.string;

/**
 * Author : Alex
 * Date : 2018/7/31 23:20
 * Description : 14. 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        char c;
        int len0 = strs[0].length();
        for (int i = 0; i < len0; ++i) {
            c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                // i 小于每个str的len，c == str.charAt(i);
                if (!(i < strs[j].length()) || c != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
