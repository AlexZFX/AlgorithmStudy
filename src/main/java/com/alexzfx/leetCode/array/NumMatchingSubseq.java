package com.alexzfx.leetCode.array;

import java.util.HashMap;

/**
 * Author : Alex
 * Date : 2018/9/27 13:42
 * Description : 792. 匹配子序列的单词数
 */
public class NumMatchingSubseq {
    public int numMatchingSubseq(String S, String[] words) {
        int res = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                ++res;
            } else {
                if (isSubsequence(word, S)) {
                    map.put(word, 1);
                    ++res;
                }
            }
        }
        return res;
    }

    private boolean isSubsequence(String s, String t) {
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
