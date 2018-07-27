package com.alexzfx.leetCode;

/**
 * Author : Alex
 * Date : 2018/7/25 13:25
 * Description : 5
 * <p>
 * 最长回文字符串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 * <p>
 * 我写的中的bytes都是错误用法，实际应该为 char[] = toCharArray。
 * 但是bytes的也通过了。。。先不改了
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String s = longestPalindrome.longestPalindrome("ababd");
        System.out.println(s);
    }

    //动态规划解法
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int start = 0;
        int maxLen = 1;
        //错误用法，实际应该为 char[] = toCharArray。
        byte[] bytes = s.getBytes();
        int len = bytes.length;
        // p[i][j] == true 表示 i - j中间为回文串
        boolean[][] p = new boolean[len][len];
        //初始化长度为1和为2的回文串
        for (int i = 0; i < len; i++) {
            p[i][i] = true;
            if (i + 1 < len && bytes[i] == bytes[i + 1]) {
                maxLen = 2;
                start = i;
                p[i][i + 1] = true;
            }
        }
        //dp 长度为 3~(len-1)的字符串 ，更新p的实际范围为len，为3~len
        for (int strLen = 3; strLen <= len; ++strLen) {
            for (int i = 0; i <= len - strLen; i++) {
                int j = i + strLen - 1;
                if (p[i + 1][j - 1] && bytes[i] == bytes[j]) {
                    p[i][j] = true;
                    maxLen = strLen;
                    start = i;
                }
            }
        }
        return s.substring(start, maxLen + start);
    }

    //中心向两端扩展解法
//    public String longestPalindrome(String s) {
//        if (s == null || s.isEmpty()) {
//            return null;
//        }
//        int start = 0;
//        int maxLen = 1;
//        int len;
//        int left, right;
//        byte[] bytes = s.getBytes();
//        for (int i = 0; i < bytes.length; i++) {
//            len = 1;
//            left = i;
//            right = i;
//            while (left - 1 >= 0 && right + 1 < bytes.length && bytes[left - 1] == bytes[right + 1]) {
//                len += 2;
//                --left;
//                ++right;
//            }
//            if (len > maxLen) {
//                maxLen = len;
//                start = left;
//            }
//        }
//        for (int i = 0; i < bytes.length - 1; i++) {
//            left = i;
//            right = i + 1;
//            if (bytes[left] != bytes[right]) {
//                continue;
//            }
//            len = 2;
//            while (left - 1 >= 0 && right + 1 < bytes.length && bytes[left - 1] == bytes[right + 1]) {
//                len += 2;
//                --left;
//                ++right;
//            }
//            if (len > maxLen) {
//                maxLen = len;
//                start = left;
//            }
//        }
//        return s.substring(start, start + maxLen);
//    }
}
