package com.alexzfx.leetCode.dp;

/**
 * Author : Alex
 * Date : 2018/10/1 11:25
 * Description : 309. 最佳买卖股票时机含冷冻期
 */
public class MaxProfit3 {
    public static void main(String[] args) {
        MaxProfit3 maxProfit3 = new MaxProfit3();
        System.out.println(maxProfit3.maxProfit(new int[]{6, 1, 3, 2, 4, 7}));
    }

    /**
     * 定义多种状态
     * f[i] 表示 第i天 不持有股票且没有发生卖出交易的最大收益
     * g[i] 表示 第i天 不持有股票，且刚刚卖出股票的最大收益
     * h[i] 表示 第i天 当前持有股票的最大收益
     * 状态转移为
     * f[i] = max(f[i - 1], g[i - 1])，表示构成第i天不持有股票且当天无交易有两种方式，一种是前一天也不持有且前一天没有卖出交易，另一种是前一天持有且前一天刚刚卖出股票；二者取最大值。
     * g[i] = h[i - 1] + prices[i]，表示构成第i天不持有股票且当天有交易仅有一种方式，即当天卖出前一天持有的股票。
     * h[i] = max(h[i - 1], f[i - 1] - prices[i])，表示构成第i天持有股票有两种方式，一种是前一天持有，另一种是前一天不持有且前一天无交易，但这一天刚刚买入。
     * 最终答案为max(f[n - 1], g[n - 1])，即最后一天不持有股票的两种情况
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int[] f = new int[len];
        int[] g = new int[len];
        int[] h = new int[len];
        f[0] = 0;
        g[0] = 0;
        h[0] = -prices[0];
        for (int i = 1; i < len; i++) {
            f[i] = Math.max(f[i - 1], g[i - 1]);
            g[i] = h[i - 1] + prices[i];
            h[i] = Math.max(h[i - 1], f[i - 1] - prices[i]);
        }
        return Math.max(f[len - 1], g[len - 1]);
    }

//    public int maxProfit(int[] prices) {
//        int len = prices.length;
//        if (len < 2) {
//            return 0;
//        }
//        // dp[i][j] 表示 到第i天买入第j天卖出的收益为止能拿到的最大收入。
//        int[][] dp = new int[len][len];
//        int[] profit = new int[len];
//        for (int i = 0; i < len; i++) {
//            for (int j = i + 1; j < len; j++) {
//                dp[i][j] = Math.max(prices[j] - prices[i], 0);
//            }
//        }
//        profit[1] = dp[0][1];
//        for (int i = 2; i < len; i++) {
//            //昨天刚卖出或者昨天冷冻期
//            profit[i] = Math.max(profit[i - 1], profit[i - 2]);
//            for (int j = 0; j < i; j++) {
//                profit[i] = Math.max(profit[i], dp[j][i]);
//                if (j >= 2) {
//                    profit[i] = Math.max(profit[i], dp[j][i] + profit[j - 2]);
//                }
//            }
//        }
//        return profit[len - 1];
//    }
}
