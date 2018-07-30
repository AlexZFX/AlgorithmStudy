package com.alexzfx.leetCode.dp;

/**
 * Author : Alex
 * Date : 2018/1/24 21:03
 * Description : 746. 使用最小花费爬楼梯
 * <p>
 * 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 */
public class MinCostClimbingStairs {
    //这种只输出最后两个中最大的dp，可以不用构建数组，3个temp变量动态更新即可，性能更优
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i], dp[i - 1] + cost[i]);
        }
        return Math.min(dp[len - 1], dp[len - 2]);
    }
}
