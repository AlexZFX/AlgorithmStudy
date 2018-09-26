package com.alexzfx.leetCode.dp;

/**
 * Author : Alex
 * Date : 2018/7/30 13:48
 * Description :
 * 121. 买卖股票的最佳时机
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 309. 最佳买卖股票时机含冷冻期
 * TODO
 */
public class MaxProfit {
//    //不含冷冻期
//    public int maxProfit(int[] prices) {
//        int len = prices.length;
//        if (len == 0 || len == 1) {
//            return 0;
//        }
//        int min = prices[0];
//        int max = 0;
//        int temp = 0;
//        for (int i = 1; i < len; i++) {
//            if (prices[i] < min) {
//                min = prices[i];
//            } else {
//                temp = prices[i] - min;
//                max = temp > max ? temp : max;
//            }
//        }
//        return max;
//    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfit(new int[]{6, 1, 3, 2, 4, 7}));
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        // dp[i] 表示 到第i天为止能拿到的最大收入。
        int[] dp = new int[len];
        dp[0] = 0;
        dp[1] = prices[1] > prices[0] ? prices[1] - prices[0] : 0;
        int off = 0;
        for (int i = 2; i < len; i++) {
            if (prices[i] > prices[i - 1]) {
                if (off == i - 1) {
                    //要么今天买入，否则今天选之前的
                    dp[i] = Math.max(dp[off - 2] + prices[i] - prices[i - 1], dp[i - 1]);
                } else {
                    dp[i] = dp[off] + prices[i] - prices[i - 1];
                    while (i + 1 < len && prices[i] < prices[i + 1]) {
                        ++i;
                        dp[i] = dp[i - 1] + prices[i] - prices[i - 1];
                    }
                }
            } else {
                dp[i] = dp[i - 1];
                off = i;
                while (i + 1 < len && prices[i] > prices[i + 1]) {
                    ++i;
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[len - 1];
    }

}
