package com.alexzfx.leetCode.dp;

/**
 * Author : Alex
 * Date : 2018/7/30 13:31
 * Description : 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 步你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class ClimbStairs {

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println(climbStairs.climbStairs(10));
    }

    //这种只输出最后两个中最大的dp，可以不用构建数组，几个temp变量动态更新即可，性能更优
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
