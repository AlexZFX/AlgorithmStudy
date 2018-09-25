package com.alexzfx.leetCode.dp;

/**
 * Author : Alex
 * Date : 2018/9/24 10:56
 * Description : 312. 戳气球
 */
public class MaxCoins {

    public static void main(String[] args) {
        MaxCoins maxCoins = new MaxCoins();
        System.out.println(maxCoins.maxCoins(new int[]{3, 1, 5, 8}));
    }

    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] array = new int[len + 2];
        array[0] = 1;
        array[len + 1] = 1;
        System.arraycopy(nums, 0, array, 1, len);
        len += 2;
        //dp[i][j] 表示i j之间的气球的maxCoin
        int[][] dp = new int[len][len];
        //设第k个元素是最后被删除的元素,则dp[i][j] = Math.max(dp[i][j],array[i]*)
        for (int k = 2; k < len; k++) {
            for (int l = 0; l + k < len; l++) {
                int r = l + k;
                for (int m = l + 1; m < r; m++) {
                    dp[l][r] = Math.max(dp[l][r], array[l] * array[m] * array[r] + dp[l][m] + dp[m][r]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
