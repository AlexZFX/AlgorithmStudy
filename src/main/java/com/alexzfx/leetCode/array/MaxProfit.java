package com.alexzfx.leetCode.array;

/**
 * Author : Alex
 * Date : 2018/9/13 11:42
 * Description : 122. 买卖股票的最佳时机 II
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfit(nums));
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int res = 0, start;
        for (int i = 1; i < len; i++) {
            start = i - 1;
            while (i < len && prices[i] > prices[i - 1]) {
                ++i;
            }
            res += prices[i - 1] - prices[start];
        }
        return res;
    }

    //存数组解法
//    public int maxProfit(int[] prices) {
//        if (prices.length == 0)
//            return 0;
//        int[] value = new int[prices.length - 1];
//        for (int i = 1; i < prices.length; i++) {
//            value[i - 1] = prices[i] - prices[i - 1];
//        }
//        int sum = 0;
//        for (int a : value)
//            if (a > 0)
//                sum += a;
//        return sum;
//    }
}
