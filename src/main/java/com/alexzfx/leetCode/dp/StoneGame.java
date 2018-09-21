package com.alexzfx.leetCode.dp;

/**
 * Author : Alex
 * Date : 2018/9/21 10:47
 * Description : 877. 石子游戏
 * <p>
 * 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
 * <p>
 * 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
 * <p>
 * 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
 * <p>
 * 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
 */
//偶数堆石子时，必然能够保证自己获胜，但奇数堆时不可以。
public class StoneGame {


//    public boolean stoneGame(int[] plies){
//        return true;
//    }

    //将Alex拿的算作+分，li拿的算作-分，dp[i][j] 表示在i~j中所能获得的最大分数
    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = len - 1; i >= 0; --i) {
            for (int j = i + 1; j < len; j++) {
                //选择 拿任一个，则对方都会拿另一种情况下的最优解。
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][len - 1] > 0;
    }
}
