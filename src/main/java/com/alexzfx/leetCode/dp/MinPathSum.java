package com.alexzfx.leetCode.dp;

/**
 * Author : Alex
 * Date : 2018/9/11 13:12
 * Description : 64. 最小路径和
 * <p>
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] p = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    p[i][j] = grid[i][j];
                } else if (i == 0) {
                    p[i][j] = p[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    p[i][j] = p[i - 1][j] + grid[i][j];
                } else {
                    p[i][j] = Math.min(p[i - 1][j], p[i][j - 1]) + grid[i][j];
                }
            }
        }
        return p[m - 1][n - 1];
    }
}
