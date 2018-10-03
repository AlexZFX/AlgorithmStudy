package com.alexzfx.leetCode.dbfsgraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Alex
 * Date : 2018/9/18 13:24
 * Description : 131. 分割回文串
 * <p>
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回 s 所有可能的分割方案。
 */
public class Partition {

    //dp[i][j]用来保存 i~j 之间是否为回文串
    private boolean[][] dp;
    private char[] chars;
    private int len;

    public static void main(String[] args) {
        Partition partition = new Partition();
        System.out.println(partition.partition("aaab"));
    }

    public List<List<String>> partition(String s) {
        chars = s.toCharArray();
        len = chars.length;
        dp = new boolean[len][len];
        for (int i = 0; i < chars.length; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = isPalindrome(i, j);
            }
        }

        List<List<String>> res = new ArrayList<>();
        dfs(0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int start, List<String> tempList, List<List<String>> res) {
        if (start >= len) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < len; i++) {
            if (dp[start][i]) {
                String s = new String(chars, start, i - start + 1);
                tempList.add(s);
                dfs(i + 1, tempList, res);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    private boolean isPalindrome(int i, int j) {
        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }

}
