package com.alexzfx.leetCode.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Author : Alex
 * Date : 2018/9/24 9:35
 * Description : 646. 最长数对链
 */
public class FindLongestChain {

    public static void main(String[] args) {
        int[][] pairs = new int[][]{{9, 10}, {9, 10}, {4, 5}, {-9, -3}, {-9, 1}, {0, 3}, {6, 10}, {-5, -4}, {-7, -6}};
        FindLongestChain findLongestChain = new FindLongestChain();
        System.out.println(findLongestChain.findLongestChain(pairs));
    }

    public int findLongestChain(int[][] pairs) {
        int len = pairs.length, max = 1, end;
        //dp存储到pairs位置能存储的最大数对链长度
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
        end = pairs[0][1];
        for (int i = 1; i < len; i++) {
            if (pairs[i][0] > end) {
                ++max;
                end = pairs[i][1];
            }
        }
        return max;
//        //实际不需要2次循环，一次即可
//        int[] dp = new int[len];
//        dp[0] = 1;
//        for (int i = 1; i < len; i++) {
//            for (int j = i - 1; j >= 0; j--) {
//                if (pairs[i][0] > pairs[j][1]) {
//                    if (dp[j] >= dp[i]) {
//                        dp[i] = dp[j] + 1;
//                    }
//                }
//            }
//            if (dp[i] == 0) {
//                dp[i] = 1;
//            }
//            max = Math.max(max, dp[i]);
//        }
//        return max;
    }
}
