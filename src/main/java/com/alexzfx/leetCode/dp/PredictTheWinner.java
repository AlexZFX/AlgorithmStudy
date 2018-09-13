package com.alexzfx.leetCode.dp;

/**
 * Author : Alex
 * Date : 2018/9/12 16:20
 * Description : 486. 预测赢家
 * <p>
 * 给定一个表示分数的非负整数数组。
 * 玩家1从数组任意一端拿取一个分数，随后玩家2继续从剩余数组任意一端拿取分数，然后玩家1拿，……。
 * 每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。
 * 最终获得分数总和最多的玩家获胜。
 * <p>
 * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
 * <p>
 * <p>
 * <p>
 * dp[i][j] 表示从 i~j 这些数字中，玩家能获得的最大分数（自己拿到的分数-对手拿到的分数），大于0则胜利
 * dp[i][j] = Max(num[i]-dp[i+1][j],num[j]-dp[i][j-1])
 */
public class PredictTheWinner {
    public boolean predictTheWinner(int[] nums) {
        int len = nums.length;
        if (nums.length == 1 || nums.length == 2) {
            return true;
        }
        int[][] dp = new int[len][len]; //dp[i][j] 表示从 i~j 这些数字中，玩家能获得的最大分数
        for (int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
        }
        // i从大到小，以保证后一个已被初始化
        for (int i = len - 2; i >= 0; --i) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][len - 1] >= 0;
    }
}
