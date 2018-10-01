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

 */
public class MaxProfit {
    //不含冷冻期
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0 || len == 1) {
            return 0;
        }
        int min = prices[0];
        int max = 0;
        int temp = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                temp = prices[i] - min;
                max = temp > max ? temp : max;
            }
        }
        return max;
    }

}
