package com.alexzfx.leetCode.dp;

/**
 * Author : Alex
 * Date : 2018/10/6 9:35
 * Description : 714. 买卖股票的最佳时机含手续费
 */
public class MaxProfit4 {
    public static void main(String[] args) {
        MaxProfit4 profit4 = new MaxProfit4();
        System.out.println(profit4.maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3));
    }

    public int maxProfit(int[] prices, int fee) {
        if (prices.length < 1) {
            return 0;
        }
        int len = prices.length;
//        int sum = 0, start = 0, profit;
        //可以不使用一个数组，只使用2个值temp即可
        //当前持有股票时的最大收益值
        int[] f = new int[len];
        //当前不持有的最大收益值
        int[] g = new int[len];
        f[0] = -prices[0];
        g[0] = 0;
        for (int i = 1; i < len; i++) {
            f[i] = Math.max(f[i - 1], g[i - 1] - prices[i]);
            g[i] = Math.max(g[i - 1], f[i - 1] + prices[i] - fee);
        }
        return Math.max(f[len - 1], g[len - 1]);
    }
}
