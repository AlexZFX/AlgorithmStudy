package com.alexzfx.leetCode.dp;

/**
 * Author : Alex
 * Date : 2018/9/21 11:04
 * Description : 647. 回文子串
 * <p>
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 */
public class CountSubstrings {

    public static void main(String[] args) {
        CountSubstrings countSubstrings = new CountSubstrings();
        System.out.println(countSubstrings.countSubstrings("aaa"));
    }

    //dp解法
    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean[][] dp = new boolean[len][len];
        int count = 0;
        //初始化长度为 1 和 2 的回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            ++count;
            if (i + 1 < len && chars[i] == chars[i + 1]) {
                dp[i][i + 1] = true;
                ++count;
            }
        }
        for (int i = len - 3; i >= 0; i--) {
            for (int j = i + 2; j < len; j++) {
                if (dp[i + 1][j - 1] && chars[i] == chars[j]) {
                    dp[i][j] = true;
                    ++count;
                }
            }
        }
        return count;
    }
//    //回文串型题目可以考虑从中间向两边扩展型解法，O(n^2)
//    private int cnt = 0;
//    private void extend(String s ,int start,int end){
//        while(start >= 0&&end < s.length() &&s.charAt(start)==s.charAt(end)){
//            cnt++;
//            start--;
//            end++;
//        }
//    }
//    public int countSubstrings(String s) {
//        for(int i =0;i<s.length();i++){
//            extend(s,i,i+1);
//            extend(s,i,i);
//        }
//        return cnt;
//
//    }
}
